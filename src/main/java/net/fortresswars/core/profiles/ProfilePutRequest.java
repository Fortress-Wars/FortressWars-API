package net.fortresswars.core.profiles;

import net.fortresswars.core.Subscription;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.UUID;

public record ProfilePutRequest(
        @Nullable UUID uuid,
        @Nullable String username,
        @Nullable String rank,
        @Nullable Integer  credits,
        @Nullable Map<String, Subscription> subscriptions,
        @Nullable Map<String, String> preferences
) {

}
