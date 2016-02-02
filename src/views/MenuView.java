import views.View;

public class MenuView extends View
{
	
	private Menu menu;
	
	public MenuView(Menu menu){
		this.menu = menu;
	}
	
	public void render(){
		menu.draw(/*screen coordinates*/);
	}
	
}