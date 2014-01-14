package Pacman;

import java.awt.Point;

public class Ghosts {
	String randomMovement = "";
	int Width, Height;
	String[][] Array;
	Point pacmanPos, redGhostPos, cyanGhostPos, pinkGhostPos, orangeGhostPos;
	boolean godMode;
	String gameState;
	
	GetLocations getLocs;
	
	public Ghosts(String[][] Array, int Width, int Height, Point pacmanPos, Point redGhostPos, Point cyanGhostPos, Point pinkGhostPos, Point orangeGhostPos, boolean godMode, String gameState){
		this.Array = Array;
		this.Width = Width;
		this.Height = Height;
		this.pacmanPos = pacmanPos;
		this.redGhostPos = redGhostPos;
		this.cyanGhostPos = cyanGhostPos;
		this.pinkGhostPos = pinkGhostPos;
		this.orangeGhostPos = orangeGhostPos;
		this.godMode = godMode;
		this.gameState = gameState;
		
		getLocs = new GetLocations(Array, Width, Height, pacmanPos, redGhostPos, cyanGhostPos, pinkGhostPos, orangeGhostPos);
	}
	
	public void Movements(){
		String redGhost = "";
		String cyanGhost = "";
		String pinkGhost = "";
		String orangeGhost = "";
		
		
		//Red ghost controls:
		randomDirection();
		redGhost = randomMovement;
		getLocs.getLocationRedGhost();
		
		//move right.
		if(redGhost.equals("moveRight")){
			if(redGhostPos.x < Width - 1){
				getLocs.getLocationRedGhost();
				getLocs.getLocationPacMan();
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
				getLocs.getLocationRedGhost();
				getLocs.getLocationPacMan();
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
				getLocs.getLocationRedGhost();
				getLocs.getLocationPacMan();
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
				getLocs.getLocationRedGhost();
				getLocs.getLocationPacMan();
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
				
				
		//Cyan ghost controls:
		randomDirection();
		cyanGhost = randomMovement;
		getLocs.getLocationCyanGhost();
				
		//move right.
		if(cyanGhost.equals("moveRight")){
			if(cyanGhostPos.x < Width - 1){
				getLocs.getLocationCyanGhost();
				getLocs.getLocationPacMan();
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
				getLocs.getLocationCyanGhost();
				getLocs.getLocationPacMan();
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
				getLocs.getLocationCyanGhost();
				getLocs.getLocationPacMan();
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
				getLocs.getLocationCyanGhost();
				getLocs.getLocationPacMan();
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
						
		//Pink ghost controls:
		randomDirection();
		pinkGhost = randomMovement;
		getLocs.getLocationPinkGhost();
						
		//move right.
		if(pinkGhost.equals("moveRight")){
			if(pinkGhostPos.x < Width - 1){
				getLocs.getLocationPinkGhost();
				getLocs.getLocationPacMan();
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
		if(pinkGhost.equals("moveLeft")){
			if(pinkGhostPos.x > 0){
				getLocs.getLocationPinkGhost();
				getLocs.getLocationPacMan();
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
		if(pinkGhost.equals("moveUp")){
			if(pinkGhostPos.y > 0){
				getLocs.getLocationPinkGhost();
				getLocs.getLocationPacMan();
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
					
				}else if(godMode){
					if(Array[pinkGhostPos.x][pinkGhostPos.y - 1].equals("pacMan")){
						gameState = "gameOver";
					}
				}
			}
		}
						
						
		//move down.
		if(pinkGhost.equals("moveDown")){
			if(pinkGhostPos.y < Height - 1){
				getLocs.getLocationPinkGhost();
				getLocs.getLocationPacMan();
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
								
		//Orange ghost controls:
		randomDirection();
		orangeGhost = randomMovement;
		getLocs.getLocationOrangeGhost();
								
		//move right.
		if(orangeGhost.equals("moveRight")){
			if(orangeGhostPos.x < Width - 1){
				getLocs.getLocationOrangeGhost();
				getLocs.getLocationPacMan();
				if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndPacDot") && Array[orangeGhostPos.x + 1][orangeGhostPos.y].equals("pacDot")){
					Array[orangeGhostPos.x + 1][orangeGhostPos.y] = "orangeGhostAndPacDot";
					Array[orangeGhostPos.x][orangeGhostPos.y] = "pacDot";
											
				}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndPacDot") && Array[orangeGhostPos.x + 1][orangeGhostPos.y].equals("blackSpace")){
					Array[orangeGhostPos.x + 1][orangeGhostPos.y] = "orangeGhostAndBlackSpace";
					Array[orangeGhostPos.x][orangeGhostPos.y] = "pacDot";
																								
				}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndBlackSpace") && Array[orangeGhostPos.x + 1][orangeGhostPos.y].equals("blackSpace")){
					Array[orangeGhostPos.x + 1][orangeGhostPos.y] = "orangeGhostAndBlackSpace";
					Array[orangeGhostPos.x][orangeGhostPos.y] = "blackSpace";
																							
				}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndBlackSpace") && Array[orangeGhostPos.x + 1][orangeGhostPos.y].equals("pacDot")){
					Array[orangeGhostPos.x + 1][orangeGhostPos.y] = "orangeGhostAndPacDot";
					Array[orangeGhostPos.x][orangeGhostPos.y] = "blackSpace";
					
				}else if(!godMode){
					if(Array[orangeGhostPos.x + 1][orangeGhostPos.y].equals("pacMan")){
						gameState = "gameOver";
					}
				}
			}
		}
								
								
		//move left.
		if(orangeGhost.equals("moveLeft")){
			if(orangeGhostPos.x > 0){
				getLocs.getLocationOrangeGhost();
				getLocs.getLocationPacMan();
				if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndPacDot") && Array[orangeGhostPos.x - 1][orangeGhostPos.y].equals("pacDot")){
					Array[orangeGhostPos.x - 1][orangeGhostPos.y] = "orangeGhostAndPacDot";
					Array[orangeGhostPos.x][orangeGhostPos.y] = "pacDot";
											
				}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndPacDot") && Array[orangeGhostPos.x - 1][orangeGhostPos.y].equals("blackSpace")){
					Array[orangeGhostPos.x - 1][orangeGhostPos.y] = "orangeGhostAndBlackSpace";
					Array[orangeGhostPos.x][orangeGhostPos.y] = "pacDot";
																							
				}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndBlackSpace") && Array[orangeGhostPos.x - 1][orangeGhostPos.y].equals("blackSpace")){
					Array[orangeGhostPos.x - 1][orangeGhostPos.y] = "orangeGhostAndBlackSpace";
					Array[orangeGhostPos.x][orangeGhostPos.y] = "blackSpace";
																						
				}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndBlackSpace") && Array[orangeGhostPos.x - 1][orangeGhostPos.y].equals("pacDot")){
					Array[orangeGhostPos.x - 1][orangeGhostPos.y] = "orangeGhostAndPacDot";
					Array[orangeGhostPos.x][orangeGhostPos.y] = "blackSpace";
						
				}else if(!godMode){
					if(Array[orangeGhostPos.x - 1][orangeGhostPos.y].equals("pacMan")){
						gameState = "gameOver";
					}
				}
			}
		}		
									
								
		//move up.
		if(orangeGhost.equals("moveUp")){
			if(orangeGhostPos.y > 0){
				getLocs.getLocationOrangeGhost();
				getLocs.getLocationPacMan();
				if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndPacDot") && Array[orangeGhostPos.x][orangeGhostPos.y - 1].equals("pacDot")){
					Array[orangeGhostPos.x][orangeGhostPos.y - 1] = "orangeGhostAndPacDot";
					Array[orangeGhostPos.x][orangeGhostPos.y] = "pacDot";
											
				}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndPacDot") && Array[orangeGhostPos.x][orangeGhostPos.y - 1].equals("blackSpace")){
					Array[orangeGhostPos.x][orangeGhostPos.y - 1] = "orangeGhostAndBlackSpace";
					Array[orangeGhostPos.x][orangeGhostPos.y] = "pacDot";
																								
				}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndBlackSpace") && Array[orangeGhostPos.x][orangeGhostPos.y - 1].equals("blackSpace")){
					Array[orangeGhostPos.x][orangeGhostPos.y - 1] = "orangeGhostAndBlackSpace";
					Array[orangeGhostPos.x][orangeGhostPos.y] = "blackSpace";
																							
				}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndBlackSpace") && Array[orangeGhostPos.x][orangeGhostPos.y - 1].equals("pacDot")){
					Array[orangeGhostPos.x][orangeGhostPos.y - 1] = "orangeGhostAndPacDot";
					Array[orangeGhostPos.x][orangeGhostPos.y] = "blackSpace";
					
				}else if(!godMode){
					if(Array[orangeGhostPos.x][orangeGhostPos.y - 1].equals("pacMan")){
						gameState = "gameOver";
					}
				}
			}
		}
								
								
		//move down.
		if(orangeGhost.equals("moveDown")){
			if(orangeGhostPos.y < Height - 1){
				getLocs.getLocationOrangeGhost();
				getLocs.getLocationPacMan();
				if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndPacDot") && Array[orangeGhostPos.x][orangeGhostPos.y + 1].equals("pacDot")){
					Array[orangeGhostPos.x][orangeGhostPos.y + 1] = "orangeGhostAndPacDot";
					Array[orangeGhostPos.x][orangeGhostPos.y] = "pacDot";
													
				}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndPacDot") && Array[orangeGhostPos.x][orangeGhostPos.y + 1].equals("blackSpace")){
					Array[orangeGhostPos.x][orangeGhostPos.y + 1] = "orangeGhostAndBlackSpace";
					Array[orangeGhostPos.x][orangeGhostPos.y] = "pacDot";
																												
				}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndBlackSpace") && Array[orangeGhostPos.x][orangeGhostPos.y + 1].equals("blackSpace")){
					Array[orangeGhostPos.x][orangeGhostPos.y + 1] = "orangeGhostAndBlackSpace";
					Array[orangeGhostPos.x][orangeGhostPos.y] = "blackSpace";
																											
				}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndBlackSpace") && Array[orangeGhostPos.x][orangeGhostPos.y + 1].equals("pacDot")){
					Array[orangeGhostPos.x][orangeGhostPos.y + 1] = "orangeGhostAndPacDot";
					Array[orangeGhostPos.x][orangeGhostPos.y] = "blackSpace";
					
				}else if(!godMode){
					if(Array[orangeGhostPos.x][orangeGhostPos.y + 1].equals("pacMan")){
						gameState = "gameOver";
					}
				}
			}
		}
	}
	
	public void randomDirection(){
		 int random = (int)(Math.random() * 4 + 1);
		 if(random == 1){
			 randomMovement = "moveRight";
		 }else if(random == 2){
			 randomMovement = "moveLeft";
		 }else if(random == 3){
			 randomMovement = "moveDown";
		 }else if(random == 4){
			 randomMovement = "moveUp";
		 }
	}
}
