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
	boolean redPresent = false; 
    boolean cyanPresent = false; 
    boolean pinkPresent = false; 
    boolean orangePresent = false; 
    private int lives = 3;
	
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
	
	private int Height = 29;
	private int Width = 25;
	private String [][] Array; //Maybe change to String array? to easier see what is going on.
	
	View view;
	GetLocations getLocations;
	Ghosts ghosts;
	Pacman pacman;
	GameArray gameArray;
	
	public Model(Frame frame){
		Array = new String[Width][Height];
		this.frame = frame;
		frame.setSize(490, 670);
		this.frame.addKeyListener(new KeyHandler(this));
		thread.start();
	}
	
	public void run() {
		
		//Goes once:
		gameArray = new GameArray(Array, Width, Height);
		gameArray.restartGameArray();
		this.Array = gameArray.Array;
		view = new View(Array, gameState, frame, Width, Height, lives, godMode);
		frame.getContentPane().add(view);
		pacman = new Pacman(Array, Width, Height, pacmanPos, godMode, lives);
		getLocations = new GetLocations(Array, Width, Height, pacmanPos, redGhostPos, cyanGhostPos, pinkGhostPos, orangeGhostPos);
		ghosts = new Ghosts(Array, Width, Height, pacmanPos, redGhostPos, cyanGhostPos, pinkGhostPos, orangeGhostPos, godMode, gameState);
		getLocations.getLocationPacMan();
		running = true;
	
		
		//updates:
		while(running){
			
			//check if all ghosts are present, if not they respawn. 
			ghosts.checkIfPresent(redPresent, cyanPresent, pinkPresent, orangePresent);
			
			pacman.movePacman(right, left, up, down);
              
            //Check if the game is won. 
            int numberOfPacDotsRemaining = 0; 
            for(int i = 0; i < Width; i++){ 
                for(int j = 0; j < Height; j++){ 
                    if(Array[i][j].equals("pacDot") || Array[i][j].equals("bigPacDot")){ 
                        numberOfPacDotsRemaining++; 
                    } 
                } 
            } 
            
            if(numberOfPacDotsRemaining == 0){ 
                gameState = "gameWon"; 
            }    
              
            //Increment ghostCounter. 
            ghostCounter++; 
            if(ghostCounter == 50){ 
                ghosts.Movements(); 
                ghostCounter = 0; 
            } 
                  
            //Make so that when the gameover or game won screen is up you can restart by pressing space 
            if(enter){ 
                gameState = "gameOn"; 
                gameArray.restartGameArray(); 
                this.Array = gameArray.Array;
                lives = 3; 
                enter = false; 
            }
              
            if(lives <= 0){ 
                gameState = "gameOver"; 
            }
			
			//update screen variables
            this.lives = pacman.lives;
            this.godMode = pacman.godMode;
			this.pacmanPos = getLocations.pacmanPos;
			this.redGhostPos = getLocations.redGhostPos;
			this.cyanGhostPos = getLocations.cyanGhostPos;
			this.pinkGhostPos = getLocations.pinkGhostPos;
			this.orangeGhostPos = getLocations.orangeGhostPos;
			this.up = pacman.up;
			this.down = pacman.down;
			this.right = pacman.right;
			this.left = pacman.left;
			if(ghosts.gameState == "gameOver"){
				this.gameState = ghosts.gameState;
			} else {
				ghosts.gameState = this.gameState;
			}
			
			//update other class variables
			view.gameState = this.gameState;
			view.godMode = this.godMode;
			view.lives = this.lives;
			ghosts.godMode = this.godMode;
			getLocations.Array = this.Array;
			ghosts.Array = this.Array;
			pacman.Array = this.Array;

			
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