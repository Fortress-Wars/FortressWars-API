package net.fortresswars.helpers;

import org.bukkit.Location;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

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
}
