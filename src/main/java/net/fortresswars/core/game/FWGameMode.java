package net.fortresswars.core.game;

public enum FWGameMode {
    CLASSIC("Classic"),
    KOTH("King of the Hill"),
    AD("Attack and Defend");

    private final String friendlyName;

    FWGameMode(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public String getFriendlyName() {
        return friendlyName;
    }
}
