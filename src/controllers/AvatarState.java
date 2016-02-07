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
        System.out.println("The avatar moved N");
        triggerMotion(Direction.NORTH);
	}

	public void northEast()
    {
        System.out.println("The avatar moved NE");
        triggerMotion(Direction.NORTHEAST);
	}

	public void east()
    {
        System.out.println("The avatar moved E");
        triggerMotion(Direction.EAST);
	}

	public void southEast()
    {
        System.out.println("The avatar moved SE");
        triggerMotion(Direction.SOUTHEAST);
	}

	public void south()
    {
        System.out.println("The avatar moved S");
        triggerMotion(Direction.SOUTH);
	}

	public void southWest()
    {
        System.out.println("The avatar moved SW");
        triggerMotion(Direction.SOUTHWEST);
	}

	public void west()
    {
        System.out.println("The avatar moved W");
        triggerMotion(Direction.WEST);
	}

	public void northWest()
    {
        System.out.println("The avatar moved NW");
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