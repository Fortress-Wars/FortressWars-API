package net.fortresswars.core.entities;

import net.fortresswars.core.damage.FWDamageCause;
import org.bukkit.Location;
import org.bukkit.util.BoundingBox;

public interface Zappable extends Stunnable {

    /**
     * Get the minecraft location of this class.
     * @return The location
     */
    Location getLocation();

    /**
     * Get the bounding box of the zappable
     */
    BoundingBox getBoundingBox();

    /**
     * Damage this class
     * @param source source of the damage instance
     * @param damageCause damage cause of this damage instance
     * @param amount amount of damage to deal
     * @return the final damage that was dealt
     */
    double damage(FortressWarsEntity source, FWDamageCause damageCause, double amount);
}
