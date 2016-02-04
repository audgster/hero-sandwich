import java.awt.*;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import javax.swing.*;

public class RunGame{
	
	private static final String GAME_TITLE = "Hero Sandwich";
	
	public static void main(String[] args){
	
        GameWindow gw = new GameWindow();
		gw.setVisible(true);
		
		/*GameWindow window = new GameWindow(GAME_TITLE);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel titleLabel = new JLabel(GAME_TITLE);
		titleLabel.setPreferredSize(new Dimension(175, 100));
		window.getContentPane().add(titleLabel, BorderLayout.CENTER);
		window.pack();
		window.setVisible(true);*/
	}  
}