package net.fortresswars.events.blocks;

import net.fortresswars.core.entities.FortressWarsEntity;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

public class FWPlaceBlockEvent extends FWBlockEvent {

    private final @NotNull BlockState previousBlockState;
    private final @NotNull Block blockAgainst;

    public FWPlaceBlockEvent(FortressWarsEntity entity, @NotNull Block block, @NotNull Block blockAgainst, @NonNull BlockState previousBlockState) {
        super(entity, block);
        this.blockAgainst = blockAgainst;
        this.previousBlockState = previousBlockState;
    }

    public @NotNull BlockState getPreviousBlockState() {
        return previousBlockState;
    }

    public @NotNull Block getBlockAgainst() {
        return blockAgainst;
    }

    public BlockFace getBlockFace() {
        return blockAgainst.getFace(block);
    }
}
