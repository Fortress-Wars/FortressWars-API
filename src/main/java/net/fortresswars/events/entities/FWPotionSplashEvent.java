package net.fortresswars.events.entities;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.core.entities.FortressWarsLivingEntity;
import net.fortresswars.events.FortressWarsCancellableEvent;
import org.bukkit.entity.ThrownPotion;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FWPotionSplashEvent extends FortressWarsCancellableEvent {

    private final ThrownPotion potion;
    private final FortressWarsEntity shooter;
    private final Collection<FortressWarsLivingEntity> affectedEntities;
    private final Map<FortressWarsEntity, Double> intensityOverrideMap;

    public FWPotionSplashEvent(ThrownPotion potion, FortressWarsEntity shooter, Collection<FortressWarsLivingEntity> affectedEntities) {
        this.potion = potion;
        this.shooter = shooter;
        this.affectedEntities = affectedEntities;
        this.intensityOverrideMap = new HashMap<>();
    }

    public ThrownPotion getPotion() {
        return potion;
    }

    public FortressWarsEntity getShooter() {
        return shooter;
    }

    public Collection<FortressWarsLivingEntity> getAffectedEntities() {
        return affectedEntities;
    }

    public double getOverrideIntensity(FortressWarsEntity entity) {
        return intensityOverrideMap.getOrDefault(entity, 0d);
    }

    public void setOverrideIntensity(FortressWarsEntity entity, double intensity) {
        intensityOverrideMap.put(entity, intensity);
    }

    public boolean hasIntensityOverride(FortressWarsEntity entity) {
        return intensityOverrideMap.containsKey(entity);
    }
}
