package net.fortresswars.events.kits.engineer;

import net.fortresswars.core.entities.FortressWarsPlayer;
import net.fortresswars.core.kits.engineer.EngineerTeleporter;
import net.fortresswars.events.FortressWarsCancellableEvent;

public class EngineerPreTeleportEvent extends FortressWarsCancellableEvent {

    private final EngineerTeleporter entrance;
    private final FortressWarsPlayer teleportee;

    private EngineerTeleporter exit;
    private boolean canUserTakeTeleporter;
    private boolean hasSetExit;

    public EngineerPreTeleportEvent(EngineerTeleporter entrance, FortressWarsPlayer teleportee) {
        this.entrance = entrance;
        this.teleportee = teleportee;
        this.canUserTakeTeleporter = false;
        this.hasSetExit = false;
    }

    public EngineerTeleporter getEntranceTeleporter() {
        return entrance;
    }

    public EngineerTeleporter getExitTeleporter() {
        return exit;
    }

    public FortressWarsPlayer getTeleportee() {
        return teleportee;
    }

    public void setExit(EngineerTeleporter exit) {
        if (hasSetExit) return;
        this.exit = exit;
        hasSetExit = true;
    }

    public boolean canUserTakeTeleporter() {
        return canUserTakeTeleporter;
    }

    public void setCanUserTakeTeleporter(boolean canUserTakeTeleporter) {
        this.canUserTakeTeleporter = canUserTakeTeleporter;
    }

    public boolean hasSetExit() {
        return hasSetExit;
    }
}
