package com.herosandwich.menus;


import com.herosandwich.controller.Controller;
import com.herosandwich.creation.entity.PlayerFactory;
import com.herosandwich.events.*;
import com.herosandwich.menus.areaviewdrawables.TileGrid;
import com.herosandwich.models.Game;
import com.herosandwich.models.entity.*;
import com.herosandwich.models.entity.Character;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipmentType;
import com.herosandwich.models.map.Map;
import com.herosandwich.models.map.MapEventHandler;
import com.herosandwich.models.map.Tile;
import com.herosandwich.models.occupation.Smasher;
import com.herosandwich.util.PositionHex;

import com.herosandwich.util.persistence.Loader;
import com.herosandwich.util.persistence.Saver;
import com.herosandwich.util.persistence.XmlLoader;
import com.herosandwich.util.persistence.XmlSaver;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.geom.Area;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public class AreaView implements Menu {
    private double WIDTH,HEIGHT;
    private Npc talkingPerson;
    private Game game;
    private Pane areaView;
    private HBox content;
    private Timeline gameLoop;
    private TileGrid grid;
    Canvas canvas;
    Pane areaMenu;
    PauseMenu pm;
    AreaMenu am;
    Player avatar;
    ShopMenu shop;

    private Stage stage;

    private ScrollPane scrollBar;

    public AreaView(Stage stage, double width, double height, Player avatar){
        this.stage = stage;

        WIDTH = width;
        HEIGHT = height;

        this.avatar = avatar;
        loadGame(avatar);

        content = new HBox();
        gameLoop = new Timeline();
        canvas = new Canvas(WIDTH*3/4,HEIGHT);
        areaMenu = new Pane();
        pm = new PauseMenu(stage, WIDTH,HEIGHT,avatar,this);
        am = new AreaMenu(WIDTH/4,HEIGHT,avatar,this);
        talkingPerson = new Npc();
        shop = new ShopMenu(WIDTH,HEIGHT,talkingPerson,avatar);
    }

    public AreaView(Stage stage, double width, double height, File loadFile)
    {
        loadGame(loadFile);

        this.stage = stage;

        WIDTH = width;
        HEIGHT = height;
        content = new HBox();
        gameLoop = new Timeline();
        canvas = new Canvas(WIDTH*3/4,HEIGHT);
        areaMenu = new Pane();
        pm = new PauseMenu(stage, WIDTH,HEIGHT,game.getAvatar(), this);
        am = new AreaMenu(WIDTH/4,HEIGHT,game.getAvatar(),this);
    }

    public void updateTileGrid()
    {
        grid =  game.getMap().initMyDrawable(canvas);

        createAreaMenu();
        gameLoop();

        grid.addAvatar(game.getAvatar());

        createController(game.getMap());
    }

    @Override
    public void createMenu(Pane root) {
        areaView = root;

        updateTileGrid();

        /** Register events **/

        EventDispatcher dispatcher = EventDispatcher.getInstance();

        CharacterMeleeAttacksEntityListener damageCalculator = new CombatDamageCalculator();
        dispatcher.subscribe( CharacterMeleeAttacksEntityEvent.class, damageCalculator );

        EntityDeathHandler entityDeathHandler = new EntityDeathHandler( game.getMap() );
        dispatcher.subscribe( EntityDeathEvent.class, entityDeathHandler );

        PlayerDeathHandler playerDeathHandler = new PlayerDeathHandler( game.getMap() );
        dispatcher.subscribe( PlayerDeathEvent.class, playerDeathHandler );

        //Hope this $#!+ works
        MapEventHandler mapEventHandler = new MapEventHandler(game.getMap());
        dispatcher.subscribe(CharacterPickUpItemEvent.class, (CharacterPickUpItemListener) mapEventHandler);
        dispatcher.subscribe(PetPickUpItemEvent.class, (PetPickUpItemListener) mapEventHandler);
        dispatcher.subscribe(EntityActivatesAoEEvent.class, (EntityActivatesAoEListener) mapEventHandler);

        /** End of register events **/
        shop.createMenu(areaView);
    }

    private void createAreaMenu(){
                StackPane map = new StackPane();
            map.getChildren().add(canvas);
            map.setAlignment(canvas, Pos.CENTER);
            map.setPrefSize(WIDTH, HEIGHT);
            map.setMinSize(WIDTH*3/4,HEIGHT);
            map.setMaxSize(WIDTH,HEIGHT);
        //createOccupationSkills(map);
        map.setId("black_bg");
        HBox.setHgrow(map, Priority.ALWAYS);
        content.setMaxSize(WIDTH,HEIGHT);
        areaMenu = am.createMenu();

        areaMenu.setMinSize(WIDTH/4,HEIGHT);
        content.getChildren().addAll(map,areaMenu);
        areaView.getChildren().add(content);
            //pm.createMenu(areaView);
        content.setFocusTraversable(true);
    }

    private void createOccupationSkills(StackPane display){
        StackPane occupationLayout = new StackPane();
        occupationLayout.setMaxSize(WIDTH*3/4,HEIGHT);
        HBox occupationBoxes = new HBox(2);
        for(int i = 0; i < avatar.getOccupation().getLearnedSkills().size(); i++){
            Rectangle box = new Rectangle(100,100,Color.WHITE);
                box.setOpacity(0.5);
            occupationBoxes.getChildren().add(box);
        }
       // occupationLayout.getChildren().add(occupationBoxes);
        display.getChildren().add(occupationBoxes);
    }

    private void createController(Map map){
        /** Set key press event listener for Controller **/
        PetAIController petAIController = new PetAIController(game.getAvatar(), map);
        Controller controller = Controller.getController();
        controller.setCharacter(game.getAvatar());
        controller.setMap(map);
        controller.setAreaView(this);
        controller.setGridView(grid);
        areaView.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                controller.executeUserInput( event.getCode() );
            }
        });
    }
    public void gameLoop(){
        gameLoop.setCycleCount( Timeline.INDEFINITE );
        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.017),
                ae->{
                    render();
                }
        );

        gameLoop.getKeyFrames().add( kf );
        gameLoop.play();
    }

    public void updateStatsMenu(){
        if(talkingPerson!=null){
            String[] thingsToSay = talkingPerson.getThingsToSay();
            thingsToSay[0] = "Hello";
            am.setText(thingsToSay[0]);
            talkingPerson = null;
        }
        am.update();
    }

    public void showShop(){
        shop.setVisible();
    }

    private void render() {
        canvas.getGraphicsContext2D().clearRect(0,0,canvas.getWidth(),canvas.getHeight());
        grid.draw();
    }

    public void toggleStatsMenu(){
        if(content.getChildren().contains(areaMenu)){
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
    }
    public void play(){
        gameLoop.play();
    }
    public void stop(){
        gameLoop.stop();
    }

    public void loadGame(File file)
    {
        Loader loader = new XmlLoader(file);

        this.game = loader.loadGame();
    }

    public void loadGame(Character avatar)
    {
        Loader loader = new XmlLoader(new File("default.xml"));

        this.game = loader.loadGame(avatar);
    }

    public void saveGame(File file)
    {
        Saver saver = new XmlSaver(file);

        saver.saveGame(game);
    }
}