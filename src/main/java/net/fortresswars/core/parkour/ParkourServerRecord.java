package net.fortresswars.core.parkour;

import java.util.Date;
import java.util.UUID;

public record ParkourServerRecord(
        String courseID,
        UUID uuid,
        String username,
        double completionTime,
        Date dateCompleted
) {
}
