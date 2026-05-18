/*
 * Name: FWDamageCause
 * Author: Peter Cesmegi
 * Description: Enum for custom damage causes
 */

package net.fortresswars.core.damage;

import net.fortresswars.core.kits.abilities.shields.ShieldDamageType;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum FWDamageCause {
    AIR_GUST(
            ShieldDamageType.RESPECT,
            Set.of(DamageType.ARCANE, DamageType.AIR)
    ),
    AQUAMAN_TRIDENT(
            ShieldDamageType.DAMAGE,
            Set.of(DamageType.IMPALING)
    ),
    AQUAMAN_TRIDENT_FAR(
            ShieldDamageType.DAMAGE,
            Set.of(DamageType.IMPALING)
    ),
    AQUAMAN_TRIDENT_MELEE(
            ShieldDamageType.DAMAGE,
            Set.of(DamageType.IMPALING, DamageType.SLASHING)
    ),
    AQUAMAN_TRIDENT_WATER_MELEE(
            ShieldDamageType.DAMAGE,
            Set.of(DamageType.IMPALING, DamageType.SLASHING)
    ),
    AXE_SWIRL(
            ShieldDamageType.BREAK,
            Set.of(DamageType.SLASHING)
    ),
    BLOOD_BOND_BREAK(
            ShieldDamageType.IGNORE,
            Set.of(DamageType.BLOOD)
    ),
    BLOOD_TRANSFUSION(
            ShieldDamageType.IGNORE,
            Set.of(DamageType.BLOOD, DamageType.REDISTRIBUTION, DamageType.STATIC)
    ),
    BOMBER_BOMB(
            ShieldDamageType.BREAK,
            Set.of(DamageType.BLAST)
    ),
    BUILDER_MELEE(
            ShieldDamageType.DAMAGE,
            Set.of(DamageType.IMPACT)
    ),
    COMBAT_LOG(
            ShieldDamageType.IGNORE,
            Set.of(DamageType.STATIC)
    ),
    CREEPER_MINION(
            ShieldDamageType.BREAK,
            Set.of(DamageType.BLAST)
    ),
    CRUSHER_ANVIL_DIRECT(
            ShieldDamageType.DAMAGE,
            Set.of(DamageType.IMPACT)
    ),
    CRUSHER_ANVIL_INDIRECT(
            ShieldDamageType.DAMAGE,
            Set.of(DamageType.IMPACT)
    ),
    DEATH_PLANE(
            ShieldDamageType.IGNORE,
            Set.of(DamageType.STATIC)
    ),
    DEMOLITIONIST_BOMB(
            ShieldDamageType.BREAK,
            Set.of(DamageType.BLAST)
    ),
    DEMOLITIONIST_BOMB_INSTANT(
            ShieldDamageType.BREAK,
            Set.of(DamageType.BLAST)
    ),
    EARTH_SHATTER(
            ShieldDamageType.DAMAGE,
            Set.of(DamageType.ARCANE, DamageType.EARTH, DamageType.IMPACT)
    ),
    ENVIRONMENTAL(
            ShieldDamageType.IGNORE,
            Set.of()
    ),
    EXPLOSION(
            ShieldDamageType.BREAK,
            Set.of(DamageType.BLAST)
    ),
    FISH(
            ShieldDamageType.RESPECT,
            Set.of(DamageType.IMPACT)
    ),
    FUTURE_SIGHT(
            ShieldDamageType.IGNORE,
            Set.of(DamageType.PSYCHIC)
    ),
    GOBBLESTONE(
            ShieldDamageType.DAMAGE,
            Set.of(DamageType.IMPACT, DamageType.EARTH)
    ),
    GRAPPLING_HOOK(
            ShieldDamageType.IGNORE,
            Set.of(DamageType.PIERCING)
    ),
    GUNNER_SHOT(
            ShieldDamageType.PIERCE,
            Set.of(DamageType.PIERCING)
    ),
    HACKED_SENTRY_PROJECTILE(
            ShieldDamageType.DAMAGE,
            Set.of(DamageType.PIERCING)
    ),
    HITMAN_DART(
            ShieldDamageType.DAMAGE,
            Set.of(DamageType.PIERCING)
    ),
    HITMAN_HARM_DART(
            ShieldDamageType.IGNORE,
            Set.of(DamageType.ARCANE)
    ),
    HOMING_HEMOGLOBIN(
            ShieldDamageType.IGNORE,
            Set.of(DamageType.BLOOD)
    ),
    ICICLE(
            ShieldDamageType.DAMAGE,
            Set.of(DamageType.ICE, DamageType.PIERCING)
    ),
    ICICLE_MINION(
            ShieldDamageType.DAMAGE,
            Set.of(DamageType.ICE, DamageType.PIERCING)
    ),
    KANGAROO_STOMP(
            ShieldDamageType.DAMAGE,
            Set.of(DamageType.IMPACT)
    ),
    KATANA_PARRY(
            ShieldDamageType.IGNORE,
            Set.of(DamageType.REDISTRIBUTION, DamageType.SLASHING)
    ),
    KNIGHT_DAMAGE_DEFLECT(
            ShieldDamageType.IGNORE,
            Set.of(DamageType.IMPACT, DamageType.REDISTRIBUTION)
    ),
    LIGHTNING(
            ShieldDamageType.IGNORE,
            Set.of(DamageType.ARCANE, DamageType.ELECTRIC, DamageType.IMPACT)
    ),
    MATH_WORKSHEET(
            ShieldDamageType.IGNORE,
            Set.of(DamageType.PSYCHIC)
    ),
    MATH_WORKSHEET_SELF(
            ShieldDamageType.IGNORE,
            Set.of(DamageType.PSYCHIC)
    ),
    MELEE(
            ShieldDamageType.DAMAGE,
            Set.of(DamageType.SLASHING)
    ),
    MERCY_DAMAGING(
            ShieldDamageType.IGNORE,
            Set.of(DamageType.ARCANE)
    ),
    MINION(
            ShieldDamageType.DAMAGE,
            Set.of(DamageType.IMPACT)
    ),
    MUSKETEER_BURST_SHOT(
            ShieldDamageType.PIERCE,
            Set.of(DamageType.PIERCING)
    ),
    MUSKETEER_SNIPER_SHOT(
            ShieldDamageType.PIERCE,
            Set.of(DamageType.PIERCING)
    ),
    NO_MANA_FLIGHT(
            ShieldDamageType.IGNORE,
            Set.of(DamageType.ARCANE)
    ),
    NONCOMBAT_LOG(
            ShieldDamageType.IGNORE,
            Set.of(DamageType.STATIC)
    ),
    NORMAL_SHOT(
            ShieldDamageType.DAMAGE,
            Set.of(DamageType.PIERCING)
    ),
    OP_FISH_SUFFOCATE(
            ShieldDamageType.IGNORE,
            Set.of(DamageType.AIR)
    ),
    PAXEL_MELEE(
            ShieldDamageType.DAMAGE,
            Set.of(DamageType.IMPALING, DamageType.SLASHING)
    ),
    PORCUPINE_QUILL(
            ShieldDamageType.DAMAGE,
            Set.of(DamageType.PIERCING)
    ),
    POTION_MASTER_POTION(
            ShieldDamageType.IGNORE,
            Set.of(DamageType.ARCANE)
    ),
    PROJECTILE(
            ShieldDamageType.DAMAGE,
            Set.of(DamageType.PIERCING)
    ),
    PROMETHEUS_FIREBALL(
            ShieldDamageType.BREAK,
            Set.of(DamageType.ARCANE, DamageType.BLAST, DamageType.FIRE, DamageType.IMPACT)
    ),
    PROMETHEUS_FIREBALL_IMPACT(
            ShieldDamageType.DAMAGE,
            Set.of(DamageType.ARCANE, DamageType.FIRE, DamageType.IMPACT)
    ),
    PROMETHEUS_IMBUE(
            ShieldDamageType.IGNORE,
            Set.of(DamageType.ARCANE, DamageType.FIRE)
    ),
    PUFFERFISH(
            ShieldDamageType.RESPECT,
            Set.of(DamageType.IMPACT, DamageType.PIERCING)
    ),
    PYROTECHNIC_ROCKET(
            ShieldDamageType.DAMAGE,
            Set.of(DamageType.IMPACT, DamageType.BLAST)
    ),
    ROYAL_GUARD(
            ShieldDamageType.DAMAGE,
            Set.of(DamageType.REDISTRIBUTION)
    ),
    SELF(
            ShieldDamageType.IGNORE,
            Set.of(DamageType.STATIC)
    ),
    SENTRY_PROJECTILE(
            ShieldDamageType.DAMAGE,
            Set.of(DamageType.PIERCING)
    ),
    SHIELD_BASH(
            ShieldDamageType.DAMAGE,
            Set.of(DamageType.IMPACT)
    ),
    SLIME_MINION(
            ShieldDamageType.DAMAGE,
            Set.of(DamageType.IMPACT)
    ),
    SNEAK_ATTACK(
            ShieldDamageType.DAMAGE,
            Set.of(DamageType.STABBING)
    ),
    SNIPER_HEADSHOT(
            ShieldDamageType.DAMAGE,
            Set.of(DamageType.PIERCING)
    ),
    SNIPER_KNEESHOT(ShieldDamageType.DAMAGE,
            Set.of(DamageType.PIERCING)
    ),
    SNOWBALL(
            ShieldDamageType.DAMAGE,
            Set.of(DamageType.ARCANE, DamageType.ICE)
    ),
    SOLDIER_GRENADE(
            ShieldDamageType.BREAK,
            Set.of(DamageType.BLAST, DamageType.IMPACT)
    ),
    SONIC_BOOM(
            ShieldDamageType.BREAK,
            Set.of(DamageType.BLAST, DamageType.IMPACT)
    ),
    SUPER_CREEPER_MINION(
            ShieldDamageType.BREAK,
            Set.of(DamageType.BLAST, DamageType.ELECTRIC)
    ),
    THORNS(
            ShieldDamageType.IGNORE,
            Set.of(DamageType.IMPACT, DamageType.PIERCING, DamageType.REDISTRIBUTION)
    ),
    VITALIST_SHOT(
            ShieldDamageType.DAMAGE,
            Set.of(DamageType.PIERCING)
    ),
    WITHER_SKELETON_MINION(
            ShieldDamageType.DAMAGE,
            Set.of(DamageType.NECROTIC, DamageType.SLASHING)
    ),
    ZAP(
            ShieldDamageType.IGNORE,
            Set.of(DamageType.ARCANE, DamageType.ELECTRIC)
    ),

    ;

    private static Map<EntityDamageEvent.DamageCause, Set<DamageType>> spigotDamageTypeMap;

    private final ShieldDamageType shieldDamageType;
    private final Set<DamageType> damageTypes;

    FWDamageCause(ShieldDamageType shieldDamageType, Set<DamageType> damageTypes) {
        this.shieldDamageType = shieldDamageType;
        this.damageTypes = damageTypes;
    }

    public Set<DamageType> getDamageTypes() {
        return new HashSet<>(damageTypes);
    }

    public ShieldDamageType getShieldDamageType() {
        return shieldDamageType;
    }

    private static Map<EntityDamageEvent.DamageCause, Set<DamageType>> getSpigotDamageTypeMap() {
        if (spigotDamageTypeMap == null) {
            spigotDamageTypeMap = Map.ofEntries(
                    Map.entry(EntityDamageEvent.DamageCause.CONTACT, Set.of(DamageType.PIERCING)),
                    Map.entry(EntityDamageEvent.DamageCause.FALL, Set.of(DamageType.IMPACT)),
                    Map.entry(EntityDamageEvent.DamageCause.SUFFOCATION, Set.of(DamageType.AIR)),
                    Map.entry(EntityDamageEvent.DamageCause.FIRE, Set.of(DamageType.FIRE)),
                    Map.entry(EntityDamageEvent.DamageCause.FIRE_TICK, Set.of(DamageType.FIRE)),
                    Map.entry(EntityDamageEvent.DamageCause.MELTING, Set.of(DamageType.FIRE)),
                    Map.entry(EntityDamageEvent.DamageCause.LAVA, Set.of(DamageType.FIRE)),
                    Map.entry(EntityDamageEvent.DamageCause.DROWNING, Set.of(DamageType.WATER)),
                    Map.entry(EntityDamageEvent.DamageCause.VOID, Set.of(DamageType.AIR)),
                    Map.entry(EntityDamageEvent.DamageCause.LIGHTNING, Set.of(DamageType.ELECTRIC, DamageType.IMPACT)),
                    Map.entry(EntityDamageEvent.DamageCause.FALLING_BLOCK, Set.of(DamageType.IMPACT)),
                    Map.entry(EntityDamageEvent.DamageCause.FLY_INTO_WALL, Set.of(DamageType.IMPACT)),
                    Map.entry(EntityDamageEvent.DamageCause.HOT_FLOOR, Set.of(DamageType.FIRE)),
                    Map.entry(EntityDamageEvent.DamageCause.CRAMMING, Set.of(DamageType.CRAMMING)),
                    Map.entry(EntityDamageEvent.DamageCause.FREEZE, Set.of(DamageType.ICE)),
                    Map.entry(EntityDamageEvent.DamageCause.DRYOUT, Set.of(DamageType.AIR)),
                    Map.entry(EntityDamageEvent.DamageCause.POISON, Set.of(DamageType.POISON)),
                    Map.entry(EntityDamageEvent.DamageCause.WITHER, Set.of(DamageType.NECROTIC)),
                    Map.entry(EntityDamageEvent.DamageCause.WORLD_BORDER, Set.of(DamageType.STATIC))
            );
        }
        return spigotDamageTypeMap;
    }

    public static boolean isMeleeDamage(FWDamageCause damageCause) {
        return Set.of(
                FWDamageCause.MELEE,
                FWDamageCause.BUILDER_MELEE,
                FWDamageCause.AQUAMAN_TRIDENT_MELEE,
                FWDamageCause.AQUAMAN_TRIDENT_WATER_MELEE
        ).contains(damageCause);
    }

    public static Set<DamageType> getSpigotDamageTypes(EntityDamageEvent.DamageCause damageCause) {
        return getSpigotDamageTypeMap().getOrDefault(damageCause, Set.of());
    }

    public static Set<EntityDamageEvent.DamageCause> getEnvironmentalSpigotDamageCauses() {
        return getSpigotDamageTypeMap().keySet();
    }
}
