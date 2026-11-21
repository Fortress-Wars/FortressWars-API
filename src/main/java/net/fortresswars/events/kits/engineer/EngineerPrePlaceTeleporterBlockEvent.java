package net.fortresswars.events.kits.engineer;

import net.fortresswars.core.entities.FortressWarsPlayer;
import net.fortresswars.core.kits.abilities.AbilityID;
import net.fortresswars.core.kits.engineer.EngineerTeleporter;
import net.fortresswars.events.FortressWarsCancellableEvent;
import org.bukkit.block.Block;

public class EngineerPrePlaceTeleporterBlockEvent extends FortressWarsCancellableEvent {

    private EngineerTeleporter teleporterEntrance;
    private EngineerTeleporter teleporterExit;
    private final FortressWarsPlayer user;
    private final Block block;
    private final AbilityID abilityID;

    public EngineerPrePlaceTeleporterBlockEvent(FortressWarsPlayer user, Block block, AbilityID abilityID) {
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

    public EngineerTeleporter getTeleporterEntrance() {
        return teleporterEntrance;
    }

    public void setEntrance(EngineerTeleporter teleporterEntrance) {
        this.teleporterEntrance = teleporterEntrance;
    }

    public EngineerTeleporter getTeleporterExit() {
        return teleporterExit;
    }

    public void setExit(EngineerTeleporter teleporterExit) {
        this.teleporterExit = teleporterExit;
    }
}
