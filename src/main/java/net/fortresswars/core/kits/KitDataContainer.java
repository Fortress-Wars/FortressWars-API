package net.fortresswars.core.kits;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KitDataContainer {

    private final Map<KitData, Double> container;
    private final Map<KitData, Double> base;

    public static KitDataContainer create() {
        return new KitDataContainer();
    }

    private KitDataContainer() {
        container = new HashMap<>();
        base = new HashMap<>();
    }

    /**
     * Recognizes that the property should be in the container.
     * If the property IS NOT in the container, then it will set the default value
     * If the property IS in the container, then this function will not do anything
     * @param property property key
     */
    public void recognize(final KitData property) {
        if (container.containsKey(property)) return;
        add(property, property.getDefaultValue());
    }

    /**
     * Add a property to this container
     * @param property property key
     * @param value double
     * @param shouldAddToBase if the value should also be added to the base container
     */
    public void add(KitData property, double value, boolean shouldAddToBase) {
        if (shouldAddToBase) {
            base.put(property, value);
        }
        container.put(property, value);
    }

    /**
     * Add a property to this container
     * @param property property key
     * @param value - double
     */
    public void add(KitData property, double value) {
        add(property, value, true);
    }

    /**
     * Add a property to this container
     * @param property property key
     * @param value - boolean
     */
    public void add(KitData property, boolean value) {
        double bool = value ? 1 : 0;
        add(property, bool);
    }

    /**
     * Get the requested property as a double
     * @param property property to request
     * @return value - double
     */
    public double get(KitData property) {
        return container.getOrDefault(property, property.getDefaultValue());
    }

    /**
     * Get the requested property as an integer
     * @param property property to request
     * @return value as an integer
     */
    public int getInt(KitData property) {
        return (int) get(property);
    }

    /**
     * Gets the requested property as a potion level
     * @param property property to request
     * @return value as an integer -1
     */
    public int getPotionLevel(KitData property) {
        return  Math.max(0, getInt(property) - 1);
    }

    /**
     * Gets the requested property as melee damage
     * @param property property to request
     * @return value as an integer -1
     */
    public int getMeleeDamage(KitData property) {
        return  Math.max(0, getInt(property) - 1);
    }

    /**
     * Get the requested property as a float
     * @param property property to request
     * @return value as a float
     */
    public float getFloat(KitData property) {
        return (float) get(property);
    }

    /**
     * Get the requested property as a boolean
     * @param property property to request
     * @return true if value is greater than 0, false otherwise
     */
    public boolean getBoolean(KitData property) {
        return get(property) > 0;
    }

    /**
     * Get the requested property as a percentage
     * @param property property to request
     * @return value of the percentage converted to a double (i.e. 80 -> 0.8)
     */
    public double getPercentage(KitData property) {
        return get(property) / 100;
    }

    /**
     * Get the requested property as a milliseconds (from ticks)
     * @param property property to request
     * @return value of the milliseconds
     */
    public int getMilliseconds(KitData property) {
        return getInt(property) * 50;
    }

    /**
     * Get the keys used in this container
     * @return a new Set with the keys used in this container
     */
    public Set<KitData> keys() {
        return new HashSet<>(container.keySet());
    }

    /**
     * Merges another DataContainer into the base values of this container
     * @param dataContainer container whose values will override this
     */
    public void mergeBase(KitDataContainer dataContainer) {
        for (KitData key : dataContainer.keys()) {
            base.put(key, dataContainer.get(key));
            container.put(key, dataContainer.get(key));
        }
    }

    /**
     * Merges another DataContainer into the values of this container. If the
     * reset function is called. These values will be reset
     * @param dataContainer container whose values will override this
     */
    public void merge(KitDataContainer dataContainer) {
        for (KitData key : dataContainer.keys()) {
            container.put(key, dataContainer.get(key));
        }
    }

    /**
     * Resets the all the merge data and restores to only the
     * data that explicitly assigned to this container
     */
    public void reset() {
        container.clear();
        container.putAll(base);
    }

    /**
     * Clears the container
     */
    public void clear() {
        container.clear();
        base.clear();
    }

    /**
     * Make a copy of this kit data container
     * @return a new copy
     */
    public KitDataContainer copy() {
        final KitDataContainer clone = KitDataContainer.create();
        clone.mergeBase(this);
        return clone;
    }
}
