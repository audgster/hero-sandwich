package controllers;

public  class MenuState extends ControllerState{
	Controller controller;
	public MenuState(Controller controller){
		this.controller = controller;
	}

	public void north(){
		System.out.println(toString() + " went up");
		controller.scrollUp();
	}
	public void northEast(){}
	public void east(){}
	public void southEast(){}
	public void south(){
		System.out.println(toString() + " went down");
		controller.scrollDown();
	}
	public void southWest(){}
	public void west(){}
	public void northWest(){}
	public void enter(){
		controller.enter();
	}

	public String toString(){
		return "Menu";
	}
}