package  com.herosandwich.menus;

import com.herosandwich.models.entity.Player;
import com.herosandwich.models.occupation.*;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.image.ImageView;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javafx.scene.control.TextField;

public class AvatarCreationMenu implements Menu{
	private int currentMenu;
	private BorderPane content;
    private Pane avatarCreationView;
    private Node previousMenu;
	public AvatarCreationMenu(){
		currentMenu=1;
	}

    public void createMenu(Pane display) {
        avatarCreationView = display;
        int index = avatarCreationView.getChildren().size()-1;
            previousMenu = avatarCreationView.getChildren().get(index);
            previousMenu.setVisible(false);
        content = new BorderPane();
            content.setId("menu_bg");
            content.setPrefSize(1200,800);

        Label menuTitle = new Label("Occupation Menu");
            menuTitle.setId("menu_title");
            content.setTop(menuTitle);
            BorderPane.setAlignment(menuTitle, Pos.CENTER);

        Player p = new Player();
        OccupationMenu smasherMenu = new OccupationMenu(new Smasher(p),avatarCreationView);
        OccupationMenu sneakMenu = new OccupationMenu(new Sneak(p),avatarCreationView);
        OccupationMenu summonerMenu = new OccupationMenu(new Summoner(p),avatarCreationView);
            content.setCenter(smasherMenu);
            createNextBtn(smasherMenu,sneakMenu,summonerMenu);
            createPreviousBtn(smasherMenu,sneakMenu,summonerMenu);

        avatarCreationView.getChildren().add(content);
        //PauseMenu pm = new PauseMenu();
        //pm.createMenu(avatarCreationView);
    }

	private void createNextBtn(OccupationMenu smasherMenu,OccupationMenu sneakMenu,OccupationMenu summonerMenu){
        StackPane next = createBtn("Next");
        content.setRight(next);
        BorderPane.setAlignment(next,Pos.CENTER_RIGHT);
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
        StackPane previous = createBtn("Previous");  
        content.setLeft(previous);
        BorderPane.setAlignment(previous,Pos.CENTER_LEFT);
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
        newMenu.setTranslateY(0);
        if(direction.equals("previous")) multiplier = -1;
        TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), oldMenu);
            tt1.setToX(multiplier*600);
            tt1.play();
        TranslateTransition tt2 = new TranslateTransition(Duration.seconds(1.0), newMenu);
            newMenu.setTranslateX(multiplier*-600);
            tt2.setToX(0);
            tt2.play();
            tt1.setOnFinished(evt -> {
                content.setCenter(newMenu);
                oldMenu.setTranslateX(0);
                oldMenu.toggleButton(true);
            });
    }
    private StackPane createBtn(String btnName){
        Label btnText = new Label(btnName);
            btnText.setId("button_text");
        Rectangle bg = new Rectangle(150, 30);
            bg.setId("button_rectangle");
        StackPane btn = new StackPane();
            btn.setMaxSize(250,30);
            btn.setAlignment(Pos.CENTER);
            btn.getChildren().addAll(bg, btnText);
            btn.setVisible(true);
            btn.setOnMouseEntered(event -> {
                bg.setId("button_rectangle2");
                btnText.setId("button_text2");
            });
            btn.setOnMouseExited(event -> {
                bg.setId("button_rectangle");
                btnText.setId("button_text");
            });
        return btn;
    }
}

class OccupationMenu extends Parent{
	private boolean selected = false;
	private StackPane btnStart;
	private ToggleButton occupationImage;
	private ImageView grayscaleImg, coloredImg;
    private TextField avatarName;
    private Property occupation;
    private Pane avatarCreationView;

	public OccupationMenu(Property occupation,Pane avatarCreationView){
        this.occupation = occupation;
        this.avatarCreationView = avatarCreationView;
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

        avatarName = new TextField(occupation.toString());
            avatarName.setMaxSize(250, 30);
            avatarName.setVisible(false);
            avatarName.setAlignment(Pos.CENTER);
		btnStart = createStartButton(occupation);
        VBox bottomPane = new VBox(15);
            bottomPane.setPadding(new Insets(25,0,25,0));
            bottomPane.getChildren().addAll(avatarName, btnStart);
            bottomPane.setAlignment(Pos.CENTER);
            occupationMenu.setBottom(bottomPane);
            BorderPane.setAlignment(bottomPane, Pos.BOTTOM_CENTER);
		VBox occupationInfo = createOccupationInfo(occupation);
            occupationMenu.setCenter(occupationInfo);
            BorderPane.setAlignment(occupationInfo, Pos.CENTER);

		getChildren().addAll(occupationMenu);
	}
	private StackPane createStartButton(Property occupation){
        //creates the Start button
        StackPane btnStart;
        Label text = new Label("Start Game");
            text.setId("button_text");
        Rectangle bg = new Rectangle(250, 30);
            bg.setId("button_rectangle");
        btnStart = new StackPane();
            btnStart.setAlignment(Pos.CENTER);
            btnStart.getChildren().addAll(bg, text);
    		btnStart.setVisible(false);
            btnStart.setMaxSize(250,30);

        //handles the mouse events associated with the start button
        btnStart.setOnMouseEntered(event -> {
            bg.setId("button_rectangle2");
            text.setId("button_text2");
        });
        btnStart.setOnMouseExited(event -> {
            bg.setId("button_rectangle");
            text.setId("button_text");
        });
        btnStart.setOnMouseClicked(event -> {
            String name = avatarName.getCharacters().toString();
            if(!name.equals("")){
                System.out.println(avatarName.getCharacters()+" picked the occupation "+occupation+".");
                createGame(occupation);
            }
            else{
                System.out.println("Please input a valid name.");
            }
        });
        return btnStart;
	}
	private VBox createOccupationInfo(Property occupation){
        //create the occupation info, ie. the occupation name, image, and description
	    Label occupationName = new Label(occupation.toString());
		ToggleGroup group = new ToggleGroup();
		occupationImage = new ToggleButton ("",grayscaleImg);
			occupationImage.setToggleGroup(group);
			occupationImage.setOnAction((ActionEvent e) -> {
				selected = !selected;
	    		toggleButton(false);
			});
	    Label occupationDescription = new Label(occupation+" Description");
	    VBox vbox = new VBox(10);
    	    vbox.getChildren().addAll(occupationName,occupationImage,occupationDescription);
    	    vbox.setAlignment(Pos.CENTER);
        return vbox;
	}
	public void toggleButton(boolean reset){
        //toggles the occupation image from grayscaled to colored
		if(selected && !reset) {
            occupationImage.setGraphic(coloredImg);
            btnStart.setVisible(true);
            avatarName.setVisible(true);
            avatarName.setText(occupation.toString());
        }
		else{
			occupationImage.setGraphic(grayscaleImg);
 			btnStart.setVisible(false);
            avatarName.setVisible(false);
 			selected = false;
		}
	}
    private void createGame(Property occupation){
        AreaView av = new AreaView();
        av.createMenu(avatarCreationView);
    }
}