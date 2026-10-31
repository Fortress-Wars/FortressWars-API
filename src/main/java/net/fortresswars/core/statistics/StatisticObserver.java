package net.fortresswars.core.statistics;

import net.fortresswars.core.entities.FortressWarsEntity;

import java.util.Map;

public interface StatisticObserver {
    void onFlush(FortressWarsEntity entity, Map<FWStat, Double> deltas);
}
