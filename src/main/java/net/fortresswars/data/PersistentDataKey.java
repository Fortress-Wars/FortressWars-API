package net.fortresswars.data;

import net.fortresswars.FortressWarsAPI;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.Nullable;

public record PersistentDataKey(
        String name,
        PersistentDataType<?,?> type
) {

    public static PersistentDataKey of(String name, PersistentDataType<?,?> type) {
        return new PersistentDataKey(name, type);
    }

    public NamespacedKey getNamespacedKey(@Nullable NamespacedKey parentKey) {
        if (parentKey == null) {
            return new NamespacedKey(FortressWarsAPI.NAMESPACE, name.toLowerCase());
        }
        return new NamespacedKey(parentKey.getNamespace(), parentKey.getKey() + "." + name.toLowerCase());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    // ids
    public static String ID = "id";
    public static String UUID = "uuid";
    public static String OWNER = "owner";
    public static String PARENT = "parent";
    public static String CHILD = "child";

    // Time
    public static String TIME = "time";
    public static String COOLDOWN = "cooldown";
    public static String DURATION = "duration";
    public static String DURATION_2 = "duration_2";
    public static String START_DURATION = "start_duration";
    public static String REMAINING_DURATION = "remaining_duration";

    // Attributes
    public static String WEIGHT = "weight";
    public static String DAMAGE = "damage";
    public static String SPEED = "speed";
    public static String RADIUS = "radius";
    public static String REACH = "reach";
    public static String RANGE = "range";
    public static String IGNORE_NO_DAMAGE_TICKS = "ignore_no_damage_ticks";
    public static String THRESHOLD = "threshold";
    public static String NUTRITION = "nutrition";
    public static String CAN_ALWAYS_EAT = "can_always_eat";
    public static String COST = "cost";
    public static String AMOUNT = "amount";

    // State
    public static String STATUS = "status";
    public static String IS_ON_GROUND = "is_on_ground";

    // Cosmetics
    public static String DISABLE_COSMETICS = "disable_cosmetics";

    // Space
    public static String X = "x";
    public static String Z = "z";
    public static String Y = "y";
    public static String HEIGHT = "height";
    public static String LENGTH = "length";
    public static String WIDTH = "width";
    public static String DEPTH = "depth";
}
