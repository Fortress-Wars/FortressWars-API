package net.fortresswars.events.kits.demon;

import net.fortresswars.core.entities.FortressWarsEntity;

public class BloodBondPreHealingEvent extends BloodBondEvent {

    private final FortressWarsEntity positivePoleEntity;

    /**
     * Create a blood bond event
     *
     * @param negativePoleEntity the entity that is on the negative side of the bond
     * @param positivePoleEntity the entity that was on the positive side of the bond
     */
    public BloodBondPreHealingEvent(FortressWarsEntity negativePoleEntity, FortressWarsEntity positivePoleEntity) {
        super(negativePoleEntity);
        this.positivePoleEntity = positivePoleEntity;
    }

    public FortressWarsEntity getPositivePoleEntity() {
        return positivePoleEntity;
    }
}
