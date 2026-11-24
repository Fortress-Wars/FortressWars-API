package net.fortresswars.events.kits.engineer;

import net.fortresswars.core.entities.FortressWarsPlayer;
import net.fortresswars.events.FortressWarsCancellableEvent;

public abstract class EngineerMetalEvent extends FortressWarsCancellableEvent {

    protected final FortressWarsPlayer player;
    protected double metal;

    public EngineerMetalEvent(FortressWarsPlayer player, double metal) {
        this.player = player;
        this.metal = metal;
    }

    public FortressWarsPlayer getPlayer() {
        return player;
    }

    public void setMetal(double metal) {
        this.metal = Math.max(metal, 0);
    }

    public double getMetal() {
        return metal;
    }
}
