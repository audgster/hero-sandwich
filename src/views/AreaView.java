package views;

import models.Entity.Entity;
import models.Level;
import views.View;

public class AreaView extends View {
	
	private Level level;
	private Entity avatar;
	
	public AreaView(Level level, Entity avatar){
		this.level = level;
		this.avatar = avatar;
	}
	
	public void render(){
		//find the viewable area centred on avatar
		//for each tile in viewable area
			//
	}
	
}