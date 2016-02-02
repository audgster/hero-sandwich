import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

public class Controller{
	public ControllerState state;
	public Controller(){
		state = new AvatarState();
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
			case 5: state.select();
					if(state.getName() == "Avatar"){
						changeState();
					}
					break;
			case 6: state.east();
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
		if(state.getName() == "Avatar"){
			state = new MenuState();
		}
		else{
			state = new AvatarState();
		}
	}
}

