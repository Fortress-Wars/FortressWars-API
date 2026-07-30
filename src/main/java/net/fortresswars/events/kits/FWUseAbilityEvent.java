package net.fortresswars.events.kits;

import net.fortresswars.core.entities.FortressWarsPlayer;
import net.fortresswars.core.kits.abilities.AbilityID;
import net.fortresswars.events.FortressWarsCancellableEvent;

public class FWUseAbilityEvent extends FortressWarsCancellableEvent {

    private final FortressWarsPlayer player;
    private final AbilityID abilityID;
    private final Action action;

    public enum Action {
        RIGHT_CLICK,
        RIGHT_CLICK_ENTITY,
        LEFT_CLICK,
    }

    public FWUseAbilityEvent(FortressWarsPlayer player, AbilityID abilityID, Action action) {
        this.player = player;
        this.abilityID = abilityID;
        this.action = action;
    }

    public FortressWarsPlayer getPlayer() {
        return player;
    }

    public AbilityID getAbilityID() {
        return abilityID;
    }

    public Action getAction() {
        return action;
    }
}
