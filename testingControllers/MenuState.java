public  class MenuState extends ControllerState{
	public Menu menu = new MainMenu();
	public String getName(){
		return "Menu";
	}

	public void north(){
		System.out.println("The Menu cursor has moved up");
		menu.scrollUp();
	}
	public void northEast(){}
	public void east(){}
	public void southEast(){}
	public void south(){
		System.out.println("The Menu cursor has moved down");
		menu.scrollDown();
	}
	public void southWest(){}
	public void west(){}
	public void northWest(){}
	public void select(){
		System.out.println("The menu opened at the cursor");
		menu.enter();
	}
}