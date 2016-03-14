package com.herosandwich.menus;


import com.herosandwich.controller.Controller;
import com.herosandwich.creation.entity.PlayerFactory;
import com.herosandwich.events.*;
import com.herosandwich.menus.areaviewdrawables.TileGrid;
import com.herosandwich.models.entity.*;
import com.herosandwich.models.entity.Character;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipmentType;
import com.herosandwich.models.map.Map;
import com.herosandwich.models.map.Tile;
import com.herosandwich.models.occupation.Smasher;
import com.herosandwich.util.PositionHex;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AreaView implements Menu {
    private double WIDTH,HEIGHT;
    private Pane areaView;
    private Pane content;
    private Timeline gameLoop;
    private TileGrid grid;
    Canvas canvas;



    private ScrollPane scrollBar = new ScrollPane();

    public AreaView(double width, double height){
        WIDTH = width;
        HEIGHT = height;
        content = new Pane();
        gameLoop = new Timeline();
        canvas = new Canvas(WIDTH*3/4,HEIGHT);
    }

    @Override
    public void createMenu(Pane root) {
        areaView = root;
        Collection<Tile> tiles = new ArrayList<Tile>();
        PositionHex positionHex = new PositionHex(0,0);
            tiles.add(new Tile(positionHex, Tile.Terrain.GRASS));

        Collection<PositionHex> neighbors = positionHex.getNeighbors();
        for(PositionHex position : neighbors) {
            tiles.add(new Tile(position, Tile.Terrain.GRASS));

            Collection<PositionHex> others = position.getNeighbors();
            for(PositionHex nextPosition : others) {
                tiles.add(new Tile(nextPosition, Tile.Terrain.GRASS));

                Collection<PositionHex> othersNeighbors = nextPosition.getNeighbors();
                for(PositionHex nextNextPosition : othersNeighbors) {
                    tiles.add(new Tile(nextNextPosition, Tile.Terrain.GRASS));

                    Collection<PositionHex> othersNeighbors2 = nextNextPosition.getNeighbors();
                    for(PositionHex nextNextPosition2 : othersNeighbors2) {
                        tiles.add(new Tile(nextNextPosition2, Tile.Terrain.GRASS));

                        Collection<PositionHex> othersNeighbors3 = nextNextPosition2.getNeighbors();
                        for(PositionHex nextNextPosition3 : othersNeighbors3) {
                            tiles.add(new Tile(nextNextPosition3, Tile.Terrain.GRASS));

                            Collection<PositionHex> othersNeighbors4 = nextNextPosition3.getNeighbors();
                            for(PositionHex nextNextPosition4 : othersNeighbors4) {
                                tiles.add(new Tile(nextNextPosition4, Tile.Terrain.GRASS));

                                Collection<PositionHex> othersNeighbors5 = nextNextPosition4.getNeighbors();
                                for(PositionHex nextNextPosition5 : othersNeighbors5) {
                                    tiles.add(new Tile(nextNextPosition5, Tile.Terrain.GRASS));

                                    Collection<PositionHex> othersNeighbors6 = nextNextPosition5.getNeighbors();
                                    for(PositionHex nextNextPosition6 : othersNeighbors6) {
                                        tiles.add(new Tile(nextNextPosition6, Tile.Terrain.GRASS));

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        tiles.add(new Tile(new PositionHex(2,-2), Tile.Terrain.GRASS));

        Map map = new Map(20);
        map.initialize(tiles);
        grid =  map.initMyDrawable(canvas);
        //grid.makeAllTileVisible();
        //grid.setTileAsDiscovered(new PositionHex(0,0));
        map.addItem(new PositionHex(1,1), new EquipableItem("Boots", 200 ,EquipmentType.BOOTS));
        //grid.draw();
        root.getChildren().add(canvas); //scrollpane???
        createAreaMenu();
        gameLoop();

        PlayerFactory factory = new PlayerFactory();
        Character avatar = factory.vendDefaultInstance();
        Npc npc = new Npc(factory.vendCustomInstance("moldySandwich", 1,1,1,1,1,1,1, new ModiferWithWeightStatStrategy(9), new Smasher(), 1), Attitude.HOSTILE, null, null, null);
        grid.addAvatar(avatar);
        map.addEntity(new PositionHex(0,0), avatar);
        map.addEntity(new PositionHex(1,-1), npc);

        /** Set key press event listener for Controller **/
        Controller controller = Controller.getController();
        controller.setCharacter(avatar);
        controller.setMap(map);
        areaView.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                controller.executeUserInput( event.getCode() );
            }
        });

        /** Register events **/

        EventDispatcher dispatcher = EventDispatcher.getInstance();

        CharacterMeleeAttacksEntityListener damageCalculator = new CombatDamageCalculator();
        dispatcher.subscribe( CharacterMeleeAttacksEntityEvent.class, damageCalculator );

        EntityDeathHandler entityDeathHandler = new EntityDeathHandler( map );
        dispatcher.subscribe( EntityDeathEvent.class, entityDeathHandler );

        PlayerDeathHandler playerDeathHandler = new PlayerDeathHandler( map );
        dispatcher.subscribe( PlayerDeathEvent.class, playerDeathHandler );

        /** End of register events **/

//        scrollBar.setPrefSize(canvas.getWidth(), 120);
//        scrollBar.setContent(canvas);
//        scrollBar.setLayoutY(root.getWidth() - scrollBar.getWidth());
//        scrollBar.setMin(0D);
//        scrollBar.setOrientation(Orientation.HORIZONTAL);
//        scrollBar.setPrefHeight(180D);
//        scrollBar.setMaxHeight(360D);

//        scrollBar.valueProperty().addListener(new ChangeListener<Number>() {
//            public void changed(ObservableValue<? extends Number> ov,
//                                Number old_val, Number new_val) {
//                canvas.setLayoutY(-new_val.doubleValue());
//            }
//        });

    }

    private void createAreaMenu(){
        HBox temp = new HBox();

        StackPane map = new StackPane();
            map.getChildren().add(canvas);
            map.setAlignment(canvas, Pos.CENTER);
            map.setPrefSize(WIDTH, HEIGHT);
            map.setMinSize(WIDTH*3/4,HEIGHT);
            map.setMaxSize(WIDTH,HEIGHT);
        map.setId("black_bg");
        HBox.setHgrow(map, Priority.ALWAYS);
        temp.setMaxSize(WIDTH,HEIGHT);

        AreaMenu am = new AreaMenu(WIDTH/4, HEIGHT);
        Pane areaMenu = am.createMenu();

        areaMenu.setMinSize(WIDTH/4,HEIGHT);
        temp.getChildren().addAll(map,areaMenu);
        areaView.getChildren().add(temp);
//        temp.setFocusTraversable(true);
//        temp.setOnKeyPressed(event -> {
//            System.out.println("Key Pressed");
//            if (event.getCode() == KeyCode.RIGHT) {
//                temp.getChildren().remove(areaMenu);
//                canvas.setWidth(WIDTH);
//            }
//            else if (event.getCode() == KeyCode.LEFT) {
//                temp.getChildren().add(areaMenu);
//                canvas.setWidth(WIDTH*3/4);
//            }
//        });
    }

    public void gameLoop(){
        gameLoop.setCycleCount( Timeline.INDEFINITE );
        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.017),
                ae->{
                    //System.out.println(canvas.getWidth());
                   render();
                }
        );

        gameLoop.getKeyFrames().add( kf );
        gameLoop.play();
    }

    private void render() {
        canvas.getGraphicsContext2D().clearRect(0,0,canvas.getWidth(),canvas.getHeight());
        grid.draw();
    }
}