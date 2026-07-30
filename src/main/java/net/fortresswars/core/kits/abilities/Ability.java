package net.fortresswars.core.kits.abilities;

import net.fortresswars.core.entities.Pauseable;
import net.fortresswars.core.entities.Resettable;
import net.fortresswars.core.kits.Refreshable;
import net.fortresswars.core.managers.Enableable;
import org.bukkit.event.Listener;

import java.util.UUID;

public interface Ability extends Enableable, Refreshable, Listener, Resettable, Pauseable<Void> {

    /**
     * Get the ID for this Ability
     * @return UUID instance
     */
    UUID getID();

    /**
     * Get the ability ID for this ability
     * @return AbilityID enum
     */
    AbilityID getAbilityID();
}
