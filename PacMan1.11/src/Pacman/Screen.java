package Pacman;
import java.awt.Point;

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
	DirectionGenerator dirGen;
	String randomMovement = "";
	
	PinkGhostLocation pinkGhostLoc;
	CyanGhostLocation cyanGhostLoc;
	RedGhostLocation redGhostLoc;
	OrangeGhostLocation orangeGhostLoc;
	PacmanLocation pacmanLoc;
	Ghosts ghosts;
	
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
	
	public void run() {
		
		//Goes once:
		restartGameArray();
		view = new View(Array, gameState, frame, Width, Height);
		frame.getContentPane().add(view);
		getLocations = new GetLocations(Array, Width, Height, pacmanPos, redGhostPos, cyanGhostPos, pinkGhostPos, orangeGhostPos);
//		dirGen = new DirectionGenerator();
//		pinkGhostLoc = new PinkGhostLocation(Array, Width, Height, pinkGhostPos);
//		pacmanLoc = new PacmanLocation(Array, Width, Height, pacmanPos);
//		cyanGhostLoc = new CyanGhostLocation(Array, Width, Height, cyanGhostPos);
//		redGhostLoc = new RedGhostLocation(Array, Width, Height, redGhostPos);
//		orangeGhostLoc = new OrangeGhostLocation(Array, Width, Height, orangeGhostPos);
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
			this.pacmanPos = getLocations.pacmanPos;
			this.redGhostPos = getLocations.redGhostPos;
			this.cyanGhostPos = getLocations.cyanGhostPos;
			this.pinkGhostPos = getLocations.pinkGhostPos;
			this.orangeGhostPos = getLocations.orangeGhostPos;
			if(ghosts.gameState == "gameOver"){
				this.gameState = ghosts.gameState;
			} else {
				ghosts.gameState = this.gameState;
			}
			
			//update other class variables
			view.gameState = this.gameState;
			ghosts.godMode = this.godMode;
			getLocations.Array = this.Array;
			ghosts.Array = this.Array;

			
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
//	public void randomDirection(){
//		 int random = (int)(Math.random() * 4 + 1);
//		 if(random == 1){
//			 randomMovement = "moveRight";
//		 }else if(random == 2){
//			 randomMovement = "moveLeft";
//		 }else if(random == 3){
//			 randomMovement = "moveDown";
//		 }else if(random == 4){
//			 randomMovement = "moveUp";
//		 }
//	}
//	
//	public void movementGhosts(){
//		String redGhost = "";
//		String cyanGhost = "";
//		String pinkGhost = "";
//		String orangeGhost = "";
//		
//		
//		//Red ghost controls:
//				dirGen.randomDirection();
//				redGhost = dirGen.randomMovement;
//				redGhostLoc.getLocation();
//				
//				//move right.
//				if(redGhost.equals("moveRight")){
//					if(redGhostPos.x < Width - 1){
//						redGhostLoc.getLocation();
//						pacmanLoc.getLocation();
//						if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndPacDot") && Array[redGhostPos.x + 1][redGhostPos.y].equals("pacDot")){
//							Array[redGhostPos.x + 1][redGhostPos.y] = "redGhostAndPacDot";
//							Array[redGhostPos.x][redGhostPos.y] = "pacDot";
//							
//						}else if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndPacDot") && Array[redGhostPos.x + 1][redGhostPos.y].equals("blackSpace")){
//							Array[redGhostPos.x + 1][redGhostPos.y] = "redGhostAndBlackSpace";
//							Array[redGhostPos.x][redGhostPos.y] = "pacDot";
//												
//						}else if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndBlackSpace") && Array[redGhostPos.x + 1][redGhostPos.y].equals("blackSpace")){
//							Array[redGhostPos.x + 1][redGhostPos.y] = "redGhostAndBlackSpace";
//							Array[redGhostPos.x][redGhostPos.y] = "blackSpace";
//															
//						}else if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndBlackSpace") && Array[redGhostPos.x + 1][redGhostPos.y].equals("pacDot")){
//							Array[redGhostPos.x + 1][redGhostPos.y] = "redGhostAndPacDot";
//							Array[redGhostPos.x][redGhostPos.y] = "blackSpace";
//							
//						}else if(!godMode){
//							if(Array[redGhostPos.x + 1][redGhostPos.y].equals("pacMan")){
//							gameState = "gameOver";
//							}
//						}
//					}
//				}
//						
//						
//				//move left.
//				if(redGhost.equals("moveLeft")){
//					if(redGhostPos.x > 0){
//						redGhostLoc.getLocation();
//						pacmanLoc.getLocation();
//						if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndPacDot") && Array[redGhostPos.x - 1][redGhostPos.y].equals("pacDot")){
//							Array[redGhostPos.x - 1][redGhostPos.y] = "redGhostAndPacDot";
//							Array[redGhostPos.x][redGhostPos.y] = "pacDot";
//							
//						}else if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndPacDot") && Array[redGhostPos.x - 1][redGhostPos.y].equals("blackSpace")){
//							Array[redGhostPos.x - 1][redGhostPos.y] = "redGhostAndBlackSpace";
//							Array[redGhostPos.x][redGhostPos.y] = "pacDot";
//													
//						}else if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndBlackSpace") && Array[redGhostPos.x - 1][redGhostPos.y].equals("blackSpace")){
//							Array[redGhostPos.x - 1][redGhostPos.y] = "redGhostAndBlackSpace";
//							Array[redGhostPos.x][redGhostPos.y] = "blackSpace";
//													
//						}else if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndBlackSpace") && Array[redGhostPos.x - 1][redGhostPos.y].equals("pacDot")){
//							Array[redGhostPos.x - 1][redGhostPos.y] = "redGhostAndPacDot";
//							Array[redGhostPos.x][redGhostPos.y] = "blackSpace";
//									
//						}else if(!godMode){
//							if(Array[redGhostPos.x - 1][redGhostPos.y].equals("pacMan")){
//							gameState = "gameOver";
//							}
//						}
//					}
//				}
//					
//					
//				//move up.
//				if(redGhost.equals("moveUp")){
//					if(redGhostPos.y > 0){
//						redGhostLoc.getLocation();
//						pacmanLoc.getLocation();
//						if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndPacDot") && Array[redGhostPos.x][redGhostPos.y - 1].equals("pacDot")){
//							Array[redGhostPos.x][redGhostPos.y - 1] = "redGhostAndPacDot";
//							Array[redGhostPos.x][redGhostPos.y] = "pacDot";
//							
//						}else if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndPacDot") && Array[redGhostPos.x][redGhostPos.y - 1].equals("blackSpace")){
//							Array[redGhostPos.x][redGhostPos.y - 1] = "redGhostAndBlackSpace";
//							Array[redGhostPos.x][redGhostPos.y] = "pacDot";
//													
//						}else if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndBlackSpace") && Array[redGhostPos.x][redGhostPos.y - 1].equals("blackSpace")){
//							Array[redGhostPos.x][redGhostPos.y - 1] = "redGhostAndBlackSpace";
//							Array[redGhostPos.x][redGhostPos.y] = "blackSpace";
//													
//						}else if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndBlackSpace") && Array[redGhostPos.x][redGhostPos.y - 1].equals("pacDot")){
//							Array[redGhostPos.x][redGhostPos.y - 1] = "redGhostAndPacDot";
//							Array[redGhostPos.x][redGhostPos.y] = "blackSpace";
//							
//						}else if(!godMode){
//							if(Array[redGhostPos.x][redGhostPos.y - 1].equals("pacMan")){
//								gameState = "gameOver";
//							}
//						}
//					}
//				}
//					
//						
//				//move down.
//				if(redGhost.equals("moveDown")){
//					if(redGhostPos.y < Height - 1){
//						redGhostLoc.getLocation();
//						pacmanLoc.getLocation();
//						if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndPacDot") && Array[redGhostPos.x][redGhostPos.y + 1].equals("pacDot")){
//							Array[redGhostPos.x][redGhostPos.y + 1] = "redGhostAndPacDot";
//							Array[redGhostPos.x][redGhostPos.y] = "pacDot";
//										
//						}else if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndPacDot") && Array[redGhostPos.x][redGhostPos.y + 1].equals("blackSpace")){
//							Array[redGhostPos.x][redGhostPos.y + 1] = "redGhostAndBlackSpace";
//							Array[redGhostPos.x][redGhostPos.y] = "pacDot";
//															
//						}else if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndBlackSpace") && Array[redGhostPos.x][redGhostPos.y + 1].equals("blackSpace")){
//							Array[redGhostPos.x][redGhostPos.y + 1] = "redGhostAndBlackSpace";
//							Array[redGhostPos.x][redGhostPos.y] = "blackSpace";
//													
//						}else if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndBlackSpace") && Array[redGhostPos.x][redGhostPos.y + 1].equals("pacDot")){
//							Array[redGhostPos.x][redGhostPos.y + 1] = "redGhostAndPacDot";
//							Array[redGhostPos.x][redGhostPos.y] = "blackSpace";
//							
//						}else if(!godMode){
//							if(Array[redGhostPos.x][redGhostPos.y + 1].equals("pacMan")){
//								gameState = "gameOver";
//							}
//						}
//					}
//				}
//				
//				
//	//Cyan ghost controls:
//			cyanGhost = dirGen.randomMovement;
//			cyanGhostLoc.getLocation();
//			
//			//move right.
//			if(cyanGhost.equals("moveRight")){
//				if(cyanGhostPos.x < Width - 1){
//					cyanGhostLoc.getLocation();
//					pacmanLoc.getLocation();
//					if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndPacDot") && Array[cyanGhostPos.x + 1][cyanGhostPos.y].equals("pacDot")){
//						Array[cyanGhostPos.x + 1][cyanGhostPos.y] = "cyanGhostAndPacDot";
//						Array[cyanGhostPos.x][cyanGhostPos.y] = "pacDot";
//						
//					}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndPacDot") && Array[cyanGhostPos.x + 1][cyanGhostPos.y].equals("blackSpace")){
//						Array[cyanGhostPos.x + 1][cyanGhostPos.y] = "cyanGhostAndBlackSpace";
//						Array[cyanGhostPos.x][cyanGhostPos.y] = "pacDot";
//											
//					}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndBlackSpace") && Array[cyanGhostPos.x + 1][cyanGhostPos.y].equals("blackSpace")){
//						Array[cyanGhostPos.x + 1][cyanGhostPos.y] = "cyanGhostAndBlackSpace";
//						Array[cyanGhostPos.x][cyanGhostPos.y] = "blackSpace";
//														
//					}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndBlackSpace") && Array[cyanGhostPos.x + 1][cyanGhostPos.y].equals("pacDot")){
//						Array[cyanGhostPos.x + 1][cyanGhostPos.y] = "cyanGhostAndPacDot";
//						Array[cyanGhostPos.x][cyanGhostPos.y] = "blackSpace";
//						
//					}else if(!godMode){
//						if(Array[cyanGhostPos.x + 1][cyanGhostPos.y].equals("pacMan")){
//						gameState = "gameOver";
//						}
//					}
//				}
//			}
//					
//					
//			//move left.
//			if(cyanGhost.equals("moveLeft")){
//				if(cyanGhostPos.x > 0){
//					cyanGhostLoc.getLocation();
//					pacmanLoc.getLocation();
//					if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndPacDot") && Array[cyanGhostPos.x - 1][cyanGhostPos.y].equals("pacDot")){
//						Array[cyanGhostPos.x - 1][cyanGhostPos.y] = "cyanGhostAndPacDot";
//						Array[cyanGhostPos.x][cyanGhostPos.y] = "pacDot";
//						
//					}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndPacDot") && Array[cyanGhostPos.x - 1][cyanGhostPos.y].equals("blackSpace")){
//						Array[cyanGhostPos.x - 1][cyanGhostPos.y] = "cyanGhostAndBlackSpace";
//						Array[cyanGhostPos.x][cyanGhostPos.y] = "pacDot";
//												
//					}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndBlackSpace") && Array[cyanGhostPos.x - 1][cyanGhostPos.y].equals("blackSpace")){
//						Array[cyanGhostPos.x - 1][cyanGhostPos.y] = "cyanGhostAndBlackSpace";
//						Array[cyanGhostPos.x][cyanGhostPos.y] = "blackSpace";
//												
//					}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndBlackSpace") && Array[cyanGhostPos.x - 1][cyanGhostPos.y].equals("pacDot")){
//						Array[cyanGhostPos.x - 1][cyanGhostPos.y] = "cyanGhostAndPacDot";
//						Array[cyanGhostPos.x][cyanGhostPos.y] = "blackSpace";
//								
//					}else if(!godMode){
//						if(Array[cyanGhostPos.x - 1][cyanGhostPos.y].equals("pacMan")){
//						gameState = "gameOver";
//						}
//					}
//				}
//			}
//				
//				
//			//move up.
//			if(cyanGhost.equals("moveUp")){
//				if(cyanGhostPos.y > 0){
//					cyanGhostLoc.getLocation();
//					pacmanLoc.getLocation();
//					if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndPacDot") && Array[cyanGhostPos.x][cyanGhostPos.y - 1].equals("pacDot")){
//						Array[cyanGhostPos.x][cyanGhostPos.y - 1] = "cyanGhostAndPacDot";
//						Array[cyanGhostPos.x][cyanGhostPos.y] = "pacDot";
//						
//					}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndPacDot") && Array[cyanGhostPos.x][cyanGhostPos.y - 1].equals("blackSpace")){
//						Array[cyanGhostPos.x][cyanGhostPos.y - 1] = "cyanGhostAndBlackSpace";
//						Array[cyanGhostPos.x][cyanGhostPos.y] = "pacDot";
//												
//					}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndBlackSpace") && Array[cyanGhostPos.x][cyanGhostPos.y - 1].equals("blackSpace")){
//						Array[cyanGhostPos.x][cyanGhostPos.y - 1] = "cyanGhostAndBlackSpace";
//						Array[cyanGhostPos.x][cyanGhostPos.y] = "blackSpace";
//												
//					}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndBlackSpace") && Array[cyanGhostPos.x][cyanGhostPos.y - 1].equals("pacDot")){
//						Array[cyanGhostPos.x][cyanGhostPos.y - 1] = "cyanGhostAndPacDot";
//						Array[cyanGhostPos.x][cyanGhostPos.y] = "blackSpace";
//						
//					}else if(!godMode){
//						if(Array[cyanGhostPos.x][cyanGhostPos.y - 1].equals("pacMan")){
//							gameState = "gameOver";
//						}
//					}
//				}
//			}
//				
//					
//			//move down.
//			if(cyanGhost.equals("moveDown")){
//				if(cyanGhostPos.y < Height - 1){
//					cyanGhostLoc.getLocation();
//					pacmanLoc.getLocation();
//					if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndPacDot") && Array[cyanGhostPos.x][cyanGhostPos.y + 1].equals("pacDot")){
//						Array[cyanGhostPos.x][cyanGhostPos.y + 1] = "cyanGhostAndPacDot";
//						Array[cyanGhostPos.x][cyanGhostPos.y] = "pacDot";
//									
//					}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndPacDot") && Array[cyanGhostPos.x][cyanGhostPos.y + 1].equals("blackSpace")){
//						Array[cyanGhostPos.x][cyanGhostPos.y + 1] = "cyanGhostAndBlackSpace";
//						Array[cyanGhostPos.x][cyanGhostPos.y] = "pacDot";
//														
//					}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndBlackSpace") && Array[cyanGhostPos.x][cyanGhostPos.y + 1].equals("blackSpace")){
//						Array[cyanGhostPos.x][cyanGhostPos.y + 1] = "cyanGhostAndBlackSpace";
//						Array[cyanGhostPos.x][cyanGhostPos.y] = "blackSpace";
//												
//					}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndBlackSpace") && Array[cyanGhostPos.x][cyanGhostPos.y + 1].equals("pacDot")){
//						Array[cyanGhostPos.x][cyanGhostPos.y + 1] = "cyanGhostAndPacDot";
//						Array[cyanGhostPos.x][cyanGhostPos.y] = "blackSpace";
//						
//					}else if(!godMode){
//						if(Array[cyanGhostPos.x][cyanGhostPos.y + 1].equals("pacMan")){
//							gameState = "gameOver";
//						}
//					}
//				}
//			}
//						
////Pink ghost controls:
//		pinkGhost = dirGen.randomMovement;
//		pinkGhostLoc.getLocation();
//		
//		//move right.
//		if(pinkGhost.equals("moveRight")){
//			if(pinkGhostPos.x < Width - 1){
//				pinkGhostLoc.getLocation();
//				pacmanLoc.getLocation();
//				if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndPacDot") && Array[pinkGhostPos.x + 1][pinkGhostPos.y].equals("pacDot")){
//					Array[pinkGhostPos.x + 1][pinkGhostPos.y] = "pinkGhostAndPacDot";
//					Array[pinkGhostPos.x][pinkGhostPos.y] = "pacDot";
//					
//				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndPacDot") && Array[pinkGhostPos.x + 1][pinkGhostPos.y].equals("blackSpace")){
//					Array[pinkGhostPos.x + 1][pinkGhostPos.y] = "pinkGhostAndBlackSpace";
//					Array[pinkGhostPos.x][pinkGhostPos.y] = "pacDot";
//										
//				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndBlackSpace") && Array[pinkGhostPos.x + 1][pinkGhostPos.y].equals("blackSpace")){
//					Array[pinkGhostPos.x + 1][pinkGhostPos.y] = "pinkGhostAndBlackSpace";
//					Array[pinkGhostPos.x][pinkGhostPos.y] = "blackSpace";
//													
//				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndBlackSpace") && Array[pinkGhostPos.x + 1][pinkGhostPos.y].equals("pacDot")){
//					Array[pinkGhostPos.x + 1][pinkGhostPos.y] = "pinkGhostAndPacDot";
//					Array[pinkGhostPos.x][pinkGhostPos.y] = "blackSpace";
//					
//				}else if(!godMode){
//					if(Array[pinkGhostPos.x + 1][pinkGhostPos.y].equals("pacMan")){
//					gameState = "gameOver";
//					}
//				}
//			}
//		}
//				
//				
//		//move left.
//		if(pinkGhost.equals("moveLeft")){
//			if(pinkGhostPos.x > 0){
//				pinkGhostLoc.getLocation();
//				pacmanLoc.getLocation();
//				if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndPacDot") && Array[pinkGhostPos.x - 1][pinkGhostPos.y].equals("pacDot")){
//					Array[pinkGhostPos.x - 1][pinkGhostPos.y] = "pinkGhostAndPacDot";
//					Array[pinkGhostPos.x][pinkGhostPos.y] = "pacDot";
//					
//				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndPacDot") && Array[pinkGhostPos.x - 1][pinkGhostPos.y].equals("blackSpace")){
//					Array[pinkGhostPos.x - 1][pinkGhostPos.y] = "pinkGhostAndBlackSpace";
//					Array[pinkGhostPos.x][pinkGhostPos.y] = "pacDot";
//											
//				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndBlackSpace") && Array[pinkGhostPos.x - 1][pinkGhostPos.y].equals("blackSpace")){
//					Array[pinkGhostPos.x - 1][pinkGhostPos.y] = "pinkGhostAndBlackSpace";
//					Array[pinkGhostPos.x][pinkGhostPos.y] = "blackSpace";
//											
//				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndBlackSpace") && Array[pinkGhostPos.x - 1][pinkGhostPos.y].equals("pacDot")){
//					Array[pinkGhostPos.x - 1][pinkGhostPos.y] = "pinkGhostAndPacDot";
//					Array[pinkGhostPos.x][pinkGhostPos.y] = "blackSpace";
//							
//				}else if(!godMode){
//					if(Array[pinkGhostPos.x - 1][pinkGhostPos.y].equals("pacMan")){
//					gameState = "gameOver";
//					}
//				}
//			}
//		}
//			
//			
//		//move up.
//		if(pinkGhost.equals("moveUp")){
//			if(pinkGhostPos.y > 0){
//				pinkGhostLoc.getLocation();
//				pacmanLoc.getLocation();
//				if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndPacDot") && Array[pinkGhostPos.x][pinkGhostPos.y - 1].equals("pacDot")){
//					Array[pinkGhostPos.x][pinkGhostPos.y - 1] = "pinkGhostAndPacDot";
//					Array[pinkGhostPos.x][pinkGhostPos.y] = "pacDot";
//					
//				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndPacDot") && Array[pinkGhostPos.x][pinkGhostPos.y - 1].equals("blackSpace")){
//					Array[pinkGhostPos.x][pinkGhostPos.y - 1] = "pinkGhostAndBlackSpace";
//					Array[pinkGhostPos.x][pinkGhostPos.y] = "pacDot";
//											
//				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndBlackSpace") && Array[pinkGhostPos.x][pinkGhostPos.y - 1].equals("blackSpace")){
//					Array[pinkGhostPos.x][pinkGhostPos.y - 1] = "pinkGhostAndBlackSpace";
//					Array[pinkGhostPos.x][pinkGhostPos.y] = "blackSpace";
//											
//				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndBlackSpace") && Array[pinkGhostPos.x][pinkGhostPos.y - 1].equals("pacDot")){
//					Array[pinkGhostPos.x][pinkGhostPos.y - 1] = "pinkGhostAndPacDot";
//					Array[pinkGhostPos.x][pinkGhostPos.y] = "blackSpace";
//					
//				}else if(!godMode){
//					if(Array[pinkGhostPos.x][pinkGhostPos.y - 1].equals("pacMan")){
//						gameState = "gameOver";
//					}
//				}
//			}
//		}
//			
//				
//		//move down.
//		if(pinkGhost.equals("moveDown")){
//			if(pinkGhostPos.y < Height - 1){
//				pinkGhostLoc.getLocation();
//				pacmanLoc.getLocation();
//				if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndPacDot") && Array[pinkGhostPos.x][pinkGhostPos.y + 1].equals("pacDot")){
//					Array[pinkGhostPos.x][pinkGhostPos.y + 1] = "pinkGhostAndPacDot";
//					Array[pinkGhostPos.x][pinkGhostPos.y] = "pacDot";
//								
//				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndPacDot") && Array[pinkGhostPos.x][pinkGhostPos.y + 1].equals("blackSpace")){
//					Array[pinkGhostPos.x][pinkGhostPos.y + 1] = "pinkGhostAndBlackSpace";
//					Array[pinkGhostPos.x][pinkGhostPos.y] = "pacDot";
//													
//				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndBlackSpace") && Array[pinkGhostPos.x][pinkGhostPos.y + 1].equals("blackSpace")){
//					Array[pinkGhostPos.x][pinkGhostPos.y + 1] = "pinkGhostAndBlackSpace";
//					Array[pinkGhostPos.x][pinkGhostPos.y] = "blackSpace";
//											
//				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndBlackSpace") && Array[pinkGhostPos.x][pinkGhostPos.y + 1].equals("pacDot")){
//					Array[pinkGhostPos.x][pinkGhostPos.y + 1] = "pinkGhostAndPacDot";
//					Array[pinkGhostPos.x][pinkGhostPos.y] = "blackSpace";
//					
//				}else if(!godMode){
//					if(Array[pinkGhostPos.x][pinkGhostPos.y + 1].equals("pacMan")){
//						gameState = "gameOver";
//					}
//				}
//			}
//		}
//								
//		//Orange ghost controls:
//				orangeGhost = dirGen.randomMovement;
//				orangeGhostLoc.getLocation();
//				
//				//move right.
//				if(orangeGhost.equals("moveRight")){
//					if(orangeGhostPos.x < Width - 1){
//						orangeGhostLoc.getLocation();
//						pacmanLoc.getLocation();
//						if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndPacDot") && Array[orangeGhostPos.x + 1][orangeGhostPos.y].equals("pacDot")){
//							Array[orangeGhostPos.x + 1][orangeGhostPos.y] = "orangeGhostAndPacDot";
//							Array[orangeGhostPos.x][orangeGhostPos.y] = "pacDot";
//							
//						}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndPacDot") && Array[orangeGhostPos.x + 1][orangeGhostPos.y].equals("blackSpace")){
//							Array[orangeGhostPos.x + 1][orangeGhostPos.y] = "orangeGhostAndBlackSpace";
//							Array[orangeGhostPos.x][orangeGhostPos.y] = "pacDot";
//												
//						}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndBlackSpace") && Array[orangeGhostPos.x + 1][orangeGhostPos.y].equals("blackSpace")){
//							Array[orangeGhostPos.x + 1][orangeGhostPos.y] = "orangeGhostAndBlackSpace";
//							Array[orangeGhostPos.x][orangeGhostPos.y] = "blackSpace";
//															
//						}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndBlackSpace") && Array[orangeGhostPos.x + 1][orangeGhostPos.y].equals("pacDot")){
//							Array[orangeGhostPos.x + 1][orangeGhostPos.y] = "orangeGhostAndPacDot";
//							Array[orangeGhostPos.x][orangeGhostPos.y] = "blackSpace";
//							
//						}else if(!godMode){
//							if(Array[orangeGhostPos.x + 1][orangeGhostPos.y].equals("pacMan")){
//							gameState = "gameOver";
//							}
//						}
//					}
//				}
//						
//						
//				//move left.
//				if(orangeGhost.equals("moveLeft")){
//					if(orangeGhostPos.x > 0){
//						orangeGhostLoc.getLocation();
//						pacmanLoc.getLocation();
//						if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndPacDot") && Array[orangeGhostPos.x - 1][orangeGhostPos.y].equals("pacDot")){
//							Array[orangeGhostPos.x - 1][orangeGhostPos.y] = "orangeGhostAndPacDot";
//							Array[orangeGhostPos.x][orangeGhostPos.y] = "pacDot";
//							
//						}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndPacDot") && Array[orangeGhostPos.x - 1][orangeGhostPos.y].equals("blackSpace")){
//							Array[orangeGhostPos.x - 1][orangeGhostPos.y] = "orangeGhostAndBlackSpace";
//							Array[orangeGhostPos.x][orangeGhostPos.y] = "pacDot";
//													
//						}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndBlackSpace") && Array[orangeGhostPos.x - 1][orangeGhostPos.y].equals("blackSpace")){
//							Array[orangeGhostPos.x - 1][orangeGhostPos.y] = "orangeGhostAndBlackSpace";
//							Array[orangeGhostPos.x][orangeGhostPos.y] = "blackSpace";
//													
//						}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndBlackSpace") && Array[orangeGhostPos.x - 1][orangeGhostPos.y].equals("pacDot")){
//							Array[orangeGhostPos.x - 1][orangeGhostPos.y] = "orangeGhostAndPacDot";
//							Array[orangeGhostPos.x][orangeGhostPos.y] = "blackSpace";
//									
//						}else if(!godMode){
//							if(Array[orangeGhostPos.x - 1][orangeGhostPos.y].equals("pacMan")){
//							gameState = "gameOver";
//							}
//						}
//					}
//				}
//					
//					
//				//move up.
//				if(orangeGhost.equals("moveUp")){
//					if(orangeGhostPos.y > 0){
//						orangeGhostLoc.getLocation();
//						pacmanLoc.getLocation();
//						if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndPacDot") && Array[orangeGhostPos.x][orangeGhostPos.y - 1].equals("pacDot")){
//							Array[orangeGhostPos.x][orangeGhostPos.y - 1] = "orangeGhostAndPacDot";
//							Array[orangeGhostPos.x][orangeGhostPos.y] = "pacDot";
//							
//						}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndPacDot") && Array[orangeGhostPos.x][orangeGhostPos.y - 1].equals("blackSpace")){
//							Array[orangeGhostPos.x][orangeGhostPos.y - 1] = "orangeGhostAndBlackSpace";
//							Array[orangeGhostPos.x][orangeGhostPos.y] = "pacDot";
//													
//						}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndBlackSpace") && Array[orangeGhostPos.x][orangeGhostPos.y - 1].equals("blackSpace")){
//							Array[orangeGhostPos.x][orangeGhostPos.y - 1] = "orangeGhostAndBlackSpace";
//							Array[orangeGhostPos.x][orangeGhostPos.y] = "blackSpace";
//													
//						}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndBlackSpace") && Array[orangeGhostPos.x][orangeGhostPos.y - 1].equals("pacDot")){
//							Array[orangeGhostPos.x][orangeGhostPos.y - 1] = "orangeGhostAndPacDot";
//							Array[orangeGhostPos.x][orangeGhostPos.y] = "blackSpace";
//							
//						}else if(!godMode){
//							if(Array[orangeGhostPos.x][orangeGhostPos.y - 1].equals("pacMan")){
//								gameState = "gameOver";
//							}
//						}
//					}
//				}
//					
//						
//				//move down.
//				if(orangeGhost.equals("moveDown")){
//					if(orangeGhostPos.y < Height - 1){
//						orangeGhostLoc.getLocation();
//						pacmanLoc.getLocation();
//						if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndPacDot") && Array[orangeGhostPos.x][orangeGhostPos.y + 1].equals("pacDot")){
//							Array[orangeGhostPos.x][orangeGhostPos.y + 1] = "orangeGhostAndPacDot";
//							Array[orangeGhostPos.x][orangeGhostPos.y] = "pacDot";
//										
//						}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndPacDot") && Array[orangeGhostPos.x][orangeGhostPos.y + 1].equals("blackSpace")){
//							Array[orangeGhostPos.x][orangeGhostPos.y + 1] = "orangeGhostAndBlackSpace";
//							Array[orangeGhostPos.x][orangeGhostPos.y] = "pacDot";
//															
//						}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndBlackSpace") && Array[orangeGhostPos.x][orangeGhostPos.y + 1].equals("blackSpace")){
//							Array[orangeGhostPos.x][orangeGhostPos.y + 1] = "orangeGhostAndBlackSpace";
//							Array[orangeGhostPos.x][orangeGhostPos.y] = "blackSpace";
//													
//						}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndBlackSpace") && Array[orangeGhostPos.x][orangeGhostPos.y + 1].equals("pacDot")){
//							Array[orangeGhostPos.x][orangeGhostPos.y + 1] = "orangeGhostAndPacDot";
//							Array[orangeGhostPos.x][orangeGhostPos.y] = "blackSpace";
//							
//						}else if(!godMode){
//							if(Array[orangeGhostPos.x][orangeGhostPos.y + 1].equals("pacMan")){
//								gameState = "gameOver";
//							}
//						}
//					}
//				}
//	}
}