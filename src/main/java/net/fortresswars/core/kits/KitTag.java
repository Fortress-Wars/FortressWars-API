package net.fortresswars.core.kits;

import org.bukkit.ChatColor;

public enum KitTag {

    FREE("Free", ChatColor.GRAY),
    PREMIUM("Premium", ChatColor.DARK_AQUA),
    SPECIAL("Special", ChatColor.AQUA),
    EXCLUSIVE("Exclusive", ChatColor.LIGHT_PURPLE);

    private final String displayText;
    private final ChatColor color;

    public static int getPremiumCost() {
        return 500;
    }

    KitTag(String displayText, ChatColor color) {
        this.displayText = displayText;
        this.color = color;
    }

    public String getDisplayText() {
        return displayText;
    }

    public ChatColor getColor() {
        return color;
    }
}
