package net.fortresswars.events.blocks;

import net.fortresswars.core.entities.FortressWarsEntity;
import org.bukkit.block.Block;

public class FWBreakBlockEvent extends FWBlockEvent {

    public FWBreakBlockEvent(FortressWarsEntity entity, Block block) {
        super(entity, block);
    }
}
