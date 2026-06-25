package net.fortresswars.core.profiles;

import net.fortresswars.util.FWNumberFormat;

public record ParkourInfo (
        String courseID,
        double bestTime,
        double worstTime,
        double averageTime,
        int completions
) {
    public boolean hasCompleted() {
        return completions >= 1;
    }

    private String formatTime(double time) {
        if (time > 0) {
            return FWNumberFormat.FULL_TIME.formatValue(time);
        }
        return "--:--.--";
    }
    
    public String getBestTimeString() {
        return formatTime(bestTime);
    }

    public String getWorstTimeString() {
        return formatTime(worstTime);
    }

    public String getAverageTimeString() {
        return formatTime(averageTime);
    }

    public String getCompletionsString() {
        if (completions > 0) {
            return FWNumberFormat.INT.formatValue(completions);
        }
        return "--";
    }
}
