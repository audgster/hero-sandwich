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
	private GridBagConstraints gBC;
	private Option[] menuOptions;
	private Font menuFont = new Font("Comic Sans MS", Font.PLAIN, 40);

	public CustomizeView(Menus menu){
		setLayout(new GridBagLayout());
		setMenu(menu);
		gBC = new GridBagConstraints();
    gBC.fill = GridBagConstraints.HORIZONTAL;
		menuOptions = menu.getListOfOptions();
		options = new String[menuOptions.length];
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
			avatarImages[2] = ImageIO.read(new File("../images/sneak.gif"));
		}
		catch(IOException e){
			System.out.println("could not find any files!");
		}

		createLayout(avatarImages);
		revalidate();
		repaint();
	}

	private void createLayout(BufferedImage[] images){
		ImageIcon icon;
		JLabel img, label;
		String[] region = {BorderLayout.WEST, BorderLayout.CENTER, BorderLayout.EAST};
		for(int i = 0; i < options.length; i++){
			gBC.ipady = 40;
			gBC.weightx = 1;
			gBC.gridx = i;
			gBC.gridy = 0;

			icon = new ImageIcon(images[i]);
			img = new JLabel(icon);

			add(img, gBC);
		}

		for(int i = 0; i < options.length; i++){
			gBC.ipady = 10;
			gBC.weightx = 1;
			gBC.gridx = i;
			gBC.gridy = 1;

			label = new JLabel(options[i], SwingConstants.CENTER);
			label.setBackground(Color.GREEN);
			label.setFont(menuFont);
			if(currentIndex == i){
				label.setOpaque(true);
			}
			else{
				label.setOpaque(false);
			}
			add(label, gBC);
		}
	}

	public void update(){
		Option current = menu.getCurrentlySelected();

		for(int i = 0; i < menuOptions.length; i++){
			options[i] = menuOptions[i].toString();
			if(menuOptions[i] == current){
				currentIndex = i;
			}
		}
		render();
	}

}
