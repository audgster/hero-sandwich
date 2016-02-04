package views;

import views.*;
import javax.swing.*;
import java.util.*;

public class ViewManager extends View{
	
	private AreaView areaView;
	private StatsView statsView;
	private List<MenuView> menuViews;
	
	private enum Mode{
		MAIN_MENU,
		GAME
	};
	private Mode mode;
	
	public ViewManager(AreaView areaView, StatsView statsView, MenuView... menuViews){
		this.areaView = areaView;
		this.statsView = statsView;
		this.menuViews = new LinkedList<MenuView>();
		for(int i = 0; i < menuViews.length; i++){
			this.menuViews.add(menuViews[i]);
		}
		setLayout(new BorderLayuot());
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
		if(mode == MAIN_MENU){
			add(menuViews.get(0), BorderLayout.LINE_START);
			JLabel logo = new JLabel("Insert Logo Here");
			add(logo, BorderLayout.CENTER);
		}
		else if(mode == GAME){
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
		mode = MAIN_MENU;
	}
	
	public void setGameMode(){
		mode = GAME;
	}
	
}