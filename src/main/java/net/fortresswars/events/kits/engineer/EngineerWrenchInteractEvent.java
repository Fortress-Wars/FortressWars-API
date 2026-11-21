package net.fortresswars.events.kits.engineer;

import net.fortresswars.core.entities.FortressWarsPlayer;
import net.fortresswars.events.entities.FortressWarsPlayerEvent;
import org.bukkit.block.Block;

public class EngineerWrenchInteractEvent extends FortressWarsPlayerEvent {

    private final Block block;

    public EngineerWrenchInteractEvent(FortressWarsPlayer player, Block block) {
        super(player);
        this.block = block;
    }

    public Block getBlock() {
        return block;
    }

}
