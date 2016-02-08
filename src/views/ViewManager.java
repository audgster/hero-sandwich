package views;

import views.*;
import models.Level;
import models.entities.Entity;
import models.menus.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import controllers.*;

public class ViewManager extends View{

	private AreaView areaView;
	private StatsView statsView;
	private PauseView pauseView;
	private InventoryView inventoryView;
	private EquipmentView equipmentView;
	private GameOverView gameOverView;
	private LinkedList<View> menuViews;
	private String titleText = "Hero Sandwich";
	private Font titleFont = new Font("Comic Sans MS", Font.ITALIC, 80);
	private Menus inventoryMenu, equipmentMenu, gameOverMenu;

	private enum Mode{
		MAIN_MENU,
		CUSTOMIZE_MENU,
		GAME,
		PAUSE,
		INVENTORY_MENU,
		EQUIPMENT_MENU,
		DEAD
	};
	private Mode mode;

	public ViewManager(){
		this.menuViews = new LinkedList<View>();
		setLayout(new BorderLayout());
		update();
	}

	public Menus getInventoryMenu(){
		return inventoryMenu;
	}

	public Menus getEquipmentMenu(){
		return equipmentMenu;
	}
	public Menus getGameOverMenu(){
		return gameOverMenu;
	}

	public void setStatsView(StatsView statsView){
		this.statsView = statsView;
	}

	public void setInventoryMenu(Menus inventoryMenu){
		this.inventoryMenu = inventoryMenu;
	}

	public void setEquipmentMenu(Menus equipmentMenu){
		this.equipmentMenu = equipmentMenu;
	}
	public void setGameOverMenu(Menus gameOverMenu){
		this.gameOverMenu = gameOverMenu;
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
		}
		else if(mode == Mode.CUSTOMIZE_MENU){
			JLabel cText = new JLabel("Select Avatar");
			cText.setFont(titleFont);
			cText.setHorizontalAlignment(SwingConstants.CENTER);
			add(cText, BorderLayout.PAGE_START);
			menuViews.getLast().setVisible(true);
			add(menuViews.getLast(), BorderLayout.CENTER);
		}
		else if(mode == Mode.GAME){
			areaView.setVisible(true);
			statsView.setVisible(true);
			areaView.setPreferredSize(new Dimension(getWidth(), getHeight()));
			add(areaView, BorderLayout.CENTER);
			statsView.setPreferredSize(new Dimension(getWidth()/5, getHeight()));
			add(statsView, BorderLayout.LINE_START);
			System.out.println("the size of the fram is " + areaView.getWidth());
		}
		else if(mode == Mode.PAUSE){
			pauseView.setVisible(true);
			statsView.setVisible(true);
			pauseView.setPreferredSize(new Dimension(getWidth(), getHeight()));
			add(pauseView, BorderLayout.CENTER);
			statsView.setPreferredSize(new Dimension(getWidth()/5, getHeight()));
			add(statsView, BorderLayout.LINE_START);
		}
		else if(mode == Mode.INVENTORY_MENU){
			inventoryView.setVisible(true);
			statsView.setVisible(true);
			inventoryView.setPreferredSize(new Dimension(getWidth(), getHeight()));
			add(inventoryView, BorderLayout.CENTER);
			statsView.setPreferredSize(new Dimension(getWidth()/5, getHeight()));
			add(statsView, BorderLayout.LINE_START);
		}
		// else if(mode == Mode.EQUIPMENT_MENU){
		// 	equipmentView.setVisible(true);
		// 	statsView.setVisible(true);
		// 	equipmentView.setPreferredSize(new Dimension(getWidth(), getHeight()));
		// 	add(equipmentView, BorderLayout.CENTER);
		// 	statsView.setPreferredSize(new Dimension(getWidth()/5, getHeight()));
		// 	add(statsView, BorderLayout.LINE_START);
		// }
		else if(mode == Mode.DEAD){
			statsView.setVisible(true);
			gameOverView.setPreferredSize(new Dimension(getWidth(), getHeight()));
			add(gameOverView, BorderLayout.CENTER);
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
			if(areaView.getAvatar().getIsDead()){
				setGameOverMode();
			}
			else{
				areaView.update();
				statsView.update();
			}
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

	public void setInventoryMenuMode(Menus iMenu, Entity avatar){
		mode = Mode.INVENTORY_MENU;
		popMenuView();
		System.out.println("The avatar is in setInvetory11111111" + avatar);
		inventoryView = new InventoryView(iMenu, avatar);
		pushMenuView(inventoryView);
		iMenu.addListener(inventoryView);
		update();
	}

	public void setEquipmentMenuMode(){
		mode = Mode.EQUIPMENT_MENU;
		popMenuView();

		equipmentView = new EquipmentView(equipmentMenu);
		pushMenuView(equipmentView);
		update();
	}

	public void setGameMode(Level level, Entity avatar){
		mode = Mode.GAME;
		areaView = new AreaView(level, avatar);
		statsView = new StatsView(avatar);
		menuViews.clear();
		update();
	}

	public void setGameModeAgain(){
		mode = Mode.GAME;
		menuViews.clear();
		update();
	}

	public void setPauseMode(Menus pMenu){
		mode = Mode.PAUSE;
		pauseView = new PauseView(pMenu);
		menuViews.push(pauseView);
		update();
	}

	public void setGameOverMode(){
		mode = Mode.DEAD;
		System.out.println("The AVATAR is DEAD!!!!!!!!!!!!!!!!!!");
		gameOverView = new GameOverView(gameOverMenu);
		Controller.getController().setMenu(gameOverMenu);
		Controller.getController().changeState();
		gameOverMenu.setController(Controller.getController());
		menuViews.clear();

		update();
	}

}
