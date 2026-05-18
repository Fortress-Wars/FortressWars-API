package net.fortresswars.core.kits;

/**
 * Interface for refreshable classes
 * Used by kit classes for abilities
 * Author: Peter Cesmegi
 */
public interface Refreshable {

    /**
     * Fully refresh
     */
    void refresh();

    /**
     * Refresh by the specified number of ticks
     * @param ticks to refresh by
     */
    void refresh(int ticks);

    /**
     * Refresh by a certain percentage
     * @param percentage to refresh by
     */
    void refresh(double percentage);
}
