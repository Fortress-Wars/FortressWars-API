package net.fortresswars.events.kits.engineer;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.core.kits.engineer.EngineerBlock;
import net.fortresswars.events.FortressWarsCancellableEvent;

public class EngineerBlockEvent extends FortressWarsCancellableEvent {

    private final FortressWarsEntity involvedEntity;
    private final EngineerBlock block;

    public EngineerBlockEvent(FortressWarsEntity involvedEntity, EngineerBlock block) {
        this.involvedEntity = involvedEntity;
        this.block = block;
    }

    /**
     * Get the involved entity in this event. This can be the damager, repairer, the entity that picked up the block, etc
     * @return fortress wars entity
     */
    public FortressWarsEntity getEntity() {
        return involvedEntity;
    }

    /**
     * Get the engineer block involved in this event
     * @return the engineer block
     */
    public EngineerBlock getBlock() {
        return block;
    }
}
