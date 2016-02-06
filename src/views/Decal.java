package views;

public class Decal implements Drawable {
	
	public String getImageId(){
		return "Decal_" + this.getClass().getSimpleName();
	}
	
}