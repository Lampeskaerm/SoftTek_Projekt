package Pacman;

import java.awt.*;

import javax.swing.JPanel;

public class Screen extends JPanel implements Runnable {
	Thread thread = new Thread(this);
	
	Frame frame;
	public boolean running = false;
	public String gameState = "gameOn";
	private boolean enter = false;
	public boolean UpperLeftBigPacDot = false;
	public boolean UpperRightBigPacDot = false;
	public boolean lowerLeftBigPacDot = false;
	public boolean lowerRightBigPacDot = false;
	public boolean godMode = false;
	int godModeCounter = 0;
	
	//Movement variables.
	public boolean right = false;
	public boolean left = false;
	public boolean up = false;
	public boolean down = false;
	public int ghostCounter = 0;
	public String randomMovement = "";
	
	//Location variables.
	public Point pacmanPos = new Point();
	public Point redGhostPos = new Point();
	public Point cyanGhostPos = new Point();
	public Point pinkGhostPos = new Point();
	public Point orangeGhostPos = new Point();
	
	
	private int Height;
	private int Width;
	private String [][] Array; //Maybe change to String array? to easier see what is going on.
	
	Ghosts ghosts;
	GetLocations getLocs;
	
	public Screen(Frame frame, int Width, int Height){
		this.Width = Width;
		this.Height = Height;
		Array = new String[Width][Height];
		this.frame = frame;
		frame.setSize(Width * 25 + 24, Height * 25 + 48);
		this.frame.addKeyListener(new KeyHandler(this));
		thread.start();
		
	}
	
	//Creates array with correct starting strings.
	public void restartGameArray(){
		for(int i = 0; i < Width; i++){
			for(int j = 0; j < Height; j++){
				Array[i][j] = "pacDot";
			}
		}
		Array[(int)(Width / 2)][Height - 2] = "pacMan";
		Array[(int)(Width / 2)][(int)(Height / 2 - 1)] = "redGhostAndBlackSpace";
		Array[(int)(Width / 2 - 1)][(int)(Height / 2)] = "cyanGhostAndBlackSpace";
		Array[(int)(Width / 2)][(int)(Height / 2)] = "pinkGhostAndBlackSpace";
		Array[(int)(Width / 2 + 1)][(int)(Height / 2)] = "orangeGhostAndBlackSpace";
		Array[1][1] = "bigPacDot";
		Array[1][Height - 2] = "bigPacDot";
		Array[Width - 2][1] = "bigPacDot";
		Array[Width - 2][Height - 2] = "bigPacDot";
	}
	
