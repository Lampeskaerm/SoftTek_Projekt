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
		pacman = new Pacman(Array, Width, Height, godMode, pacmanPos, right, left, up, down);
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
			
			//check if all ghosts are present, if not they respawn. 
            for(int i = 0; i < 24; i++){ 
                for(int j = 0; j < 29; j++){ 
                    if(Array[i][j].equals("redGhostAndPacDot") || Array[i][j].equals("redGhostAndBlackSpace")){ 
                        redPresent = true; 
                    } 
                    if(Array[i][j].equals("cyanGhostAndPacDot") || Array[i][j].equals("cyanGhostAndBlackSpace")){ 
                        cyanPresent = true; 
                          
                    } 
                    if(Array[i][j].equals("pinkGhostAndPacDot") || Array[i][j].equals("pinkGhostAndBlackSpace")){ 
                        pinkPresent = true; 
                          
                    } 
                    if(Array[i][j].equals("orangeGhostAndPacDot") || Array[i][j].equals("orangeGhostAndBlackSpace")){ 
                        orangePresent = true; 
                          
                    } 
                } 
            } 
           if(!redPresent){ 
                Array[(int)(Width / 2)][(int)(Height / 2 - 2)] = "redGhostAndBlackSpace"; 
            } 
            redPresent = false; 
             if(!cyanPresent){ 
                Array[(int)(Width / 2 - 1)][(int)(Height / 2 - 1)] = "cyanGhostAndBlackSpace"; 
            } 
            cyanPresent = false; 
            if(!pinkPresent){ 
                Array[(int)(Width / 2)][(int)(Height / 2 - 1)] = "pinkGhostAndBlackSpace"; 
            } 
            pinkPresent = false; 
            if(!orangePresent){ 
                Array[(int)(Width / 2 + 1)][(int)(Height / 2 - 1)] = "orangeGhostAndBlackSpace"; 
            } 
            orangePresent = false;
			ghosts.checkIfPresent(redPresent, cyanPresent, pinkPresent, orangePresent);
  
            //movements: 
            //Move right. 
            while(right){ 
                getLocations.getLocationPacMan(); 
                if(pacmanPos.x < Width - 1){ 
                    if(pacmanPos.x + 1 == 10 && pacmanPos.y == 13){ 
                        right = false; 
                    }else{ 
                        if(Array[pacmanPos.x + 1][pacmanPos.y].equals("bigPacDot")){ 
                            godMode = true; 
                            Array[pacmanPos.x + 1][pacmanPos.y] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                            right = false; 
                        }else if(Array[pacmanPos.x + 1][pacmanPos.y].equals("pacDot") || Array[pacmanPos.x + 1][pacmanPos.y].equals("blackSpace")){ 
                            Array[pacmanPos.x + 1][pacmanPos.y] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                            right = false; 
                        }else if(Array[pacmanPos.x + 1][pacmanPos.y].equals("Wall")){ 
                            right = false; 
                        }else if(Array[pacmanPos.x + 1][pacmanPos.y].equals("redGhostAndPacDot") || Array[pacmanPos.x + 1][pacmanPos.y].equals("cyanGhostAndPacDot") || Array[pacmanPos.x + 1][pacmanPos.y].equals("pinkGhostAndPacDot") || Array[pacmanPos.x + 1][pacmanPos.y].equals("orangeGhostAndPacDot")){ 
                            if(godMode){ 
                                Array[pacmanPos.x + 1][pacmanPos.y] = "pacMan"; 
                                Array[pacmanPos.x][pacmanPos.y] = "pacDot"; 
                            } 
                            if(!godMode){ 
                                Array[pacmanPos.x][pacmanPos.y] = "pacDot"; 
                                ResetPacManAndLoseLife(); 
                            } 
                            right = false; 
                        }else if(Array[pacmanPos.x + 1][pacmanPos.y].equals("redGhostAndBlackSpace") || Array[pacmanPos.x + 1][pacmanPos.y].equals("cyanGhostAndBlackSpace") || Array[pacmanPos.x + 1][pacmanPos.y].equals("pinkGhostAndBlackSpace") || Array[pacmanPos.x + 1][pacmanPos.y].equals("orangeGhostAndBlackSpace")){ 
                            if(godMode){ 
                                Array[pacmanPos.x + 1][pacmanPos.y] = "pacMan"; 
                                Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                            } 
                            if(!godMode){ 
                                Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                                ResetPacManAndLoseLife(); 
                            } 
                            right = false; 
                        }else if(Array[pacmanPos.x + 1][pacmanPos.y].equals("portal")){ 
                            Array[1][13] = "pacMan"; 
                            Array[23][13] = "blackSpace"; 
                            right = false; 
                        }else{ 
                            right = false; 
                        } 
                    } 
                } 
            } 
              
              
            //Move left. 
            while(left){ 
                getLocations.getLocationPacMan(); 
                if(pacmanPos.x > 0){ 
                    if(pacmanPos.x - 1 == 14 && pacmanPos.y == 13){ 
                        left = false; 
                    }else{ 
                        if(Array[pacmanPos.x - 1][pacmanPos.y].equals("bigPacDot")){ 
                            godMode = true; 
                            Array[pacmanPos.x - 1][pacmanPos.y] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                            left = false; 
                        }else if(Array[pacmanPos.x - 1][pacmanPos.y].equals("pacDot") || Array[pacmanPos.x - 1][pacmanPos.y].equals("blackSpace") || Array[pacmanPos.x - 1][pacmanPos.y].equals("bigPacDot")){ 
                            Array[pacmanPos.x - 1][pacmanPos.y] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                            left = false; 
                        }else if(Array[pacmanPos.x - 1][pacmanPos.y].equals("Wall")){ 
                            left = false; 
                        }else if(Array[pacmanPos.x - 1][pacmanPos.y].equals("redGhostAndPacDot") || Array[pacmanPos.x - 1][pacmanPos.y].equals("cyanGhostAndPacDot") || Array[pacmanPos.x - 1][pacmanPos.y].equals("pinkGhostAndPacDot") || Array[pacmanPos.x - 1][pacmanPos.y].equals("orangeGhostAndPacDot")){ 
                            if(godMode){ 
                                Array[pacmanPos.x - 1][pacmanPos.y] = "pacMan"; 
                                Array[pacmanPos.x][pacmanPos.y] = "pacDot"; 
                            } 
                            if(!godMode){ 
                                Array[pacmanPos.x][pacmanPos.y] = "pacDot"; 
                                ResetPacManAndLoseLife(); 
                            } 
                            left = false; 
                        }else if(Array[pacmanPos.x - 1][pacmanPos.y].equals("redGhostAndBlackSpace") || Array[pacmanPos.x - 1][pacmanPos.y].equals("cyanGhostAndBlackSpace") || Array[pacmanPos.x - 1][pacmanPos.y].equals("pinkGhostAndBlackSpace") || Array[pacmanPos.x - 1][pacmanPos.y].equals("orangeGhostAndBlackSpace")){ 
                            if(godMode){ 
                                Array[pacmanPos.x - 1][pacmanPos.y] = "pacMan"; 
                                Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                            } 
                            if(!godMode){ 
                                Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                                ResetPacManAndLoseLife(); 
                            } 
                            left = false; 
                        }else if(Array[pacmanPos.x - 1][pacmanPos.y].equals("portal")){ 
                            Array[23][13] = "pacMan"; 
                            Array[1][13] = "blackSpace"; 
                            left = false; 
                        }else{ 
                        left = false; 
                        } 
                    } 
                } 
            } 
          
              
              
              
