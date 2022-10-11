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
        //imageView.setImage(pm.exampleGradient(800,600, new Vector3(0,255,0), new Vector3(0,0,255), 800));
        Sphere sphA = new Sphere(-1001, 0, 0, 1000, new Vector3(0.8, 0, 0));
        Sphere sphB = new Sphere(1001, 0, 0, 1000, new Vector3(0, 0, 0.8));
        Sphere sphC = new Sphere(0, 0, 1001, 1000, new Vector3(0.5, 0.5, 0.5));
        Sphere sphD = new Sphere(0, -1001, 0, 1000, new Vector3(0.5, 0.5, 0.5));
        Sphere sphE = new Sphere(0, 1001, 0, 1000, new Vector3(0, 0, 0));
        Sphere sphF = new Sphere((float)-0.6, (float)-0.7, (float)-0.6, (float)0.3, new Vector3(0, 0.8, 0));
        Sphere sphG = new Sphere((float)0.3, (float)-0.4, (float)0.3, (float)0.6, new Vector3(0.8, 0, 0.8));
        Scene scene = new Scene(new Vector3(-0.9, -0.5, 0.9), new Vector3(0,0,0), 36);
        scene.addSphere(sphA);
        scene.addSphere(sphB);
        scene.addSphere(sphC);
        scene.addSphere(sphD);
        scene.addSphere(sphE);
        scene.addSphere(sphF);
        scene.addSphere(sphG);

        Vector3 eye = new Vector3(-0.9, -0.5, 0.9);
        Vector3 lookAt = new Vector3(0,0,0);
        float fov = 110;

        imageView.setImage(pm.pathTracer(800, 600, eye, lookAt, fov, scene));
    }

    private void layoutControls() {
        getChildren().add(imageView);
    }

    private void setupValueChangeListeners() {

    }

    private void setupBindings() {

    }
}
