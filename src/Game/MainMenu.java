package Game;

import javafx.scene.layout.HBox;
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

	public void renderMenu(Stage primaryStage){
		GridPane layout = createLayout();
		Scene scene = new Scene(layout, 600, 500);
		primaryStage.setScene(scene);
        scene.getStylesheets().add(MainMenu.class.getResource("MainMenu.css").toExternalForm());
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
		//Image image = new Image("Game/gameLogo.gif");
		addMainMenuImage(layout);

		setMenuTitle(layout, "Hero Sandwich");

		addMainMenuOptions(layout);

		return layout;
	}

	private void addMainMenuImage(GridPane layout) {
		HBox imageBox = new HBox();
		ImageView image = new ImageView();
		image.setFitWidth(200);
		image.setFitHeight(200);
		image.setId("image");
		imageBox.getChildren().add(image);
		imageBox.setAlignment(Pos.CENTER);
		layout.add(imageBox, 0, 0);
	}

	private void addMainMenuOptions(GridPane layout) {
		VBox vBox = new VBox();
		vBox = createCenteredBottomButton(vBox, "New Game");
		vBox = createCenteredBottomButton(vBox, "Load Game");
		vBox = createCenteredBottomButton(vBox, "Exit");
		layout.add(vBox,0,3);
	}

	private void setMenuTitle(GridPane layout, String title) {
		Label gameTitle = new Label(title);
		VBox vBoxTemp = new VBox();
		vBoxTemp.setAlignment(Pos.BOTTOM_CENTER);
		vBoxTemp.getChildren().add(gameTitle);
		layout.add(vBoxTemp,0,1);
	}

	private VBox createCenteredBottomButton(VBox vBox, String title){
		Button button = new Button(title);
		vBox.setAlignment(Pos.BOTTOM_CENTER);
		vBox.getChildren().add(button);
		vBox.setSpacing(5.0);
		return vBox;
	}
}