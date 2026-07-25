package net.fortresswars.helpers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;

import java.util.function.Predicate;

public class LocationHelper {

    public static double distance(Location from, Location to) {
        final World fromWorld = from.getWorld();
        final World toWorld = to.getWorld();
        if (fromWorld != toWorld) return Integer.MAX_VALUE;
        return from.distance(to);
    }

    /**
     * Get the distance the entity is from the ground. Starts checking at the entity's location and subtracts
     * the accuracy from the y each time it checks
     * @param entity the entity to check
     * @param accuracy the accuracy.
     * @return the distance from the ground
     */
    public static double getDistanceFromGround(Entity entity, double accuracy) {
        if (entity.isOnGround()) return 0;
        Location loc = entity.getLocation();
        return getDistanceFromGround(loc, accuracy);
    }

    /**
     * Get the distance the location is from the ground. Starts checking at the location and subtracts
     * the accuracy from the y each time it checks
     * @param location the location to check
     * @param accuracy the accuracy.
     * @return the distance from the ground
     */
    public static double getDistanceFromGround(Location location, double accuracy) {
        Location loc = location.clone();
        double distance = 0;
        for (double i = loc.getY(); i >= -64; i -= Math.max(0.1, accuracy)) {
            loc.setY(i);
            distance += accuracy;
            if (loc.getBlock().getType().isSolid()) break;
        }
        return distance;
    }

    public static Location getRandomTeleportLocationForPlayer(Location fromLocation, double minRadius, double maxRadius, double maxBlocksDown, double maxBlocksUp, int maxAttempts, Predicate<Location> predicate) {
        final World world = fromLocation.getWorld();
        final double locationX = fromLocation.getX();
        final double locationY = fromLocation.getY();
        final double locationZ = fromLocation.getZ();
        final float locationYaw = fromLocation.getYaw();
        final float locationPitch = fromLocation.getPitch();

        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            // Random Point
            final double newRadius = minRadius + (maxRadius - minRadius) * Math.sqrt(Math.random());
            final double theta = Math.random() * 2 * Math.PI;
            final double newX = locationX + newRadius * Math.cos(theta);
            final double newZ = locationZ + newRadius * Math.sin(theta);

            final Location newLocation = new Location(world, newX, locationY, newZ, locationYaw, locationPitch);
            final Location newBlockLocation = new Location(
                    world,
                    newLocation.getBlockX(),
                    locationY,
                    newLocation.getBlockZ(),
                    locationYaw,
                    locationPitch
            ).add(0.5, 0, 0.5);
            final Location safeLocation = getClosestSafeLocationInXZ(newBlockLocation, maxBlocksDown, maxBlocksUp);
            if (safeLocation == null) continue;
            if (!predicate.test(safeLocation)) continue;
            return safeLocation;
        }
        return null;
    }

    public static boolean isSafeLocation(Location location) {
        if (location == null) return false;
        final Block feetBlock = location.getBlock();
        final Material feetMaterial = feetBlock.getType();
        if (feetMaterial.isSolid()) return false;

        final Block headBlock = feetBlock.getRelative(BlockFace.UP);
        final Material headMaterial = headBlock.getType();
        if (headMaterial.isSolid()) return false;

        final Block groundBlock = feetBlock.getRelative(BlockFace.DOWN);
        final Material groundMaterial = groundBlock.getType();
        return groundMaterial.isSolid() || BlockHelper.isOnlyWater(groundBlock.getBlockData());
    }

    public static Location getClosestSafeLocationInXZ(Location location, double maxBlocksDown, double maxBlocksUp) {
        if (isSafeLocation(location)) return location;
        double downCounter = 0;
        double upCounter = 0;
        for (double safeCounter = 0; safeCounter < 100; safeCounter++) {
            // Check if we should break
            if (downCounter > maxBlocksDown && upCounter > maxBlocksUp) {
                break;
            }

            // Check Down
            if (downCounter <= maxBlocksDown) {
                final Location newLocation = location.clone().subtract(0, downCounter, 0);
                final Location blockTopLocation = BlockHelper.getBlockTopLocation(newLocation.getBlock());
                blockTopLocation.setYaw(location.getYaw());
                blockTopLocation.setPitch(location.getPitch());
                if (isSafeLocation(blockTopLocation)) return blockTopLocation;
                downCounter++;
            }

            // Check Up
            if (upCounter <= maxBlocksUp) {
                final Location newLocation = location.clone().add(0, upCounter, 0);
                final Location blockTopLocation = BlockHelper.getBlockTopLocation(newLocation.getBlock());
                blockTopLocation.setYaw(location.getYaw());
                blockTopLocation.setPitch(location.getPitch());
                if (isSafeLocation(blockTopLocation)) return blockTopLocation;
                upCounter++;
            }
        }
        return null;
    }

    public static boolean isInWorld(Entity entity, World world) {
        if (entity == null) return false;
        if (world == null) return false;
        final var entityWorld = entity.getWorld();
        return world.getUID().equals(entityWorld.getUID());
    }
}
