package unittests;

import elements.Camera;
import geometries.Intersectable.GeoPoint;
import geometries.Plane;
import geometries.Sphere;
import geometries.Triangle;
import org.junit.Test;
import primitives.Point3D;
import primitives.Vector;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class CameraIntegrationTest {
    Camera camera1 = new Camera(Point3D.ZERO, new Vector(0, 0, 1), new Vector(0, -1, 0));
    Camera camera2 = new Camera(new Point3D(0, 0, -0.5), new Vector(0, 0, 1), new Vector(0, -1, 0));

    /**
     * 3X3 view plane ,find the number of  intersection point of a ray from camera toward a sphere
     * excepted result : 2
     */
    @Test
    public void intersectionSphere1st() {
        Sphere sph = new Sphere(1, new Point3D(0, 0, 3));
        List<GeoPoint> results;
        int result = 0;
        int Nx = 3; //number of pixel in x line
        int Ny = 3;// number of pixel in y line
        for (int i = 0; i < 3; ++i) {  // loop for all the pixels
            for (int j = 0; j < 3; ++j) {
                results = sph.findIntersections(camera1.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (results != null)
                    result += results.size();
            }
        }

        assertEquals("wrong results", 2, result);
        System.out.println("result: " + result);
    }

    /**
     * 3X3  view plane  ,find the number of  intersection point of a ray from camera toward a sphere
     * excepted result : 18
     */
    @Test
    public void intersectionSphere2nd() {
        Sphere sph = new Sphere(2.5, new Point3D(0, 0, 2.5));
        List<GeoPoint> results;
        int result = 0;
        int Nx = 3;//number of pixel in x line
        int Ny = 3;// number of pixel in y line

        for (int i = 0; i < 3; ++i) { //loop all over the view plane
            for (int j = 0; j < 3; ++j) {
                results = sph.findIntersections(camera2.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (results != null)
                    result += results.size();
            }
        }

        assertEquals("wrong results", 18, result);
        System.out.println("result: " + result);
    }

    /**
     * 3X3 view plane ,find the number of  interSection point of a ray from camera toward a sphere
     * excepted result : 10
     */
    @Test
    public void intersectionSphere3rd() {
        Sphere sph = new Sphere(2d, new Point3D(0, 0, 2d));
        List<GeoPoint> results;

        int result = 0;
        int Nx = 3;//number of pixel in x line
        int Ny = 3;// number of pixel in y line

        for (int i = 0; i < 3; ++i) {// go over all the pixels like a 2 Dimension array
            for (int j = 0; j < 3; ++j) {
                results = sph.findIntersections(camera2.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (results != null)
                    result += results.size();
            }
        }

        assertEquals("Wrong results", 10, result);
        System.out.println("result: " + result);
    }

    /**
     * 3X3 view plane  ,find the number of  intersection point of a ray from camera toward a sphere
     * excepted result : 9
     */
    @Test
    public void intersectionSphere4th() {
        Sphere sph = new Sphere(4d, new Point3D(0, 0, 2d));
        List<GeoPoint> results;

        int result = 0;
        int Nx = 3;//number of pixel in x line
        int Ny = 3;// number of pixel in y line

        for (int i = 0; i < 3; ++i) {// go over all the pixels like a 2 Dimension array
            for (int j = 0; j < 3; ++j) {
                results = sph.findIntersections(camera2.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (results != null)
                    result += results.size();
            }
        }

        assertEquals("Wrong results", 9, result);
        System.out.println("result: " + result);
    }

    /**
     * 3X3  , find the number of  intersection point of a ray from camera toward a sphere
     * excepted result : 0
     */
    @Test
    public void intersectionSphere5th() {
        Sphere sph = new Sphere(2d, new Point3D(0, 0, -5));
        List<GeoPoint> results;

        int result = 0;
        int Nx = 3;//number of pixel in x line
        int Ny = 3;// number of pixel in y line

        for (int i = 0; i < 3; ++i) {// go over all the pixels like a 2 Dimension array
            for (int j = 0; j < 3; ++j) {
                results = sph.findIntersections(camera2.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (results != null)
                    result += results.size();
            }
        }

        assertEquals("Wrong results", 0, result);
        System.out.println("result: " + result);
    }

    /**
     * 3X3   view plane ,find the number of  intersection point of a ray from camera toward a plane
     * excepted result : 9
     */
    @Test
    public void intersectionPlane1st() {
        Plane pl = new Plane(new Point3D(0, 0, 6), new Point3D(1, 1, 6), new Point3D(-5, -765, 6));
        List<GeoPoint> results;

        int result = 0;
        int Nx = 3;//number of pixel in x line
        int Ny = 3;// number of pixel in y line

        for (int i = 0; i < 3; ++i) {// loop on view plane
            for (int j = 0; j < 3; ++j) {
                results = pl.findIntersections(camera2.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (results != null)
                    result += results.size();
            }
        }

        assertEquals("Wrong results", 9, result);
        System.out.println("result: " + result);
    }

    /**
     * 3X3  view plane  ,find the number of  intersection point of a ray from camera and a plane
     * excepted result : 9
     */
    @Test
    public void intersectionPlane2nd() {
        Plane pl = new Plane(new Point3D(0, 0, 5), new Point3D(10, 10, 4), new Point3D(4, 10, 4));
        List<GeoPoint> results;

        int result = 0;
        int Nx = 3;//number of pixel in x line
        int Ny = 3;// number of pixel in y line

        for (int i = 0; i < 3; ++i) {//loop view plane
            for (int j = 0; j < 3; ++j) {
                results = pl.findIntersections(camera2.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (results != null)
                    result += results.size();
            }
        }

        assertEquals("wrong results", 9, result);
        System.out.println("result: " + result);
    }

    /**
     * 3X3 view plane ,find the number of  intersection point of a ray from camera toward a plane
     * excepted result : 6
     */
    @Test
    public void intersectionPlane3rd() {
        Plane pl = new Plane(new Point3D(0, 0, 5), new Point3D(1, 1, 4), new Point3D(4, 10, 3));
        List<GeoPoint> results;

        int result = 0;
        int Nx = 3;//number of pixel in x line
        int Ny = 3;// number of pixel in y line

        for (int i = 0; i < 3; ++i) {// loop on view plane
            for (int j = 0; j < 3; ++j) {
                results = pl.findIntersections(camera2.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (results != null)
                    result += results.size();
            }
        }

        assertEquals("wrong results", 6, result);
        System.out.println("result: " + result);
    }

    /**
     * 3X3 center(1,1) ,find the number of  intersection point of a ray from camera toward a triangle
     * excepted result : 1
     */
    @Test
    public void intersectionTriangle1st() {
        Triangle tri = new Triangle(new Point3D(0, -1, 2), new Point3D(1, 1, 2), new Point3D(-1, 1, 2));
        List<GeoPoint> results;

        int result = 0;
        int Nx = 3;//number of pixel in x line
        int Ny = 3;// number of pixel in y line

        for (int i = 0; i < 3; ++i) {//view plane loop
            for (int j = 0; j < 3; ++j) {
                results = tri.findIntersections(camera2.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (results != null)
                    result += results.size();
            }
        }

        assertEquals("wrong results", 1, result);
        System.out.println("result: " + result);
    }

    /**
     * 3X3 view plane ,find the number of  intersection point of a ray from camera toward a triangle
     * excepted result : 2
     */
    @Test
    public void intersectionTriangle2nd() {
        List<GeoPoint> results;
        Triangle tri = new Triangle(new Point3D(1, 1, 2), new Point3D(-1, 1, 2), new Point3D(0, -20, 2));
        int result = 0;
        int Nx = 3;//number of pixel in x line
        int Ny = 3;// number of pixel in y line

        for (int i = 0; i < 3; ++i) {// go all over of the the view plane
            for (int j = 0; j < 3; ++j) {
                results = tri.findIntersections(camera2.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (results != null)
                    result += results.size();
            }
        }

        assertEquals("wrong results", 2, result);
        System.out.println("result: " + result);
    }

    /**
     * 3X3 view plane ,find the number of  interSection point of a ray from camera toward a triangle
     * excepted result : 9
     */
    @Test
    public void intersectionTriangle3rd() {
        Triangle tri = new Triangle(new Point3D(0, -10, 2), new Point3D(10, 10, 2), new Point3D(-10, 10, 2));
        List<GeoPoint> results;

        int result = 0;
        int Nx = 3;//number of pixel in x line
        int Ny = 3;// number of pixel in y line

        for (int i = 0; i < 3; ++i) {// view plane loop
            for (int j = 0; j < 3; ++j) {
                results = tri.findIntersections(camera2.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (results != null)
                    result += results.size();
            }
        }

        assertEquals("wrong results", 9, result);
        System.out.println("result: " + result);
    }
}