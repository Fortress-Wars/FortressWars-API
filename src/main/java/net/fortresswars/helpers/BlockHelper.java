package net.fortresswars.helpers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.util.BoundingBox;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    /**
     * Get all blocks in a spherical radius
     * @param location sphere's center lcoation
     * @param radius radius of sphere
     * @return Set of blocks in the sphere
     */
    public static Set<Block> getBlocksInRadius(Location location, double radius) {
        Set<Block> blocks = new HashSet<>();
        if (location == null || radius < 0) return blocks;

        final World world = location.getWorld();
        final double bx = location.getX();
        final double by = location.getY();
        final double bz = location.getZ();

        for (double x = bx - radius; x <= bx + radius; x++) {
            for (double y = by - radius; y <= by + radius; y++) {
                for (double z = bz - radius; z <= bz + radius; z++) {
                    Location newLoc = new Location(world, x, y, z);
                    if (newLoc.distance(location) > radius) continue;
                    blocks.add(newLoc.getBlock());
                }
            }
        }
        return blocks;
    }

    /**
     * Checks if the bounding box collides with any blocks that are not passable
     * @param world world where the bounding box is located
     * @param bb bounding box to check collision for
     * @param ignorePassable if we should include blocks that are passable (pressure plates, plants, etc)
     * @return true if bounding block collides with any block, false otherwise
     */
    public static boolean doesHitBoxCollideWithBlocks(World world, BoundingBox bb, boolean ignorePassable) {
        return !getBlocksCollidingWithHitBox(world, bb, ignorePassable).isEmpty();
    }

    /**
     * Checks if the bounding box collides with any blocks that are not passable
     * @param world world where the bounding box is located
     * @param bb bounding box to check collision for
     * @param ignorePassable if we should include blocks that are passable (open gates, plants, etc)
     *                       (Note: engineer pressure plates are considered non-passable
     *                       because projectiles can damage them)
     * @return List of block that the hitbox collides with
     */
    public static List<Block> getBlocksCollidingWithHitBox(World world, BoundingBox bb, boolean ignorePassable) {
        // Get every corner
        List<Location> corners = new ArrayList<>();
        corners.add(new Location(world, bb.getMinX(), bb.getMinY(), bb.getMinZ()));
        corners.add(new Location(world, bb.getMinX(), bb.getMinY(), bb.getMaxZ()));
        corners.add(new Location(world, bb.getMinX(), bb.getMaxY(), bb.getMinZ()));
        corners.add(new Location(world, bb.getMinX(), bb.getMaxY(), bb.getMaxZ()));
        corners.add(new Location(world, bb.getMaxX(), bb.getMinY(), bb.getMinZ()));
        corners.add(new Location(world, bb.getMaxX(), bb.getMinY(), bb.getMaxZ()));
        corners.add(new Location(world, bb.getMaxX(), bb.getMaxY(), bb.getMinZ()));
        corners.add(new Location(world, bb.getMaxX(), bb.getMaxY(), bb.getMaxZ()));

        // Making a set will remove duplicates
        final Set<Block> collidingBlocksSet = new HashSet<>(8);
        // Check that all corners' blocks are passable
        for (Location corner : corners) {
            final Block cornerBlock = corner.getBlock();
            final Material material = cornerBlock.getType();
            final BoundingBox cornerBB = cornerBlock.getBoundingBox();
            boolean isPassable = cornerBlock.isPassable() || material == Material.LADDER;
            boolean isBlackListedFromPassable = material == Material.HEAVY_WEIGHTED_PRESSURE_PLATE || material == Material.LIGHT_WEIGHTED_PRESSURE_PLATE;
            if (bb.overlaps(cornerBB)) {
                if (ignorePassable && isPassable && !isBlackListedFromPassable) continue;
                collidingBlocksSet.add(cornerBlock);
            }
        }

        return collidingBlocksSet.stream().distinct().toList();
    }
}
