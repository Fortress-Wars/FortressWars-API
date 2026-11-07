package net.fortresswars.helpers;

import java.security.InvalidParameterException;

public class MathHelper {

    public static int bind(int value, int min, int max) {
        if (min > max) {
            throw new InvalidParameterException("The min must be equal to or less than the max");
        }
        return Math.clamp(value, min, max);
    }

    public static double calculateFalloff(double value, double falloffStart, double falloffEnd, double min, double max) {
        if (falloffEnd - falloffStart <= 0) return max;
        if (value <= falloffStart) return max;
        if (value >= falloffEnd) return min;
        final double normalizedFalloff = (value - falloffStart) / (falloffEnd - falloffStart);
        return normalizedFalloff * min + (1.0 - normalizedFalloff) * max;
    }

    public static double calculateRampUp(double value, double rampUpStart, double rampUpEnd, double min, double max) {
        if (rampUpEnd - rampUpStart <= 0) return max;
        if (value <= rampUpStart) return min;
        if (value >= rampUpEnd) return max;

        final double normalizedFalloff = (value - rampUpStart) / (rampUpEnd - rampUpStart);
        return (1.0 - normalizedFalloff) * min + normalizedFalloff * max;
    }

    /**
     * Get the number of leading spaces based on the stat value.
     * @param statValue The stat value to use
     * @return number of leading zeros
     */
    public static int getNumberSpacing(double statValue) {
        if (statValue == 0) return 0;

        // If the number is a negative, then there is the - symbol which adds 1
        final boolean isNegative = statValue < 0;

        final double absValue = Math.abs(statValue);
        final double log10 = Math.log10(absValue);

        if (isNegative) {
            return (int) Math.floor(log10) + 1;
        }

        return (int) Math.floor(log10);
    }

    /**
     * Cycle an integer by an amount. If the value goes below the min, it continues at the max. If
     * The value goes above the max, it continues from the min.
     * @param value the value to cycle
     * @param amount the amount by which to cycle.
     * @param min the min value
     * @param max the max value
     * @return the new cycled value.
     */
    public static int cycleNumber(int value, int amount, int min, int max) {
        // Calculate the total number of unique elements in the range
        final var rangeSize = max - min + 1;

        // Normalize the current position to a 0-indexed scale relative to min
        final var zeroIndexedCurrent = value - min;

        // Use modulo arithmetic to find the new 0-indexed position.
        // Adding rangeSize before the second modulo prevents negative results.
        var nextZeroIndexed = (zeroIndexedCurrent + amount) % rangeSize;
        if (nextZeroIndexed < 0) {
            nextZeroIndexed += rangeSize;
        }

        // Convert back to the original range scale
        return nextZeroIndexed + min;
    }
}
