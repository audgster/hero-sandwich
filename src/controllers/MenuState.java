package controller;
import menu.*;

public  class MenuState extends ControllerState{
	private Menu menu;
	public String getName(){
		return "Menu";
	}

	public void north(){
		menu.scrollUp();
	}
	public void northEast(){}
	public void east(){}
	public void southEast(){}
	public void south(){
		menu.scrollDown();
	}
	public void southWest(){}
	public void west(){}
	public void northWest(){}
	public void select(){
		menu.enter();
	}
	public void setMenu(Menu menu){
		this.menu = menu;
	}
}