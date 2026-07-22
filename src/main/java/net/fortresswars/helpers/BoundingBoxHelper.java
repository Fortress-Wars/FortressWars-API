package net.fortresswars.helpers;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class BoundingBoxHelper {

    /**
     * Shifts the bounding box by adding the vector
     * @param boundingBox bounding box to shift
     * @param vector vector to shift by
     * @return true if the bounding box was successfully shifted, false if it wasn't
     */
    public static boolean shiftBoundingBox(BoundingBox boundingBox, Vector vector) {
        try {
            boundingBox.shift(vector);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Creates a cubic bounding box at the given location with a specific size
     * @param refLocation Location where the center of the bounding box should be
     * @param size the size of the bounding box from the center. (0.5, would be 0.5 in each direction)
     * @return new bounding box
     */
    public static BoundingBox createBoundingBox(Location refLocation, double size) {
        double x1 = refLocation.getX() + size;
        double y1 = refLocation.getY() + size;
        double z1 = refLocation.getZ() + size;
        double x2 = refLocation.getX() - size;
        double y2 = refLocation.getY() - size;
        double z2 = refLocation.getZ() - size;
        return new BoundingBox(x1, y1, z1, x2, y2, z2);
    }

    /**
     * Creates a cubic bounding box at the given location with a specific size
     * @param refLocation Location where the center of the bounding box should be
     * @param x the size of the bounding box in the x direction. (0.5, would be 0.5 in x and -x direction)
     * @param y the size of the bounding box in the y direction. (0.5, would be 0.5 in y and -y direction)
     * @param z the size of the bounding box in the z direction. (0.5, would be 0.5 in z and -z direction)
     * @return new bounding box
     */
    public static BoundingBox createBoundingBox(Location refLocation, double x, double y, double z) {
        double x1 = refLocation.getX() + x;
        double y1 = refLocation.getY() + y;
        double z1 = refLocation.getZ() + z;
        double x2 = refLocation.getX() - x;
        double y2 = refLocation.getY() - y;
        double z2 = refLocation.getZ() - z;
        return new BoundingBox(x1, y1, z1, x2, y2, z2);
    }

    /**
     * Creates a list of locations for the outline of a bounding box.
     * @param world the world of the bounding box.
     * @param boundingBox the bounding box.
     * @param gap the gap between each location in the outline.
     * @return the list of outline locations.
     */
    public static List<Location> getOutlineLocations(World world, BoundingBox boundingBox, double gap) {
        final List<Location> outlineLocations = new ArrayList<>();
        final double minX = boundingBox.getMinX();
        final double maxX = boundingBox.getMaxX();
        final double minY = boundingBox.getMinY();
        final double maxY = boundingBox.getMaxY();
        final double minZ = boundingBox.getMinZ();
        final double maxZ = boundingBox.getMaxZ();

        // The basic idea is that we want to trace each line along the bounding box of the block.
        // So, because we are using a bounding box, we need to make sure that we use the xs, ys, and zs
        // from it

        // Do X lines
        for (double x = minX; x <= maxX; x += gap) {
            outlineLocations.add(new Location(world, x, minY, minZ));
            outlineLocations.add(new Location(world, x, minY, maxZ));
            outlineLocations.add(new Location(world, x, maxY, minZ));
            outlineLocations.add(new Location(world, x, maxY, maxZ));
        }

        // Do Y Lines
        for (double y = minY; y <= maxY; y += gap) {
            outlineLocations.add(new Location(world, minX, y, minZ));
            outlineLocations.add(new Location(world, minX, y, maxZ));
            outlineLocations.add(new Location(world, maxX, y, minZ));
            outlineLocations.add(new Location(world, maxX, y, maxZ));
        }

        // Do Z Lines
        for (double z = minZ; z <= maxZ; z += gap) {
            outlineLocations.add(new Location(world, minX, minY, z));
            outlineLocations.add(new Location(world, minX, maxY, z));
            outlineLocations.add(new Location(world, maxX, minY, z));
            outlineLocations.add(new Location(world, maxX, maxY, z));
        }

        return outlineLocations;
    }
}
