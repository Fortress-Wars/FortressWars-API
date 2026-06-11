package net.fortresswars.events;

import net.fortresswars.core.profiles.PlayerProfile;

public class ProfileEvent extends FortressWarsEvent {

    private final PlayerProfile profile;

    public ProfileEvent(PlayerProfile profile) {
        this.profile = profile;
    }

    public PlayerProfile getProfile() {
        return profile;
    }
}
