package net.fortresswars.api;

import net.fortresswars.Logger;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class BaseAPI {

    protected final Logger logger;
    protected final FileConfiguration config;

    public BaseAPI(JavaPlugin javaPlugin) {
        this.logger = new Logger(javaPlugin);
        this.config = javaPlugin.getConfig();
    }
}
