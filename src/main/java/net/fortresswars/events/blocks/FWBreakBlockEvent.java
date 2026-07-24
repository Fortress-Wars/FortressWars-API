package net.fortresswars.events.blocks;

import net.fortresswars.core.entities.FortressWarsPlayer;
import net.fortresswars.events.FortressWarsCancellableEvent;
import org.bukkit.block.Block;

public class FWBreakBlockEvent extends FortressWarsCancellableEvent {

    private final FortressWarsPlayer player;
    private final Block block;

    public FWBreakBlockEvent(FortressWarsPlayer player, Block block) {
        this.player = player;
        this.block = block;
    }

    public FortressWarsPlayer getPlayer() {
        return player;
    }

    public Block getBlock() {
        return block;
    }
}
