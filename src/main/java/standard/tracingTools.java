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



}
