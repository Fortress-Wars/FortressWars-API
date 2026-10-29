package net.fortresswars.events.kits.abilities.spells;

import net.fortresswars.core.entities.FortressWarsPlayer;
import net.fortresswars.core.kits.abilities.spells.SpellID;
import net.fortresswars.events.FortressWarsCancellableEvent;
import net.fortresswars.util.Options;

public class FWCastSpellEvent extends FortressWarsCancellableEvent {

    private final FortressWarsPlayer player;
    private final SpellID spellID;
    private final Options options;
    private double cost;
    private int castCooldown;

    public FWCastSpellEvent(FortressWarsPlayer player, SpellID spellID, double cost, int castCooldown, Options spellOptions) {
        this.player = player;
        this.spellID = spellID;
        this.cost = cost;
        this.castCooldown = castCooldown;
        this.options = spellOptions;
    }

    public FortressWarsPlayer getPlayer() {
        return player;
    }

    public SpellID getSpellID() {
        return spellID;
    }

    public Options getOptions() {
        return options;
    }

    public double getCost() {
        return Math.max(0, cost);
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getCastCooldown() {
        return Math.max(0, castCooldown);
    }

    public void setCastCooldown(int castCooldown) {
        this.castCooldown = castCooldown;
    }
}
