package standard;

import javafx.scene.image.*;
import javafx.scene.paint.Color;

public class PathTracerPM {
    //WritableImage or WritablePixelFormat (PixelReader / PixelWriter)
    ColorCalculator colCalc = new ColorCalculator();


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



}
