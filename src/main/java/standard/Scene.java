package standard;

import vectors.Vector3;

import java.util.ArrayList;
import java.util.List;

public class Scene {
    private Vector3 eye;
    private Vector3 lookAt;
    private float fov;
    private List<Sphere> spheres = new ArrayList<>();

    public Scene(Vector3 eye, Vector3 lookAt, float fov) {
        this.eye = eye;
        this.lookAt = lookAt;
        this.fov = fov;
    }

    public Vector3 getEye() {
        return eye;
    }

    public Vector3 getLookAt() {
        return lookAt;
    }

    public float getFov() {
        return fov;
    }

    public List<Sphere> getSpheres() {
        return spheres;
    }

    public void addSphere(Sphere sphere) {
        spheres.add(sphere);
    }
}
