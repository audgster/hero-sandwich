package Game;

import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.Parent;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.event.ActionEvent;



public class AvatarCreationMenu{
	private int currentMenu;
	public AvatarCreationMenu(){
		currentMenu=1;
	}

	public void createScene(Stage primaryStage){
		final int offset = 400;
        BorderPane root = new BorderPane();

        //create background
        Rectangle bg = new Rectangle(900, 600);
        	bg.setId("background_rectangle");

		Label menuTitle = new Label("Occupation Menu");
			menuTitle.setId("menu_title");
			root.setTop(menuTitle);
			root.setAlignment(menuTitle,Pos.CENTER);

        OccupationMenu smasherMenu = new OccupationMenu("Smasher");
        OccupationMenu sneakMenu = new OccupationMenu("Sneak");
        OccupationMenu summonerMenu = new OccupationMenu("Summoner");
            root.setCenter(smasherMenu);

         StackPane next = new StackPane();
        	Label nextText = new Label("NEXT");
        		nextText.setId("buttons");
            Rectangle bg1 = new Rectangle(150, 30);
            bg1.setOpacity(0.6);
            bg1.setFill(Color.BLACK);
            next.setAlignment(Pos.CENTER);
            next.getChildren().addAll(bg1, nextText);
			root.setRight(next);
    		root.setMargin(next,new Insets(0,0,25,0));
    		next.setVisible(true);
    		next.setOnMouseEntered(event -> {
                bg1.setFill(Color.WHITE);
                nextText.setTextFill(Color.BLACK);
            });

            next.setOnMouseExited(event -> {
                bg1.setFill(Color.BLACK);
                nextText.setTextFill(Color.WHITE);
            });
            next.setOnMouseClicked(event -> {
            	if(currentMenu==1) {
	            	TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.25), smasherMenu);
	                tt1.setToX(600);
	                tt1.play();
	                // TranslateTransition tt1 = new TranslateTransition(Duration.seconds(10.5), sneakMenu);
	                // tt1.setToX(100);
	                // tt1.play();

	                tt1.setOnFinished(evt -> {
                    	root.setCenter(sneakMenu);
                    	smasherMenu.setTranslateX(0);	
                    	smasherMenu.toggleButton();
	            		currentMenu++;
                	});
            	}
            	else if(currentMenu==2) {
	            	TranslateTransition tt2 = new TranslateTransition(Duration.seconds(0.25), sneakMenu);
	                tt2.setToX(600);
	                tt2.play();
	                // TranslateTransition tt1 = new TranslateTransition(Duration.seconds(10.5), sneakMenu);
	                // tt1.setToX(100);
	                // tt1.play();

	                tt2.setOnFinished(evt -> {
                    	root.setCenter(summonerMenu);
                    	sneakMenu.setTranslateX(0);
                    	sneakMenu.toggleButton();
	            		currentMenu++;
                	});
            	}
            	else if(currentMenu==3) {
	            	TranslateTransition tt3 = new TranslateTransition(Duration.seconds(0.25), summonerMenu);
	                tt3.setToX(600);
	                tt3.play();
	                // TranslateTransition tt1 = new TranslateTransition(Duration.seconds(10.5), sneakMenu);
	                // tt1.setToX(100);
	                // tt1.play();

	                tt3.setOnFinished(evt -> {
                    	root.setCenter(smasherMenu);
                    	summonerMenu.setTranslateX(0);
                    	summonerMenu.toggleButton();
	            		currentMenu = 1;
                	});
            	}
            });

        StackPane previous = new StackPane();
        	Label previousText = new Label("PREVIOUS");
        	   	previousText.setId("buttons");
            Rectangle bg2 = new Rectangle(150, 30);
            bg2.setOpacity(0.6);
            bg2.setFill(Color.BLACK);
            previous.setAlignment(Pos.CENTER);
            previous.getChildren().addAll(bg2, previousText);
			root.setLeft(previous);
    		root.setMargin(previous,new Insets(0,0,25,0));
    		previous.setVisible(true); 
    		previous.setOnMouseEntered(event -> {

                bg2.setFill(Color.WHITE);
                previousText.setTextFill(Color.BLACK);
            });

            previous.setOnMouseExited(event -> {
                bg2.setFill(Color.BLACK);
                previousText.setTextFill(Color.WHITE);
            });   
            previous.setOnMouseClicked(event -> {
            	if(currentMenu==1) {
	            	TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.25), smasherMenu);
	                tt1.setToX(-600);
	                tt1.play();
	                // TranslateTransition tt1 = new TranslateTransition(Duration.seconds(10.5), sneakMenu);
	                // tt1.setToX(100);
	                // tt1.play();

	                tt1.setOnFinished(evt -> {
                    	root.setCenter(summonerMenu);
                    	smasherMenu.setTranslateX(0);	
                    	smasherMenu.toggleButton();
	            		currentMenu = 3;
                	});
            	}
            	else if(currentMenu==2) {
	            	TranslateTransition tt2 = new TranslateTransition(Duration.seconds(0.25), sneakMenu);
	                tt2.setToX(-600);
	                tt2.play();
	                // TranslateTransition tt1 = new TranslateTransition(Duration.seconds(10.5), sneakMenu);
	                // tt1.setToX(100);
	                // tt1.play();

	                tt2.setOnFinished(evt -> {
                    	root.setCenter(smasherMenu);
                    	sneakMenu.setTranslateX(0);
                    	sneakMenu.toggleButton();
	            		currentMenu--;
                	});
            	}
            	else if(currentMenu==3) {
	            	TranslateTransition tt3 = new TranslateTransition(Duration.seconds(0.25), summonerMenu);
	                tt3.setToX(-600);
	                tt3.play();
	                // TranslateTransition tt1 = new TranslateTransition(Duration.seconds(10.5), sneakMenu);
	                // tt1.setToX(100);
	                // tt1.play();

	                tt3.setOnFinished(evt -> {
                    	root.setCenter(sneakMenu);
                    	summonerMenu.setTranslateX(0);
                    	summonerMenu.toggleButton();
	            		currentMenu--;
                	});
            	}
            });
        createScene(root, primaryStage);
	}

	public void createScene(Pane root, Stage primaryStage){
		Scene scene = new Scene(root,900,600);
        primaryStage.setScene(scene);
        scene.getStylesheets().add
            (AvatarCreationMenu.class.getResource("AvatarCreationMenu.css").toExternalForm());
        primaryStage.show();
	}
}

