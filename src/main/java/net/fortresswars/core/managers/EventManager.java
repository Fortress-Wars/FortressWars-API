package net.fortresswars.core.managers;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class EventManager implements Enableable, Listener {

    private final JavaPlugin plugin;
    private boolean isEnabled;

    protected EventManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void enable() {
        if (isEnabled()) return;
        Bukkit.getPluginManager().registerEvents(this, plugin);
        plugin.getLogger().info("Enabled " + this);
        this.isEnabled = true;
    }

    @Override
    public void disable() {
        if (!isEnabled()) return;
        HandlerList.unregisterAll(this);
        plugin.getLogger().info("Disabled " + this);
        this.isEnabled = false;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
