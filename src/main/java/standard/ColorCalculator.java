package standard;
import vectors.Vector3;
import static java.lang.Math.pow;

public class ColorCalculator {

    public Vector3 convertSRGBtoLRGB(Vector3 srgb){
        return gammaCorrectSRGBtoLRGB(scaleSRGBtoLRGB(srgb));
    }

    public Vector3 convertLRGBtoSRGB(Vector3 lrgb){
        return scaleLRGBtoSRGB(gammaCorrectLRGBtoSRGB(clipToSRGB(lrgb)));
    }

    private Vector3 scaleSRGBtoLRGB(Vector3 srgb){
        return srgb.multiply(srgb, 1/255);
    }

    private Vector3 gammaCorrectSRGBtoLRGB(Vector3 srgb){
        double x = pow(srgb.x(), 1/2.2);
        double y = pow(srgb.y(), 1/2.2);
        double z = pow(srgb.z(), 1/2.2);
        return new Vector3(x,y,z);
    }

    private Vector3 scaleLRGBtoSRGB(Vector3 lrgb){
        return lrgb.multiply(lrgb, 255);
    }

    private Vector3 gammaCorrectLRGBtoSRGB(Vector3 lrgb){
        double x = pow(lrgb.x(), 2.2);
        double y = pow(lrgb.y(), 2.2);
        double z = pow(lrgb.z(), 2.2);
        return new Vector3(x,y,z);
    }

    private Vector3 clipToSRGB(Vector3 lrgb) {
        double x = lrgb.x();
        double y = lrgb.y();
        double z = lrgb.z();

        if(x < 0){x = 0;} else if (x > 1) {x = 1;}
        if(y < 0){y = 0;} else if (y > 1) {y = 1;}
        if(z < 0){z = 0;} else if (z > 1) {z = 1;}

        return new Vector3(x,y,z);
    }
}
