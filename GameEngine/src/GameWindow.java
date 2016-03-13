import  com.herosandwich.menus.*;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class GameWindow extends Application{
    double WIDTH,HEIGHT;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        WIDTH = screenBounds.getWidth();
        HEIGHT = screenBounds.getHeight();

        Pane rootView = new Pane();

        AreaView mm = new AreaView(WIDTH,HEIGHT);
            mm.createMenu(rootView);

        Scene display = new Scene(rootView,WIDTH,HEIGHT);
        primaryStage.setScene(display);
        primaryStage.setTitle("Hero Sandwich");
        primaryStage.getIcons().add(new Image("res/images/smasher.gif"));

        display.getStylesheets().add
                (GameWindow.class.getResource("GameWindow.css").toExternalForm());
        primaryStage.show();
    }
}