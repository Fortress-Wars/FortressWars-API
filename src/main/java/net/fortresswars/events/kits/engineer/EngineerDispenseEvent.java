package net.fortresswars.events.kits.engineer;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.core.kits.engineer.EngineerDispenser;
import net.fortresswars.events.FortressWarsCancellableEvent;

public class EngineerDispenseEvent extends FortressWarsCancellableEvent {

    private final EngineerDispenser dispenser;
    private final FortressWarsEntity target;

    public EngineerDispenseEvent(EngineerDispenser dispenser, FortressWarsEntity target) {
        this.dispenser = dispenser;
        this.target = target;
    }

    public EngineerDispenser getDispenser() {
        return dispenser;
    }

    public FortressWarsEntity getTarget() {
        return target;
    }
}
