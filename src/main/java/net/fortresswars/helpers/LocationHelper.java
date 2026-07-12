package net.fortresswars.helpers;

import org.bukkit.Location;
import org.bukkit.World;

public class LocationHelper {

    public static double distance(Location from, Location to) {
        final World fromWorld = from.getWorld();
        final World toWorld = to.getWorld();
        if (fromWorld != toWorld) return Integer.MAX_VALUE;
        return from.distance(to);
    }
}