	public void paintComponent(Graphics g){	

		//if game still on.
		if(gameState.equals("gameOn")){
			g.setColor(Color.black);
			g.fillRect(0, 0, this.frame.getWidth(), this.frame.getHeight());
			//Draws the game using the array.
			for(int i = 0; i < Width; i++){
				for(int j = 0; j < Height; j++){
					if(Array[i][j].equals("pacDot")){
						g.setColor(Color.white);
						g.fillRect(24 * i + 24, 24 * j + 24, 8, 8);
					}else if(Array[i][j].equals("pacMan")){
						g.setColor(Color.yellow);
						g.fillOval(24 * i + 18, 24 * j + 18, 20, 20);
					}else if(Array[i][j].equals("redGhostAndPacDot")){
						g.setColor(Color.red);
						g.fillOval(24 * i + 18, 24 * j + 18, 20, 20);
					}else if(Array[i][j].equals("redGhostAndBlackSpace")){
						g.setColor(Color.red);
						g.fillOval(24 * i + 18, 24 * j + 18, 20, 20);
					}else if(Array[i][j].equals("cyanGhostAndPacDot")){
						g.setColor(Color.cyan);
						g.fillOval(24 * i + 18, 24 * j + 18, 20, 20);
					}else if(Array[i][j].equals("cyanGhostAndBlackSpace")){
						g.setColor(Color.cyan);
						g.fillOval(24 * i + 18, 24 * j + 18, 20, 20);
					}else if(Array[i][j].equals("pinkGhostAndPacDot")){
						g.setColor(Color.pink);
						g.fillOval(24 * i + 18, 24 * j + 18, 20, 20);
					}else if(Array[i][j].equals("pinkGhostAndBlackSpace")){
						g.setColor(Color.pink);
						g.fillOval(24 * i + 18, 24 * j + 18, 20, 20);
					}else if(Array[i][j].equals("orangeGhostAndPacDot")){
						g.setColor(Color.orange);
						g.fillOval(24 * i + 18, 24 * j + 18, 20, 20);
					}else if(Array[i][j].equals("orangeGhostAndBlackSpace")){
						g.setColor(Color.orange);
						g.fillOval(24 * i + 18, 24 * j + 18, 20, 20);
					}else if(Array[i][j].equals("bigPacDot")){
						g.setColor(Color.white);
						g.fillOval(24 * i + 19, 24 * j + 19, 16, 16);
					}else if(Array[i][j].equals("blackSpace")){
						g.setColor(Color.black);
						g.fillRect(24 * i + 16, 24 * j + 16, 24, 24);
					}
				}
			}
			
		//if game over.
		}else if(gameState.equals("gameOver")){
			g.setColor(Color.black);
			g.fillRect(0, 0, this.frame.getWidth(), this.frame.getHeight());
			g.setColor(Color.green);
			Font font = new Font("Arial", Font.BOLD, 30);
			g.setFont(font);
			g.drawString("GAMEOVER!", 100, 50);
			g.drawString("PRESS SPACE", 90, 150);
			g.drawString("TO RESTART!", 95, 200);
			g.drawString("ESC TO EXIT", 100, 300);
		
		//If game is won.
		}else if (gameState.equals("gameWon")){
			g.setColor(Color.black);
			g.fillRect(0, 0, this.frame.getWidth(), this.frame.getHeight());
			g.setColor(Color.green);
			Font font = new Font("Arial", Font.BOLD, 30);
			g.setFont(font);
			g.drawString("GAME WON!", 100, 50);
			g.drawString("PRESS SPACE", 90, 150);
			g.drawString("TO RESTART!", 95, 200);
			g.drawString("ESC TO EXIT", 100, 300);
		}
	}
	
