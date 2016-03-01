import javafx.application.Application;
import javafx.stage.Stage;


public class GameWindow extends Application{
	private double HEIGHT = 300;
	private double WIDTH = 250;
	private double SCALE = 2;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
    	primaryStage.setTitle("HeroSandwich");
    	MainMenu main = new MainMenu(HEIGHT*SCALE, WIDTH*SCALE);
        main.createScene(primaryStage);
    }
}