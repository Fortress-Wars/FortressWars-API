package net.fortresswars.core.kits.abilities.blocks;

public interface Repairable {

    /**
     * Check if the block can be repaired
     * @return true if the block can be repaired, false otherwise
     */
    boolean canBeReRepaired();

    /**
     * Repairs the block
     * @param amount by which to repair
     * @return integer new HP
     */
    int repair(int amount);

    /**
     * Get the health of the block
     * @return the health of the block
     */
    double getHealth();

    /**
     * Get the max health of the block
     * @return the max health of the block
     */
    double getMaxHealth();

    /**
     * Check if the block is at max HP
     * @return true if the block is at max HP, false otherwise
     */
    boolean isAtMaxHP();
}
