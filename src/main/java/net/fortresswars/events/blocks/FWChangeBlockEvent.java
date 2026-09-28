package net.fortresswars.events.blocks;

import net.fortresswars.core.entities.FortressWarsEntity;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class FWChangeBlockEvent extends FWBlockEvent {

    private final Material to;

    public FWChangeBlockEvent(FortressWarsEntity entity, Block block, Material to) {
        super(entity, block);
        this.to = to;
    }

    public Material getTo() {
        return to;
    }
}
