package net.fortresswars.events.profiles;

import net.fortresswars.core.profiles.CosmeticsProfile;

public class CosmeticsProfileSavedEvent extends CosmeticsProfileEvent {

    public CosmeticsProfileSavedEvent(CosmeticsProfile profile) {
        super(profile);
    }
}
