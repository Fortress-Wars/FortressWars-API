package net.fortresswars.helpers;

import net.fortresswars.core.damage.FWDamageCause;
import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.core.entities.Hackable;
import net.fortresswars.core.entities.Stunnable;
import net.fortresswars.data.PersistentData;
import net.fortresswars.data.PersistentDataKey;
import net.fortresswars.events.damage.FWDamageByEntityEvent;
import net.fortresswars.util.PauseableTask;
import net.kyori.adventure.util.TriState;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class EntityHelper {

    private static Entity refEntity;

    private static Entity getRefEntity() {
        if (refEntity == null) {
            final World world = Bukkit.getWorlds().getFirst();
            refEntity = world.spawnEntity(world.getSpawnLocation(), EntityType.TEXT_DISPLAY);
            refEntity.remove();
        }
        return refEntity;
    }

    public static int getNextEntityID() {
        try {
            // CraftTextDisplay -> CraftDisplay -> CraftEntity
            final Entity refEntity = getRefEntity();
            final Class<?> craftEntityClass = refEntity.getClass().getSuperclass().getSuperclass();
            final Field minecraftEntityField = craftEntityClass.getDeclaredField("entity");
            final Class<?> minecraftEntityClass = minecraftEntityField.getType();
            final Field minecraftEntityCounterField = minecraftEntityClass.getDeclaredField("ENTITY_COUNTER");
            minecraftEntityCounterField.setAccessible(true);
            final AtomicInteger minecraftEntityCounter = (AtomicInteger) minecraftEntityCounterField.get(refEntity);
            minecraftEntityCounterField.setAccessible(false);
            return minecraftEntityCounter.incrementAndGet();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

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

    public static boolean isCriticalHealth(LivingEntity entity) {
        final AttributeInstance ai = entity.getAttribute(Attribute.MAX_HEALTH);
        if (ai == null) return false;
        final double maxHealth = ai.getValue();
        return entity.getHealth() <= maxHealth / 2;
    }

    /**
     * Fire is visual when the fire ticks is above 0, however, because the fire ticks only deal damage every 20 ticks,
     * the can have visual fire and not take any damage if the fire ticks is set anywhere between 1 and 19 ticks
     * @param entity entity to check if burning
     * @return if the player has visual fire
     */
    public static boolean hasVisualFire(Entity entity) {
        return entity.getFireTicks() > 0 || entity.getVisualFire() == TriState.TRUE;
    }

    public static ChatColor getHealthStatusColor(LivingEntity entity) {
        if (hasVisualFire(entity)) return ChatColor.GOLD;
        if (entity.hasPotionEffect(PotionEffectType.POISON)) return ChatColor.DARK_GREEN;
        if (entity.hasPotionEffect(PotionEffectType.WITHER)) return ChatColor.BLACK;
        if (entity.isFrozen()) return ChatColor.AQUA;
        if (isCriticalHealth(entity)) return ChatColor.RED;
        return ChatColor.GREEN;
    }

    /**
     * Reset a player's state
     * @param player the player whose state we should reset
     */
    public static void resetPlayerState(Player player) {
        player.setHealth(20);
        player.setFreezeTicks(0);
        player.setFireTicks(0);
        player.setAllowFlight(false);
        player.setFlySpeed(0.1f);
        player.setWalkSpeed(0.2f);
        player.setLevel(0);
        player.setExp(0f);
        player.clearActivePotionEffects();
        ScaleHelper.reset(player);
    }

    /**
     * Get if an entity is visible.
     * @param entity the entity to check.
     * @return true if the entity is visiable.
     */
    public static boolean isVisible(Entity entity) {
        if (entity == null) return false;
        if (!(entity instanceof LivingEntity livingEntity)) return true;

        final boolean hasInvisibility = livingEntity.hasPotionEffect(PotionEffectType.INVISIBILITY);
        final boolean hasGlowing = livingEntity.hasPotionEffect(PotionEffectType.GLOWING);
        return !hasInvisibility || hasGlowing || hasVisualFire(livingEntity);
    }

    /**
     * If the entity's frozen ticks are above its max freeze ticks
     * @param entity the entity to check if frozen
     * @return ture if frozen, false otherwise
     */
    public static boolean isFrozen(Entity entity) {
        return entity.getFreezeTicks() >= entity.getMaxFreezeTicks();
    }

    /**
     * If the entity has freeze ticks
     * @param entity the entity to check if freezing
     * @return true if freezing, false otherwise
     */
    public static boolean isFreezing(Entity entity) {
        return entity.getFreezeTicks() > 0;
    }

    /**
     * Freeze the target
     * @param target the target to freeze
     * @param source the source of the freeze
     * @param ticks duration to freeze for
     * @return true if the entity was successfully frozen
     */
    public static boolean freeze(FortressWarsEntity target, FortressWarsEntity source, int ticks) {
        if (target == null || source == null || ticks <= 0) return false;

        final Entity targetEntity = target.getEntity();
        final int currentFreezeTicks = targetEntity.getFreezeTicks();
        final int newTicks = ticks + targetEntity.getMaxFreezeTicks();
        final boolean wasFrozen = isFrozen(targetEntity);

        if (newTicks > currentFreezeTicks) {
            FWDamageByEntityEvent fwDamageByEntityEvent = new FWDamageByEntityEvent(
                    target,
                    source,
                    FWDamageCause.ENVIRONMENTAL,
                    EntityDamageEvent.DamageCause.FREEZE,
                    0,
                    0
            );
            target.setLastDamageEvent(fwDamageByEntityEvent);
            targetEntity.setFreezeTicks(newTicks);
        } else {
            target.addAssist(source);
        }

        return newTicks > currentFreezeTicks && !wasFrozen;
    }

    /**
     * Get whether the entity is ignited or not. Ignited means that they have visual fire,
     * and they will take at least one fire damage tick. (The entity's fire ticks is > 20)
     * @param entity entity to check if ignited
     * @return true if they are ignited, false otherwise
     */
    public static boolean isIgnited(Entity entity) {
        return entity.getFireTicks() > 20;
    }

    /**
     * Ignite an entity. This method will add assist tags and set the last damage
     * @param targetFWE entity being ignited
     * @param sourceEntity source entity of the burning
     * @param ticks burning ticks
     * @return true if the target entity was ignited
     */
    public static boolean ignite(FortressWarsEntity targetFWE, FortressWarsEntity sourceEntity, int ticks) {
        if (targetFWE == null || sourceEntity == null || ticks <= 0) return false;
        final Entity targetEntity = targetFWE.getEntity();
        final int currentFireTicks = targetEntity.getFireTicks();
        final boolean wasIgnited = isIgnited(targetEntity);
        if (ticks > currentFireTicks) {
            FWDamageByEntityEvent fwDamageByEntityEvent = new FWDamageByEntityEvent(
                    targetFWE,
                    sourceEntity,
                    FWDamageCause.ENVIRONMENTAL,
                    EntityDamageEvent.DamageCause.FIRE,
                    0,
                    0
            );
            targetFWE.setLastDamageEvent(fwDamageByEntityEvent);
            targetEntity.setFireTicks(ticks);
        } else {
            targetFWE.addAssist(sourceEntity);
        }

        return ticks > currentFireTicks && !wasIgnited;
    }

    /**
     * Ignite the entity
     * @param entity entity to ignite
     * @param ticks the duration, in ticks, to ignite the entity for. The result fire ticks will be the max
     *              of the current fire ticks and ticks parameter
     * @return true if the player was reignited, false otherwise. A reignition is only if the player ws not
     * already on fire. In this case if the current fire ticks is less than 20.
     */
    public static boolean ignite(Entity entity, int ticks) {
        if (entity == null) return false;
        if (ticks <= 0) return false;
        final int currentFireTicks = entity.getFireTicks();
        final boolean wasIgnited = isIgnited(entity);

        if (ticks > currentFireTicks) {
            entity.setFireTicks(ticks);
        }

        return ticks > currentFireTicks && !wasIgnited;
    }

    /**
     * Extinguish an entity
     * @param entity entity to extinguish
     * @return true if the entity was extinguished, false if the entity was not extinguished
     */
    public static boolean extinguish(Entity entity) {
        if (entity == null) return false;
        final int currentFireTicks = entity.getFireTicks();
        entity.setFireTicks(0);
        return currentFireTicks > 0;
    }

    /**
     * Grant the player flight, by setting allow flight to true
     * @param player the player to grant flight
     * @param shouldImmediatelyToggleFlight if the method should set flying to true
     * @return if the player's flight status was granted
     */
    public static boolean grantFlight(Player player, boolean shouldImmediatelyToggleFlight) {
        return grantFlight(player, shouldImmediatelyToggleFlight, 0.1f);
    }

    /**
     * Grant the player flight, by setting allow flight to true
     * @param player the player to grant flight
     * @param shouldImmediatelyToggleFlight if the method should set flying to true
     * @param speed the speed of the flight
     * @return if the player's flight status was granted
     */
    public static boolean grantFlight(Player player, boolean shouldImmediatelyToggleFlight, float speed) {
        if (player == null) return false;
        if (speed <= 0) return false;
        player.setAllowFlight(true);
        player.setFlying(shouldImmediatelyToggleFlight);
        player.setFlySpeed(speed);
        return true;
    }

    /**
     * Revoke the player's flight statuys
     * @param player the player to revoke flight
     * @return if the player's flight status was revoked
     */
    public static boolean revokeFlight(Player player) {
        if (player == null) return false;
        player.setAllowFlight(false);
        player.setFlying(false);
        player.setFlySpeed(0.1f);
        return true;
    }

    public static RayTraceResult rayTraceProjectile(Entity entity, Projectile projectile) {
        return entity.getBoundingBox().rayTrace(
                projectile.getLocation().clone().toVector(),
                projectile.getVelocity(),
                5
        );
    }

    public static boolean isHeadshot(Entity entity, Projectile projectile) {
        if (!(entity instanceof LivingEntity livingEntity)) return false;
        Vector hitPos = projectile.getLocation().toVector();
        final RayTraceResult rayTraceResult = rayTraceProjectile(livingEntity, projectile);
        if (rayTraceResult != null) {
            hitPos = rayTraceResult.getHitPosition();
        }

        final double leHeight = livingEntity.getHeight();
        final double eyePosition = livingEntity.getEyeHeight();
        final double headShotThreshold = 2 * (leHeight - eyePosition);

        final double hitY = hitPos.getY();
        final double leY = livingEntity.getLocation().getY();
        return (hitY - leY) > leHeight - headShotThreshold;
    }

    public static boolean isKneeShot(Entity entity, Projectile projectile) {
        if (!(entity instanceof LivingEntity livingEntity)) return false;
        Vector hitPos = projectile.getLocation().toVector();
        final RayTraceResult rayTraceResult = rayTraceProjectile(livingEntity, projectile);
        if (rayTraceResult != null) {
            hitPos = rayTraceResult.getHitPosition();
        }

        final double leHeight = livingEntity.getHeight();
        final double kneeMin = leHeight * 0.15;
        final double kneeMax = leHeight * 0.3;
        final double hitY = hitPos.getY();
        final double leY = livingEntity.getLocation().getY();
        return (hitY - leY) > kneeMin && (hitY - leY) < kneeMax;
    }

    /**
     * Returns the LivingEntity reference of the shooter of a projectile
     * @param projectile projectile to get Entity reference from
     * @return LivingEntity reference, null if shooter is not an Entity
     */
    public static LivingEntity getEntityShooter(Projectile projectile) {
        if (projectile == null) return null;
        ProjectileSource shooter = projectile.getShooter();
        if (!(shooter instanceof LivingEntity)) return null;
        return (LivingEntity) shooter;
    }

    /**
     * Check if a Stunnable is the specified FortressWarsEntity
     * @param stunnable object
     * @param fwe FortressWarsEntity to check
     * @return true if this stunnble is the fwe, false otherwise
     */
    public static boolean isStunnableThisFWE(Stunnable stunnable, FortressWarsEntity fwe) {
        if (!(stunnable instanceof FortressWarsEntity stunnableFWE)) return false;
        return stunnableFWE.getUUID().equals(fwe.getUUID());
    }

    /**
     * Check if a Hackable is the specified FortressWarsEntity
     * @param hackable object
     * @param fwe FortressWarsEntity to check
     * @return true if this hackable is the fwe, false otherwise
     */
    public static boolean isHackableThisFWE(Hackable hackable, FortressWarsEntity fwe) {
        if (!(hackable instanceof FortressWarsEntity hackableFWE)) return false;
        return hackableFWE.getUUID().equals(fwe.getUUID());
    }

    /**
     * Get the armor points of the entity
     * @param entity the entity
     * @return the entity armor points
     */
    public static double getEntityArmorPoints(Entity entity) {
        if (!(entity instanceof LivingEntity le)) return 0;
        final AttributeInstance armorAttribute = le.getAttribute(Attribute.ARMOR);
        if (armorAttribute == null) return 0;
        return armorAttribute.getValue();
    }

    /**
     * Remove an entity after a delay
     * @param entity the entity to remove
     * @param delay the delay after which the entity should be removed
     * @return a pauseable task
     */
    public static PauseableTask removeEntityAfterDelay(JavaPlugin plugin, Entity entity, int delay) {
        return PauseableTask.createTask(() -> {
            if (entity == null) return;
            entity.remove();
        }).runTaskLater(plugin, delay);
    }

    /**
     * Set an internal cooldown for an entity
     * @param entity the entity to which the cooldown should be applied
     * @param key the key of the internal cooldown
     * @param cooldown the duration of the cooldown
     */
    public static void setInternalCooldown(Entity entity, NamespacedKey key, long cooldown) {
        final long currentTime = new Date().getTime();
        PersistentData.setProperty(entity, PersistentDataKey.TIME, currentTime, key);
        PersistentData.setProperty(entity, PersistentDataKey.COOLDOWN, cooldown, key);
    }

    /**
     * Get if an entity has an internal cooldown.
     * @param entity the entity to check
     * @param key the key of the internal cooldown
     * @return true if the cooldown is active, false otherwise.
     */
    public static boolean hasInternalCooldown(Entity entity, NamespacedKey key) {
        final long cooldownDuration = PersistentData.getProperty(entity, PersistentDataKey.COOLDOWN, key).asLong();
        final long cooldownStartTime = PersistentData.getProperty(entity, PersistentDataKey.TIME, key).asLong();
        final long currentTime = new Date().getTime();
        final long elapsedTime = currentTime - cooldownStartTime;
        return cooldownDuration - elapsedTime > 0;
    }

    /**
     * Remove an internal cooldown from an entity
     * @param entity the entity from which to remove the cooldown
     * @param key the key of the internal cooldown
     */
    public static void removeInternalCooldown(Entity entity, NamespacedKey key) {
        PersistentData.removeData(entity, Set.of(PersistentDataKey.TIME, PersistentDataKey.COOLDOWN), key);
    }
}
