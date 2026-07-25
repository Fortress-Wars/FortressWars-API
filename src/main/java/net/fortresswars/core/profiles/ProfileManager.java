package net.fortresswars.core.profiles;

import net.fortresswars.api.PlayerProfileServiceAPI;
import net.fortresswars.core.managers.EventManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.function.Supplier;
import java.util.logging.Level;

public abstract class ProfileManager<Profile> extends EventManager {

    private ExecutorService executor;
    protected final PlayerProfileServiceAPI playerProfileServiceAPI;
    protected final Map<UUID, Profile> profileStore = new ConcurrentHashMap<>();

    public ProfileManager(JavaPlugin plugin) {
        super(plugin);
        playerProfileServiceAPI = new PlayerProfileServiceAPI(plugin);
    }

    @Override
    public void enable() {
        if (isEnabled()) return;
        super.enable();
        this.executor = Executors.newFixedThreadPool(4);
        this.loadAll();
    }

    @Override
    public void disable() {
        if (!isEnabled()) return;
        super.disable();
        this.saveAll();

        // Shuts the profile manger down. Waits for the outstanding async tasks to
        // complete for 10 seconds. This function is blocking
        try {
            this.executor.shutdown();
            if (!this.executor.awaitTermination(10, TimeUnit.SECONDS)) {
                throw new RuntimeException("Executor did not terminate within 10 seconds");
            }
        } catch (Exception e) {
            plugin.getLogger().log(Level.SEVERE, "Failed to shutdown executor", e);
        } finally {
            this.executor = null;
        }
    }

    /**
     * Run a runnable asynchronously in this profile manager.
     * @param runnable the runnable to execute
     * @return a new completable future
     */
    protected CompletableFuture<Void> runAsync(Runnable runnable) {
        return CompletableFuture.runAsync(runnable, this.executor);
    }

    /**
     * Supply a completable future to the executor service in this profile manager.
     * @param supplier The supply function to execute async
     * @return a new completable future
     */
    protected <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier) {
        return CompletableFuture.supplyAsync(supplier, this.executor);
    }

    public CompletableFuture<Void> loadAll() {
        final var onlinePlayers = Bukkit.getOnlinePlayers().stream().map(Player::getUniqueId).toList();
        final var futureList = onlinePlayers.stream().map((uuid) -> {
            return this.loadProfile(uuid).exceptionally((throwable) -> null);
        }).toList();
        return CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]));
    }

    public CompletableFuture<Void> saveAll() {
        final var futureList = profileStore.keySet().stream().map((uuid) -> {
            return this.saveProfile(uuid).exceptionally((throwable) -> null);
        }).toList();
        return CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]));
    }

    public boolean isProfileLoaded(UUID uuid) {
        return profileStore.containsKey(uuid);
    }

    public Profile getProfile(UUID uuid) {
        return profileStore.get(uuid);
    }

    protected abstract CompletableFuture<Void> loadProfile(UUID uuid);

    protected abstract CompletableFuture<Void> saveProfile(UUID uuid);

    protected abstract CompletableFuture<Void> deleteProfile(UUID uuid);

    @EventHandler (ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        final UUID uuid = player.getUniqueId();
        final String playerName = player.getName();
        this.loadProfile(uuid);
    }

    @EventHandler (ignoreCancelled = true)
    public void onPlayerQuit(PlayerQuitEvent event) {
        final Player player = event.getPlayer();
        final UUID uuid = player.getUniqueId();
        final String playerName = player.getName();
        saveProfile(uuid).thenCompose((v) -> deleteProfile(uuid));
    }
}
