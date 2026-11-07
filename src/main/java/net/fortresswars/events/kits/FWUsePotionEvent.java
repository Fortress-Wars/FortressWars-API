package net.fortresswars.events.kits;

import net.fortresswars.core.entities.FortressWarsPlayer;
import org.bukkit.inventory.ItemStack;

public class FWUsePotionEvent extends FWPotionEvent {

    private final PotionUseTrigger trigger;
    private double potency;

    public enum PotionUseTrigger {
        CLICK,
        AUTO_POT
    }

    public FWUsePotionEvent(FortressWarsPlayer player, ItemStack potion, PotionUseTrigger trigger, double potency) {
        super(player, potion);
        this.trigger = trigger;
        this.potency = potency;
    }

    public PotionUseTrigger getTrigger() {
        return trigger;
    }

    public double getPotency() {
        return potency;
    }

    public void setPotency(double potency) {
        this.potency = potency;
    }
}
