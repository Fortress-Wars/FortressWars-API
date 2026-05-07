package net.fortresswars.core.managers;

/**
 * Interface for objects that can be enabled and disabled
 * Author: Peter Cesmegi
 */
public interface Enableable {

    /**
     * Called when this class should be enabled
     */
    void enable();

    /**
     * Called when this class should be disabled
     */
    void disable();

    /**
     * Returns whether his class is currently enabled
     * @return true if enabled, false otherwise
     */
    boolean isEnabled();
}
