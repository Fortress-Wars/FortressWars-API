package net.fortresswars.events.entities;

import net.fortresswars.core.entities.FortressWarsEntity;
import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

public class FWAdjustVelocityEvent extends FortressWarsEntityEvent implements Cancellable {

    public enum AdjustingType {
        SET,
        ADD
    }

    private final FortressWarsEntity sourceEntity;
    private final Vector velocity;
    private final AdjustingType adjustingType;
    private double scalar;
    private boolean isCancelled;

    public FWAdjustVelocityEvent(@NotNull FortressWarsEntity targetEntity, @NotNull FortressWarsEntity sourceEntity, Vector velocity, AdjustingType adjustingType) {
        super(targetEntity);
        this.sourceEntity = sourceEntity;
        this.velocity = velocity.clone();
        this.adjustingType = adjustingType;
        this.scalar = 1;
    }

    public FortressWarsEntity getSourceEntity() {
        return sourceEntity;
    }

    public AdjustingType getAdjustingType() {
        return adjustingType;
    }

    public void addScalar(double scale) {
        scalar = Math.max(0, scalar + scale);
    }

    public void removeScalar(double scale) {
        scalar = Math.max(0, scalar - scale);
    }

    public Vector getFinalVelocity() {
        final Entity entity = getEntity().getEntity();
        final Vector currentVelocity = entity.getVelocity().clone();
        final Vector finalVelocity = switch (adjustingType) {
            case SET -> velocity;
            case ADD -> currentVelocity.add(velocity);
        };
        return finalVelocity.multiply(scalar);
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }
}