//            Move up. 
            while(up){ 
                getLocations.getLocationPacMan(); 
                if(pacmanPos.y > 0){ 
                    if(pacmanPos.x == 12 && pacmanPos.y - 1 == 14){ 
                        up = false; 
                    }else{ 
                        if(Array[pacmanPos.x][pacmanPos.y - 1].equals("bigPacDot")){ 
                            godMode = true; 
                            Array[pacmanPos.x][pacmanPos.y - 1] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                            up = false; 
                        }else if(Array[pacmanPos.x][pacmanPos.y - 1].equals("pacDot") || Array[pacmanPos.x][pacmanPos.y - 1].equals("blackSpace") || Array[pacmanPos.x][pacmanPos.y - 1].equals("bigPacDot")){ 
                            Array[pacmanPos.x][pacmanPos.y - 1] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                            up = false; 
                        }else if(Array[pacmanPos.x][pacmanPos.y - 1].equals("Wall")){ 
                            up = false; 
                        }else if(Array[pacmanPos.x][pacmanPos.y - 1].equals("redGhostAndPacDot") || Array[pacmanPos.x][pacmanPos.y - 1].equals("cyanGhostAndPacDot") || Array[pacmanPos.x][pacmanPos.y - 1].equals("pinkGhostAndPacDot") || Array[pacmanPos.x][pacmanPos.y - 1].equals("orangeGhostAndPacDot")){ 
                            if(godMode){ 
                                Array[pacmanPos.x][pacmanPos.y - 1] = "pacMan"; 
                                Array[pacmanPos.x][pacmanPos.y] = "pacDot"; 
                            } 
                            if(!godMode){ 
                                Array[pacmanPos.x][pacmanPos.y] = "pacDot"; 
                                ResetPacManAndLoseLife(); 
                            } 
                            up = false; 
                        }else if(Array[pacmanPos.x][pacmanPos.y - 1].equals("redGhostAndBlackSpace") || Array[pacmanPos.x][pacmanPos.y - 1].equals("cyanGhostAndBlackSpace") || Array[pacmanPos.x][pacmanPos.y - 1].equals("pinkGhostAndBlackSpace") || Array[pacmanPos.x][pacmanPos.y - 1].equals("orangeGhostAndBlackSpace")){ 
                            if(godMode){ 
                                Array[pacmanPos.x][pacmanPos.y - 1] = "pacMan"; 
                                Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                            } 
                            if(!godMode){ 
                                Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                                ResetPacManAndLoseLife(); 
                            } 
                            up = false; 
                        }else{ 
                        up = false; 
                        } 
                    } 
                } 
            } 
  
              
              
            //move down. 
            while(down){ 
                getLocations.getLocationPacMan(); 
                if(pacmanPos.y < Height - 1){ 
                    if(pacmanPos.x == 12 && pacmanPos.y + 1 == 12){ 
                        down = false; 
                    }else{ 
                        if(Array[pacmanPos.x][pacmanPos.y + 1].equals("bigPacDot")){ 
                            godMode = true; 
                            Array[pacmanPos.x][pacmanPos.y + 1] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                            down = false; 
                        }else if(Array[pacmanPos.x][pacmanPos.y + 1].equals("pacDot") || Array[pacmanPos.x][pacmanPos.y + 1].equals("blackSpace") || Array[pacmanPos.x][pacmanPos.y + 1].equals("bigPacDot")){ 
                            Array[pacmanPos.x][pacmanPos.y + 1] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                            down = false; 
                        }else if(Array[pacmanPos.x][pacmanPos.y + 1].equals("Wall")){ 
                            down = false; 
                        }else if(Array[pacmanPos.x][pacmanPos.y + 1].equals("redGhostAndPacDot") || Array[pacmanPos.x][pacmanPos.y + 1].equals("cyanGhostAndPacDot") || Array[pacmanPos.x][pacmanPos.y + 1].equals("pinkGhostAndPacDot") || Array[pacmanPos.x][pacmanPos.y + 1].equals("orangeGhostAndPacDot")){ 
                            if(godMode){ 
                                Array[pacmanPos.x][pacmanPos.y + 1] = "pacMan"; 
                                Array[pacmanPos.x][pacmanPos.y] = "pacDot"; 
                            } 
                            if(!godMode){ 
                                Array[pacmanPos.x][pacmanPos.y] = "pacDot"; 
                                ResetPacManAndLoseLife(); 
                            } 
                            down = false; 
                        }else if(Array[pacmanPos.x][pacmanPos.y + 1].equals("redGhostAndBlackSpace") || Array[pacmanPos.x][pacmanPos.y + 1].equals("cyanGhostAndBlackSpace") || Array[pacmanPos.x][pacmanPos.y + 1].equals("pinkGhostAndBlackSpace") || Array[pacmanPos.x][pacmanPos.y + 1].equals("orangeGhostAndBlackSpace")){ 
                            if(godMode){ 
                                Array[pacmanPos.x][pacmanPos.y + 1] = "pacMan"; 
                                Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                            } 
                            if(!godMode){ 
                                Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                                ResetPacManAndLoseLife(); 
                            } 
                            down = false; 
                        }else{ 
                        down = false; 
                        } 
                    } 
                } 
            }
			pacman.movePacman();
			pacman.up = this.up;
			pacman.down = this.down;
			pacman.left = this.left;
			pacman.right = this.right;
              
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
  
              
            //Check god mode and increment god mode counter. 
            if(godMode){ 
                godModeCounter++; 
                if(godModeCounter == 500){ 
                    godMode = false; 
                    godModeCounter = 0; 
                } 
            } 
              
            if(lives <= 0){ 
                gameState = "gameOver"; 
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
	
	public void ResetPacManAndLoseLife(){ 
        Array[12][21] = "pacMan"; 
        lives--; 
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