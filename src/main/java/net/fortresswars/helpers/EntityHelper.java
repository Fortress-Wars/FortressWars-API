package net.fortresswars.helpers;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.util.BoundingBox;

public class EntityHelper {

    public static boolean isVanished(Player player) {
        for (MetadataValue meta : player.getMetadata("vanished")) {
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
}
