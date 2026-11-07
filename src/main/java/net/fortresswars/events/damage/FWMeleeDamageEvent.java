package net.fortresswars.events.damage;

import net.fortresswars.core.damage.FWDamageCause;
import net.fortresswars.core.entities.FortressWarsEntity;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class FWMeleeDamageEvent extends FWDamageByEntityEvent {

    private final ItemStack weapon;

    public FWMeleeDamageEvent(FortressWarsEntity entity, FortressWarsEntity source, FWDamageCause damageCause, EntityDamageEvent.DamageCause minecraftCause, double damage, double damageThatHitShield, ItemStack weapon) {
        super(entity, source, damageCause, minecraftCause, damageThatHitShield, damage);
        this.weapon = weapon;
    }

    /**
     * Returns the weapon used to attack
     * @return ItemStack reference (can be null)
     */
    public ItemStack getWeapon() {
        return weapon;
    }
}
