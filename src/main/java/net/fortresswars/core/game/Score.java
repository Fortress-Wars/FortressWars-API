package net.fortresswars.core.game;

import com.google.gson.JsonObject;
import net.fortresswars.core.player.TeamColor;

import java.util.HashMap;
import java.util.Map;

public class Score {

    private final Map<TeamColor, Double> scores;

    public static Score createGameScore(double blueTeamScore, double redTeamScore) {
        final Score score = new Score();
        score.putScore(TeamColor.BLUE, blueTeamScore);
        score.putScore(TeamColor.RED, redTeamScore);
        return score;
    }

    public Score() {
        scores = new HashMap<>();
    }

    public void putScore(TeamColor teamColor, double score) {
        scores.put(teamColor, score);
    }

    public double getScore(TeamColor teamColor) {
        return scores.getOrDefault(teamColor, 0d);
    }

    public int getScoreInt(TeamColor teamColor) {
        return (int) getScore(teamColor);
    }

    public JsonObject getScoreAsJSON() {
        final JsonObject jsonObject = new JsonObject();
        for (TeamColor team : scores.keySet()) {
            final String property = team.toString().toLowerCase();
            final double value = scores.get(team);
            jsonObject.addProperty(property, value);
        }
        return jsonObject;
    }
}
