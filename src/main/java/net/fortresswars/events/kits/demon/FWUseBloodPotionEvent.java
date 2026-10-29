package net.fortresswars.events.kits.demon;

import net.fortresswars.core.entities.FortressWarsPlayer;
import net.fortresswars.events.kits.FWUsePotionEvent;
import org.bukkit.inventory.ItemStack;

public class FWUseBloodPotionEvent extends FWUsePotionEvent {

    public FWUseBloodPotionEvent(FortressWarsPlayer player, ItemStack potion, PotionUseTrigger trigger, double potency) {
        super(player, potion, trigger, potency);
    }
}
