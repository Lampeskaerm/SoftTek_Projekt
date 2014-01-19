package Pacman;
import java.awt.Point;

import javax.swing.JPanel;

public class Model extends JPanel implements Runnable {
	Thread thread = new Thread(this);
	
	PacmanDriver frame;
	public boolean running = false;
	public static String gameState = "gameOn";
	private boolean enter = false;
	public boolean UpperLeftBigPacDot = false;
	public boolean UpperRightBigPacDot = false;
	public boolean lowerLeftBigPacDot = false;
	public boolean lowerRightBigPacDot = false;
	public static boolean godMode = false;
	boolean redPresent = false; 
    boolean cyanPresent = false; 
    boolean pinkPresent = false; 
    boolean orangePresent = false; 
    boolean fruit = false;
    public static int level = 0;
    public static int numberOfPacDotsRemaining = 234;
    int fruitCounter = 0;
	
	//Movement variables.
	public boolean right = false;
	public boolean left = false;
	public boolean up = false;
	public boolean down = false;
	public int ghostCounter = 0;
	
	//direction of ghosts
	public String redDir = "up";
	public String cyanDir = "up";
	public String pinkDir = "up";
	public String orangeDir = "up";
	public String pacmanDir = "up";
	
	//Location variables.
	public Point pacmanPos = new Point();
	public Point redGhostPos = new Point();
	public Point cyanGhostPos = new Point();
	public Point pinkGhostPos = new Point();
	public Point orangeGhostPos = new Point();
	
	private int Height = 31;
	private int Width = 27;
	private String [][] Array; //Maybe change to String array? to easier see what is going on.
	
	Animation animation;
	View view;
	GhostsCalls ghosts;
	Pacman pacman;
	GameArray gameArray;
	PlaySounds playSounds;
	
	public Model(PacmanDriver frame){
		Array = new String[Width][Height];
		this.frame = frame;
		frame.setSize(550, 750);
		this.frame.addKeyListener(new KeyHandler(this));
		playSounds = new PlaySounds();
		playSounds.playSound("pacman_beginning.wav");
		thread.start();
		
	}
	
