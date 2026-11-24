package net.fortresswars.events.kits.engineer;

import net.fortresswars.core.damage.FWDamageCause;
import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.core.kits.engineer.EngineerStructure;

public class EngineerDestroyBlockEvent extends EngineerBlockEvent {

    private final FWDamageCause damageCause;

    public EngineerDestroyBlockEvent(FortressWarsEntity destroyer, FWDamageCause damageCause, EngineerStructure engineerStructure) {
        super(destroyer, engineerStructure);
        this.damageCause = damageCause;
    }

    public EngineerDestroyBlockEvent(EngineerStructure engineerStructure, FWDamageCause damageCause) {
        super(null, engineerStructure);
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
