package com.herosandwich.controller;

import com.herosandwich.models.map.Map;
import com.herosandwich.models.entity.Character;
import com.herosandwich.util.*;
import com.herosandwich.controller.KeyBindings;
import javafx.scene.input.KeyCode;

public class Controller {
    private Character player;
    private Map map;
    private KeyBindings keyBindings = new KeyBindings();
    private static Controller controller = null;

	public static Controller getController() {
    	if(controller == null){
    		controller = new Controller();
    	}
    	return controller;

	}

	// Private constructor for Singleton pattern
	private Controller() {}


	public void executeUserInput(KeyCode input){
		// get correct enum from HashMap<KeyCode, Action>
		Action inputAction = keyBindings.getAction(input);

		switch (inputAction) {
            case MOVE_NORTH:        player.move(DirectionHex.NORTH, map);
                                    break;
            case MOVE_NORTH_EAST:   player.move(DirectionHex.NORTH_EAST, map);
                                    break;
            case MOVE_SOUTH_EAST:   player.move(DirectionHex.SOUTH_EAST, map);
                                    break;
            case MOVE_SOUTH:        player.move(DirectionHex.SOUTH, map);
                                    break;
            case MOVE_SOUTH_WEST:   player.move(DirectionHex.SOUTH_WEST, map);
                                    break;
            case MOVE_NORTH_WEST:   player.move(DirectionHex.NORTH_WEST, map);
                                    break;
            default:                // key not assigned; do nothing
        }
	}

    public void setCharacter(Character player) {
        this.player = player;
    }

    public void setMap(Map map) {
        this.map = map;
    }


//	public void triggerMotion(Direction direction)
//    {
//        if(game.getGameEngine().changeEntityLocation(game.getCurrentLevel(), game.getAvatar(), direction)) {
//            System.out.println("The Avatar moved " + direction.toString().toLowerCase());
//            System.out.println("After movement, position is: " +
//                    game.getCurrentLevel().returnCurrentPosition(game.getAvatar()).toString());
//        }
//        else
//        {
//            System.out.println("The Avatar did not move");
//        }
//    }
//
//    public void scrollUp(){
//    	menu.scrollUp();
//    }
//    public void scrollDown(){
//    	menu.scrollDown();
//    }
//    public void enter(){
//    	menu.enter();
//    }
}
