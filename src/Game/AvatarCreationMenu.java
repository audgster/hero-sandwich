package Game;

import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;



public class AvatarCreationMenu{
	public AvatarCreationMenu(){

	}

	public void createScene(Stage primaryStage){
		Label text = new Label("Testing Chalk Font");
		//text.setFont(Font.loadFont("file:../../resources/fonts/chalk_font_family.ttf", 120));
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
		grid.add(text,1,1);



        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        scene.getStylesheets().add
            (AvatarCreationMenu.class.getResource("AvatarCreationMenu.css").toExternalForm());
        primaryStage.show();
	}


}