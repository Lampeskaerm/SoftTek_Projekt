package Pacman;

import java.awt.Point;

public class PinkGhost {
	Point pacmanPos, pinkGhostPos;
	int Width, Height;
	String[][] Array;
	boolean godMode;
	public String gameState;
	String pinkGhost;
	
	DirectionGenerator dirGen;
	PinkGhostLocation pinkGhostLoc;
	PacmanLocation pacmanLoc;
	
	public PinkGhost(String[][] Array, int Width, int Height, Point pacmanPos, Point pinkGhostPos, boolean godMode, String gameState){
		this.Array = Array;
		this.Width = Width;
		this.Height = Height;
		this.pacmanPos = pacmanPos;
		this.pinkGhostPos = pinkGhostPos;
		this.godMode = godMode;
		this.gameState = gameState;
		
		dirGen = new DirectionGenerator();
		pinkGhostLoc = new PinkGhostLocation(Array, Width, Height, pinkGhostPos);
		pacmanLoc = new PacmanLocation(Array, Width, Height, pacmanPos);
	}
	
	public void Movements() {
		//Pink ghost controls:
		dirGen.randomDirection();
		pinkGhost = dirGen.randomMovement;
		pinkGhostLoc.getLocation();
		
		//move right.
		if(pinkGhost.equals("right")){
			if(pinkGhostPos.x < Width - 1){
				pinkGhostLoc.getLocation();
				pacmanLoc.getLocation();
				if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndPacDot") && Array[pinkGhostPos.x + 1][pinkGhostPos.y].equals("pacDot")){
					Array[pinkGhostPos.x + 1][pinkGhostPos.y] = "pinkGhostAndPacDot";
					Array[pinkGhostPos.x][pinkGhostPos.y] = "pacDot";
					
				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndPacDot") && Array[pinkGhostPos.x + 1][pinkGhostPos.y].equals("blackSpace")){
					Array[pinkGhostPos.x + 1][pinkGhostPos.y] = "pinkGhostAndBlackSpace";
					Array[pinkGhostPos.x][pinkGhostPos.y] = "pacDot";
										
				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndBlackSpace") && Array[pinkGhostPos.x + 1][pinkGhostPos.y].equals("blackSpace")){
					Array[pinkGhostPos.x + 1][pinkGhostPos.y] = "pinkGhostAndBlackSpace";
					Array[pinkGhostPos.x][pinkGhostPos.y] = "blackSpace";
													
				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndBlackSpace") && Array[pinkGhostPos.x + 1][pinkGhostPos.y].equals("pacDot")){
					Array[pinkGhostPos.x + 1][pinkGhostPos.y] = "pinkGhostAndPacDot";
					Array[pinkGhostPos.x][pinkGhostPos.y] = "blackSpace";
					
				}else if(!godMode){
					if(Array[pinkGhostPos.x + 1][pinkGhostPos.y].equals("pacMan")){
					gameState = "gameOver";
					}
				}
			}
		}
				
				
		//move left.
		if(pinkGhost.equals("left")){
			if(pinkGhostPos.x > 0){
				pinkGhostLoc.getLocation();
				pacmanLoc.getLocation();
				if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndPacDot") && Array[pinkGhostPos.x - 1][pinkGhostPos.y].equals("pacDot")){
					Array[pinkGhostPos.x - 1][pinkGhostPos.y] = "pinkGhostAndPacDot";
					Array[pinkGhostPos.x][pinkGhostPos.y] = "pacDot";
					
				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndPacDot") && Array[pinkGhostPos.x - 1][pinkGhostPos.y].equals("blackSpace")){
					Array[pinkGhostPos.x - 1][pinkGhostPos.y] = "pinkGhostAndBlackSpace";
					Array[pinkGhostPos.x][pinkGhostPos.y] = "pacDot";
											
				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndBlackSpace") && Array[pinkGhostPos.x - 1][pinkGhostPos.y].equals("blackSpace")){
					Array[pinkGhostPos.x - 1][pinkGhostPos.y] = "pinkGhostAndBlackSpace";
					Array[pinkGhostPos.x][pinkGhostPos.y] = "blackSpace";
											
				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndBlackSpace") && Array[pinkGhostPos.x - 1][pinkGhostPos.y].equals("pacDot")){
					Array[pinkGhostPos.x - 1][pinkGhostPos.y] = "pinkGhostAndPacDot";
					Array[pinkGhostPos.x][pinkGhostPos.y] = "blackSpace";
							
				}else if(!godMode){
					if(Array[pinkGhostPos.x - 1][pinkGhostPos.y].equals("pacMan")){
					gameState = "gameOver";
					}
				}
			}
		}
			
			
		//move up.
		if(pinkGhost.equals("up")){
			if(pinkGhostPos.y > 0){
				pinkGhostLoc.getLocation();
				pacmanLoc.getLocation();
				if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndPacDot") && Array[pinkGhostPos.x][pinkGhostPos.y - 1].equals("pacDot")){
					Array[pinkGhostPos.x][pinkGhostPos.y - 1] = "pinkGhostAndPacDot";
					Array[pinkGhostPos.x][pinkGhostPos.y] = "pacDot";
					
				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndPacDot") && Array[pinkGhostPos.x][pinkGhostPos.y - 1].equals("blackSpace")){
					Array[pinkGhostPos.x][pinkGhostPos.y - 1] = "pinkGhostAndBlackSpace";
					Array[pinkGhostPos.x][pinkGhostPos.y] = "pacDot";
											
				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndBlackSpace") && Array[pinkGhostPos.x][pinkGhostPos.y - 1].equals("blackSpace")){
					Array[pinkGhostPos.x][pinkGhostPos.y - 1] = "pinkGhostAndBlackSpace";
					Array[pinkGhostPos.x][pinkGhostPos.y] = "blackSpace";
											
				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndBlackSpace") && Array[pinkGhostPos.x][pinkGhostPos.y - 1].equals("pacDot")){
					Array[pinkGhostPos.x][pinkGhostPos.y - 1] = "pinkGhostAndPacDot";
					Array[pinkGhostPos.x][pinkGhostPos.y] = "blackSpace";
					
				}else if(!godMode){
					if(Array[pinkGhostPos.x][pinkGhostPos.y - 1].equals("pacMan")){
						gameState = "gameOver";
					}
				}
			}
		}
			
				
		//move down.
		if(pinkGhost.equals("down")){
			if(pinkGhostPos.y < Height - 1){
				pinkGhostLoc.getLocation();
				pacmanLoc.getLocation();
				if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndPacDot") && Array[pinkGhostPos.x][pinkGhostPos.y + 1].equals("pacDot")){
					Array[pinkGhostPos.x][pinkGhostPos.y + 1] = "pinkGhostAndPacDot";
					Array[pinkGhostPos.x][pinkGhostPos.y] = "pacDot";
								
				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndPacDot") && Array[pinkGhostPos.x][pinkGhostPos.y + 1].equals("blackSpace")){
					Array[pinkGhostPos.x][pinkGhostPos.y + 1] = "pinkGhostAndBlackSpace";
					Array[pinkGhostPos.x][pinkGhostPos.y] = "pacDot";
													
				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndBlackSpace") && Array[pinkGhostPos.x][pinkGhostPos.y + 1].equals("blackSpace")){
					Array[pinkGhostPos.x][pinkGhostPos.y + 1] = "pinkGhostAndBlackSpace";
					Array[pinkGhostPos.x][pinkGhostPos.y] = "blackSpace";
											
				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndBlackSpace") && Array[pinkGhostPos.x][pinkGhostPos.y + 1].equals("pacDot")){
					Array[pinkGhostPos.x][pinkGhostPos.y + 1] = "pinkGhostAndPacDot";
					Array[pinkGhostPos.x][pinkGhostPos.y] = "blackSpace";
					
				}else if(!godMode){
					if(Array[pinkGhostPos.x][pinkGhostPos.y + 1].equals("pacMan")){
						gameState = "gameOver";
					}
				}
			}
		}
	}
}
