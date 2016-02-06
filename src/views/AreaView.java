package views;

import models.entities.Entity;
import models.Level;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class AreaView extends View {

	private Level level;
	private Entity avatar;

public AreaView() {

}

	public AreaView(Level level, Entity avatar){
		this.level = level;
		this.avatar = avatar;
	}

	public void paintComponent(Graphics g) {
		int x = 0;
		int y = 0;
		BufferedImage tileImg = null;
		BufferedImage avatarImg = null;
		try{
			tileImg = ImageIO.read(new File("../images/groundTile.PNG"));
			avatarImg = ImageIO.read(new File("../images/smasher.gif"));
		}catch(IOException e){System.out.println("Error");}

		for(int i = 0; i < 10; i++){
			y = 64 * i;
			for(int j = 0; j < 10; j++){
				x = 64*j;
				g.drawImage(tileImg,x,y, null);
			}
		}
		g.drawImage(avatarImg,0,0,64,64,null);
	}

	protected void render(){
		//find the viewable area centred on avatar
		//for each tile in viewable area
			//get info
			//draw it
	}

	public void update(){

	}

}
