package com.herosandwich.controller;

import com.herosandwich.events.CharacterMeleeAttacksEntityEvent;
import com.herosandwich.events.EventDispatcher;
import com.herosandwich.menus.AreaView;
import com.herosandwich.menus.areaviewdrawables.TileGrid;
import com.herosandwich.models.entity.Entity;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.WeaponType;
import com.herosandwich.models.map.Map;
import com.herosandwich.models.entity.Character;
import com.herosandwich.models.map.Tile;
import com.herosandwich.util.*;
import javafx.scene.input.KeyCode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.*;

public class Controller {
    private  Character player;
    private com.herosandwich.models.map.Map map;
    private KeyBindings keyBindings = new KeyBindings();
    private static Controller controller = null;
    private boolean searchMode = false;
    private AreaView areaView;

	public static Controller getController() {
    	if(controller == null){
    		controller = new Controller();
    	}
    	return controller;
	}

	// Private constructor for Singleton pattern
	private Controller() {}


	public void executeUserInput(KeyCode input){
        areaView.updateStatsMenu();
        if(input == KeyCode.ESCAPE){
            areaView.doPauseTransition();
        }



		// get correct enum from HashMap<KeyCode, Action>
		Action inputAction = keyBindings.getAction(input);
        if(inputAction != null){
            switch (inputAction) {
                case MOVE_NORTH:        gridView.activateGamePlayMode();
                                        player.move(DirectionHex.NORTH, map);
                                        break;
                case MOVE_NORTH_EAST:   gridView.activateGamePlayMode();
                                        player.move(DirectionHex.NORTH_EAST, map);
                                        break;
                case MOVE_SOUTH_EAST:   gridView.activateGamePlayMode();
                                        player.move(DirectionHex.SOUTH_EAST, map);
                                        break;
                case MOVE_SOUTH:        gridView.activateGamePlayMode();
                                        player.move(DirectionHex.SOUTH, map);
                                        break;
                case MOVE_SOUTH_WEST:   gridView.activateGamePlayMode();
                                        player.move(DirectionHex.SOUTH_WEST, map);
                                        break;
                case MOVE_NORTH_WEST:   gridView.activateGamePlayMode();
                                        player.move(DirectionHex.NORTH_WEST, map);
                                        break;
                case ATTACK:            basic_attack();
                                        break;
                case BIND_WONDS:        bind_wounds();
                                        break;
                case BARGAIN:           bargain();
                                        break;
                case OBSERVATION:       observation();
                                        break;
                case SEARCH_MOVE_NORTH:
                                        gridView.activateSearchMode();
                                        gridView.scroll(DirectionHex.NORTH);
                                        break;

                case SEARCH_MOVE_NORTH_EAST:
                                            gridView.activateSearchMode();
                                            gridView.scroll(DirectionHex.NORTH_EAST);
                                            break;

                case SEARCH_MOVE_SOUTH_EAST:
                                            gridView.activateSearchMode();
                                            gridView.scroll(DirectionHex.SOUTH_EAST);
                                            break;
                case SEARCH_MOVE_SOUTH:
                                            gridView.activateSearchMode();
                                            gridView.scroll(DirectionHex.SOUTH);
                                            break;
                case SEARCH_MOVE_SOUTH_WEST:
                                            gridView.activateSearchMode();
                                            gridView.scroll(DirectionHex.SOUTH_WEST);
                                            break;

                case SEARCH_MOVE_NORTH_WEST:
                                            gridView.activateSearchMode();
                                            gridView.scroll(DirectionHex.NORTH_WEST);
                                            break;
                case RANGED_ATTACK:
                                            System.out.println("TRYING TO RANGE ATTACK!!");
                                            gridView.doRangedAttack();

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

        Tile tile;
        Entity target = null;

        if ( (player.getRightHand() != null && player.getRightHand().getWeaponType() == WeaponType.RANGED_WEAPON)
                || (player.getLeftHand() != null && player.getLeftHand().getWeaponType() == WeaponType.RANGED_WEAPON)) {
            /** Ranged Attacks **/
            int range = 3;
            boolean doNotIncludeSelf = false;
            HashMap<PositionHex, Tile> line = map.drawLine( player.getPosition(), range, player.getDirection(), doNotIncludeSelf );
            Iterator iterator = line.entrySet().iterator();
            while ( iterator.hasNext() ) {
                java.util.Map.Entry pair = (java.util.Map.Entry)( iterator.next() );
                tile = (Tile) pair.getValue();
                target = tile.getEntity();
                iterator.remove();
                if ( target != null ) {
                    break;
                }
            }
        } else {
            /** Melee attacks **/
            tile = map.getTile(player.getPosition().getPosInDirection(player.getDirection()));
            target = tile.getEntity();
        }

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

    //will heal an occupation on press!!
    public boolean bind_wounds(){
        return player.getOccupation().bindWounds();
    }


    public void bargain(){
        //return player.getOccupation().bargain(target);
    }

    public void observation(){

    }

    /****************************************************************/
    //only for testing!!!

    private TileGrid gridView;

    public void setGridView(TileGrid gridView) {
        this.gridView = gridView;
    }
    public void setAreaView(AreaView areaView) { this.areaView = areaView;}


    /****************************************************************/

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
