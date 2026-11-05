package net.fortresswars.core.kits.abilities.blocks;

import net.fortresswars.core.entities.*;
import net.fortresswars.core.kits.abilities.AbilityID;
import net.fortresswars.core.player.TeamColor;
import org.bukkit.block.Block;
import org.jetbrains.annotations.NotNull;

public interface AbilityBlock extends Hackable, Zappable, Attackable {

    int DAMAGE_TO_BLOCK_DAMAGE_RATIO = 30;

    static int convertDamageToBlockDamage(double damage) {
        return (int) Math.max(0, damage * DAMAGE_TO_BLOCK_DAMAGE_RATIO);
    }

    /**
     * The kit ability block
     * @return block
     */
    @NotNull Block getBlock();

    /**
     * Destroy the ability block
     */
    void destroy();

    /**
     * Get the creator of the block
     * @return the entity crerator
     */
    @NotNull FortressWarsEntity getCreator();

    /**
     * Get the ability ID associated with this ability block
     * @return the ability ID associated with this ability block
     */
    @NotNull AbilityID getAbilityID();

    /**
     * Get the owner of the block. The owner can change depending on the state of the block.
     * @return the owner of the block
     */
    @NotNull FortressWarsEntity getOwner();

    /**
     * Get the team of the block. The team can change depending on the state of the block.
     * @return the team of the block
     */
    TeamColor getTeam();
}
