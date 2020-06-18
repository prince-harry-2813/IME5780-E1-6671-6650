package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.List;

/**
 * interface for all intersectable geometries
 */
public interface Intersectable {
    /**
     * find intersection points from camera ray in 3D objects.
     *
     * @param ray start from camera point 0.
     * @return list of GeoPoint
     */
    List<GeoPoint> findIntersections(Ray ray);

    /**
     * assistant class.
     * this class hold point of intersection and his object
     */
    class GeoPoint {
        public Geometry geometry;
        public Point3D point;

        /**
         * ctor for 3D instance
         *
         * @param geometry 3D object
         * @param point    for intersection point.
         */
        public GeoPoint(Geometry geometry, Point3D point) {
            this.point = point;
            this.geometry = geometry;
        }

        /**
         * getter
         *
         * @return Point3D
         */
        public Point3D getPoint() {
            return point;
        }

        /**
         * getter
         *
         * @return Geometry object
         */
        public Geometry getGeometry() {
            return geometry;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GeoPoint geoPoint = (GeoPoint) o;
            return (geometry.equals(geoPoint.geometry) &&
                    point.equals(geoPoint.point));
        }

    }
}

