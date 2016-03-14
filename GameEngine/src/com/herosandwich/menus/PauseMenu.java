package  com.herosandwich.menus;

import com.herosandwich.models.entity.Character;
import com.herosandwich.models.entity.Player;
import com.herosandwich.util.persistence.Saver;
import com.herosandwich.util.persistence.XmlSaver;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;
import javafx.scene.control.Label;
import javafx.scene.Node;

import java.awt.*;
import java.awt.geom.Area;
import java.io.File;

public class PauseMenu implements Menu {
    private double WIDTH, HEIGHT;
    private Character avatar;
    private Pane content;
    private Pane pauseMenuView;
    private Node bgMenu;
    private AreaView areaView;
    private InventoryMenu inventoryMenu = null;
    private EquipmentMenu equipmentMenu = null;

    private Stage stage;

    public PauseMenu(Stage stage, double width, double height, Character avatar, AreaView areaView){
        this.stage = stage;
        WIDTH = width;
        HEIGHT = height;
        this.avatar = avatar;
        this.areaView = areaView;
    }

    public boolean getIsPause(){
        return content.isVisible();
    }

    @Override
    public void createMenu(Pane display){
        pauseMenuView = display;

        int index = pauseMenuView.getChildren().size()-1;
            bgMenu = pauseMenuView.getChildren().get(index);
            bgMenu.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ESCAPE) {
                    //doTransition();
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
            areaView.stop();
            //bgMenu.setOpacity(0.5);
        }
        else {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), content);
            ft.setFromValue(1);
            ft.setToValue(0);
            ft.setOnFinished(evt -> content.setVisible(false));
            ft.play();
            areaView.play();
            //bgMenu.setOpacity(1);
        }
    }

    private StackPane createBtn(String btnName){
        StackPane btn = new StackPane();
            btn.setMaxSize(WIDTH/6, HEIGHT/15);
        Label btnText = new Label(btnName);
            btnText.setId("button_text");
        Rectangle bg = new Rectangle(WIDTH/6, HEIGHT/15);
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
        Rectangle bg = new Rectangle(WIDTH,HEIGHT);
            bg.setOpacity(0.75);
            bg.setFill(Color.BLACK);
            bg.setEffect(new GaussianBlur(3.5));
            bg.setOnMouseClicked(event -> {
                doTransition();
            });

        Label title = new Label("Pause Menu");
            title.setId("menu_title");
            title.setTranslateY(-HEIGHT/3.2);

        VBox pauseOptions = new VBox(2);
            StackPane resume = createBtn("Resume");
                resume.setOnMouseClicked(event -> {
                    doTransition();
                });

            StackPane load = createBtn("Save");
                load.setOnMouseClicked(event -> {
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.setTitle("Choose save file");
                    File file = fileChooser.showOpenDialog(stage);

                    areaView.saveGame(file);
                });


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
        pauseOptions.setMaxSize(WIDTH*5/8, HEIGHT/15);
        pauseOptions.setTranslateX(-200);

        StackPane pauseMenu = new StackPane();
        pauseMenu.getChildren().addAll(bg,title,pauseOptions);
            StackPane.setAlignment(title,Pos.CENTER);
        pauseMenu.setVisible(false);
        return pauseMenu;
    }

    private void getInventoryMenu() {
            inventoryMenu = new InventoryMenu(WIDTH,HEIGHT,avatar);
            inventoryMenu.createMenu(pauseMenuView);
    }

    private void getEquipmentMenu() {
        if(equipmentMenu == null) {
            equipmentMenu = new EquipmentMenu(WIDTH,HEIGHT);
            equipmentMenu.createMenu(pauseMenuView);
        }
        else {
            equipmentMenu.setEquipmentView(pauseMenuView);
        }
    }
}
