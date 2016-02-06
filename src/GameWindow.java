import java.awt.event.*;
import javax.swing.*;
import controllers.*;
import models.menus.*;
import views.*;

public class GameWindow extends JFrame implements KeyListener{
	private Controller  avatarController;
	private Menus menu;

  	public GameWindow(){
		createViewManager();
  		setTitle("Hero Sandwich");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	setLocationRelativeTo(null);
		createController();
	}

	private void createViewManager(){
		ViewManager viewManager = new ViewManager();
		menu = new MainMenu(viewManager);
		
		viewManager.setMainMenuMode(menu);
		viewManager.setVisible(true);
		add(viewManager);
	}

	private void createController(){
		avatarController = new Controller();
    	avatarController.setMenu(menu);
    	addKeyListener(this);
		menu.setController(avatarController);
	}

	//KeyListener methods
	public void keyPressed(KeyEvent e){
		avatarController.executeUserInput(e.getKeyChar());
	}

	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e){}
}
