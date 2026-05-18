package net.fortresswars.core.cosmetics;


import org.bukkit.block.Block;

public abstract class BlockEffect extends Cosmetic<FWBlockEffect> {

    /**
     * Gets called when a fortress wars player breaks a block in game
     * @param block of the block broken
     */
    public abstract void doBreakEffect(Block block);

    /**
     * Gets called when a fortress wars player places a block in game
     * @param block of the block placed
     */
    public abstract void doPlaceEffect(Block block);
}
