package net.fortresswars.core.cosmetics;

import org.bukkit.entity.Player;

public abstract class ParticleEffect extends Cosmetic<FWParticleEffect> {
    protected final int frameCount;

    public ParticleEffect(int frameCount) {
        super();
        this.frameCount = frameCount;
    }

    public int getFrameCount() {
        return frameCount;
    }

    public abstract void doIdleAnimation(Player player, int frameNumber);

    public abstract void doMovementAnimation(Player player, int frameNumber);
}
