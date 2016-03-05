package Game;

import javafx.application.Application;
import javafx.stage.Stage;


public class GameWindow extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        AvatarCreationMenu acm = new AvatarCreationMenu();
        acm.createScene(primaryStage);
        //InventoryMenu im = new InventoryMenu();
        //im.renderMenu(primaryStage);
        //PauseMenu pm = new PauseMenu();
       // pm.createScene(primaryStage);
        MainMenu mm = new MainMenu();
        mm.createMenu(primaryStage);
    }
}