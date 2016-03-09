package  com.herosandwich.menus;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


public class InventoryMenu implements Menu {
    private BorderPane content = new BorderPane();
    private Pane inventoryView;
    GridPane grid = new GridPane();
    private InventoryItem selectedItem = null;

    @Override

    public void createMenu(Pane root) {
        content.setId("menu_bg");
            content.setMinSize(1200,800);
        setTop("Inventory");
        setInventoryGrid();
        setLeft();
        setRight();

        inventoryView = root;
        inventoryView.getChildren().add(content);
    }


    private HBox getBackButton() {
        StackPane backButton = new StackPane();
        HBox container = new HBox();
        Label buttonText = new Label("Back");
        buttonText.setAlignment(Pos.CENTER);
        buttonText.setId("button_text");
        Rectangle backGround = new Rectangle(150, 30);
        backGround.setId("button_rectangle");
        backButton.setAlignment(Pos.CENTER);
        backButton.setPadding(new Insets(5, 5, 5, 45));
        backButton.getChildren().addAll(backGround, buttonText);
        backButton.setVisible(true);

        addHoverEvent(backButton, backGround, buttonText);
        addBackButtonClickEvent(backButton);

        //return backButton;
        container.getChildren().add(backButton);
        container.setAlignment(Pos.CENTER_LEFT);
        return container;
    }

    private void addBackButtonClickEvent(StackPane backButton) {
        backButton.setOnMouseClicked(event -> {
            removeInventoryView();
        });
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

    public void setInventoryView(Pane display) {
        display.getChildren().add(content);
    }

    private void setInventoryGrid() {
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(25,25,25,25));
        grid.setId("grid");

        ToggleGroup group = new ToggleGroup();
        for(int i = 0; i < 12; i++) {
            InventoryItem inventoryItem = new InventoryItem(content, Integer.toString(i));
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

    private void setTop(String title) {
        StackPane topBar = new StackPane();
        HBox titleBox = new HBox();
        titleBox.setAlignment(Pos.CENTER);

        Label titleText = new Label(title);
        titleText.setId("menu_title");

        titleBox.getChildren().add(titleText);
        topBar.getChildren().addAll(titleBox, getBackButton());

        content.setTop(topBar);
    }

    private void removeInventoryView(){
        inventoryView.getChildren().remove(content);
    }


    /*
        Used to display inventory items and make them clickable
     */
    private class InventoryItem extends ToggleButton {
        HBox horizontalContainer = null;
        StackPane useButton;
        StackPane dropButton;
        BorderPane content;
        String item;
        Boolean selected = false;

        public InventoryItem(BorderPane content, String item2) {
            super("");
            item = "res/images/" + "smasher" + ".gif";
            ImageView image = new ImageView(new Image(item));
                this.setGraphic(image);
                image.setFitHeight(100);
                image.setFitWidth(100);
            this.item = item2;
            this.content = content;
            super.setId("inventory-items");
         }

        public void addMouseClickEvent() {
            super.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if(item != null){
                        addButtons();
                        toggleButtons(selected);
                        event.consume();
                    }
                    setSelectedItem();
                }
            });
        }

        private void setSelectedItem(){
            if(selectedItem != this && selectedItem != null) {
                selectedItem.toggleButtons(false);
            }
            selectedItem = this;
        }

        private void addButtons() {
            if(horizontalContainer == null){
                initButtons();
            }
        }


        private void toggleButtons(boolean select) {
            if(selected){
                initButtons();
            }
            else{
                content.getChildren().remove(horizontalContainer);
            }
            selected = !select;

        }

        private void initButtons() {
            horizontalContainer = new HBox(10);
            initUseButton(horizontalContainer);
            initDropButton(horizontalContainer);
            horizontalContainer.setAlignment(Pos.CENTER);
            content.setBottom(horizontalContainer);

            setUseButtonClickEvent();
            setDropButtonClickEvent();
        }

        private void setUseButtonClickEvent() {
            useButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                    System.out.println("Item:" + item + " used!");
                    itemUsedOrDroppedSelected();
                }
            });
        }

        private void setDropButtonClickEvent() {
            dropButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    System.out.println("Item:" + item + " dropped!");
                    itemUsedOrDroppedSelected();
                }
            });
        }

        private void itemUsedOrDroppedSelected() {
            ImageView image = new ImageView(new Image("res/images/item_bg.jpg"));
            image.setFitHeight(100);
            image.setFitWidth(100);
            super.setGraphic(image);
            item = null;
            selectedItem = null;
            toggleButtons(selected);
        }

        private void initDropButton(HBox horizontalContainer) {
            dropButton = new StackPane();
            Label buttonText = new Label("Drop");
            buttonText.setId("button_text");
            Rectangle backGround = new Rectangle(150, 30);
            backGround.setId("button_rectangle");
            dropButton.setAlignment(Pos.CENTER);
            dropButton.getChildren().addAll(backGround, buttonText);
            dropButton.setPadding(new Insets(5, 5, 5, 5));
            dropButton.setVisible(true);
            horizontalContainer.getChildren().add(dropButton);

            addHoverEvent(dropButton, backGround, buttonText);


        }

        private void initUseButton(HBox horizontalContainer) {
            useButton = new StackPane();
            Label buttonText = new Label("Use");
            buttonText.setId("button_text");
            Rectangle backGround = new Rectangle(150, 30);
            backGround.setId("button_rectangle");
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
