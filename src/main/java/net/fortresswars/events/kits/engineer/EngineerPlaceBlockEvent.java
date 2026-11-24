package net.fortresswars.events.kits.engineer;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.core.kits.engineer.EngineerStructure;

public class EngineerPlaceBlockEvent extends EngineerBlockEvent {
    public EngineerPlaceBlockEvent(FortressWarsEntity entity, EngineerStructure block) {
        super(entity, block);
    }
}
