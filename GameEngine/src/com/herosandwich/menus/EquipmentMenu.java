package  com.herosandwich.menus;

import com.herosandwich.menus.areaviewdrawables.SpriteMap;
import com.herosandwich.models.equipment.Equipment;
import com.herosandwich.models.entity.Character;

import com.herosandwich.models.equipment.EquipmentSlots;
import com.herosandwich.models.items.takeableItems.TakeableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.HashMap;

/**
 * Created by adamfortier on 3/4/16.
 */
public class EquipmentMenu implements Menu {
    private double WIDTH,HEIGHT;
    private Character avatar;
    private BorderPane content;
    private Pane equipmentMenu;
    private EquipmentItem selectedItem;

    private EquipableItem[] equipment;
    private Equipment e;

    public EquipmentMenu(double width, double height,Character avatar){
        WIDTH = width;
        HEIGHT = height;
        this.avatar = avatar;
        content = new BorderPane();
        equipmentMenu = new Pane();
        e = avatar.getEquipment();
        equipment = e.getEquipmentArray();
    }

    @Override
    public void createMenu(Pane root) {
        content.setId("menu_bg");
            content.setMinSize(WIDTH,HEIGHT);
        setTop("Equipment");
        setEquipmentGrid();
        //setLeft();
        setRight();

        equipmentMenu = root;
        equipmentMenu.getChildren().add(content);
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
            removeEquipmentView();
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

    private void setEquipmentGrid() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(25,25,25,25));
        grid.setId("grid");

        ToggleGroup group = new ToggleGroup();
        int index = 0;
        for(int i = 0; i < 12; i++) {
                EquipmentItem equipmentItem = new EquipmentItem(content, equipment[index]);
                equipmentItem.setToggleGroup(group);
                equipmentItem.addMouseClickEvent();
                if(i < 8 && i > 3) {
                    grid.add(equipmentItem, 1, i-4, 1, 1);
                    index++;
                }
                else if(i == 1) {
                    grid.add(equipmentItem, 0, i, 1, 1);
                    index++;
                }
                else if(i == 9) {
                    grid.add(equipmentItem, 2, i-8, 1, 1);
                    index++;
                    break;
                }
        }
        grid.setVgap(5);
        grid.setHgap(5);

        content.setLeft(grid);

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

    private void removeEquipmentView(){
        equipmentMenu.getChildren().remove(content);
    }

    public void setEquipmentView(Pane display) {
        display.getChildren().add(content);
    }

    private void removeItem(TakeableItem item){
       // e.removeItem(item);
    }


    /*
        Used to display inventory items and make them clickable
     */
    private class EquipmentItem extends ToggleButton {
        VBox horizontalContainer = null;
        StackPane useButton;
        StackPane dropButton;
        BorderPane content;
        String itemName;
        EquipableItem item;
        Boolean selected = false;

        public EquipmentItem(BorderPane content, EquipableItem item) {
            super("");
            this.item = item;
            SpriteMap spriteMap = SpriteMap.getInstance();
            ImageView image;
            if(item == null){
                image = new ImageView(new Image("res/images/items/item_bg.jpg"));
            }
            else{
                image = new ImageView(spriteMap.getImageForKey(item.getItemId()));
            }
            this.item = item;
            this.setGraphic(image);
            image.setFitHeight(HEIGHT / 8);
            image.setFitWidth(HEIGHT/8);
            this.content = content;
            super.setId("inventory-items");
        }

        public void addMouseClickEvent() {
            super.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (item != null) {
                        addButtons();
                        toggleButtons(selected);
                        event.consume();
                    }
                    setSelectedItem();
                }
            });
        }

        private void setSelectedItem() {
            if (selectedItem != this && selectedItem != null) {
                selectedItem.toggleButtons(true);
            }
            selectedItem = this;
        }

        private void addButtons() {
            if (horizontalContainer == null) {
                initButtons();
            }
        }

        private void toggleButtons(boolean select) {
            selected = !select;
            if (selected) {
                if(!horizontalContainer.getChildren().contains(useButton)){
                    initButtons();
                }
            } else {
                if(useButton!=null)
                horizontalContainer.getChildren().remove(useButton);
            }
        }

        private void initButtons() {
            horizontalContainer = new VBox(60);
            horizontalContainer.setMinHeight(HEIGHT / 3);
            //horizontalContainer.getChildren().add(new ImageView(new Image("res/images/smasher.gif")));
            initUseButton(horizontalContainer);
            horizontalContainer.setAlignment(Pos.CENTER);
            horizontalContainer.setPadding(new Insets(0, 100, 0, 0));
            content.setRight(horizontalContainer);

            setUnequipButtonClickEvent();
        }

        private void setUnequipButtonClickEvent() {
            useButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    System.out.println("Item:" + item + " unequipped!");
                    if(avatar.removeItemFromEquipment(item)){
                        itemUnequippedSelected();
                    }
                }
            });
        }

        private void itemUnequippedSelected() {
            ImageView image = new ImageView(new Image("res/images/items/item_bg.jpg"));
            image.setFitHeight(HEIGHT / 8);
            image.setFitWidth(HEIGHT / 8);
            super.setGraphic(image);
            removeItem(item);
            item = null;
            selectedItem = null;
            toggleButtons(selected);
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

        private void initUseButton(VBox horizontalContainer) {
            useButton = new StackPane();
            Label buttonText = new Label("Unequip");
            buttonText.setId("button_text");
            Rectangle backGround = new Rectangle(WIDTH/6,HEIGHT/15);
            backGround.setId("button_rectangle");
            useButton.setAlignment(Pos.CENTER);
            useButton.setPadding(new Insets(5, 5, 45, 5));
            useButton.getChildren().addAll(backGround, buttonText);
            useButton.setVisible(true);
            horizontalContainer.getChildren().add(useButton);

            addHoverEvent(useButton, backGround, buttonText);
        }
    }
}
