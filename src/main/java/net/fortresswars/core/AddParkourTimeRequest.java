package net.fortresswars.core;

public record AddParkourTimeRequest(
        String courseID,
        double completionTime
) {
}
