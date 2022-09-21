package standard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class PathTracerApplication extends Application {
    @Override public void start(Stage primaryStage) throws Exception {
        Region rootPanel = new PathTracerPane(new PathTracerPM());

        Scene scene = new Scene(rootPanel);
        primaryStage.titleProperty().set("Pathtracer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
