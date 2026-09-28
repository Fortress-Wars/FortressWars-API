package net.fortresswars.events.blocks;

import net.fortresswars.core.entities.FortressWarsPlayer;
import org.bukkit.block.Block;

public class FWBreakBlockEvent extends FWBlockEvent {

    public FWBreakBlockEvent(FortressWarsPlayer player, Block block) {
        super(player, block);
    }
}
