package net.fortresswars.core.entities;

public interface Memorious {

    boolean hasMemory();

    int getMemory();

    void loseMemory();

    void gainMemory();

    void resetMemory();
}
