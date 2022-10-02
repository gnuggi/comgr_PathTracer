package standard;

import javafx.scene.image.*;
import javafx.scene.paint.Color;
import vectors.Vector2;
import vectors.Vector3;

public class PathTracerPM {
    //WritableImage or WritablePixelFormat (PixelReader / PixelWriter)
    ColorCalculator colCalc = new ColorCalculator();
    tracingTools tools = new tracingTools();

    public Image exampleGradient(int width, int height, Vector3 color1, Vector3 color2, int steps) {
        WritableImage img = new WritableImage(width , height);
        PixelWriter pw = img.getPixelWriter();
        for(int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){

                //System.out.println("1: " + color1.x() + " " + color1.y() + " " + color1.z() + " / " + color2.x() + " " + color2.y() + " " + color2.z());


                Vector3 lrgb1 = colCalc.convertSRGBtoLRGB(color1);
                Vector3 lrgb2 = colCalc.convertSRGBtoLRGB(color2);

                //System.out.println("2: " + lrgb1.x() + " " + lrgb1.y() + " " + lrgb1.z() + " / " + lrgb2.x() + " " + lrgb2.y() + " " + lrgb2.z());

                Vector3 pixelColor = colCalc.convertLRGBtoSRGB(colCalc.getGradiantColor(lrgb1, lrgb2, steps, i + 1));
                pw.setColor(i, j, Color.rgb((int)pixelColor.x(), (int)pixelColor.y(), (int)pixelColor.z()));

                //System.out.println("3: " +(int)pixelColor.x() + " " + (int)pixelColor.y() + " " +  (int)pixelColor.z());
            }
        }
        return img;
    }

    public Image changePixelColor(int width, int height, int posX, int posY){
        WritableImage img = new WritableImage(width , height);
        PixelWriter pw = img.getPixelWriter();
        pw.setColor(posX,posY, Color.BLUE);
        return img;
    }

    public Image bluePicture(int width, int height){
        WritableImage img = new WritableImage(width , height);
        PixelWriter pw = img.getPixelWriter();
        for(int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                pw.setColor(i, j, Color.BLUE);
            }
        }
        return img;
    }


    public Image pathTracer(int width, int height, Vector3 eye, Vector3 lookAt, float fov, Scene s) {
        WritableImage img = new WritableImage(width , height);
        PixelWriter pw = img.getPixelWriter();
        for(int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){

                //System.out.println("1: " + color1.x() + " " + color1.y() + " " + color1.z() + " / " + color2.x() + " " + color2.y() + " " + color2.z());

                float curX = -1 + (float)(2/width) * width;
                float curY = -1 + (float)(2/height) * height;

                Vector2 pixel = new Vector2(curX, curY);

                Vector3 eyeRay = tools.CreateEyeRay(s.getEye(), s.getLookAt(),s.getFov(), pixel);

                Vector3 color = tools.FindClosestHitPointSphere(s, s.getEye(), eyeRay);

                //System.out.println("2: " + lrgb1.x() + " " + lrgb1.y() + " " + lrgb1.z() + " / " + lrgb2.x() + " " + lrgb2.y() + " " + lrgb2.z());

                Vector3 pixelColor = colCalc.convertLRGBtoSRGB(color);
                pw.setColor(i, j, Color.rgb((int)pixelColor.x(), (int)pixelColor.y(), (int)pixelColor.z()));

                //System.out.println("3: " +(int)pixelColor.x() + " " + (int)pixelColor.y() + " " +  (int)pixelColor.z());
            }
        }
        return img;
    }


}
