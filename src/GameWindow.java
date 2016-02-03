import java.awt.event.*;
import javax.swing.*;
import controllers.*;
import models.menus.*;

public class GameWindow extends JFrame 
						implements KeyListener{
    Controller  avatarController;
	//creates the game window
    MainMenuView currentView;
    Menu menu;
    public GameWindow(){
        menu = new MainMenu();
        currentView = new MainMenuView(menu);
    	add(currentView);
		pack();

    	setTitle("Hero Sandwich");
        setSize(1300,1300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        avatarController = new Controller();
        avatarController.setMenu(menu);
        addKeyListener(this);

	}

    //KeyListener methods
    public void keyPressed(KeyEvent e){
        char input = e.getKeyChar();
		avatarController.executeUserInput(input);
	}
    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e){}
}