package views;
import views.View;
import models.menus.*;
import models.menus.options.Option;
import java.awt.*;
import javax.swing.*;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class CustomizeView extends View{

	private Menus menu;
	private String[] options;
	private int currentIndex;
	private Font menuFont = new Font("Comic Sans MS", Font.PLAIN, 40);

	public CustomizeView(Menus menu){
		setLayout(new GridLayout(1,3));
		setMenu(menu);
		update();
}

	public void setMenu(Menus menu){
		if(this.menu != null){
			menu.removeListener(this);
		}
		this.menu = menu;
		this.menu.addListener(this);
	}

	protected void render(){
		removeAll();

			BufferedImage smasherImage = null, sneakImage = null, summonerImage = null;
			try{
				smasherImage = ImageIO.read(new File("../images/groundTile.PNG"));
				sneakImage = ImageIO.read(new File("../images/smasher.gif"));
				summonerImage = ImageIO.read(new File("../images/smasher.gif"));
			}
			catch(IOException e){
				System.out.println("could not find any files!!!!!!!!!!!!!!!!!!!");
			}
			ImageIcon icon = new ImageIcon(smasherImage);

		JPanel panel;
		for(int i = 0; i < options.length; i++){
			panel = new JPanel();
			JLabel img = new JLabel(icon);
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			JLabel label = new JLabel(options[i]);
			// label.setIcon(icon);
			label.setAlignmentX(Component.CENTER_ALIGNMENT);
			label.setBackground(Color.GREEN);
			label.setFont(menuFont);
			if(currentIndex == i){
				label.setOpaque(true);
			}
			else{
				label.setOpaque(false);
			}
			panel.add(img);
			panel.add(label);
			add(panel);
		}

		revalidate();
		repaint();
	}

	public void update(){
		Option[] menuOptions = menu.getListOfOptions();
		Option current = menu.getCurrentlySelected();
		options = new String[menuOptions.length];

		for(int i = 0; i < menuOptions.length; i++){
			options[i] = menuOptions[i].toString();
			if(menuOptions[i] == current){
				currentIndex = i;
			}
		}
		render();
	}

}
