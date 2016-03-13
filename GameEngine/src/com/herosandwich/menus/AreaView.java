package com.herosandwich.menus;


import com.herosandwich.controller.Controller;
import com.herosandwich.menus.areaviewdrawables.TileGrid;
import com.herosandwich.models.map.Map;
import com.herosandwich.models.map.Tile;
import com.herosandwich.util.PositionHex;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
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

    public AreaView(double width, double height){
        WIDTH = width;
        HEIGHT = height;
        content = new Pane();
        gameLoop = new Timeline();
    }

    @Override
    public void createMenu(Pane root) {

        Collection<Tile> tiles = new ArrayList<Tile>();
        PositionHex positionHex = new PositionHex(0,0);
            tiles.add(new Tile(positionHex, Tile.Terrain.GRASS));

        Collection<PositionHex> neighbors = positionHex.getNeighbors();

        for(PositionHex position : neighbors) {
            tiles.add(new Tile(position, Tile.Terrain.GRASS));
            Collection<PositionHex> others = position.getNeighbors();
            for(PositionHex nextPosition : others) {
                tiles.add(new Tile(nextPosition, Tile.Terrain.GRASS));
            }
        }
        tiles.add(new Tile(new PositionHex(2,-2), Tile.Terrain.GRASS));

        Map map = new Map(20);
        map.initialize(tiles);
        Canvas canvas = new Canvas(WIDTH,HEIGHT);
        canvas.getGraphicsContext2D().setFill(Color.BLACK);
        canvas.getGraphicsContext2D().fillRect(0,0,WIDTH,HEIGHT);
        grid =  map.initMyDrawable(canvas);
        grid.makeAllTileVisible();
        grid.setTileAsDiscovered(new PositionHex(0,0));
        //grid.draw();
        root.getChildren().add(canvas);
        gameLoop();

        // Set key press event listener for Controller
        Controller controller = Controller.getController();
        content.setOnKeyPressed(new EventHandler<KeyEvent>() {
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
                    System.out.println("The Game is Running");
                   render();
                }
        );

        gameLoop.getKeyFrames().add( kf );
        gameLoop.play();
    }

    private void render() {
        grid.draw();
    }
}

//
//static int frame = 0;
//private ImagePattern land = new ImagePattern(new Image("com/herosandwich/menus/land6.jpg"));
//private Pane areaView;
//private Group content;
//
//@Override
//public void createMenu(Pane display){
//        content = new Group();
//        content.setFocusTraversable(true);
//
//        Rectangle bg = new Rectangle(1200,800, Color.BLACK);
//        content.getChildren().add(bg);
//        new HexagonGrid(300,10,content);
//
//        areaView = display;
//        areaView.getChildren().add(content);
//
//        //PauseMenu pm = new PauseMenu();
//        //  pm.createMenu(areaView);
//        }

//private class HexagonGrid {
//    List<Hexagon> grid = new ArrayList<Hexagon>();
//    Double hexHeight = 30*Math.sqrt(3D);
//
//    public HexagonGrid(int height, int width, Group root) {
//        setGrid(height, width, root);
//    }
//
//    private void setGrid(int height, int width, Group root) {
//        for(int row = 0; row < height; row++) {
//            for(int column = 0; column < 600/30; column++){
//                if(column%2 == 0 && row%2 == 0) {
//                    Hexagon hexagon = new Hexagon(60D + 90D*column, 60D + hexHeight*row, 60D);
//                    hexagon.setFill(land);
//                    hexagon.setStroke(Color.BLACK);
//                    hexagon.setOnMouseEnteredEvent();
//                    hexagon.setOnMouseExitEvent();
//                    root.getChildren().add(hexagon);
//                    grid.add(hexagon);
//                }
//                else if (column%2 == 0 && row%2 == 1) {
//                    Hexagon hexagon = new Hexagon(150D + 90D*column, 60D + hexHeight*row, 60D);
//                    hexagon.setFill(land);
//                    hexagon.setStroke(Color.BLACK);
//                    hexagon.setOnMouseEnteredEvent();
//                    hexagon.setOnMouseExitEvent();;
//                    root.getChildren().add(hexagon);
//                    grid.add(hexagon);
//                }
//            }
//        }
//
////            for(int i = 0; i < ; i++) {
////                super.getPoints().addAll(xCenter + sideLength*Math.cos(i*2*Math.PI/6), yCenter + sideLength*Math.sin(i*2*Math.PI/6));
////
////            }
//
//    }
//
//
//}
//
//private class Hexagon extends Polygon {
//    int sides = 6;
//
//    public Hexagon(Double xCenter, Double yCenter, Double sideLength) {
//        setVertices(xCenter, yCenter, sideLength);
//    }
//
//    private void setVertices(Double xCenter, Double yCenter, Double sideLength) {
//        for(int i = 0; i < sides; i++) {
//            super.getPoints().addAll(xCenter + sideLength*Math.cos(i*2*Math.PI/sides), yCenter + sideLength*Math.sin(i*2*Math.PI/sides));
//        }
//
//    }
//
//    private void setOnMouseEnteredEvent() {
//        super.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                temp();
//            }
//        });
//    }
//
//    private void setOnMouseExitEvent() {
//        super.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                temp2();
//            }
//        });
//    }
//
//    private void temp() {
//
//        super.setFill(land);
////            super.setStroke(Color.RED);
//    }
//
//    private void temp2() {
//        super.setFill(Color.AQUAMARINE);
//        super.setStroke(Color.BLACK);
//    }
//}








//import javafx.scene.canvas.Canvas;
//import javafx.scene.layout.Pane;
//import javafx.stage.Stage;
//
//
//
//
//public class AreaView implements Runnable, Menu {
//	private String frameRate="";
//	private boolean running;
//	private int tickCount = 0;
//
//	private Pane areaView;
//	private Canvas content;
//	public AreaView(){}
//
//	@Override
//	public void createMenu(Pane root) {
//
//		final Canvas canvas = new Canvas(1200,800);
//		GraphicsContext gc = canvas.getGraphicsContext2D();
//
//		gc.setFill(Color.BLUE);
//		gc.fillRect(75,75,100,100);
//
//		root.getChildren().add(canvas);
//	}
//
//	public void createScene(Stage primaryStage){
//		start();
//	}
//	public synchronized void start(){
//		running = true;
//		new Thread(this).start();
//	}
//	public synchronized void stop(){
//		running = false;
//	}
//	private void render(){
//	}
//	private void tick(){
//		tickCount++;
//	}
//	public void run(){
//		long lastTime = System.nanoTime();
//		double nsPerTick = 1000000000D/60D; //how many ticks per second
//
//		int ticks = 0;
//		int frames = 0;
//
//		long lastTimer = System.currentTimeMillis();
//		double delta = 0;
//		while(running){
//			long now = System.nanoTime();
//			delta += (now - lastTime)/nsPerTick;
//			lastTime = now;
//
//			boolean shouldRender= false;
//			while(delta >= 1){
//				ticks++;
//				tick();
//				delta -= 1;
//				shouldRender = true;
//			}
//			if(shouldRender){
//				frames++;
//				render();
//			}
//
//			if(System.currentTimeMillis()-lastTimer >= 1000){
//				lastTimer += 1000;
//				frameRate = frames + " fps";
//				frames = 0;
//				ticks = 0;
//				System.out.println(frameRate);
//
//			}
//		}
//	}
//}
