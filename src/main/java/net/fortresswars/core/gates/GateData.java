package net.fortresswars.core.gates;

import org.bukkit.Location;
import org.bukkit.Material;

public record GateData (
        Location dataBlockLocation,
        Location pos1,
        Location pos2,
        Material material,
        boolean isOpen
) {
}
