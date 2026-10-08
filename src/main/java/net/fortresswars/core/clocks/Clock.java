package net.fortresswars.core.clocks;

import net.fortresswars.core.entities.Pauseable;
import net.fortresswars.core.entities.Resettable;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.time.Instant;

public interface Clock extends Pauseable<Boolean>, Resettable {

    void start();

    void stop();

    boolean isStarted();

    Instant getStartTime();

    @NotNull Duration getPausedDuration();

    boolean isZero();

    boolean isInSecond(long second);

    boolean isBetweenSeconds(long low, long high);

    @NotNull Duration getDuration();

    void setDuration(@NotNull Duration duration);
}
