package net.fortresswars.events.damage;

import net.fortresswars.core.entities.FortressWarsPlayer;
import net.fortresswars.helpers.ColorHelper;

import javax.annotation.Nullable;

public class FWPlayerDeathEvent extends FWDeathEvent {

    private final FortressWarsPlayer player;
    private final @Nullable FortressWarsPlayer killerPlayer;
    private final String deathMessage;

    public FWPlayerDeathEvent(FortressWarsPlayer player, @Nullable FortressWarsPlayer killerPlayer, FWDamageEvent lastDamageEvent, double distance, String deathMessage) {
        super(player, killerPlayer, lastDamageEvent, distance);
        this.player = player;
        this.killerPlayer = killerPlayer;
        this.deathMessage = deathMessage;
    }

    public String getDeathMessage() {
        return deathMessage;
    }

    public FortressWarsPlayer getPlayer() {
        return player;
    }

    public @Nullable FortressWarsPlayer getKillerPlayer() {
        return killerPlayer;
    }

    public String getUnformattedDeathMessage() {
        return deathMessage.replaceAll(ColorHelper.COLOR_CODES_REGEX, "");
    }
}