	public void run() {
		
		//Goes once:
		gameArray = new GameArray(Array, Width, Height);
		gameArray.restartGameArray();
		this.Array = gameArray.Array;
		animation = new Animation(pacmanPos);
		view = new View(Array, frame, Width, Height, redDir, cyanDir, pinkDir, orangeDir, pacmanDir);
		frame.getContentPane().add(animation);
		frame.getContentPane().add(view);
		view.initiateSpriteLoad();
		pacman = new Pacman(pacmanPos, Array, Width, Height);
		pacman.getLocation();
		ghosts = new GhostsCalls(Array, Width, Height, pacmanPos, redGhostPos, cyanGhostPos, pinkGhostPos, orangeGhostPos);
		level = 1;
		running = true;
		
	
		
		//updates:
		while(running){
			int dots = 0;
			for(int i = 0; i < Width; i++){
				for(int j = 0; j < Height; j++){
					if(Array[i][j].endsWith("pacDot") || Array[i][j].endsWith("PacDot")){
						dots++;
					}
				}
			}
			//Check if the level is beat. 
            if(dots == 0){ 
            	try{
    				Thread.sleep(500);
    			} catch (InterruptedException e) {
    				e.printStackTrace();
    			}
            	gameArray.restartGameArray();
                level++; 
            }
			
			pacman.movePacman(right, left, up, down);
                    
            //Fruits
            if(234 - numberOfPacDotsRemaining == 70 || 234 - numberOfPacDotsRemaining == 170){
            	fruit = true;
            	numberOfPacDotsRemaining--;
            }
            
            if(fruit){
            	int random = (int)(Math.random() * 4 + 1);
             	if(random == 1){
             		if(Array[5][5].equals("pacDot")){
             			Array[5][5] = "fruitAndPacDot";
             		}else if(Array[5][5].equals("blackSpace")){
             			Array[5][5] = "fruitAndBlackSpace";
             		}
             	}else if(random == 2){
             		if(Array[24][8].equals("pacDot")){
             			Array[24][8] = "fruitAndPacDot";
             		}else if(Array[24][8].equals("blackSpace")){
             			Array[24][8] = "fruitAndBlackSpace";
             		}
             	}else if(random == 3){
             		if(Array[6][26].equals("pacDot")){
             			Array[6][26] = "fruitAndPacDot";
             		}else if(Array[6][24].equals("blackSpace")){
             			Array[6][26] = "fruitAndBlackSpace";
             		}
             	}else if(random == 4){
             		if(Array[25][20].equals("pacDot")){
             			Array[25][20] = "fruitAndPacDot";
             		}else if(Array[25][20].equals("blackSpace")){
             			Array[25][20] = "fruitAndBlackSpace";
             		}
             	}
            }
            if(fruit || fruitCounter > 0){
            	fruitCounter++;
            	if(fruitCounter == 500){
            		for(int i = 0; i < Width; i++){
            			for(int j = 0; j < Height; j++){
            				if(Array[i][j].equals("fruitAndBlackSpace")){
            					Array[i][j] = "blackSpace";
            				}else if (Array[i][j].equals("fruitAndPacDot")){
            					Array[i][j] = "pacDot";
            				}
            			}
            		}
            	}
            }
            fruit = false;
            
            //checks if pacman is in the game.
            pacman.checkIfPacmanIsPresent();
              
            
            //Increment ghostCounter. 
            //changes the difficulty of the game as the level increases by making the ghosts move faster, ensures endless levels.
            //level 1 = 500ms wait.
            //level 2 = 450ms wait.
            //level 3 = 340ms wait.
            //level 4 = 280ms wait....
            	ghostCounter++; 
            	if(ghostCounter == (int)(50 * Math.pow(1.1, - (level - 1)))){
            		ghosts.Movements(); 
            		ghostCounter = 0; 
            	} 
            
            //Make so that when the gameover.
            if(gameState.equals("gameOver")){
            	if(enter){ 
            		playSounds.playSound("pacman_beginning.wav");
            		gameState = "gameOn";
            		Pacman.fruits = 0;
            		Pacman.lives = 3;
            		Pacman.score = 0;
            		level = 1;
            		ghosts.setAllFalse();
            		gameArray.restartGameArray();
            		this.Array = gameArray.Array;
            		enter = false; 
            	}
            }
            
            if(Pacman.lives <= 0){ 
                gameState = "gameOver"; 
            }
            
			//update screen variables
			this.pacmanPos = pacman.pos;
			this.redGhostPos = ghosts.redGhost.pos;
			this.cyanGhostPos = ghosts.cyanGhost.pos;
			this.pinkGhostPos = ghosts.pinkGhost.pos;
			this.orangeGhostPos = ghosts.orangeGhost.pos;
			this.up = pacman.up;
			this.down = pacman.down;
			this.right = pacman.right;
			this.left = pacman.left;
			
			//update other class variables
			view.pacmanDir = pacmanDir;
			view.redDir = ghosts.redDir;
            view.cyanDir = ghosts.cyanDir;
            view.pinkDir = ghosts.pinkDir;
            view.orangeDir = ghosts.orangeDir;
			ghosts.Array = this.Array;
			pacman.Array = this.Array;

			

			//update graphics.
			frame.getContentPane().repaint();
			
			ghosts.checkIfPresent(redPresent, cyanPresent, pinkPresent, orangePresent);
			
			//Limits max fps:
			try{
				Thread.sleep(10); //stops the program for 10 milliseconds before going on, therefore the max fps is 100 fps.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.exit(10);
	}
	
	
	//Input
	public class KeyTyped{
		public void keyESC(){
			running = false;
		}
		
		public void KeyRight(){
			right = true;
			pacmanDir = "right";
		}
		
		public void KeyLeft(){
			left = true;
			pacmanDir = "left";
		}
		
		public void KeyUp(){
			up = true;
			pacmanDir = "up";
		}
		
		public void KeyDown(){
			down = true;
			pacmanDir = "down";
		}
		
		public void KeyEnter(){
			enter = true;
		}
	}
}