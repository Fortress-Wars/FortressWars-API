package net.fortresswars.events.kits.engineer;

import net.fortresswars.core.entities.FortressWarsPlayer;
import net.fortresswars.core.kits.abilities.AbilityID;
import net.fortresswars.events.FortressWarsCancellableEvent;
import org.bukkit.block.Block;

public class EngineerPrePlaceBlockEvent extends FortressWarsCancellableEvent {

    private final FortressWarsPlayer user;
    private final Block block;
    private final AbilityID abilityID;

    public EngineerPrePlaceBlockEvent(FortressWarsPlayer user, Block block, AbilityID abilityID) {
        this.user = user;
        this.block = block;
        this.abilityID = abilityID;
    }

    public FortressWarsPlayer getUser() {
        return user;
    }

    public Block getBlock() {
        return block;
    }

    public AbilityID getAbilityID() {
        return abilityID;
    }
}
