package net.fortresswars.events.profiles;

import net.fortresswars.core.profiles.CosmeticsProfile;
import net.fortresswars.events.FortressWarsEvent;

public class CosmeticsProfileEvent extends FortressWarsEvent {

    private final CosmeticsProfile profile;

    public CosmeticsProfileEvent(CosmeticsProfile profile) {
        this.profile = profile;
    }

    public CosmeticsProfile getProfile() {
        return profile;
    }
}
