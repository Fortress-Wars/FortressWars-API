package net.fortresswars.core.entities;

import net.fortresswars.core.data.PersistentData;
import net.fortresswars.core.data.PersistentDataKey;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.Interaction;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class DisplayInteractionEntity {

    private final @NotNull BlockDisplay display;
    private final @NotNull Interaction interaction;

    public DisplayInteractionEntity(@NotNull Location location, @NotNull BlockData blockData, @NotNull BlockFace facing) {
        final var alignBase = computeBaseAlignment(facing);
        this.display = createDisplay(location, blockData, alignBase);
        this.interaction = createInteractionEntity(location, alignBase);
    }

    private Quaternionf computeBaseAlignment(@NotNull BlockFace blockFace) {
        final var localBaseDir = new Vector3f(0f, -1f, 0f);
        final var targetBaseDir = new Vector3f(
                -blockFace.getModX(),
                -blockFace.getModY(),
                -blockFace.getModZ()
        );

        if (targetBaseDir.lengthSquared() < 1e-6f) {
            targetBaseDir.set(0f, -1f, 0f);
        } else {
            targetBaseDir.normalize();
        }

        return new Quaternionf().rotationTo(localBaseDir, targetBaseDir);
    }

    private BlockDisplay createDisplay(@NotNull Location location, @NotNull BlockData blockData, @NotNull Quaternionf alignBase) {
        final var world = location.getWorld();
        return world.spawn(location, BlockDisplay.class, (entity -> {
            entity.setBlock(blockData);
            final var transform = new Matrix4f()
                    .translate(0.5f, 0.5f, 0.5f)
                    .rotate(alignBase)
                    .translate(-0.5f, -0.5f, -0.5f);
            entity.setTransformationMatrix(transform);
        }));
    }

    /**
     * Create a new Interaction entity to represent the engineer structure. This entity will be used for interaction and collision detection.
     * @param alignBase The base alignment of the engineer structure, used to calculate the interaction entity's dimensions.
     * @return A new Interaction entity representing the engineer structure
     */
    public Interaction createInteractionEntity(@NotNull Location location, Quaternionf alignBase) {
        final var world = this.display.getWorld();

        // Half-extents of a 1x1x1 block are 0.5 along each local axis
        final var xAxis = new Vector3f(0.5f, 0f, 0f).rotate(alignBase);
        final var yAxis = new Vector3f(0f, 0.5f, 0f).rotate(alignBase);
        final var zAxis = new Vector3f(0f, 0f, 0.5f).rotate(alignBase);

        float halfX = Math.abs(xAxis.x) + Math.abs(yAxis.x) + Math.abs(zAxis.x);
        float halfY = Math.abs(xAxis.y) + Math.abs(yAxis.y) + Math.abs(zAxis.y);
        float halfZ = Math.abs(xAxis.z) + Math.abs(yAxis.z) + Math.abs(zAxis.z);

        float width = Math.max(halfX * 2f, halfZ * 2f);
        float height = Math.max(0.1f, halfY * 2f);

        // Interaction entity origin is at the bottom-center of its cylinder
        final var spawnLocation = location.clone().add(0.5, 0, 0.5);
        return display.getWorld().spawn(spawnLocation, Interaction.class, interaction -> {
            interaction.setInteractionWidth(width);
            interaction.setInteractionHeight(height);
            interaction.setResponsive(true);
            PersistentData.setProperty(interaction, PersistentDataKey.HIT,1, null);
        });
    }

    public void delete() {
        this.display.remove();
        this.interaction.remove();
    }

    public @NotNull BlockDisplay getDisplay() {
        return display;
    }

    public @NotNull Interaction getInteraction() {
        return interaction;
    }
}
