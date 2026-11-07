package net.fortresswars.helpers;

import net.fortresswars.FortressWarsAPI;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EquipmentSlotGroup;

import java.util.Set;

public class ScaleHelper {

    private final static double MIN_SCALAR = 1.0/12;
    private final static double MAX_SCALAR = 12;
    private final static Set<Attribute> ATTRIBUTES = Set.of(
            Attribute.BLOCK_INTERACTION_RANGE,
            Attribute.ENTITY_INTERACTION_RANGE,
            Attribute.FALL_DAMAGE_MULTIPLIER,
            Attribute.JUMP_STRENGTH,
            Attribute.MOVEMENT_SPEED,
            Attribute.SAFE_FALL_DISTANCE,
            Attribute.SCALE,
            Attribute.STEP_HEIGHT,
            Attribute.GRAVITY
    );
    private final static Set<Attribute> INVERTED_ATTRIBUTES = Set.of(
            Attribute.FALL_DAMAGE_MULTIPLIER
    );

    /**
     * Set the scale of an entity. This function modifies every attribute relating to size.
     * @param livingEntity the living entity
     * @param value the value
     * @return true if successful, false if not.
     */
    public static boolean scale(LivingEntity livingEntity, double value) {
        if (livingEntity == null) return false;

        // Sanitize Multiplier
        final double sanitizedMultiplier = Math.clamp(value, MIN_SCALAR, MAX_SCALAR);

        // Set Attributes
        for (Attribute attribute : ATTRIBUTES) {
            final AttributeInstance attributeInstance = livingEntity.getAttribute(attribute);
            if (attributeInstance == null) continue;

            // Determine the multiplier
            double multiplier = (INVERTED_ATTRIBUTES.contains(attribute) ? 1 / sanitizedMultiplier : sanitizedMultiplier);
            multiplier -= 1;

            // Set the key
            final String keyString = attribute.getKey().getKey() + "_" + livingEntity.getUniqueId().toString().toLowerCase();
            final NamespacedKey key = new NamespacedKey(FortressWarsAPI.NAMESPACE, keyString);
            final AttributeModifier attributeModifier = new AttributeModifier(
                    key,
                    multiplier,
                    AttributeModifier.Operation.ADD_SCALAR,
                    EquipmentSlotGroup.ANY
            );
            attributeInstance.removeModifier(key);
            attributeInstance.addModifier(attributeModifier);
        }
        return true;
    }

    /**
     * Reset a living entities scale attributes.
     * @param livingEntity the living entity.
     * @return true if successful, false if not.
     */
    public static boolean reset(LivingEntity livingEntity) {
        if (livingEntity == null) return false;

        // Reset Attributes
        for (Attribute attribute : ATTRIBUTES) {
            final AttributeInstance attributeInstance = livingEntity.getAttribute(attribute);
            if (attributeInstance == null) continue;
            final String keyString = attribute.getKey().getKey() + "_" + livingEntity.getUniqueId().toString().toLowerCase();
            final NamespacedKey key = new NamespacedKey(FortressWarsAPI.NAMESPACE, keyString);
            attributeInstance.removeModifier(key);
        }
        return true;
    }
}
