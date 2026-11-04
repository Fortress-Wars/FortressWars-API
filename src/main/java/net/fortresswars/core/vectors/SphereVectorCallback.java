package net.fortresswars.core.vectors;

import org.bukkit.Location;
import org.bukkit.util.Vector;

public interface SphereVectorCallback {

    void run(Location location, Vector vector);
}
