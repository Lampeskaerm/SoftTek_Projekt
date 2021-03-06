package Pacman;

import java.awt.Point;

public class Pacman {
	PacmanLocation pacmanLoc;
	PlaySounds playSounds;
	
	Point pacmanPos;
	String[][] Array;
	boolean godMode, right, left, up, down;
	int Width, Height, lives;
	int godModeCounter = 0;
	
	public Pacman (String[][] Array, int Width, int Height, Point pacmanPos, boolean godMode, int lives){
		this.pacmanPos = pacmanPos;
		this.Array = Array;
		this.godMode = godMode;
		this.Width = Width;
		this.Height = Height;
		this.lives = lives;
		
		pacmanLoc = new PacmanLocation(Array, Width, Height, pacmanPos);
		playSounds = new PlaySounds();
	}
	
	public void movePacman( boolean right, boolean left, boolean up, boolean down){
		
		//movements: 
        //Move right. 
        while(right){ 
            pacmanLoc.getLocation(); 
            if(pacmanPos.x < Width - 1){ 
                if(pacmanPos.x + 1 == 10 && pacmanPos.y == 13){ 
                    right = false; 
                }else{ 
                    if(Array[pacmanPos.x + 1][pacmanPos.y].equals("bigPacDot")){ 
                        godMode = true; 
                        pacmanSounds("pacman_chomp.wav");
                        Array[pacmanPos.x + 1][pacmanPos.y] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        right = false; 
                    }else if(Array[pacmanPos.x + 1][pacmanPos.y].equals("pacDot")){ 
                    	pacmanSounds("pacman_chomp.wav");
                    	Array[pacmanPos.x + 1][pacmanPos.y] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        right = false; 
                    }else if(Array[pacmanPos.x + 1][pacmanPos.y].equals("blackSpace")){
                    	Array[pacmanPos.x + 1][pacmanPos.y] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        right = false;
                    }else if(Array[pacmanPos.x + 1][pacmanPos.y].equals("Wall")){ 
                        right = false; 
                    }else if(Array[pacmanPos.x + 1][pacmanPos.y].equals("redGhostAndPacDot") || Array[pacmanPos.x + 1][pacmanPos.y].equals("cyanGhostAndPacDot") || Array[pacmanPos.x + 1][pacmanPos.y].equals("pinkGhostAndPacDot") || Array[pacmanPos.x + 1][pacmanPos.y].equals("orangeGhostAndPacDot")){ 
                        if(godMode){
                        	pacmanSounds("pacman_eatghost.wav");
                            Array[pacmanPos.x + 1][pacmanPos.y] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "pacDot"; 
                        } 
                        if(!godMode){ 
                            Array[pacmanPos.x][pacmanPos.y] = "pacDot";
                            pacmanSounds("pacman_death.wav");
                            ResetPacManAndLoseLife(); 
                        } 
                        right = false; 
                    }else if(Array[pacmanPos.x + 1][pacmanPos.y].equals("redGhostAndBlackSpace") || Array[pacmanPos.x + 1][pacmanPos.y].equals("cyanGhostAndBlackSpace") || Array[pacmanPos.x + 1][pacmanPos.y].equals("pinkGhostAndBlackSpace") || Array[pacmanPos.x + 1][pacmanPos.y].equals("orangeGhostAndBlackSpace")){ 
                        if(godMode){ 
                        	pacmanSounds("pacman_eatghost.wav");
                            Array[pacmanPos.x + 1][pacmanPos.y] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        } 
                        if(!godMode){ 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace";
                            pacmanSounds("pacman_death.wav");
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
            pacmanLoc.getLocation(); 
            if(pacmanPos.x > 0){ 
                if(pacmanPos.x - 1 == 14 && pacmanPos.y == 13){ 
                    left = false; 
                }else{ 
                    if(Array[pacmanPos.x - 1][pacmanPos.y].equals("bigPacDot")){ 
                        godMode = true; 
                        pacmanSounds("pacman_chomp.wav");
                        Array[pacmanPos.x - 1][pacmanPos.y] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        left = false; 
                    }else if(Array[pacmanPos.x - 1][pacmanPos.y].equals("pacDot")){ 
                    	pacmanSounds("pacman_chomp.wav");
                    	Array[pacmanPos.x - 1][pacmanPos.y] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        left = false;
                    }else if(Array[pacmanPos.x - 1][pacmanPos.y].equals("blackSpace")){
                    	Array[pacmanPos.x - 1][pacmanPos.y] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        left = false;
                    }else if(Array[pacmanPos.x - 1][pacmanPos.y].equals("Wall")){ 
                        left = false; 
                    }else if(Array[pacmanPos.x - 1][pacmanPos.y].equals("redGhostAndPacDot") || Array[pacmanPos.x - 1][pacmanPos.y].equals("cyanGhostAndPacDot") || Array[pacmanPos.x - 1][pacmanPos.y].equals("pinkGhostAndPacDot") || Array[pacmanPos.x - 1][pacmanPos.y].equals("orangeGhostAndPacDot")){ 
                        if(godMode){ 
                        	pacmanSounds("pacman_eatghost.wav");
                            Array[pacmanPos.x - 1][pacmanPos.y] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "pacDot"; 
                        } 
                        if(!godMode){ 
                            Array[pacmanPos.x][pacmanPos.y] = "pacDot"; 
                            pacmanSounds("pacman_death.wav");
                            ResetPacManAndLoseLife(); 
                        } 
                        left = false; 
                    }else if(Array[pacmanPos.x - 1][pacmanPos.y].equals("redGhostAndBlackSpace") || Array[pacmanPos.x - 1][pacmanPos.y].equals("cyanGhostAndBlackSpace") || Array[pacmanPos.x - 1][pacmanPos.y].equals("pinkGhostAndBlackSpace") || Array[pacmanPos.x - 1][pacmanPos.y].equals("orangeGhostAndBlackSpace")){ 
                        if(godMode){ 
                        	pacmanSounds("pacman_eatghost.wav");
                            Array[pacmanPos.x - 1][pacmanPos.y] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        } 
                        if(!godMode){ 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                            pacmanSounds("pacman_death.wav");
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
      
          
          
          
        //Move up. 
        while(up){ 
            pacmanLoc.getLocation(); 
            if(pacmanPos.y > 0){ 
                if(pacmanPos.x == 12 && pacmanPos.y - 1 == 14){ 
                    up = false; 
                }else{ 
                    if(Array[pacmanPos.x][pacmanPos.y - 1].equals("bigPacDot")){ 
                        godMode = true; 
                        pacmanSounds("pacman_chomp.wav");
                        Array[pacmanPos.x][pacmanPos.y - 1] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        up = false; 
                    }else if(Array[pacmanPos.x][pacmanPos.y - 1].equals("pacDot")){ 
                    	pacmanSounds("pacman_chomp.wav");
                        Array[pacmanPos.x][pacmanPos.y - 1] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        up = false;
                    }else if(Array[pacmanPos.x][pacmanPos.y - 1].equals("blackSpace")){
                    	Array[pacmanPos.x][pacmanPos.y - 1] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        up = false;
                    }else if(Array[pacmanPos.x][pacmanPos.y - 1].equals("Wall")){ 
                        up = false; 
                    }else if(Array[pacmanPos.x][pacmanPos.y - 1].equals("redGhostAndPacDot") || Array[pacmanPos.x][pacmanPos.y - 1].equals("cyanGhostAndPacDot") || Array[pacmanPos.x][pacmanPos.y - 1].equals("pinkGhostAndPacDot") || Array[pacmanPos.x][pacmanPos.y - 1].equals("orangeGhostAndPacDot")){ 
                        if(godMode){ 
                        	pacmanSounds("pacman_eatghost.wav");
                            Array[pacmanPos.x][pacmanPos.y - 1] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "pacDot"; 
                        } 
                        if(!godMode){ 
                            Array[pacmanPos.x][pacmanPos.y] = "pacDot"; 
                            pacmanSounds("pacman_death.wav");
                            ResetPacManAndLoseLife(); 
                        } 
                        up = false; 
                    }else if(Array[pacmanPos.x][pacmanPos.y - 1].equals("redGhostAndBlackSpace") || Array[pacmanPos.x][pacmanPos.y - 1].equals("cyanGhostAndBlackSpace") || Array[pacmanPos.x][pacmanPos.y - 1].equals("pinkGhostAndBlackSpace") || Array[pacmanPos.x][pacmanPos.y - 1].equals("orangeGhostAndBlackSpace")){ 
                        if(godMode){ 
                        	pacmanSounds("pacman_eatghost.wav");
                            Array[pacmanPos.x][pacmanPos.y - 1] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        } 
                        if(!godMode){ 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                            pacmanSounds("pacman_death.wav");
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
            pacmanLoc.getLocation(); 
            if(pacmanPos.y < Height - 1){ 
                if(pacmanPos.x == 12 && pacmanPos.y + 1 == 12){ 
                    down = false; 
                }else{ 
                    if(Array[pacmanPos.x][pacmanPos.y + 1].equals("bigPacDot")){ 
                        godMode = true; 
                        pacmanSounds("pacman_chomp.wav");
                        Array[pacmanPos.x][pacmanPos.y + 1] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        down = false; 
                    }else if(Array[pacmanPos.x][pacmanPos.y + 1].equals("pacDot")){
                    	pacmanSounds("pacman_chomp.wav");
                        Array[pacmanPos.x][pacmanPos.y + 1] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        down = false; 
                    }else if(Array[pacmanPos.x][pacmanPos.y + 1].equals("blackSpace")){
                    	Array[pacmanPos.x][pacmanPos.y + 1] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        down = false; 
                    }else if(Array[pacmanPos.x][pacmanPos.y + 1].equals("Wall")){ 
                        down = false; 
                    }else if(Array[pacmanPos.x][pacmanPos.y + 1].equals("redGhostAndPacDot") || Array[pacmanPos.x][pacmanPos.y + 1].equals("cyanGhostAndPacDot") || Array[pacmanPos.x][pacmanPos.y + 1].equals("pinkGhostAndPacDot") || Array[pacmanPos.x][pacmanPos.y + 1].equals("orangeGhostAndPacDot")){ 
                        if(godMode){ 
                        	pacmanSounds("pacman_eatghost.wav");
                            Array[pacmanPos.x][pacmanPos.y + 1] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "pacDot"; 
                        } 
                        if(!godMode){ 
                            Array[pacmanPos.x][pacmanPos.y] = "pacDot";
                            pacmanSounds("pacman_death.wav");
                            ResetPacManAndLoseLife(); 
                        } 
                        down = false; 
                    }else if(Array[pacmanPos.x][pacmanPos.y + 1].equals("redGhostAndBlackSpace") || Array[pacmanPos.x][pacmanPos.y + 1].equals("cyanGhostAndBlackSpace") || Array[pacmanPos.x][pacmanPos.y + 1].equals("pinkGhostAndBlackSpace") || Array[pacmanPos.x][pacmanPos.y + 1].equals("orangeGhostAndBlackSpace")){ 
                        if(godMode){ 
                        	pacmanSounds("pacman_eatghost.wav");
                            Array[pacmanPos.x][pacmanPos.y + 1] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        } 
                        if(!godMode){ 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                            pacmanSounds("pacman_death.wav");
                            ResetPacManAndLoseLife(); 
                        } 
                        down = false; 
                    }else{ 
                    down = false; 
                    } 
                } 
            } 
        }
        
        //Check god mode and increment god mode counter. 
        if(godMode){ 
            godModeCounter++; 
            if(godModeCounter == 500){ 
                godMode = false; 
                godModeCounter = 0; 
            } 
        }
	}
	
	public void ResetPacManAndLoseLife(){ 
        Array[12][21] = "pacMan"; 
        lives--; 
    } 
	
	public void pacmanSounds(String state){
		playSounds.playSound(state);
	}
}
