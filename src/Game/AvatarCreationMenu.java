package Game;

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
import javafx.scene.layout.VBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AvatarCreationMenu{
	private int currentMenu;
	private BorderPane root;
	public AvatarCreationMenu(){
		currentMenu=1;
	}
	public void createScene(Stage primaryStage){
        root = new BorderPane();
        //create background
        Rectangle bg = new Rectangle(900, 600);
        	bg.setId("background_rectangle");

		Label menuTitle = new Label("Occupation Menu");
			menuTitle.setId("menu_title");
			root.setTop(menuTitle);
			root.setAlignment(menuTitle,Pos.CENTER);

        OccupationMenu smasherMenu = new OccupationMenu("Smasher");
        OccupationMenu sneakMenu = new OccupationMenu("Sneak");
        	sneakMenu.setTranslateY(-95);
        OccupationMenu summonerMenu = new OccupationMenu("Summoner");
        	summonerMenu.setTranslateY(-95);
        createNextBtn(smasherMenu,sneakMenu,summonerMenu);
        createPreviousBtn(smasherMenu,sneakMenu,summonerMenu);

        root.setCenter(smasherMenu);
		Scene scene = new Scene(root,900,600);
        primaryStage.setScene(scene);
        scene.getStylesheets().add
            (AvatarCreationMenu.class.getResource("AvatarCreationMenu.css").toExternalForm());
        primaryStage.show();
	}

	private void createNextBtn(OccupationMenu smasherMenu,OccupationMenu sneakMenu,OccupationMenu summonerMenu){
        StackPane next = createBtn("NEXT");
        root.setRight(next);
        next.setOnMouseClicked(event -> {
        	if(currentMenu==1) {
                createTransitions(smasherMenu, sneakMenu,"next");
                currentMenu++;
        	}
        	else if(currentMenu==2) {
                createTransitions(sneakMenu,summonerMenu,"next");
                currentMenu++;
        	}
        	else if(currentMenu==3) {
                createTransitions(summonerMenu,smasherMenu,"next");
                currentMenu = 1;
        	}
        });
	}
	private void createPreviousBtn(OccupationMenu smasherMenu,OccupationMenu sneakMenu,OccupationMenu summonerMenu){
        StackPane previous = createBtn("PREVIOUS");  
        root.setLeft(previous);
        previous.setOnMouseClicked(event -> {
        	if(currentMenu==1) {
                createTransitions(smasherMenu,summonerMenu,"previous");
                currentMenu = 3;
        	}
        	else if(currentMenu==2) {
                createTransitions(sneakMenu,smasherMenu,"previous");
                currentMenu--;
        	}
        	else if(currentMenu==3) {
                createTransitions(summonerMenu,sneakMenu,"previous");
                currentMenu--;
        	}
        });
	}
    private void createTransitions(OccupationMenu oldMenu, OccupationMenu newMenu, String direction){
        int multiplier = 1;
        if(direction == "previous") multiplier = -1;
        TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), oldMenu);
        tt1.setToX(multiplier*600);
        tt1.play();
        TranslateTransition tt2 = new TranslateTransition(Duration.seconds(1.0), newMenu);
        newMenu.setTranslateX(multiplier*-600);
        tt2.setToX(0);
        tt2.play();
        tt1.setOnFinished(evt -> {
            root.setCenter(newMenu);
            oldMenu.setTranslateX(0);
            oldMenu.setTranslateY(0);   
            oldMenu.toggleButton(true);
        });
    }
    private StackPane createBtn(String btnName){
        StackPane btn = new StackPane();
        Label btnText = new Label(btnName);
            btnText.setId("buttons");
        Rectangle bg = new Rectangle(150, 30);
        bg.setOpacity(0.6);
        bg.setFill(Color.BLACK);
        btn.setAlignment(Pos.CENTER);
        btn.getChildren().addAll(bg, btnText);
        btn.setVisible(true);
        btn.setOnMouseEntered(event -> {
            bg.setFill(Color.WHITE);
            btnText.setTextFill(Color.BLACK);
        });
        btn.setOnMouseExited(event -> {
            bg.setFill(Color.BLACK);
            btnText.setTextFill(Color.WHITE);
        });
        return btn;
    }
}

class OccupationMenu extends Parent{
	private boolean selected = false;
	private StackPane btnStart;
	private ToggleButton occupationImage;
	private ImageView grayscaleImg, coloredImg;

	public OccupationMenu(String occupation){
        BorderPane occupationMenu = new BorderPane();
            occupationMenu.setMaxSize(900,600);
            occupationMenu.setTranslateX(0);

        grayscaleImg = new ImageView();
            grayscaleImg.setId(occupation+"_image");
            grayscaleImg.setFitWidth(300);
            grayscaleImg.setFitHeight(300);
        coloredImg = new ImageView();
            coloredImg.setId(occupation+"_image2");
            coloredImg.setFitWidth(300);
            coloredImg.setFitHeight(300);

		btnStart = createStartButton(occupation);
            occupationMenu.setBottom(btnStart);
            occupationMenu.setAlignment(btnStart,Pos.BOTTOM_CENTER);
		VBox occupationInfo = createOccupationInfo(occupation);
            occupationMenu.setCenter(occupationInfo);
            occupationMenu.setAlignment(occupationInfo, Pos.CENTER);

		getChildren().addAll(occupationMenu);
	}
	private StackPane createStartButton(String occupation){
        StackPane btnStart;
        Label text = new Label("Start Game");
        Rectangle bg = new Rectangle(250, 30);
            bg.setOpacity(0.6);
            bg.setFill(Color.BLACK);
        btnStart = new StackPane();
            btnStart.setAlignment(Pos.CENTER);
            btnStart.getChildren().addAll(bg, text);
    		btnStart.setVisible(false);

    		btnStart.setOnMouseEntered(event -> {

                bg.setFill(Color.WHITE);
                text.setTextFill(Color.BLACK);
            });
            btnStart.setOnMouseExited(event -> {
                bg.setFill(Color.BLACK);
                text.setTextFill(Color.WHITE);
            }); 
            btnStart.setOnMouseClicked(event -> {
                System.out.println("The occupation "+occupation+" was picked.");
            });  
        return btnStart;
	}
	private VBox createOccupationInfo(String occupation){
	    Label occupationName = new Label(occupation);
		ToggleGroup group = new ToggleGroup();
		occupationImage = new ToggleButton ("",grayscaleImg);
			occupationImage.setToggleGroup(group);
			occupationImage.setOnAction((ActionEvent e) -> {
				selected = !selected;
				setTranslateY(0);
				setTranslateX(0);
	    		toggleButton(false);
			});
	    Label occupationDescription = new Label(occupation+" Description");
	    VBox vbox = new VBox(10);
	    vbox.getChildren().addAll(occupationName,occupationImage,occupationDescription);
	    vbox.setAlignment(Pos.CENTER);
        return vbox;
	}
	public void toggleButton(boolean reset){
		if(selected && !reset){
			occupationImage.setGraphic(coloredImg);
    		btnStart.setVisible(true);
		}
		else{
			occupationImage.setGraphic(grayscaleImg);
 			btnStart.setVisible(false);
 			selected = false;
		}
	}
}