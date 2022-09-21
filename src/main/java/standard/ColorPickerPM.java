package standard;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class ColorPickerPM {
	public static final int MIN_VALUE = 0; // min value for the color values
	public static final int MAX_VALUE = 255; // max value for the color values

	private final ObjectProperty<Paint> color = new SimpleObjectProperty<>(Color.BLACK);

	private final IntegerProperty red = new SimpleIntegerProperty(0);
	private final IntegerProperty green = new SimpleIntegerProperty(0);
	private final IntegerProperty blue = new SimpleIntegerProperty(0);

	public Color getColor() {
		return (Color) color.get();
	}

	public void setColor(Color color) {
		this.color.set(color);
	}

	public ObjectProperty<Paint> colorProperty() {
		return color;
	}

	public int getRed() {
		return red.get();
	}

	public void setRed(int red) {
		this.red.set(red);
	}

	public IntegerProperty redProperty() {
		return red;
	}

	public int getGreen() {
		return green.get();
	}

	public void setGreen(int green) {
		this.green.set(green);
	}

	public IntegerProperty greenProperty() {
		return green;
	}

	public void setBlue(int blue) {
		this.blue.set(blue);
	}

	public int getBlue() {
		return blue.get();
	}

	public IntegerProperty blueProperty() {
		return blue;
	}
    
    private static final double FACTOR = 0.7;

	public static Color brighter(Color c) {
		int r = (int) (c.getRed() * 255);
		int g = (int) (c.getGreen() * 255);
		int b = (int) (c.getBlue() * 255);

		int i = 3;
		if (r == 0 && g == 0 && b == 0) {
			return new Color(i / 255.0, i / 255.0, i / 255.0, c.getOpacity());
		}
		if (r > 0 && r < i) r = i;
		if (g > 0 && g < i) g = i;
		if (b > 0 && b < i) b = i;

		return new Color(Math.min((int) (r / FACTOR), 255) / 255.0,
						 Math.min((int) (g / FACTOR), 255) / 255.0,
						 Math.min((int) (b / FACTOR), 255) / 255.0,
						 c.getOpacity());
	}
    
    public static Color darker(Color c) {
        return new Color(Math.max((int)(c.getRed()  * 255 * FACTOR), 0)/255.0,
                         Math.max((int)(c.getGreen()* 255 * FACTOR), 0)/255.0,
                         Math.max((int)(c.getBlue() * 255 * FACTOR), 0)/255.0,
                         c.getOpacity());
    }

}
