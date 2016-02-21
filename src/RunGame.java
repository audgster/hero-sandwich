import java.net.URL;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RunGame extends Application{

    public static void main(String args[]){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
      final URL resource = getClass().getResource("themeSong.mp3");
      final Media media = new Media(resource.toString());
      final MediaPlayer mediaPlayer = new MediaPlayer(media);
      mediaPlayer.setOnEndOfMedia(new Runnable() {
       	public void run() {
        	mediaPlayer.seek(Duration.ZERO);
        }
      });
      mediaPlayer.play();

         GameWindow gw = new GameWindow(); 
         gw.start();

    }
}
