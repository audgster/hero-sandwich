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
import javafx.scene.image.ImageView;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javafx.scene.control.TextField;

public class AvatarCreationMenu implements Menu{
    private double WIDTH, HEIGHT;
	private int currentMenu;
	private BorderPane content;
    private Player p;
    private Pane avatarCreationView;

	public AvatarCreationMenu(double w, double h){
        WIDTH = w;
        HEIGHT = h;
        currentMenu=1;
        content = new BorderPane();
            content.setId("menu_bg");
            content.setPrefSize(WIDTH,HEIGHT);
        p = new Player();
	}
    public void createMenu(Pane display) {
        avatarCreationView = display;
        //creates title of menu page
        createTitle();

        //creates the 3 different occupations
        OccupationMenu smasherMenu = new OccupationMenu(new Smasher(p),avatarCreationView,WIDTH,HEIGHT);
        OccupationMenu sneakMenu = new OccupationMenu(new Sneak(p),avatarCreationView,WIDTH,HEIGHT);
        OccupationMenu summonerMenu = new OccupationMenu(new Summoner(p),avatarCreationView,WIDTH,HEIGHT);
            //sets the first view with the smasher occupation
            content.setCenter(smasherMenu);
            //creates the next and previous buttons
            createNextBtn(smasherMenu,sneakMenu,summonerMenu);
            createPreviousBtn(smasherMenu,sneakMenu,summonerMenu);

        avatarCreationView.getChildren().add(content);
        PauseMenu pm = new PauseMenu(WIDTH,HEIGHT);
        pm.createMenu(avatarCreationView);
    }
    public void removeAvatarCreationView(){
        avatarCreationView.getChildren().remove(content);
    }
    private void createTitle(){
        Label menuTitle = new Label("Occupation Menu");
            menuTitle.setId("menu_title");
        content.setTop(menuTitle);
        BorderPane.setAlignment(menuTitle, Pos.CENTER);
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
            tt1.setToX(multiplier*WIDTH);
            tt1.play();
        TranslateTransition tt2 = new TranslateTransition(Duration.seconds(1.0), newMenu);
            newMenu.setTranslateX(multiplier*-WIDTH);
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
        Rectangle bg = new Rectangle(WIDTH/6, HEIGHT/15);
            bg.setId("button_rectangle");
        StackPane btn = new StackPane();
            btn.setMaxSize(WIDTH/6, HEIGHT/15);
            btn.setAlignment(Pos.CENTER);
            btn.getChildren().addAll(bg, btnText);
            btn.setVisible(true);
            btn.setOnMouseEntered(event -> {
                bg.setId("button_rectangle_hover");
                btnText.setId("button_text_hover");
            });
            btn.setOnMouseExited(event -> {
                bg.setId("button_rectangle");
                btnText.setId("button_text");
            });
        return btn;
    }
}

class OccupationMenu extends Parent{
    private double WIDTH,HEIGHT;
    private Property occupation;
    private boolean selected;
	private StackPane btnStart;
    private ImageView grayscaleImg, coloredImg;
    private ToggleButton occupationImage;
    private TextField avatarName;
    private Pane avatarCreationView;

	public OccupationMenu(Property occupation,Pane avatarCreationView,double width, double height){
        WIDTH = width;
        HEIGHT = height;
        this.occupation = occupation;
        selected = false;
        btnStart = createStartButton(occupation);
        createOccupationImages();
        occupationImage = new ToggleButton();
        createAvatarCustomName();

        this.avatarCreationView = avatarCreationView;


        BorderPane occupationMenu = createMenu();
		getChildren().addAll(occupationMenu);
	}

    private BorderPane createMenu(){
        BorderPane occupationMenu = new BorderPane();
            occupationMenu.setMaxSize(WIDTH,HEIGHT/10);
            occupationMenu.setTranslateX(0);
        VBox occupationInfo = createOccupationInfo(occupation);
            occupationMenu.setCenter(occupationInfo);
        VBox bottomPane = new VBox(15);
            bottomPane.setPadding(new Insets(25,0,25,0));
            bottomPane.getChildren().addAll(avatarName, btnStart);
            bottomPane.setAlignment(Pos.CENTER);
            occupationMenu.setBottom(bottomPane);
        BorderPane.setAlignment(occupationInfo, Pos.CENTER);
        BorderPane.setAlignment(bottomPane, Pos.BOTTOM_CENTER);
        return occupationMenu;
    }

    private void createOccupationImages(){
        grayscaleImg = new ImageView();
            grayscaleImg.setId(occupation+"_image");
            grayscaleImg.setFitWidth(WIDTH/4);
            grayscaleImg.setFitHeight(WIDTH/4);
        coloredImg = new ImageView();
            coloredImg.setId(occupation+"_image2");
            coloredImg.setFitWidth(WIDTH/4);
            coloredImg.setFitHeight(WIDTH/4);
    }

    private void createAvatarCustomName(){
        avatarName = new TextField(occupation.toString());
            avatarName.setId("text_box");
            avatarName.setMaxSize(WIDTH/6, HEIGHT/15);
            avatarName.setVisible(false);
            avatarName.setAlignment(Pos.CENTER);
    }

	private StackPane createStartButton(Property occupation){
        //creates the Start button
        StackPane btnStart;
        Label text = new Label("Start Game");
            text.setId("button_text");
        Rectangle bg = new Rectangle(WIDTH/6,HEIGHT/15);
            bg.setId("button_rectangle");
        btnStart = new StackPane();
            btnStart.setAlignment(Pos.CENTER);
            btnStart.getChildren().addAll(bg, text);
    		btnStart.setVisible(false);
            btnStart.setMaxSize(WIDTH/6,HEIGHT/15);

        //handles the mouse events associated with the start button
        btnStart.setOnMouseEntered(event -> {
            bg.setId("button_rectangle_hover");
            text.setId("button_text_hover");
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
        });
        return btnStart;
	}
	private VBox createOccupationInfo(Property occupation){
        //create the occupation info, ie. the occupation name, image, and description
	    Label occupationName = new Label(occupation.toString());
		ToggleGroup group = new ToggleGroup();
		occupationImage.setGraphic(grayscaleImg);
			occupationImage.setToggleGroup(group);
			occupationImage.setOnAction((ActionEvent e) -> {
				selected = !selected;
	    		toggleButton(false);
			});
	    Label occupationDescription = new Label(occupation.getDescription());
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
        avatarCreationView.getChildren().clear();
        AreaView av = new AreaView(WIDTH,HEIGHT);
        av.createMenu(avatarCreationView);
    }
}