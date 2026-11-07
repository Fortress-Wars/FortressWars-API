package net.fortresswars.events.damage;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.core.entities.FortressWarsPlayer;
import net.fortresswars.events.FortressWarsEvent;

public class FWCleanseEvent extends FortressWarsEvent {

    private final FortressWarsPlayer sourcePlayer;
    private final FortressWarsEntity targetEntity;
    private final double range;

    public FWCleanseEvent(FortressWarsPlayer sourcePlayer, FortressWarsEntity targetEntity, double range) {
        this.sourcePlayer = sourcePlayer;
        this.targetEntity = targetEntity;
        this.range = range;
    }

    public FortressWarsPlayer getSourcePlayer() {
        return sourcePlayer;
    }

    public FortressWarsEntity getTarget() {
        return targetEntity;
    }

    public double getRange() {
        return range;
    }
}
