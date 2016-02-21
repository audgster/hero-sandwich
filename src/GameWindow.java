import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.BufferStrategy;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.FontMetrics;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class GameWindow extends Canvas implements Runnable, KeyListener{
	
	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 160;
	public static final int HEIGHT = WIDTH/12*9;
	public static final int SCALE = 5;
	public static final String NAME = "Hero Sandwich";
	String frameRate = "";

	public boolean running = false;
	int tickCount = 0;

	private JFrame frame;
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();

	private int[] tiles = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
	private Tile tile = new Tile();
	private Avatar avatar = new Avatar();


	public GameWindow(){
		setMinimumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		setMaximumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));

		frame = new JFrame(NAME);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		frame.add(this, BorderLayout.CENTER);
		frame.pack();

		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		//controller
		addKeyListener(this);
	}

	public synchronized void start(){
		running = true;
		new Thread(this).start();
	}
	public synchronized void stop(){
		running = false;
	}

	public void tick(){
		tickCount++;

		//gets Tile images
		tile.tick();
		image = tile.image;

		//gets avatar image

	}
	public void render(){
				avatar.tick();

		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();

		//draws the tiles on the map
		int w = 0,h = 0;
		for(int t = 0; t < 130; t++){
			if(w == getWidth()/image.getWidth()+1){
				h++;
				w = 0;
			}
			g.drawImage(image, w*image.getWidth(), h*image.getHeight(),null);
			w++;
		}

		//draws the avatar on the map
		g.drawImage(avatar.image, avatar.x, avatar.y,null);


		//draws the frame rate string to bottom right of screen
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesRoman", Font.BOLD, 15)); 
		int stringWidth = g.getFontMetrics().stringWidth(frameRate);
		g.drawString(frameRate, getWidth()-stringWidth,getHeight());
		
		g.dispose();
		bs.show();
	}

	public void run(){
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D/60D;

		int ticks = 0;
		int frames = 0;

		long lastTimer = System.currentTimeMillis();
		double delta = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime)/nsPerTick;
			lastTime = now;

			boolean shouldRender= false;
			while(delta >= 1){
				ticks++;
				tick();
				delta -= 1;
				shouldRender = true;
			}
			try{
			 	Thread.sleep(2);
			} catch(InterruptedException e){
			 	e.printStackTrace();
			}
			if(shouldRender){
				frames++;
				render();
			}

			if(System.currentTimeMillis()-lastTimer >= 1000){
				lastTimer += 1000;
				//frameRate = ticks + " ticks, " + frames + " frames";
				frameRate = frames + " fps";
				frames = 0;
				ticks = 0;
			}
		}
	}

	//KeyListener methods
	public void keyPressed(KeyEvent e){
		avatar.executeUserInput(e.getKeyChar());
	}

	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e){}


}