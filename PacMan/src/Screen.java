
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Screen extends JPanel implements Runnable, ActionListener{
	Thread thread;
	Timer timer;
	
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
	
	private int start = 10000;
	private int pause = 1900;
	
	Player pacman;
	
	public Screen(Frame frame){
		
		this.frame = frame;
		frame.setSize(horizontal * 25 + 24 , (vertical) * 25 + 48);
		this.frame.addKeyListener(new KeyHandler(this));
		thread  = new Thread(this);
		thread.start();
		
		timer = new Timer(start,this);
		timer.setInitialDelay(pause);
		timer.start();
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
		pacman = new Player(playerPos);
		pacman.draw(g2d);
		
	}
	
	public void setStartLoc(){
		playerPos = new Point(this.frame.getWidth()/2 - 10, this.frame.getHeight()-100);
	}

	@Override
	public void run(){
		running = true;
		setStartLoc();
		
		while(running){
			checkForMovement();
			repaint();
		}		
	}
	
	public void checkForMovement(){
		if(right) {
			playerPos.setLocation(playerPos.x+10, playerPos.y);
		}
	}
	
	public class KeyTyped{
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("FOO!");
		
	}
}
