package Game;

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



public class MainMenu{
	private double height, width;
	public MainMenu(double height, double width){
		this.height = height;
		this.width = width;
	}

	public void createScene(Stage primaryStage){
		GridPane layout = createLayout();
		Scene scene = new Scene(layout, height, width);
		primaryStage.setScene(scene);
        scene.getStylesheets().add
            (MainMenu.class.getResource("MainMenu.css").toExternalForm());
        primaryStage.show();
	}

	private GridPane createLayout(){
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        return populateLayout(grid);
	}

	private GridPane populateLayout(GridPane layout){
		//creates main menu image
		Image image = new Image("Game/gameLogo.gif");
		ImageView iv = new ImageView();
	    iv.setFitWidth(100);
	    iv.setFitHeight(100);
		iv.setImage(image);
		layout.add(iv,0,0);

		//creates main menu title
		Label gameTitle = new Label("Hero Sandwich");
		VBox vBoxTemp = new VBox();
		vBoxTemp.setAlignment(Pos.BOTTOM_CENTER);
		vBoxTemp.getChildren().add(gameTitle);
		layout.add(vBoxTemp,0,1);

		//creates main menu options
		VBox vBox = new VBox();
		vBox = createCenteredBottomButton(vBox, "New Game");
		vBox = createCenteredBottomButton(vBox, "Load Game");
		vBox = createCenteredBottomButton(vBox, "Exit");
		layout.add(vBox,0,3);

		return layout;
	}

	private VBox createCenteredBottomButton(VBox vBox, String title){
		Button button = new Button(title);
		vBox.setAlignment(Pos.BOTTOM_CENTER);
		vBox.getChildren().add(button);
		vBox.setSpacing(5.0);
		return vBox;
	}
}