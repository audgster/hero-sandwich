package com.herosandwich.controller;



import com.herosandwich.models.*;
import com.herosandwich.util.*;

public class Controller{
    private static Controller controller = null;

	public static Controller getController() {
    	if(controller == null){
    		controller = new Controller();
    	}
    	return controller;

	}

	// Private constructor for Singleton pattern
	private Controller() { }


	public void executeUserInput(char input){
		// get correct enum from hashmap
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
