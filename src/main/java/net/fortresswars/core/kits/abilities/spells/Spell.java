package net.fortresswars.core.kits.abilities.spells;

import net.fortresswars.core.entities.Pauseable;
import net.fortresswars.core.entities.Resettable;
import net.fortresswars.core.managers.Enableable;
import net.fortresswars.util.Options;
import org.bukkit.event.Listener;

import java.util.UUID;

public interface Spell extends Listener, Enableable, Resettable, Pauseable<Void> {

    /**
     * Helper method used to see if a given UUID is the user
     * @param uuid of entity to check
     * @return true if the uuid matches this spells' user, false otherwise
     */
    boolean isSpellUser(UUID uuid);

    /**
     * Get the UUID of this spell instance
     * @return UUID
     */
    UUID getID();

    /**
     * Get the spell ID if this spell class
     * @return SpellID
     */
    SpellID getSpellID();

    /**
     * Get the spell's mana cost
     * @return mana cost in as a double
     */
    double getCost();

    /**
     * Get the spell's cast Cooldown
     * @return cooldown integer, in ticks
     */
    int getCooldown();

    /**
     * Get if the user can cast the spell or not
     * @return true if the user can cast the spell, false otherwise
     */
    boolean canCast();

    /**
     * Cast the spell
     * @param options - options to send to the spell when casting.
     *                (Useful when the same spell has different controls (Earth Wall, Wind Gust)
     * @return true if the spell was successfully cast, false otherwise
     */
    boolean cast(Options options);
}
