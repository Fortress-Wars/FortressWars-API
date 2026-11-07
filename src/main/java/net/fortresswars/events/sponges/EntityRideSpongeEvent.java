package net.fortresswars.events.sponges;

import net.fortresswars.core.sponges.SpongeDestination;
import net.fortresswars.events.FortressWarsCancellableEvent;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;

public class EntityRideSpongeEvent extends FortressWarsCancellableEvent {

    private final LivingEntity entity;
    private final Block block;
    private final String type;
    private final String spongeTeam;
    private final SpongeDestination spongeDestination;

    public EntityRideSpongeEvent(LivingEntity entity, Block block, String type, String spongeTeam, SpongeDestination spongeDestination) {
        this.entity = entity;
        this.block = block;
        this.type = type;
        this.spongeTeam = spongeTeam;
        this.spongeDestination = spongeDestination;
    }

    public LivingEntity getEntity() {
        return entity;
    }

    public Block getBlock() {
        return block;
    }

    public String getType() {
        return type;
    }

    public String getSpongeTeam() {
        return spongeTeam;
    }

    public SpongeDestination getSpongeDestination() {
        return spongeDestination;
    }
}
