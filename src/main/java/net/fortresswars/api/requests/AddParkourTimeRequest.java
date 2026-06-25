package net.fortresswars.api.requests;

public record AddParkourTimeRequest(
        String courseID,
        double completionTime
) {
}
