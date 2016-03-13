package com.herosandwich.menus;


import com.herosandwich.controller.Controller;
import com.herosandwich.creation.entity.PlayerFactory;
import com.herosandwich.menus.areaviewdrawables.TileGrid;
import com.herosandwich.models.entity.Character;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipmentType;
import com.herosandwich.models.map.Map;
import com.herosandwich.models.map.Tile;
import com.herosandwich.util.PositionHex;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.HBox;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;

import javafx.util.Duration;
import java.util.ArrayList;
import java.util.Collection;

public class AreaView implements Menu {
    private double WIDTH,HEIGHT;
    private Pane areaView;
    private HBox content;
    private Timeline gameLoop;
    private TileGrid grid;
    private boolean paused;
    Canvas canvas;
    Pane areaMenu;
    PauseMenu pm;

    public AreaView(double width, double height){
        WIDTH = width;
        HEIGHT = height;
        content = new HBox();
        gameLoop = new Timeline();
        canvas = new Canvas(WIDTH*3/4,HEIGHT);
        areaMenu = new Pane();
        pm = new PauseMenu(WIDTH,HEIGHT);
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
        root.getChildren().add(canvas);
        createAreaMenu();
        gameLoop();

        PlayerFactory factory = new PlayerFactory();
        Character avatar = factory.vendDefaultInstance();
        grid.addAvatar(avatar);
        map.addEntity(new PositionHex(0,0), avatar);

        pm.createMenu(areaView);
        createController(avatar,map);
    }

    private void createController(Character avatar, Map map){
        // Set key press event listener for Controller
        Controller controller = Controller.getController();
        controller.setCharacter(avatar);
        controller.setMap(map);
        controller.setAreaView(this);
        areaView.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                controller.executeUserInput( event.getCode() );
            }
        });
    }

    private void createAreaMenu(){
                StackPane map = new StackPane();
            map.getChildren().add(canvas);
            map.setAlignment(canvas, Pos.CENTER);
            map.setPrefSize(WIDTH, HEIGHT);
            map.setMinSize(WIDTH*3/4,HEIGHT);
            map.setMaxSize(WIDTH,HEIGHT);
        map.setId("black_bg");
        HBox.setHgrow(map, Priority.ALWAYS);
        content.setMaxSize(WIDTH,HEIGHT);
        AreaMenu am = new AreaMenu(WIDTH/4, HEIGHT);
        areaMenu = am.createMenu();

        areaMenu.setMinSize(WIDTH/4,HEIGHT);
        content.getChildren().addAll(map,areaMenu);
        areaView.getChildren().add(content);
            content.setFocusTraversable(true);
    }

    public void gameLoop(){
        gameLoop.setCycleCount( Timeline.INDEFINITE );
        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.017),
                ae->{
                    if(!paused){
                        //System.out.println(canvas.getWidth());
                        render();
                    }
                }
        );

        gameLoop.getKeyFrames().add( kf );
        gameLoop.play();
    }

    private void render() {
        canvas.getGraphicsContext2D().clearRect(0,0,canvas.getWidth(),canvas.getHeight());
        grid.draw();
    }

    public void toggleStatsMenu(){
        if(content.getChildren().contains(areaMenu)){
            System.out.println("TEsting");
            content.getChildren().remove(areaMenu);
            canvas.setWidth(WIDTH);
        }
        else{
            content.getChildren().add(areaMenu);
            canvas.setWidth(WIDTH*3/4);
        }
    }
    public void doPauseTransition(){
        pm.doTransition();
        paused = !paused;
    }
}