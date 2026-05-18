/*
 * Name: MapType
 * Author: Peter Cesmegi
 * Description: Different Map types for fortress wars 3
 */

package net.fortresswars.core.maps;

public enum MapType {
    B("Build"),
    BAB("Build And Break"),
    NB("Non-Build"),
    NBAB("Non-Build And Break");

    private final String name;

    MapType(String mapType) {
        this.name = mapType;
    }

    public String getName() {
        return name;
    }
}
