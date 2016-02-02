
public  class MenuState extends ControllerState{
	public String getName(){
		return "Menu";
	}

	public void north(){
		System.out.println("The Menu cursor has moved up");
	}
	public void northEast(){}
	public void east(){}
	public void southEast(){}
	public void south(){
		System.out.println("The Menu cursor has moved down");
	}
	public void southWest(){}
	public void west(){}
	public void northWest(){}
	public void select(){
		System.out.println("The menu opened at the cursor");
	}
}