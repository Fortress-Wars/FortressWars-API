package net.fortresswars.events.kits.engineer;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.core.kits.engineer.EngineerDispenser;
import net.fortresswars.events.FortressWarsCancellableEvent;

public class EngineerPreDispenseEvent extends FortressWarsCancellableEvent {

    private final EngineerDispenser dispenser;
    private final FortressWarsEntity target;
    private boolean doesTargetEntity;

    public EngineerPreDispenseEvent(EngineerDispenser dispenser, FortressWarsEntity target) {
        this.dispenser = dispenser;
        this.target = target;
        this.doesTargetEntity = false;
    }

    public EngineerDispenser getDispenser() {
        return dispenser;
    }

    public FortressWarsEntity getTarget() {
        return target;
    }

    public boolean doesTargetEntity() {
        return doesTargetEntity;
    }

    public void setDoesTargetEntity(boolean doesTargetEntity) {
        this.doesTargetEntity = doesTargetEntity;
    }
}
