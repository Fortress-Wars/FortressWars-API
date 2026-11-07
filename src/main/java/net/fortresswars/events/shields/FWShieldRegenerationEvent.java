package net.fortresswars.events.shields;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.events.FortressWarsCancellableEvent;
import org.bukkit.inventory.ItemStack;

public class FWShieldRegenerationEvent extends FortressWarsCancellableEvent {

    private final FortressWarsEntity entity;
    private final ItemStack shield;
    private final int currentShieldDamage;
    private int durabilityChangeBy;

    public FWShieldRegenerationEvent(FortressWarsEntity entity, ItemStack shield, int currentShieldDamage, int durabilityChangeBy) {
        this.entity = entity;
        this.shield = shield;
        this.currentShieldDamage = currentShieldDamage;
        this.durabilityChangeBy = durabilityChangeBy;
    }

    public FortressWarsEntity getEntity() {
        return entity;
    }

    public ItemStack getShield() {
        return shield;
    }

    public int getCurrentShieldDamage() {
        return currentShieldDamage;
    }

    public int getDurabilityChangeBy() {
        return durabilityChangeBy;
    }

    public void setDurabilityChangeBy(int durabilityChangeBy) {
        this.durabilityChangeBy = durabilityChangeBy;
    }
}
