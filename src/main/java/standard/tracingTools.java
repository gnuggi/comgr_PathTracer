package standard;

import vectors.Vector2;
import vectors.Vector3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class tracingTools {

    public Vector3 CreateEyeRay(Vector3 eye, Vector3 lookAt, float fov, Vector2 pixel) {

        Vector3 up = new Vector3(0,0,1);
        Vector3 f = lookAt.subtract(eye);
        Vector3 r = Vector3.cross(up, f);
        Vector3 u = Vector3.cross(f, r);
        Vector3 fNorm = Vector3.normalize(f);
        Vector3 rNorm = Vector3.normalize(r);
        Vector3 uNorm = Vector3.normalize(u);
        Vector3 temp1 = rNorm.multiply(((float)Math.tan(fov/2)* pixel.x()));
        Vector3 temp2 = uNorm.multiply(((float)Math.tan(fov/2)* pixel.y()));

        return fNorm.add(temp1).add(temp2);
    }

    public Vector3 FindClosestHitPointSphere(Scene s, Vector3 o, Vector3 d) {

        Map<Sphere, Vector3> hitPoints = new HashMap<>();

        for(Sphere sphere : s.getSpheres()) {
            Vector3 co = o.subtract(sphere.getCenter());

            float a = 1;
            float b = Vector3.dot(co.multiply(2), d);
            float c = (float) (Math.pow(co.length(), 2) - Math.pow(sphere.getRadius(), 2));

            float discriminant = (float) (Math.pow(b, 2) - 4*a*c);

            if(discriminant > 0) {
                float gamma1 = (float) (-b + Math.sqrt(discriminant))/ (2*a);
                float gamma2 = (float) (-b - Math.sqrt(discriminant))/ (2*a);

                if(gamma1 < gamma2 && gamma1 > 0) {
                    Vector3 h = o.add(Vector3.normalize(d).multiply(gamma1));
                    hitPoints.put(sphere, h);
                } else if(gamma2 < gamma1 && gamma2 > 0) {
                    Vector3 h = o.add(Vector3.normalize(d).multiply(gamma2));
                    hitPoints.put(sphere, h);
                }

            } else if (discriminant == 0) {
                float gamma = -b / (2*a);
                if(gamma >= 0) {
                    Vector3 h = o.add(Vector3.normalize(d).multiply(gamma));
                    hitPoints.put(sphere, h);
                }
            }
        }


        Vector3 closestHitPoint = new Vector3(10000,10000,10000);
        Vector3 color =  new Vector3(0,0,0);

        for(Map.Entry<Sphere, Vector3> entry : hitPoints.entrySet()) {
            //System.out.println(entry.getValue().length());
            if(entry.getValue().length() < closestHitPoint.length()){
                closestHitPoint = entry.getValue();
                color = entry.getKey().getColor();
            }
        }

        return color;
    }

    public Vector3 ComputeColor(Vector3 color) {



        return new Vector3(0,0,0);
    }
}
