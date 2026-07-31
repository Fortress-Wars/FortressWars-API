package net.fortresswars.core.gamerules;

import net.fortresswars.core.kits.KitDataContainer;
import net.fortresswars.core.kits.KitID;
import net.fortresswars.core.kits.KitRole;
import org.bukkit.inventory.ItemStack;

import java.util.Set;

public interface Gamerule {

    /**
     * Get the ID of the gamerule
     * @return the id
     */
    String getID();

    /**
     * Get if the gamerule is enabled or not
     * @return true if the gamerule is enabled, false if it is not.
     */
    boolean isEnabled();

    /**
     * Get if the game rule can be voted for during the gamerule voting phase.
     * @return true if the gamerule can be voted for, false if it can not.
     */
    boolean canVote();

    /**
     * Get the icon of the gamerule.
     * @return A new item stack of the gamerule icon.
     */
    ItemStack getIcon();

    /**
     * Get the name of the gamerule
     * @return the name
     */
    String getName();

    /**
     * Get the description of the gamerule
     * @return the description
     */
    String getDescription();

    /**
     * Get the default kit of the gamerule
     * @return The default kit
     */
    KitID getDefaultKit();

    /**
     * Get the limit of each kit for each team.
     * @return the kit limit
     */
    int getKitLimit();

    /**
     * Get the maximum number of players that can join each team.
     * @return the maximum number of players
     */
    int getPlayerLimit();

    /**
     * Get the limit of each kit role for each team
     * @return the limit for the specified role
     */
    int getRoleLimit(KitRole kitRole);

    /**
     * If gamerule allows all premium kits to be used.
     * @return true if all premium kits are allowed, false otherwise
     */
    boolean isAllowPremiumKitsEnabled();

    /**
     * Get the enabled kits of the gamerule
     * @return An unmodifiable set of the enabled kits
     */
    Set<KitID> getEnabledKits();

    /**
     * Get if the kit is enabled or not
     * @return true if the kit is enabled, false if it is not
     */
    boolean isKitEnabled(KitID kitID);

    /**
     * Get a kit data container of the kit data overrides of the specified kit of this gamerule
     * @param kitID the kit to get kit data overrides for
     * @return a new kit data container
     */
    KitDataContainer getKitData(KitID kitID);
}
