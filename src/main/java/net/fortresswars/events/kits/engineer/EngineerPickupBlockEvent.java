package net.fortresswars.events.kits.engineer;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.core.kits.engineer.EngineerBlock;

public class EngineerPickupBlockEvent extends EngineerBlockEvent {

    public EngineerPickupBlockEvent(FortressWarsEntity entity, EngineerBlock block) {
        super(entity, block);
    }
}
