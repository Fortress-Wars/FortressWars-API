package net.fortresswars.events.kits.priest;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.events.FortressWarsCancellableEvent;

public class LightBeamHitEvent extends FortressWarsCancellableEvent {

    private final FortressWarsEntity entityHit;
    private final FortressWarsEntity sourceEntity;
    private boolean shouldGiveEffects;

    public LightBeamHitEvent(FortressWarsEntity entityHit, FortressWarsEntity sourceEntity) {
        this.entityHit = entityHit;
        this.sourceEntity = sourceEntity;
        this.shouldGiveEffects = true;
    }

    public FortressWarsEntity getEntityHit() {
        return entityHit;
    }

    public FortressWarsEntity getSourceEntity() {
        return sourceEntity;
    }

    public boolean shouldGiveEffects() {
        return shouldGiveEffects;
    }

    public void setShouldGiveEffects(boolean shouldGiveEffects) {
        this.shouldGiveEffects = shouldGiveEffects;
    }
}
