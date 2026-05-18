package net.fortresswars.core.achievements;

import net.fortresswars.util.FWNumberFormat;

import java.util.UUID;

public record AchievementProgress(
        FWAchievement achievement,
        UUID uuid,
        FWNumberFormat valueType,
        double currentValue,
        double targetValue
) {

    public String getFormattedProgress() {
        return valueType.formatValue(currentValue);
    }

    public String getFormattedTarget() {
        return valueType.formatValue(targetValue);
    }

    public double getPercentage() {
        if (targetValue <= 0) return 0;
        return  Math.min(100, currentValue / targetValue);
    }

    public String getFormattedPercentage() {
        final double percentage = getPercentage();
        return FWNumberFormat.PERCENT.formatValue(percentage);
    }
}
