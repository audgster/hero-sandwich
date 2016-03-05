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
        MainMenu mm = new MainMenu();
        Pane rootView = new Pane();
            mm.createMenu(rootView);
        Scene display = new Scene(rootView,900,600);
        primaryStage.setScene(display);
        display.getStylesheets().add
            (GameWindow.class.getResource("AvatarCreationMenu.css").toExternalForm());
        primaryStage.show();
    }
}