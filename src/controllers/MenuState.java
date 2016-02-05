package controllers;
import models.menus.*;

public  class MenuState extends ControllerState{
	private Menus menu;
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
		System.out.println("State");
		menu.enter();
	}
	public void setMenu(Menus menu){
		this.menu = menu;
	}
}
