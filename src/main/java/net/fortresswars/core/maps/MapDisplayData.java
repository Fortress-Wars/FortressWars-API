package net.fortresswars.core.maps;

import net.fortresswars.core.game.FWGameMode;
import org.bukkit.Material;

public class MapDisplayData {
    private final String id;
    private final String displayName;
    private final String contributors;
    private final Material icon;
    private final FWGameMode gamemode;
    private final MapType type;

    public MapDisplayData(String id, String displayName, String contributors, Material icon, FWGameMode gamemode, MapType type) {
        this.id = id;
        this.displayName = displayName;
        this.contributors = contributors;
        this.icon = icon;
        this.gamemode = gamemode;
        this.type = type;
    }

    public String getID() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getContributors() {
        return contributors;
    }

    public Material getIcon() {
        return icon;
    }

    public FWGameMode getGamemode() {
        return gamemode;
    }

    public MapType getType() {
        return type;
    }
}
