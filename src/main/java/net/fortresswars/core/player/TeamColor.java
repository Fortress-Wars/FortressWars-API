/*
 * Name: TeamColor
 * Author: Peter Cesmegi
 * Description: Different team colors for fortress wars 3
 */

package net.fortresswars.core.player;

import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Color;
import org.bukkit.boss.BarColor;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public enum TeamColor {
    RED(
            "Red",
            Color.fromRGB(153, 0, 0),
            NamedTextColor.RED,
            BarColor.RED,
            true
    ),
    BLUE(
            "Blue",
            Color.fromRGB(0, 0, 153),
            NamedTextColor.BLUE,
            BarColor.BLUE,
            true
    ),
    RANDOM(
            "Random",
            Color.PURPLE,
            NamedTextColor.DARK_PURPLE,
            BarColor.PURPLE,
            false
    ),
    NONE(
            "None",
            Color.WHITE,
            NamedTextColor.WHITE,
            BarColor.WHITE,
            false
    );

    private static Map<String, TeamColor> teamIdMap;
    private final String id;
    private final String friendlyName;
    private final Color color;
    private final NamedTextColor chatColor;
    private final BarColor barColor;
    private final int colorInt;
    private final boolean hasTeamChat;

    TeamColor(String friendlyName, Color color, NamedTextColor chatColor, BarColor barColor, boolean hasTeamChat) {
        this.id = ordinal() + "_" + this.name();
        this.friendlyName = friendlyName;
        this.color = color;
        this.chatColor = chatColor;
        this.colorInt = color.asARGB();
        this.barColor = barColor;
        this.hasTeamChat = hasTeamChat;
    }

    public static TeamColor fromId(@NotNull String name) {
        if (teamIdMap == null) {
            teamIdMap = new HashMap<>();
            for (TeamColor teamColor : TeamColor.values()) {
                teamIdMap.put(teamColor.id, teamColor);
            }
        }
        return teamIdMap.get(name);
    }

    public String getId() {
        return id;
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

    public NamedTextColor getChatColor() {
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
