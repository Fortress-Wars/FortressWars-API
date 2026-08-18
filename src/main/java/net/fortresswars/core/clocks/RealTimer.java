package net.fortresswars.core.clocks;

import net.fortresswars.util.FWNumberFormat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.Duration;
import java.time.Instant;

public class RealTimer implements Timer {

    private @Nullable Instant pausedInstant;
    private @Nullable Instant startInstant;
    private @NotNull Duration duration;

    public RealTimer(@NotNull Duration duration) {
        this.duration = duration;
        this.pausedInstant = null;
    }

    public void start() {
        this.startInstant = Instant.now();
        this.unpause();
    }

    public void stop() {
        this.pause();
        this.startInstant = null;
    }

    @Override
    public void reset() {
        stop();
        start();
    }

    public Instant getStartTime() {
        return startInstant;
    }

    public @NotNull Duration getDuration() {
        return duration;
    }

    public @NotNull Duration getElapsedTime() {
        if (startInstant == null) return Duration.ZERO;
        final var now = Instant.now();
        final var pausedDuration = getPausedDuration();
        return Duration.between(startInstant, now).minus(pausedDuration);
    }

    public @NotNull Duration getTimeLeft() {
        if (startInstant == null) return Duration.ZERO;
        final var now = Instant.now();
        final var end = startInstant.plus(duration);
        final var pausedDuration = getPausedDuration();
        return Duration.between(now, end).minus(pausedDuration);
    }

    public boolean isZero() {
        final var timeLeft = getTimeLeft();
        return timeLeft.isNegative() ||  timeLeft.isZero();
    }

    public boolean isInSecond(long second) {
        final var timeLeft = getTimeLeft();
        return timeLeft.getSeconds() == second;
    }

    /**
     * Check if the time left is between the specified times.
     * @param low the low value (inclusive)
     * @param high the high value (exclusive)
     * @return true if the time left is between the low and high value, false otherwise.
     */
    public boolean isBetweenSeconds(long low, long high) {
        final var timeLeft = getTimeLeft();
        return timeLeft.getSeconds() >= low && timeLeft.getSeconds() < high;
    }

    public @NotNull Duration getPausedDuration() {
        if (pausedInstant == null) return Duration.ZERO;
        final var now = Instant.now();
        return Duration.between(pausedInstant, now);
    }

    public void setDuration(@NotNull Duration duration) {
        this.duration = duration;
    }

    public void setEndTime(@NotNull Instant end) {
        if (startInstant == null) throw new IllegalStateException();
        this.duration = Duration.between(startInstant, end);
    }

    @Override
    public Boolean pause() {
        if (pausedInstant != null) return false;
        if (startInstant == null) throw new IllegalStateException();
        this.pausedInstant = Instant.now();
        return true;
    }

    @Override
    public Boolean unpause() {
        if (pausedInstant == null) return false;
        if (startInstant == null) throw new IllegalStateException();
        final var now = Instant.now();
        final var pausedDuration = Duration.between(pausedInstant, now);
        this.startInstant = this.startInstant.plus(pausedDuration);
        this.pausedInstant = null;
        return true;
    }

    @Override
    public boolean isPaused() {
        return this.pausedInstant != null;
    }

    @Override
    public String toString() {
        final var timeLeft = getTimeLeft();
        final var secondsLeft = timeLeft.toSeconds();
        return FWNumberFormat.DURATION.formatValue(secondsLeft);
    }
}
