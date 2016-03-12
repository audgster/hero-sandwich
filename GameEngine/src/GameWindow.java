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
        HBox temp = new HBox();
        Label tempLabel = new Label("TESTING");
        tempLabel.setAlignment(Pos.CENTER);
        StackPane rec = new StackPane();
        rec.getChildren().add(tempLabel);
        rec.setAlignment(tempLabel,Pos.CENTER);
            rec.setId("black_bg");
            rec.setPrefSize(WIDTH,HEIGHT);
            rec.setMinSize(WIDTH*3/4,HEIGHT);
            rec.setMaxSize(WIDTH,HEIGHT);
        HBox.setHgrow(rec, Priority.ALWAYS);
        temp.setMaxSize(WIDTH,HEIGHT);

        //MainMenu mm = new MainMenu();
        //AreaView mm = new AreaView();
        //AvatarCreationMenu mm = new AvatarCreationMenu(WIDTH, HEIGHT);
        AreaMenu am = new AreaMenu(WIDTH/4, HEIGHT);
        Pane areaMenu = am.createMenu();

        areaMenu.setMinSize(WIDTH/4,HEIGHT);
        temp.getChildren().addAll(rec,areaMenu);
        rootView.getChildren().add(temp);
        temp.setFocusTraversable(true);
        temp.setOnKeyPressed(event -> {
            System.out.println("Key Pressed");
            if (event.getCode() == KeyCode.RIGHT) {
                temp.getChildren().remove(areaMenu);
            }
            else if (event.getCode() == KeyCode.LEFT) {
                temp.getChildren().add(areaMenu);
            }
        });

        Scene display = new Scene(rootView,WIDTH,HEIGHT);
        primaryStage.setScene(display);
        primaryStage.setTitle("Hero Sandwich");
        primaryStage.getIcons().add(new Image("res/images/smasher.gif"));

        display.getStylesheets().add
                (GameWindow.class.getResource("GameWindow.css").toExternalForm());
        primaryStage.show();
    }
}