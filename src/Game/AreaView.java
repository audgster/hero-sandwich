package Game;

import javafx.stage.Stage;




public class AreaView implements Runnable{
	private String frameRate="";
	private boolean running;
	private int tickCount = 0;

	public AreaView(){}
	public void createScene(Stage primaryStage){
		start();
	}
	public synchronized void start(){
		running = true;
		new Thread(this).start();
	}
	public synchronized void stop(){
		running = false;
	}
	private void render(){
	}
	private void tick(){
		tickCount++;
	}
	public void run(){
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D/60D; //how many ticks per second

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
			if(shouldRender){
				frames++;
				render();
			}

			if(System.currentTimeMillis()-lastTimer >= 1000){
				lastTimer += 1000;
				frameRate = frames + " fps";
				frames = 0;
				ticks = 0;
				System.out.println(frameRate);

			}
		}
	}
}
