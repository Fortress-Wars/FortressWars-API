package net.fortresswars.events.kits.demon;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.events.FortressWarsEvent;

public class BloodBondEvent extends FortressWarsEvent {

    private final FortressWarsEntity negativePoleEntity;

    /**
     * Create a blood bond event
     * @param negativePoleEntity the entity that is on the negative side of the bond
     */
    public BloodBondEvent(FortressWarsEntity negativePoleEntity) {
        this.negativePoleEntity = negativePoleEntity;
    }

    /**
     * Get the entity that is on the negative side of the bond
     * @return FortressWarsEntity
     */
    public FortressWarsEntity getNegativePoleEntity() {
        return negativePoleEntity;
    }
}
