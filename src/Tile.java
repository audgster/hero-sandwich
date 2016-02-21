import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Tile{
       public int[] pixels;
       BufferedImage image;
       boolean changeTiles;
       int changeYet;

	public Tile(){
       image = null;
       changeTiles = true;
       changeYet = 0;
	}
    public void tick(){
        //if(changeTiles){
        if(false){
            try {
                    image = ImageIO.read(Tile.class.getResourceAsStream("Tile_Water.gif"));
            } catch (IOException e) {
                    e.printStackTrace();
            }
            if(changeYet%50==0){
                changeTiles = !changeTiles;
            }
        }
        else{
            try {
                    image = ImageIO.read(Tile.class.getResourceAsStream("Tile_Ground.gif"));
            } catch (IOException e) {
                    e.printStackTrace();
            }
            if(changeYet%50==0){
                changeTiles = !changeTiles;
            }
        }
        changeYet++;

    }
}