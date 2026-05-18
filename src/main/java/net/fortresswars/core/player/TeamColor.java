/*
 * Name: TeamColor
 * Author: Peter Cesmegi
 * Description: Different team colors for fortress wars 3
 */

package net.fortresswars.core.player;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.boss.BarColor;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public enum TeamColor {
    RED("Red", Color.fromRGB(153, 0, 0), ChatColor.RED, BarColor.RED, true),
    BLUE("Blue", Color.fromRGB(0, 0, 153), ChatColor.BLUE, BarColor.BLUE, true),
    RANDOM("Random", Color.PURPLE, ChatColor.DARK_PURPLE, BarColor.PURPLE, false),
    NONE("None", Color.WHITE, ChatColor.WHITE, BarColor.WHITE, false);

    private final String friendlyName;
    private final Color color;
    private final ChatColor chatColor;
    private final BarColor barColor;
    private final int colorInt;
    private final boolean hasTeamChat;

    TeamColor(String friendlyName, Color color, ChatColor chatColor, BarColor barColor, boolean hasTeamChat) {
        this.friendlyName = friendlyName;
        this.color = color;
        this.chatColor = chatColor;
        this.colorInt = color.asARGB();
        this.barColor = barColor;
        this.hasTeamChat = hasTeamChat;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public Color getColor() {
        return color;
    }

    public int getColorInt() {
        return colorInt;
    }

    public ChatColor getChatColor() {
        return chatColor;
    }

    public @NotNull BarColor getBarColor() {
        return barColor;
    }

    public boolean hasTeamChat() {
        return hasTeamChat;
    }

    public static TeamColor getRandomTeam() {
        final var rand = new Random();
        final var value = rand.nextInt(0, 2);
        if (value == 0) {
            return TeamColor.BLUE;
        }
        return TeamColor.RED;
    }
}
