package net.fortresswars.core.entities;

/**
 * Interface for objects that can be stunned
 * Author: Peter Cesmegi
 */
public interface Stunnable {

    /**
     * Returns whether this Stunnable can be stunned in its current state
     * @return false if not stunnable, true otherwise
     */
    boolean isStunnable();

    /**
     * Returns whether this Stunnable is currently stunned
     * @return true if stunned, false otherwise
     */
    boolean isStunned();

    /**
     * Gets the duration in ticks for how much longer this Stunnable is stunned for
     * (Integer must be >= 0)
     * @return int ticks
     */
    int getStunDuration();

    /**
     * Gets the entity that has stunned most recently
     * @return FortressWarsEntity of the current stunner, null if no stunners
     */
    FortressWarsEntity getStunner();


    /**
     * Stun this Stunnable for the specified number of ticks
     * @param ticks duration to stun (should expect to be a positive integer)
     * @param fwe FortressWarsEntity that stunned this
     * @return the number of ticks that was added to the stun duration
     */
    int stun(int ticks, FortressWarsEntity fwe);

    /**
     * Unstun this Stunnable
     */
    void unstun();
}
