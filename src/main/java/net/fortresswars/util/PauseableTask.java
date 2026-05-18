package net.fortresswars.util;

import net.fortresswars.core.entities.Pauseable;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.time.Instant;

public abstract class PauseableTask implements Runnable, Pauseable<PauseableTask> {

    private BukkitTask task;
    private boolean isCancelled;

    private RunType runType;
    private Plugin plugin;
    private long delay;
    private long period;

    private boolean isPaused;
    private Instant runInstant;

    private enum RunType {
        RUN,
        RUN_LATER,
        RUN_TIMER,
        RUN_ASYNC,
        RUN_LATER_ASYNC,
        RUN_TIMER_ASYNC,
    }

    public static @NotNull PauseableTask createTask(Runnable runnable) {
        return new PauseableTask() {
            @Override
            public void run() {
                runnable.run();
            }
        };
    }

    public synchronized boolean isCancelled() throws IllegalStateException {
        return isCancelled;
    }

    public synchronized void cancel() throws IllegalStateException {
        if (task != null) {
            Bukkit.getScheduler().cancelTask(task.getTaskId());
        }
        this.isCancelled = true;
    }

    public synchronized @NotNull PauseableTask runTask(@NotNull Plugin plugin) throws IllegalArgumentException, IllegalStateException {
        return this.schedule(plugin, RunType.RUN);
    }

    public synchronized @NotNull PauseableTask runTaskAsynchronously(@NotNull Plugin plugin) throws IllegalArgumentException, IllegalStateException {
        return this.schedule(plugin, RunType.RUN_ASYNC);
    }

    public synchronized @NotNull PauseableTask runTaskLater(@NotNull Plugin plugin, long delay) throws IllegalArgumentException, IllegalStateException {
        return this.schedule(plugin, RunType.RUN_LATER, delay);
    }

    public synchronized @NotNull PauseableTask runTaskLaterAsynchronously(@NotNull Plugin plugin, long delay) throws IllegalArgumentException, IllegalStateException {
        return this.schedule(plugin, RunType.RUN_LATER_ASYNC, delay);
    }

    public synchronized @NotNull PauseableTask runTaskTimer(@NotNull Plugin plugin, long delay, long period) throws IllegalArgumentException, IllegalStateException {
        return this.schedule(plugin, RunType.RUN_TIMER, delay, period);
    }

    public synchronized @NotNull PauseableTask runTaskTimerAsynchronously(@NotNull Plugin plugin, long delay, long period) throws IllegalArgumentException, IllegalStateException {
        return this.schedule(plugin, RunType.RUN_TIMER_ASYNC, delay, period);
    }

    private synchronized @NotNull PauseableTask schedule(Plugin plugin, RunType runType) throws IllegalArgumentException, IllegalStateException {
        return this.schedule(plugin, runType, 0, 0);
    }

    private synchronized @NotNull PauseableTask schedule(Plugin plugin, RunType runType, long delay) throws IllegalArgumentException, IllegalStateException {
        return this.schedule(plugin, runType, delay, 0);
    }

    private synchronized @NotNull PauseableTask schedule(Plugin plugin, RunType runType, long delay, long period) throws IllegalArgumentException, IllegalStateException {
        this.checkNotYetScheduled();
        this.plugin = plugin;
        this.delay = delay;
        this.period = period;
        this.runType = runType;
        this.runInstant = Instant.now();
        return reschedule(runType);
    }

    private PauseableTask reschedule(RunType runType) throws IllegalArgumentException, IllegalStateException {
        this.checkNotYetScheduled();
        switch (runType) {
            case RUN -> this.setupTask(Bukkit.getScheduler().runTask(plugin, this));
            case RUN_ASYNC -> this.setupTask(Bukkit.getScheduler().runTaskAsynchronously(plugin, this));
            case RUN_LATER -> this.setupTask(Bukkit.getScheduler().runTaskLater(plugin, this, delay));
            case RUN_LATER_ASYNC -> this.setupTask(Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, this, delay));
            case RUN_TIMER -> this.setupTask(Bukkit.getScheduler().runTaskTimer(plugin, this, delay, period));
            case RUN_TIMER_ASYNC -> this.setupTask(Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, this, delay, period));
        }
        return this;
    }

    public synchronized int getTaskId() throws IllegalStateException {
        this.checkScheduled();
        return this.task.getTaskId();
    }

    private void checkScheduled() {
        if (this.task == null) {
            throw new IllegalStateException("Not scheduled yet");
        }
    }

    private void checkNotYetScheduled() {
        if (this.task != null) {
            throw new IllegalStateException("Already scheduled as " + this.task.getTaskId());
        }
    }

    private @NotNull BukkitTask setupTask(@NotNull BukkitTask task) {
        this.task = task;
        return task;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public PauseableTask pause() throws IllegalArgumentException, IllegalStateException {
        if (isCancelled) return null;
        if (isPaused) return null;

        // This will also check if there is a task
        final var taskId = this.getTaskId();

        // Check if we can pause
        if (this.runType == RunType.RUN || this.runType == RunType.RUN_ASYNC) return null;

        // Calculate new period and delay
        final var pauseInstant = Instant.now();
        this.period = getNewRemainingTicks(this.period, this.runInstant, pauseInstant);
        this.delay = getNewRemainingTicks(this.delay, this.runInstant, pauseInstant);
        Bukkit.getScheduler().cancelTask(taskId);
        this.task = null;

        this.isPaused = true;
        return null;
    }

    private long getNewRemainingTicks(long remainingTicks, Instant start, Instant end) {
        if (remainingTicks <= 0) return 0;
        final var elapsedDuration = Duration.between(start, end);
        final var elapsedTicks = elapsedDuration.toMillis() / 50;
        return Math.max(0, remainingTicks - elapsedTicks);
    }

    public PauseableTask unpause() throws IllegalArgumentException, IllegalStateException {
        if (isCancelled) return null;
        if (!isPaused) return null;
        final var newTask = reschedule(runType);
        this.isPaused = false;
        return newTask;
    }
}
