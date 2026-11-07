package net.fortresswars.events.blocks;

import net.fortresswars.core.damage.FWDamageCause;
import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.events.FortressWarsCancellableEvent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.Set;
import java.util.stream.Collectors;

public class FWExplodeBlocksResultEvent extends FortressWarsCancellableEvent {

    private final FortressWarsEntity source;
    private final Location center;
    private final double radius;
    private final FWDamageCause damageCause;
    private final Set<Block> explodedBlocks;
    private final Set<Material> blownUpMaterials;

    public FWExplodeBlocksResultEvent(FortressWarsEntity source, Location center, double radius, FWDamageCause damageCause, Set<Block> explodedBlocks) {
        this.source = source;
        this.center = center;
        this.radius = radius;
        this.damageCause = damageCause;
        this.explodedBlocks = explodedBlocks;
        this.blownUpMaterials = explodedBlocks.stream().map(Block::getType).collect(Collectors.toSet());
    }

    public FortressWarsEntity getSource() {
        return source;
    }

    public Location getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public FWDamageCause getDamageCause() {
        return damageCause;
    }

    public Set<Block> getExplodedBlocks() {
        return explodedBlocks;
    }

    public boolean isMaterialBlownUp(Set<Material> materials) {
        return blownUpMaterials.stream().anyMatch((materials::contains));
    }
}
