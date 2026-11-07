package net.fortresswars.core.metadata;

import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.plugin.java.JavaPlugin;

public class BlockMetaDataContainer extends MetaDataContainer {

    private final BlockData blockData;

    protected BlockMetaDataContainer(JavaPlugin plugin, Block block) {
        super(plugin, block);
        final BlockState blockState = block.getState();
        this.blockData = blockState.getBlockData().clone();
    }

    public BlockMetaDataContainer(JavaPlugin plugin, Block block, BlockState blockState) {
        super(plugin, block);
        this.blockData = blockState.getBlockData().clone();
    }

    public void applyMetaData(JavaPlugin plugin, Block block) {
        super.applyMetaData(block);
        block.setBlockData(blockData);
    }

    public BlockData getBlockData() {
        return blockData;
    }
}
