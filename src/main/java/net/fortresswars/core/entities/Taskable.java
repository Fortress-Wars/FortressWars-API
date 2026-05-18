package net.fortresswars.core.entities;

import org.bukkit.scheduler.BukkitTask;

public interface Taskable {

    void setTask(String taskName, BukkitTask task);

    void cancelTask(String taskName);

    void resetTasks();

    boolean isTaskActive(String taskName);
}
