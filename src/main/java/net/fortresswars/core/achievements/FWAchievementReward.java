package net.fortresswars.core.achievements;

public enum FWAchievementReward {
    TEN_CREDITS("10 Credits"),
    TWENTY_CREDITS("20 Credits"),
    THIRTY_CREDITS("30 Credits"),
    FORTY_CREDITS("40 Credits"),
    FIFTY_CREDITS("50 Credits"),
    ONE_HUNDRED_CREDITS("100 Credits"),
    TWO_HUNDRED_FIFTY_CREDITS("250 Credits"),
    FIVE_HUNDRED_CREDITS("500 Credits"),
    ONE_THOUSAND_CREDITS("1,000 Credits"),
    UNLOCK_KIT_FISH("Kit Fish"),
    UNLOCK_KIT_MATHEMATICIAN("Kit Mathematician"),
    ;

    private final String description;

    FWAchievementReward(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
