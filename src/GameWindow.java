import java.awt.event.*;
import javax.swing.*;
import controllers.*;
import models.menus.*;
import views.*;

public class GameWindow extends JFrame implements KeyListener{
	
	Controller  avatarController;
    ViewManager viewManager;
    Menus menu;
    char input;
	
    public GameWindow(){
        menu = new MainMenu();
        viewManager = new ViewManager();
		viewManager.addMenuView(new MenuView(menu));
    	add(viewManager);
		viewManager.setVisible(true);
		pack();

    	setTitle("Hero Sandwich");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        avatarController = new Controller();
        avatarController.setMenu(menu);
        addKeyListener(this);
	}
	
	public ViewManager getViewManager(){
		return this.viewManager;
	}

    //KeyListener methods
    public void keyPressed(KeyEvent e){
        input = e.getKeyChar();
		avatarController.executeUserInput(input);
	}
    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e){}
}
