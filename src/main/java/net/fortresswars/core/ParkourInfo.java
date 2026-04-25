package net.fortresswars.core;

import java.util.UUID;

public record ParkourInfo (
        UUID uuid,
        String courseID,
        double bestTime,
        double worstTime,
        double averageTime,
        int completions
) {
    public boolean hasCompleted() {
        return completions >= 1;
    }
}
