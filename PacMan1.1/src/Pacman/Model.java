package Pacman;
import java.awt.Point;

import javax.swing.JPanel;

public class Model extends JPanel implements Runnable {
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
	
	//Location variables.
	public Point pacmanPos = new Point();
	public Point redGhostPos = new Point();
	public Point cyanGhostPos = new Point();
	public Point pinkGhostPos = new Point();
	public Point orangeGhostPos = new Point();
	private int Height;
	private int Width;
	private String [][] Array; //Maybe change to String array? to easier see what is going on.
	
	View view;
	GetLocations getLocations;
	Ghosts ghosts;
	
	public Model(Frame frame, int Width, int Height){
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
	
	public void run() {
		
		//Goes once:
		restartGameArray();
		view = new View(Array, gameState, frame, Width, Height);
		frame.getContentPane().add(view);
		getLocations = new GetLocations(Array, Width, Height, pacmanPos, redGhostPos, cyanGhostPos, pinkGhostPos, orangeGhostPos);
		ghosts = new Ghosts(Array, Width, Height, pacmanPos, redGhostPos, cyanGhostPos, pinkGhostPos, orangeGhostPos, godMode, gameState);
		
		getLocations.getLocationPacMan();
		running = true;
	
		
		//updates:
		while(running){
			
			//movements:
			//Move right.
			while(right){
				getLocations.getLocationPacMan();
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
				getLocations.getLocationPacMan();
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
				getLocations.getLocationPacMan();
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
				getLocations.getLocationPacMan();
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
				getLocations.getLocationPacMan();
				getLocations.getLocationRedGhost();
				if(pacmanPos.x == redGhostPos.x && pacmanPos.y == redGhostPos.y){
					gameState = "gameOver";
				}
			
				getLocations.getLocationCyanGhost();
				if(pacmanPos.x == cyanGhostPos.x && pacmanPos.y == cyanGhostPos.y){
					gameState =  "gameOver";
				}
			
				getLocations.getLocationPinkGhost();
				if(pacmanPos.x == pinkGhostPos.x && pacmanPos.y == pinkGhostPos.y){
					gameState =  "gameOver";
				}
			
				getLocations.getLocationOrangeGhost();
				if(pacmanPos.x == orangeGhostPos.x && pacmanPos.y == orangeGhostPos.y){
					gameState =  "gameOver";
				}
			}
			if(godMode == true){
				getLocations.getLocationPacMan();
				getLocations.getLocationRedGhost();
				if(pacmanPos.x == redGhostPos.x && pacmanPos.y == redGhostPos.y){
					Array[(int)(Width / 2)][(int)(Height / 2 - 1)] = "redGhostAndBlackSpace";
					getLocations.getLocationRedGhost();
				}
				
				getLocations.getLocationCyanGhost();
				if(pacmanPos.x == cyanGhostPos.x && pacmanPos.y == cyanGhostPos.y){
					Array[(int)(Width / 2 - 1)][(int)(Height / 2)] = "cyanGhostAndBlackSpace";
					getLocations.getLocationCyanGhost();
				}
				
				getLocations.getLocationPinkGhost();
				if(pacmanPos.x == pinkGhostPos.x && pacmanPos.y == pinkGhostPos.y){
					Array[(int)(Width / 2)][(int)(Height / 2)] = "pinkGhostAndBlackSpace";
					getLocations.getLocationPinkGhost();
				}
				
				getLocations.getLocationOrangeGhost();
				if(pacmanPos.x == orangeGhostPos.x && pacmanPos.y == orangeGhostPos.y){
					Array[(int)(Width / 2 + 1)][(int)(Height / 2)] = "orangeGhostAndBlackSpace";
					getLocations.getLocationOrangeGhost();
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
			
			//update screen variables
			pacmanPos = getLocations.pacmanPos;
			redGhostPos = getLocations.redGhostPos;
			cyanGhostPos = getLocations.cyanGhostPos;
			pinkGhostPos = getLocations.pinkGhostPos;
			orangeGhostPos = getLocations.orangeGhostPos;
			if(ghosts.gameState == "gameOver"){
				gameState = ghosts.gameState;
			}
			
			//update other class variables
			view.gameState = gameState;
			ghosts.godMode = godMode;
			getLocations.Array = Array;
			ghosts.Array = Array;

			
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