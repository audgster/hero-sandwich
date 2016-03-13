package com.herosandwich.controller;

import com.herosandwich.events.CharacterMeleeAttacksEntityEvent;
import com.herosandwich.events.EventDispatcher;
import com.herosandwich.models.entity.Entity;
import com.herosandwich.models.map.Map;
import com.herosandwich.models.entity.Character;
import com.herosandwich.models.map.Tile;
import com.herosandwich.util.*;
import com.herosandwich.controller.KeyBindings;
import javafx.scene.input.KeyCode;

public class Controller {
    private  Character player;
    private  Map map;
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
        if(inputAction != null){
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
                case SKILL1:            basic_attack();
                                        break;
                default:                // key not assigned; do nothing
            }
        }
	}

    public void setCharacter(Character player) {
        this.player = player;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    /** Checks whether there is an Entity adjacent to the player that can be attacked **/
    /** If there is, calls players attack method and fires the CharacterMeleeAttacksEntity event **/
    /** If not, returns false **/
    /* TODO
    * Need to add cooldowns
    * Need to add Attitude mutating (attack and friendly Entity and it turns hostile)
    */
    public boolean basic_attack() {
        boolean success = false;
        /** Test print **/
        System.out.println(player.getName() + " is trying to attack!");
        Tile tile = map.getTile( player.getPosition().getPosInDirection( player.getDirection() ) );
        Entity target = tile.getEntity();
        if ( !(target == null) ) {
            success = true;
            /** Test print **/
            System.out.println(player.getName() + " is facing and adjacent to " + target.getName() + "! Damage attempting to be calculated...");
            CharacterMeleeAttacksEntityEvent attackEvent = new CharacterMeleeAttacksEntityEvent(player, target);
            final EventDispatcher eventDispatcher = EventDispatcher.getInstance();
            eventDispatcher.notify(attackEvent);
        }
        /** Test print **/
        if (!success) { System.out.println("No adjacent enemy! Attack failed."); }
        return success;
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
