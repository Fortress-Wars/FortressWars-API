package net.fortresswars.events.damage;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.events.FortressWarsEvent;
import org.bukkit.Location;

public class FWEMPEvent extends FortressWarsEvent {

    public enum EMPType {
        HACK,
        STUN
    }

    private final EMPType type;
    private final FortressWarsEntity source;
    private final Location location;
    private final int duration;
    private final double radius;

    public FWEMPEvent(EMPType type, Location location, double radius, int duration, FortressWarsEntity source) {
        this.type = type;
        this.location = location;
        this.duration = duration;
        this.radius = radius;
        this.source = source;
    }

    public EMPType getType() {
        return type;
    }

    public Location getLocation() {
        return location;
    }

    public int getDuration() {
        return duration;
    }

    public double getRadius() {
        return radius;
    }

    public FortressWarsEntity getSource() {
        return source;
    }
}
