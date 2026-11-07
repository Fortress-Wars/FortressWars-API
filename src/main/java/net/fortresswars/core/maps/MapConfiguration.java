package net.fortresswars.core.maps;

import net.fortresswars.core.games.FWGameMode;
import net.fortresswars.core.respawn.RespawnTimes;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class MapConfiguration {

    private final FileConfiguration config;

    public MapConfiguration(FileConfiguration config, RespawnTimes defaultRespawnTimes) {
        this.config = config;
        if (!this.config.isSet("respawnTimes.low")) this.config.set("respawnTimes.low", defaultRespawnTimes.low());
        if (!this.config.isSet("respawnTimes.medium")) this.config.set("respawnTimes.medium", defaultRespawnTimes.medium());
        if (!this.config.isSet("respawnTimes.high")) this.config.set("respawnTimes.high", defaultRespawnTimes.high());
    }

    public boolean contains(String path) {
        return config.contains(path);
    }

    public boolean isSet(String path) {
        return config.isSet(path);
    }

    public List<String> getStringList(String path) {
        return config.getStringList(path);
    }

    public String getString(String path) {
        return config.getString(path);
    }

    public int getInt(String path) {
        return config.getInt(path);
    }

    // Override set methods to prevent modifications
    public void set(String path, Object value) {
        throw new UnsupportedOperationException("This configuration is read-only.");
    }

    public MapDisplayData getMapData() {
        final var id = this.config.getString("id");
        final var contributors = this.config.getString("contributors");
        final var friendlyName = this.config.getString("friendlyName");
        final var icon = this.config.getString("icon");
        final var iconMat = Material.valueOf(icon);
        final var gamemode = FWGameMode.valueOf(this.config.getString("gamemode").toUpperCase());
        final var mapType = MapType.valueOf(this.config.getString("mapType").toUpperCase());
        return new MapDisplayData(id, friendlyName, contributors, iconMat, gamemode, mapType);
    }
}
