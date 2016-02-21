import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Avatar{
       public BufferedImage image;
       private BufferedImage image2;
       public int x = 0;
       public int y = 0;
       private int movementSpeed = 1;
       private int changeAvatar = 0;
       private char direction=' ';



	public Avatar(){
       image = null;
            try {
                    image = ImageIO.read(Tile.class.getResourceAsStream("sprite_avatar2.png"));
            } catch (IOException e) {
                    e.printStackTrace();
            }
            try {
                    image2 = ImageIO.read(Tile.class.getResourceAsStream("sprite_avatar1.png"));
            } catch (IOException e) {
                    e.printStackTrace();
            }
	}
    public void tick(){
        if(x%64!=0){
            if(direction=='w')goUp();
            if(direction=='a')goLeft();
            if(direction=='s')goDown();
            if(direction=='d')goRight();
        }
    }
    public void change(){
        BufferedImage tempImage;
        tempImage = image;
        image = image2;
        image2 = tempImage;
    }

    public void executeUserInput(char input){
        int newInput =  (int) input - 48;
        switch(input){
            case 'w': goUp();
                    break;
            case 'a': goLeft();
                    break;
            case 's': goDown();
                    break;
            case 'd': goRight();
                    break;
            default: break;
        }
    }

    public void goUp(){
        y=y-8*movementSpeed;
        direction='w';
        if(y<0)y=0;
        else change();
    }
    public void goLeft(){
        x=x-8*movementSpeed;
        direction='a';
        if(x<0)x=0;
        else change();
    }
    public void goDown(){
        y=y+8*movementSpeed;
        direction='s';
        change();
    }
    public void goRight(){
        x=x+8*movementSpeed;
        direction='d';
        change();
    }

}