	public void run() {
		
		//Goes once:
		restartGameArray();
		ghosts = new Ghosts(Array, Width, Height, pacmanPos, redGhostPos, cyanGhostPos, pinkGhostPos, orangeGhostPos, godMode, gameState);
		getLocs = new GetLocations(Array, Width, Height, pacmanPos, redGhostPos, cyanGhostPos, pinkGhostPos, orangeGhostPos);
		getLocs.getLocationPacMan();
		running = true;
	
		
		//updates:
		while(running){
			
			//movements:
			//Move right.
			while(right){
				getLocs.getLocationPacMan();
				if(pacmanPos.x < Width - 1){
					if(Array[pacmanPos.x + 1][pacmanPos.y].equals("bigPacDot")){
						godMode = true;
					}
				Array[pacmanPos.x + 1][pacmanPos.y] = "pacMan";
				Array[pacmanPos.x][pacmanPos.y] = "blackSpace";
				right = false;
				}else{
					right = false;
				}
			}
			right = false;
			
			//Move left.
			while(left){
				getLocs.getLocationPacMan();
				if(pacmanPos.x > 0){
					if(Array[pacmanPos.x - 1][pacmanPos.y].equals("bigPacDot")){
						godMode = true;
					}
				Array[pacmanPos.x - 1][pacmanPos.y] = "pacMan";
				Array[pacmanPos.x][pacmanPos.y] = "blackSpace";
				left = false;
				}else{
					left = false;
				}
			}
			left = false;
			
			
			//Move up.
			while(up){
				getLocs.getLocationPacMan();
				if(pacmanPos.y > 0){
					if(Array[pacmanPos.x][pacmanPos.y - 1].equals("bigPacDot")){
						godMode = true;
					}
					Array[pacmanPos.x][pacmanPos.y - 1] = "pacMan";
					Array[pacmanPos.x][pacmanPos.y] = "blackSpace";
					up = false;
				}else{
					up = false;
				}
			}
			up = false;
			
			
			//move down.
			while(down){
				getLocs.getLocationPacMan();
				if(pacmanPos.y < Height - 1){
					if(Array[pacmanPos.x][pacmanPos.y + 1].equals("bigPacDot")){
						godMode = true;
					}
					Array[pacmanPos.x][pacmanPos.y + 1] = "pacMan";
					Array[pacmanPos.x][pacmanPos.y] = "blackSpace";
					down = false;
				}else{
					down = false;
				}
			}
			down = false;
			
			//Check if the game is won.
			int numberOfBlackSpaces = 0;
			for(int i = 0; i < Width; i++){
				for(int j = 0; j < Height; j++){
					if(Array[i][j].equals("blackSpace")){
						numberOfBlackSpaces++;
					}
				}
			}
			if(numberOfBlackSpaces == Width * Height - 5){
				gameState = "gameWon";
			}	
			
			//Increment ghostCounter.
			ghostCounter++;
			if(ghostCounter == 50){
				ghosts.Movements();
				ghostCounter = 0;
			}
			
			//Checks for collision with ghosts, gameover if this happends.
			if(!godMode){
				getLocs.getLocationPacMan();
				getLocs.getLocationRedGhost();
				if(pacmanPos.x == redGhostPos.x && pacmanPos.y == redGhostPos.y){
					gameState = "gameOver";
				}
			
				getLocs.getLocationCyanGhost();
				if(pacmanPos.x == cyanGhostPos.x && pacmanPos.y == cyanGhostPos.y){
					gameState =  "gameOver";
				}
			
				getLocs.getLocationPinkGhost();
				if(pacmanPos.x == pinkGhostPos.x && pacmanPos.y == pinkGhostPos.y){
					gameState =  "gameOver";
				}
			
				getLocs.getLocationOrangeGhost();
				if(pacmanPos.x == orangeGhostPos.x && pacmanPos.y == orangeGhostPos.y){
					gameState =  "gameOver";
				}
			}
			if(godMode == true){
				getLocs.getLocationPacMan();
				getLocs.getLocationRedGhost();
				if(pacmanPos.x == redGhostPos.x && pacmanPos.y == redGhostPos.y){
					Array[(int)(Width / 2)][(int)(Height / 2 - 1)] = "redGhostAndBlackSpace";
					getLocs.getLocationRedGhost();
				}
				
				getLocs.getLocationCyanGhost();
				if(pacmanPos.x == cyanGhostPos.x && pacmanPos.y == cyanGhostPos.y){
					Array[(int)(Width / 2 - 1)][(int)(Height / 2)] = "cyanGhostAndBlackSpace";
					getLocs.getLocationCyanGhost();
				}
				
				getLocs.getLocationPinkGhost();
				if(pacmanPos.x == pinkGhostPos.x && pacmanPos.y == pinkGhostPos.y){
					Array[(int)(Width / 2)][(int)(Height / 2)] = "pinkGhostAndBlackSpace";
					getLocs.getLocationPinkGhost();
				}
				
				getLocs.getLocationOrangeGhost();
				if(pacmanPos.x == orangeGhostPos.x && pacmanPos.y == orangeGhostPos.y){
					Array[(int)(Width / 2 + 1)][(int)(Height / 2)] = "orangeGhostAndBlackSpace";
					getLocs.getLocationOrangeGhost();
				}
				
			}
			 
			
			//Make so that when the gameover or game won screen is up you can restart by pressing space
			if(enter){
				gameState = "gameOn";
				restartGameArray();
				enter = false;
			}

			
			//Check god mode and increment god mode counter.
			if(godMode){
				godModeCounter++;
				if(godModeCounter == 500){
					godMode = false;
					godModeCounter = 0;
				}
			}
						
			//update graphics.
			frame.getContentPane().repaint();
			
			//Limits max fps:
			try {
				Thread.sleep(20); //stops the program for 20 milliseconds before going on, therefore the max fps is 50 fps.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.exit(0);
	}
	
	
	//Input
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
		
		public void KeyEnter(){
			enter = true;
		}
	}	
}