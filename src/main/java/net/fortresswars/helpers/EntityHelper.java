package net.fortresswars.helpers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.BoundingBox;
import org.jetbrains.annotations.NotNull;

public class EntityHelper {

    public static boolean isVanished(Player player) {
        for (final var meta : player.getMetadata("vanished")) {
            if (meta.asBoolean()) return true;
        }
        return false;
    }

    public static Location getEntityTopLocation(Entity entity) {
        final BoundingBox boundingBox = entity.getBoundingBox();
        final double maxY = boundingBox.getMaxY();
        return getEntityLocation(entity, maxY);
    }

    public static Location getEntityCenterLocation(Entity entity) {
        final BoundingBox boundingBox = entity.getBoundingBox();
        final double centerY = boundingBox.getCenterY();
        return getEntityLocation(entity, centerY);
    }

    public static Location getEntityBottomLocation(Entity entity) {
        final BoundingBox boundingBox = entity.getBoundingBox();
        final double minY = boundingBox.getMinY();
        return getEntityLocation(entity, minY);
    }

    public static Location getEntityEyesLocation(Entity entity) {
        if (entity instanceof LivingEntity livingEntity) return livingEntity.getEyeLocation();
        return getEntityCenterLocation(entity);
    }

    private static Location getEntityLocation(Entity entity, double y) {
        final BoundingBox boundingBox = entity.getBoundingBox();
        final Location location = entity.getLocation();
        final World world = location.getWorld();
        final double centerX = boundingBox.getCenterX();
        final double centerZ = boundingBox.getCenterZ();
        return new Location(world, centerX, y, centerZ, location.getYaw(), location.getPitch());
    }

    /**
     * Get an entities volume. This returns the volume of the entity's bounding box
     * @param entity the entity
     * @return the volume in m^3
     */
    public static double getEntityVolume(@NotNull Entity entity) {
        final BoundingBox boundingBox = entity.getBoundingBox();
        return boundingBox.getHeight() * boundingBox.getWidthX() * boundingBox.getWidthZ();
    }

    /**
     * Teleport an entity to a destination. Also removes passengers if going across dimensions.
     * @param entity the entity to teleport
     * @param destination the location to teleport the entity to
     * @return true if the teleportation was successful, false otherwise
     */
    public static boolean teleport(Entity entity, Location destination) {
        if (entity == null) return false;
        if (destination == null) return false;

        // Only remove passengers of going across dimensions
        final var entityWorld = destination.getWorld();
        final var destinationWorld = destination.getWorld();
        if (entityWorld != destinationWorld) {
            for (Entity passenger : entity.getPassengers()) {
                entity.removePassenger(passenger);
            }
        }
        return entity.teleport(destination);
    }

    public static boolean isEntityInAir(Entity entity) {
        final Location location = entity.getLocation();
        final Block block = location.getBlock();
        final Material material = block.getType();
        return material.isAir();
    }
}
