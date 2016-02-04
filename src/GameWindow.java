import java.awt.event.*;
import javax.swing.*;
import controllers.*;
import models.menus.*;
import models.menus.options.*;
import views.*;

public class GameWindow extends JFrame
						implements KeyListener, Listener{
    Controller  avatarController;
    MainMenuView currentView;
    Menus menu;
    char input;
    public GameWindow(){
        menu = new MainMenu();
        currentView = new MainMenuView(menu);
        menu.addListener(this);
    	add(currentView);
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

    //KeyListener methods
    public void keyPressed(KeyEvent e){
        input = e.getKeyChar();
		avatarController.executeUserInput(input);
	}
    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e){}

    public void update(){
		Option option = menu.getCurrentlySelected();
        if(input == '5'){
            remove(currentView);
            option.execute();
        }
    }
}
