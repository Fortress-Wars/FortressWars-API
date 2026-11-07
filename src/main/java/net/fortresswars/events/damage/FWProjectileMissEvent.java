package net.fortresswars.events.damage;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.events.entities.FortressWarsEntityEvent;

public class FWProjectileMissEvent extends FortressWarsEntityEvent {

    public FWProjectileMissEvent(FortressWarsEntity entity) {
        super(entity);
    }
}
