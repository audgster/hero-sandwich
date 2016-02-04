package views;

import views.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class ViewManager extends View{
	
	private AreaView areaView;
	private StatsView statsView;
	private java.util.List<MenuView> menuViews;
	
	private enum Mode{
		MAIN_MENU,
		GAME
	};
	private Mode mode;
	
	public ViewManager(){
		this.menuViews = new LinkedList<MenuView>();
		setLayout(new BorderLayout());
		setMainMenuMode();
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
		setMainMenuMode();
		update();
	}
	
	public void setAreaView(AreaView areaView){
		this.areaView = areaView;
	}
	
	public void setStatsView(StatsView statsView){
		this.statsView = statsView;
	}
	
	public void addMenuView(MenuView menuView){
		menuViews.add(menuView);
	}
	
	public void removeMenuView(MenuView menuView){
		menuViews.remove(menuView);
	}
	
	public void render(){
		if(mode == Mode.MAIN_MENU){
			add(menuViews.get(0), BorderLayout.LINE_START);
			menuViews.get(0).setVisible(true);
			JLabel logo = new JLabel("Insert Logo Here");
			add(logo, BorderLayout.CENTER);
		}
		else if(mode == Mode.GAME){
			///TO-DO
		}
		else{
			//something screwed up
		}
		
		revalidate();
		repaint();
	}
	
	public void update(){
		
		render();
	}
	
	public void setMainMenuMode(){
		mode = Mode.MAIN_MENU;
	}
	
	public void setGameMode(){
		mode = Mode.GAME;
	}
	
}