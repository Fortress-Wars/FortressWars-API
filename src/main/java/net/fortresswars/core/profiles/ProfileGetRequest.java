package net.fortresswars.core.profiles;

import net.fortresswars.core.Subscription;

import java.util.Map;
import java.util.UUID;

public class ProfileGetRequest {
    UUID uuid;
    String username;
    Integer credits;
    Map<String, Subscription> subscriptions;
    Map<String, String> preferences;
}
