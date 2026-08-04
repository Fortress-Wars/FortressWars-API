package net.fortresswars.core.clocks;

import net.fortresswars.util.FWNumberFormat;
import net.fortresswars.util.PauseableTask;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.time.Duration;
import java.time.Instant;

public class ServerTimer implements Timer {

    private final JavaPlugin plugin;
    private @Nullable Instant startInstant;
    private @Nullable Instant pausedInstant;
    private @NotNull Duration duration;
    private @Nullable PauseableTask timerTask;
    private long elapsedTime; // 1 tick = 50ms

    public ServerTimer(JavaPlugin plugin, @NotNull Duration duration) {
        this.plugin = plugin;
        this.duration = duration;
        this.elapsedTime = 0;
    }

    @Override
    public void start() {
        if (this.timerTask != null) return;
        this.elapsedTime = 0;
        this.startInstant = Instant.now();
        this.timerTask = PauseableTask.createTask(() -> {
            this.elapsedTime++;
            if (isZero()) {
                stop();
            }
        }).runTaskTimer(this.plugin, 0L, 1L);
    }

    @Override
    public void stop() {
        if (this.timerTask == null) return;
        this.timerTask.cancel();
        this.timerTask = null;
    }

    @Override
    public Instant getStartTime() {
        return this.startInstant;
    }

    @Override
    public @NotNull Duration getDuration() {
        return this.duration;
    }

    @Override
    public @NotNull Duration getElapsedTime() {
        return Duration.ofMillis(50 * this.elapsedTime);
    }

    @Override
    public @NotNull Duration getTimeLeft() {
        final var elapsed = getElapsedTime();
        return duration.minus(elapsed);
    }

    @Override
    public @NotNull Duration getPausedDuration() {
        if (this.pausedInstant == null) return Duration.ZERO;
        return Duration.between(this.pausedInstant, Instant.now());
    }

    @Override
    public boolean isZero() {
        final var timeLeft = getTimeLeft();
        return timeLeft.isZero() || timeLeft.isNegative();
    }

    @Override
    public boolean isInSecond(long second) {
        return second <= this.elapsedTime && this.elapsedTime < second + 1;
    }

    @Override
    public boolean isBetweenSeconds(long low, long high) {
        return low <= this.elapsedTime && this.elapsedTime < high;
    }

    @Override
    public void setDuration(@NotNull Duration duration) {
        this.duration = duration;
    }

    @Override
    public void setEndTime(@NotNull Instant end) {
        if (startInstant == null) throw new IllegalStateException();
        this.duration = Duration.between(startInstant, end);
    }

    @Override
    public Boolean pause() {
        if (this.timerTask == null) return false;
        this.timerTask.pause();
        return true;
    }

    @Override
    public Boolean unpause() {
        if (this.timerTask == null) return false;
        this.timerTask.unpause();
        return true;
    }

    @Override
    public boolean isPaused() {
        if (this.timerTask == null) return false;
        return this.timerTask.isPaused();
    }

    @Override
    public void reset() {
        stop();
        start();
    }

    @Override
    public String toString() {
        final var timeLeft = getTimeLeft();
        final var secondsLeft = timeLeft.toSeconds();
        return FWNumberFormat.DURATION.formatValue(secondsLeft);
    }
}
