package net.fortresswars.core.entities;

/**
 * Interface for Objects that can be hacked
 * Author: Peter Cesmegi
 */
public interface Hackable {

    /**
     * Returns whether this Hackable can be hacked in its current state
     * @return false if not Hackable, true otherwise
     */
    boolean isHackable();

    /**
     * Returns whether this Hackable is currently hacked
     * @return true if hacked, false otherwise
     */
    boolean isHacked();

    /**
     * Gets the duration in ticks for how much longer this Hackable is hacked for
     * (Integer must be >= 0)
     * @return int ticks
     */
    int getHackDuration();

    /**
     * Gets the entity that has hacked most recently
     * @return FortressWarsEntity of the current hacker, null if no hackers
     */
    FortressWarsEntity getHacker();


    /**
     * Hack this Hackable for the specified number of ticks
     * @param ticks duration to hack (should expect to be a positive integer)
     * @param hacker FortressWarsEntity of the entity that hacked this
     * @return the number of ticks that was added to the hack duration
     */
    int hack(int ticks, FortressWarsEntity hacker);


    /**
     * Unhack this Hackable
     */
    void unhack();
}
