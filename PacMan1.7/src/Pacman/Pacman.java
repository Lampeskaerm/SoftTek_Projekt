package Pacman;

import java.awt.Point;

public class Pacman {
	PacmanLocation pacmanLoc;
	static PlaySounds playSounds;
	
	Point pacmanPos;
	String[][] Array;
	boolean right, left, up, down;
	public int Width, Height;
	public static int lives = 3;
	int godModeCounter = 0;
    public static int score = 0;
    public static int fruits = 0;

	
	public Pacman (String[][] Array, int Width, int Height, Point pacmanPos){
		this.pacmanPos = pacmanPos;
		this.Array = Array;
		this.Width = Width;
		this.Height = Height;
		
		pacmanLoc = new PacmanLocation(Array, Width, Height, pacmanPos);
		playSounds = new PlaySounds();
	}
	
	public Pacman(){
		
	}
	
	public void movePacman( boolean right, boolean left, boolean up, boolean down){
		
		//movements: 
        //Move right. 
        while(right){ 
            pacmanLoc.getLocation(); 
            if(pacmanPos.x < Width - 1){ 
                if(pacmanPos.x + 1 == 10 && pacmanPos.y == 14){ 
                    right = false; 
                }else{ 
                    if(Array[pacmanPos.x + 1][pacmanPos.y].equals("bigPacDot")){ 
                    	Model.numberOfPacDotsRemaining--;
                    	score += 50;
                        Model.godMode = true;
                        pacmanSounds("pacman_chomp.wav");
                        Array[pacmanPos.x + 1][pacmanPos.y] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        right = false; 
                    }else if(Array[pacmanPos.x + 1][pacmanPos.y].equals("pacDot")){ 
                    	Model.numberOfPacDotsRemaining--;
                    	score += 10;
                    	pacmanSounds("pacman_chomp.wav");
                    	Array[pacmanPos.x + 1][pacmanPos.y] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        right = false; 
                    }else if(Array[pacmanPos.x + 1][pacmanPos.y].equals("blackSpace")){
                    	Array[pacmanPos.x + 1][pacmanPos.y] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        right = false;
                    }else if(Array[pacmanPos.x + 1][pacmanPos.y].equals("redGhostAndPacDot") || Array[pacmanPos.x + 1][pacmanPos.y].equals("cyanGhostAndPacDot") || Array[pacmanPos.x + 1][pacmanPos.y].equals("pinkGhostAndPacDot") || Array[pacmanPos.x + 1][pacmanPos.y].equals("orangeGhostAndPacDot")){ 
                        if(Model.godMode){
                        	score += 200;
                        	pacmanSounds("pacman_eatghost.wav");
                            Array[pacmanPos.x + 1][pacmanPos.y] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "blackspace"; 
                        } 
                        if(!Model.godMode){ 
                            Array[pacmanPos.x][pacmanPos.y] = "pacDot";
                            pacmanSounds("pacman_death.wav");
                            ResetPacManAndLoseLife(); 
                        } 
                        right = false; 
                    }else if(Array[pacmanPos.x + 1][pacmanPos.y].equals("redGhostAndBlackSpace") || Array[pacmanPos.x + 1][pacmanPos.y].equals("cyanGhostAndBlackSpace") || Array[pacmanPos.x + 1][pacmanPos.y].equals("pinkGhostAndBlackSpace") || Array[pacmanPos.x + 1][pacmanPos.y].equals("orangeGhostAndBlackSpace")){ 
                        if(Model.godMode){ 
                        	score += 200;
                        	pacmanSounds("pacman_eatghost.wav");
                            Array[pacmanPos.x + 1][pacmanPos.y] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        } 
                        if(!Model.godMode){ 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace";
                            pacmanSounds("pacman_death.wav");
                            ResetPacManAndLoseLife(); 
                        } 
                        right = false; 
                    }else if(Array[pacmanPos.x + 1][pacmanPos.y].equals("portal")){ 
                        Array[1][14] = "pacMan"; 
                        Array[25][14] = "blackSpace"; 
                        right = false; 
                    }else if(Array[pacmanPos.x + 1][pacmanPos.y].equals("fruitAndBlackSpace") || Array[pacmanPos.x + 1][pacmanPos.y].equals("fruitAndPacDot")){
                    	fruits++;
                    	Array[pacmanPos.x + 1][pacmanPos.y] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace";
                        score += 2 * (Model.level * 100) - 100;
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
                if(pacmanPos.x - 1 == 16 && pacmanPos.y == 14){ 
                    left = false; 
                }else{ 
                    if(Array[pacmanPos.x - 1][pacmanPos.y].equals("bigPacDot")){
                    	Model.numberOfPacDotsRemaining--;
                    	score += 50;
                    	Model.godMode = true; 
                        pacmanSounds("pacman_chomp.wav");
                        Array[pacmanPos.x - 1][pacmanPos.y] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        left = false; 
                    }else if(Array[pacmanPos.x - 1][pacmanPos.y].equals("pacDot")){ 
                    	Model.numberOfPacDotsRemaining--;
                    	score += 10;
                    	pacmanSounds("pacman_chomp.wav");
                    	Array[pacmanPos.x - 1][pacmanPos.y] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        left = false;
                    }else if(Array[pacmanPos.x - 1][pacmanPos.y].equals("blackSpace")){
                    	Array[pacmanPos.x - 1][pacmanPos.y] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        left = false;
                    }else if(Array[pacmanPos.x - 1][pacmanPos.y].equals("redGhostAndPacDot") || Array[pacmanPos.x - 1][pacmanPos.y].equals("cyanGhostAndPacDot") || Array[pacmanPos.x - 1][pacmanPos.y].equals("pinkGhostAndPacDot") || Array[pacmanPos.x - 1][pacmanPos.y].equals("orangeGhostAndPacDot")){ 
                        if(Model.godMode){ 
                        	score += 200;
                        	pacmanSounds("pacman_eatghost.wav");
                            Array[pacmanPos.x - 1][pacmanPos.y] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "blackspace"; 
                        } 
                        if(!Model.godMode){ 
                            Array[pacmanPos.x][pacmanPos.y] = "pacDot"; 
                            pacmanSounds("pacman_death.wav");
                            ResetPacManAndLoseLife(); 
                        } 
                        left = false; 
                    }else if(Array[pacmanPos.x - 1][pacmanPos.y].equals("redGhostAndBlackSpace") || Array[pacmanPos.x - 1][pacmanPos.y].equals("cyanGhostAndBlackSpace") || Array[pacmanPos.x - 1][pacmanPos.y].equals("pinkGhostAndBlackSpace") || Array[pacmanPos.x - 1][pacmanPos.y].equals("orangeGhostAndBlackSpace")){ 
                        if(Model.godMode){ 
                        	score += 200;
                        	pacmanSounds("pacman_eatghost.wav");
                            Array[pacmanPos.x - 1][pacmanPos.y] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        } 
                        if(!Model.godMode){ 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                            pacmanSounds("pacman_death.wav");
                            ResetPacManAndLoseLife(); 
                        } 
                        left = false; 
                    }else if(Array[pacmanPos.x - 1][pacmanPos.y].equals("portal")){ 
                        Array[25][14] = "pacMan"; 
                        Array[1][14] = "blackSpace"; 
                        left = false; 
                    }else if(Array[pacmanPos.x - 1][pacmanPos.y].equals("fruitAndBlackSpace") || Array[pacmanPos.x - 1][pacmanPos.y].equals("fruitAndPacDot")){
                    	fruits++;
                    	Array[pacmanPos.x - 1][pacmanPos.y] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace";
                        score += 2 * (Model.level * 100) - 100;
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
                if(pacmanPos.x == 13 && pacmanPos.y - 1 == 16){ 
                    up = false; 
                }else{ 
                    if(Array[pacmanPos.x][pacmanPos.y - 1].equals("bigPacDot")){ 
                    	Model.numberOfPacDotsRemaining--;
                    	score += 50;
                    	Model.godMode = true; 
                        pacmanSounds("pacman_chomp.wav");
                        Array[pacmanPos.x][pacmanPos.y - 1] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        up = false; 
                    }else if(Array[pacmanPos.x][pacmanPos.y - 1].equals("pacDot")){ 
                    	Model.numberOfPacDotsRemaining--;
                    	score += 10;
                    	pacmanSounds("pacman_chomp.wav");
                        Array[pacmanPos.x][pacmanPos.y - 1] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        up = false;
                    }else if(Array[pacmanPos.x][pacmanPos.y - 1].equals("blackSpace")){
                    	Array[pacmanPos.x][pacmanPos.y - 1] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        up = false;
                    }else if(Array[pacmanPos.x][pacmanPos.y - 1].equals("redGhostAndPacDot") || Array[pacmanPos.x][pacmanPos.y - 1].equals("cyanGhostAndPacDot") || Array[pacmanPos.x][pacmanPos.y - 1].equals("pinkGhostAndPacDot") || Array[pacmanPos.x][pacmanPos.y - 1].equals("orangeGhostAndPacDot")){ 
                        if(Model.godMode){ 
                        	score += 200;
                        	pacmanSounds("pacman_eatghost.wav");
                            Array[pacmanPos.x][pacmanPos.y - 1] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "blackspace"; 
                        } 
                        if(!Model.godMode){ 
                            Array[pacmanPos.x][pacmanPos.y] = "pacDot"; 
                            pacmanSounds("pacman_death.wav");
                            ResetPacManAndLoseLife(); 
                        } 
                        up = false; 
                    }else if(Array[pacmanPos.x][pacmanPos.y - 1].equals("redGhostAndBlackSpace") || Array[pacmanPos.x][pacmanPos.y - 1].equals("cyanGhostAndBlackSpace") || Array[pacmanPos.x][pacmanPos.y - 1].equals("pinkGhostAndBlackSpace") || Array[pacmanPos.x][pacmanPos.y - 1].equals("orangeGhostAndBlackSpace")){ 
                        if(Model.godMode){ 
                        	score += 200;
                        	pacmanSounds("pacman_eatghost.wav");
                            Array[pacmanPos.x][pacmanPos.y - 1] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        } 
                        if(!Model.godMode){ 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                            pacmanSounds("pacman_death.wav");
                            ResetPacManAndLoseLife(); 
                        } 
                        up = false; 
                    }else if(Array[pacmanPos.x][pacmanPos.y - 1].equals("fruitAndBlackSpace") || Array[pacmanPos.x][pacmanPos.y - 1].equals("fruitAndPacDot")){
                    	fruits++;
                    	Array[pacmanPos.x][pacmanPos.y - 1] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace";
                        score += 2 * (Model.level * 100) - 100;
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
                if(pacmanPos.x == 13 && pacmanPos.y + 1 == 12){ 
                    down = false; 
                }else{ 
                    if(Array[pacmanPos.x][pacmanPos.y + 1].equals("bigPacDot")){ 
                    	Model.numberOfPacDotsRemaining--;
                    	score += 50;
                    	Model.godMode = true; 
                        pacmanSounds("pacman_chomp.wav");
                        Array[pacmanPos.x][pacmanPos.y + 1] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        down = false; 
                    }else if(Array[pacmanPos.x][pacmanPos.y + 1].equals("pacDot")){
                    	Model.numberOfPacDotsRemaining--;
                    	score += 10;
                    	pacmanSounds("pacman_chomp.wav");
                        Array[pacmanPos.x][pacmanPos.y + 1] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        down = false; 
                    }else if(Array[pacmanPos.x][pacmanPos.y + 1].equals("blackSpace")){
                    	Array[pacmanPos.x][pacmanPos.y + 1] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        down = false; 
                    }else if(Array[pacmanPos.x][pacmanPos.y + 1].equals("redGhostAndPacDot") || Array[pacmanPos.x][pacmanPos.y + 1].equals("cyanGhostAndPacDot") || Array[pacmanPos.x][pacmanPos.y + 1].equals("pinkGhostAndPacDot") || Array[pacmanPos.x][pacmanPos.y + 1].equals("orangeGhostAndPacDot")){ 
                        if(Model.godMode){ 
                        	score += 200;
                        	pacmanSounds("pacman_eatghost.wav");
                            Array[pacmanPos.x][pacmanPos.y + 1] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "blackspace";
                        } 
                        if(! Model.godMode){ 
                            Array[pacmanPos.x][pacmanPos.y] = "pacDot";
                            pacmanSounds("pacman_death.wav");
                            ResetPacManAndLoseLife(); 
                        } 
                        down = false; 
                    }else if(Array[pacmanPos.x][pacmanPos.y + 1].equals("redGhostAndBlackSpace") || Array[pacmanPos.x][pacmanPos.y + 1].equals("cyanGhostAndBlackSpace") || Array[pacmanPos.x][pacmanPos.y + 1].equals("pinkGhostAndBlackSpace") || Array[pacmanPos.x][pacmanPos.y + 1].equals("orangeGhostAndBlackSpace")){ 
                        if(Model.godMode){ 
                        	score += 200;
                        	pacmanSounds("pacman_eatghost.wav");
                            Array[pacmanPos.x][pacmanPos.y + 1] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        } 
                        if(!Model.godMode){ 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                            pacmanSounds("pacman_death.wav");
                            ResetPacManAndLoseLife(); 
                        } 
                        down = false; 
                    }else if(Array[pacmanPos.x][pacmanPos.y + 1].equals("fruitAndBlackSpace") || Array[pacmanPos.x][pacmanPos.y + 1].equals("fruitAndPacDot")){
                    	Array[pacmanPos.x][pacmanPos.y + 1] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace";
                        score += 2 * (Model.level * 100) - 100;
                        fruits++;
                    }else{ 
                    down = false; 
                    } 
                } 
            } 
        }
        
        //Check god mode and increment god mode counter. 
        if(Model.godMode){ 
            godModeCounter++; 
            if(godModeCounter == 1000){ 
            	 Model.godMode = false; 
                godModeCounter = 0; 
            } 
        }
	}
	
	//reset pacman and loose a life.
	public void ResetPacManAndLoseLife(){ 
		Array[13][23] = "pacMan"; 
        lives--; 
    } 
	
	//Check if pacman is present if he is not, respawn him.
	public void checkIfPacmanIsPresent(){
		boolean pacmanPresent = false;
		for(int i = 0; i < Width; i++){ 
            for(int j = 0; j < Height; j++){ 
                if(Array[i][j].equals("pacMan")){ 
                    pacmanPresent = true;
                } 
            } 
        }
		if(!pacmanPresent){
			Array[12][21] = "pacMan"; 
		}
	}
	
	
	public static void pacmanSounds(String state){
		playSounds.playSound(state);
	}
}
