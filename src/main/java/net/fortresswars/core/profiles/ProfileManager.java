package net.fortresswars.core.profiles;

import net.fortresswars.api.PlayerProfileServiceAPI;
import net.fortresswars.core.managers.EventManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ProfileManager<Profile> extends EventManager {

    protected final PlayerProfileServiceAPI playerProfileServiceAPI;
    protected final Map<UUID, Profile> profileStore = new ConcurrentHashMap<>();

    public ProfileManager(JavaPlugin plugin) {
        super(plugin);
        playerProfileServiceAPI = new PlayerProfileServiceAPI(plugin);
    }

    @Override
    public void disable() {
        if (!isEnabled()) return;
        super.disable();
    }

    public Profile getProfile(UUID uuid) {
        return profileStore.get(uuid);
    }

    public abstract CompletableFuture<Void> loadProfile(UUID uuid);

    public abstract CompletableFuture<Void> saveProfile(UUID uuid);

    public abstract CompletableFuture<Void> deleteProfile(UUID uuid);

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
