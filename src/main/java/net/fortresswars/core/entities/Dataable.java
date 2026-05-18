package net.fortresswars.core.entities;

import java.util.HashMap;

@Deprecated (forRemoval = true)
public interface Dataable {

    void setMiscData(String string, double value);

    void removeMiscData(String string);

    double getMiscData(String string);

    void deleteAllMiscData();

    void setData(String string, boolean value);

    void setData(String string, double value);

    double getData(String string);

    int getIntData(String string);

    boolean isDataTrue(String string);

    void resetData();

    HashMap<String, Double> getAllData();
}
