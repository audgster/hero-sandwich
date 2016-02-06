package controllers;
import models.entities.Entity;
import models.gameengine.interfaces.IGameEngine;
import models.menus.*;
import util.Direction;
import util.Game;

public  class AvatarState extends ControllerState{
	public String getName(){
		return "Avatar";
	}

    Game game;

    public AvatarState(Game game)
    {
        this.game = game;
    }

	public void north()
    {
        triggerMotion(Direction.NORTH);
	}

	public void northEast()
    {
        triggerMotion(Direction.NORTHEAST);
	}

	public void east()
    {
        triggerMotion(Direction.EAST);
	}

	public void southEast()
    {
        triggerMotion(Direction.SOUTHEAST);
	}

	public void south()
    {
        triggerMotion(Direction.SOUTH);
	}

	public void southWest()
    {
        triggerMotion(Direction.SOUTHWEST);
	}

	public void west()
    {
        triggerMotion(Direction.WEST);
	}

	public void northWest()
    {
        triggerMotion(Direction.NORTHWEST);
	}

	public void select()
    {
		System.out.println("The pause menu opened");
	}

	public void setMenu(Menus menu){};

    private void triggerMotion(Direction direction)
    {
        if(game.getGameEngine().changeEntityLocation(game.getCurrentLevel(), game.getAvatar(), direction)) {
            System.out.println("The Avatar moved " + direction.toString().toLowerCase());
        }
        else
        {
            System.out.println("The Avatar did not move");
        }
    }
}