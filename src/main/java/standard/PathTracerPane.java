package standard;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.StringConverter;

public class PathTracerPane extends BorderPane {

    private final PathTracerPM pm;

    public PathTracerPane(PathTracerPM pm) {
        this.pm = pm;
        initializeControls();
        layoutControls();
        setupValueChangeListeners();
        setupBindings();
    }

    private void initializeControls() {

    }

    private void layoutControls() {

    }

    private void setupValueChangeListeners() {

    }

    private void setupBindings() {

    }
}
