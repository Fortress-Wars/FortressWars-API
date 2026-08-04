package net.fortresswars.core.clocks;

import net.fortresswars.util.FWNumberFormat;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.time.Instant;

public class ZeroTimer implements Timer {

    @Override
    public void start() {
        // Do Nothing
    }

    @Override
    public void stop() {
        // Do Nothing
    }

    @Override
    public Instant getStartTime() {
        return Instant.now();
    }

    @Override
    public @NotNull Duration getDuration() {
        return Duration.ZERO;
    }

    @Override
    public @NotNull Duration getElapsedTime() {
        return Duration.ZERO;
    }

    @Override
    public @NotNull Duration getTimeLeft() {
        return Duration.ZERO;
    }

    @Override
    public @NotNull Duration getPausedDuration() {
        return Duration.ZERO;
    }

    @Override
    public boolean isZero() {
        return true;
    }

    @Override
    public boolean isInSecond(long second) {
        return second == 0;
    }

    @Override
    public boolean isBetweenSeconds(long low, long high) {
        return isInSecond(low) && isInSecond(high);
    }

    @Override
    public void setDuration(@NotNull Duration duration) {
        // Do Nothing
    }

    @Override
    public void setEndTime(@NotNull Instant end) {
        // Do Nothing
    }

    @Override
    public Boolean pause() {
        return false;
    }

    @Override
    public Boolean unpause() {
        return false;
    }

    @Override
    public boolean isPaused() {
        return false;
    }

    @Override
    public void reset() {
        // Do Nothing
    }

    @Override
    public String toString() {
        return FWNumberFormat.DURATION.formatValue(0);
    }
}
