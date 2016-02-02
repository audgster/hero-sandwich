import java.awt.event.*;
import javax.swing.*;

public class GameWindow extends JFrame 
						implements KeyListener{
    Controller  avatarController;
	//creates the game window
    public GameWindow(){
    	add(new MainMenuView());
		pack();

    	setTitle("Hero Sandwich");
        setSize(1300,1300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        avatarController = new Controller();
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