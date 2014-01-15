package Pacman;

import java.awt.Point;

public class CyanGhost {
	Point pacmanPos, cyanGhostPos;
	int Width, Height;
	String[][] Array;
	boolean godMode;
	public String gameState;
	String cyanGhost;
	
	DirectionGenerator dirGen;
	CyanGhostLocation cyanGhostLoc;
	PacmanLocation pacmanLoc;
	
	public CyanGhost(String[][] Array, int Width, int Height, Point pacmanPos, Point cyanGhostPos, boolean godMode, String gameState){
		this.Array = Array;
		this.Width = Width;
		this.Height = Height;
		this.pacmanPos = pacmanPos;
		this.cyanGhostPos = cyanGhostPos;
		this.godMode = godMode;
		this.gameState = gameState;
		
		dirGen = new DirectionGenerator();
		cyanGhostLoc = new CyanGhostLocation(Array, Width, Height, cyanGhostPos);
		pacmanLoc = new PacmanLocation(Array, Width, Height, pacmanPos);
	}
	
	public void Movements() {
		//Cyan ghost controls:
		dirGen.randomDirection();
		cyanGhost = dirGen.randomMovement;
		cyanGhostLoc.getLocation();
		
		//move right.
		if(cyanGhost.equals("moveRight")){
			if(cyanGhostPos.x < Width - 1){
				cyanGhostLoc.getLocation();
				pacmanLoc.getLocation();
				if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndPacDot") && Array[cyanGhostPos.x + 1][cyanGhostPos.y].equals("pacDot")){
					Array[cyanGhostPos.x + 1][cyanGhostPos.y] = "cyanGhostAndPacDot";
					Array[cyanGhostPos.x][cyanGhostPos.y] = "pacDot";
					
				}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndPacDot") && Array[cyanGhostPos.x + 1][cyanGhostPos.y].equals("blackSpace")){
					Array[cyanGhostPos.x + 1][cyanGhostPos.y] = "cyanGhostAndBlackSpace";
					Array[cyanGhostPos.x][cyanGhostPos.y] = "pacDot";
										
				}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndBlackSpace") && Array[cyanGhostPos.x + 1][cyanGhostPos.y].equals("blackSpace")){
					Array[cyanGhostPos.x + 1][cyanGhostPos.y] = "cyanGhostAndBlackSpace";
					Array[cyanGhostPos.x][cyanGhostPos.y] = "blackSpace";
													
				}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndBlackSpace") && Array[cyanGhostPos.x + 1][cyanGhostPos.y].equals("pacDot")){
					Array[cyanGhostPos.x + 1][cyanGhostPos.y] = "cyanGhostAndPacDot";
					Array[cyanGhostPos.x][cyanGhostPos.y] = "blackSpace";
					
				}else if(!godMode){
					if(Array[cyanGhostPos.x + 1][cyanGhostPos.y].equals("pacMan")){
					gameState = "gameOver";
					}
				}
			}
		}
				
				
		//move left.
		if(cyanGhost.equals("moveLeft")){
			if(cyanGhostPos.x > 0){
				cyanGhostLoc.getLocation();
				pacmanLoc.getLocation();
				if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndPacDot") && Array[cyanGhostPos.x - 1][cyanGhostPos.y].equals("pacDot")){
					Array[cyanGhostPos.x - 1][cyanGhostPos.y] = "cyanGhostAndPacDot";
					Array[cyanGhostPos.x][cyanGhostPos.y] = "pacDot";
					
				}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndPacDot") && Array[cyanGhostPos.x - 1][cyanGhostPos.y].equals("blackSpace")){
					Array[cyanGhostPos.x - 1][cyanGhostPos.y] = "cyanGhostAndBlackSpace";
					Array[cyanGhostPos.x][cyanGhostPos.y] = "pacDot";
											
				}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndBlackSpace") && Array[cyanGhostPos.x - 1][cyanGhostPos.y].equals("blackSpace")){
					Array[cyanGhostPos.x - 1][cyanGhostPos.y] = "cyanGhostAndBlackSpace";
					Array[cyanGhostPos.x][cyanGhostPos.y] = "blackSpace";
											
				}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndBlackSpace") && Array[cyanGhostPos.x - 1][cyanGhostPos.y].equals("pacDot")){
					Array[cyanGhostPos.x - 1][cyanGhostPos.y] = "cyanGhostAndPacDot";
					Array[cyanGhostPos.x][cyanGhostPos.y] = "blackSpace";
							
				}else if(!godMode){
					if(Array[cyanGhostPos.x - 1][cyanGhostPos.y].equals("pacMan")){
					gameState = "gameOver";
					}
				}
			}
		}
			
			
		//move up.
		if(cyanGhost.equals("moveUp")){
			if(cyanGhostPos.y > 0){
				cyanGhostLoc.getLocation();
				pacmanLoc.getLocation();
				if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndPacDot") && Array[cyanGhostPos.x][cyanGhostPos.y - 1].equals("pacDot")){
					Array[cyanGhostPos.x][cyanGhostPos.y - 1] = "cyanGhostAndPacDot";
					Array[cyanGhostPos.x][cyanGhostPos.y] = "pacDot";
					
				}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndPacDot") && Array[cyanGhostPos.x][cyanGhostPos.y - 1].equals("blackSpace")){
					Array[cyanGhostPos.x][cyanGhostPos.y - 1] = "cyanGhostAndBlackSpace";
					Array[cyanGhostPos.x][cyanGhostPos.y] = "pacDot";
											
				}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndBlackSpace") && Array[cyanGhostPos.x][cyanGhostPos.y - 1].equals("blackSpace")){
					Array[cyanGhostPos.x][cyanGhostPos.y - 1] = "cyanGhostAndBlackSpace";
					Array[cyanGhostPos.x][cyanGhostPos.y] = "blackSpace";
											
				}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndBlackSpace") && Array[cyanGhostPos.x][cyanGhostPos.y - 1].equals("pacDot")){
					Array[cyanGhostPos.x][cyanGhostPos.y - 1] = "cyanGhostAndPacDot";
					Array[cyanGhostPos.x][cyanGhostPos.y] = "blackSpace";
					
				}else if(!godMode){
					if(Array[cyanGhostPos.x][cyanGhostPos.y - 1].equals("pacMan")){
						gameState = "gameOver";
					}
				}
			}
		}
			
				
		//move down.
		if(cyanGhost.equals("moveDown")){
			if(cyanGhostPos.y < Height - 1){
				cyanGhostLoc.getLocation();
				pacmanLoc.getLocation();
				if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndPacDot") && Array[cyanGhostPos.x][cyanGhostPos.y + 1].equals("pacDot")){
					Array[cyanGhostPos.x][cyanGhostPos.y + 1] = "cyanGhostAndPacDot";
					Array[cyanGhostPos.x][cyanGhostPos.y] = "pacDot";
								
				}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndPacDot") && Array[cyanGhostPos.x][cyanGhostPos.y + 1].equals("blackSpace")){
					Array[cyanGhostPos.x][cyanGhostPos.y + 1] = "cyanGhostAndBlackSpace";
					Array[cyanGhostPos.x][cyanGhostPos.y] = "pacDot";
													
				}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndBlackSpace") && Array[cyanGhostPos.x][cyanGhostPos.y + 1].equals("blackSpace")){
					Array[cyanGhostPos.x][cyanGhostPos.y + 1] = "cyanGhostAndBlackSpace";
					Array[cyanGhostPos.x][cyanGhostPos.y] = "blackSpace";
											
				}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndBlackSpace") && Array[cyanGhostPos.x][cyanGhostPos.y + 1].equals("pacDot")){
					Array[cyanGhostPos.x][cyanGhostPos.y + 1] = "cyanGhostAndPacDot";
					Array[cyanGhostPos.x][cyanGhostPos.y] = "blackSpace";
					
				}else if(!godMode){
					if(Array[cyanGhostPos.x][cyanGhostPos.y + 1].equals("pacMan")){
						gameState = "gameOver";
					}
				}
			}
		}
	}
}
