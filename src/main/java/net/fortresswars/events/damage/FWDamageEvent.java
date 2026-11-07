package net.fortresswars.events.damage;

import net.fortresswars.core.damage.DamageType;
import net.fortresswars.core.damage.FWDamageCause;
import net.fortresswars.core.damage.FWDamageModifier;
import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.core.kits.abilities.shields.ShieldDamageType;
import net.fortresswars.events.FortressWarsCancellableEvent;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.damage.DamageSource;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FWDamageEvent extends FortressWarsCancellableEvent {

    private final static double MIN_DAMAGE_FROM_MAX_ARMOR_PERCENTAGE = 0.5;

    private final FortressWarsEntity entity;
    private final boolean doesDamageHitShield;
    private final EntityDamageEvent.DamageCause minecraftCause;
    private FWDamageCause damageCause;

    private final Map<FWDamageModifier, Double> damageAdditiveModifiers;
    private final Map<FWDamageModifier, Double> damageMultiplierModifiers;
    private final Map<DamageType, Double> damageTypeModifiers;

    private ShieldDamageType shieldDamageType;
    private double damage;
    private Set<DamageType> damageTypes;

    private boolean hasBeenTracked;

    /**
     * Called when a FortressWarsEntity takes damage.
     * @param entity entity being damaged
     * @param damageCause type of damage
     * @param damageThatHitShield damage that hit the shield (from spigot DamageModifier)
     * @param damage amount of damage
     */
    public FWDamageEvent(
            FortressWarsEntity entity,
            FWDamageCause damageCause,
            EntityDamageEvent.DamageCause minecraftCause,
            double damageThatHitShield,
            double damage
    ) {
        this.entity = entity;
        this.damageCause = damageCause;
        this.minecraftCause = minecraftCause;
        this.damage = Math.max(damage, 0);
        this.shieldDamageType = damageCause.getShieldDamageType();
        this.damageTypes = new HashSet<>(damageCause.getDamageTypes());
        damageAdditiveModifiers = new HashMap<>();
        damageMultiplierModifiers = new HashMap<>();
        damageTypeModifiers = new HashMap<>();

        this.doesDamageHitShield = entity.isBlocking() && (damageThatHitShield > 0 || minecraftCause == EntityDamageEvent.DamageCause.CUSTOM);
    }

    public static double getEntityArmorPoints(Entity entity) {
        if (!(entity instanceof LivingEntity le)) return 0;
        final AttributeInstance armorAttribute = le.getAttribute(Attribute.ARMOR);
        if (armorAttribute == null) return 0;
        return armorAttribute.getValue();
    }

    public FortressWarsEntity getEntity() {
        return entity;
    }

    public FWDamageCause getDamageCause() {
        return damageCause;
    }

    public double getBaseDamage() {
        return damage;
    }

    public EntityDamageEvent.DamageCause getMinecraftCause() {
        return minecraftCause;
    }

    public void setBaseDamage(double damage) {
        this.damage = Math.max(damage, 0);
        if (damage == 0) {
            this.damageAdditiveModifiers.clear();
            this.damageMultiplierModifiers.clear();
        }
    }

    public void addAdditiveModifier(FWDamageModifier modifier, double additive) {
        final double currentModifierValue = getAdditiveModifier(modifier);
        damageAdditiveModifiers.put(modifier, currentModifierValue + additive);
    }

    public void addMultiplierModifier(FWDamageModifier modifier, double multiplier) {
        final double currentModifierValue = getMultiplierModifier(modifier);
        damageMultiplierModifiers.put(modifier, currentModifierValue + multiplier);
    }

    public void addDamageTypeModifier(DamageType damageType, double multiplier) {
        final double currentModifierValue = getDamageTypeModifier(damageType);
        damageTypeModifiers.put(damageType, currentModifierValue + multiplier);
    }

    public void removeAdditiveModifier(FWDamageModifier modifier, double additive) {
        final double currentModifierValue = getAdditiveModifier(modifier);
        damageMultiplierModifiers.put(modifier, currentModifierValue - additive);
    }

    public void removeMultiplierModifier(FWDamageModifier modifier, double multiplier) {
        final double currentModifierValue = getMultiplierModifier(modifier);
        damageMultiplierModifiers.put(modifier, currentModifierValue - multiplier);
    }

    public void removeDamageTypeModifier(DamageType damageType, double multiplier) {
        final double currentModifierValue = getDamageTypeModifier(damageType);
        damageTypeModifiers.put(damageType, currentModifierValue - multiplier);
    }

    public void resetAdditiveModifier(FWDamageModifier modifier) {
        damageAdditiveModifiers.remove(modifier);
    }

    public void resetMultiplierModifier(FWDamageModifier modifier) {
        damageMultiplierModifiers.remove(modifier);
    }

    public void resetDamageTypeModifier(DamageType modifier) {
        damageTypeModifiers.remove(modifier);
    }

    public void clearAdditiveModifiers() {
        damageAdditiveModifiers.clear();
    }

    public void clearMultiplierModifiers() {
        damageMultiplierModifiers.clear();
    }

    public void clearDamageTypeModifiers() {
        damageTypeModifiers.clear();
    }

    public double getAdditiveModifier(FWDamageModifier modifier) {
        return damageAdditiveModifiers.getOrDefault(modifier, 0d);
    }

    public double getMultiplierModifier(FWDamageModifier modifier) {
        return damageMultiplierModifiers.getOrDefault(modifier, 0d);
    }

    public double getDamageTypeModifier(DamageType damageType) {
        return Math.max(0, damageTypeModifiers.getOrDefault(damageType, 1d)); // Default to x1, can't go below 0
    }

    public boolean hasAdditiveModifier(FWDamageModifier modifier) {
        return damageAdditiveModifiers.containsKey(modifier);
    }

    public boolean hasMultiplierModifier(FWDamageModifier modifier) {
        return damageMultiplierModifiers.containsKey(modifier);
    }

    public double calculateCombinedAdditiveModifier() {
        double totalAdditiveMultiplier = 0;
        for (FWDamageModifier modifier : damageAdditiveModifiers.keySet()) {
            final double currentModifierValue = getAdditiveModifier(modifier);
            totalAdditiveMultiplier += currentModifierValue;
        }
        return totalAdditiveMultiplier;
    }

    public double calculateCombinedMultiplierModifier() {
        double totalMultiplierModifier = 1;
        for (FWDamageModifier modifier : damageMultiplierModifiers.keySet()) {
            final double currentModifierValue = getMultiplierModifier(modifier);
            totalMultiplierModifier += currentModifierValue;
        }
        return totalMultiplierModifier;
    }

    public double calculateCombinedDamageTypeModifier() {
        final int numberOfDamageTypes = this.damageTypes.size();

        // Get all damage types and their parents
        final Set<DamageType> familyTypes = DamageType.getParents(this.damageTypes);

        // Stack all damage multipliers
        return familyTypes.stream()
                .mapToDouble(this::getDamageTypeModifier) // Get damage modifier
                .reduce(1.0, (a, b) -> (a > 0 && b > 0) ? a * b : 0); // reduce to multiple all the modifiers together
    }

    public void setShieldDamageType(ShieldDamageType shieldDamageType) {
        if (shieldDamageType == null) return;
        this.shieldDamageType = shieldDamageType;
    }

    public double getDamageModifierDelta(FWDamageModifier damageModifier) {
        // Damage can't be negative
        final double multiplier = 1 - getMultiplierModifier(damageModifier);
        final double additive = getAdditiveModifier(damageModifier);

        return Math.max(damage * multiplier + additive, 0) - damage;
    }

    /**
     * Gets the list of damage modifiers
     * @return All damage modifiers;
     */
    public Set<FWDamageModifier> getModifiers() {
        final Set<FWDamageModifier> modifiers = new HashSet<>();
        modifiers.addAll(damageMultiplierModifiers.keySet());
        modifiers.addAll(damageAdditiveModifiers.keySet());
        return modifiers;
    }

    public ShieldDamageType getShieldDamageType() {
        return shieldDamageType;
    }

    public double getAdjustedBaseDamage() {
        final double finalBaseDamage = (damage * calculateCombinedMultiplierModifier()) + calculateCombinedAdditiveModifier();
        return  Math.max(0, finalBaseDamage * calculateCombinedDamageTypeModifier());
    }

    private double calculateCustomArmorDamage(double damage, double armorPoints) {
        final double minDamage = damage * MIN_DAMAGE_FROM_MAX_ARMOR_PERCENTAGE;
        final double maxDamage = damage * 1;

        final double minArmor = 0;
        final double maxArmor = 20;

        if (armorPoints <= minArmor) return maxDamage;
        if (armorPoints >= maxArmor) return minDamage;

        // Any armor above 20 won't be considered
        final double normalizedArmorPoints = (armorPoints - minArmor) / (maxArmor - minArmor);
        return normalizedArmorPoints * minDamage + (1.0 - normalizedArmorPoints) * maxDamage;
    }

    public double getDamage() {
        if (!shieldDamageType.doesEntityDamage()) return 0;

        // To check if the damage is blocked, we need to check if the damage hit the shield and if the damage doesn't go through the shield
        if ((doesDamageHitShield && !shieldDamageType.doesDamageIfBlocking())) return 0;

        if (damageTypes.contains(DamageType.STATIC)) return damage;

        double adjustedDamage = getAdjustedBaseDamage();

        // Calculate with armor points because CUSTOM doesn't consider armor points
        if (minecraftCause == EntityDamageEvent.DamageCause.CUSTOM && damageTypes.contains(DamageType.PHYSICAL)) {
            final Entity e = entity.getEntity();
            final double armorPoints = getEntityArmorPoints(e);
            adjustedDamage = calculateCustomArmorDamage(adjustedDamage, armorPoints);
        }

        return Math.max(0, adjustedDamage);
    }

    public double getFinalDamage() {
        final Entity e = entity.getEntity();
        final DamageSource damageSource = DamageSource.builder(org.bukkit.damage.DamageType.GENERIC).build();
        final EntityDamageEvent event = new EntityDamageEvent(e, minecraftCause, damageSource, getAdjustedBaseDamage());
        return Math.min(event.getFinalDamage(), entity.getMaxHealth());
    }

    public boolean doesDamageHitShield() {
        return doesDamageHitShield;
    }

    /**
     * Sets the damage type. This function will also set the shieldDamageType and damageTypes
     * to the respective values of the new fwDamageCause
     * @param fwDamageCause new fw damage cause to set
     */
    public void setDamageCause(FWDamageCause fwDamageCause) {
        this.damageCause = fwDamageCause;
        this.shieldDamageType = fwDamageCause.getShieldDamageType();
        this.damageTypes = new HashSet<>(fwDamageCause.getDamageTypes());
    }

    /**
     * Check the provided type is a type in this event.
     * @param damageType the damage type to check
     * @return true if the damage type is in the list of damage types or is a child or parent of the types.
     */
    public boolean containsDamageType(DamageType damageType) {
        return DamageType.getParents(this.damageTypes).contains(damageType);
    }

    /**
     * Gets all damage types in this event
     * @return the set of damage types and its parents and children
     */
    public Set<DamageType> getDamageTypes() {
        return new HashSet<>(DamageType.getParents(this.damageTypes));
    }

    /**
     * Adds a damage type to the base set.
     * @param damageType the damage type to add.
     */
    public void addDamageType(DamageType damageType) {
        damageTypes.add(damageType);
    }

    public boolean hasBeenTracked() {
        return hasBeenTracked;
    }

    public void setTracked() {
        hasBeenTracked = true;
    }
}
