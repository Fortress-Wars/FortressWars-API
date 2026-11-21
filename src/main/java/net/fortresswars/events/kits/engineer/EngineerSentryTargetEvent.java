package net.fortresswars.events.kits.engineer;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.events.FortressWarsCancellableEvent;

public class EngineerSentryTargetEvent extends FortressWarsCancellableEvent {

    final FortressWarsEntity owner;
    final FortressWarsEntity target;

    public EngineerSentryTargetEvent(FortressWarsEntity owner, FortressWarsEntity target) {
       this.owner = owner;
       this.target = target;
    }

    public FortressWarsEntity getOwner() {
        return owner;
    }

    public FortressWarsEntity getTarget() {
        return target;
    }
}
