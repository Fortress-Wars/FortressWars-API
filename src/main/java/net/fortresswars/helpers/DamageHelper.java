package net.fortresswars.helpers;

import net.fortresswars.core.damage.FWDamageCause;
import net.fortresswars.core.data.PersistentData;
import net.fortresswars.core.data.PersistentDataKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;

public class DamageHelper {

    public static double getDamageDataFromEntity(Entity entity, double defaultValue) {
        // Attack Damage
        var damage = defaultValue;
        final var pdv = PersistentData.getProperty(entity, PersistentDataKey.DAMAGE);
        if (!pdv.isEmpty()) {
            damage = pdv.asDouble();
        } else if (entity instanceof LivingEntity livingEntity) {
            final var attribute = livingEntity.getAttribute(Attribute.ATTACK_DAMAGE);
            if (attribute != null) {
                damage = attribute.getValue();
            }
        } else if (entity instanceof Arrow arrow) {
            damage = estimateVanillaArrowDamage(arrow);
        }

        // Attack Cooldown
        var cooldownMultiplier = 1.0;
        if (entity instanceof HumanEntity humanEntity) {
            double cooldown = Math.clamp(humanEntity.getAttackCooldown(), 0.0, 1.0);
            cooldownMultiplier = 0.2 + (cooldown * cooldown) * 0.8;
        }

        // Final Damage
        return damage * cooldownMultiplier;
    }

    public static FWDamageCause getDamageCauseDataFromEntity(Entity entity, FWDamageCause defaultValue) {
        if (entity == null) return defaultValue;

        final var pdv = PersistentData.getProperty(entity, PersistentDataKey.DAMAGE_CAUSE);
        if (pdv.isEmpty()) return defaultValue;

        final var damageCauseString = pdv.asString();
        return FWDamageCause.fromString(damageCauseString);
    }

    public static double estimateVanillaArrowDamage(Arrow arrow) {
        final var velocity = arrow.getVelocity();
        final double speed = velocity.length();

        // Vanilla arrow damage scales with speed (roughly ceil(speed * baseDamage))
        // Arrow#getDamage() reflects the arrow's base damage attribute/value in modern Paper/Spigot
        final double baseDamage = arrow.getDamage();
        double damage = speed * baseDamage;

        if (arrow.isCritical()) {
            // Vanilla crits add random bonus damage up to ~half damage + 2; average/cap example:
            damage += (damage * 0.5) + 1.0;
        }

        return Math.max(0.0, damage);
    }
}
