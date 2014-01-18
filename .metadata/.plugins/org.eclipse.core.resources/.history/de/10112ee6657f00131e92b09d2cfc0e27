package Pacman;

import java.awt.Point;

public class CyanGhost {
	Point pacmanPos, cyanGhostPos;
	int Width, Height;
	String[][] Array;
	String cyanGhost;
	
	DirectionGenerator dirGen;
	CyanGhostLocation cyanGhostLoc;
	PacmanLocation pacmanLoc;
	
	public CyanGhost(String[][] Array, int Width, int Height, Point pacmanPos, Point cyanGhostPos){
		this.Array = Array;
		this.Width = Width;
		this.Height = Height;
		this.pacmanPos = pacmanPos;
		this.cyanGhostPos = cyanGhostPos;
		
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
		if(cyanGhost.equals("right")){
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
					
				}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndPacDot") && Array[cyanGhostPos.x + 1][cyanGhostPos.y].equals("fruit")){
					Array[cyanGhostPos.x + 1][cyanGhostPos.y] = "cyanGhostAndFruit";
					Array[cyanGhostPos.x][cyanGhostPos.y] = "pacDot";
					
				}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndBlackSpace") && Array[cyanGhostPos.x + 1][cyanGhostPos.y].equals("fruit")){
					Array[cyanGhostPos.x + 1][cyanGhostPos.y] = "cyanGhostAndFruit";
					Array[cyanGhostPos.x][cyanGhostPos.y] = "blackSpace";
					
				}else if(!Model.godMode){
					if(Array[cyanGhostPos.x + 1][cyanGhostPos.y].equals("pacMan")){
						Pacman.pacmanSounds("pacman_death.wav");
						Pacman.lives--;
						Array[12][21] = "pacMan"; 
						Array[cyanGhostPos.x][cyanGhostPos.y] = "blackSpace";
						Array[cyanGhostPos.x + 1][cyanGhostPos.y] = "cyanGhostAndBlackSpace";
					}
				}
			}
		}
				
				
		//move left.
		if(cyanGhost.equals("left")){
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
							
				}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndPacDot") && Array[cyanGhostPos.x - 1][cyanGhostPos.y].equals("fruit")){
					Array[cyanGhostPos.x - 1][cyanGhostPos.y] = "cyanGhostAndFruit";
					Array[cyanGhostPos.x][cyanGhostPos.y] = "pacDot";
					
				}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndBlackSpace") && Array[cyanGhostPos.x - 1][cyanGhostPos.y].equals("fruit")){
					Array[cyanGhostPos.x - 1][cyanGhostPos.y] = "cyanGhostAndFruit";
					Array[cyanGhostPos.x][cyanGhostPos.y] = "blackSpace";
					
				}else if(!Model.godMode){
					if(Array[cyanGhostPos.x - 1][cyanGhostPos.y].equals("pacMan")){
						Pacman.pacmanSounds("pacman_death.wav");
						Pacman.lives--;
						Array[12][21] = "pacMan"; 
						Array[cyanGhostPos.x][cyanGhostPos.y] = "blackSpace";
						Array[cyanGhostPos.x - 1][cyanGhostPos.y] = "cyanGhostAndBlackSpace";
					}
				}
			}
		}
			
			
		//move up.
		if(cyanGhost.equals("up")){
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
					
				}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndPacDot") && Array[cyanGhostPos.x][cyanGhostPos.y - 1].equals("fruit")){
					Array[cyanGhostPos.x][cyanGhostPos.y - 1] = "cyanGhostAndFruit";
					Array[cyanGhostPos.x][cyanGhostPos.y] = "pacDot";
					
				}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndBlackSpace") && Array[cyanGhostPos.x][cyanGhostPos.y - 1].equals("fruit")){
					Array[cyanGhostPos.x][cyanGhostPos.y - 1] = "cyanGhostAndFruit";
					Array[cyanGhostPos.x][cyanGhostPos.y] = "blackSpace";
					
				}else if(!Model.godMode){
					if(Array[cyanGhostPos.x][cyanGhostPos.y - 1].equals("pacMan")){
						Pacman.pacmanSounds("pacman_death.wav");
						Pacman.lives--;
						Array[12][21] = "pacMan"; 
						Array[cyanGhostPos.x][cyanGhostPos.y] = "blackSpace";
						Array[cyanGhostPos.x][cyanGhostPos.y - 1] = "cyanGhostAndBlackSpace";
					}
				}
			}
		}
			
				
		//move down.
		if(cyanGhost.equals("down")){
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
					
				}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndPacDot") && Array[cyanGhostPos.x][cyanGhostPos.y + 1].equals("fruit")){
					Array[cyanGhostPos.x][cyanGhostPos.y + 1] = "cyanGhostAndFruit";
					Array[cyanGhostPos.x][cyanGhostPos.y] = "pacDot";
					
				}else if(Array[cyanGhostPos.x][cyanGhostPos.y].equals("cyanGhostAndBlackSpace") && Array[cyanGhostPos.x][cyanGhostPos.y + 1].equals("fruit")){
					Array[cyanGhostPos.x][cyanGhostPos.y + 1] = "cyanGhostAndFruit";
					Array[cyanGhostPos.x][cyanGhostPos.y] = "blackSpace";
					
				}else if(!Model.godMode){
					if(Array[cyanGhostPos.x][cyanGhostPos.y + 1].equals("pacMan")){
						Pacman.pacmanSounds("pacman_death.wav");
						Pacman.lives--;
						Array[12][21] = "pacMan"; 
						Array[cyanGhostPos.x][cyanGhostPos.y] = "blackSpace";
						Array[cyanGhostPos.x][cyanGhostPos.y + 1] = "cyanGhostAndBlackSpace";
					}
				}
			}
		}
	}
}
