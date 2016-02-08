package controllers;

import util.Direction;

public  class AvatarState extends ControllerState{
	Controller controller;

    public String toString(){
		return "Avatar";
	}

    public AvatarState(Controller controller)
    {
        this.controller = controller;
    }

	public void north()
    {
        System.out.println("The avatar moved N");
        controller.triggerMotion(Direction.NORTH);
	}

	public void northEast()
    {
        System.out.println("The avatar moved NE");
        controller.triggerMotion(Direction.NORTHEAST);
	}

	public void east()
    {
        System.out.println("The avatar moved E");
        controller.triggerMotion(Direction.EAST);
	}

	public void southEast()
    {
        System.out.println("The avatar moved SE");
        controller.triggerMotion(Direction.SOUTHEAST);
	}

	public void south()
    {
        System.out.println("The avatar moved S");
        controller.triggerMotion(Direction.SOUTH);
	}

	public void southWest()
    {
        System.out.println("The avatar moved SW");
        controller.triggerMotion(Direction.SOUTHWEST);
	}

	public void west()
    {
        System.out.println("The avatar moved W");
        controller.triggerMotion(Direction.WEST);
	}

	public void northWest()
    {
        System.out.println("The avatar moved NW");
        controller.triggerMotion(Direction.NORTHWEST);
	}

	public void enter()
    {
		System.out.println("The pause menu opened");
        controller.openPauseMenu();
        
	}
}