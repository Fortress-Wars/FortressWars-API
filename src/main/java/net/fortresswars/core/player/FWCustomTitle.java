package net.fortresswars.core.player;

import org.bukkit.ChatColor;

public class FWCustomTitle {
    private final String nickName;

    public FWCustomTitle(String title) {
        this.nickName = title != null ? ChatColor.translateAlternateColorCodes('&', title) : "";
    }

    @Override
    public String toString() {
        return nickName;
    }
}
