package game;

package Game;

import javafx.stage.Stage;
import javafx.scene.control.Label;




public class MainMenu{
	public MainMenu(){

	}

	public void createScene(Stage primaryStage){

	}

	private GridPane createLayout(){
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        return populateLayout(grid);
	}
}