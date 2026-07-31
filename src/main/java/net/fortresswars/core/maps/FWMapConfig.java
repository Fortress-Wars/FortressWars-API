package net.fortresswars.core.maps;

import net.fortresswars.core.games.FWGameMode;
import net.fortresswars.respawn.RespawnTimes;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Objects;

public abstract class FWMapConfig {

    protected final FileConfiguration fileConfiguration;
    protected final MapDisplayData mapDisplayData;
    protected final RespawnTimes defaultRespawnTimes;

    public FWMapConfig(FileConfiguration fileConfiguration, RespawnTimes defaultRespawnTimes) {
        this.fileConfiguration = fileConfiguration;
        this.defaultRespawnTimes = defaultRespawnTimes;
        this.mapDisplayData = this.createMapDisplayData(fileConfiguration);
    }

    private MapDisplayData createMapDisplayData(FileConfiguration mapConfig) {
        final var id = mapConfig.getString("id");
        final var contributors = mapConfig.getString("contributors");
        final var friendlyName = mapConfig.getString("friendlyName");
        final var icon = mapConfig.getString("icon");
        final var iconMat = Material.valueOf(icon);
        final var gamemode = FWGameMode.valueOf(mapConfig.getString("gamemode").toUpperCase());
        final var mapType = MapType.valueOf(mapConfig.getString("mapType").toUpperCase());
        return new MapDisplayData(id, friendlyName, contributors, iconMat, gamemode, mapType);
    }

    public MapDisplayData getMapDisplayData() {
        return mapDisplayData;
    }

    public FileConfiguration getFileConfiguration() {
        return fileConfiguration;
    }

    protected RespawnTimes getMapRespawnTimes() {
        if (fileConfiguration.contains("respawnTimes")) {
            final int low = fileConfiguration.getInt("respawnTimes.low");
            final int medium = fileConfiguration.getInt("respawnTimes.medium");
            final int high = fileConfiguration.getInt("respawnTimes.high");
            return new RespawnTimes(low, medium, high);
        }
        return defaultRespawnTimes;
    }

    public FWMap createMap() {
        final var newMap = this.createBaseMap();

        if (fileConfiguration.contains("deathPlaneY")) {
            final var deathPlaneY = Integer.parseInt(Objects.requireNonNull(fileConfiguration.getString("deathPlaneY")));
            newMap.setDeathPlane(deathPlaneY);
        }

        if (fileConfiguration.contains("noBuildBox1")) {
            final var x1 = Integer.parseInt(Objects.requireNonNull(fileConfiguration.getString("noBuildBox1.x1")));
            final var y1 = Integer.parseInt(Objects.requireNonNull(fileConfiguration.getString("noBuildBox1.y1")));
            final var z1 = Integer.parseInt(Objects.requireNonNull(fileConfiguration.getString("noBuildBox1.z1")));
            final var x2 = Integer.parseInt(Objects.requireNonNull(fileConfiguration.getString("noBuildBox1.x2")));
            final var y2 = Integer.parseInt(Objects.requireNonNull(fileConfiguration.getString("noBuildBox1.y2")));
            final var z2 = Integer.parseInt(Objects.requireNonNull(fileConfiguration.getString("noBuildBox1.z2")));
            newMap.setNoPlaceBox1(x1, y1, z1, x2, y2, z2);
        }

        if (fileConfiguration.contains("noBuildBox2")) {
            final var x1 = Integer.parseInt(Objects.requireNonNull(fileConfiguration.getString("noBuildBox2.x1")));
            final var y1 = Integer.parseInt(Objects.requireNonNull(fileConfiguration.getString("noBuildBox2.y1")));
            final var z1 = Integer.parseInt(Objects.requireNonNull(fileConfiguration.getString("noBuildBox2.z1")));
            final var x2 = Integer.parseInt(Objects.requireNonNull(fileConfiguration.getString("noBuildBox2.x2")));
            final var y2 = Integer.parseInt(Objects.requireNonNull(fileConfiguration.getString("noBuildBox2.y2")));
            final var z2 = Integer.parseInt(Objects.requireNonNull(fileConfiguration.getString("noBuildBox2.z2")));
            newMap.setNoPlaceBox2(x1, y1, z1, x2, y2, z2);
        }

        if (fileConfiguration.contains("red.buildRadiusCenter")) {
            final var center = fileConfiguration.getString("red.buildRadiusCenter");
            final var coords = center.split(",");
            final var x = Integer.parseInt(coords[0]);
            final var y = Integer.parseInt(coords[1]);
            final var z = Integer.parseInt(coords[2]);
            newMap.setRedBuildRadiusCoords(x, y, z);
        }

        if (fileConfiguration.contains("blue.buildRadiusCenter")) {
            final var center = fileConfiguration.getString("blue.buildRadiusCenter");
            final var coords = center.split(",");
            final var x = Integer.parseInt(coords[0]);
            final var y = Integer.parseInt(coords[1]);
            final var z = Integer.parseInt(coords[2]);
            newMap.setBlueBuildRadiusCoords(x, y, z);
        }

        if (fileConfiguration.contains("gates")) {
            fileConfiguration.getStringList("gates").forEach(gates -> {
                final var coords = gates.split(",");
                final var x = Integer.parseInt(coords[0]);
                final var y = Integer.parseInt(coords[1]);
                final var z = Integer.parseInt(coords[2]);
                newMap.createGate(x, y, z);
            });
        }

        return newMap;
    }

    protected abstract FWMap createBaseMap();
}
