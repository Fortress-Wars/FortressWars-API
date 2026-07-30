package net.fortresswars.events.kits;

import net.fortresswars.core.entities.FortressWarsPlayer;
import org.bukkit.inventory.ItemStack;

public class FWUseManaPotionEvent extends FWUsePotionEvent {

    public FWUseManaPotionEvent(FortressWarsPlayer player, ItemStack potion, PotionUseTrigger trigger, double potency) {
        super(player, potion, trigger, potency);
    }
}
