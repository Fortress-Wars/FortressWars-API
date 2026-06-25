package net.fortresswars.core.profiles;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

public record ParkourProfile (
        UUID uuid,
        Date date,
        Map<String, ParkourCourseStats> courses
) {
    public record ParkourCourseStats(
            double bestTime,
            double worstTime,
            double averageTime,
            int completions
    ) {
    }
}
