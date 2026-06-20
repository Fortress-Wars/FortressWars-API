package net.fortresswars.api;

import net.fortresswars.core.*;
import net.fortresswars.core.profiles.PlayerProfile;
import net.fortresswars.core.profiles.ProfileGetRequest;
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

    private void validateResponseCode(HttpResponse<String> response) {
        if (response.statusCode() < 400) return;
        throw new RuntimeException("HTTP Error: Status code " + response.statusCode() + " with body: " + response.body());
    }

    public PlayerProfile getPlayerProfile(UUID playerId) {
        try {
            final HttpClient client = getHttpClient();
            final String playerProfileServiceUrl = this.config.getString("api.playerProfileServiceUrl");
            final String apiKey = this.config.getString("api.apiKey");
            final String url = playerProfileServiceUrl + "/profiles/" + playerId;
            final HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .header("Content-Type", "application/json")
                    .header("x-api-key", apiKey)
                    .build();
            final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            final ProfileGetRequest profileGetRequest = gson.fromJson(response.body(), ProfileGetRequest.class);
            return new PlayerProfile(profileGetRequest);
        } catch (Exception e) {
            final var message = "Failed to get player profile " + playerId + ": " + e.getMessage();
            this.logger.warn(message);
            throw new RuntimeException(message, e);
        }
    }

    public boolean saveProfile(PlayerProfile profile) {
        final UUID playerId = profile.getUuid();
        try {
            final HttpClient client = getHttpClient();
            final String playerProfileServiceUrl = this.config.getString("api.playerProfileServiceUrl");
            final String apiKey = this.config.getString("api.apiKey");
            final String url = playerProfileServiceUrl + "/profiles/" + playerId;
            final String body = gson.toJson(profile.toUpdateRequest());
            final HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .PUT(HttpRequest.BodyPublishers.ofString(body))
                    .header("Content-Type", "application/json")
                    .header("x-api-key", apiKey)
                    .build();
            final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            this.validateResponseCode(response);
            return response.statusCode() == 201;
        } catch (Exception e) {
            final var message = "Failed to save player profile " + playerId + ": " + e.getMessage();
            this.logger.error(message);
            throw new RuntimeException(message, e);
        }
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
            this.validateResponseCode(response);
            return gson.fromJson(response.body(), Leaderboard.class);
        } catch (Exception e) {
           this.logger.warn("Failed to get leaderboard " + key + ": " + e.getMessage());
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
            this.validateResponseCode(response);
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
            this.validateResponseCode(response);
            return response.statusCode() == 201;
        } catch (Exception e) {
            this.logger.error("Failed to add parkour time for " + playerId + ": " + e.getMessage());
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
            this.validateResponseCode(response);
            return response.statusCode() == 204;
        } catch (Exception e) {
            this.logger.error("Failed to delete parkour profile for " + playerId + ": " + e.getMessage());
        }
        return false;
    }

    public ParkourServerRecord getParkourCourseRecord(String courseID) {
        try {
            final HttpClient client = getHttpClient();
            final String playerProfileServiceUrl = this.config.getString("api.playerProfileServiceUrl");
            final String apiKey = this.config.getString("api.apiKey");
            final String encodedCourseID = URLEncoder.encode(courseID, StandardCharsets.UTF_8);
            final String url = playerProfileServiceUrl + "/parkour/courses/" + encodedCourseID + "/record";
            final HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .header("Content-Type", "application/json")
                    .header("x-api-key", apiKey)
                    .build();
            final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 404) {
                return null;
            }
            this.validateResponseCode(response);
            return gson.fromJson(response.body(), ParkourServerRecord.class);
        } catch (Exception e) {
            final var message = "Failed to get parkour course record for " + courseID + ": " + e.getMessage();
            this.logger.warn(message);
            throw new RuntimeException(message);
        }
    }

    public CosmeticsProfileRequest getCosmeticsProfile(UUID playerId) {
        try {
            final HttpClient client = getHttpClient();
            final String playerProfileServiceUrl = this.config.getString("api.playerProfileServiceUrl");
            final String apiKey = this.config.getString("api.apiKey");
            final String url = playerProfileServiceUrl + "/cosmetics/" + playerId;
            final HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .header("Content-Type", "application/json")
                    .header("x-api-key", apiKey)
                    .build();

            final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            this.validateResponseCode(response);
            return gson.fromJson(response.body(), CosmeticsProfileRequest.class);
        } catch (Exception e) {
            final var message = "Failed to get cosmetic profile for " + playerId + ": " + e.getMessage();
            this.logger.warn(message);
            throw new RuntimeException(message, e);
        }
    }

    public boolean saveCosmeticsProfile(CosmeticsProfileRequest cosmeticsProfileRequest) {
        final var playerId = cosmeticsProfileRequest.uuid();
        try {
            final HttpClient client = getHttpClient();
            final String playerProfileServiceUrl = this.config.getString("api.playerProfileServiceUrl");
            final String apiKey = this.config.getString("api.apiKey");
            final String url = playerProfileServiceUrl + "/cosmetics/" + playerId;
            final String body = gson.toJson(cosmeticsProfileRequest);
            final HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .PUT(HttpRequest.BodyPublishers.ofString(body))
                    .header("Content-Type", "application/json")
                    .header("x-api-key", apiKey)
                    .build();
            final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            this.validateResponseCode(response);
            return response.statusCode() == 201;
        } catch (Exception e) {
            final var message = "Failed to save cosmetic profile for " + playerId + ": " + e.getMessage();
            this.logger.error(message);
            throw new RuntimeException(message, e);
        }
    }

    public boolean deleteEquippedCosmetic(UUID playerId, String cosmeticType) {
        try {
            final HttpClient client = getHttpClient();
            final String playerProfileServiceUrl = this.config.getString("api.playerProfileServiceUrl");
            final String apiKey = this.config.getString("api.apiKey");
            final String url = playerProfileServiceUrl + "/cosmetics/" + playerId + "?cosmeticType=" + cosmeticType;
            final HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .DELETE()
                    .header("Content-Type", "application/json")
                    .header("x-api-key", apiKey)
                    .build();
            final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            this.validateResponseCode(response);
            return response.statusCode() == 204;
        } catch (Exception e) {
            final var message = "Failed to delete equipped cosmetic for " + playerId + ": " + e.getMessage();
            this.logger.error(message);
            throw new RuntimeException(message, e);
        }
    }

    public boolean deleteAllEquippedCosmetics(UUID playerId) {
        try {
            final HttpClient client = getHttpClient();
            final String playerProfileServiceUrl = this.config.getString("api.playerProfileServiceUrl");
            final String apiKey = this.config.getString("api.apiKey");
            final String url = playerProfileServiceUrl + "/cosmetics/" + playerId;
            final HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .DELETE()
                    .header("Content-Type", "application/json")
                    .header("x-api-key", apiKey)
                    .build();
            final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.statusCode() == 204;
        } catch (Exception e) {
            final var message = "Failed to delete cosmetic profile for " + playerId + ": " + e.getMessage();
            this.logger.error(message);
            throw new RuntimeException(message, e);
        }
    }
}
