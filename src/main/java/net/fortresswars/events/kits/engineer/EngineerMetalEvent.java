package net.fortresswars.events.kits.engineer;

import net.fortresswars.core.entities.FortressWarsPlayer;
import net.fortresswars.events.FortressWarsCancellableEvent;

public abstract class EngineerMetalEvent extends FortressWarsCancellableEvent {

    protected final FortressWarsPlayer player;
    protected int metal;

    public EngineerMetalEvent(FortressWarsPlayer player, int metal) {
        this.player = player;
        this.metal = metal;
    }

    public FortressWarsPlayer getPlayer() {
        return player;
    }

    public void setMetal(int metal) {
        this.metal = Math.max(metal, 0);
    }

    public int getMetal() {
        return metal;
    }
}
