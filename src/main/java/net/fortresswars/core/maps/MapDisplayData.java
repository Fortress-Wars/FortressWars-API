package net.fortresswars.core.maps;

import net.fortresswars.core.games.FWGameMode;
import org.bukkit.Material;

public record MapDisplayData (
        String id,
        String displayName,
        String contributors,
        Material icon,
        FWGameMode gamemode,
        MapType type
) {

}
