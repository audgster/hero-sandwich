package Game;

import javafx.application.Application;
import javafx.stage.Stage;


public class GameWindow extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
<<<<<<< HEAD
        // AvatarCreationMenu acm = new AvatarCreationMenu();
        // acm.createScene(primaryStage);
        // MainMenu mm = new MainMenu();
        // mm.createScene(primaryStage);
        AreaView av = new AreaView();
        av.createScene(primaryStage);
=======
        AvatarCreationMenu ac = new AvatarCreationMenu();
        //ac.createScene(primaryStage);
        InventoryMenu inventoryMenu = new InventoryMenu();
        inventoryMenu.renderMenu(primaryStage);
>>>>>>> 8924076d9c1cd8f8003e4fbed7a9fd2fb75b5d2f
    }
}