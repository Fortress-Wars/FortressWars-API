package net.fortresswars.events.kits;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.events.FortressWarsCancellableEvent;

public class FWLightningStrikeEntityEvent extends FortressWarsCancellableEvent {
    private final FortressWarsEntity entity;
    private final FortressWarsEntity source;

    public FWLightningStrikeEntityEvent(FortressWarsEntity entity, FortressWarsEntity source) {
        this.entity = entity;
        this.source = source;
    }

    public FortressWarsEntity getEntity() {
        return entity;
    }

    public FortressWarsEntity getSource() {
        return source;
    }
}
