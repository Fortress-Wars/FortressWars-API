package net.fortresswars;

import net.fortresswars.core.profiles.PlayerProfileManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class FortressWarsAPI extends JavaPlugin {

    private static PlayerProfileManager playerProfileManager;

    public final static String NAMESPACE = "fwapi";

    public static PlayerProfileManager getPlayerProfileManager() {
        return playerProfileManager;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        playerProfileManager = new PlayerProfileManager(this);
        playerProfileManager.enable();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        if (playerProfileManager != null) {
            playerProfileManager.disable();
            playerProfileManager = null;
        }
    }
}
