package Game;

import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;



public class AreaView{
	public AreaView(){}

	public void createScene(Stage primaryStage){
		Group root = new Group();
		Scene scene = new Scene(root, primaryStage.getHeight(), primaryStage.getWidth(), Color.BLACK);
		final Canvas canvas = new Canvas(600, 600);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		gc.setFill(Color.BLUE);
		gc.fillRect(0,0,500,500);
		root.getChildren().add(canvas);

		primaryStage.setScene(scene);
		primaryStage.show();
		System.out.println(primaryStage.getHeight());
	}
}
