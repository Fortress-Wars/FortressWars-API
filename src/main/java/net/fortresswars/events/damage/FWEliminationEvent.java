package net.fortresswars.events.damage;

import net.fortresswars.core.damage.FWDamageCause;
import net.fortresswars.core.entities.FortressWarsPlayer;
import net.fortresswars.events.FortressWarsCancellableEvent;
import net.fortresswars.helpers.ColorHelper;

import java.util.HashSet;
import java.util.Set;

public class FWEliminationEvent extends FortressWarsCancellableEvent {

    private final FortressWarsPlayer playerEliminated;
    private final FortressWarsPlayer killer;
    private final Set<FortressWarsPlayer> elimators;
    private final Set<FortressWarsPlayer> assistors;
    private final String deathMessage;
    private final double distance;
    private final FWDamageEvent lastDamageEvent;

    public FWEliminationEvent(FortressWarsPlayer playerEliminated, FortressWarsPlayer killer, FWDamageEvent lastDamageEvent, String deathMessage, double distance, Set<FortressWarsPlayer> assistPlayerList) {
        this.playerEliminated = playerEliminated;
        this.killer = killer;
        this.distance = distance;
        this.lastDamageEvent = lastDamageEvent;
        this.deathMessage = deathMessage;
        assistors = new HashSet<>(assistPlayerList.size());
        assistors.addAll(assistPlayerList);
        elimators = new HashSet<>(assistPlayerList.size() + 1);
        elimators.add(killer);
        elimators.addAll(assistors);
    }

    public FortressWarsPlayer getEliminated() {
        return playerEliminated;
    }

    public FortressWarsPlayer getKiller() {
        return killer;
    }

    public FWDamageCause getDamageCause() {
        return lastDamageEvent.getDamageCause();
    }

    public FWDamageEvent getLastDamageEvent() {
        return lastDamageEvent;
    }

    public Set<FortressWarsPlayer> getEliminators() {
        return elimators;
    }

    public Set<FortressWarsPlayer> getAssistors() {
        return assistors;
    }

    public double getDistance() {
        return distance;
    }

    public String getDeathMessage() {
        return deathMessage;
    }

    public String getUnformattedDeathMessage() {
        return deathMessage.replaceAll(ColorHelper.COLOR_CODES_REGEX, "");
    }

    public boolean isKiller(FortressWarsPlayer fwe) {
        return fwe == killer;
    }

    public boolean isEliminator(FortressWarsPlayer fwe) {
        return elimators.contains(fwe);
    }

    public boolean isSuicide() {
        return isKiller(playerEliminated);
    }
}
