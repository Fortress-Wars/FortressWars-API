package net.fortresswars.core.damage;

import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum DamageType {

    // Physical
    PHYSICAL(null), // Physical
    BLAST(DamageType.PHYSICAL), // Something explodes
    CRAMMING(DamageType.PHYSICAL), // Cramming
    IMPACT(DamageType.PHYSICAL), // Something big colliding
    IMPALING(DamageType.PHYSICAL), // Goes in and stays in
    PIERCING(DamageType.PHYSICAL), // Goes in and goes out the other side
    REDISTRIBUTION(DamageType.PHYSICAL), // Damage that is redirected from one entity to another
    SLASHING(DamageType.PHYSICAL), // Doesn't go in
    STABBING(DamageType.PHYSICAL), // Goes in and comes out

    // Elemental
    ELEMENTAL(null), // Magic that is elemental based
    AIR(DamageType.ELEMENTAL), // Air element magic
    EARTH(DamageType.ELEMENTAL), // Earth element magic
    ELECTRIC(DamageType.ELEMENTAL), // Electric element magic
    FIRE(DamageType.ELEMENTAL), // Fire element magic & other fire damage
    ICE(DamageType.ELEMENTAL), // Ice element magic
    WATER(DamageType.ELEMENTAL), // Water element magic

    // Magic
    MAGIC(null), // Magical damage
    ARCANE(DamageType.MAGIC), // Mana damage
    BLOOD(DamageType.MAGIC), // Blood Damage
    NECROTIC(DamageType.MAGIC), // Decay and withering damage
    POISON(DamageType.MAGIC), // Poison damage
    PSYCHIC(DamageType.MAGIC), // Mind damage

    // System
    SYSTEM(null), // Damage caused from the game
    OTHER(DamageType.SYSTEM), // Miscellaneous damage
    STATIC(DamageType.SYSTEM) // Damage that can't be adjusted by damage modifiers

    ;

    private static final Map<DamageType, Set<DamageType>> CHILDREN;
    private final DamageType parent;

    DamageType(DamageType parent) {
        this.parent = parent;
    }

    static {
        // Build { parent -> children } map once at startup
        EnumMap<DamageType, Set<DamageType>> children = new EnumMap<>(DamageType.class);
        for (DamageType type : DamageType.values()) {
            final DamageType parent = type.getParent();
            if (parent != null) {
                children.computeIfAbsent(parent, k -> new HashSet<>()).add(type);
            }
        }

        for (Map.Entry<DamageType, Set<DamageType>> entry : children.entrySet()) {
            entry.setValue(Collections.unmodifiableSet(entry.getValue()));
        }

        CHILDREN = Collections.unmodifiableMap(children);
    }

    /**
     * Get the parent damage type
     * @return the parent
     */
    public @Nullable DamageType getParent() {
        return parent;
    }

    /**
     * Get all damage types up to the root parent
     * @param type the type
     * @return this type + all parents up to the root
     */
    public static Set<DamageType> getParents(DamageType type) {
        return Stream.iterate(type, Objects::nonNull, DamageType::getParent)
                .collect(Collectors.toSet());
    }

    /**
     * Get all descendants/children of the damage type
     * @param type the damage type
     * @return this type + all descendants
     */
    public static Set<DamageType> getDescendants(DamageType type) {
        final Set<DamageType> result = new HashSet<>();
        result.add(type);

        final Set<DamageType> directChildren = CHILDREN.get(type);
        if (directChildren != null) {
            for (DamageType child : directChildren) {
                result.addAll(getDescendants(child));
            }
        }
        return result;
    }

    /**
     * expand a set of leaf types to include all parents
     * @param baseTypes the base types
     * @return all the types, including parents
     */
    public static Set<DamageType> getParents(Set<DamageType> baseTypes) {
        return baseTypes.stream()
                .flatMap(t -> getParents(t).stream())
                .collect(Collectors.toSet());
    }

    /**
     * Get the family of types. All parents siblings, and children of the provided types set.
     * @param damageTypes the damage types to get
     * @return the provided type types, parents of the provided types, and children of the provided types
     */
    public static Set<DamageType> getFamily(Set<DamageType> damageTypes) {
        // Iterate through all the damageType only to get all the parent types.
        final Set<DamageType> allParentTypes = getParents(damageTypes);

        // Iterate through all of damageTypes only (not the parents) and get all the children.
        final Set<DamageType> allChildrenTypes = damageTypes.stream()
                .flatMap(type -> getDescendants(type).stream())
                .collect(Collectors.toSet());

        // Combine all the types
        final Set<DamageType> allTypes = new HashSet<>();
        allTypes.addAll(allParentTypes);
        allTypes.addAll(allChildrenTypes);
        return allTypes;
    }
}
