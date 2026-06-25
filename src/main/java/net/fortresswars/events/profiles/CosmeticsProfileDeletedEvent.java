package net.fortresswars.events.profiles;

import net.fortresswars.core.profiles.CosmeticsProfile;

public class CosmeticsProfileDeletedEvent extends CosmeticsProfileEvent {
    public CosmeticsProfileDeletedEvent(CosmeticsProfile profile) {
        super(profile);
    }
}
