/*
Short Description:  This program will display a text label followed by four sliders.  Each slider has an effect on the
                    color of the text in the label.
Author:  Brian Wiatrek
Date:  September 21, 2024
*/
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class Slider extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Create the label
        Label textLabel = new Label("Show Colors");
        textLabel.setTextFill(Color.BLUE);
        textLabel.setContentDisplay(ContentDisplay.CENTER);

        //Place the label in a VBOX
        VBox paneLabel = new VBox(20);
        paneLabel.getChildren().add(textLabel);
        paneLabel.setAlignment(Pos.TOP_CENTER);

        //Create the sliders by first creating a label for each slider, then slider itself, finally put
        //all in an Hbox
        Label redLabel = new Label("Red");
        Label blueLabel = new Label("Blue");
        Label greenLabel = new Label("Green");
        Label opacityLabel = new Label("Opacity");
        ScrollBar redHorizontal = new ScrollBar();
        redHorizontal.setOrientation(Orientation.HORIZONTAL);
        redHorizontal.setMax(255);
        redHorizontal.setMin(0);

        ScrollBar blueHorizontal = new ScrollBar();
        blueHorizontal.setOrientation(Orientation.HORIZONTAL);
        blueHorizontal.setMax(255);
        blueHorizontal.setMin(0);
        ScrollBar greenHorizontal = new ScrollBar();
        greenHorizontal.setOrientation(Orientation.HORIZONTAL);
        greenHorizontal.setMax(255);
        greenHorizontal.setMin(0);
        ScrollBar opacityHorizontal = new ScrollBar();
        opacityHorizontal.setOrientation(Orientation.HORIZONTAL);
        opacityHorizontal.setMax(1);
        opacityHorizontal.setMin(0);

        //create a listener for the value of the slider, effecting the color of the text in the label
        redHorizontal.valueProperty().addListener(e->textLabel.setTextFill(Color.rgb((int) redHorizontal.getValue(),
                (int) greenHorizontal.getValue(), (int) blueHorizontal.getValue(), opacityHorizontal.getValue())));
        greenHorizontal.valueProperty().addListener(e->textLabel.setTextFill(Color.rgb((int) redHorizontal.getValue(),
                (int) greenHorizontal.getValue(), (int) blueHorizontal.getValue(), opacityHorizontal.getValue())));
        blueHorizontal.valueProperty().addListener(e->textLabel.setTextFill(Color.rgb((int) redHorizontal.getValue(),
                (int) greenHorizontal.getValue(), (int) blueHorizontal.getValue(), opacityHorizontal.getValue())));
        opacityHorizontal.valueProperty().addListener(e->textLabel.setTextFill(Color.rgb((int) redHorizontal.getValue(),
                (int) greenHorizontal.getValue(), (int) blueHorizontal.getValue(), opacityHorizontal.getValue())));

        HBox redScroll = new HBox(20);
        HBox blueScroll = new HBox(20);
        HBox greenScroll = new HBox(20);
        HBox opacityScroll = new HBox(20);

        redScroll.getChildren().addAll(redLabel, redHorizontal);
        blueScroll.getChildren().addAll(blueLabel, blueHorizontal);
        greenScroll.getChildren().addAll(greenLabel, greenHorizontal);
        opacityScroll.getChildren().addAll(opacityLabel, opacityHorizontal);

        VBox paneScroll = new VBox(10);
        paneScroll.setPadding(new Insets(11,22,13,24));

        paneScroll.getChildren().addAll(redScroll, blueScroll, greenScroll, opacityScroll);

        BorderPane pane = new BorderPane(paneLabel);
        pane.setBottom(paneScroll);
        Scene scene = new Scene(pane, 230, 200);

        primaryStage.setTitle("Slider");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}