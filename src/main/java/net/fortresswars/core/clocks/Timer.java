package net.fortresswars.core.clocks;

import net.fortresswars.core.entities.Pauseable;
import net.fortresswars.core.entities.Resettable;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.time.Instant;

public interface Timer extends Pauseable<Boolean>, Resettable {

    void start();

    void stop();

    Instant getStartTime();

    @NotNull Duration getDuration();

    @NotNull Duration getElapsedTime();

    @NotNull Duration getTimeLeft();

    @NotNull Duration getPausedDuration();

    boolean isZero();

    boolean isInSecond(long second);

    boolean isBetweenSeconds(long low, long high);

    void setDuration(@NotNull Duration duration);

    void setEndTime(@NotNull Instant end);
}
