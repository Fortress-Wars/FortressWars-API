package net.fortresswars.data;

import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.persistence.PersistentDataHolder;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class PersistentData {

    private final Map<PersistentDataKey, Object> properties;

    public static PersistentData create() {
        return new PersistentData();
    }

    public static PersistentData fromFileConfiguration(ConfigurationSection configurationSection, PersistentData defaultConfig) {
        final var persistentData = new PersistentData();
        for (final var propertyKey : defaultConfig.properties.keySet()) {
            if (configurationSection != null) {
                final var propertyValue = configurationSection.get(propertyKey.name());
                if (propertyValue != null) {
                    persistentData.set(propertyKey, propertyValue);
                    continue;
                }
            }
            persistentData.set(propertyKey, defaultConfig.properties.getOrDefault(propertyKey, null));
        }
        return persistentData;
    }

    public static PersistentData fromHolder(PersistentDataHolder holder, Set<PersistentDataKey> propertyKeys, @Nullable NamespacedKey parentKey) {
        final var persistentData = new PersistentData();
        for (var propertyKey : propertyKeys) {
            final var namespacedKey = propertyKey.getNamespacedKey(parentKey);
            final var propertyValue = getPersistentData(holder, namespacedKey, propertyKey.type());
            if (propertyValue != null) {
                persistentData.set(propertyKey, propertyValue);
            }
        }
        return persistentData;
    }

    public static PersistentData fromHolder(PersistentDataHolder holder, PersistentData defaultData, @Nullable NamespacedKey parentKey) {
        final var persistentData = new PersistentData();
        for (final var propertyKey : defaultData.properties.keySet()) {
            final var namespacedKey = propertyKey.getNamespacedKey(parentKey);
            final var propertyValue = getPersistentData(holder, namespacedKey, propertyKey.type());
            if (propertyValue != null) {
                persistentData.set(propertyKey, propertyValue);
            } else {
                persistentData.set(propertyKey, defaultData.properties.getOrDefault(propertyKey, null));
            }
        }
        return persistentData;
    }

    public static void removeData(PersistentDataHolder holder, Set<PersistentDataKey> properties, @Nullable NamespacedKey parentKey) {
        if (holder == null) return;
        for (final var propertyKey : properties) {
            final var namespacedKey = propertyKey.getNamespacedKey(parentKey);
            holder.getPersistentDataContainer().remove(namespacedKey);
        }
    }

    public static PersistentDataValue getProperty(PersistentDataHolder holder, PersistentDataKey property) {
        return getProperty(holder, property, null);
    }

    public static PersistentDataValue getProperty(PersistentDataHolder holder, PersistentDataKey propertyKey, NamespacedKey parentKey) {
        final var namespacedKey = propertyKey.getNamespacedKey(parentKey);
        final var value = getPersistentData(holder, namespacedKey, propertyKey.type());
        return new PersistentDataValue(value);
    }

    private static Object getPersistentData(PersistentDataHolder holder, NamespacedKey key, PersistentDataType<?, ?> persistentDataType) {
        if (holder == null) return null;
        if (key == null) return null;
        final var pdc = holder.getPersistentDataContainer();
        return pdc.get(key, persistentDataType);
    }

    public PersistentData() {
        this.properties = new HashMap<>();
    }

    /**
     * Return the keys in this container
     * @return a new set of keys.
     */
    public Set<PersistentDataKey> getKeys() {
        return Collections.unmodifiableSet(properties.keySet());
    }

    /**
     * Set a property to this container
     * @param key the key of the property
     * @param value the value of the property
     */
    public PersistentData set(PersistentDataKey key, Object value) {
        properties.put(key, value);
        return this;
    }

    /**
     * Check if the config has a property set.
     * @param property property key
     * @return true if the property exists and is not null, false otherwise.
     */
    public boolean has(PersistentDataKey property) {
        if (property == null) return false;
        return this.properties.getOrDefault(property, null) != null;
    }

    /**
     * Get the requested property
     * @param property property to request
     * @return value - object
     */
    public PersistentDataValue get(PersistentDataKey property) {
        final var value = this.properties.getOrDefault(property, null);
        return new PersistentDataValue(value);
    }

    public void applyTo(PersistentDataHolder holder, NamespacedKey parentKey) {
        for (final var propertyKey : properties.keySet()) {
            setProperty(holder, propertyKey, get(propertyKey), parentKey);
        }
    }

    public static void setProperty(PersistentDataHolder holder, PersistentDataKey key, Object value, NamespacedKey parentKey) {
        setProperty(holder, key, new PersistentDataValue(value), parentKey);
    }

    public static void setProperty(PersistentDataHolder holder, PersistentDataKey propertyKey, PersistentDataValue value, NamespacedKey parentKey) {
        final var namespacedKey = propertyKey.getNamespacedKey(parentKey);
        final var propertyDataType = propertyKey.type();

        if (propertyDataType == PersistentDataType.BYTE) {
            setPersistentData(holder, value.asByte(), PersistentDataType.BYTE, namespacedKey);
        } else if (propertyDataType == PersistentDataType.SHORT) {
            setPersistentData(holder, value.asShort(), PersistentDataType.SHORT, namespacedKey);
        } else if (propertyDataType == PersistentDataType.INTEGER) {
            setPersistentData(holder, value.asInt(), PersistentDataType.INTEGER, namespacedKey);
        } else if (propertyDataType == PersistentDataType.LONG) {
            setPersistentData(holder, value.asLong(), PersistentDataType.LONG, namespacedKey);
        } else if (propertyDataType == PersistentDataType.DOUBLE) {
            setPersistentData(holder, value.asDouble(), PersistentDataType.DOUBLE, namespacedKey);
        } else if (propertyDataType == PersistentDataType.FLOAT) {
            setPersistentData(holder, value.asFloat(), PersistentDataType.FLOAT, namespacedKey);
        } else if (propertyDataType == PersistentDataType.BOOLEAN) {
            setPersistentData(holder, value.asBoolean(), PersistentDataType.BOOLEAN, namespacedKey);
        } else {
            setPersistentData(holder, value.asString(), PersistentDataType.STRING, namespacedKey);
        }
    }

    private static <P, C> void setPersistentData(PersistentDataHolder holder, C value, PersistentDataType<P, C> persistentDataType, NamespacedKey key) {
        if (value == null) return;
        final var pdc = holder.getPersistentDataContainer();
        pdc.set(key, persistentDataType, value);
    }
}
