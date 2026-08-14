package net.fortresswars.core.data;

import net.fortresswars.FortressWarsAPI;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.Nullable;

public record PersistentDataKey (
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
    public static PersistentDataKey ID = new PersistentDataKey("id", PersistentDataType.STRING);
    public static PersistentDataKey UUID = new PersistentDataKey("uuid", PersistentDataType.STRING);
    public static PersistentDataKey OWNER = new PersistentDataKey("owner", PersistentDataType.STRING);
    public static PersistentDataKey PARENT = new PersistentDataKey("parent", PersistentDataType.STRING);
    public static PersistentDataKey CHILD = new PersistentDataKey("child", PersistentDataType.STRING);
    public static PersistentDataKey TYPE = new PersistentDataKey("type", PersistentDataType.STRING);

    // Time
    public static PersistentDataKey TIME = new PersistentDataKey("time", PersistentDataType.LONG);
    public static PersistentDataKey COOLDOWN = new PersistentDataKey("cooldown", PersistentDataType.INTEGER);
    public static PersistentDataKey DURATION = new PersistentDataKey("duration", PersistentDataType.INTEGER);
    public static PersistentDataKey DURATION_2 = new PersistentDataKey("duration_2", PersistentDataType.INTEGER);
    public static PersistentDataKey START_DURATION = new PersistentDataKey("start_duration", PersistentDataType.INTEGER);
    public static PersistentDataKey REMAINING_DURATION = new PersistentDataKey("remaining_duration", PersistentDataType.INTEGER);

    // Attributes
    public static PersistentDataKey WEIGHT = new PersistentDataKey("weight", PersistentDataType.INTEGER);
    public static PersistentDataKey DAMAGE = new PersistentDataKey("damage", PersistentDataType.DOUBLE);
    public static PersistentDataKey MELEE_DAMAGE = new PersistentDataKey("melee_damage", PersistentDataType.DOUBLE);
    public static PersistentDataKey SPEED = new PersistentDataKey("speed", PersistentDataType.DOUBLE);
    public static PersistentDataKey MELEE_SPEED = new PersistentDataKey("melee_speed", PersistentDataType.DOUBLE);
    public static PersistentDataKey RADIUS = new PersistentDataKey("radius", PersistentDataType.DOUBLE);
    public static PersistentDataKey REACH = new PersistentDataKey("reach", PersistentDataType.DOUBLE);
    public static PersistentDataKey RANGE = new PersistentDataKey("range", PersistentDataType.DOUBLE);
    public static PersistentDataKey IGNORE_NO_DAMAGE_TICKS = new PersistentDataKey("ignore_no_damage_ticks", PersistentDataType.BOOLEAN);
    public static PersistentDataKey THRESHOLD = new PersistentDataKey("threshold", PersistentDataType.DOUBLE);
    public static PersistentDataKey NUTRITION = new PersistentDataKey("nutrition", PersistentDataType.DOUBLE);
    public static PersistentDataKey CAN_ALWAYS_EAT = new PersistentDataKey("can_always_eat", PersistentDataType.BOOLEAN);
    public static PersistentDataKey COST = new PersistentDataKey("cost", PersistentDataType.DOUBLE);
    public static PersistentDataKey AMOUNT = new PersistentDataKey("amount", PersistentDataType.INTEGER);

    // State
    public static PersistentDataKey STATUS = new PersistentDataKey("status", PersistentDataType.STRING);
    public static PersistentDataKey IS_ON_GROUND = new PersistentDataKey("is_on_ground", PersistentDataType.BOOLEAN);
    public static PersistentDataKey IS_OPEN = new PersistentDataKey("is_open", PersistentDataType.BOOLEAN);
    public static PersistentDataKey MATERIAL = new PersistentDataKey("material", PersistentDataType.STRING);
    public static PersistentDataKey VARIANT = new PersistentDataKey("variant", PersistentDataType.STRING);
    public static PersistentDataKey IS_MENU_TEM = new PersistentDataKey("is_menu_item", PersistentDataType.BOOLEAN);

    // Cosmetics
    public static PersistentDataKey DISABLE_COSMETICS = new PersistentDataKey("disable_cosmetics", PersistentDataType.BOOLEAN);

    // Space
    public static PersistentDataKey INDEX = new PersistentDataKey("index", PersistentDataType.INTEGER);
    public static PersistentDataKey X = new PersistentDataKey("x", PersistentDataType.DOUBLE);
    public static PersistentDataKey Z = new PersistentDataKey("z", PersistentDataType.DOUBLE);
    public static PersistentDataKey Y = new PersistentDataKey("y", PersistentDataType.DOUBLE);
    public static PersistentDataKey X1 = new PersistentDataKey("x1", PersistentDataType.DOUBLE);
    public static PersistentDataKey Z1 = new PersistentDataKey("z1", PersistentDataType.DOUBLE);
    public static PersistentDataKey Y1 = new PersistentDataKey("y1", PersistentDataType.DOUBLE);
    public static PersistentDataKey X2 = new PersistentDataKey("x2", PersistentDataType.DOUBLE);
    public static PersistentDataKey Z2 = new PersistentDataKey("z2", PersistentDataType.DOUBLE);
    public static PersistentDataKey Y2 = new PersistentDataKey("y2", PersistentDataType.DOUBLE);
    public static PersistentDataKey HEIGHT = new PersistentDataKey("height", PersistentDataType.DOUBLE);
    public static PersistentDataKey LENGTH = new PersistentDataKey("length", PersistentDataType.DOUBLE);
    public static PersistentDataKey WIDTH = new PersistentDataKey("width", PersistentDataType.DOUBLE);
    public static PersistentDataKey DEPTH = new PersistentDataKey("depth", PersistentDataType.DOUBLE);
    public static PersistentDataKey DIRECTION = new PersistentDataKey("direction", PersistentDataType.STRING);

    // Team
    public static PersistentDataKey TEAM =  new PersistentDataKey("team", PersistentDataType.STRING);
}
