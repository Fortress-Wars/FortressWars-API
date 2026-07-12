package net.fortresswars.core.maps;

import java.util.Set;
import java.util.stream.Collectors;

public enum OfficialMaps {
    MAP_2CASTLES("map_2castles"),
    MAP_ASHLANDS("map_ashlands"),
    MAP_BIOHAZARD("map_biohazard"),
    MAP_BOOTCAMP("map_bootcamp"),
    MAP_BOOTCAMP_AD("map_bootcamp_ad"),
    MAP_CANDYLAND("map_candyland"),
    MAP_CAVERNS("map_caverns"),
    MAP_CLAY("map_clay"),
    MAP_CLAY_NB("map_clay_nb"),
    MAP_CLIFFS("map_cliffs"),
    MAP_COAST_CLASSIC("map_coast_classic"),
    MAP_COAST_KOTH("map_coast_koth"),
    MAP_COLLIERY("map_colliery"),
    MAP_FOREST("map_forest"),
    MAP_FROSTNOVA("map_frostnova"),
    MAP_HOTEL_MONSENOR("map_hotel_monsenor"),
    MAP_ICE("map_ice"),
    MAP_ICE_AD("map_ice_ad"),
    MAP_ICE_NB("map_ice_nb"),
    MAP_ISLANDS("map_islands"),
    MAP_LAZARUS("map_lazarus"),
    MAP_LEAFY_CANYON("map_leafy_canyon"),
    MAP_MOUNTAIN("map_mountain"),
    MAP_OASIS("map_oasis"),
    MAP_OVERGROWN("map_overgrown"),
    MAP_RAVINE("map_ravine"),
    MAP_RIVER("map_river"),
    MAP_SHIPS("map_ships"),
    MAP_SKYLANDS("map_skylands"),
    MAP_SOMBER_SWAMPS("map_somber_swamps"),
    MAP_SPAWN_RUINS_KOTH("map_spawn_ruins_koth"),
    MAP_UNDERWORLD("map_underworld"),
    MAP_URBAN("map_urban"),
    MAP_VALLEY("map_valley"),
    MAP_VALLEY_NB("map_valley_nb"),
    MAP_VOID("map_void"),
    MAP_VOID_KOTH("map_void_koth"),
    MAP_WALL("map_wall"),
    ;

    private final String id;

    OfficialMaps(String id) {
        this.id = id;
    }

    public static Set<String> getOfficialMapIDs() {
        return Set.of(OfficialMaps.values()).stream().map((officialMaps -> officialMaps.id)).collect(Collectors.toSet());
    }

    public String getId() {
        return id;
    }
}
