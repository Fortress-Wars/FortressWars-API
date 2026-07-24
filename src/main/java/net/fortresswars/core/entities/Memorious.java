package net.fortresswars.core.entities;

public interface Memorious {

    /**
     * Does the minion have memory.
     * @return ture if it has memory, false if it does not.
     */
    boolean hasMemory();

    /**
     * Get the current memory points of the minion.
     * @return the memory points.
     */
    int getMemory();

    /**
     * Lose a memory point.
     */
    void loseMemory();

    /**
     * Gain a memory point.
     */
    void gainMemory();

    /**
     * Set the memory points to max.
     */
    void resetMemory();
}
