package net.fortresswars.core.subscriptions;

import org.bukkit.ChatColor;

public enum SubscriptionType {
    FW_PLUS("FW+", ChatColor.YELLOW);

    private final String name;
    private final ChatColor color;

    SubscriptionType(String name, ChatColor color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public ChatColor getColor() {
        return color;
    }
}