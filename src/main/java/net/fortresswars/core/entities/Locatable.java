package net.fortresswars.core.entities;

import org.bukkit.Location;

import javax.annotation.Nullable;

public interface Locatable {

    /**
     * Get the minecraft location of this class.
     * @return The location
     */
    Location getLocation();

    /**
     * Get the distance between another locatable
     * @param other the other locatable
     * @return the distance.
     */
    double distance(@Nullable Locatable other);
}
