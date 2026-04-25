package net.fortresswars.core;

import java.text.DecimalFormat;

public enum NumberFormat {
    INT,
    DOUBLE,
    TIME,
    PERCENT,
    FULLTIME,
    TICK,
    POTION_LEVEL,
    RATIOPERCENT,
    DURATION;

    private static String formatTime(double timeInSeconds) {
        String timeString;
        if (timeInSeconds / 3600 > 1) {
            timeInSeconds = Math.round((timeInSeconds / 3600.0) * 100.0) / 100.0;
            timeString = String.format("%,.2f", timeInSeconds) + "h";
        } else if (timeInSeconds / 60 > 1) {
            timeInSeconds = Math.round((timeInSeconds / 60.0) * 100.0) / 100.0;
            timeString = String.format("%,.2f", timeInSeconds) + "m";
        } else {
            timeString = String.format("%,.2f", timeInSeconds) + "s";
        }
        return timeString;
    }

    private static String formatFullTime(double timeInSeconds) {
        long hours = (long) (timeInSeconds / 3600);
        long minutes = (long) ((timeInSeconds % 3600) / 60);
        double seconds =  ((timeInSeconds * 100) % 6000) / 100.0;

        DecimalFormat df = new DecimalFormat("00.00");
        String ss = df.format(seconds);
        if (hours > 0) {
            return hours + ":" + String.format("%2d", minutes) + ":" + ss;
        } else if (minutes > 0) {
            return minutes + ":" + ss;
        }
        return String.format("%,.2f", timeInSeconds) + "s";
    }

    private static String formatDuration(double timeInSeconds) {
        final long MINUTE = 60;
        final long HOUR = MINUTE * 60;
        final long DAY = HOUR * 24;
        final long timeInMS = ((long) timeInSeconds % DAY) * 1000;
        final long days = ((long)  timeInSeconds) / DAY;
        return String.format("%dd %tH:%<tM:%<tS", days, timeInMS);
    }

    public static String formatStat(NumberFormat statType, double value) {
        return switch (statType) {
            case INT -> String.format("%,.0f", value);
            case PERCENT -> String.format("%,.0f%s", value, "%");
            case RATIOPERCENT -> String.format("%,.1f%s", (value * 100), "%");
            case TIME -> formatTime(value);
            case FULLTIME -> formatFullTime(value);
            case TICK -> formatTime(value / 20.0);
            case DURATION -> formatDuration(value);
            default -> String.format("%,.2f", value);
        };
    }

    public String formatValue(double value) {
        return formatStat(this, value);
    }
}
