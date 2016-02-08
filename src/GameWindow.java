import java.awt.event.*;
import javax.swing.*;
import controllers.*;
import models.menus.*;
import views.*;

public class GameWindow extends JFrame implements KeyListener{
	private Controller  avatarController;
	private Menus menu;
	private ViewManager viewManager;

  	public GameWindow(){
		createViewManager();
  		setTitle("Hero Sandwich");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	setLocationRelativeTo(null);
		pack();
		createController();
	}

	private void createViewManager(){
		viewManager = new ViewManager();
		menu = new MainMenu(viewManager);

		viewManager.setMainMenuMode(menu);
		viewManager.setVisible(true);
		add(viewManager);
	}

	private void createController(){
		avatarController = Controller.getController();
    	avatarController.setMenu(menu);
    	avatarController.setViewManager(viewManager);

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
