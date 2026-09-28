package net.fortresswars.events.blocks;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.events.FortressWarsCancellableEvent;
import org.bukkit.block.Block;

public class FWBlockEvent extends FortressWarsCancellableEvent {

    private final FortressWarsEntity entity;
    private final Block block;

    public FWBlockEvent(FortressWarsEntity entity, Block block) {
        this.entity = entity;
        this.block = block;
    }

    public FortressWarsEntity getEntity() {
        return entity;
    }

    public Block getBlock() {
        return block;
    }
}
