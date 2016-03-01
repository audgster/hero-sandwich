import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.Font; 
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.StackPane;
 
public class HelloWorld extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    // HelloWorld Start
    // @Override
    // public void start(Stage primaryStage) {
    //     primaryStage.setTitle("Hello World!");
    //     Button btn = new Button();
    //     btn.setText("Say 'Hello World'");
    //     btn.setOnAction(new EventHandler<ActionEvent>() {
 
            // @Override
            // public void handle(ActionEvent event) {
            //     System.out.println("Hello World!");
            // }
    //     });
        
    // StackPane root = new StackPane();
    // root.getChildren().add(btn);
    // primaryStage.setScene(new Scene(root, 300, 250));
    // primaryStage.show();
    // }

    @Override
    public void start(Stage primaryStage) {
        createMainMenu(primaryStage);
    }

    public void createMainMenu(Stage primaryStage){
        primaryStage.setTitle("JavaFX Welcome");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);
        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);
        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Sign in button pressed");

                Button btn = new Button();
                btn.setText("Say 'Hello World'");
                    btn.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent e) {
                            createMainMenu(primaryStage);
                        }
                    });

                StackPane root = new StackPane();
                root.getChildren().add(btn);
                primaryStage.setScene(new Scene(root, 300, 250));
                primaryStage.show();
            }
        });

        // Scene scene = new Scene(grid, 300, 275);
        // primaryStage.setScene(scene);
        // primaryStage.show();
        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        scene.getStylesheets().add
            (HelloWorld.class.getResource("HelloWorld.css").toExternalForm());
        primaryStage.show();
    }
}