package net.fortresswars.core.clocks.timers;

import net.fortresswars.core.clocks.Clock;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.time.Instant;

public interface Timer extends Clock {

    @NotNull Duration getElapsedTime();

    @NotNull Duration getTimeLeft();

    void setEndTime(@NotNull Instant end);
}
