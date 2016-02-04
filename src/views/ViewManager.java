package views;

public class ViewManager extends View{
	
	private AreaView areaView;
	private StatsView statsView;
	private List<MenuView> menuViews;
	
	public ViewManager(AreaView areaView, StatsView statsView, MenuView... menuViews){
		this.areaView = areaView;
		this.statsView = statsView;
		this.menuViews = new LinkedList<MenuView>();
		for(int i = 0; i < menuViews.length; i++){
			this.menuViews.add(menuViews[i]);
		}
	}
	
	public void setAreaView(AreaView areaView){
		this.areaView = areaView;
	}
	
	public void setStatsView(StatsView statsView){
		this.statsView = statsView()
	}
	
	public void addMenuView(MenuView menuView){
		menuViews.add(menuView);
	}
	
	public void removeMenuView(MenuView menuView){
		menuViews.remove(menuView);
	}
	
	public void render(){
		
	}
	
	public void update(){
		
	}
	
}