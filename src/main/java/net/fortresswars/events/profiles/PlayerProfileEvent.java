package net.fortresswars.events.profiles;

import net.fortresswars.core.profiles.PlayerProfile;
import net.fortresswars.events.FortressWarsEvent;

public class PlayerProfileEvent extends FortressWarsEvent {

    private final PlayerProfile profile;

    public PlayerProfileEvent(PlayerProfile profile) {
        this.profile = profile;
    }

    public PlayerProfile getProfile() {
        return profile;
    }
}
