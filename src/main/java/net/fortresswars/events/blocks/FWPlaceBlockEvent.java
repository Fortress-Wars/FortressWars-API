package net.fortresswars.events.blocks;

import net.fortresswars.core.entities.FortressWarsPlayer;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;

public class FWPlaceBlockEvent extends FWBlockEvent {

    private final BlockState previousBlockState;

    public FWPlaceBlockEvent(FortressWarsPlayer player, Block block, BlockState previousBlockState) {
        super(player, block);
        this.previousBlockState = previousBlockState;
    }

    public BlockState getPreviousBlockState() {
        return previousBlockState;
    }
}
