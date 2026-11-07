package net.fortresswars.core.entities;

public interface Pauseable<T> {

    T pause();

    T unpause();

    boolean isPaused();
}
