package net.fortresswars.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public enum FWNumberFormat {
    INT,
    DOUBLE,
    TIME,
    PERCENT,
    FULL_TIME,
    TICK,
    POTION_LEVEL,
    RATIO_PERCENT,
    DURATION;

    private static String formatTime(double timeInSeconds) {
        if (timeInSeconds / 3600 > 1) {
            timeInSeconds = Math.round((timeInSeconds / 3600.0) * 100.0) / 100.0;
            return String.format("%,.2f", timeInSeconds) + "h";
        } else if (timeInSeconds / 60 > 1) {
            timeInSeconds = Math.round((timeInSeconds / 60.0) * 100.0) / 100.0;
            return String.format("%,.2f", timeInSeconds) + "m";
        }
        return String.format("%,.2f", timeInSeconds) + "s";
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

    private static String formatDuration(long totalSeconds) {
        long days = totalSeconds / 86400;
        long hours = (totalSeconds % 86400) / 3600;
        long minutes = (totalSeconds % 3600) / 60;
        long seconds = totalSeconds % 60;

        if (days > 0) {
            return String.format("%dd %02d:%02d:%02d", days, hours, minutes, seconds);
        } else if (hours > 0) {
            return String.format("%02d:%02d:%02d", hours, minutes, seconds);
        } else {
            return String.format("%02d:%02d", minutes, seconds);
        }
    }

    private static String formatValue(FWNumberFormat statType, double value) {
        return switch (statType) {
            case INT -> String.format("%,.0f", value);
            case PERCENT -> String.format("%,.0f%s", value, "%");
            case RATIO_PERCENT -> String.format("%,.1f%s", (value * 100), "%");
            case TIME -> formatTime(value);
            case FULL_TIME -> formatFullTime(value);
            case TICK -> formatTime(value / 20.0);
            case DURATION -> formatDuration((long) value);
            default -> String.format("%,.2f", value);
        };
    }

    public static double round(double value, int precision) {
        var bd = new BigDecimal(value);
        bd = bd.setScale(precision, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public String formatValue(double value) {
        return formatValue(this, value);
    }
}
