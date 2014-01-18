package Pacman;

import java.awt.Point;
import java.util.ArrayList;

public class Ghost extends Objects{
	String ghostColor, lastPos = "none", ghost;
	ArrayList<String> illegalPos;
	
	Pacman pacman;
	DirectionGenerator dirGen;
	
	public Ghost(Point pos, String[][] Array, int Width, int Height, String ghostColor, Point pacmanPos) {
		super(pos, Array, Width, Height);
		this.ghostColor = ghostColor;
		
		pacman = new Pacman(pacmanPos, Array, Width, Height);
		dirGen = new DirectionGenerator();
	}
	
	public void getLocation(){
		for(int i = 0; i < Width; i++){
			for(int j = 0; j < Height; j++){
				if(Array[i][j].equals(ghostColor + "GhostAndPacDot") || Array[i][j].equals(ghostColor+"GhostAndBlackSpace")){
					pos.x = i;
					pos.y = j;
				}
			}
		}
	}
	
	public void Movements(){
		checkLastPos();
		illegalPos = new ArrayList<String>();
		checkIllegalPos();
		dirGen.randomDirection(illegalPos);
		ghost = dirGen.randomMovement;
		lastPos = ghost;
		getLocation();
		pacman.getLocation();
		
		//move right.
				if(ghost.equals("right")){
					if(pos.x < Width - 1){
						getLocation();
						pacman.getLocation();
						if(Array[pos.x][pos.y].equals(ghostColor+"GhostAndPacDot") && Array[pos.x + 1][pos.y].equals("pacDot")){
							Array[pos.x + 1][pos.y] = ghostColor+"GhostAndPacDot";
							Array[pos.x][pos.y] = "pacDot";
							
						}else if(Array[pos.x][pos.y].equals(ghostColor+"GhostAndPacDot") && Array[pos.x + 1][pos.y].equals("blackSpace")){
							Array[pos.x + 1][pos.y] = ghostColor+"GhostAndBlackSpace";
							Array[pos.x][pos.y] = "pacDot";
												
						}else if(Array[pos.x][pos.y].equals(ghostColor+"GhostAndBlackSpace") && Array[pos.x + 1][pos.y].equals("blackSpace")){
							Array[pos.x + 1][pos.y] = ghostColor+"GhostAndBlackSpace";
							Array[pos.x][pos.y] = "blackSpace";
															
						}else if(Array[pos.x][pos.y].equals(ghostColor+"GhostAndBlackSpace") && Array[pos.x + 1][pos.y].equals("pacDot")){
							Array[pos.x + 1][pos.y] = ghostColor+"GhostAndPacDot";
							Array[pos.x][pos.y] = "blackSpace";
							
						}else if(Array[pos.x][pos.y].equals(ghostColor+"GhostAndPacDot") && Array[pos.x + 1][pos.y].equals("fruit")){
							Array[pos.x + 1][pos.y] = ghostColor+"GhostAndFruit";
							Array[pos.x][pos.y] = "pacDot";
							
						}else if(Array[pos.x][pos.y].equals(ghostColor+"GhostAndBlackSpace") && Array[pos.x + 1][pos.y].equals("fruit")){
							Array[pos.x + 1][pos.y] = ghostColor+"GhostAndFruit";
							Array[pos.x][pos.y] = "blackSpace";
							
						}else if(!Model.godMode){
							if(Array[pos.x + 1][pos.y].equals("pacMan")){
								Pacman.pacmanSounds("pacman_death.wav");
								Pacman.lives--;
								Array[13][23] = "pacMan";
								Array[pos.x][pos.y] = "blackSpace";
								Array[pos.x + 1][pos.y] = ghostColor+"GhostAndBlackSpace";
							}
						}
					}
				}
						
						
				//move left.
				if(ghost.equals("left")){
					if(pos.x > 0){
						getLocation();
						pacman.getLocation();
						if(Array[pos.x][pos.y].equals(ghostColor+"GhostAndPacDot") && Array[pos.x - 1][pos.y].equals("pacDot")){
							Array[pos.x - 1][pos.y] = ghostColor+"GhostAndPacDot";
							Array[pos.x][pos.y] = "pacDot";
							
						}else if(Array[pos.x][pos.y].equals(ghostColor+"GhostAndPacDot") && Array[pos.x - 1][pos.y].equals("blackSpace")){
							Array[pos.x - 1][pos.y] = ghostColor+"GhostAndBlackSpace";
							Array[pos.x][pos.y] = "pacDot";
													
						}else if(Array[pos.x][pos.y].equals(ghostColor+"GhostAndBlackSpace") && Array[pos.x - 1][pos.y].equals("blackSpace")){
							Array[pos.x - 1][pos.y] = ghostColor+"GhostAndBlackSpace";
							Array[pos.x][pos.y] = "blackSpace";
													
						}else if(Array[pos.x][pos.y].equals(ghostColor+"GhostAndBlackSpace") && Array[pos.x - 1][pos.y].equals("pacDot")){
							Array[pos.x - 1][pos.y] = ghostColor+"GhostAndPacDot";
							Array[pos.x][pos.y] = "blackSpace";
									
						}else if(Array[pos.x][pos.y].equals(ghostColor+"GhostAndPacDot") && Array[pos.x - 1][pos.y].equals("fruit")){
							Array[pos.x - 1][pos.y] = ghostColor+"GhostAndFruit";
							Array[pos.x][pos.y] = "pacDot";
							
						}else if(Array[pos.x][pos.y].equals(ghostColor+"GhostAndBlackSpace") && Array[pos.x - 1][pos.y].equals("fruit")){
							Array[pos.x - 1][pos.y] = ghostColor+"GhostAndFruit";
							Array[pos.x][pos.y] = "blackSpace";
							
						}else if(!Model.godMode){
							if(Array[pos.x - 1][pos.y].equals("pacMan")){
								Pacman.pacmanSounds("pacman_death.wav");
								Pacman.lives--;
								Array[13][23] = "pacMan";
								Array[pos.x][pos.y] = "blackSpace";
								Array[pos.x - 1][pos.y] = ghostColor+"GhostAndBlackSpace";
							}
						}
					}
				}
					
					
				//move up.
				if(ghost.equals("up")){
					if(pos.y > 0){
						getLocation();
						pacman.getLocation();
						if(Array[pos.x][pos.y].equals(ghostColor+"GhostAndPacDot") && Array[pos.x][pos.y - 1].equals("pacDot")){
							Array[pos.x][pos.y - 1] = ghostColor+"GhostAndPacDot";
							Array[pos.x][pos.y] = "pacDot";
							
						}else if(Array[pos.x][pos.y].equals(ghostColor+"GhostAndPacDot") && Array[pos.x][pos.y - 1].equals("blackSpace")){
							Array[pos.x][pos.y - 1] = ghostColor+"GhostAndBlackSpace";
							Array[pos.x][pos.y] = "pacDot";
													
						}else if(Array[pos.x][pos.y].equals(ghostColor+"GhostAndBlackSpace") && Array[pos.x][pos.y - 1].equals("blackSpace")){
							Array[pos.x][pos.y - 1] = ghostColor+"GhostAndBlackSpace";
							Array[pos.x][pos.y] = "blackSpace";
													
						}else if(Array[pos.x][pos.y].equals(ghostColor+"GhostAndBlackSpace") && Array[pos.x][pos.y - 1].equals("pacDot")){
							Array[pos.x][pos.y - 1] = ghostColor+"GhostAndPacDot";
							Array[pos.x][pos.y] = "blackSpace";
							
						}else if(Array[pos.x][pos.y].equals(ghostColor+"GhostAndPacDot") && Array[pos.x][pos.y - 1].equals("fruit")){
							Array[pos.x][pos.y - 1] = ghostColor+"GhostAndFruit";
							Array[pos.x][pos.y] = "pacDot";
							
						}else if(Array[pos.x][pos.y].equals(ghostColor+"GhostAndBlackSpace") && Array[pos.x][pos.y - 1].equals("fruit")){
							Array[pos.x - 1][pos.y] = ghostColor+"GhostAndFruit";
							Array[pos.x][pos.y] = "blackSpace";
							
						}else if(!Model.godMode){
							if(Array[pos.x][pos.y - 1].equals("pacMan")){
								Pacman.pacmanSounds("pacman_death.wav");
								Pacman.lives--;
								Array[13][23] = "pacMan";
								Array[pos.x][pos.y] = "blackSpace";
								Array[pos.x][pos.y - 1] = ghostColor+"GhostAndBlackSpace";
							}
						}
					}
				}
					
						
				//move down.
				if(ghost.equals("down")){
					if(pos.y < Height - 1){
						getLocation();
						pacman.getLocation();
						if(Array[pos.x][pos.y].equals(ghostColor+"GhostAndPacDot") && Array[pos.x][pos.y + 1].equals("pacDot")){
							Array[pos.x][pos.y + 1] = ghostColor+"GhostAndPacDot";
							Array[pos.x][pos.y] = "pacDot";
										
						}else if(Array[pos.x][pos.y].equals(ghostColor+"GhostAndPacDot") && Array[pos.x][pos.y + 1].equals("blackSpace")){
							Array[pos.x][pos.y + 1] = ghostColor+"GhostAndBlackSpace";
							Array[pos.x][pos.y] = "pacDot";
															
						}else if(Array[pos.x][pos.y].equals(ghostColor+"GhostAndBlackSpace") && Array[pos.x][pos.y + 1].equals("blackSpace")){
							Array[pos.x][pos.y + 1] = ghostColor+"GhostAndBlackSpace";
							Array[pos.x][pos.y] = "blackSpace";
													
						}else if(Array[pos.x][pos.y].equals(ghostColor+"GhostAndBlackSpace") && Array[pos.x][pos.y + 1].equals("pacDot")){
							Array[pos.x][pos.y + 1] = ghostColor+"GhostAndPacDot";
							Array[pos.x][pos.y] = "blackSpace";
							
						}else if(Array[pos.x][pos.y].equals(ghostColor+"GhostAndPacDot") && Array[pos.x][pos.y + 1].equals("fruit")){
							Array[pos.x][pos.y + 1] = ghostColor+"GhostAndFruit";
							Array[pos.x][pos.y] = "pacDot";
							
						}else if(Array[pos.x][pos.y].equals(ghostColor+"GhostAndBlackSpace") && Array[pos.x][pos.y + 1].equals("fruit")){
							Array[pos.x + 1][pos.y] = ghostColor+"GhostAndFruit";
							Array[pos.x][pos.y] = "blackSpace";
							
						}else if(!Model.godMode){
							if(Array[pos.x][pos.y + 1].equals("pacMan")){
								Pacman.pacmanSounds("pacman_death.wav");
								Pacman.lives--;
								Array[13][23] = "pacMan";
								Array[pos.x][pos.y] = "blackSpace";
								Array[pos.x][pos.y + 1] = ghostColor+"GhostAndBlackSpace";
							}
						}
					}
				}
	}
	
	public void checkIllegalPos(){
		getLocation();
		if(Array[pos.x + 1][pos.y].endsWith("Wall") || (pos.x == 6 && pos.y == 14)){
			System.out.println(pos);
			System.out.println(Array[pos.x + 1][pos.y]);
			illegalPos.add("right");
		}
		if(Array[pos.x - 1][pos.y].endsWith("Wall") || (pos.x == 20 && pos.y == 14)){
			illegalPos.add("left");
		}
		if(Array[pos.x][pos.y - 1].endsWith("Wall")){
			illegalPos.add("up");
		}
		if(Array[pos.x][pos.y + 1].endsWith("Wall")){
			illegalPos.add("down");
		}
		if(illegalPos.size() != 4){
			if(!illegalPos.contains(lastPos))
				illegalPos.add(lastPos);
		}
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