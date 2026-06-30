package net.fortresswars.helpers;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.util.BoundingBox;

public class BlockHelper {

    public static boolean isZeroZero(Location location) {
        return location.getX() == 0 && location.getY() == 0 && location.getZ() == 0;
    }

    public static Location getBlockCenterLocation(Block block) {
        final BoundingBox boundingBox = block.getBoundingBox();
        final World world = block.getWorld();
        final Location newLocation = new Location(world, boundingBox.getCenterX(), boundingBox.getCenterY(), boundingBox.getCenterZ());

        // Check if zero, zero (This will happen for blocks such as air blocks)
        if (!isZeroZero(newLocation)) {
            return newLocation;
        }
        final Location blockLocation = block.getLocation();
        return blockLocation.add(0.5, 0.5, 0.5);
    }

    public static Location getBlockTopLocation(Block block) {
        final BoundingBox boundingBox = block.getBoundingBox();
        final World world = block.getWorld();
        final Location newLocation = new Location(world, boundingBox.getCenterX(), boundingBox.getMaxY(), boundingBox.getCenterZ());

        // Check if zero, zero (This will happen for blocks such as air blocks)
        if (!isZeroZero(newLocation)) {
            return newLocation;
        }
        final Location blockLocation = block.getLocation();
        return blockLocation.add(0.5, 1, 0.5);
    }

    public static Location getBlockBottomLocation(Block block) {
        final BoundingBox boundingBox = block.getBoundingBox();
        final World world = block.getWorld();
        final Location newLocation = new Location(world, boundingBox.getCenterX(), boundingBox.getMinY(), boundingBox.getCenterZ());

        // Check if zero, zero (This will happen for blocks such as air blocks)
        if (!isZeroZero(newLocation)) {
            return newLocation;
        }
        final Location blockLocation = block.getLocation();
        return blockLocation.add(0.5, 0, 0.5);
    }
}
