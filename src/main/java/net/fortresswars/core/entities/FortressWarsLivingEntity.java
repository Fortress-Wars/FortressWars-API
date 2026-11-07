package net.fortresswars.core.entities;

import net.fortresswars.core.effects.Inflictable;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public interface FortressWarsLivingEntity extends FortressWarsEntity, Inflictable {

    @NotNull LivingEntity getLivingEntity();
}
