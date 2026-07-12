package net.fortresswars.helpers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;

public class TeamHelper {

    public enum MatchType {
        EXACT,
        INCLUDES
    }

    public static boolean isOnTeam(Entity entity, String teamName, MatchType matchType) {
        if (teamName == null) return false;
        final var scoreboardManager = Bukkit.getScoreboardManager();
        final var mainScoreboard = scoreboardManager.getMainScoreboard();

        final var team = mainScoreboard.getEntityTeam(entity);
        if (team == null) return false;
        return switch (matchType) {
            case INCLUDES -> team.getName().contains(teamName.toLowerCase());
            case EXACT -> teamName.equals(team.getName());
        };
    }
}
