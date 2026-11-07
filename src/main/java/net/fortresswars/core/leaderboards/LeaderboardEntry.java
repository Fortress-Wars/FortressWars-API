package net.fortresswars.core.leaderboards;

import java.util.UUID;

public record LeaderboardEntry(
        UUID uuid,
        String username,
        double value
) {

}
