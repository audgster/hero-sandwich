package Game;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
            InventoryItem inventoryItem = new InventoryItem(new ImageView(new Image("Game/gameLogo.jpg")));
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

        public InventoryItem(ImageView image) {
            super("", image);
            image.setFitHeight(100);
            image.setFitWidth(100);
         }

        public void addMouseClickEvent() {
            super.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    System.out.println("Toggle was Clicked");
                    event.consume();
                }
            });
        }

        private void addButtons() {
            initButtons();
        }

        private void initButtons() {

        }
    }

}
