package net.fortresswars.data;

import org.bukkit.persistence.PersistentDataType;

public enum PersistentDataKey {

    // UUIDs
    ID(PersistentDataType.STRING),
    UUID(PersistentDataType.STRING),
    OWNER(PersistentDataType.STRING),
    PARENT(PersistentDataType.STRING),
    CHILD(PersistentDataType.STRING),

    // Time
    COOLDOWN(PersistentDataType.INTEGER),
    DURATION(PersistentDataType.INTEGER),
    DURATION_2(PersistentDataType.INTEGER),
    START_DURATION(PersistentDataType.INTEGER),
    REMAINING_DURATION(PersistentDataType.INTEGER),

    // Attributes
    DAMAGE(PersistentDataType.DOUBLE),
    SPEED(PersistentDataType.DOUBLE),
    RADIUS(PersistentDataType.DOUBLE),
    REACH(PersistentDataType.DOUBLE),
    RANGE(PersistentDataType.DOUBLE),
    IGNORE_NO_DAMAGE_TICKS(PersistentDataType.BOOLEAN),
    THRESHOLD(PersistentDataType.DOUBLE),
    NUTRITION(PersistentDataType.INTEGER),
    CAN_ALWAYS_EAT(PersistentDataType.BOOLEAN),
    COST(PersistentDataType.DOUBLE),
    AMOUNT(PersistentDataType.INTEGER),

    // State
    STATUS(PersistentDataType.STRING),
    IS_ON_GROUND(PersistentDataType.BOOLEAN),
    ;

    private final PersistentDataType<?, ?> persistentDataType;

    PersistentDataKey(PersistentDataType<?, ?> persistentDataType) {
        this.persistentDataType = persistentDataType;
    }

    public PersistentDataType<?, ?> getPersistentDataType() {
        return persistentDataType;
    }

    public String getName() {
        return name().toLowerCase();
    }
}
