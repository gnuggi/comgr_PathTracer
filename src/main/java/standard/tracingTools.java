package standard;

import vectors.Vector2;
import vectors.Vector3;

public class tracingTools {

    public Vector3 CreateEyeRay(Vector3 eye, Vector3 lookAt, float fov, Vector2 pixel) {

        Vector3 up = new Vector3(0,0,1);
        Vector3 f = lookAt.subtract(eye);
        Vector3 r = Vector3.cross(up, f);
        Vector3 u = Vector3.cross(f, r);
        Vector3 fNorm = Vector3.normalize(f);
        Vector3 rNorm = Vector3.normalize(r);
        Vector3 uNorm = Vector3.normalize(u);
        Vector3 temp1 = rNorm.multiply((float)(Math.tan(fov/2)* pixel.x()));
        Vector3 temp2 = uNorm.multiply((float)(Math.tan(fov/2)* pixel.y()));

        return fNorm.add(temp1).add(temp2);
    }

    public Vector2 FindClosestHitPointSphere(Scene s, Vector3 o, Vector3 d) {

        for(Sphere sphere : s.getSpheres()) {
            Vector3 co = o.subtract(sphere.getCenter());

            float a = 1;
            float b = Vector3.dot(co.multiply(2), d);
            float c = (float) (Math.pow(co.length(), 2) - Math.pow(sphere.getRadius(), 2));

            float discriminant = (float) (Math.pow(b, 2) - 4*a*c);

        }



        return new Vector2(0,0);
    }

}
