package net.fortresswars.events.profiles;

import net.fortresswars.core.profiles.PlayerProfile;

public class PlayerProfileSavedEvent extends PlayerProfileEvent {

    public PlayerProfileSavedEvent(PlayerProfile profile) {
        super(profile);
    }
}
