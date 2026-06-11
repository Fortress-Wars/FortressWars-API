package net.fortresswars.events;

import net.fortresswars.core.profiles.PlayerProfile;

public class ProfileLoadedEvent extends ProfileEvent {

    public ProfileLoadedEvent(PlayerProfile profile) {
        super(profile);
    }
}
