package net.fortresswars.events.games;

import net.fortresswars.core.games.BeaconGame;
import net.fortresswars.core.games.FWBeacon;
import org.bukkit.event.Cancellable;

public class FWBeaconDamageEvent extends GameEvent implements Cancellable {

    public enum Reason {
        PLAYER,
        DECAY
    }

    private final FWBeacon beacon;
    private final int currentHealth;
    private final int damage;
    private final Reason reason;

    private boolean isCancelled;
    private int additives;
    private double multiplier;

    public FWBeaconDamageEvent(BeaconGame game, FWBeacon beacon, int damage, Reason reason) {
        super(game);
        this.beacon = beacon;
        this.currentHealth = beacon.getBeaconPercent();
        this.damage = damage;
        this.reason = reason;
        additives = 0;
        multiplier = 1;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    /**
     * Get the beacon
     * @return beacon - Block
     */
    public FWBeacon getBeacon() {
        return beacon;
    }

    /**
     * Damage to the beacon
     * @return int
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Get the reason the beacon was damaged.
     * @return the reason
     */
    public Reason getReason() {
        return this.reason;
    }

    /**
     * Returns the final beacon damage
     * @return int (damage + additives) * multipliers
     */
    public int getFinalDamage() {
        int finalDamage = (int) Math.floor(Math.round((damage + additives) * multiplier));
        finalDamage = Math.min(finalDamage, currentHealth);
        finalDamage = Math.max(finalDamage, 0);
        return finalDamage;
    }

    /**
     * Adds to the damage additives
     * @param damage positive/negative int
     */
    public void addAdditiveDamage(int damage) {
        additives += damage;
    }

    /**
     * Adds to the damage multiplier
     * @param multiplier positive double
     */
    public void addMultiplierDamage(int multiplier) {
        this.multiplier += Math.abs(multiplier);
    }

    /**
     * If the beacon breaks due to the damage that will be done
     * @return true if the beacon will break, false otherwise
     */
    public boolean isBroken() {
        return currentHealth - getFinalDamage() <= 0;
    }

    /**
     * Calculate the beacon damage after damaging it.
     * @return the calculated beacon damage.
     */
    public int calculateNewBeaconDamage() {
        return Math.max(0, beacon.getBeaconPercent() - getFinalDamage());
    }
}
