package net.fortresswars.core.kits.abilities.structures;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.core.entities.FortressWarsNonLivingEntity;
import net.fortresswars.core.entities.Repairable;
import net.fortresswars.core.kits.abilities.AbilityID;
import org.jetbrains.annotations.NotNull;

public interface EntityStructure extends FortressWarsNonLivingEntity, Repairable {
    /**
     * Get the amount of resources the player needs to spend to place the structure
     * @return the amount of resources.
     */
    double getPlacementCost();

    /**
     * Get the amount of resources the player will receive when they pick up the structure
     * @return the amount of resources.
     */
    double getPickupRefund();

    /**
     * Get the owner of the structure
     * @return the owner of the structure
     */
    @NotNull FortressWarsEntity getOwner();

    /**
     * Get the creator of the structure
     * @return the creator of the structure
     */
    @NotNull FortressWarsEntity getCreator();

    /**
     * Get the ability ID associated with this structure
     * @return the ability ID associated with this structure
     */
    @NotNull AbilityID getAbilityID();
}
