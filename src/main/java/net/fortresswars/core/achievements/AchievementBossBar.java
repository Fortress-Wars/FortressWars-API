package net.fortresswars.core.achievements;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.UUID;

public class AchievementBossBar implements Listener {

    private static final long ACHIEVEMENT_PROGRESS_DURATION = 100;

    private final JavaPlugin plugin;
    private final UUID playerUUID;
    private AchievementProgress achievementProgress;
    private BukkitTask displayTask;
    private final BossBar displayBar;

    public AchievementBossBar(JavaPlugin plugin, UUID playerUUID, String id, AchievementProgress achievementProgress) {
        this.plugin = plugin;
        this.playerUUID = playerUUID;
        this.achievementProgress = achievementProgress;
        displayBar = Bukkit.getServer().createBossBar(new NamespacedKey(plugin, id), getBarTitle(), BarColor.GREEN, BarStyle.SOLID);
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    private String getBarTitle() {
        FWAchievement achievement = achievementProgress.achievement();
        String achievementName = achievement.getName();
        String formattedProgress = achievementProgress.getFormattedProgress();
        String formattedTarget = achievementProgress.getFormattedTarget();
        String formattedPercentage = achievementProgress.getFormattedPercentage();

        return "§3§l" + achievementName + " §7§l- §3" + formattedProgress + "§7§l/§3" + formattedTarget + " §7§l(§3" + formattedPercentage + "§7§l)";
    }

    private void stopDeleteTask() {
        if (displayTask != null) {
            displayTask.cancel();
            displayTask = null;
        }
    }

    public void display() {
        displayBar.setProgress(achievementProgress.getPercentage() * 0.01); // needs to be between 0.0 and 1.0

        displayBar.setTitle(getBarTitle());

        Player player = Bukkit.getPlayer(playerUUID);
        if (player == null) return;
        displayBar.addPlayer(player);

        stopDeleteTask();
        displayTask = Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, this::delete, ACHIEVEMENT_PROGRESS_DURATION);
    }

    public void update(AchievementProgress achievementProgress) {
        this.achievementProgress = achievementProgress;
    }

    public void delete() {
        displayBar.removeAll();
        HandlerList.unregisterAll(this);
        stopDeleteTask();
    }

    @EventHandler
    public void onLeaveGameEvent(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if (p.getUniqueId() != playerUUID) return;
        delete();
    }
}
