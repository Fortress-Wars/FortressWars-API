package net.fortresswars.data;

import net.fortresswars.FortressWarsAPI;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataHolder;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PersistentData {

    private final Map<PersistentDataKey, Object> properties;

    public static PersistentData create() {
        return new PersistentData();
    }

    public static PersistentData fromFileConfiguration(ConfigurationSection configurationSection, PersistentData defaultConfig) {
        final PersistentData persistentData = new PersistentData();
        for (PersistentDataKey propertyKey : defaultConfig.properties.keySet()) {
            if (configurationSection != null) {
                final Object propertyValue = configurationSection.get(propertyKey.getName().toLowerCase());
                if (propertyValue != null) {
                    persistentData.set(propertyKey, propertyValue);
                    continue;
                }
            }

            persistentData.set(propertyKey, defaultConfig.properties.getOrDefault(propertyKey, null));
        }
        return persistentData;
    }

    public static PersistentData fromHolder(PersistentDataHolder holder, Set<PersistentDataKey> properties, @Nullable NamespacedKey parentKey) {
        final PersistentData persistentData = new PersistentData();
        for (PersistentDataKey propertyKey : properties) {
            final NamespacedKey key = getCombinedPropertyKey(parentKey, propertyKey);
            final Object propertyValue = getPersistentData(holder, key, propertyKey.getPersistentDataType());
            if (propertyValue != null) {
                persistentData.set(propertyKey, propertyValue);
            }
        }
        return persistentData;
    }

    public static PersistentData fromHolder(PersistentDataHolder holder, PersistentData defaultData, @Nullable NamespacedKey parentKey) {
        final PersistentData persistentData = new PersistentData();
        for (PersistentDataKey propertyKey : defaultData.properties.keySet()) {
            final NamespacedKey key = getCombinedPropertyKey(parentKey, propertyKey);
            final Object propertyValue = getPersistentData(holder, key, propertyKey.getPersistentDataType());
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
        for (PersistentDataKey propertyKey : properties) {
            final NamespacedKey key = getCombinedPropertyKey(parentKey, propertyKey);
            holder.getPersistentDataContainer().remove(key);
        }
    }

    public static NamespacedKey getCombinedPropertyKey(@Nullable NamespacedKey parentKey, PersistentDataKey property) {
        if (parentKey == null) {
            return new NamespacedKey(FortressWarsAPI.NAMESPACE, property.name().toLowerCase());
        }
        return new NamespacedKey(parentKey.getNamespace(), parentKey.getKey() + "." + property.name().toLowerCase());
    }

    public static PersistentDataProperty getProperty(PersistentDataHolder holder, PersistentDataKey property) {
        return getProperty(holder, property, null);
    }

    public static PersistentDataProperty getProperty(PersistentDataHolder holder, PersistentDataKey property, NamespacedKey parentKey) {
        final NamespacedKey key = getCombinedPropertyKey(parentKey, property);
        final Object value = getPersistentData(holder, key, property.getPersistentDataType());
        return new PersistentDataProperty(value);
    }

    private static Object getPersistentData(PersistentDataHolder holder, NamespacedKey key, PersistentDataType<?, ?> persistentDataType) {
        if (holder == null) return null;
        if (key == null) return null;
        final PersistentDataContainer pdc = holder.getPersistentDataContainer();
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
        return new HashSet<>(properties.keySet());
    }

    /**
     * Set a property to this container
     * @param property property key
     * @param value - double
     */
    public PersistentData set(PersistentDataKey property, Object value) {
        properties.put(property, value);
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
    public PersistentDataProperty get(PersistentDataKey property) {
        final Object value = this.properties.getOrDefault(property, null);
        return new PersistentDataProperty(value);
    }

    public void applyTo(PersistentDataHolder holder, NamespacedKey parentKey) {
        for (PersistentDataKey propertyKey : properties.keySet()) {
            setProperty(holder, propertyKey, get(propertyKey), parentKey);
        }
    }

    public static void setProperty(PersistentDataHolder holder, PersistentDataKey key, Object value, NamespacedKey parentKey) {
        setProperty(holder, key, new PersistentDataProperty(value), parentKey);
    }

    public static void setProperty(PersistentDataHolder holder, PersistentDataKey property, PersistentDataProperty value, NamespacedKey parentKey) {
        final PersistentDataType<?, ?> persistentDataType = property.getPersistentDataType();
        final NamespacedKey key = getCombinedPropertyKey(parentKey, property);
        if (persistentDataType == PersistentDataType.INTEGER) {
            setPersistentData(holder, value.asInt(), PersistentDataType.INTEGER, key);
        } else if (persistentDataType == PersistentDataType.BOOLEAN) {
            setPersistentData(holder, value.asBoolean(), PersistentDataType.BOOLEAN, key);
        } else if (persistentDataType == PersistentDataType.DOUBLE) {
            setPersistentData(holder, value.asDouble(), PersistentDataType.DOUBLE, key);
        } else if (persistentDataType == PersistentDataType.FLOAT) {
            setPersistentData(holder, value.asFloat(), PersistentDataType.FLOAT, key);
        } else {
            setPersistentData(holder, value.asString(), PersistentDataType.STRING, key);
        }
    }

    private static <P, C> void setPersistentData(PersistentDataHolder holder, C value, PersistentDataType<P, C> persistentDataType, NamespacedKey key) {
        if (value == null) return;
        final PersistentDataContainer pdc = holder.getPersistentDataContainer();
        pdc.set(key, persistentDataType, value);
    }
}
