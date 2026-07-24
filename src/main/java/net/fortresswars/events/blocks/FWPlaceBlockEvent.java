package net.fortresswars.events.blocks;

import net.fortresswars.core.entities.FortressWarsPlayer;
import net.fortresswars.core.metadata.BlockMetaDataContainer;
import net.fortresswars.events.FortressWarsCancellableEvent;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;

public class FWPlaceBlockEvent extends FortressWarsCancellableEvent {

    private final FortressWarsPlayer fwp;
    private final Block block;
    private final BlockMetaDataContainer previousData;

    public FWPlaceBlockEvent(FortressWarsPlayer fwp, Block block, BlockState previousBlockState) {
        this.fwp = fwp;
        this.block = block;
        this.previousData = new BlockMetaDataContainer(block, previousBlockState);
    }

    public FortressWarsPlayer getPlayer() {
        return fwp;
    }

    public Block getBlock() {
        return block;
    }

    public BlockMetaDataContainer getPreviousData() {
        return previousData;
    }
}
