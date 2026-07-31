package net.fortresswars.core.games.states;

public enum EndReason {
    PLAYERS_ELIMINATED("Players Eliminated"),
    MANUALLY_ENDED("Manually Ended"),
    TIME_ELAPSED("Time Elapsed"),
    HEALTH_DECAYED("Health Decayed"),
    NOT_CAPTURED("Not Captured"),
    FULLY_CONTROLLED("Fully Controlled"),
    NO_PLAYERS("No Players"),
    BEACON_DESTROYED("Beacon Destroyed"),;

    private final String friendlyText;

    EndReason(String friendlyText) {
        this.friendlyText = friendlyText;
    }

    public String getFriendlyText() {
        return friendlyText;
    }
}
