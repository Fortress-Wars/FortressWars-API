package net.fortresswars.core.player;

import org.bukkit.ChatColor;

@SuppressWarnings("unused")
public enum FWRank {
    PM("Project Manager", "PM", ChatColor.DARK_GREEN, true),
    DEV("Developer", "DEV", ChatColor.GREEN, true),
    SRADMIN("Sr. Administrator", "Sr.A", ChatColor.DARK_RED, true),
    ADMIN("Administrator", "A", ChatColor.DARK_RED, true),
    HOST("Host", "H", ChatColor.DARK_AQUA, false),
    MOD("Moderator", "M", ChatColor.AQUA, false),
    RETIRED("Retired", "R", ChatColor.GRAY, false),
    VETERAN("Veteran", "OG", ChatColor.GOLD, false);

    private final String name;
    private final String shortName;
    private final ChatColor color;
    private final boolean hasFWPlus;

    FWRank(String name, String shortName, ChatColor color, boolean hasFWPlus) {
        this.name = name;
        this.shortName = shortName;
        this.color = color;
        this.hasFWPlus = hasFWPlus;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public ChatColor getColor() {
        return color;
    }

    public boolean hasFWPlus() {
        return hasFWPlus;
    }
}
