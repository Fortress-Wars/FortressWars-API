package net.fortresswars.util;

import net.fortresswars.core.entities.Zappable;
import net.fortresswars.helpers.BlockHelper;
import net.fortresswars.helpers.EntityHelper;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;

import java.util.Comparator;

public class FWDistanceComparator implements Comparator<Object> {

    private final Location compareLocation;

    public FWDistanceComparator(Location compareLocation) {
        this.compareLocation = compareLocation;
    }

    @Override
    public int compare(Object o1, Object o2) {
        Location loc1 = getLocation(o1);
        Location loc2 = getLocation(o2);

        if (loc1 == null || loc2 == null) return 0;
        if (loc1.getWorld() != compareLocation.getWorld() && loc2.getWorld() != compareLocation.getWorld()) return 0;
        if (loc1.getWorld() != compareLocation.getWorld()) return 1;
        if (loc2.getWorld() != compareLocation.getWorld()) return -1;
        double distanceB1 = compareLocation.distance(loc1);
        double distanceB2 = compareLocation.distance(loc2);

        double diff = distanceB1 - distanceB2;
        if (diff < 0) return -1;
        else if (diff > 0) return 1;
        else return 0;
    }

    private Location getLocation(Object o) {
        return switch (o) {
            case Entity entity -> EntityHelper.getEntityCenterLocation(entity);
            case Zappable zappable -> zappable.getLocation();
            case Block block -> BlockHelper.getBlockCenterLocation(block);
            case null, default -> null;
        };
    }
}
