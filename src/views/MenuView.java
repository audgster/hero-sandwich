package views;
import views.View;
import java.awt.*;

public class MenuView extends View{
	
	private Menu menu;
	private String[] options;
	private int currentIndex;
	
	public MenuView(Menu menu){
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setMenu(menu);
		update();
	}
	
	public void setMenu(Menu menu){
		this.menu = menu;
	}
	
	public void render(){
		removeAll();
		for(int i = 0; i < options.length; i++){
			JLabel label = new Jlabel(options[i]);
			label.setAlignmentX(Component.CENTER_ALIGNMENT);
			label.setBackground(Color.WHITE);
			if(currentIndex == i){
				label.setOpaque(true);
			}
			else{
				label.setOpaque(false);
			}
			add(label)
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