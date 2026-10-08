package net.fortresswars.core.clocks.stopwatches;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.Duration;
import java.time.Instant;

public class RealStopwatch implements Stopwatch {

    private @Nullable Instant pausedInstant;
    private @NotNull Instant lastSavedInstant;
    private @NotNull Duration duration;
    private @Nullable Instant startInstant;

    public RealStopwatch() {
        this.duration = Duration.ZERO;
        this.pausedInstant = null;
        this.lastSavedInstant = Instant.now();
    }

    private void updateDuration() {
        if (this.isStarted() && this.pausedInstant == null) {
            final var newDurationChunk = Duration.between(this.lastSavedInstant, Instant.now());
            this.duration = this.duration.plus(newDurationChunk);
        }
        this.lastSavedInstant = Instant.now();
    }

    @Override
    public void start() {
        if (this.isStarted()) return;
        this.updateDuration();
        this.startInstant = Instant.now();
        this.pausedInstant = null;
    }

    @Override
    public void stop() {
        if (!this.isStarted()) return;
        this.updateDuration();
        this.pausedInstant = null;
        this.startInstant = null;
    }

    @Override
    public boolean isStarted() {
        return this.startInstant != null;
    }

    @Override
    public Instant getStartTime() {
        return this.lastSavedInstant;
    }

    @Override
    public @NotNull Duration getDuration() {
       this.updateDuration();
       return this.duration;
    }

    @Override
    public @NotNull Duration getPausedDuration() {
        if (this.pausedInstant == null) {
            return Duration.ZERO;
        }
        return Duration.between(this.pausedInstant, Instant.now());
    }

    @Override
    public boolean isZero() {
        return this.duration.isZero();
    }

    @Override
    public boolean isInSecond(long second) {
        final var duration = this.getDuration();
        return duration.getSeconds() == second;
    }

    @Override
    public boolean isBetweenSeconds(long low, long high) {
        final var duration = this.getDuration();
        final var seconds = duration.getSeconds();
        return seconds >= low && seconds < high;
    }

    @Override
    public void setDuration(@NotNull Duration duration) {
        this.duration = duration;
    }

    @Override
    public Boolean pause() {
        if (this.isPaused()) return false;
        this.updateDuration();
        this.pausedInstant = Instant.now();
        return true;
    }

    @Override
    public Boolean unpause() {
        if (!this.isPaused()) return false;
        this.pausedInstant = null;
        return true;
    }

    @Override
    public boolean isPaused() {
        return this.pausedInstant != null;
    }

    @Override
    public void reset() {
        this.stop();
        this.start();
    }

    @Override
    public void restart() {
        this.duration = Duration.ZERO;
        this.reset();
    }
}
