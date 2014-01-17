package Pacman;

import java.awt.Point;

public class OrangeGhost {
	Point pacmanPos, orangeGhostPos;
	int Width, Height;
	String[][] Array;
	String orangeGhost;
	
	DirectionGenerator dirGen;
	OrangeGhostLocation orangeGhostLoc;
	PacmanLocation pacmanLoc;
	
	public OrangeGhost(String[][] Array, int Width, int Height, Point pacmanPos, Point orangeGhostPos){
		this.Array = Array;
		this.Width = Width;
		this.Height = Height;
		this.pacmanPos = pacmanPos;
		this.orangeGhostPos = orangeGhostPos;
		
		dirGen = new DirectionGenerator();
		orangeGhostLoc = new OrangeGhostLocation(Array, Width, Height, orangeGhostPos);
		pacmanLoc = new PacmanLocation(Array, Width, Height, pacmanPos);
	}
	
	public void Movements() {
		//Orange ghost controls:
		dirGen.randomDirection();
		orangeGhost = dirGen.randomMovement;
		orangeGhostLoc.getLocation();
		
		//move right.
		if(orangeGhost.equals("right")){
			if(orangeGhostPos.x < Width - 1){
				orangeGhostLoc.getLocation();
				pacmanLoc.getLocation();
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
					
				}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndPacDot") && Array[orangeGhostPos.x + 1][orangeGhostPos.y].equals("fruit")){
					Array[orangeGhostPos.x + 1][orangeGhostPos.y] = "orangeGhostAndFruit";
					Array[orangeGhostPos.x][orangeGhostPos.y] = "pacDot";
					
				}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndBlackSpace") && Array[orangeGhostPos.x + 1][orangeGhostPos.y].equals("fruit")){
					Array[orangeGhostPos.x + 1][orangeGhostPos.y] = "orangeGhostAndFruit";
					Array[orangeGhostPos.x][orangeGhostPos.y] = "blackSpace";
					
				}else if(!Model.godMode){
					if(Array[orangeGhostPos.x + 1][orangeGhostPos.y].equals("pacMan")){
						Pacman.pacmanSounds("pacman_death.wav");
						Pacman.lives--;
						Array[12][21] = "pacMan";
						Array[orangeGhostPos.x][orangeGhostPos.y] = "blackSpace";
						Array[orangeGhostPos.x + 1][orangeGhostPos.y] = "orangeGhostAndBlackSpace";
					}
				}
			}
		}
				
				
		//move left.
		if(orangeGhost.equals("left")){
			if(orangeGhostPos.x > 0){
				orangeGhostLoc.getLocation();
				pacmanLoc.getLocation();
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
							
				}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndPacDot") && Array[orangeGhostPos.x - 1][orangeGhostPos.y].equals("fruit")){
					Array[orangeGhostPos.x - 1][orangeGhostPos.y] = "orangeGhostAndFruit";
					Array[orangeGhostPos.x][orangeGhostPos.y] = "pacDot";
					
				}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndBlackSpace") && Array[orangeGhostPos.x - 1][orangeGhostPos.y].equals("fruit")){
					Array[orangeGhostPos.x - 1][orangeGhostPos.y] = "orangeGhostAndFruit";
					Array[orangeGhostPos.x][orangeGhostPos.y] = "blackSpace";
					
				}else if(!Model.godMode){
					if(Array[orangeGhostPos.x - 1][orangeGhostPos.y].equals("pacMan")){
						Pacman.pacmanSounds("pacman_death.wav");
						Pacman.lives--;
						Array[12][21] = "pacMan";
						Array[orangeGhostPos.x][orangeGhostPos.y] = "blackSpace";
						Array[orangeGhostPos.x - 1][orangeGhostPos.y] = "orangeGhostAndBlackSpace";
					}
				}
			}
		}
			
			
		//move up.
		if(orangeGhost.equals("up")){
			if(orangeGhostPos.y > 0){
				orangeGhostLoc.getLocation();
				pacmanLoc.getLocation();
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
					
				}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndPacDot") && Array[orangeGhostPos.x][orangeGhostPos.y - 1].equals("fruit")){
					Array[orangeGhostPos.x][orangeGhostPos.y - 1] = "orangeGhostAndFruit";
					Array[orangeGhostPos.x][orangeGhostPos.y] = "pacDot";
					
				}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndBlackSpace") && Array[orangeGhostPos.x][orangeGhostPos.y - 1].equals("fruit")){
					Array[orangeGhostPos.x - 1][orangeGhostPos.y] = "orangeGhostAndFruit";
					Array[orangeGhostPos.x][orangeGhostPos.y] = "blackSpace";
					
				}else if(!Model.godMode){
					if(Array[orangeGhostPos.x][orangeGhostPos.y - 1].equals("pacMan")){
						Pacman.pacmanSounds("pacman_death.wav");
						Pacman.lives--;
						Array[12][21] = "pacMan";
						Array[orangeGhostPos.x][orangeGhostPos.y] = "blackSpace";
						Array[orangeGhostPos.x][orangeGhostPos.y - 1] = "orangeGhostAndBlackSpace";
					}
				}
			}
		}
			
				
		//move down.
		if(orangeGhost.equals("down")){
			if(orangeGhostPos.y < Height - 1){
				orangeGhostLoc.getLocation();
				pacmanLoc.getLocation();
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
					
				}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndPacDot") && Array[orangeGhostPos.x][orangeGhostPos.y + 1].equals("fruit")){
					Array[orangeGhostPos.x][orangeGhostPos.y + 1] = "orangeGhostAndFruit";
					Array[orangeGhostPos.x][orangeGhostPos.y] = "pacDot";
					
				}else if(Array[orangeGhostPos.x][orangeGhostPos.y].equals("orangeGhostAndBlackSpace") && Array[orangeGhostPos.x][orangeGhostPos.y + 1].equals("fruit")){
					Array[orangeGhostPos.x + 1][orangeGhostPos.y] = "orangeGhostAndFruit";
					Array[orangeGhostPos.x][orangeGhostPos.y] = "blackSpace";
					
				}else if(!Model.godMode){
					if(Array[orangeGhostPos.x][orangeGhostPos.y + 1].equals("pacMan")){
						Pacman.pacmanSounds("pacman_death.wav");
						Pacman.lives--;
						Array[12][21] = "pacMan";
						Array[orangeGhostPos.x][orangeGhostPos.y] = "blackSpace";
						Array[orangeGhostPos.x][orangeGhostPos.y + 1] = "orangeGhostAndBlackSpace";
					}
				}
			}
		}
	}
}
