package net.fortresswars.core.kits;

import net.kyori.adventure.text.format.NamedTextColor;

public enum KitRole {
    DAMAGE("Damage", "\uD83D\uDDE1", NamedTextColor.RED),
    SUPPORT("Support", "❤", NamedTextColor.LIGHT_PURPLE),
    TANK("Tank", "\uD83D\uDEE1", NamedTextColor.GRAY),
    UTILITY("Utility", "\uD83D\uDD27", NamedTextColor.WHITE);

    private final String name;
    private final String icon;
    private final NamedTextColor color;

    KitRole(String name,  String icon, NamedTextColor color) {
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

    public NamedTextColor getColor() {
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
