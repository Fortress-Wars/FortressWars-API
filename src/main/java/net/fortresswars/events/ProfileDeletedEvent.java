package net.fortresswars.events;

import net.fortresswars.core.profiles.PlayerProfile;

public class ProfileDeletedEvent extends ProfileEvent {

    public ProfileDeletedEvent(PlayerProfile profile) {
        super(profile);
    }
}
