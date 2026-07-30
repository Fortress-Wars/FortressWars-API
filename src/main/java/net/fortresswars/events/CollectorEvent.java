package net.fortresswars.events;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class CollectorEvent<T> extends FortressWarsEvent {

    protected final Predicate<T> predicateT;
    protected final Set<T> collectedT;
    public CollectorEvent(Predicate<T> predicateT) {
        this.predicateT = predicateT;
        this.collectedT = new HashSet<>();
    }

    public boolean check(T t) {
        if (t == null) return false;
        if (!predicateT.test(t)) return false;
        collectedT.add(t);
        return true;
    }

    public Set<T> getCollected() {
        return collectedT;
    }
}
