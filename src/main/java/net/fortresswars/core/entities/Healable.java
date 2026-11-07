package net.fortresswars.core.entities;

import net.fortresswars.core.player.FWHealingSource;

public interface Healable {

    double heal(double amount, FWHealingSource healingSourceType, FortressWarsEntity source);

    double heal(double amount, FWHealingSource healingSourceType);

    double getHealth();

    double getMaxHealth();

    boolean isAtMaxHP();
}
