package net.fortresswars.events.kits.engineer;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.core.kits.engineer.EngineerStructure;

public class EngineerPickupBlockEvent extends EngineerBlockEvent {

    public EngineerPickupBlockEvent(FortressWarsEntity entity, EngineerStructure block) {
        super(entity, block);
    }
}
