package net.fortresswars.events.profiles;

import net.fortresswars.core.profiles.PlayerProfile;

public class PlayerProfileLoadedEvent extends PlayerProfileEvent {

    public PlayerProfileLoadedEvent(PlayerProfile profile) {
        super(profile);
    }
}
