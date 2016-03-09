package  com.herosandwich.menus;

import com.herosandwich.models.equipment.Equipment;
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

/**
 * Created by adamfortier on 3/4/16.
 */
public class EquipmentMenu implements Menu {
    private BorderPane content = new BorderPane();
    private Pane equipmentMenu;
    private EquipmentItem selectedItem;

    @Override
    public void createMenu(Pane root) {
        content.setId("menu_bg");
            content.setMinSize(1200,800);
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
        filler.setMinWidth(100);
        content.setLeft(filler);
    }

    private void setRight() {
        VBox filler = new VBox();
        filler.setMinWidth(100);
        content.setRight(filler);
    }

    private void setEquipmentGrid() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(25,25,25,25));
        grid.setId("grid");

        ToggleGroup group = new ToggleGroup();
        for(int i = 0; i < 12; i++) {
            EquipmentItem equipmentItem = new EquipmentItem(content, Integer.toString(i));
            equipmentItem.setToggleGroup(group);
            equipmentItem.addMouseClickEvent();
            if(i < 8 && i > 3) {
                grid.add(equipmentItem, 1, i-4, 1, 1);
            }
            else if(i == 1) {
                grid.add(equipmentItem, 0, i, 1, 1);
            }
            else if(i == 9) {
                grid.add(equipmentItem, 2, i-8, 1, 1);
            }
        }

//        grid.getChildren().get(0).setOpacity(0);
//        grid.getChildren().get(2).setOpacity(0);
//        grid.getChildren().get(3).setOpacity(0);
//        grid.getChildren().get(8).setOpacity(0);
//        grid.getChildren().get(10).setOpacity(0);
//        grid.getChildren().get(11).setOpacity(0);

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


    /*
        Used to display inventory items and make them clickable
     */
    private class EquipmentItem extends ToggleButton {
        VBox horizontalContainer = null;
        StackPane useButton;
        StackPane dropButton;
        BorderPane content;
        String item;
        Boolean selected = false;

        public EquipmentItem(BorderPane content, String item2) {
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
                horizontalContainer.getChildren().remove(useButton);
            }
        }

        private void initButtons() {
            horizontalContainer = new VBox(60);
            horizontalContainer.getChildren().add(new ImageView(new Image("res/images/smasher.gif")));
            initUseButton(horizontalContainer);
            //initDropButton(horizontalContainer);
            horizontalContainer.setAlignment(Pos.CENTER);
            horizontalContainer.setPadding(new Insets(0, 100, 0, 0));
            content.setRight(horizontalContainer);

            setUseButtonClickEvent();
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

        private void itemUsedOrDroppedSelected() {
            ImageView image = new ImageView(new Image("res/images/item_bg.jpg"));
            image.setFitHeight(100);
            image.setFitWidth(100);
            super.setGraphic(image);
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
            Rectangle backGround = new Rectangle(150, 30);
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
