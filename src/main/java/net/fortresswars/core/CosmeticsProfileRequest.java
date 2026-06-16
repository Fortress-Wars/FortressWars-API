package net.fortresswars.core;

import java.util.Map;
import java.util.UUID;

public record CosmeticsProfileRequest(
        UUID uuid,
        Map<String, String> equippedCosmetics
) {
}
