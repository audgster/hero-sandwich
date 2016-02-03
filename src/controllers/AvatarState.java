package controllers;
import models.menus.*;

public  class AvatarState extends ControllerState{
	public String getName(){
		return "Avatar";
	}

	public void north(){
		System.out.println("The Avatar moved north");
	}
	public void northEast(){
		System.out.println("The Avatar moved northEast");
	}
	public void east(){
		System.out.println("The Avatar moved east");
	}
	public void southEast(){
		System.out.println("The Avatar moved southEast");
	}
	public void south(){
		System.out.println("The Avatar moved south");
	}
	public void southWest(){
		System.out.println("The Avatar moved southWest");
	}
	public void west(){
		System.out.println("The Avatar moved west");
	}
	public void northWest(){
		System.out.println("The Avatar moved northWest");
	}
	public void select(){
		System.out.println("The pause menu opened");
	}
	public void setMenu(Menu menu){};
}