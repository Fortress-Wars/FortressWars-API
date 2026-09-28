package net.fortresswars.events.blocks;

import net.fortresswars.core.entities.FortressWarsEntity;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;

public class FWPlaceBlockEvent extends FWBlockEvent {

    private final BlockState previousBlockState;

    public FWPlaceBlockEvent(FortressWarsEntity entity, Block block, BlockState previousBlockState) {
        super(entity, block);
        this.previousBlockState = previousBlockState;
    }

    public BlockState getPreviousBlockState() {
        return previousBlockState;
    }
}
