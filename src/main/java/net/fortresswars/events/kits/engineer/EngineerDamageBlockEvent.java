package net.fortresswars.events.kits.engineer;

import net.fortresswars.core.damage.FWDamageCause;
import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.core.kits.engineer.EngineerStructure;

public class EngineerDamageBlockEvent extends EngineerBlockEvent {

    private int damageAmount;
    private final FWDamageCause damageCause;

    public EngineerDamageBlockEvent(FortressWarsEntity entity, EngineerStructure block, int damageAmount, FWDamageCause damageCause) {
        super(entity, block);
        this.damageAmount = damageAmount;
        this.damageCause = damageCause;
    }

    public int getDamageAmount() {
        return damageAmount;
    }

    public void setDamageAmount(int damageAmount) {
        this.damageAmount = damageAmount;
    }

    public FWDamageCause getDamageCause() {
        return damageCause;
    }
}
