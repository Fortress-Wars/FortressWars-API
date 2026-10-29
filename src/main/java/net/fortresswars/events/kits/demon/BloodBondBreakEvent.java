package net.fortresswars.events.kits.demon;

import net.fortresswars.core.entities.FortressWarsEntity;

public class BloodBondBreakEvent extends BloodBondEvent {

    public enum Reason {
        BURN,
        RANGE,
        CLEANSE,
        DISABLE,
        CAST,
        DEATH
    }

    private final FortressWarsEntity positivePoleEntity;
    private final Reason reason;

    /**
     * Create a blood bond event
     * @param negativePoleEntity the entity that was on the negative side of the bond
     * @param positivePoleEntity the entity that was on the positive side of the bond
     */
    public BloodBondBreakEvent(FortressWarsEntity negativePoleEntity, FortressWarsEntity positivePoleEntity, Reason reason) {
        super(negativePoleEntity);
        this.positivePoleEntity = positivePoleEntity;
        this.reason = reason;
    }

    public FortressWarsEntity getPositivePoleEntity() {
        return positivePoleEntity;
    }

    public Reason getReason() {
        return reason;
    }
}
