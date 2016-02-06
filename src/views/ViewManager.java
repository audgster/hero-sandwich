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
		CUSTOMIZE_MENU,
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
			removeAll();
		if(mode == Mode.MAIN_MENU){
			JLabel title = new JLabel(titleText);
			title.setFont(titleFont);
			add(title, BorderLayout.PAGE_START);
			menuViews.get(0).setVisible(true);
			add(menuViews.get(0), BorderLayout.LINE_START);
			JLabel logo = new JLabel("Insert Logo Here");
			add(logo, BorderLayout.CENTER);
		}
		else if(mode == Mode.CUSTOMIZE_MENU){
			System.out.println("Customize View");
			JLabel cText = new JLabel("Customize View Temp");
			cText.setFont(titleFont);
			add(cText, BorderLayout.PAGE_START);
			menuViews.get(0).setVisible(true);
			add(menuViews.get(0), BorderLayout.CENTER);
		}
		else if(mode == Mode.GAME){
			// Map map = new Map();
			// ILocationManager locationManager = new ILocationMangager();
			//game object will  game.getLevel();
			add(areaView, BorderLayout.CENTER);
			add(statsView, BorderLayout.LINE_START);
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

	public void setMainMenuMode(Menu mainMenu){
		mode = Mode.MAIN_MENU;
		areaView = null;
		statsView = null;
		menuViews.clear();
		
		MenuView mainMenuView = new MenuView(mainMenu);
		pushMenuView(mainMenuView);
		update();
	}
	
	public void setCustomizeMenuMode(Menu cMenu){
		mode = Mode.CUSTOMIZE_MODE;
		areaView = null;
		statsView = null;
		menuViews.clear();
		
		MenuView cMenuView = new MenuView(cMenu);
		pushMenuView(cMenuView);
		update();
	}

	public void setGameMode(Level level, Entity avatar){
		mode = Mode.GAME;
		areaView = new AreaView(level, avatar);
		statsView = new StatsView(/*avatar.getStats()*/);
		menuViews.clear();
		update();
	}

}
