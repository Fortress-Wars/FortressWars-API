package net.fortresswars.events.kits.engineer;

import net.fortresswars.core.damage.FWDamageCause;
import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.core.kits.engineer.EngineerBlock;

public class EngineerDestroyBlockEvent extends EngineerBlockEvent {

    private final FWDamageCause damageCause;

    public EngineerDestroyBlockEvent(FortressWarsEntity destroyer, FWDamageCause damageCause, EngineerBlock engineerBlock) {
        super(destroyer, engineerBlock);
        this.damageCause = damageCause;
    }

    public EngineerDestroyBlockEvent(EngineerBlock engineerBlock, FWDamageCause damageCause) {
        super(null, engineerBlock);
        this.damageCause = damageCause;
    }

    /**
     * Get the damage cause that destroyed this engineer block.
     * @return the damage cause
     */
    public FWDamageCause getDamageCause() {
        return damageCause;
    }
}
