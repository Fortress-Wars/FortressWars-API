package net.fortresswars.events.damage;

import net.fortresswars.core.damage.FWDamageCause;
import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.events.FortressWarsEvent;
import org.bukkit.event.entity.EntityDamageEvent;

@SuppressWarnings("unused")
public class FWDamageResultEvent extends FortressWarsEvent {

    private final FortressWarsEntity entity;
    private final FWDamageEvent event;
    private final double damage;

    /**
     * @param event The damage event
     * @param damage amount of damage from this damage instance
     */
    public FWDamageResultEvent(FWDamageEvent event, double damage) {
        this.entity = event.getEntity();
        this.event = event;
        this.damage = damage;
    }

    public FortressWarsEntity getEntity() {
        return entity;
    }

    public FortressWarsEntity getDamager() {
        if (event instanceof FWDamageByEntityEvent fwDamageByEntityEvent) {
           return fwDamageByEntityEvent.getSource();
        }
        return null;
    }

    public double getDamage() {
        return damage; // Don't use event damage, because the damage passed in accounts for damage mitigation and number of hearts remaining.
    }

    public FWDamageCause getDamageCause() {
        return event.getDamageCause();
    }

    public EntityDamageEvent.DamageCause getMinecraftCause() {
        return event.getMinecraftCause();
    }
}
