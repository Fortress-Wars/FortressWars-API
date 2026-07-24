package net.fortresswars.helpers;

import net.fortresswars.core.entities.FortressWarsPlayer;
import net.fortresswars.events.blocks.FWPlaceBlockEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Levelled;
import org.bukkit.block.data.Waterlogged;
import org.bukkit.util.BoundingBox;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BlockHelper {

    public static final double ONE_BY_ONE_HITBOX_SIZE = 0.5;
    private static Set<Material> vegetationSet;

    public static boolean isZeroZero(Location location) {
        return location.getX() == 0 && location.getY() == 0 && location.getZ() == 0;
    }

    public static Location getBlockCenterLocation(Block block) {
        final BoundingBox boundingBox = block.getBoundingBox();
        final World world = block.getWorld();
        final Location newLocation = new Location(world, boundingBox.getCenterX(), boundingBox.getCenterY(), boundingBox.getCenterZ());

        // Check if zero, zero (This will happen for blocks such as air blocks)
        if (!isZeroZero(newLocation)) {
            return newLocation;
        }
        final Location blockLocation = block.getLocation();
        return blockLocation.add(0.5, 0.5, 0.5);
    }

    public static Location getBlockTopLocation(Block block) {
        final BoundingBox boundingBox = block.getBoundingBox();
        final World world = block.getWorld();
        final Location newLocation = new Location(world, boundingBox.getCenterX(), boundingBox.getMaxY(), boundingBox.getCenterZ());

        // Check if zero, zero (This will happen for blocks such as air blocks)
        if (!isZeroZero(newLocation)) {
            return newLocation;
        }
        final Location blockLocation = block.getLocation();
        return blockLocation.add(0.5, 1, 0.5);
    }

    public static Location getBlockBottomLocation(Block block) {
        final BoundingBox boundingBox = block.getBoundingBox();
        final World world = block.getWorld();
        final Location newLocation = new Location(world, boundingBox.getCenterX(), boundingBox.getMinY(), boundingBox.getCenterZ());

        // Check if zero, zero (This will happen for blocks such as air blocks)
        if (!isZeroZero(newLocation)) {
            return newLocation;
        }
        final Location blockLocation = block.getLocation();
        return blockLocation.add(0.5, 0, 0.5);
    }

    /**
     * Get all blocks in a spherical radius
     * @param location sphere's center lcoation
     * @param radius radius of sphere
     * @return Set of blocks in the sphere
     */
    public static Set<Block> getBlocksInRadius(Location location, double radius) {
        Set<Block> blocks = new HashSet<>();
        if (location == null || radius < 0) return blocks;

        final World world = location.getWorld();
        final double bx = location.getX();
        final double by = location.getY();
        final double bz = location.getZ();

        for (double x = bx - radius; x <= bx + radius; x++) {
            for (double y = by - radius; y <= by + radius; y++) {
                for (double z = bz - radius; z <= bz + radius; z++) {
                    Location newLoc = new Location(world, x, y, z);
                    if (newLoc.distance(location) > radius) continue;
                    blocks.add(newLoc.getBlock());
                }
            }
        }
        return blocks;
    }

    /**
     * Checks if the bounding box collides with any blocks that are not passable
     * @param world world where the bounding box is located
     * @param bb bounding box to check collision for
     * @param ignorePassable if we should include blocks that are passable (pressure plates, plants, etc)
     * @return true if bounding block collides with any block, false otherwise
     */
    public static boolean doesHitBoxCollideWithBlocks(World world, BoundingBox bb, boolean ignorePassable) {
        return !getBlocksCollidingWithHitBox(world, bb, ignorePassable).isEmpty();
    }

    /**
     * Checks if the bounding box collides with any blocks that are not passable
     * @param world world where the bounding box is located
     * @param bb bounding box to check collision for
     * @param ignorePassable if we should include blocks that are passable (open gates, plants, etc)
     *                       (Note: engineer pressure plates are considered non-passable
     *                       because projectiles can damage them)
     * @return List of block that the hitbox collides with
     */
    public static List<Block> getBlocksCollidingWithHitBox(World world, BoundingBox bb, boolean ignorePassable) {
        // Get every corner
        List<Location> corners = new ArrayList<>();
        corners.add(new Location(world, bb.getMinX(), bb.getMinY(), bb.getMinZ()));
        corners.add(new Location(world, bb.getMinX(), bb.getMinY(), bb.getMaxZ()));
        corners.add(new Location(world, bb.getMinX(), bb.getMaxY(), bb.getMinZ()));
        corners.add(new Location(world, bb.getMinX(), bb.getMaxY(), bb.getMaxZ()));
        corners.add(new Location(world, bb.getMaxX(), bb.getMinY(), bb.getMinZ()));
        corners.add(new Location(world, bb.getMaxX(), bb.getMinY(), bb.getMaxZ()));
        corners.add(new Location(world, bb.getMaxX(), bb.getMaxY(), bb.getMinZ()));
        corners.add(new Location(world, bb.getMaxX(), bb.getMaxY(), bb.getMaxZ()));

        // Making a set will remove duplicates
        final Set<Block> collidingBlocksSet = new HashSet<>(8);
        // Check that all corners' blocks are passable
        for (Location corner : corners) {
            final Block cornerBlock = corner.getBlock();
            final Material material = cornerBlock.getType();
            final BoundingBox cornerBB = cornerBlock.getBoundingBox();
            boolean isPassable = cornerBlock.isPassable() || material == Material.LADDER;
            boolean isBlackListedFromPassable = material == Material.HEAVY_WEIGHTED_PRESSURE_PLATE || material == Material.LIGHT_WEIGHTED_PRESSURE_PLATE;
            if (bb.overlaps(cornerBB)) {
                if (ignorePassable && isPassable && !isBlackListedFromPassable) continue;
                collidingBlocksSet.add(cornerBlock);
            }
        }

        return collidingBlocksSet.stream().distinct().toList();
    }

    /**
     * Call to hook into placing blocks through fortress wars
     * @param player the fortress wars placing blocks
     * @param block the block being placed
     * @param previousBlockState the old block state
     * @return true if the event is cancelled, false if it is not cancelled
     */
    public static boolean placeBlock(FortressWarsPlayer player, Block block, BlockState previousBlockState) {
        final FWPlaceBlockEvent event = new FWPlaceBlockEvent(player, block, previousBlockState);
        Bukkit.getPluginManager().callEvent(event);
        return event.isCancelled();
    }

    public static boolean isFireBlock(BlockData b) {
        if (b == null) return false;
        final Material material = b.getMaterial();
        if (material == Material.FIRE) return true;
        return material == Material.SOUL_FIRE;
    }

    public static boolean canReplaceBlock(Block b) {
        final Material material = b.getType();
        if (material == Material.SEA_PICKLE) return false; // An exception
        if (material == Material.SNOW) return true;
        if (material.isAir()) return true;
        if (material == Material.STRUCTURE_VOID) return true;
        if (isFireBlock(b.getBlockData())) return true;
        if (b.isLiquid()) return true;
        return isVegetation(b.getBlockData());
    }

    public static boolean isVegetation(BlockData blockData) {
        final Material material = blockData.getMaterial();
        if (vegetationSet == null) {
            vegetationSet = new HashSet<>();
            // 1.19.4 & Previous
            vegetationSet.add(Material.ACACIA_SAPLING);
            vegetationSet.add(Material.ALLIUM);
            vegetationSet.add(Material.AZALEA);
            vegetationSet.add(Material.AZURE_BLUET);
            vegetationSet.add(Material.BAMBOO_SAPLING);
            vegetationSet.add(Material.BEETROOT_SEEDS);
            vegetationSet.add(Material.BEETROOTS);
            vegetationSet.add(Material.BIG_DRIPLEAF);
            vegetationSet.add(Material.BIRCH_SAPLING);
            vegetationSet.add(Material.BLUE_ORCHID);
            vegetationSet.add(Material.BROWN_MUSHROOM);
            vegetationSet.add(Material.CARROTS);
            vegetationSet.add(Material.CAVE_VINES);
            vegetationSet.add(Material.CAVE_VINES_PLANT);
            vegetationSet.add(Material.CRIMSON_FUNGUS);
            vegetationSet.add(Material.CRIMSON_ROOTS);
            vegetationSet.add(Material.DANDELION);
            vegetationSet.add(Material.DARK_OAK_SAPLING);
            vegetationSet.add(Material.DEAD_BUSH);
            vegetationSet.add(Material.FERN);
            vegetationSet.add(Material.FLOWERING_AZALEA);
            vegetationSet.add(Material.FROGSPAWN);
            vegetationSet.add(Material.GLASS_BOTTLE);
            vegetationSet.add(Material.GLOW_BERRIES);
            vegetationSet.add(Material.GLOW_LICHEN);
            vegetationSet.add(Material.SHORT_GRASS);
            vegetationSet.add(Material.HANGING_ROOTS);
            vegetationSet.add(Material.JUNGLE_SAPLING);
            vegetationSet.add(Material.KELP);
            vegetationSet.add(Material.KELP_PLANT);
            vegetationSet.add(Material.LARGE_FERN);
            vegetationSet.add(Material.LILAC);
            vegetationSet.add(Material.LILY_OF_THE_VALLEY);
            vegetationSet.add(Material.LILY_PAD);
            vegetationSet.add(Material.MANGROVE_PROPAGULE);
            vegetationSet.add(Material.MELON_SEEDS);
            vegetationSet.add(Material.MELON_STEM);
            vegetationSet.add(Material.NETHER_SPROUTS);
            vegetationSet.add(Material.OAK_SAPLING);
            vegetationSet.add(Material.ORANGE_TULIP);
            vegetationSet.add(Material.OXEYE_DAISY);
            vegetationSet.add(Material.PEONY);
            vegetationSet.add(Material.PINK_TULIP);
            vegetationSet.add(Material.POPPY);
            vegetationSet.add(Material.POTATOES);
            vegetationSet.add(Material.PUMPKIN_STEM);
            vegetationSet.add(Material.PUMPKIN_SEEDS);
            vegetationSet.add(Material.RED_MUSHROOM);
            vegetationSet.add(Material.RED_TULIP);
            vegetationSet.add(Material.ROSE_BUSH);
            vegetationSet.add(Material.SEA_PICKLE);
            vegetationSet.add(Material.SEAGRASS);
            vegetationSet.add(Material.SMALL_DRIPLEAF);
            vegetationSet.add(Material.SPORE_BLOSSOM);
            vegetationSet.add(Material.SPRUCE_SAPLING);
            vegetationSet.add(Material.SUGAR_CANE);
            vegetationSet.add(Material.SUNFLOWER);
            vegetationSet.add(Material.SWEET_BERRIES);
            vegetationSet.add(Material.SWEET_BERRY_BUSH);
            vegetationSet.add(Material.TALL_GRASS);
            vegetationSet.add(Material.TALL_SEAGRASS);
            vegetationSet.add(Material.TWISTING_VINES);
            vegetationSet.add(Material.TWISTING_VINES_PLANT);
            vegetationSet.add(Material.VINE);
            vegetationSet.add(Material.WARPED_FUNGUS);
            vegetationSet.add(Material.WARPED_ROOTS);
            vegetationSet.add(Material.WEEPING_VINES);
            vegetationSet.add(Material.WEEPING_VINES_PLANT);
            vegetationSet.add(Material.WHITE_TULIP);
            vegetationSet.add(Material.WITHER_ROSE);
            vegetationSet.add(Material.WHEAT);
            vegetationSet.add(Material.WHEAT_SEEDS);

            // Coral
            vegetationSet.add(Material.TUBE_CORAL_FAN);
            vegetationSet.add(Material.TUBE_CORAL_WALL_FAN);
            vegetationSet.add(Material.DEAD_TUBE_CORAL_FAN);
            vegetationSet.add(Material.DEAD_TUBE_CORAL_WALL_FAN);
            vegetationSet.add(Material.DEAD_TUBE_CORAL);

            vegetationSet.add(Material.BRAIN_CORAL_FAN);
            vegetationSet.add(Material.BRAIN_CORAL_WALL_FAN);
            vegetationSet.add(Material.DEAD_BRAIN_CORAL_FAN);
            vegetationSet.add(Material.DEAD_BRAIN_CORAL_WALL_FAN);
            vegetationSet.add(Material.DEAD_BRAIN_CORAL);

            vegetationSet.add(Material.BUBBLE_CORAL_FAN);
            vegetationSet.add(Material.BUBBLE_CORAL_WALL_FAN);
            vegetationSet.add(Material.DEAD_BUBBLE_CORAL_FAN);
            vegetationSet.add(Material.DEAD_BUBBLE_CORAL_WALL_FAN);
            vegetationSet.add(Material.DEAD_BUBBLE_CORAL);

            vegetationSet.add(Material.FIRE_CORAL_FAN);
            vegetationSet.add(Material.FIRE_CORAL_WALL_FAN);
            vegetationSet.add(Material.DEAD_FIRE_CORAL_FAN);
            vegetationSet.add(Material.DEAD_FIRE_CORAL_WALL_FAN);
            vegetationSet.add(Material.DEAD_FIRE_CORAL);

            vegetationSet.add(Material.HORN_CORAL_FAN);
            vegetationSet.add(Material.HORN_CORAL_WALL_FAN);
            vegetationSet.add(Material.DEAD_HORN_CORAL_FAN);
            vegetationSet.add(Material.DEAD_HORN_CORAL_WALL_FAN);
            vegetationSet.add(Material.DEAD_HORN_CORAL);

            // 1.20
            vegetationSet.add(Material.PITCHER_PLANT);
            vegetationSet.add(Material.PITCHER_CROP);
            vegetationSet.add(Material.TORCHFLOWER);
            vegetationSet.add(Material.TORCHFLOWER_CROP);
            vegetationSet.add(Material.PINK_PETALS);
            vegetationSet.add(Material.CHERRY_SAPLING);

            // 1.21.4
            vegetationSet.add(Material.PALE_OAK_SAPLING);
            vegetationSet.add(Material.OPEN_EYEBLOSSOM);
            vegetationSet.add(Material.CLOSED_EYEBLOSSOM);
            vegetationSet.add(Material.PALE_HANGING_MOSS);
            vegetationSet.add(Material.RESIN_CLUMP);

            // 1.21.5
            vegetationSet.add(Material.LEAF_LITTER);
            vegetationSet.add(Material.WILDFLOWERS);
            vegetationSet.add(Material.BUSH);
            vegetationSet.add(Material.FIREFLY_BUSH);
            vegetationSet.add(Material.CACTUS_FLOWER);
            vegetationSet.add(Material.SHORT_DRY_GRASS);
            vegetationSet.add(Material.TALL_DRY_GRASS);

            // 1.21.6
            // No Additions

            // 1.21.7
            // No Additions

            // 1.21.8
            // No Additions

            // 1.21.9
            // No Additions

            // 1.21.10
            // No Additions

            // 1.21.11
            // No Additions
        }

        return vegetationSet.contains(material);
    }

    public static boolean isVegetationInWater(Material material) {
        if (material == Material.SEAGRASS) return true;
        if (material == Material.TALL_SEAGRASS) return true;
        if (material == Material.KELP_PLANT) return true;
        return material == Material.KELP;
    }

    public static boolean isSourceWater(BlockData blockData) {
        final Material material = blockData.getMaterial();
        if (material == Material.BUBBLE_COLUMN) return true;
        if (blockData instanceof Levelled levelledData) {
            return levelledData.getLevel() == 0 && material == Material.WATER;
        }
        return false;
    }

    public static boolean isWaterLoggable(BlockData blockData) {
        return blockData instanceof Waterlogged waterloggedData;
    }

    public static boolean isWaterLogged(BlockData blockData) {
        return blockData instanceof Waterlogged waterloggedData && waterloggedData.isWaterlogged();
    }

    public static boolean isWater(BlockData blockData) {
        final Material material = blockData.getMaterial();
        if (material == Material.BUBBLE_COLUMN) return true;
        if (material == Material.WATER) return true;
        if (isVegetationInWater(material)) return true;
        return isWaterLogged(blockData);
    }

    public static boolean isOnlyWater(BlockData blockData) {
        final Material material = blockData.getMaterial();
        if (material == Material.BUBBLE_COLUMN) return true;
        return material == Material.WATER;
    }

    /**
     * Gets if the block takes up the entire 1x1x1 block. It doesn't necessarily have to be a source block.
     * @param blockData block data to check
     * @return true if the block takes up a full water block, false if it doesn't
     */
    public static boolean isFullBlockWater(BlockData blockData) {
        final Material material = blockData.getMaterial();
        if (material == Material.BUBBLE_COLUMN) return true;
        if (blockData instanceof Levelled levelledData && material == Material.WATER) {
            return levelledData.getLevel() == 0 || levelledData.getLevel() >= 8;
        }
        return false;
    }

    public void setWaterLogged(Block block) {
        final BlockData blockData = block.getBlockData();
        if (!(blockData instanceof Waterlogged waterlogged)) return;
        waterlogged.setWaterlogged(true);
        block.setBlockData(blockData);
    }

    private static BlockData isRestorableBlockData(BlockData blockData) {
        final Material material = blockData.getMaterial();
        if (material == Material.STRUCTURE_VOID) return blockData;

        // All water blocks would be replaced just water so that they update properly
        if (material == Material.BUBBLE_COLUMN) return Material.WATER.createBlockData();
        if (isVegetationInWater(blockData.getMaterial())) return Material.WATER.createBlockData();
        if (blockData instanceof Levelled levelledData) {
            if (levelledData.getLevel() == 0 && material == Material.LAVA) return blockData;
            if (levelledData.getLevel() == 0 && material == Material.WATER) return blockData;
        }
        if (blockData instanceof Waterlogged waterlogged) {
            if (material == Material.SEA_PICKLE) return null; // An Exception
            if (waterlogged.isWaterlogged() && isVegetation(blockData)) return blockData;
        }
        return null;
    }
}
