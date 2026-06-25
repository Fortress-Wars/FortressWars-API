package net.fortresswars.api.requests;

public record SetEquippedCosmeticRequest(
        String cosmeticType,
        String cosmeticID
) {
}
