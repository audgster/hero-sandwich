package  com.herosandwich.menus;

import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;
import javafx.scene.control.Label;
import javafx.scene.Node;

public class PauseMenu implements Menu {
    private Pane content;
    private Pane pauseMenuView;
    private Node bgMenu;
    private InventoryMenu inventoryMenu = null;
    private EquipmentMenu equipmentMenu = null;

    @Override
    public void createMenu(Pane display){
        pauseMenuView = display;

        int index = pauseMenuView.getChildren().size()-1;
            bgMenu = pauseMenuView.getChildren().get(index);
            bgMenu.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ESCAPE) {
                    doTransition();
                }
            });

        content = createPauseMenu();

        pauseMenuView.getChildren().add(content);
    }

    public void doTransition(){
        if (!content.isVisible()) {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), content);
            ft.setFromValue(0);
            ft.setToValue(1);
            content.setVisible(true);
            ft.play();
            //bgMenu.setOpacity(0.5);
        }
        else {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), content);
            ft.setFromValue(1);
            ft.setToValue(0);
            ft.setOnFinished(evt -> content.setVisible(false));
            ft.play();
            //bgMenu.setOpacity(1);
        }
    }

    private StackPane createBtn(String btnName){
        StackPane btn = new StackPane();
            btn.setMaxSize(250,30);
        Label btnText = new Label(btnName);
            btnText.setId("button_text");
        Rectangle bg = new Rectangle(150, 30);
            bg.setId("button_rectangle");
        btn.setAlignment(Pos.CENTER);
        btn.getChildren().addAll(bg, btnText);
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

    public StackPane createPauseMenu(){
        Rectangle bg = new Rectangle(1200,800);
            bg.setOpacity(0.75);
            bg.setFill(Color.BLACK);
            bg.setEffect(new GaussianBlur(3.5));
            bg.setOnMouseClicked(event -> {
                doTransition();
            });

        Label title = new Label("Pause Menu");
            title.setId("menu_title");
            title.setTranslateY(-250);

        VBox pauseOptions = new VBox(2);
            StackPane resume = createBtn("Resume");
                resume.setOnMouseClicked(event -> {
                    doTransition();
                });
            StackPane load = createBtn("Load");
            StackPane inventory = createBtn("Inventory");
                inventory.setOnMouseClicked(event -> {
                    getInventoryMenu();
                });
            StackPane equipment = createBtn("Equipment");
            equipment.setOnMouseClicked(event -> {
                getEquipmentMenu();
            });
            StackPane quit = createBtn("Quit");
                quit.setOnMouseClicked(event -> {
                    System.exit(0);
                });
        pauseOptions.getChildren().addAll(resume,load,inventory,equipment,quit);
        pauseOptions.setMaxSize(150,130);
        pauseOptions.setTranslateX(-200);

        StackPane pauseMenu = new StackPane();
        pauseMenu.getChildren().addAll(bg,title,pauseOptions);
            StackPane.setAlignment(title,Pos.CENTER);
        pauseMenu.setVisible(false);
        return pauseMenu;
    }

    private void getInventoryMenu() {
        if(inventoryMenu == null) {
            inventoryMenu = new InventoryMenu();
            inventoryMenu.createMenu(pauseMenuView);
        }
        else {
            inventoryMenu.setInventoryView(pauseMenuView);
        }
    }

    private void getEquipmentMenu() {
        if(equipmentMenu == null) {
            equipmentMenu = new EquipmentMenu();
            equipmentMenu.createMenu(pauseMenuView);
        }
        else {
            equipmentMenu.setEquipmentView(pauseMenuView);
        }
    }
}
