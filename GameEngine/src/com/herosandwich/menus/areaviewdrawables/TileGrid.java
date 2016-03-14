package com.herosandwich.menus.areaviewdrawables;

import com.herosandwich.creation.entity.PlayerFactory;
import com.herosandwich.models.entity.Character;
import com.herosandwich.models.entity.Player;
import com.herosandwich.models.map.Map;
import com.herosandwich.models.map.Tile;
import com.herosandwich.util.DirectionHex;
import com.herosandwich.util.PositionHex;
import javafx.scene.canvas.GraphicsContext;

import java.util.*;

public class TileGrid  implements Listener{

    HashMap<PositionHex, DrawableTile> drawableMap = new HashMap<PositionHex, DrawableTile>();
    Double tileScale = 31D;
    Double tileWidth = tileScale*2;
    Double tileHeight = tileScale * Math.sqrt(3D);
    GraphicsContext graphicsContext;
    Set<PositionHex> inViewTilePositions;

    Double screenWidth;
    Double screenHeight;

    boolean searchMode = false;
    Character viewState = null;
    Character lookModeAvatar = new Player();
    Character gamePlayAvatar;
    Map map;

    public TileGrid(Map map, GraphicsContext graphicsContext, Double screenWidth, Double screenHeight) {
        this.map = map;
        this.graphicsContext = graphicsContext;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        initGridWithMap();
    }
    public void updateDimensions(){
        screenHeight = graphicsContext.getCanvas().getHeight();
        screenWidth = graphicsContext.getCanvas().getWidth();
    }

    public void addAvatar(Character avatar) {
        gamePlayAvatar = avatar;
        gamePlayAvatar.addListener(this);
        viewState = gamePlayAvatar;
    }

    public void activateSearchMode() {
        System.out.println("Search Mode Activated!");
        if(searchMode)
            return;
        lookModeAvatar.updatePosition(gamePlayAvatar.getPosition());
        viewState = lookModeAvatar;
        searchMode = true;
    }


    public void scroll(DirectionHex scrollDirection) {
        System.out.println("I am trying to scroll!!!!");
        PositionHex positionHex = new PositionHex(viewState.getPosition().getQ(), viewState.getPosition().getR(), viewState.getPosition().getS());
        viewState.updatePosition(positionHex.getPosInDirection(scrollDirection));
    }
    public void activateGamePlayMode() {
        viewState = gamePlayAvatar;
        searchMode = false;
    }

    public Character getAvatarViewMode() {
        return viewState;
    }

    private void initGridWithMap() {
        //System.out.println("initGridWithMap");
        Collection<Tile> mapTiles = map.getTiles();
        for(Tile tile : mapTiles) {
           // System.out.println("adding drawableTiles");
            DrawableTile drawableTile = new DrawableTile(tile);
            drawableMap.put(tile.getPosition(), drawableTile);
        }
    }


    /***********************************************************************************************************/
    // For testing!!!!

    public void makeAllTileVisible() {
       // System.out.println("makeAllTileVisible");
        for(DrawableTile tile : drawableMap.values())
            tile.makeVisible();
    }
    /***********************************************************************************************************/
    //TODO need avatar position
    public void update() {

        if(searchMode) {
               System.out.println("Search Mode!!!!!!");
            return;
        }

        makePreviousInViewTilesNotVisible();

        inViewTilePositions = map.drawCircle(gamePlayAvatar.getPosition(), 3, true).keySet();
        for(PositionHex position : inViewTilePositions) {
            //System.out.println("Q: " + position.getQ() + " R: " + position.getR()+  " S: " + position.getS());
            DrawableTile drawableTile = drawableMap.get(position);
            drawableTile.makeVisible();
            drawableTile.update();
        }
    }

    public void setTileAsDiscovered(PositionHex positionHex) {
        DrawableTile tile = drawableMap.get(positionHex);
        tile.makeNotVisible();
    }

    private void makePreviousInViewTilesNotVisible() {

        if(inViewTilePositions == null)
            return;

        for(PositionHex position : inViewTilePositions) {
            DrawableTile tile = drawableMap.get(position);
            tile.makeNotVisible();
        }
    }

    public void draw() {
        //System.out.println("draw");
        updateDimensions();
        for(PositionHex position : drawableMap.keySet()) {
            //System.out.println("draw0.2");
            drawableMap.get(position).draw(graphicsContext, hexToCanvasPoint(position));
        }
    }

    private Double getImageCornerX(Double x)
    {
        return x - tileScale;
    }

    private Double getImageCornerY(Double y)
    {
        return y - (Math.sqrt(3)/2) * tileScale;
    }

    public CanvasPoint hexToCanvasPoint(PositionHex point)
    {
        /*
        * Calculations are based in difference between Q, R of
        * new point (point) and current center point (viewState.getPosition())
        * */
        int qDiff = point.getQ() - viewState.getPosition().getQ();
        int rDiff = point.getR() - viewState.getPosition().getR();

        Double dx = ((3/2) * qDiff * tileScale) + (0 * rDiff * tileScale);
        Double dy = ((Math.sqrt(3)/2) * qDiff * tileScale) + (Math.sqrt(3) * rDiff * tileScale);

        /*
        * Center of the center tile is located at (screenWidth/2, screenHeight/2)
        * This calculates center of destination hex
        *
        * Also here be dragons in the form of 3 *  and 2 *
        * */
        Double x_center = (screenWidth/2) + (3 * dx);
        Double y_center = (screenHeight/2) + (2 * dy);

        /*
        * Top corner calculated by:
        * 1. subtracting tileScale from x where tile scale is the distance from the center
        * to the left or right
        *
        * 2. subtracting sqrt(3)/2 * tilescale from y where sqrt(3)/2 * tilescale is the distance
        * from the center to the top or bottom
        *
        * */
        Double x_corner = getImageCornerX(x_center);
        Double y_corner = getImageCornerY(y_center);

        return new CanvasPoint(x_corner, y_corner);
    }
}
