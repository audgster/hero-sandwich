package views;

import models.entities.Entity;
import models.Level;

public class AreaView extends View {
	
	private Level level;
	private Entity avatar;
	
	public AreaView(Level level, Entity avatar){
		this.level = level;
		this.avatar = avatar;
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