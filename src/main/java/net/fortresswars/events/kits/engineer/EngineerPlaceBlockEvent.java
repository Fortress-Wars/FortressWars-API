package net.fortresswars.events.kits.engineer;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.core.kits.engineer.EngineerBlock;

public class EngineerPlaceBlockEvent extends EngineerBlockEvent {
    public EngineerPlaceBlockEvent(FortressWarsEntity entity, EngineerBlock block) {
        super(entity, block);
    }
}
