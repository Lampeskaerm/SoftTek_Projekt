import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JPanel;


public class Screen2 extends JPanel implements Runnable{
	Thread thread = new Thread();
	
	Frame frame;
	public boolean running = false;
	public int gameState = 1;
	
	//Movement variables.
	public boolean right = false;
	public boolean left = false;
	public boolean up = false;
	public boolean down = false;
	public boolean space = false;
	
	//Location variables.
	private Point playerPos;
	private Point blinkyPos;
	private Point pinkyPos;
	private Point inkyPos;
	private Point clydePos;
	
	private int vertical = 18;
	private int horizontal = 20;
	private int frameWidth;
	private int frameHeight;
	
	Player pacman;
	
	public Screen2(Frame frame){
		this.frame = frame;
		frame.setSize(horizontal * 25 + 24 , (vertical) * 25 + 48);
//		this.frame.addKeyListener(new KeyHandler(this));
		thread.start();
	}
	
	public void paintComponent(Graphics g){
		frameWidth = this.frame.getWidth();
		frameHeight = this.frame.getHeight();
		
		ArrayList<Pellet> pellets = new ArrayList<Pellet>();
		g.setColor(Color.black);
		g.fillRect(0, 0, frameWidth, frameHeight);
		
		Graphics2D g2d = (Graphics2D) g;
		
		for(int i = 1; i <= vertical; i++){
			for(int j = 1; j <= horizontal; j++){
				Point pelletPos = new Point((24*i), (24*j));
				Pellet pellet = new Pellet(pelletPos);
				pellets.add(pellet);
				pellet.draw(g2d);
			}
		}
		playerPos = new Point(frameWidth/2 - 10, frameHeight-100);
		pacman = new Player(playerPos);
		pacman.draw(g2d);
		
	}
	
	public void run(){
		//Goes once:
				running = true;
				System.out.println("RIGHT!");
				
				//updates:
				while(running){
					System.out.println("RIGHT!");
					//movements:
					//Move right.
					while(right){
						System.out.println("RIGHT!");
						if(playerPos.x < horizontal - 1){
							pacman.pos.x +=50;
							
							right = false;
						}else{
							right = false;
						}
					}
					right = false;
					
					
					//Move left.
					while(left){
						if(playerPos.x > 0){
						left = false;
						}else{
							left = false;
						}
					}
					left = false;
					
					
					//Move up.
					while(up){
						if(playerPos.y > 0){
							up = false;
						}else{
							up = false;
						}
					}
					up = false;
					
					
					//move down.
					while(down){
						if(playerPos.y < vertical - 1){
							down = false;
						}else{
							down = false;
						
						}
					}
				}
			//update graphics.
			frame.getContentPane().repaint();
	}
	
	public class KeyTyped2{
		public void keyESC(){
			running = false;
		}
		
		public void KeyRight(){
			right = true;
		}
		
		public void KeyLeft(){
			left = true;
		}
		
		public void KeyUp(){
			up = true;
		}
		
		public void KeyDown(){
			down = true;
		}
		
		public void KeySpace(){
			space = true;
		}
	}
}
