package standard;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.StringConverter;

public class ColorPickerPane extends BorderPane {
    private final ColorPickerPM pm;

    private MenuBar menuBar;
    private MenuItem menuItemQuit;
    private CheckMenuItem menuItemRed;
    private CheckMenuItem menuItemGreen;
    private CheckMenuItem menuItemBlue;
    private CheckMenuItem menuItemYellow;
    private CheckMenuItem menuItemCyan;
    private CheckMenuItem menuItemOrange;

    private Slider sliderRed;
    private Slider sliderGreen;
    private Slider sliderBlue;

    private TextField textRed;
    private TextField textGreen;
    private TextField textBlue;

    private Label hexRed;
    private Label hexGreen;
    private Label hexBlue;

    private RadioButton rbRed;
    private RadioButton rbGreen;
    private RadioButton rbBlue;
    private RadioButton rbYellow;
    private RadioButton rbCyan;
    private RadioButton rbOrange;

    private Button btnDarker;
    private Button btnBrighter;

    private Rectangle colorRect;

    public ColorPickerPane(ColorPickerPM pm) {
        this.pm = pm;
        initializeControls();
        layoutControls();
        setupValueChangeListeners();
        setupBindings();
    }

    private void initializeControls() {
        Menu menuFile = new Menu("File");
        menuItemQuit = new MenuItem("Quit");
        menuFile.getItems().add(menuItemQuit);

        Menu menuAttributes = new Menu("Attributes");
        menuItemRed = new CheckMenuItem("Red");
        menuItemGreen = new CheckMenuItem("Green");
        menuItemBlue = new CheckMenuItem("Blue");
        menuItemYellow = new CheckMenuItem("Yellow");
        menuItemCyan = new CheckMenuItem("Cyan");
        menuItemOrange = new CheckMenuItem("Orange");
        menuAttributes.getItems().addAll(menuItemRed, menuItemGreen, menuItemBlue, menuItemYellow, menuItemCyan, menuItemOrange);

        menuBar = new MenuBar();
        menuBar.getMenus().addAll(menuFile, menuAttributes);

        sliderRed = new Slider();
        sliderRed.setMax(ColorPickerPM.MAX_VALUE);
        textRed = new TextField();
        hexRed = new Label();

        sliderGreen = new Slider();
        sliderGreen.setMax(ColorPickerPM.MAX_VALUE);
        textGreen = new TextField();
        hexGreen = new Label();

        sliderBlue = new Slider();
        sliderBlue.setMax(ColorPickerPM.MAX_VALUE);
        textBlue = new TextField();
        hexBlue = new Label();

        rbRed = new RadioButton("Red");
        rbRed.setMinHeight(20);
        rbGreen = new RadioButton("Green");
        rbGreen.setMinHeight(20);
        rbBlue = new RadioButton("Blue");
        rbBlue.setMinHeight(20);
        rbYellow = new RadioButton("Yellow");
        rbYellow.setMinHeight(20);
        rbCyan = new RadioButton("Cyan");
        rbCyan.setMinHeight(20);
        rbOrange = new RadioButton("Orange");
        rbOrange.setMinHeight(20);

        btnDarker = new Button("Darker");
        btnBrighter = new Button("Brighter");
        btnDarker.setMinWidth(100);
        btnBrighter.setMinWidth(100);

        colorRect = new Rectangle(180, 180);
    }

    private void layoutControls() {
        // Menu Bar:
        setTop(menuBar);

        // Center Grid
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        // set sizes:
        grid.getColumnConstraints()
                .addAll(new ColumnConstraints(200), new ColumnConstraints(150), new ColumnConstraints(150));

        grid.add(sliderRed, 0, 0);
        grid.add(textRed, 1, 0);
        grid.add(hexRed, 2, 0);
        grid.add(sliderGreen, 0, 1);
        grid.add(textGreen, 1, 1);
        grid.add(hexGreen, 2, 1);
        grid.add(sliderBlue, 0, 2);
        grid.add(textBlue, 1, 2);
        grid.add(hexBlue, 2, 2);
        grid.add(colorRect, 0, 3, 1, 8);
        grid.add(rbRed, 1, 3);
        grid.add(rbGreen, 1, 4);
        grid.add(rbBlue, 1, 5);
        grid.add(rbYellow, 1, 6);
        grid.add(rbCyan, 1, 7);
        grid.add(rbOrange, 1, 8);

        grid.add(btnDarker, 2, 3);
        grid.add(btnBrighter, 2, 4);

        setCenter(grid);
    }

    private void setupValueChangeListeners() {
        rbRed.setOnAction(event -> pm.setColor(Color.RED));
        rbGreen.setOnAction(event -> pm.setColor(Color.GREEN));
        rbBlue.setOnAction(event -> pm.setColor(Color.BLUE));
        rbYellow.setOnAction(event -> pm.setColor(Color.YELLOW));
        rbCyan.setOnAction(event -> pm.setColor(Color.CYAN));
        rbOrange.setOnAction(event -> pm.setColor(Color.ORANGE));

        btnDarker.setOnAction(event -> pm.setColor(ColorPickerPM.darker(pm.getColor())));
        btnBrighter.setOnAction(event -> pm.setColor(ColorPickerPM.brighter(pm.getColor())));

        // Menu actions:
        menuItemQuit.setOnAction(event -> Platform.exit());
        menuItemRed.setOnAction(event -> pm.setColor(Color.RED));
        menuItemGreen.setOnAction(event -> pm.setColor(Color.GREEN));
        menuItemBlue.setOnAction(event -> pm.setColor(Color.BLUE));
        menuItemYellow.setOnAction(event -> pm.setColor(Color.YELLOW));
        menuItemCyan.setOnAction(event -> pm.setColor(Color.CYAN));
        menuItemOrange.setOnAction(event -> pm.setColor(Color.ORANGE));
    }

    private void setupBindings() {
    	colorRect.fillProperty().bind(pm.colorProperty());

        StringConverter<Number> stringConverter = new StringConverter<>() {
            @Override public String toString(Number object) {
                return object.toString();
            }

            @Override public Number fromString(String string) {
                int n = 0;
                try {
                    n = Integer.parseInt(string);
                } catch (NumberFormatException e) {
                    // do nothing
                }
                // cap values:
                return Math.max(ColorPickerPM.MIN_VALUE, Math.min(n, ColorPickerPM.MAX_VALUE));
            }
        };

        sliderRed.valueProperty().bindBidirectional(pm.redProperty());
        textRed.textProperty().bindBidirectional(pm.redProperty(), stringConverter);
        hexRed.textProperty().bind(pm.redProperty().asString("%02x"));

        sliderGreen.valueProperty().bindBidirectional(pm.greenProperty());
        textGreen.textProperty().bindBidirectional(pm.greenProperty(), stringConverter);
        hexGreen.textProperty().bind(pm.greenProperty().asString("%02x"));

        sliderBlue.valueProperty().bindBidirectional(pm.blueProperty());
        textBlue.textProperty().bindBidirectional(pm.blueProperty(), stringConverter);
        hexBlue.textProperty().bind(pm.blueProperty().asString("%02x"));
    }
}
