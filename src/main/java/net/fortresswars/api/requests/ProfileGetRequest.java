package net.fortresswars.api.requests;

import net.fortresswars.core.profiles.Subscription;

import java.util.Map;
import java.util.UUID;

public record ProfileGetRequest(
        UUID uuid,
        String username,
        String rank,
        Integer credits,
        Map<String, Subscription> subscriptions,
        Map<String, String> preferences
) {

}
