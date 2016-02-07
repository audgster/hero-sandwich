package views;
import views.View;
import models.menus.*;
import models.menus.options.Option;
import java.awt.*;
import javax.swing.*;

public class MenuView extends View{

	private Menus menu;
	protected String[] options;
	private int currentIndex;
	private Font menuFont = new Font("Comic Sans MS", Font.PLAIN, 40);

	public MenuView(Menus menu){
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
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
		for(int i = 0; i < options.length; i++){
			JLabel label = new JLabel(options[i]);
			label.setAlignmentX(Component.CENTER_ALIGNMENT);
			label.setBackground(Color.GREEN);
			label.setFont(menuFont);
			if(currentIndex == i){
				label.setOpaque(true);
			}
			else{
				label.setOpaque(false);
			}
			add(label);
		}

		JLabel imageLabel = new JLabel(new ImageIcon("../images/hero-sandwiche.gif"));
		add(imageLabel);

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
