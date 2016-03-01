package Menus;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Driver extends Application {
    public static void main(String []args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Welcome to JavaFX");
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(25,25,25,25));

        setSceneTitle(gridPane);

        setLabels(gridPane);

        setTextFields(gridPane);

        setSignInButton(gridPane);

        primaryStage.setScene(new Scene(gridPane, 300, 250));
        primaryStage.show();
    }

    private void setSignInButton(GridPane gridPane) {
        Button signInButton = new Button("Sign In");
        HBox hBoxButton = new HBox(10);
        hBoxButton.setAlignment(Pos.BOTTOM_RIGHT);
        hBoxButton.getChildren().add(signInButton);
        gridPane.add(hBoxButton, 1, 3, 1, 1);

        setButtonPressEvent(signInButton, gridPane);

    }

    private void setButtonPressEvent(Button button, GridPane gridPane) {
        final Text actionTarget = new Text();
        gridPane.add(actionTarget, 1, 4, 1, 1);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                actionTarget.setFill(Color.FIREBRICK);
                actionTarget.setText("Sign In Pressed");
            }
        });
    }

    private void setActionTextPlaceHolder(GridPane gridPane) {
    }

    private void setTextFields(GridPane gridPane) {
        TextField userNameField = new TextField();
        gridPane.add(userNameField, 1, 1, 1, 1);


        PasswordField passwordField = new PasswordField();
        gridPane.add(passwordField, 1, 2, 1, 1);
    }

    private void setLabels(GridPane gridPane) {
        Label userNameLabel = new Label("UserName: ");
        gridPane.add(userNameLabel, 0, 1, 1, 1);

        Label passwordLabel = new Label("Password: ");
        gridPane.add(passwordLabel, 0, 2, 1, 1);
    }

    private void setSceneTitle(GridPane gridPane) {
        Text screenTitle = new Text("Welcome");
        screenTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        gridPane.add(screenTitle, 0, 0, 2, 1);
    }



    /*
    Hello World Example
    @Override
    public void start(Stage primaryStage) {
        //primaryStage.setTitle("Hello World");
        Button button = new Button();
        button.setText("Say 'Hello World'!");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(button);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
    */

}
