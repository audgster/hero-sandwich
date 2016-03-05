package Game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;

public class GameWindow extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        MainMenu mm = new MainMenu();
        Pane root = mm.createMenu(new Pane());
        Scene display = new Scene(root,900,600);
        primaryStage.setScene(display);
        display.getStylesheets().add
            (GameWindow.class.getResource("AvatarCreationMenu.css").toExternalForm());
        primaryStage.show();
    }
}