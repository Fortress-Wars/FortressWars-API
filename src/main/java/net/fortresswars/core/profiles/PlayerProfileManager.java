package net.fortresswars.core.profiles;

import net.fortresswars.events.profiles.PlayerProfileDeletedEvent;
import net.fortresswars.events.profiles.PlayerProfileLoadedEvent;
import net.fortresswars.events.profiles.PlayerProfileSavedEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class PlayerProfileManager extends ProfileManager<PlayerProfile> {

    public PlayerProfileManager(JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    public CompletableFuture<Void> loadProfile(UUID uuid) {
        return supplyAsync(() -> {
            final PlayerProfile profile = playerProfileServiceAPI.getPlayerProfile(uuid);
            profileStore.put(uuid, profile);
            return profile;
        }).thenAccept((profile) -> {
            Bukkit.getScheduler().runTask(plugin, () -> {
                final PlayerProfileLoadedEvent profileLoadedEvent = new PlayerProfileLoadedEvent(profile);
                Bukkit.getPluginManager().callEvent(profileLoadedEvent);
            });
        });
    }

    @Override
    protected CompletableFuture<Void> saveProfile(UUID uuid) {
        return runAsync(() -> {
            final PlayerProfile profile = profileStore.get(uuid);
            playerProfileServiceAPI.saveProfile(profile);
            Bukkit.getScheduler().runTask(plugin, () -> {
                final PlayerProfileSavedEvent profileSavedEvent = new PlayerProfileSavedEvent(profile);
                Bukkit.getPluginManager().callEvent(profileSavedEvent);
            });
        });
    }

    @Override
    protected CompletableFuture<Void> deleteProfile(UUID uuid) {
        return runAsync(() -> {
            final PlayerProfile profile = profileStore.remove(uuid);
            final PlayerProfileDeletedEvent profileDeletedEvent = new PlayerProfileDeletedEvent(profile);
            Bukkit.getPluginManager().callEvent(profileDeletedEvent);
        });
    }

    @EventHandler
    protected void onProfileLoadedEvent(PlayerProfileLoadedEvent event) {
        final PlayerProfile profile = event.getProfile();
        final UUID uuid = profile.getUuid();
        final Player player = Bukkit.getPlayer(uuid);
        if (player == null) return;
        final String username = player.getName();
        profile.setUsername(username);
    }
}
