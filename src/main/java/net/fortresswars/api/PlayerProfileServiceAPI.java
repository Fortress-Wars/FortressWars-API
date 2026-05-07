package net.fortresswars.api;

import net.fortresswars.core.Leaderboard;
import net.fortresswars.core.AddParkourTimeRequest;
import net.fortresswars.core.DeleteParkourProfileRequest;
import net.fortresswars.core.ParkourProfile;
import org.bukkit.plugin.java.JavaPlugin;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
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

    public boolean addParkourTime(UUID playerId, AddParkourTimeRequest parkourTimeRequest) {
        try {
            final HttpClient client = getHttpClient();
            final String playerProfileServiceUrl = this.config.getString("api.playerProfileServiceUrl");
            final String apiKey = this.config.getString("api.apiKey");
            final String url = playerProfileServiceUrl + "/parkour/players/" + playerId;
            final String body = gson.toJson(parkourTimeRequest);
            final HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .header("Content-Type", "application/json")
                    .header("x-api-key", apiKey)
                    .build();
            final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.statusCode() == 201;
        } catch (Exception e) {
            this.logger.warn("Failed to add parkour time for " + playerId + ": " + e.getMessage());
        }
        return false;
    }

    public boolean deleteParkourProfile(UUID playerId, DeleteParkourProfileRequest deleteRequest) {
        try {
            final HttpClient client = getHttpClient();
            final String playerProfileServiceUrl = this.config.getString("api.playerProfileServiceUrl");
            final String apiKey = this.config.getString("api.apiKey");

            String url = playerProfileServiceUrl + "/parkour/players/" + playerId;
            if (deleteRequest != null && deleteRequest.courseID() != null && !deleteRequest.courseID().isBlank()) {
                final String encodedCourseID = URLEncoder.encode(deleteRequest.courseID(), StandardCharsets.UTF_8);
                url += "?courseID=" + encodedCourseID;
            }

            final HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .DELETE()
                    .header("Content-Type", "application/json")
                    .header("x-api-key", apiKey)
                    .build();
            final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.statusCode() == 204;
        } catch (Exception e) {
            this.logger.warn("Failed to delete parkour profile for " + playerId + ": " + e.getMessage());
        }
        return false;
    }
}
