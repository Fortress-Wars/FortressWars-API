package net.fortresswars.events.kits;

import net.fortresswars.core.entities.FortressWarsPlayer;
import org.bukkit.inventory.ItemStack;

public class FWRegeneratePotionEvent extends FWPotionEvent {

    public FWRegeneratePotionEvent(FortressWarsPlayer player, ItemStack potion) {
        super(player, potion);
    }
}
