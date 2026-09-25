/*
 * Name: TeamColor
 * Author: Peter Cesmegi
 * Description: Different team colors for fortress wars 3
 */

package net.fortresswars.core.player;

import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.boss.BarColor;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public enum TeamColor {
    RED(
            "Red",
            Color.fromRGB(153, 0, 0),
            NamedTextColor.RED,
            ChatColor.RED,
            BarColor.RED,
            true
    ),
    BLUE(
            "Blue",
            Color.fromRGB(0, 0, 153),
            NamedTextColor.BLUE,
            ChatColor.BLUE,
            BarColor.BLUE,
            true
    ),
    RANDOM(
            "Random",
            Color.PURPLE,
            NamedTextColor.DARK_PURPLE,
            ChatColor.DARK_PURPLE,
            BarColor.PURPLE,
            false
    ),
    NONE(
            "None",
            Color.WHITE,
            NamedTextColor.WHITE,
            ChatColor.WHITE,
            BarColor.WHITE,
            false
    );

    private static List<TeamColor> gameTeams;
    private static Map<String, TeamColor> teamIdMap;
    private final String id;
    private final String friendlyName;
    private final Color color;
    private final NamedTextColor namedTextColor;
    private final ChatColor chatColor;
    private final BarColor barColor;
    private final int colorInt;
    private final boolean isGameTeam;

    TeamColor(
            String friendlyName,
            Color color,
            NamedTextColor namedTextColor,
            ChatColor chatColor,
            BarColor barColor,
            boolean isGameTeam
    ) {
        this.id = ordinal() + "_" + this.name();
        this.friendlyName = friendlyName;
        this.color = color;
        this.namedTextColor = namedTextColor;
        this.chatColor = chatColor;
        this.colorInt = color.asARGB();
        this.barColor = barColor;
        this.isGameTeam = isGameTeam;
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

    public static List<TeamColor> getGameTeams() {
        if (gameTeams == null) {
            gameTeams = Arrays.stream(TeamColor.values()).filter(TeamColor::isGameTeam).toList();
        }
        return gameTeams;
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

    public NamedTextColor getNamedTextColor() {
        return namedTextColor;
    }

    public ChatColor getChatColor() {
        return this.chatColor;
    }

    public @NotNull BarColor getBarColor() {
        return barColor;
    }

    /**
     * If the team is an actual team that is played in a game.
     * @return true if is, false if it is not.
     */
    public boolean isGameTeam() {
        return isGameTeam;
    }

    public static TeamColor getRandomTeam() {
        final var rand = new Random();
        final var gameTeams = getGameTeams();
        final var value = rand.nextInt(0, gameTeams.size());
        return gameTeams.get(value);
    }
}
