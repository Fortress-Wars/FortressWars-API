package net.fortresswars.helpers;

import net.fortresswars.core.player.TeamColor;
import net.fortresswars.core.teams.TeamException;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TeamHelper {

    public enum MatchType {
        EXACT,
        INCLUDES
    }

    public static Scoreboard getScoreboard() {
        final var scoreboardManager = Bukkit.getScoreboardManager();
        return scoreboardManager.getMainScoreboard();
    }

    public boolean isOnSameTeam(Entity entity1, Entity entity2) {
        final var scoreboard = getScoreboard();
        final var team1 = scoreboard.getEntityTeam(entity1);
        if (team1 == null) return false;
        final var team2 = scoreboard.getEntityTeam(entity2);
        if (team2 == null) return false;
        return team1.equals(team2);
    }

    public static boolean isOnTeam(Entity entity, String teamName, MatchType matchType) {
        if (teamName == null) return false;
        final var scoreboard = getScoreboard();
        final var team = scoreboard.getEntityTeam(entity);
        if (team == null) return false;
        return switch (matchType) {
            case INCLUDES -> team.getName().contains(teamName.toLowerCase());
            case EXACT -> teamName.equals(team.getName());
        };
    }

    public Team createTeam(TeamColor teamColor) {
        if (teamColor == null) return null;

        final var scoreboard = getScoreboard();
        final Team team = scoreboard.registerNewTeam(teamColor.getId());
        team.setAllowFriendlyFire(true);
        team.setCanSeeFriendlyInvisibles(false);
        team.setOption(Team.Option.COLLISION_RULE, Team.OptionStatus.NEVER);
        team.color(teamColor.getChatColor());
        return team;
    }

    public static Team deleteTeam(TeamColor teamColor) {
        final Team team = getTeam(teamColor);
        if (team == null) return null;
        team.unregister();
        return team;
    }

    public static Team getTeam(Entity entity) {
        final var scoreboard = getScoreboard();
        return scoreboard.getEntityTeam(entity);
    }

    public static Team getTeam(TeamColor teamColor) {
        if (teamColor == null) return null;
        final var scoreboard = getScoreboard();
        return scoreboard.getTeam(teamColor.getId());
    }

    public static void joinTeam(Entity entity, TeamColor teamColor) {
        final Team team = getTeam(teamColor);
        if (team == null) {
            throw new TeamException("Team does not exist");
        }
        team.addEntity(entity);
    }

    public static void leaveTeam(Entity entity) {
        final Team team = getTeam(entity);
        if (team == null) return;
        team.removeEntity(entity);
    }
}
