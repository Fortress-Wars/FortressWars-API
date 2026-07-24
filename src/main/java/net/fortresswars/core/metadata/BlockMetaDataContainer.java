package net.fortresswars.core.metadata;

import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;

public class BlockMetaDataContainer extends MetaDataContainer {

    private final BlockData blockData;

    protected BlockMetaDataContainer( Block block) {
        super(block);
        final BlockState blockState = block.getState();
        this.blockData = blockState.getBlockData().clone();
    }

    public BlockMetaDataContainer(Block block, BlockState blockState) {
        super(block);
        this.blockData = blockState.getBlockData().clone();
    }

    public void applyMetaData(Block block) {
        super.applyMetaData(block);
        block.setBlockData(blockData);
    }

    public BlockData getBlockData() {
        return blockData;
    }
}
