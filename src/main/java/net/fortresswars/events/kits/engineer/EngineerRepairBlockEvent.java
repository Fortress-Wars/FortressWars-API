package net.fortresswars.events.kits.engineer;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.core.kits.engineer.EngineerBlock;

public class EngineerRepairBlockEvent extends EngineerBlockEvent {

    private final int repairAmount;
    private final int metalAmount;

    public EngineerRepairBlockEvent(FortressWarsEntity entity, EngineerBlock block, int repairAmount, int metalAmount) {
        super(entity, block);
        this.repairAmount = repairAmount;
        this.metalAmount = metalAmount;
    }

    public int getRepairAmount() {
        return repairAmount;
    }

    public int getMetalAmount() {
        return metalAmount;
    }
}
