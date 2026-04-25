package net.fortresswars.api;

import net.fortresswars.core.Leaderboard;
import net.fortresswars.core.ParkourProfile;
import org.bukkit.plugin.java.JavaPlugin;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class PlayerProfileServiceAPI extends HttpAPI {

    public PlayerProfileServiceAPI(JavaPlugin javaPlugin) {
        super(javaPlugin);
    }

    public Leaderboard getLeaderboard(String key) {
        try {
            final HttpClient client = getHttpClient();
            final String playerProfileServiceUrl = this.config.getString("api.playerProfileServiceUrl");
            final String apiKey = this.config.getString("api.apiKey");
            final int minTimePlayedSeconds = this.config.getInt("leaderboards.minTimePlayedSeconds", 0);
            final String url = playerProfileServiceUrl + "/leaderboards/" + key + "?minTimePlayed=" + minTimePlayedSeconds;
            final HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .header("Content-Type", "application/json")
                    .header("x-api-key", apiKey)
                    .build();
            final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), Leaderboard.class);
        } catch (Exception e) {
           this.logger.warn("Failed to get leaderboard " + key + ": ", e);
        }
        // Empty Leaderboard
        return new Leaderboard(key, new Date(), new ArrayList<>());
    }

    public ParkourProfile getParkourProfile(UUID playerId) {
        try {
            final HttpClient client = getHttpClient();
            final String playerProfileServiceUrl = this.config.getString("api.playerProfileServiceUrl");
            final String apiKey = this.config.getString("api.apiKey");
            final String url = playerProfileServiceUrl + "/parkour/players/" + playerId;
            final HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .header("Content-Type", "application/json")
                    .header("x-api-key", apiKey)
                    .build();
            final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), ParkourProfile.class);
        } catch (Exception e) {
            this.logger.warn("Failed to get player parkour profile for " + playerId + ": " + e.getMessage());
        }
        return null;
    }
}
