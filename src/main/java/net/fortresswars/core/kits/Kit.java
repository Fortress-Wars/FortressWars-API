package net.fortresswars.core.kits;

import net.fortresswars.core.entities.Resettable;
import net.fortresswars.core.kits.abilities.Ability;
import net.fortresswars.core.kits.abilities.AbilityID;
import net.fortresswars.core.managers.Enableable;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * Interface for Fortress Wars Kits
 * Author: Peter Cesmegi
 */
public interface Kit extends Enableable, Refreshable, Listener, Resettable {
    /**
     * Get the id of the kit class
     * @return UUID
     */
    UUID getID();

    /**
     * Get the kit id of the kit class
     * @return KitID enum
     */
    KitID getKitID();

    /**
     * Get the role of the kit
     * @return KitRole enum
     */
    KitRole getKitRole();

    /**
     * Get the helmet item for this kit
     * @return new ItemStack
     */
    ItemStack getHelmet();

    /**
     * Get the chestplate item for this kit
     * @return new ItemStack
     */
    ItemStack getChestplate();

    /**
     * Get the leggings item for this kit
     * @return new ItemStack
     */
    ItemStack getLeggings();


    /**
     * Get the boots item for this kit
     * @return new ItemStack
     */
    ItemStack getBoots();

    /**
     * Gets the item that should be in the off-hand (i.e a Shield)
     * @return new ItemSTack
     */
    ItemStack getOffHandItem();

    /**
     * Returns a map with the added ability gear.
     * @param gear gear set before calling this method
     */
    void addAbilityGear(Map<Integer, ItemStack> gear);

    /**
     * Get the kit data container that belongs to this kit instance
     * @return KitDataContainer reference
     */
    KitDataContainer getKitData();

    /**
     * Register an ability to be a part of this kit
     * @param ability to register
     */
    void registerAbility(Ability ability);

    /**
     * Unregister an ability of this kit
     * @param ability to unregister
     */
    void unregisterAbility(Ability ability);


    /**
     * Find if a kit has an ability registered
     * @param abilityID ability ID to find
     * @return true if ability ID is registered, false otherwise
     */
    boolean isAbilityRegistered(AbilityID abilityID);

    /**
     * Get the specified ability if it is registered
     * @param abilityID Ability to fetch
     * @return Ability that correlates to the registered ability
     */
    Ability getRegisteredAbility(AbilityID abilityID);

    /**
     * Gets a list of abilities that are currently registered with this kit
     * @return Set of Abilities
     */
    Set<Ability> getAbilities();

    /**
     * Get the Kit Information book for this kit
     * @return new ItemStack
     */
    ItemStack getKitInfoBook();

    /**
     * Sets the users inventory
     */
    void setEquipment();
}