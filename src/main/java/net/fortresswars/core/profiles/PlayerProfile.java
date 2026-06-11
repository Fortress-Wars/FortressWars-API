package net.fortresswars.core.profiles;

import net.fortresswars.core.Subscription;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class PlayerProfile {

    private final UUID uuid;
    private final AtomicReference<String> username;
    private final AtomicInteger credits;
    private final Map<String, Subscription> subscriptions;
    private final Map<String, String>  preferences;

    public PlayerProfile(ProfileGetRequest profileGetRequest) {
        this.uuid = profileGetRequest.uuid;
        this.username = new AtomicReference<>(profileGetRequest.username);
        this.credits = new AtomicInteger(profileGetRequest.credits);
        this.subscriptions = new ConcurrentHashMap<>(profileGetRequest.subscriptions);
        this.preferences = new ConcurrentHashMap<>(profileGetRequest.preferences);
    }

    public ProfilePutRequest toUpdateRequest() {
        final UUID uuid = this.uuid;
        final String username = this.username.get();
        final Integer credits = this.credits.get();
        final @Nullable Map<String, Subscription> subscriptions = !this.subscriptions.isEmpty() ? this.subscriptions : null;
        final @Nullable Map<String, String> preferences = !this.preferences.isEmpty() ? this.preferences : null;
        return new ProfilePutRequest(uuid, username, credits, subscriptions, preferences);
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getUsername() {
        return username.get();
    }

    public int getCredits() {
        return credits.get();
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    /**
     * Add credits to the profile.
     * @param credits the number of credits to add.
     * @return the new number of total credits.
     */
    public int addCredits(int credits) {
        return this.credits.addAndGet(credits);
    }

    /**
     * Remove credits from the profile.
     * @param credits the number of credits to remove.
     * @return the new number of total credits.
     */
    public int removeCredits(int credits) {
        return addCredits(-credits);
    }

    /**
     * Set the credits in the profile
     * @param credits the number of credits to set.
     */
    public void setCredits(int credits) {
        this.credits.set(credits);
    }

    public void setSubscription(String subscriptionType, Subscription subscription) {
        this.subscriptions.put(subscriptionType, subscription);
    }

    public @Nullable Subscription getSubscription(String subscriptionType) {
        return subscriptions.get(subscriptionType);
    }

    public void deleteSubscription(String subscriptionType) {
        this.subscriptions.remove(subscriptionType);
    }

    public @Nullable String getPreference(String preference) {
        return this.preferences.get(preference);
    }

    public void setPreference(String preference, String value) {
        this.preferences.put(preference, value);
    }

    public boolean hasPreference(String preference) {
        return this.preferences.containsKey(preference);
    }

    public void deletePreference(String preference) {
        this.preferences.remove(preference);
    }
}
