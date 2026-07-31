package net.fortresswars.core.games;

import net.fortresswars.core.gamerules.Gamerule;
import net.fortresswars.core.maps.FWMap;

public interface Game {

    Gamerule getGamerule();

    FWMap getMap();
}
