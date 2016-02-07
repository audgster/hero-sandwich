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
		level.addListener(this);
		this.avatar = avatar;
		viewablePositions = new HashSet<Position>();
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0,0,getWidth(), getHeight());
		g.setColor(Color.WHITE);
		g.drawRect(0,0,getWidth(), getHeight());
		//I know the AreaView can get its location here
		update2();


		//render the Tiles, AoEs, and Items
		for(Position p : viewablePositions){
			//System.out.println("[AREAVIEW] ihave some mothafuking positions");
			if(level.returnTileAt(p) == null){
				continue;
			}
			
			Tile tile = level.returnTileAt(p);
			BufferedImage tileImage = null;
			try{
				//System.out.println("[AREAVIEW] it found the tile images");
				tileImage = ImageIO.read(new File(
						spriteMap.getResourcePath(tile.getImageId())));
			}
			catch(IOException e){
				//throw e;
				System.out.println("[AREAVIEW] cannot find tile images");
				break;
			}
			catch(Exception e){
				//throw e;
				System.out.println("[AREAVIEW] sprite error");
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
					System.out.println("[AREAVIEW] cannot find aoe images");
					break;
				}
				catch(Exception e){
					//throw e;
					System.out.println("[AREAVIEW] aoe error");
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




		BufferedImage entityImage = null;
		try{
			entityImage = ImageIO.read(new File(
					spriteMap.getResourcePath(avatar.getImageId())));
			System.out.println("[AREAVIEW] FOUND THE AVATAR");
		}
		catch(IOException e){
			//throw e;
			System.out.println("[AREAVIEW] cannot find AVATAR images");
			
		}
		catch(Exception e){
			//throw e;
			e.printStackTrace();
			
		}
		Position p = level.returnCurrentPosition(avatar);
		int x = tileSize * (p.getX() - topLeftX);
		int y = tileSize * (p.getY() - topLeftY);
		g.drawImage(entityImage, x, y, null);
		
		/*
		******************DON'T DELETE THIS FFS***************************
		System.out.println("BOUT TO CHECK THE ENTITIES");
		Collection<Position> tempPos = new HashSet<Position>();
		tempPos.add(new Position(5,5));
		//render the Entities
		Collection<Entity> entitySet = level.getAllEntitiesIn(viewablePositions);
		System.out.println("amount of entities on the level " + entitySet.size());
		System.out.println(level.toString());
		for(Entity entity: entitySet){
			System.out.println("CHECKING THE ENTITIES");
			BufferedImage entityImage = null;
			try{
				System.out.println("FOUND THE AVATAR");
				entityImage = ImageIO.read(new File(
						spriteMap.getResourcePath(entity.getImageId())));
			}
			catch(IOException e){
				//throw e;
				System.out.println("cannot find AVATAR images");
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
			
		}*/
		
	}
	
	protected void render(){
		
		revalidate();
		repaint();
		
	}

	public void update(){
		/*
		Position avatarPosition = level.returnCurrentPosition(avatar);
		//find the viewable area centred on avatar
		int numTilesWide = (int) Math.ceil(1.0 * getWidth() / tileSize);
		int numTilesHigh = (int) Math.ceil(1.0 * getHeight() / tileSize);
		numTilesWide = 5 ;
		numTilesHigh = 5 ;
		//System.out.println("Is Avatar Position null? " + (avatarPosition == null));
		System.out.println("areaView.getWidth() " + getWidth());
		System.out.println("areaView.getHeight() " + getHeight());
		//find the top-left tile position
		topLeftX = avatarPosition.getX() - (numTilesWide / 2);
		topLeftY = avatarPosition.getY() - (numTilesHigh / 2);

		viewablePositions = new HashSet<Position>();
		for(int i = 0; i < numTilesWide; i++){
			for(int j = 0; j < numTilesHigh; j++){
				viewablePositions.add(new Position(topLeftX + i, topLeftY + j));
			}
		}
		*/
		render();

	}

	private void update2(){

		Position avatarPosition = level.returnCurrentPosition(avatar);
		//find the viewable area centred on avatar
		int numTilesWide = (int) Math.ceil(1.0 * getWidth() / tileSize);
		int numTilesHigh = (int) Math.ceil(1.0 * getHeight() / tileSize);
		//numTilesWide = 5 ;
		//numTilesHigh = 5 ;
		//System.out.println("Is Avatar Position null? " + (avatarPosition == null));
		System.out.println("areaView.getWidth() " + getWidth());
		System.out.println("areaView.getHeight() " + getHeight());
		//find the top-left tile position
		topLeftX = avatarPosition.getX() - (numTilesWide / 2);
		topLeftY = avatarPosition.getY() - (numTilesHigh / 2);

		viewablePositions = new HashSet<Position>();
		for(int i = 0; i < numTilesWide; i++){
			for(int j = 0; j < numTilesHigh; j++){
				viewablePositions.add(new Position(topLeftX + i, topLeftY + j));
			}
		}

	}

}