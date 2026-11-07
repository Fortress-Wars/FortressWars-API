package net.fortresswars.core.entities;

import java.util.Set;

public interface Assistable extends Combatable {

    void addBuffAssist(FortressWarsEntity fwe);

    void addBuffAssist(FortressWarsEntity fwe, int duration);

    void clearBuffAssists();

    void removeBuffAssist(FortressWarsEntity fwe);

    Set<FortressWarsEntity> getBuffAssists();

    void addAssist(FortressWarsEntity fwe);

    void addAssist(FortressWarsEntity fwe, int duration);

    void clearAssists();

    void removeAssist(FortressWarsEntity fwe);

    Set<FortressWarsEntity> getAssists();
}
