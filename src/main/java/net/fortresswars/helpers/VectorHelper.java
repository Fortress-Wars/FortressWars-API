package net.fortresswars.helpers;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.core.vectors.SphereVectorCallback;
import net.fortresswars.events.entities.FWAdjustVelocityEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;

public final class VectorHelper {

    /**
     *
     * @param radius The radius of the circle sector
     * @param originLocation The origin location of the circle
     * @param pointLocation The location to check within the circle sector
     * @param directionVector The middle vector of the circle sector from the origin to the edge of the circle
     * @param sectorSpreadRadians the angle (in radians) from the direction vector that the circle sector extends
     * @param shouldIgnoreYAxis true if the circle sector should only check the X and Z axis coordinates
     * @return true if the pointLocation is in the circle sector, false if it is not
     */
    public static boolean isPointInCircleSector(double radius, Location originLocation, Location pointLocation, Vector directionVector, double sectorSpreadRadians, boolean shouldIgnoreYAxis) {

        // Middle Vector
        final Vector directionVectorNormalized = directionVector.normalize();

        // Point Angle
        final Vector originVector = originLocation.toVector();
        final Vector pointVector = pointLocation.toVector().subtract(originVector); // We need to subtract the origin to move it to 0,0
        final Vector pointVectorNormalized = pointVector.normalize();

        // Ignore y is set
        if (shouldIgnoreYAxis) pointVectorNormalized.setY(0);
        final double pointTheta = directionVectorNormalized.angle(pointVectorNormalized);

        // Polar Radius
        final Location originLocation2D = new Location(originLocation.getWorld(), originLocation.getX(), originLocation.getY(), originLocation.getZ());
        final Location pointLocation2D = new Location(pointLocation.getWorld(), pointLocation.getX(), pointLocation.getY(), pointLocation.getZ());
        if (shouldIgnoreYAxis) {
            originLocation2D.setY(0);
            pointLocation2D.setY(0);
        }
        final double pointToOriginDistance = LocationHelper.distance(pointLocation2D, originLocation2D);
        return pointToOriginDistance <= radius && pointTheta <= (sectorSpreadRadians * 0.5);
    }

    /**
     * Convert degrees to radians
     * @param degrees degrees to convert
     * @return the angle in radians
     */
    public static double degreesToRadians(double degrees) {
        return degrees * Math.PI / 180;
    }

    /**
     * Convert radians to degrees
     * @param radians radians to convert
     * @return the angle in degrees
     */
    public static double radiansToDegrees(double radians) {
        return radians * 180 / Math.PI;
    }

    /**
     * Rotate the vector along the x Axis
     * @param v vector to rotate
     * @param angle angle in Radians
     * @return the same vector with the rotation applied
     */
    public static Vector rotateAroundAxisX(Vector v, double angle) {
        double y, z, cos, sin;
        cos = Math.cos(angle);
        sin = Math.sin(angle);
        y = v.getY() * cos - v.getZ() * sin;
        z = v.getY() * sin + v.getZ() * cos;
        return v.setY(y).setZ(z);
    }

    /**
     * Rotate the vector along the y Axis
     * @param v vector to rotate
     * @param angle angle in Radians
     * @return the same vector with the rotation applied
     */
    public static Vector rotateAroundAxisY(Vector v, double angle) {
        double x, z, cos, sin;
        cos = Math.cos(angle);
        sin = Math.sin(angle);
        x = v.getX() * cos + v.getZ() * sin;
        z = v.getX() * -sin + v.getZ() * cos;
        return v.setX(x).setZ(z);
    }

    /**
     * Rotate the vector along the z Axis
     * @param v vector to rotate
     * @param angle angle in Radians
     * @return the same vector with the rotation applied
     */
    public static Vector rotateAroundAxisZ(Vector v, double angle) {
        double x, y, cos, sin;
        cos = Math.cos(angle);
        sin = Math.sin(angle);
        x = v.getX() * cos - v.getY() * sin;
        y = v.getX() * sin + v.getY() * cos;
        return v.setX(x).setY(y);
    }

    /**
     * Rotate the vector along the x, y, and z axis
     * @param v vector to rotate
     * @param angleX x angle in Radians
     * @param angleY y angle in Radians
     * @param angleZ z angle in Radians
     * @return the same vector with the rotation applied
     */
    public static Vector rotateVector(Vector v, double angleX, double angleY, double angleZ) {
        rotateAroundAxisX(v, angleX);
        rotateAroundAxisY(v, angleY);
        rotateAroundAxisZ(v, angleZ);
        return v;
    }

    public static Vector rotateVector(Vector v, Location location) {
        return rotateVector(v, location.getYaw(), location.getPitch());
    }

