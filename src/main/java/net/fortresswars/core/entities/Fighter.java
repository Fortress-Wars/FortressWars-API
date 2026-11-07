package net.fortresswars.core.entities;

import java.util.UUID;

public interface Fighter extends Attackable, Healable, Assistable {

    UUID getUUID();

    String getName();

    void setNoDamageTicks(int ticks);

    void resetNoDamageTicks();

    boolean isTargetable();

    boolean canTarget(Fighter fighter);
}
