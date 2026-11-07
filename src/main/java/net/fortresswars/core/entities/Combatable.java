package net.fortresswars.core.entities;

public interface Combatable {

    void addInCombatTag(FortressWarsEntity fwe);

    void removeInCombatTag(FortressWarsEntity fwe);

    boolean isInCombat();

    void clearInCombatTags();
}
