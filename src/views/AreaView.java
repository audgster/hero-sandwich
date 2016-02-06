package views;

import models.entities.Entity;
import models.Level;
import models.map.Tile;
import models.items.*;
import util.*;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.lang.Math;
import javax.swing.*;


public class AreaView extends View {

	private Level level;
	private Entity avatar;
	private HashSet<Position> viewablePositions;
	private static final int tileSize = 64;

	public AreaView() {

	}

	public AreaView(Level level, Entity avatar){
		this.level = level;
		this.avatar = avatar;
	}

	protected void render(){
		Graphics g = getComponentGraphics();
		int x = 0;
		int y = 0;
		BufferedImage tileImg = null;
		BufferedImage avatarImg = null;
		try{
			tileImg = ImageIO.read(new File("../images/groundTile.PNG"));
			avatarImg = ImageIO.read(new File("../images/smasher.gif"));
		}catch(IOException e){System.out.println("Error");}

		//for each tile in viewable area
		for(Position p : viewablePositions){
			if(level.returnTileAt(p) == null){
				continue;
			}
			Tile tile = level.returnTileAt(p);

		}

		for(int i = 0; i < 10; i++){
			y = 64 * i;
			for(int j = 0; j < 10; j++){
				x = 64*j;
				g.drawImage(tileImg,x,y, null);
			}
		}
		g.drawImage(avatarImg,0,0,64,64,null);
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
