package net.fortresswars.core.kits.abilities.shields;

public enum ShieldDamageType {
    // No Damage to the target and no damage to shields
    IMMUNE(false, false, false, false),

    // Does no shield damage and will not damage target if they are blocking
    RESPECT(true, false, false, false),

    // Damages the shield if the target is blocking & damages the target if they are not
    DAMAGE(true, false, true, false),

    // Break the shield if the target is blocking & damages the target if they are not
    BREAK(true, false, false, true),

    // Damage the shield and damage the target regardless if they are blocking or not
    PIERCE(true, true, true, false),

    // Deal damage to the target regarless if they are blocking or not (does not damage shields)
    IGNORE(true, true, false, false),

    // Damages shields if the target is blocking, will not damage the target if they are not
    ONLY_DAMAGE(false, false, true, false),

    // Breaks shields if the target is blocking, will not damage the target if they are not
    ONLY_BREAK(false, false, false, true),

    ;

    private final boolean doesDamageEntity;
    private final boolean doesDamageIfBlocking;
    private final boolean doesDamageShield;
    private final boolean doesBreakShield;

    ShieldDamageType(boolean doesDamageEntity, boolean doesDamageIfBlocking, boolean doesDamageShield, boolean doesBreakShield) {
        this.doesDamageEntity = doesDamageEntity;
        this.doesDamageIfBlocking = doesDamageIfBlocking;
        this.doesDamageShield = doesDamageShield;
        this.doesBreakShield = doesBreakShield;
    }

    public boolean doesEntityDamage() {
        return doesDamageEntity;
    }

    public boolean doesDamageIfBlocking() {
        return doesDamageIfBlocking;
    }

    public boolean doesDamageShield() {
        return doesDamageShield;
    }

    public boolean doesBreakShield() {
        return doesBreakShield;
    }
}
