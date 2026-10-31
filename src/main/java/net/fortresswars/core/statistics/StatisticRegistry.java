package net.fortresswars.core.statistics;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.core.tasks.PauseableTask;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class StatisticRegistry {

    // Statistic Observers
    private static final List<StatisticObserver> observers = new CopyOnWriteArrayList<>();
    private PauseableTask notifyStatisticObserversTask;

    /**
     * Register a statistic observer.
     * @param observer the observer to register.
     */
    public static void registerObserver(StatisticObserver observer) {
        observers.add(observer);
    }

    /**
     * Unregister a statistic observer.
     * @param observer the observer to unregister.
     */
    public static void unregisterObserver(StatisticObserver observer) {
        observers.remove(observer);
    }

    /**
     * Notify the observers of the statistic deltas.
     * @param player the player to notify about.
     * @param deltas the statistic deltas.
     */
    public static void notifyObservers(FortressWarsEntity player, Map<FWStat, Double> deltas) {
        for (final var observer : observers) {
            observer.onFlush(player, deltas);
        }
    }
}
