package net.fortresswars.core.kits;

import org.bukkit.ChatColor;

public enum KitRole {
    DAMAGE("Damage", "\uD83D\uDDE1", ChatColor.RED),
    SUPPORT("Support", "❤", ChatColor.LIGHT_PURPLE),
    TANK("Tank", "\uD83D\uDEE1", ChatColor.GRAY),
    UTILITY("Utility", "\uD83D\uDD27", ChatColor.WHITE);

    private final String name;
    private final String icon;
    private final ChatColor color;

    KitRole(String name,  String icon, ChatColor color) {
        this.name = name;
        this.icon = icon;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public ChatColor getColor() {
        return color;
    }

    /**
     * Parse the kit role string
     * @param string the string that might be a kit role
     * @return the KitRole or null if not a kit role
     */
    public static KitRole parseKitRole(String string) {
        try {
            return KitRole.valueOf(string);
        } catch (NullPointerException | IllegalArgumentException ignored) {
            return null;
        }
    }
}
