package net.fortresswars.core.sponges;

import net.fortresswars.util.FWNumberFormat;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

public record SpongeDestination (
        double x,
        double y,
        double z,
        double height
) {
    public static SpongeDestination from(Location location, double height) {
        return new SpongeDestination(location.getX(), location.getY(), location.getZ(), height);
    }

    @Override
    public @NotNull String toString() {
        final var xStr = FWNumberFormat.DOUBLE.formatValue(x);
        final var yStr = FWNumberFormat.DOUBLE.formatValue(y);
        final var zStr = FWNumberFormat.DOUBLE.formatValue(z);
        final var heightStr = FWNumberFormat.DOUBLE.formatValue(height);
        return "Destination: (" + xStr + ", " + yStr + ", " + zStr + "): Height: " + heightStr;
    }
}
