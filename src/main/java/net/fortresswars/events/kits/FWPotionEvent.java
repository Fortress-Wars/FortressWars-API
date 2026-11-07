package net.fortresswars.events.kits;

import net.fortresswars.core.entities.FortressWarsPlayer;
import net.fortresswars.events.FortressWarsCancellableEvent;
import org.bukkit.inventory.ItemStack;

public class FWPotionEvent extends FortressWarsCancellableEvent {

    private final FortressWarsPlayer player;
    private final ItemStack potion;

    public FWPotionEvent(final FortressWarsPlayer player, final ItemStack potion) {
        this.player = player;
        this.potion = potion;
    }

    public FortressWarsPlayer getPlayer() {
        return player;
    }

    public ItemStack getPotion() {
        return potion;
    }
}
