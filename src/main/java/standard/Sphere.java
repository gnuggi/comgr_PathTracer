package standard;

import vectors.Vector3;

public class Sphere {
    private float x,y,z,r;
    private Vector3 color;

    public Sphere(float x, float y, float z, float r, Vector3 color) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.r = r;
        this.color = color;
    }

    public Vector3 getCenter() {
        return new Vector3(x,y,z);
    }
    public float getRadius() {
        return r;
    }

    public Vector3 getColor() {
        return color;
    }
}
