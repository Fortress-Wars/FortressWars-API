package net.fortresswars.events.kits.engineer;

import net.fortresswars.core.entities.FortressWarsPlayer;
import org.bukkit.block.Block;

public class EngineerWrenchInteractPickupEvent extends EngineerWrenchInteractEvent {

    private boolean hasPickedUp;

    public EngineerWrenchInteractPickupEvent(FortressWarsPlayer player, Block block) {
        super(player, block);
        this.hasPickedUp = false;
    }

    public boolean hasPickedUp() {
        return hasPickedUp;
    }

    public void setHasPickedUp() {
        this.hasPickedUp = true;
    }
}
