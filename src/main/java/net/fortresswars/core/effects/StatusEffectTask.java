package net.fortresswars.core.effects;

import net.fortresswars.core.entities.Pauseable;
import net.fortresswars.core.managers.Enableable;
import net.fortresswars.events.effects.StatusEffectRemoveEvent;
import net.fortresswars.core.tasks.PauseableTask;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public abstract class StatusEffectTask implements Enableable, Listener, Pauseable<Boolean> {

    private final JavaPlugin plugin;
    protected final Inflictable inflictable;
    protected final StatusEffect effect;
    private PauseableTask task;
    private boolean isExpired;
    private int remainingDuration;
    private boolean isDisabledForReaplication;
    private boolean isPaused;

    protected StatusEffectTask(JavaPlugin plugin, @NotNull Inflictable inflictable, @NotNull StatusEffect effect) {
        this.plugin = plugin;
        this.inflictable = inflictable;
        this.effect = effect;
    }

    protected abstract void onEffectTick(int remainingDuration);
    protected abstract void onTaskEnd();

    public void startTask() {
        if (isExpired) return;
        if (this.task != null) return;
        final int delay = Math.max(0, effect.getOptions().getInt(StatusEffect.DELAY));
        this.remainingDuration = Math.max(0, effect.getDuration());
        this.task = PauseableTask.createTask(() -> {
            if (remainingDuration <= 0) {
                disable();
                onTaskEnd();
                return;
            }

            onEffectTick(remainingDuration);
            remainingDuration--;
        }).runTaskTimer(plugin, delay, 1);
    }

    public int getRemainingDuration() {
        return remainingDuration;
    }

    public StatusEffect getEffect() {
        return this.effect;
    }

    public void enable() {
        if (isEnabled()) return;
        startTask();
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    public void setIsDisabledForReaplication() {
        this.isDisabledForReaplication = true;
    }

    public void disable() {
        if (!isEnabled()) return;
        if (this.task != null) {
            this.task.cancel();
            this.task = null;
        }
        isExpired = true;
        HandlerList.unregisterAll(this);

        final StatusEffectRemoveEvent statusEffectRemoveEvent = new StatusEffectRemoveEvent(inflictable, getEffect(), this.isDisabledForReaplication);
        Bukkit.getPluginManager().callEvent(statusEffectRemoveEvent);
    }

    @Override
    public boolean isEnabled() {
        return task != null;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public boolean isInflictable(Entity entity) {
        final LivingEntity inflictableEntity = inflictable.getLivingEntity();
        final UUID inflictableUUID = inflictableEntity.getUniqueId();
        final UUID livingEntityUUID = entity.getUniqueId();
        return inflictableUUID.equals(livingEntityUUID);
    }

    public boolean extendDuration(int duration) {
        if (duration == 0) return false;
        this.remainingDuration = Math.max(this.remainingDuration, duration);
        return true;
    }

    @Override
    public Boolean pause() {
        if (isPaused) return false;
        if (this.task != null) {
            this.task.pause();
        }
        this.isPaused = true;
        return true;
    }

    @Override
    public Boolean unpause() {
        if (!isPaused) return false;
        if (this.task != null) {
            this.task.unpause();
        }
        this.isPaused = false;
        return true;
    }

    @Override
    public boolean isPaused() {
        return isPaused;
    }
}
