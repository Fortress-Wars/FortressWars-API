package net.fortresswars.events.kits;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.events.FortressWarsCancellableEvent;

public class FWDropEssenceEvent extends FortressWarsCancellableEvent {

    public static final int DEFAULT_ESSENCE_TO_DROP = 1;
    private final FortressWarsEntity deadEntity;
    private final FortressWarsEntity killerEntity;
    private int amountOfEssenceToDrop = DEFAULT_ESSENCE_TO_DROP;

    public FWDropEssenceEvent(FortressWarsEntity deadEntity, FortressWarsEntity killerEntity) {
        this.deadEntity = deadEntity;
        this.killerEntity = killerEntity;
    }

    public FortressWarsEntity getDeadEntity() {
        return deadEntity;
    }

    public FortressWarsEntity getKillerEntity() {
        return killerEntity;
    }

    public void addAmountOfEssenceToDrop(int amountOfEssenceToAdd) {
        this.amountOfEssenceToDrop = Math.max(amountOfEssenceToDrop + amountOfEssenceToAdd, DEFAULT_ESSENCE_TO_DROP);
    }

    public void setAmountOfEssenceToDrop(int amountOfEssenceToDrop) {
        this.amountOfEssenceToDrop = Math.max(amountOfEssenceToDrop, DEFAULT_ESSENCE_TO_DROP);
    }

    public int getAmountOfEssenceToDrop() {
        return amountOfEssenceToDrop;
    }
}
