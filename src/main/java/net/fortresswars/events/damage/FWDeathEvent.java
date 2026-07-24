package net.fortresswars.events.damage;

import net.fortresswars.core.damage.FWDamageCause;
import net.fortresswars.core.entities.FortressWarsPlayer;
import net.fortresswars.events.FortressWarsCancellableEvent;
import net.fortresswars.helpers.ColorHelper;

public class FWDeathEvent extends FortressWarsCancellableEvent {

    private final FortressWarsPlayer player;
    private final FWDamageEvent lastDamageEvent;
    private final FortressWarsPlayer killer;
    private final String deathMessage;
    private final double distance;

    public FWDeathEvent(FortressWarsPlayer player, FortressWarsPlayer killer, FWDamageEvent lastDamageEvent, String deathMessage, double distance) {
        this.player = player;
        this.killer = killer;
        this.lastDamageEvent = lastDamageEvent;
        this.deathMessage = deathMessage;
        this.distance = distance;
    }

    public FortressWarsPlayer getPlayer() {
        return player;
    }

    public FortressWarsPlayer getKiller() {
        return killer;
    }

    public FWDamageCause getDamageCause() {
        if (lastDamageEvent == null) {
            return null;
        }
        return lastDamageEvent.getDamageCause();
    }

    public FWDamageEvent getDamageEvent() {
        return lastDamageEvent;
    }

    public double getDistanceFromKiller() {
        return distance;
    }

    public String getDeathMessage() {
        return deathMessage;
    }

    public String getUnformattedDeathMessage() {
        return deathMessage.replaceAll(ColorHelper.COLOR_CODES_REGEX, "");
    }

    public boolean isSuicide() {
        return this.player == this.killer;
    }
}
