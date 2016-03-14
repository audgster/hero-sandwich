import  com.herosandwich.menus.*;

import com.herosandwich.models.entity.*;
import com.herosandwich.models.entity.Character;
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
import com.herosandwich.controller.Controller;


public class GameWindow extends Application {
    double WIDTH,HEIGHT;
    Controller controller = Controller.getController();

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        WIDTH = screenBounds.getWidth();
        HEIGHT = screenBounds.getHeight();

        Pane rootView = new Pane();

        MainMenu mm = new MainMenu(primaryStage, WIDTH, HEIGHT);
        //AvatarCreationMenu mm = new AvatarCreationMenu(WIDTH,HEIGHT);
        //AreaView mm = new AreaView(WIDTH,HEIGHT);
        //ShopMenu mm = new ShopMenu(WIDTH,HEIGHT, new Npc(), new Character());
            mm.createMenu(rootView);

        Scene display = new Scene(rootView,WIDTH,HEIGHT);
        primaryStage.setScene(display);
        primaryStage.setTitle("Hero Sandwich");
        primaryStage.getIcons().add(new Image("res/images/old/smasher.gif"));

        display.getStylesheets().add
                (GameWindow.class.getResource("GameWindow.css").toExternalForm());
        primaryStage.show();
    }
    
}