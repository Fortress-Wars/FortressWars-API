package net.fortresswars.core.entities;

import net.fortresswars.core.effects.Inflictable;
import org.bukkit.entity.LivingEntity;

public interface FortressWarsLivingEntity extends FortressWarsEntity, Inflictable {

    LivingEntity getLivingEntity();
}
