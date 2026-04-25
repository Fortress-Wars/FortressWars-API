package net.fortresswars.api;

import com.google.gson.Gson;
import org.bukkit.plugin.java.JavaPlugin;

import java.net.http.HttpClient;

public class HttpAPI extends BaseAPI {

    protected final Gson gson;
    private HttpClient httpClient;

    public HttpAPI(JavaPlugin javaPlugin) {
        super(javaPlugin);
        this.gson = new Gson();
    }

    protected HttpClient getHttpClient() {
        if (httpClient == null) {
            httpClient = HttpClient.newHttpClient();
        }
        return httpClient;
    }
}
