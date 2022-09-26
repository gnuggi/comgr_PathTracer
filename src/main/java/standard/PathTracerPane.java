package standard;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.StringConverter;
import vectors.Vector3;

public class PathTracerPane extends BorderPane {

    private ImageView imageView;
    private final PathTracerPM pm;

    public PathTracerPane(PathTracerPM pm) {
        this.pm = pm;
        initializeControls();
        layoutControls();
        setupValueChangeListeners();
        setupBindings();
    }

    private void initializeControls() {
        imageView = new ImageView();
        imageView.setImage(pm.exampleGradient(800,600, new Vector3(0,255,0), new Vector3(0,0,255), 800));
    }

    private void layoutControls() {
        getChildren().add(imageView);
    }

    private void setupValueChangeListeners() {

    }

    private void setupBindings() {

    }
}
