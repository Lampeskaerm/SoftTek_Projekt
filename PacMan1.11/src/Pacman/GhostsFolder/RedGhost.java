package Pacman.GhostsFolder;

import java.awt.Point;
import Pacman.*;
import Pacman.GhostsLocs.*;



public class RedGhost {
	Point pacmanPos, redGhostPos;
	int Width, Height;
	String[][] Array;
	boolean godMode;
	public String gameState;
	String redGhost;
	
	DirectionGenerator dirGen;
	RedGhostLocation redGhostLoc;
	PacmanLocation pacmanLoc;
	
	public RedGhost(String[][] Array, int Width, int Height, Point pacmanPos, Point redGhostPos, boolean godMode, String gameState){
		this.Array = Array;
		this.Width = Width;
		this.Height = Height;
		this.pacmanPos = pacmanPos;
		this.redGhostPos = redGhostPos;
		this.godMode = godMode;
		this.gameState = gameState;
		
		dirGen = new DirectionGenerator();
		redGhostLoc = new RedGhostLocation(Array, Width, Height, redGhostPos);
		pacmanLoc = new PacmanLocation(Array, Width, Height, pacmanPos);
	}
	
	public void Movements() {
		//Red ghost controls:
		dirGen.randomDirection();
		redGhost = dirGen.randomMovement;
		redGhostLoc.getLocation();
		
		//move right.
		if(redGhost.equals("moveRight")){
			if(redGhostPos.x < Width - 1){
				redGhostLoc.getLocation();
				pacmanLoc.getLocation();
				if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndPacDot") && Array[redGhostPos.x + 1][redGhostPos.y].equals("pacDot")){
					Array[redGhostPos.x + 1][redGhostPos.y] = "redGhostAndPacDot";
					Array[redGhostPos.x][redGhostPos.y] = "pacDot";
					
				}else if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndPacDot") && Array[redGhostPos.x + 1][redGhostPos.y].equals("blackSpace")){
					Array[redGhostPos.x + 1][redGhostPos.y] = "redGhostAndBlackSpace";
					Array[redGhostPos.x][redGhostPos.y] = "pacDot";
										
				}else if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndBlackSpace") && Array[redGhostPos.x + 1][redGhostPos.y].equals("blackSpace")){
					Array[redGhostPos.x + 1][redGhostPos.y] = "redGhostAndBlackSpace";
					Array[redGhostPos.x][redGhostPos.y] = "blackSpace";
													
				}else if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndBlackSpace") && Array[redGhostPos.x + 1][redGhostPos.y].equals("pacDot")){
					Array[redGhostPos.x + 1][redGhostPos.y] = "redGhostAndPacDot";
					Array[redGhostPos.x][redGhostPos.y] = "blackSpace";
					
				}else if(!godMode){
					if(Array[redGhostPos.x + 1][redGhostPos.y].equals("pacMan")){
					gameState = "gameOver";
					}
				}
			}
		}
				
				
		//move left.
		if(redGhost.equals("moveLeft")){
			if(redGhostPos.x > 0){
				redGhostLoc.getLocation();
				pacmanLoc.getLocation();
				if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndPacDot") && Array[redGhostPos.x - 1][redGhostPos.y].equals("pacDot")){
					Array[redGhostPos.x - 1][redGhostPos.y] = "redGhostAndPacDot";
					Array[redGhostPos.x][redGhostPos.y] = "pacDot";
					
				}else if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndPacDot") && Array[redGhostPos.x - 1][redGhostPos.y].equals("blackSpace")){
					Array[redGhostPos.x - 1][redGhostPos.y] = "redGhostAndBlackSpace";
					Array[redGhostPos.x][redGhostPos.y] = "pacDot";
											
				}else if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndBlackSpace") && Array[redGhostPos.x - 1][redGhostPos.y].equals("blackSpace")){
					Array[redGhostPos.x - 1][redGhostPos.y] = "redGhostAndBlackSpace";
					Array[redGhostPos.x][redGhostPos.y] = "blackSpace";
											
				}else if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndBlackSpace") && Array[redGhostPos.x - 1][redGhostPos.y].equals("pacDot")){
					Array[redGhostPos.x - 1][redGhostPos.y] = "redGhostAndPacDot";
					Array[redGhostPos.x][redGhostPos.y] = "blackSpace";
							
				}else if(!godMode){
					if(Array[redGhostPos.x - 1][redGhostPos.y].equals("pacMan")){
					gameState = "gameOver";
					}
				}
			}
		}
			
			
		//move up.
		if(redGhost.equals("moveUp")){
			if(redGhostPos.y > 0){
				redGhostLoc.getLocation();
				pacmanLoc.getLocation();
				if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndPacDot") && Array[redGhostPos.x][redGhostPos.y - 1].equals("pacDot")){
					Array[redGhostPos.x][redGhostPos.y - 1] = "redGhostAndPacDot";
					Array[redGhostPos.x][redGhostPos.y] = "pacDot";
					
				}else if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndPacDot") && Array[redGhostPos.x][redGhostPos.y - 1].equals("blackSpace")){
					Array[redGhostPos.x][redGhostPos.y - 1] = "redGhostAndBlackSpace";
					Array[redGhostPos.x][redGhostPos.y] = "pacDot";
											
				}else if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndBlackSpace") && Array[redGhostPos.x][redGhostPos.y - 1].equals("blackSpace")){
					Array[redGhostPos.x][redGhostPos.y - 1] = "redGhostAndBlackSpace";
					Array[redGhostPos.x][redGhostPos.y] = "blackSpace";
											
				}else if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndBlackSpace") && Array[redGhostPos.x][redGhostPos.y - 1].equals("pacDot")){
					Array[redGhostPos.x][redGhostPos.y - 1] = "redGhostAndPacDot";
					Array[redGhostPos.x][redGhostPos.y] = "blackSpace";
					
				}else if(!godMode){
					if(Array[redGhostPos.x][redGhostPos.y - 1].equals("pacMan")){
						gameState = "gameOver";
					}
				}
			}
		}
			
				
		//move down.
		if(redGhost.equals("moveDown")){
			if(redGhostPos.y < Height - 1){
				redGhostLoc.getLocation();
				pacmanLoc.getLocation();
				if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndPacDot") && Array[redGhostPos.x][redGhostPos.y + 1].equals("pacDot")){
					Array[redGhostPos.x][redGhostPos.y + 1] = "redGhostAndPacDot";
					Array[redGhostPos.x][redGhostPos.y] = "pacDot";
								
				}else if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndPacDot") && Array[redGhostPos.x][redGhostPos.y + 1].equals("blackSpace")){
					Array[redGhostPos.x][redGhostPos.y + 1] = "redGhostAndBlackSpace";
					Array[redGhostPos.x][redGhostPos.y] = "pacDot";
													
				}else if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndBlackSpace") && Array[redGhostPos.x][redGhostPos.y + 1].equals("blackSpace")){
					Array[redGhostPos.x][redGhostPos.y + 1] = "redGhostAndBlackSpace";
					Array[redGhostPos.x][redGhostPos.y] = "blackSpace";
											
				}else if(Array[redGhostPos.x][redGhostPos.y].equals("redGhostAndBlackSpace") && Array[redGhostPos.x][redGhostPos.y + 1].equals("pacDot")){
					Array[redGhostPos.x][redGhostPos.y + 1] = "redGhostAndPacDot";
					Array[redGhostPos.x][redGhostPos.y] = "blackSpace";
					
				}else if(!godMode){
					if(Array[redGhostPos.x][redGhostPos.y + 1].equals("pacMan")){
						gameState = "gameOver";
					}
				}
			}
		}
	}
}
