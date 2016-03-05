package Game;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainMenu implements Menu{
    private ImageView mainMenuImg;
    private StackPane content;
    private Pane mainMenuView;
    public Pane createMenu(Pane root){
        mainMenuView = root;
        content = createMainMenuOptions();
        content.getChildren().addAll(createMainMenuImage());
        mainMenuView.getChildren().addAll(content);
        return mainMenuView;
    }

    private void removeMainMenuView(){
        mainMenuView.getChildren().remove(content);
    }

    private ImageView createMainMenuImage(){
        mainMenuImg = new ImageView();
            mainMenuImg.setId("");
            mainMenuImg.setFitWidth(200);
            mainMenuImg.setFitHeight(200);
            mainMenuImg.setTranslateX(200);
        return mainMenuImg;
    }

    private StackPane createMainMenuOptions(){
        VBox mainOptions = new VBox(2);
        Label title = new Label("Hero Sandwich");
            title.setId("menu_title");
            title.setPadding(new Insets(25,25,25,25));
        StackPane newGame = createBtn("New Game");
            newGame.setOnMouseClicked(event -> {
                System.out.println("Starting a new game");
                AvatarCreationMenu acm = new AvatarCreationMenu();
                Pane avatarCreationView = acm.createMenu(content);
                mainMenuView.getChildren().add(avatarCreationView);
                content.setVisible(false);
            });
        StackPane loadGame = createBtn("Load Game");
        StackPane exit = createBtn("Exit");
            exit.setOnMouseClicked(event -> {
                System.exit(0);
            });
        mainOptions.getChildren().addAll(title,newGame,loadGame,exit);
        StackPane mainMenu = new StackPane();
        mainMenu.getChildren().addAll(mainOptions);
        mainOptions.setTranslateY(75);
        return mainMenu;
    }

    private StackPane createBtn(String btnName){
        StackPane btn = new StackPane();
            btn.setMaxSize(250,30);
        Label btnText = new Label(btnName);
            btnText.setId("button_text");
        Rectangle bg = new Rectangle(150, 30);
            bg.setId("button_rectangle");
        btn.setAlignment(Pos.CENTER);
        btn.getChildren().addAll(bg, btnText);
        btn.setVisible(true);
        btn.setOnMouseEntered(event -> {
            bg.setId("button_rectangle2");
            btnText.setId("button_text2");
            setImageView(btnName);
        });
        btn.setOnMouseExited(event -> {
            bg.setId("button_rectangle");
            btnText.setId("button_text");
        });
        return btn;
    }
    private void setImageView(String option){
        if(option == "Load Game"){
            mainMenuImg.setId("sneak_image");
        }
        else if(option == "Exit"){
            mainMenuImg.setId("summoner_image");
        }
        else{
            mainMenuImg.setId("smasher_image");
        }
    }
}
