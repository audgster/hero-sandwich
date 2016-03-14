package  com.herosandwich.menus;

import com.herosandwich.menus.areaviewdrawables.SpriteMap;
import com.herosandwich.models.entity.Character;
import com.herosandwich.models.entity.Player;
import com.herosandwich.models.inventory.Inventory;
import com.herosandwich.models.items.takeableItems.TakeableItem;

import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;
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

import java.util.ArrayList;
import java.util.List;


public class InventoryMenu implements Menu {
    private double WIDTH, HEIGHT;
    private int capacity;
    private BorderPane content;
    private Pane inventoryView;
    private InventoryItem selectedItem;

    private Character avatar;
    private Inventory i;
    private ArrayList<TakeableItem> inventory;

    public InventoryMenu(double width, double height, Character avatar){
        WIDTH = width;
        HEIGHT = height;
        this.avatar = avatar;
        i = avatar.getInventory();
        this.inventory = i.getInventory();
        capacity = i.getCapacity();
        content = new BorderPane();
    }
    @Override
    public void createMenu(Pane root) {
        content.setId("menu_bg");
        content.setMinSize(WIDTH,HEIGHT);
        setTop("Inventory");
        setInventoryGrid();
        setLeft();
        setRight();

        inventoryView = root;
        inventoryView.getChildren().add(content);
    }
    public void update(){
        inventory = i.getInventory();
        content.setCenter(null);
        setInventoryGrid();
    }


    private HBox getBackButton() {
        StackPane backButton = new StackPane();
        HBox container = new HBox();
        Label buttonText = new Label("Back");
        buttonText.setAlignment(Pos.CENTER);
        buttonText.setId("button_text");
        Rectangle backGround = new Rectangle(WIDTH/6,HEIGHT/15);
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
        filler.setMinWidth(HEIGHT/8);
        content.setLeft(filler);
    }

    private void setRight() {
        VBox filler = new VBox();
        filler.setMinWidth(HEIGHT/8);
        content.setRight(filler);
    }

    public void setInventoryView(Pane display) {
        display.getChildren().add(content);
    }

    private void setInventoryGrid() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(25,25,25,25));
        grid.setId("grid");

        ToggleGroup group = new ToggleGroup();
        int row = 0;
        int col = 0;
        for(int i = 0; i < capacity; i++) {
            InventoryItem inventoryItem;
            if(inventory.get(i) != null){
                inventoryItem = new InventoryItem(content, inventory.get(i));
            }
            else {
                inventoryItem = new InventoryItem(content);
            }

            inventoryItem.setToggleGroup(group);
            inventoryItem.addMouseClickEvent();
            grid.add(inventoryItem, col, row, 1, 1);
            col++;
            if(col == 6) {
                row++;
                col = 0;
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

    private void removeItem(TakeableItem item){
        i.removeItem(item);
    }


    /*
        Used to display inventory items and make them clickable
     */
    private class InventoryItem extends ToggleButton {
        HBox horizontalContainer = null;
        StackPane useButton;
        StackPane dropButton;
        BorderPane content;
        String itemName;
        TakeableItem item;
        Boolean selected = false;

        public InventoryItem(BorderPane content){
            super("");
            super.setId("inventory-items");

            this.content = content;
            itemName = "res/images/items/item_bg.jpg";
            ImageView itemImg = new ImageView(new Image(itemName));
            this.setGraphic(itemImg);
            itemImg.setFitHeight(HEIGHT/8);
            itemImg.setFitWidth(HEIGHT/8);
        }
        public InventoryItem(BorderPane content, TakeableItem item) {
            super("");
            super.setId("inventory-items");

            this.content = content;
            this.item = item;
            SpriteMap spriteMap = SpriteMap.getInstance();
            itemName = "res/images/items/" + item.getName() + ".gif";
            ImageView itemImg = new ImageView(spriteMap.getImageForKey(item.getItemId()));
            this.setGraphic(itemImg);
                itemImg.setFitHeight(HEIGHT/8);
                itemImg.setFitWidth(HEIGHT/8);
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
                selectedItem.toggleButtons(true);
            }
            selectedItem = this;
        }

        private void addButtons() {
            if(horizontalContainer == null){
                initButtons();
            }
        }


        private void toggleButtons(boolean select) {
            selected = !select;
            if(selected){
                initButtons();
            }
            else{
                content.getChildren().remove(horizontalContainer);
            }
        }

        private void initButtons() {
            horizontalContainer = new HBox(10);
            initUseButton(horizontalContainer);
            initDropButton(horizontalContainer);
            horizontalContainer.setAlignment(Pos.CENTER);
            horizontalContainer.setTranslateY(-HEIGHT/25);
            content.setBottom(horizontalContainer);

            setUseButtonClickEvent();
            setDropButtonClickEvent();
        }

        private void setUseButtonClickEvent() {
            useButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                    System.out.println("Item: " + item.getName() + " used!");
                    if(item.getAction().equals("Equip")){
                        if(avatar.addToEquipment((EquipableItem)item)){
                            itemUsedOrDroppedSelected();
                        }
                    }
                    else if (item.getAction().equals("Consume")){
                        itemUsedOrDroppedSelected();
                    }
                }
            });
        }

        private void setDropButtonClickEvent() {
            dropButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    System.out.println("Item: " + item.getName() + " dropped!");
                    itemUsedOrDroppedSelected();
                }
            });
        }

        private void itemUsedOrDroppedSelected() {
            ImageView image = new ImageView(new Image("res/images/items/item_bg.jpg"));
            image.setFitHeight(HEIGHT / 8);
            image.setFitWidth(HEIGHT / 8);
            super.setGraphic(image);
            removeItem(item);
            item = null;
            selectedItem = null;
            toggleButtons(selected);
        }

        private void initDropButton(HBox horizontalContainer) {
            dropButton = new StackPane();
            Label buttonText = new Label("Drop");
            buttonText.setId("button_text");
            Rectangle backGround = new Rectangle(WIDTH/6,HEIGHT/15);
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
            Label buttonText = new Label(item.getAction());
            buttonText.setId("button_text");
            Rectangle backGround = new Rectangle(WIDTH/6,HEIGHT/15);
            backGround.setId("button_rectangle");
            useButton.setAlignment(Pos.CENTER);
            useButton.setPadding(new Insets(5, 5, 5, 5));
            useButton.getChildren().addAll(backGround, buttonText);
            useButton.setVisible(true);
            horizontalContainer.getChildren().add(useButton);

            addHoverEvent(useButton, backGround, buttonText);

            if(item.getAction().equals("")){
                useButton.setVisible(false);
            }

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