class OccupationMenu extends Parent{
	private int count = 0;
	private String occupation;
	private StackPane btnStart;
	private BorderPane occupationMenu;
	private ToggleButton occupationImage;
	private ImageView grayscaleImg;
	public OccupationMenu(String occupation){
		this.occupation = occupation;
		occupationMenu = new BorderPane();
		    occupationMenu.setMaxSize(900,600);
		    occupationMenu.setTranslateX(0);
		createStartButton();
		createOccupationInfo();
		getChildren().addAll(occupationMenu);
	}

	public void createStartButton(){
        btnStart = new StackPane();
        	Label text = new Label("Start Game");
            Rectangle bg = new Rectangle(250, 30);
            bg.setOpacity(0.6);
            bg.setFill(Color.BLACK);
            btnStart.setAlignment(Pos.CENTER);
            btnStart.getChildren().addAll(bg, text);
			occupationMenu.setBottom(btnStart);
    		occupationMenu.setAlignment(btnStart,Pos.BOTTOM_CENTER);
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
	}

	public void createOccupationInfo(){
		grayscaleImg = new ImageView();
			grayscaleImg.setId(occupation+"_image");
			grayscaleImg.setFitWidth(300);
		    grayscaleImg.setFitHeight(300);
		ImageView coloredImg = new ImageView();
			coloredImg.setId(occupation+"_image2");
			coloredImg.setFitWidth(300);
		    coloredImg.setFitHeight(300);
		occupationImage = new ToggleButton ("",grayscaleImg);
		ToggleGroup group = new ToggleGroup();
		occupationImage.setToggleGroup(group);
		occupationImage.setOnAction((ActionEvent e) -> {
    		count++;
    		if(count%2==0){
				occupationImage.setGraphic(grayscaleImg);
	    		btnStart.setVisible(false);
    		}
    		else{
    			occupationImage.setGraphic(coloredImg);
     			btnStart.setVisible(true);
    		}
		});
	    Label occupationName = new Label(occupation);
	    Label occupationDescription = new Label(occupation+" Description");
	    VBox vbox = new VBox(10);
	    vbox.getChildren().addAll(occupationName,occupationImage,occupationDescription);
	    vbox.setAlignment(Pos.CENTER);

	    occupationMenu.setCenter(vbox);
	    	occupationMenu.setAlignment(vbox, Pos.CENTER);
	}

	public void toggleButton(){
		count = 0;
		occupationImage.setGraphic(grayscaleImg);
		btnStart.setVisible(false);
	}
}