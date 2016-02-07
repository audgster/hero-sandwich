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

		BufferedImage[] avatarImages = new BufferedImage[3];
		try{
			avatarImages[0] = ImageIO.read(new File("../images/smasher.gif"));
			avatarImages[1] = ImageIO.read(new File("../images/summoner.png"));
			avatarImages[2] = ImageIO.read(new File("../images/sneak.jpg"));
		}
		catch(IOException e){
			System.out.println("could not find any files!!!!!!!!!!!!!!!!!!!");
		}

		createLayout(avatarImages);

		revalidate();
		repaint();
	}

	private void createLayout(BufferedImage[] images){
		ImageIcon icon;
		JPanel panel;
		JLabel img, label;
		for(int i = 0; i < options.length; i++){
			icon = new ImageIcon(images[i]);
			panel = new JPanel();
			img = new JLabel(icon);
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			label = new JLabel(options[i]);
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
