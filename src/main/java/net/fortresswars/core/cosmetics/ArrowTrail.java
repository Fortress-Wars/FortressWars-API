package net.fortresswars.core.cosmetics;

import org.bukkit.Location;
public abstract class ArrowTrail extends Cosmetic<FWArrowTrail> {

    /**
     * Called when arrow has a cosmetic trail and is in air/in water
     * @param location location of arrow
     */
    public abstract void doTrailEffect(Location location);

    /**
     * Called when an arrow that has an arrow trail hits a block/entity, dies, or cosmetic expires
     * @param location location of arrow
     */
    public abstract void doHitEffect(Location location);
}
