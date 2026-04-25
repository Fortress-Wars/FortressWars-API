package net.fortresswars.core;

import java.util.UUID;

public record LeaderboardEntry(
        UUID uuid,
        String username,
        double value
) {

}
