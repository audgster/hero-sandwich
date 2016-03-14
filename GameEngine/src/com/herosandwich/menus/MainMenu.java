package  com.herosandwich.menus;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MainMenu implements Menu{
    private ImageView mainMenuImg;
    private StackPane content;
    private Pane mainMenuView;

    private Double WIDTH;
    private Double HEIGHT;

    private Stage stage;

    public MainMenu(Stage stage, Double width, Double height)
    {
        super();

        WIDTH = width;
        HEIGHT = height;
        this.stage = stage;
    }

    @Override
    public void createMenu(Pane root){
        mainMenuView = root;
        content = createMainMenuOptions();
        content.getChildren().addAll(createMainMenuImage());
        mainMenuView.getChildren().addAll(content);
    }

    private void removeMainMenuView(){
        mainMenuView.getChildren().remove(content);
    }

    private ImageView createMainMenuImage(){
        mainMenuImg = new ImageView();
            mainMenuImg.setId("");
            mainMenuImg.setFitWidth(200);
            mainMenuImg.setFitHeight(200);
            mainMenuImg.setTranslateX(250);
            mainMenuImg.setTranslateY(175);
        return mainMenuImg;
    }

    private StackPane createMainMenuOptions(){
        VBox mainOptions = new VBox(2);
        Label title = new Label("Hero Sandwich");
            title.setId("menu_title");
            title.setPadding(new Insets(25,25,25,25));
        StackPane newGame = createBtn("New Game");
            newGame.setOnMouseClicked(event -> {
                AvatarCreationMenu acm = new AvatarCreationMenu(stage, WIDTH, HEIGHT);
                acm.createMenu(mainMenuView);
            });
        StackPane loadGame = createBtn("Load Game");
            loadGame.setOnMouseClicked(event -> {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Choose save file");
                File file = fileChooser.showOpenDialog(stage);

                AreaView areaView = new AreaView(stage, WIDTH, HEIGHT, file);
                areaView.createMenu(mainMenuView);
            });

        StackPane exit = createBtn("Exit");
            exit.setOnMouseClicked(event -> {
                System.exit(0);
            });
        mainOptions.getChildren().addAll(title,newGame,loadGame,exit);
        StackPane mainMenu = new StackPane();
        mainMenu.setPrefSize(1200,800);
        mainMenu.getChildren().addAll(mainOptions);
        mainOptions.setTranslateY(75);
        return mainMenu;
    }

    private StackPane createBtn(String btnName){
        StackPane btn = new StackPane();
            btn.setMaxSize(250, 30);
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
        if(option.equals("Load Game")){
            mainMenuImg.setId("sneak_image");
        }
        else if(option.equals("Exit")){
            mainMenuImg.setId("summoner_image");
        }
        else{
            mainMenuImg.setId("smasher_image");
        }
    }
}
