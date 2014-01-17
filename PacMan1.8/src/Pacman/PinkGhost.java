package Pacman;

import java.awt.Point;
import java.util.ArrayList;

public class PinkGhost {
	Point pacmanPos, pinkGhostPos;
	int Width, Height;
	String[][] Array;
	String pinkGhost, lastPos = "none"; 
	ArrayList<String> illegalPos;
	
	DirectionGenerator dirGen;
	PinkGhostLocation pinkGhostLoc;
	PacmanLocation pacmanLoc;
	
	public PinkGhost(String[][] Array, int Width, int Height, Point pacmanPos, Point pinkGhostPos){
		this.Array = Array;
		this.Width = Width;
		this.Height = Height;
		this.pacmanPos = pacmanPos;
		this.pinkGhostPos = pinkGhostPos;
		
		dirGen = new DirectionGenerator();
		pinkGhostLoc = new PinkGhostLocation(Array, Width, Height, pinkGhostPos);
		pacmanLoc = new PacmanLocation(Array, Width, Height, pacmanPos);
	}
	
	public void Movements() {
		//Pink ghost controls:
		checkLastPos();
		illegalPos = new ArrayList<String>();
		checkIllegalPos();
		dirGen.randomDirection(illegalPos);
		pinkGhost = dirGen.randomMovement;
		lastPos = pinkGhost;
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
					
				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndPacDot") && Array[pinkGhostPos.x + 1][pinkGhostPos.y].equals("fruit")){
					Array[pinkGhostPos.x + 1][pinkGhostPos.y] = "pinkGhostAndFruit";
					Array[pinkGhostPos.x][pinkGhostPos.y] = "pacDot";
					
				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndBlackSpace") && Array[pinkGhostPos.x + 1][pinkGhostPos.y].equals("fruit")){
					Array[pinkGhostPos.x + 1][pinkGhostPos.y] = "pinkGhostAndFruit";
					Array[pinkGhostPos.x][pinkGhostPos.y] = "blackSpace";
					
				}else if(!Model.godMode){
					if(Array[pinkGhostPos.x + 1][pinkGhostPos.y].equals("pacMan")){
						Pacman.pacmanSounds("pacman_death.wav");
						Pacman.lives--;
						Array[12][21] = "pacMan";
						Array[pinkGhostPos.x][pinkGhostPos.y] = "blackSpace";
						Array[pinkGhostPos.x + 1][pinkGhostPos.y] = "pinkGhostAndBlackSpace";
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
							
				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndPacDot") && Array[pinkGhostPos.x - 1][pinkGhostPos.y].equals("fruit")){
					Array[pinkGhostPos.x - 1][pinkGhostPos.y] = "pinkGhostAndFruit";
					Array[pinkGhostPos.x][pinkGhostPos.y] = "pacDot";
					
				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndBlackSpace") && Array[pinkGhostPos.x - 1][pinkGhostPos.y].equals("fruit")){
					Array[pinkGhostPos.x - 1][pinkGhostPos.y] = "pinkGhostAndFruit";
					Array[pinkGhostPos.x][pinkGhostPos.y] = "blackSpace";
					
				}else if(!Model.godMode){
					if(Array[pinkGhostPos.x - 1][pinkGhostPos.y].equals("pacMan")){
						Pacman.pacmanSounds("pacman_death.wav");
						Pacman.lives--;
						Array[12][21] = "pacMan";
						Array[pinkGhostPos.x][pinkGhostPos.y] = "blackSpace";
						Array[pinkGhostPos.x - 1][pinkGhostPos.y] = "pinkGhostAndBlackSpace";
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
					
				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndPacDot") && Array[pinkGhostPos.x][pinkGhostPos.y - 1].equals("fruit")){
					Array[pinkGhostPos.x][pinkGhostPos.y - 1] = "pinkGhostAndFruit";
					Array[pinkGhostPos.x][pinkGhostPos.y] = "pacDot";
					
				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndBlackSpace") && Array[pinkGhostPos.x][pinkGhostPos.y - 1].equals("fruit")){
					Array[pinkGhostPos.x][pinkGhostPos.y - 1] = "pinkGhostAndFruit";
					Array[pinkGhostPos.x][pinkGhostPos.y] = "blackSpace";
					
				}else if(!Model.godMode){
					if(Array[pinkGhostPos.x][pinkGhostPos.y - 1].equals("pacMan")){
						Pacman.pacmanSounds("pacman_death.wav");
						Pacman.lives--;
						Array[12][21] = "pacMan";
						Array[pinkGhostPos.x][pinkGhostPos.y] = "blackSpace";
						Array[pinkGhostPos.x][pinkGhostPos.y - 1] = "pinkGhostAndBlackSpace";
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
					
				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndPacDot") && Array[pinkGhostPos.x][pinkGhostPos.y + 1].equals("fruit")){
					Array[pinkGhostPos.x][pinkGhostPos.y + 1] = "pinkGhostAndFruit";
					Array[pinkGhostPos.x][pinkGhostPos.y] = "pacDot";
					
				}else if(Array[pinkGhostPos.x][pinkGhostPos.y].equals("pinkGhostAndBlackSpace") && Array[pinkGhostPos.x][pinkGhostPos.y + 1].equals("fruit")){
					Array[pinkGhostPos.x][pinkGhostPos.y + 1] = "pinkGhostAndFruit";
					Array[pinkGhostPos.x][pinkGhostPos.y] = "blackSpace";
					
				}else if(!Model.godMode){
					if(Array[pinkGhostPos.x][pinkGhostPos.y + 1].equals("pacMan")){
						Pacman.pacmanSounds("pacman_death.wav");
						Pacman.lives--;
						Array[12][21] = "pacMan";
						Array[pinkGhostPos.x][pinkGhostPos.y] = "blackSpace";
						Array[pinkGhostPos.x][pinkGhostPos.y + 1] = "pinkGhostAndBlackSpace";
					}
				}
			}
		}
	}
	
	public void checkIllegalPos(){
		pinkGhostLoc.getLocation();
		
		if(Array[pinkGhostPos.x + 1][pinkGhostPos.y].endsWith("Wall")){
			illegalPos.add("right");
		}
		if(Array[pinkGhostPos.x - 1][pinkGhostPos.y].endsWith("Wall")){
			illegalPos.add("left");
		}
		if(Array[pinkGhostPos.x][pinkGhostPos.y - 1].endsWith("Wall")){
			illegalPos.add("up");
		}
		if(Array[pinkGhostPos.x][pinkGhostPos.y + 1].endsWith("Wall")){
			illegalPos.add("down");
		}
		if(!illegalPos.contains(lastPos))
				illegalPos.add(lastPos);
	}
	
	public void checkLastPos(){
		if(lastPos == "right"){
			lastPos = "left";
		}else if(lastPos == "left"){
			lastPos = "right";
		}else if(lastPos =="up"){
			lastPos = "down";
		}else if(lastPos == "down"){
			lastPos = "up";
		}
	}
}
