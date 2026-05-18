package net.fortresswars.events;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.core.player.FWHealingSource;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class FortressWarsHealEvent extends FortressWarsCancellableEvent {

    private final FortressWarsEntity entityHealed;
    private final @Nullable FortressWarsEntity healingSourceEntity;
    private final FWHealingSource healingSource;
    private final double healingAmount;

    public FortressWarsHealEvent(FortressWarsEntity entityHealed, double healingAmount, @Nullable FortressWarsEntity healingSourceEntity, @Nullable FWHealingSource healingSource) {
        this.entityHealed = entityHealed;
        this.healingSourceEntity = healingSourceEntity;
        this.healingSource = healingSource;
        this.healingAmount = healingAmount;
    }

    public FortressWarsEntity getHealed() {
        return entityHealed;
    }

    public @Nullable FortressWarsEntity getHealer() {
        return healingSourceEntity;
    }

    public FWHealingSource getHealingSource() {
        return healingSource;
    }

    public double getHealingAmount() {
        return healingAmount;
    }
}
