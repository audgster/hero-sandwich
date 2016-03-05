package Game;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PauseMenu implements Menu {
    private Pane content;
    private Pane pauseMenuView;
    private Node previousMenu;

    @Override
    public void createMenu(Pane display){
        System.out.println("Pause menu was created");
        pauseMenuView = display;
        int index = pauseMenuView.getChildren().size()-1;
            previousMenu = pauseMenuView.getChildren().get(index);
        content = createPauseMenu();
            previousMenu.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ESCAPE) {
                    doTransition();
                }
            });
        pauseMenuView.getChildren().add(content);
    }

    public void doTransition(){
        System.out.println("the pause menu is hsowing");
        if (!content.isVisible()) {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), content);
            ft.setFromValue(0);
            ft.setToValue(1);
            content.setVisible(true);
            ft.play();
            previousMenu.setOpacity(0.5);
        }
        else {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), content);
            ft.setFromValue(1);
            ft.setToValue(0);
            ft.setOnFinished(evt -> content.setVisible(false));
            ft.play();
            previousMenu.setOpacity(1);
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
        btn.setVisible(true);
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
        Rectangle bg = new Rectangle(900, 600);
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
                    InventoryMenu im = new InventoryMenu();
                    im.createMenu(pauseMenuView);
                });
            StackPane equipment = createBtn("Equipment");
            equipment.setOnMouseClicked(event -> {
                EquipmentMenu em = new EquipmentMenu();
                em.createMenu(pauseMenuView);
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
            pauseMenu.setAlignment(title,Pos.CENTER);
        pauseMenu.setVisible(false);
        return pauseMenu;
    }
}
