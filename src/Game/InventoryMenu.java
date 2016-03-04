package Game;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;

public class InventoryMenu {
    private BorderPane content = new BorderPane();

    public void renderMenu(Stage primaryStage) {
        Scene inventoryScene = new Scene(content, 900, 600, Color.BLACK);
        inventoryScene.getStylesheets().add("Game/InventoryMenu.css");
        setTitle("Inventory");
        setInventoryGrid();
        setLeft();
        setRight();
        setBottomBar();
        primaryStage.setScene(inventoryScene);
        primaryStage.show();
    }

    private void setBottomBar() {

    }

    private void setLeft() {
        VBox filler = new VBox();
        filler.setMinWidth(100);
        content.setLeft(filler);
    }

    private void setRight() {
        VBox filler = new VBox();
        filler.setMinWidth(100);
        content.setRight(filler);
    }

    private void setInventoryGrid() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(25,25,25,25));
        grid.setId("grid");

        ToggleGroup group = new ToggleGroup();
        for(int i = 0; i < 12; i++) {
            InventoryItem inventoryItem = new InventoryItem(new ImageView(new Image("Game/gameLogo.gif")), content, Integer.toString(i));
            inventoryItem.setToggleGroup(group);
            inventoryItem.addMouseClickEvent();
            if(i < 6) {
                grid.add(inventoryItem, i, 0, 1, 1);
            }
            else {
                grid.add(inventoryItem, i-6, 1, 1, 1);
            }
        }

        grid.setVgap(5);
        grid.setHgap(5);

        content.setCenter(grid);

    }

    private void setTitle(String title) {
        HBox topBar = new HBox();
        topBar.setAlignment(Pos.CENTER);
        topBar.setId("top-bar");

        Label titleText = new Label(title);
        titleText.setId("title");

        topBar.getChildren().add(titleText);
        content.setTop(topBar);
    }



    /*
        Used to display inventory items and make them clickable
     */
    private class InventoryItem extends ToggleButton {
        StackPane useButton = new StackPane();
        StackPane dropButton = new StackPane();
        BorderPane content;
        String item;

        public InventoryItem(ImageView image, BorderPane content, String item) {
            super("", image);
            image.setFitHeight(100);
            image.setFitWidth(100);
            this.item = item;
            this.content = content;
            super.setId("inventory-items");
         }

        public void addMouseClickEvent() {
            super.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    System.out.println("Toggle was Clicked");
                    addButtons();
                    event.consume();
                }
            });


            //Add untoggle and remove buttons
        }

        private void addButtons() {
            initButtons();
        }

        private void initButtons() {
            HBox horitonalContianer = new HBox(10);
            initUseButton(horitonalContianer);
            initDropButton(horitonalContianer);
            horitonalContianer.setAlignment(Pos.CENTER);
            content.setBottom(horitonalContianer);

            setUseButtonClickEvent();
            setDropButtonClickEvent();
        }

        private void setUseButtonClickEvent() {
            useButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    System.out.println("Item:" + item + " used!");
                }
            });
        }

        private void setDropButtonClickEvent() {
            dropButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    System.out.println("Item:" + item + " dropped!");
                    itemUsedOrSelected();
                }
            });
        }

        private void itemUsedOrSelected() {
            ImageView image = new ImageView(new Image("Game/gameLogo.jpg"));

            image.setFitHeight(100);
            image.setFitWidth(100);
            super.setGraphic(image);
        }

        private void initDropButton(HBox horizontalContainer) {
            Label buttonText = new Label("Drop");
            buttonText.setId("button-text");
            Rectangle backGround = new Rectangle(150, 30);
            backGround.setId("button-background");
            dropButton.setAlignment(Pos.CENTER);
            dropButton.getChildren().addAll(backGround, buttonText);
            dropButton.setPadding(new Insets(5, 5, 5, 5));
            dropButton.setVisible(true);
            horizontalContainer.getChildren().add(dropButton);

            addHoverEvent(dropButton, backGround, buttonText);


        }

        private void initUseButton(HBox horizontalContainer) {
            Label buttonText = new Label("Use");
            buttonText.setId("button-text");
            Rectangle backGround = new Rectangle(150, 30);
            backGround.setId("button-background");
            useButton.setAlignment(Pos.CENTER);
            useButton.setPadding(new Insets(5, 5, 5, 5));
            useButton.getChildren().addAll(backGround, buttonText);
            useButton.setVisible(true);
            horizontalContainer.getChildren().add(useButton);

            addHoverEvent(useButton, backGround, buttonText);
        }

        private void addHoverEvent(StackPane button, Shape backGround, Label buttonText) {
            addMouseEnteredEvent(button, backGround, buttonText);
            addMouseExitEvent(button, backGround, buttonText);
        }

        private void addMouseEnteredEvent(StackPane button, Shape backGround, Label buttonText) {
            button.setOnMouseEntered(event -> {
                backGround.setFill(Color.WHITE);
                buttonText.setTextFill(Color.BLACK);
            });
        }

        private void addMouseExitEvent(StackPane button, Shape backGround, Label buttonText) {
            button.setOnMouseExited(event -> {
                backGround.setFill(Color.BLACK);
                buttonText.setTextFill(Color.WHITE);
            });
        }
    }

}
