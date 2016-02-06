package views;

import models.entities.Entity;
import models.Level;
import models.map.Tile;
import util.*;
import java.awt.*;
import java.lang.Math;

public class AreaView extends View {
	
	private Level level;
	private Entity avatar;
	private HashSet<Position> viewablePositions;
	private static final int tileSize = 64;
	
	public AreaView(Level level, Entity avatar){
		this.level = level;
		this.avatar = avatar;
	}
	
	protected void render(){
		Graphics g = getComponentGraphics();
		//for each tile in viewable area
		for(Position p : viewablePositions){
			if(level.returnTileAt(p) == null){
				continue;
			}
			Tile tile = level.returnTileAt(p);
			
		}
		//use Aud's DoubleHashMap thingy to get the entities
	}
	
	public void update(){
	
		Position avatarPosition = level.returnCurrentPosition(avatar);
		//find the viewable area centred on avatar
		int numTilesWide = (int) Math.ceil(1.0 * getWidth() / tilesize);
		int numTilesHigh = (int) Math.ceil(1.0 * getHeight() / tilesize);
		
		//find the top-left tile position
		int topLeftX = avatarPosition.getX() - (numTilesWide / 2);
		int topLeftY = avatarPosition.getY() - (numTilesHigh / 2);
		
		viewablePositions = new HashSet<Position>();
		for(int i = 0; i < numTilesWide; i++){
			for(int j = 0; j < numTilesHigh; j++){
				viewablePositions.add(new Position(topLeftX + i, topLeftY + j));
			}
		}
		
		render();
		
	}
	
}