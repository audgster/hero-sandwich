package Game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class GameWindow extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        AvatarCreationMenu acm = new AvatarCreationMenu();
        Scene menu = new Scene(acm.createMenu(root), 900, 600);

        primaryStage.setScene(menu);
        menu.getStylesheets().add
                (AvatarCreationMenu.class.getResource("GameWindow.css").toExternalForm());
        primaryStage.show();
        //InventoryMenu im = new InventoryMenu();
        //im.renderMenu(primaryStage);
        //PauseMenu pm = new PauseMenu();
       // pm.createScene(primaryStage);
        //MainMenu mm = new MainMenu();
        //mm.createMenu(primaryStage);
    }
}