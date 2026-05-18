package net.fortresswars.core.cosmetics;

import org.bukkit.entity.Player;

public abstract class DeathAnimation extends Cosmetic<FWDeathAnimation> {

    /**
     * Gets called when a fortress wars player death animation should play
     * @param player the player that the animation should play ove.
     */
    public abstract void doAnimation(Player player);
}
