package views;

import views.*;
import models.Level;
import models.entities.Entity;
import models.menus.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class ViewManager extends View{

	private AreaView areaView;
	private StatsView statsView;
	private LinkedList<View> menuViews;
	private String titleText = "Hero Sandwich";
	private Font titleFont = new Font("Comic Sans MS", Font.ITALIC, 80);

	private enum Mode{
		MAIN_MENU,
		CUSTOMIZE_MENU,
		GAME
	};
	private Mode mode;

	public ViewManager(){
		this.menuViews = new LinkedList<View>();
		setLayout(new BorderLayout());
		update();
	}

	public void setStatsView(StatsView statsView){
		this.statsView = statsView;
	}

	public void pushMenuView(View menuView){
		menuViews.add(menuView);
	}

	public View popMenuView(){
		View v = null;
		if(!menuViews.isEmpty())
		{
			v = menuViews.pop();

		}
		return v;
	}

	protected void render(){
		removeAll();
		if(mode == Mode.MAIN_MENU){
			JLabel title = new JLabel(titleText);
			title.setHorizontalAlignment(SwingConstants.CENTER);
			title.setFont(titleFont);
			add(title, BorderLayout.PAGE_START);
			menuViews.get(0).setVisible(true);
			add(menuViews.get(0), BorderLayout.LINE_START);
			// JLabel logo = new JLabel("Insert Logo Here");
			// add(logo, BorderLayout.CENTER);
		}
		else if(mode == Mode.CUSTOMIZE_MENU){
			//System.out.println("Customize View");
			JLabel cText = new JLabel("Select Avatar");
			cText.setFont(titleFont);
			cText.setHorizontalAlignment(SwingConstants.CENTER);
			add(cText, BorderLayout.PAGE_START);
			menuViews.getLast().setVisible(true);
			add(menuViews.getLast(), BorderLayout.CENTER);
		}
		else if(mode == Mode.GAME){
			// Map map = new Map();
			// ILocationManager locationManager = new ILocationMangager();
			//game object will  game.getLevel();
			areaView.setVisible(true);
			statsView.setVisible(true);
			areaView.setPreferredSize(new Dimension(getWidth(), getHeight()));
			add(areaView, BorderLayout.CENTER);
			statsView.setPreferredSize(new Dimension(getWidth()/5, getHeight()));
			add(statsView, BorderLayout.LINE_START);
		}
		else{
			//something screwed up
			//System.out.println("Mode not set. No sub-views rendered");
		}

		revalidate();
		repaint();
	}

	public void update(){
		//something
		render();
		if(mode == Mode.MAIN_MENU){
			menuViews.get(0).update();
		}
		else if(mode == Mode.CUSTOMIZE_MENU){
			menuViews.getLast().update();
		}
		else if(mode == Mode.GAME){
			areaView.update();
			statsView.update();
		}
		else{
			//nothing updates
			//System.out.println("Mode not set. No sub-views updated");
		}
		
	}

	public void setMainMenuMode(Menus mainMenu){
		mode = Mode.MAIN_MENU;
		areaView = null;
		statsView = null;
		popMenuView();


		MenuView mainMenuView = new MenuView(mainMenu);
		pushMenuView(mainMenuView);
		update();
	}

	public void setCustomizeMenuMode(Menus cMenu){
		mode = Mode.CUSTOMIZE_MENU;
		areaView = null;
		statsView = null;
		popMenuView();

		View cMenuView = new CustomizeView(cMenu);
		pushMenuView(cMenuView);
		update();
	}

	public void setGameMode(Level level, Entity avatar){
		mode = Mode.GAME;
		areaView = new AreaView(level, avatar);
		statsView = new StatsView(avatar);
		menuViews.clear();
		update();
	}

}