    public static Vector rotateVector(Vector v, float yawDegrees, float pitchDegrees) {
        double yaw = Math.toRadians(-1 * (yawDegrees + 90));
        double pitch = Math.toRadians(-pitchDegrees);

        double cosYaw = Math.cos(yaw);
        double cosPitch = Math.cos(pitch);
        double sinYaw = Math.sin(yaw);
        double sinPitch = Math.sin(pitch);

        double initialX, initialY, initialZ;
        double x, y, z;

        // Z_Axis rotation (Pitch)
        initialX = v.getX();
        initialY = v.getY();
        x = initialX * cosPitch - initialY * sinPitch;
        y = initialX * sinPitch + initialY * cosPitch;

        // Y_Axis rotation (Yaw)
        initialZ = v.getZ();
        initialX = x;
        z = initialZ * cosYaw - initialX * sinYaw;
        x = initialZ * sinYaw + initialX * cosYaw;

        return new Vector(x, y, z);
    }

    public static double angleToXAxis(Vector vector) {
        return Math.atan2(vector.getX(), vector.getY());
    }

    /**
     * Gets the vector between two locations
     * @param from Location 1
     * @param to Location 2
     * @return A new Vector that will point towards location 2
     */
    public static Vector vectorBetweenLocation(Location from, Location to) {
        try {
            return to.toVector().subtract(from.toVector());
        } catch (Exception e) {
            return new Vector(0, 0, 0);
        }
    }

    public static Vector normalize(Vector vector) {
        try {
            vector.checkFinite();
            return vector.normalize();
        } catch (Exception e) {
            return new Vector(0, 0, 0);
        }
    }

    public static boolean isFinite(Vector vector) {
        try {
            if (vector == null) return false;
            vector.checkFinite();
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static boolean adjustEntityVelocity(FortressWarsEntity target, FortressWarsEntity source, Vector velocity, FWAdjustVelocityEvent.AdjustingType adjustingType) {
        if (!isFinite(velocity)) return false;
        final FWAdjustVelocityEvent event = new FWAdjustVelocityEvent(target, source, velocity, adjustingType);
        Bukkit.getPluginManager().callEvent(event);
        if (event.isCancelled()) return false;
        final Vector newVelocity = event.getFinalVelocity();
        final Entity targetLivingEntity = target.getEntity();
        targetLivingEntity.setVelocity(newVelocity);
        return true;
    }

    /**
     * Creates a sphere of normalized vectors that point out in each direction. Creates the sphere from top to bottom
     * @param location Center location of vector sphere
     * @param startingPhi the starting phi angle of the sphere (used to start on different layers)
     * @param endingPhi the ending phi angle of the sphere (used to end the layers early)
     * @param numberOfLayers Number of layers in the sphere
     * @param vectorsPerLayer Number of vectors per layer
     * @param callback Callback for each vector created
     */
    public static void createVectorSphere(Location location, double startingPhi, double endingPhi, int numberOfLayers, int vectorsPerLayer, SphereVectorCallback callback) {
        final int sanitizedNumLayers = Math.clamp(numberOfLayers, 0, 24);
        final int sanitizedNumVectorsPerLayer = Math.clamp(vectorsPerLayer, 0, 64);
        final double sanitizedEndingPhi = Math.clamp(endingPhi, 0, Math.PI);
        if (sanitizedNumLayers == 0) return;
        if (sanitizedNumVectorsPerLayer == 0) return;
        if (startingPhi < 0) return;

        final double phiIncrement = (sanitizedEndingPhi - startingPhi) / sanitizedNumLayers;
        final double thetaIncrement = 2 * Math.PI / sanitizedNumVectorsPerLayer;

        for (double phi = startingPhi; phi <= sanitizedEndingPhi; phi += phiIncrement) {
            final double radius = Math.sin(phi);
            final double y = Math.cos(phi);
            for (double theta = 0; theta <= 2 * Math.PI; theta += thetaIncrement) {
                final double x = Math.sin(theta) * radius;
                final double z = Math.cos(theta)  * radius;
                final Vector vector = new Vector(x, y, z);
                callback.run(location.clone(), vector.normalize());
            }
        }
    }

    /**
     * Adds spread to each component of the vector and normalize the vector
     * @param vector vector to apply random spread to
     * @param spread spread value
     * @return the same vector
     */
    public static Vector addSpread(Vector vector, double spread) {
        final double xRandomizedSpread = Math.random() * spread * (Math.random() > 0.5 ? 1 : -1);
        final double yRandomizedSpread = Math.random() * spread * (Math.random() > 0.5 ? 1 : -1);
        final double zRandomizedSpread = Math.random() * spread * (Math.random() > 0.5 ? 1 : -1);
        vector.setX(vector.getX() + xRandomizedSpread);
        vector.setY(vector.getY() + yRandomizedSpread);
        vector.setZ(vector.getZ() + zRandomizedSpread);
        return vector.normalize();
    }
}


