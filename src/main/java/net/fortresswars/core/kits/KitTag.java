package net.fortresswars.core.kits;

import net.kyori.adventure.text.format.NamedTextColor;

public enum KitTag {

    FREE("Free", NamedTextColor.GRAY),
    PREMIUM("Premium", NamedTextColor.DARK_AQUA),
    SPECIAL("Special", NamedTextColor.AQUA),
    EXCLUSIVE("Exclusive", NamedTextColor.LIGHT_PURPLE);

    private final String displayText;
    private final NamedTextColor color;

    public static int getPremiumCost() {
        return 500;
    }

    KitTag(String displayText, NamedTextColor color) {
        this.displayText = displayText;
        this.color = color;
    }

    public String getDisplayText() {
        return displayText;
    }

    public NamedTextColor getColor() {
        return color;
    }
}
