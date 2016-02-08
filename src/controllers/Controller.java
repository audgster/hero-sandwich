package controllers;

import models.gameengine.HardCodedGameEngineInitializer;
import models.gameengine.interfaces.IGameEngine;
import models.entities.Entity;
import models.menus.*;
import util.Direction;
import util.Game;
import views.*;


public class Controller{
	public ControllerState state;
	private Menus menu;
    private Game game;
    private ViewManager vm;

	public Controller()
    {
		state = new MenuState(this);
        game = new Game(new HardCodedGameEngineInitializer());
	}

	public void setGame(Game game)
    {
        this.game = game;
        state = new AvatarState(this);
    }
    public Game getGame(){
    	return game;
    }
	
	public void setMenu(Menus menu){
		this.menu = menu;
	}
	public Menus getMenu(){
		return menu;
	}

	public void setViewManager(ViewManager vm){
		this.vm = vm;
	}
	public ViewManager getViewManager(){
		return vm;
	}

	public void executeUserInput(char input){
		int newInput =  (int) input - 48;
		switch(newInput){
			case 1: state.southWest();
					break;
			case 2: state.south();
					break;
			case 3: state.southEast();
					break;
			case 4: state.west();
					break;
			case 5: state.enter();
					break;
			case 6:	state.east();
					break;
			case 7: state.northWest();
					break;
			case 8: state.north();
					break;
			case 9: state.northEast();
					break;
			default: break;
		}
	}

	public void changeState(){
		if(state.toString() == "Avatar"){
			state = new MenuState(this);
		}
		else{
			state = new AvatarState(this);
		}
	}

	public void triggerMotion(Direction direction)
    {
        if(game.getGameEngine().changeEntityLocation(game.getCurrentLevel(), game.getAvatar(), direction)) {
            System.out.println("The Avatar moved " + direction.toString().toLowerCase());
            System.out.println("After movement, position is: " +
                    game.getCurrentLevel().returnCurrentPosition(game.getAvatar()).toString());
        }
        else
        {
            System.out.println("The Avatar did not move");
        }
    }
    public void openPauseMenu(){
    	changeState();
    	menu = new PauseMenu(vm);
    	vm.setPauseMode(menu);
    	menu.setController(this);
    }

    public void scrollUp(){
    	menu.scrollUp();
    }
    public void scrollDown(){
    	menu.scrollDown();
    }
    public void enter(){
    	menu.enter();
    }
}
