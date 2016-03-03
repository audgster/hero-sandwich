package Game;

import javafx.application.Application;
import javafx.stage.Stage;


public class GameWindow extends Application{
	private double HEIGHT = 300;
	private double WIDTH = 250;
	private double SCALE = 2;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        AvatarCreationMenu ac = new AvatarCreationMenu();
        //ac.createScene(primaryStage);
        InventoryMenu inventoryMenu = new InventoryMenu();
        inventoryMenu.renderMenu(primaryStage);
    }
}