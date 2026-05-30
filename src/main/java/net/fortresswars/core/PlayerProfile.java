package net.fortresswars.core;

import java.util.Map;
import java.util.UUID;

public record PlayerProfile(
        UUID uuid,
        String username,
        int credits,
        Map<String, Subscription> subscriptions

) {

}
