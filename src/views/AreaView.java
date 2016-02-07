package views;

import models.entities.Entity;
import models.Level;
import models.map.Tile;
import models.map.areaofeffect.*;
import models.items.*;
import util.*;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.lang.Exception;
import java.util.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import java.lang.Math;
import javax.swing.*;


public class AreaView extends View {

	private Level level;
	private Entity avatar;
	private Collection<Position> viewablePositions;
	private int topLeftX;
	private int topLeftY;
	private static final int tileSize = 64;
	private SpriteMap spriteMap = new SpriteMap(new HardCodedSpriteInitializer());

	public AreaView(Level level, Entity avatar){
		this.level = level;
		this.avatar = avatar;
		viewablePositions = new HashSet<Position>();
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0,0,getWidth(), getHeight());
		
		//render the Tiles, AoEs, and Items
		for(Position p : viewablePositions){
			
			if(level.returnTileAt(p) == null){
				continue;
			}
			
			Tile tile = level.returnTileAt(p);
			BufferedImage tileImage = null;
			try{
				tileImage = ImageIO.read(new File(
						spriteMap.getResourcePath(tile.getImageId())));
			}
			catch(IOException e){
				//throw e;
				break;
			}
			catch(Exception e){
				//throw e;
				e.printStackTrace();
				break;
			}
			int x = tileSize * (p.getX() - topLeftX);
			int y = tileSize * (p.getY() - topLeftY);
			g.drawImage(tileImage, x, y, null);
			
			Collection<AreaOfEffect> aoeSet = tile.getAllAoE();
			for(AreaOfEffect aoe: aoeSet){
				
				BufferedImage aoeImage = null;
				try{
					aoeImage = ImageIO.read(new File(
							spriteMap.getResourcePath(aoe.getImageId())));
				}
				catch(IOException e){
					//throw e;
					break;
				}
				catch(Exception e){
					//throw e;
					e.printStackTrace();
					break;
				}
				g.drawImage(aoeImage, x, y, null);
				
			}
			
			Collection<Item> itemSet = tile.getAllItems();
			for(Item item: itemSet){
				
				BufferedImage itemImage = null;
				try{
					itemImage = ImageIO.read(new File(
							spriteMap.getResourcePath(item.getImageId())));
				}
				catch(IOException e){
					//throw e;
					break;
				}
				catch(Exception e){
					//throw e;
					e.printStackTrace();
					break;
				}
				g.drawImage(itemImage, x, y, null);
				
			}
			
		}
		
		//render the Entities
		Collection<Entity> entitySet = level.getAllEntitiesIn(viewablePositions);
		for(Entity entity: entitySet){
			
			BufferedImage entityImage = null;
			try{
				entityImage = ImageIO.read(new File(
						spriteMap.getResourcePath(entity.getImageId())));
			}
			catch(IOException e){
				//throw e;
				break;
			}
			catch(Exception e){
				//throw e;
				e.printStackTrace();
				break;
			}
			Position p = level.returnCurrentPosition(entity);
			int x = tileSize * (p.getX() - topLeftX);
			int y = tileSize * (p.getY() - topLeftY);
			g.drawImage(entityImage, x, y, null);
			
		}
		
	}
	
	protected void render(){
		
		repaint();
		//Graphics g = getComponentGraphics();
		
		/*
		int x = 0;
		int y = 0;
		BufferedImage tileImg = null;
		BufferedImage avatarImg = null;
		try{
			tileImg = ImageIO.read(new File("../images/groundTile.PNG"));
			avatarImg = ImageIO.read(new File("../images/smasher.gif"));
		}catch(IOException e){System.out.println("Error");}
		*/
		
		//for each tile in viewable area
		/*
		for(Position p : viewablePositions){
			if(level.returnTileAt(p) == null){
				continue;
			}
			Tile tile = level.returnTileAt(p);

		}
		*/
		/*
		for(int i = 0; i < 10; i++){
			y = 64 * i;
			for(int j = 0; j < 10; j++){
				x = 64*j;
				g.drawImage(tileImg,x,y, null);
			}
		}
		g.drawImage(avatarImg,0,0,64,64,null);
		*/
		//use Aud's DoubleHashMap thingy to get the entities
		
	}

	public void update(){

		Position avatarPosition = level.returnCurrentPosition(avatar);
		//find the viewable area centred on avatar
		int numTilesWide = (int) Math.ceil(1.0 * getWidth() / tileSize);
		int numTilesHigh = (int) Math.ceil(1.0 * getHeight() / tileSize);


		System.out.println("Is Avatar Position null? " + (avatarPosition == null));
		//find the top-left tile position
		topLeftX = avatarPosition.getX() - (numTilesWide / 2);
		topLeftY = avatarPosition.getY() - (numTilesHigh / 2);

		viewablePositions = new HashSet<Position>();
		for(int i = 0; i < numTilesWide; i++){
			for(int j = 0; j < numTilesHigh; j++){
				viewablePositions.add(new Position(topLeftX + i, topLeftY + j));
			}
		}

		render();

	}

}