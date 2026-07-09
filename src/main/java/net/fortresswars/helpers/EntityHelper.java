package net.fortresswars.helpers;

import org.bukkit.Location;
import org.bukkit.World;
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
}
