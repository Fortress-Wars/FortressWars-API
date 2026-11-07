package net.fortresswars.events.kits;

import net.fortresswars.core.entities.FortressWarsPlayer;
import org.bukkit.inventory.ItemStack;

public class FWUseHealingPotionEvent extends FWUsePotionEvent {

    public FWUseHealingPotionEvent(FortressWarsPlayer player, ItemStack potion, PotionUseTrigger trigger, double potency) {
        super(player, potion, trigger, potency);
    }
}
