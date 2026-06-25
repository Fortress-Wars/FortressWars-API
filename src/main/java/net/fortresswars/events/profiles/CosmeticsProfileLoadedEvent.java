package net.fortresswars.events.profiles;

import net.fortresswars.core.profiles.CosmeticsProfile;

public class CosmeticsProfileLoadedEvent extends CosmeticsProfileEvent {

    public CosmeticsProfileLoadedEvent(CosmeticsProfile profile) {
        super(profile);
    }
}
