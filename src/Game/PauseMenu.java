package Game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class PauseMenu {

    public void renderMenu(Stage primaryStage) {
        GridPane content = new GridPane();
        Scene pauseScene = new Scene(content, primaryStage.getHeight(), primaryStage.getWidth());
        pauseScene.getStylesheets().add("Game/PauseMenu.css");
        content.setAlignment(Pos.TOP_CENTER);
        content.setPadding(new Insets(25,25,25,25));

        Label pauseLabel = new Label("Paused");
        content.add(pauseLabel, 0, 0, 2, 1);

        ImageView view = new ImageView();
        view.setId("image-view");
        content.add(view, 0, 1);


        primaryStage.setScene(pauseScene);
        primaryStage.show();


    }
}
