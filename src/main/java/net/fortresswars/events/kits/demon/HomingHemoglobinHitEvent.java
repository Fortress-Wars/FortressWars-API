package net.fortresswars.events.kits.demon;

import net.fortresswars.core.damage.FWDamageCause;
import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.events.projectiles.FWCustomProjectileHitEvent;
import org.bukkit.block.Block;

public class HomingHemoglobinHitEvent extends FWCustomProjectileHitEvent {

    public HomingHemoglobinHitEvent(FortressWarsEntity shooter, Block block, double damage, FWDamageCause damageCause) {
        super(shooter, block, damage, damageCause);
    }

    public HomingHemoglobinHitEvent(FortressWarsEntity shooter, FortressWarsEntity entity, double damage, FWDamageCause damageCause) {
        super(shooter, entity, damage, damageCause);
    }
}
