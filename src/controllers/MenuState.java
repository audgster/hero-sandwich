package controllers;
import models.menus.*;

public  class MenuState extends ControllerState{
	private Menus menu;
	public String getName(){
		return "Menu";
	}

	public void north(){
		System.out.println(getName() + " went up");
		menu.scrollUp();
	}
	public void northEast(){}
	public void east(){}
	public void southEast(){}
	public void south(){
		System.out.println(getName() + " went down");
		menu.scrollDown();
	}
	public void southWest(){}
	public void west(){}
	public void northWest(){}
	public void select(){
		menu.enter();
	}
	public void setMenu(Menus newMenu){
		this.menu = newMenu;

	}
}