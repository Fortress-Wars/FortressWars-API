package net.fortresswars.events.kits.demon;

import net.fortresswars.core.entities.FortressWarsEntity;

import java.util.Set;

public class BloodBondTransmitEvent extends BloodBondEvent {


    private final Set<FortressWarsEntity> positivePoleEntities;
    private final double totalDamage;
    private final double damagePerBond;

    /**
     * Create a blood bond event
     *
     * @param negativePoleEntity   the entity that is on the negative side of the bond
     * @param positivePoleEntities the set of entities that have bonds with this entity and are on the positive end of it
     */
    public BloodBondTransmitEvent(FortressWarsEntity negativePoleEntity, Set<FortressWarsEntity> positivePoleEntities, double totalDamage) {
        super(negativePoleEntity);
        this.positivePoleEntities = positivePoleEntities;
        this.totalDamage = totalDamage;
        this.damagePerBond = totalDamage / positivePoleEntities.size();
    }

    /**
     * Get the set of entities that have bonds with this entity and are on the positive end of it.
     * @return Set of FortressWarsEntity
     */
    public Set<FortressWarsEntity> getPositivePoleEntities() {
        return positivePoleEntities;
    }

    public double getTotalDamage() {
        return totalDamage;
    }

    public double getDamagePerBond() {
        return damagePerBond;
    }
}
