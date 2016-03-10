import  com.herosandwich.menus.*;

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
        Pane rootView = new Pane();

        //MainMenu mm = new MainMenu();
        AreaView mm = new AreaView();
        mm.createMenu(rootView);

        Scene display = new Scene(rootView,1200,800);
        primaryStage.setScene(display);
        primaryStage.setResizable(true);
        primaryStage.setTitle("Hero Sandwich");

        display.getStylesheets().add
        (GameWindow.class.getResource("GameWindow.css").toExternalForm());
        primaryStage.show();
    }
}