package net.fortresswars.events.profiles;

import net.fortresswars.core.profiles.PlayerProfile;

public class PlayerProfileDeletedEvent extends PlayerProfileEvent {

    public PlayerProfileDeletedEvent(PlayerProfile profile) {
        super(profile);
    }
}
