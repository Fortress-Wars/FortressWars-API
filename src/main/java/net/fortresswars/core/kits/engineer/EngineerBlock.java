package net.fortresswars.core.kits.engineer;

import net.fortresswars.core.kits.abilities.blocks.AbilityBlock;
import net.fortresswars.core.kits.abilities.blocks.Repairable;

public interface EngineerBlock extends AbilityBlock, Repairable {

    /**
     * Get the amount of refund the player will receive when they pick up the block
     * @return the amount of refund the player will receive when they pick up the block
     */
    int getPickupRefund();

}
