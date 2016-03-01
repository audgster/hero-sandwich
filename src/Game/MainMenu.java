import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.Scene;


public class MainMenu{
	double height, width;
	public MainMenu(double height, double width){
		this.height = height;
		this.width = width;
	}

	public void createScene(Stage primaryStage){
		Label userName = new Label("Hero Sandwich:");

		primaryStage.setScene(new Scene(userName, height, width));
        primaryStage.show();
	}
}