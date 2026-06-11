package net.fortresswars.events;

import net.fortresswars.core.profiles.PlayerProfile;

public class ProfileSavedEvent extends ProfileEvent {

    public ProfileSavedEvent(PlayerProfile profile) {
        super(profile);
    }
}
