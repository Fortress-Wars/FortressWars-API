package net.fortresswars.events.projectiles;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.events.FortressWarsCancellableEvent;
import org.bukkit.entity.LargeFireball;

import javax.annotation.Nullable;

public class FWDeflectFireballEvent extends FortressWarsCancellableEvent {

    private final LargeFireball fireball;
    private final FortressWarsEntity fireballOwner;
    private final FortressWarsEntity source;

    public FWDeflectFireballEvent(LargeFireball fireball, FortressWarsEntity fireballOwner, @Nullable FortressWarsEntity source) {
        this.fireball = fireball;
        this.fireballOwner = fireballOwner;
        this.source = source;
    }

    public LargeFireball getFireball() {
        return fireball;
    }

    public FortressWarsEntity getFireballOwner() {
        return fireballOwner;
    }

    public FortressWarsEntity getSource() {
        return source;
    }
}
