package Pacman;

import java.awt.Point;
import java.util.ArrayList;

public class Ghost extends Objects{
	boolean pacdot = false, superdot = false, fruit = false;
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
				if(Array[i][j].equals(ghostColor + "Ghost")){
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
						if(Array[pos.x][pos.y].equals(ghostColor+"Ghost") && Array[pos.x + 1][pos.y].equals("pacDot")){
							Array[pos.x + 1][pos.y] = ghostColor+"Ghost";
							if(pacdot)
								Array[pos.x][pos.y] = "pacDot";
							else if(superdot)
								Array[pos.x][pos.y] = "bigPacDot";
							else if(fruit)
								Array[pos.x][pos.y] = "fruit";
							else
								Array[pos.x][pos.y] = "blackSpace";
							
							setAllFalse();
							pacdot = true;
							
						}else if(Array[pos.x][pos.y].equals(ghostColor+"Ghost") && Array[pos.x + 1][pos.y].equals("blackSpace")){
							Array[pos.x + 1][pos.y] = ghostColor+"Ghost";
							if(pacdot)
								Array[pos.x][pos.y] = "pacDot";
							else if(superdot)
								Array[pos.x][pos.y] = "bigPacDot";
							else if(fruit)
								Array[pos.x][pos.y] = "fruit";
							else
								Array[pos.x][pos.y] = "blackSpace";
							
							setAllFalse();
							
						}else if(Array[pos.x][pos.y].equals(ghostColor+"Ghost") && Array[pos.x + 1][pos.y].equals("fruit")){
							Array[pos.x + 1][pos.y] = ghostColor+"Ghost";
							if(pacdot)
								Array[pos.x][pos.y] = "pacDot";
							else if(superdot)
								Array[pos.x][pos.y] = "bigPacDot";
							else if(fruit)
								Array[pos.x][pos.y] = "fruit";
							else
								Array[pos.x][pos.y] = "blackSpace";
							
							setAllFalse();
							fruit = true;
							
						}else if(Array[pos.x][pos.y].equals(ghostColor+"Ghost") && Array[pos.x + 1][pos.y].equals("bigPacDot")){
							Array[pos.x + 1][pos.y] = ghostColor+"Ghost";
							if(pacdot)
								Array[pos.x][pos.y] = "pacDot";
							else if(superdot)
								Array[pos.x][pos.y] = "bigPacDot";
							else if(fruit)
								Array[pos.x][pos.y] = "fruit";
							else
								Array[pos.x][pos.y] = "blackSpace";
							
							setAllFalse();
							superdot = true;
							
						}else if(Array[pos.x][pos.y].equals(ghostColor+"Ghost") && Array[pos.x + 1][pos.y].equals("portal")){ 
	                        Array[1][14] = ghostColor + "Ghost"; 
	                        Array[25][14] = "blackSpace"; 
	                        setAllFalse();
	                        
//	                    }else if(Array[pos.x + 1][pos.y].contains("Ghost")){ 
//	                        ghost = "left"; 
//	                        setAllFalse();
	                        
	                    }else if(!Model.godMode){
							if(Array[pos.x][pos.y].equals(ghostColor+"Ghost") && Array[pos.x + 1][pos.y].equals("pacMan")){
								Pacman.pacmanSounds("pacman_death.wav");
								Pacman.lives--;
								Array[13][23] = "pacMan";
								Array[pos.x][pos.y] = "blackSpace";
								Array[pos.x + 1][pos.y] = ghostColor+"Ghost";
								setAllFalse();
							}
						}
					}
				}
						
						
				//move left.
				if(ghost.equals("left")){
					if(pos.x > 0){
						getLocation();
						pacman.getLocation();
						if(Array[pos.x][pos.y].equals(ghostColor+"Ghost") && Array[pos.x - 1][pos.y].equals("pacDot")){
							Array[pos.x - 1][pos.y] = ghostColor+"Ghost";
							if(pacdot)
								Array[pos.x][pos.y] = "pacDot";
							else if(superdot)
								Array[pos.x][pos.y] = "bigPacDot";
							else if(fruit)
								Array[pos.x][pos.y] = "fruit";
							else
								Array[pos.x][pos.y] = "blackSpace";
							
							setAllFalse();
							pacdot = true;
							
						}else if(Array[pos.x][pos.y].equals(ghostColor+"Ghost") && Array[pos.x - 1][pos.y].equals("blackSpace")){
							Array[pos.x - 1][pos.y] = ghostColor+"Ghost";
							if(pacdot)
								Array[pos.x][pos.y] = "pacDot";
							else if(superdot)
								Array[pos.x][pos.y] = "bigPacDot";
							else if(fruit)
								Array[pos.x][pos.y] = "fruit";
							else
								Array[pos.x][pos.y] = "blackSpace";
							
							setAllFalse();
							
						}else if(Array[pos.x][pos.y].equals(ghostColor+"Ghost") && Array[pos.x - 1][pos.y].equals("fruit")){
							Array[pos.x - 1][pos.y] = ghostColor+"Ghost";
							if(pacdot)
								Array[pos.x][pos.y] = "pacDot";
							else if(superdot)
								Array[pos.x][pos.y] = "bigPacDot";
							else if(fruit)
								Array[pos.x][pos.y] = "fruit";
							else
								Array[pos.x][pos.y] = "blackSpace";
							
							setAllFalse();
							fruit = true;
							
						}else if(Array[pos.x][pos.y].equals(ghostColor+"Ghost") && Array[pos.x - 1][pos.y].equals("bigPacDot")){
							Array[pos.x - 1][pos.y] = ghostColor+"Ghost";
							if(pacdot)
								Array[pos.x][pos.y] = "pacDot";
							else if(superdot)
								Array[pos.x][pos.y] = "bigPacDot";
							else if(fruit)
								Array[pos.x][pos.y] = "fruit";
							else
								Array[pos.x][pos.y] = "blackSpace";
							
							setAllFalse();
							superdot = true;
							
						}else if(Array[pos.x][pos.y].equals(ghostColor+"Ghost") && Array[pos.x - 1][pos.y].equals("portal")){ 
	                        Array[1][14] = "blackSpace";
	                        Array[25][14] = ghostColor + "Ghost";  
	                        setAllFalse();
	                        
//	                    }else if(Array[pos.x - 1][pos.y].contains("Ghost")){ 
//	                        ghost = "left"; 
	                        
	                    }else if(!Model.godMode){
							if(Array[pos.x][pos.y].equals(ghostColor+"Ghost") && Array[pos.x - 1][pos.y].equals("pacMan")){
								Pacman.pacmanSounds("pacman_death.wav");
								Pacman.lives--;
								Array[13][23] = "pacMan";
								Array[pos.x][pos.y] = "blackSpace";
								Array[pos.x - 1][pos.y] = ghostColor+"Ghost";
								setAllFalse();
							}
						}
					}
				}
					
					
				//move up.
				if(ghost.equals("up")){
					if(pos.y > 0){
						getLocation();
						pacman.getLocation();
						if(Array[pos.x][pos.y].equals(ghostColor+"Ghost") && Array[pos.x][pos.y - 1].equals("pacDot")){
							Array[pos.x][pos.y - 1] = ghostColor+"Ghost";
							if(pacdot)
								Array[pos.x][pos.y] = "pacDot";
							else if(superdot)
								Array[pos.x][pos.y] = "bigPacDot";
							else if(fruit)
								Array[pos.x][pos.y] = "fruit";
							else
								Array[pos.x][pos.y] = "blackSpace";
							
							setAllFalse();
							pacdot = true;
							
						}else if(Array[pos.x][pos.y].equals(ghostColor+"Ghost") && Array[pos.x][pos.y - 1].equals("blackSpace")){
							Array[pos.x][pos.y - 1] = ghostColor+"Ghost";
							if(pacdot)
								Array[pos.x][pos.y] = "pacDot";
							else if(superdot)
								Array[pos.x][pos.y] = "bigPacDot";
							else if(fruit)
								Array[pos.x][pos.y] = "fruit";
							else
								Array[pos.x][pos.y] = "blackSpace";
							setAllFalse();
							
						}else if(Array[pos.x][pos.y].equals(ghostColor+"Ghost") && Array[pos.x][pos.y - 1].equals("fruit")){
							Array[pos.x][pos.y - 1] = ghostColor+"Ghost";
							if(pacdot)
								Array[pos.x][pos.y] = "pacDot";
							else if(superdot)
								Array[pos.x][pos.y] = "bigPacDot";
							else if(fruit)
								Array[pos.x][pos.y] = "fruit";
							else
								Array[pos.x][pos.y] = "blackSpace";
					
							setAllFalse();
							fruit = true;
							
						}else if(Array[pos.x][pos.y].equals(ghostColor+"Ghost") && Array[pos.x][pos.y - 1].equals("bigPacDot")){
							Array[pos.x][pos.y - 1] = ghostColor+"Ghost";
							if(pacdot)
								Array[pos.x][pos.y] = "pacDot";
							else if(superdot)
								Array[pos.x][pos.y] = "bigPacDot";
							else if(fruit)
								Array[pos.x][pos.y] = "fruit";
							else
								Array[pos.x][pos.y] = "blackSpace";
							
							setAllFalse();
							superdot = true;
							
						}else if(Array[pos.x][pos.y].equals(ghostColor+"Ghost") && Array[pos.x][pos.y - 1].equals("portal")){ 
	                        Array[1][14] = ghostColor + "Ghost"; 
	                        Array[25][14] = "blackSpace"; 
	                        setAllFalse();
	                        
//	                    }else if(Array[pos.x][pos.y - 1].contains("Ghost")){ 
//	                        ghost = "left"; 
	                        
	                    }else if(!Model.godMode){
							if(Array[pos.x][pos.y].equals(ghostColor+"Ghost") && Array[pos.x][pos.y - 1].equals("pacMan")){
								Pacman.pacmanSounds("pacman_death.wav");
								Pacman.lives--;
								Array[13][23] = "pacMan";
								Array[pos.x][pos.y] = "blackSpace";
								Array[pos.x][pos.y - 1] = ghostColor+"Ghost";
								setAllFalse();
							}
						}
					}
				}
					
						
				//move down.
				if(ghost.equals("down")){
					if(pos.y < Height - 1){
						getLocation();
						pacman.getLocation();
						if(Array[pos.x][pos.y].equals(ghostColor+"Ghost") && Array[pos.x][pos.y + 1].equals("pacDot")){
							Array[pos.x][pos.y + 1] = ghostColor+"Ghost";
							if(pacdot)
								Array[pos.x][pos.y] = "pacDot";
							else if(superdot)
								Array[pos.x][pos.y] = "bigPacDot";
							else if(fruit)
								Array[pos.x][pos.y] = "fruit";
							else
								Array[pos.x][pos.y] = "blackSpace";
							
							Array[pos.x][pos.y + 1] = ghostColor+"Ghost";
							setAllFalse();
							pacdot = true;
							
						}else if(Array[pos.x][pos.y].equals(ghostColor+"Ghost") && Array[pos.x][pos.y + 1].equals("blackSpace")){
							Array[pos.x][pos.y + 1] = ghostColor+"Ghost";
							if(pacdot)
								Array[pos.x][pos.y] = "pacDot";
							else if(superdot)
								Array[pos.x][pos.y] = "bigPacDot";
							else if(fruit)
								Array[pos.x][pos.y] = "fruit";
							else
								Array[pos.x][pos.y] = "blackSpace";
							
							setAllFalse();
							
						}else if(Array[pos.x][pos.y].equals(ghostColor+"Ghost") && Array[pos.x][pos.y + 1].equals("fruit")){
							Array[pos.x][pos.y + 1] = ghostColor+"Ghost";
							if(pacdot)
								Array[pos.x][pos.y] = "pacDot";
							else if(superdot)
								Array[pos.x][pos.y] = "bigPacDot";
							else if(fruit)
								Array[pos.x][pos.y] = "fruit";
							else
								Array[pos.x][pos.y] = "blackSpace";
							
							setAllFalse();
							fruit = true;
							
						}else if(Array[pos.x][pos.y].equals(ghostColor+"Ghost") && Array[pos.x][pos.y + 1].equals("bigPacDot")){
							Array[pos.x][pos.y + 1] = ghostColor+"Ghost";
							if(pacdot)
								Array[pos.x][pos.y] = "pacDot";
							else if(superdot)
								Array[pos.x][pos.y] = "bigPacDot";
							else if(fruit)
								Array[pos.x][pos.y] = "fruit";
							else
								Array[pos.x][pos.y] = "blackSpace";
							
							setAllFalse();
							superdot = true;
							
						}else if(Array[pos.x][pos.y].equals(ghostColor+"Ghost") && Array[pos.x][pos.y + 1].equals("portal")){ 
	                        Array[1][14] = ghostColor + "Ghost"; 
	                        Array[25][14] = "blackSpace"; 
	                        setAllFalse();
	                        
//	                    }else if(Array[pos.x][pos.y + 1].contains("Ghost")){ 
//	                        ghost = "left"; 
	                        
	                    }else if(!Model.godMode){
							if(Array[pos.x][pos.y].equals(ghostColor+"Ghost") && Array[pos.x][pos.y + 1].equals("pacMan")){
								Pacman.pacmanSounds("pacman_death.wav");
								Pacman.lives--;
								Array[13][23] = "pacMan";
								Array[pos.x][pos.y] = "blackSpace";
								Array[pos.x][pos.y + 1] = ghostColor+"Ghost";
								setAllFalse();
							}
						}
					}
				}
	}
	
	public void checkIllegalPos(){
		getLocation();
		if(Array[pos.x + 1][pos.y].endsWith("Wall")){		
			illegalPos.add("right");
		}
		if(Array[pos.x - 1][pos.y].endsWith("Wall")){
			illegalPos.add("left");
		}
		if(Array[pos.x][pos.y - 1].endsWith("Wall")){
			illegalPos.add("up");
		}
		if(Array[pos.x][pos.y + 1].endsWith("Wall")){
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
	
	public void setAllFalse(){
		pacdot = false;
		superdot = false;
		fruit = false;
	}
}
