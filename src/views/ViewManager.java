package views;

import views.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class ViewManager extends View{

	private AreaView areaView;
	private StatsView statsView;
	private LinkedList<MenuView> menuViews;
	private String titleText = "Hero Sandwich";
	private Font titleFont = new Font("Comic Sans MS", Font.PLAIN, 50);

	private enum Mode{
		MAIN_MENU,
		GAME
	};
	private Mode mode;

	public ViewManager(){
		this.menuViews = new LinkedList<MenuView>();
		setLayout(new BorderLayout());
		update();
	}

	public ViewManager(AreaView areaView, StatsView statsView, MenuView... menuViews){
		this.areaView = areaView;
		this.statsView = statsView;
		this.menuViews = new LinkedList<MenuView>();
		for(int i = 0; i < menuViews.length; i++){
			this.menuViews.add(menuViews[i]);
		}
		setLayout(new BorderLayout());
		update();
	}

	public void setAreaView(AreaView areaView){
		this.areaView = areaView;
	}

	public void setStatsView(StatsView statsView){
		this.statsView = statsView;
	}

	public void pushMenuView(MenuView menuView){
		menuViews.add(menuView);
	}

	public MenuView popMenuView(){
		return menuViews.pop();
	}

	protected void render(){
		if(mode == Mode.MAIN_MENU){
			JLabel title = new JLabel(titleText);
			title.setFont(titleFont);
			add(title, BorderLayout.PAGE_START);
			menuViews.get(0).setVisible(true);
			add(menuViews.get(0), BorderLayout.LINE_START);
			JLabel logo = new JLabel("Insert Logo Here");
			add(logo, BorderLayout.CENTER);
		}
		else if(mode == Mode.GAME){
			removeAll();
			///TO-DO
		}
		else{
			//something screwed up
			System.out.println("Mode not set");
		}

		revalidate();
		repaint();
	}

	public void update(){
		//something
		render();
	}

	public void setMainMenuMode(){
		mode = Mode.MAIN_MENU;
	}

	public void setGameMode(){
		mode = Mode.GAME;
	}

}
