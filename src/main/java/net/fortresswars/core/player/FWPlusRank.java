package net.fortresswars.core.player;

import org.bukkit.ChatColor;

@SuppressWarnings("unused")
public enum FWPlusRank {
    PLAYER("Fortress Wars +", "FW+", false),
    STAFF("Staff", "STAFF", true);

    private final String name;
    private final String shortName;
    private final boolean isHidden;

    public static ChatColor getColor(int totalDays) {
        if (totalDays >= 360) return ChatColor.LIGHT_PURPLE;
        if (totalDays >= 180) return ChatColor.DARK_PURPLE;
        if (totalDays >= 90) return ChatColor.GOLD;
        return ChatColor.YELLOW;
    }

    FWPlusRank(String name, String shortName, boolean isHidden) {
        this.name = name;
        this.shortName = shortName;
        this.isHidden = isHidden;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public boolean isHidden() {
        return isHidden;
    }
}
