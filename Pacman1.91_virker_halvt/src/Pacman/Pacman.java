package Pacman;

import java.awt.Point;

public class Pacman extends Objects{
	static PlaySounds playSounds;
	
	boolean right, left, up, down;
	public static int lives = 3;
	int godModeCounter = 0;
    public static int score = 0;
    public static int fruits = 0;

	
	public Pacman (Point pos, String[][] Array, int Width, int Height){
		super(pos, Array, Width, Height);

		playSounds = new PlaySounds();
	}
	
	public void getLocation(){
		for(int i = 0; i < Width; i++){
			for(int j = 0; j < Height; j++){
				if(Array[i][j].equals("pacMan")){
					pos.x = i;
					pos.y = j;
				}
			}
		}
	}
	
	public void movePacman( boolean right, boolean left, boolean up, boolean down){
		
		//movements: 
        //Move right. 
        while(right){ 
            getLocation(); 
            if(pos.x < Width - 1){ 
                if(pos.x + 1 == 10 && pos.y == 14){ 
                    right = false; 
                }else{ 
                    if(Array[pos.x + 1][pos.y].equals("bigPacDot")){ 
                    	Model.numberOfPacDotsRemaining--;
                    	score += 50;
                        Model.godMode = true;
                        pacmanSounds("pacman_chomp.wav");
                        Array[pos.x + 1][pos.y] = "pacMan"; 
                        Array[pos.x][pos.y] = "blackSpace"; 
                        right = false; 
                    }else if(Array[pos.x + 1][pos.y].equals("pacDot")){ 
                    	Model.numberOfPacDotsRemaining--;
                    	score += 10;
                    	pacmanSounds("pacman_chomp.wav");
                    	Array[pos.x + 1][pos.y] = "pacMan"; 
                        Array[pos.x][pos.y] = "blackSpace"; 
                        right = false; 
                    }else if(Array[pos.x + 1][pos.y].equals("blackSpace")){
                    	Array[pos.x + 1][pos.y] = "pacMan"; 
                        Array[pos.x][pos.y] = "blackSpace"; 
                        right = false;
                    }else if(Array[pos.x + 1][pos.y].equals("redGhostAndPacDot") || Array[pos.x + 1][pos.y].equals("cyanGhostAndPacDot") || Array[pos.x + 1][pos.y].equals("pinkGhostAndPacDot") || Array[pos.x + 1][pos.y].equals("orangeGhostAndPacDot")){ 
                        if(Model.godMode){
                        	score += 200;
                        	pacmanSounds("pacman_eatghost.wav");
                            Array[pos.x + 1][pos.y] = "pacMan"; 
                            Array[pos.x][pos.y] = "blackspace"; 
                        } 
                        if(!Model.godMode){ 
                            Array[pos.x][pos.y] = "pacDot";
                            pacmanSounds("pacman_death.wav");
                            ResetPacManAndLoseLife(); 
                        } 
                        right = false; 
                    }else if(Array[pos.x + 1][pos.y].equals("redGhostAndBlackSpace") || Array[pos.x + 1][pos.y].equals("cyanGhostAndBlackSpace") || Array[pos.x + 1][pos.y].equals("pinkGhostAndBlackSpace") || Array[pos.x + 1][pos.y].equals("orangeGhostAndBlackSpace")){ 
                        if(Model.godMode){ 
                        	score += 200;
                        	pacmanSounds("pacman_eatghost.wav");
                            Array[pos.x + 1][pos.y] = "pacMan"; 
                            Array[pos.x][pos.y] = "blackSpace"; 
                        } 
                        if(!Model.godMode){ 
                            Array[pos.x][pos.y] = "blackSpace";
                            pacmanSounds("pacman_death.wav");
                            ResetPacManAndLoseLife(); 
                        } 
                        right = false; 
                    }else if(Array[pos.x + 1][pos.y].equals("portal")){ 
                        Array[1][14] = "pacMan"; 
                        Array[25][14] = "blackSpace"; 
                        right = false; 
                    }else if(Array[pos.x + 1][pos.y].equals("fruitAndBlackSpace") || Array[pos.x + 1][pos.y].equals("fruitAndPacDot")){
                    	fruits++;
                    	Array[pos.x + 1][pos.y] = "pacMan"; 
                        Array[pos.x][pos.y] = "blackSpace";
                        score += 2 * (Model.level * 100) - 100;
                    }else{ 
                        right = false; 
                    } 
                } 
            } 
        } 
          
          
        //Move left. 
        while(left){ 
            getLocation(); 
            if(pos.x > 0){ 
                if(pos.x - 1 == 16 && pos.y == 14){ 
                    left = false; 
                }else{ 
                    if(Array[pos.x - 1][pos.y].equals("bigPacDot")){
                    	Model.numberOfPacDotsRemaining--;
                    	score += 50;
                    	Model.godMode = true; 
                        pacmanSounds("pacman_chomp.wav");
                        Array[pos.x - 1][pos.y] = "pacMan"; 
                        Array[pos.x][pos.y] = "blackSpace"; 
                        left = false; 
                    }else if(Array[pos.x - 1][pos.y].equals("pacDot")){ 
                    	Model.numberOfPacDotsRemaining--;
                    	score += 10;
                    	pacmanSounds("pacman_chomp.wav");
                    	Array[pos.x - 1][pos.y] = "pacMan"; 
                        Array[pos.x][pos.y] = "blackSpace"; 
                        left = false;
                    }else if(Array[pos.x - 1][pos.y].equals("blackSpace")){
                    	Array[pos.x - 1][pos.y] = "pacMan"; 
                        Array[pos.x][pos.y] = "blackSpace"; 
                        left = false;
                    }else if(Array[pos.x - 1][pos.y].equals("redGhostAndPacDot") || Array[pos.x - 1][pos.y].equals("cyanGhostAndPacDot") || Array[pos.x - 1][pos.y].equals("pinkGhostAndPacDot") || Array[pos.x - 1][pos.y].equals("orangeGhostAndPacDot")){ 
                        if(Model.godMode){ 
                        	score += 200;
                        	pacmanSounds("pacman_eatghost.wav");
                            Array[pos.x - 1][pos.y] = "pacMan"; 
                            Array[pos.x][pos.y] = "blackspace"; 
                        } 
                        if(!Model.godMode){ 
                            Array[pos.x][pos.y] = "pacDot"; 
                            pacmanSounds("pacman_death.wav");
                            ResetPacManAndLoseLife(); 
                        } 
                        left = false; 
                    }else if(Array[pos.x - 1][pos.y].equals("redGhostAndBlackSpace") || Array[pos.x - 1][pos.y].equals("cyanGhostAndBlackSpace") || Array[pos.x - 1][pos.y].equals("pinkGhostAndBlackSpace") || Array[pos.x - 1][pos.y].equals("orangeGhostAndBlackSpace")){ 
                        if(Model.godMode){ 
                        	score += 200;
                        	pacmanSounds("pacman_eatghost.wav");
                            Array[pos.x - 1][pos.y] = "pacMan"; 
                            Array[pos.x][pos.y] = "blackSpace"; 
                        } 
                        if(!Model.godMode){ 
                            Array[pos.x][pos.y] = "blackSpace"; 
                            pacmanSounds("pacman_death.wav");
                            ResetPacManAndLoseLife(); 
                        } 
                        left = false; 
                    }else if(Array[pos.x - 1][pos.y].equals("portal")){ 
                        Array[25][14] = "pacMan"; 
                        Array[1][14] = "blackSpace"; 
                        left = false; 
                    }else if(Array[pos.x - 1][pos.y].equals("fruitAndBlackSpace") || Array[pos.x - 1][pos.y].equals("fruitAndPacDot")){
                    	fruits++;
                    	Array[pos.x - 1][pos.y] = "pacMan"; 
                        Array[pos.x][pos.y] = "blackSpace";
                        score += 2 * (Model.level * 100) - 100;
                    }else{ 
                    left = false; 
                    } 
                } 
            } 
        } 
      
          
          
          
        //Move up. 
        while(up){ 
            getLocation(); 
            if(pos.y > 0){ 
                if(pos.x == 13 && pos.y - 1 == 16){ 
                    up = false; 
                }else{ 
                    if(Array[pos.x][pos.y - 1].equals("bigPacDot")){ 
                    	Model.numberOfPacDotsRemaining--;
                    	score += 50;
                    	Model.godMode = true; 
                        pacmanSounds("pacman_chomp.wav");
                        Array[pos.x][pos.y - 1] = "pacMan"; 
                        Array[pos.x][pos.y] = "blackSpace"; 
                        up = false; 
                    }else if(Array[pos.x][pos.y - 1].equals("pacDot")){ 
                    	Model.numberOfPacDotsRemaining--;
                    	score += 10;
                    	pacmanSounds("pacman_chomp.wav");
                        Array[pos.x][pos.y - 1] = "pacMan"; 
                        Array[pos.x][pos.y] = "blackSpace"; 
                        up = false;
                    }else if(Array[pos.x][pos.y - 1].equals("blackSpace")){
                    	Array[pos.x][pos.y - 1] = "pacMan"; 
                        Array[pos.x][pos.y] = "blackSpace"; 
                        up = false;
                    }else if(Array[pos.x][pos.y - 1].equals("redGhostAndPacDot") || Array[pos.x][pos.y - 1].equals("cyanGhostAndPacDot") || Array[pos.x][pos.y - 1].equals("pinkGhostAndPacDot") || Array[pos.x][pos.y - 1].equals("orangeGhostAndPacDot")){ 
                        if(Model.godMode){ 
                        	score += 200;
                        	pacmanSounds("pacman_eatghost.wav");
                            Array[pos.x][pos.y - 1] = "pacMan"; 
                            Array[pos.x][pos.y] = "blackspace"; 
                        } 
                        if(!Model.godMode){ 
                            Array[pos.x][pos.y] = "pacDot"; 
                            pacmanSounds("pacman_death.wav");
                            ResetPacManAndLoseLife(); 
                        } 
                        up = false; 
                    }else if(Array[pos.x][pos.y - 1].equals("redGhostAndBlackSpace") || Array[pos.x][pos.y - 1].equals("cyanGhostAndBlackSpace") || Array[pos.x][pos.y - 1].equals("pinkGhostAndBlackSpace") || Array[pos.x][pos.y - 1].equals("orangeGhostAndBlackSpace")){ 
                        if(Model.godMode){ 
                        	score += 200;
                        	pacmanSounds("pacman_eatghost.wav");
                            Array[pos.x][pos.y - 1] = "pacMan"; 
                            Array[pos.x][pos.y] = "blackSpace"; 
                        } 
                        if(!Model.godMode){ 
                            Array[pos.x][pos.y] = "blackSpace"; 
                            pacmanSounds("pacman_death.wav");
                            ResetPacManAndLoseLife(); 
                        } 
                        up = false; 
                    }else if(Array[pos.x][pos.y - 1].equals("fruitAndBlackSpace") || Array[pos.x][pos.y - 1].equals("fruitAndPacDot")){
                    	fruits++;
                    	Array[pos.x][pos.y - 1] = "pacMan"; 
                        Array[pos.x][pos.y] = "blackSpace";
                        score += 2 * (Model.level * 100) - 100;
                    }else{ 
                    up = false; 
                    } 
                } 
            } 
        } 

          
          
        //move down. 
        while(down){ 
            getLocation(); 
            if(pos.y < Height - 1){ 
                if(pos.x == 13 && pos.y + 1 == 12){ 
                    down = false; 
                }else{ 
                    if(Array[pos.x][pos.y + 1].equals("bigPacDot")){ 
                    	Model.numberOfPacDotsRemaining--;
                    	score += 50;
                    	Model.godMode = true; 
                        pacmanSounds("pacman_chomp.wav");
                        Array[pos.x][pos.y + 1] = "pacMan"; 
                        Array[pos.x][pos.y] = "blackSpace"; 
                        down = false; 
                    }else if(Array[pos.x][pos.y + 1].equals("pacDot")){
                    	Model.numberOfPacDotsRemaining--;
                    	score += 10;
                    	pacmanSounds("pacman_chomp.wav");
                        Array[pos.x][pos.y + 1] = "pacMan"; 
                        Array[pos.x][pos.y] = "blackSpace"; 
                        down = false; 
                    }else if(Array[pos.x][pos.y + 1].equals("blackSpace")){
                    	Array[pos.x][pos.y + 1] = "pacMan"; 
                        Array[pos.x][pos.y] = "blackSpace"; 
                        down = false; 
                    }else if(Array[pos.x][pos.y + 1].equals("redGhostAndPacDot") || Array[pos.x][pos.y + 1].equals("cyanGhostAndPacDot") || Array[pos.x][pos.y + 1].equals("pinkGhostAndPacDot") || Array[pos.x][pos.y + 1].equals("orangeGhostAndPacDot")){ 
                        if(Model.godMode){ 
                        	score += 200;
                        	pacmanSounds("pacman_eatghost.wav");
                            Array[pos.x][pos.y + 1] = "pacMan"; 
                            Array[pos.x][pos.y] = "blackspace";
                        } 
                        if(! Model.godMode){ 
                            Array[pos.x][pos.y] = "pacDot";
                            pacmanSounds("pacman_death.wav");
                            ResetPacManAndLoseLife(); 
                        } 
                        down = false; 
                    }else if(Array[pos.x][pos.y + 1].equals("redGhostAndBlackSpace") || Array[pos.x][pos.y + 1].equals("cyanGhostAndBlackSpace") || Array[pos.x][pos.y + 1].equals("pinkGhostAndBlackSpace") || Array[pos.x][pos.y + 1].equals("orangeGhostAndBlackSpace")){ 
                        if(Model.godMode){ 
                        	score += 200;
                        	pacmanSounds("pacman_eatghost.wav");
                            Array[pos.x][pos.y + 1] = "pacMan"; 
                            Array[pos.x][pos.y] = "blackSpace"; 
                        } 
                        if(!Model.godMode){ 
                            Array[pos.x][pos.y] = "blackSpace"; 
                            pacmanSounds("pacman_death.wav");
                            ResetPacManAndLoseLife(); 
                        } 
                        down = false; 
                    }else if(Array[pos.x][pos.y + 1].equals("fruitAndBlackSpace") || Array[pos.x][pos.y + 1].equals("fruitAndPacDot")){
                    	Array[pos.x][pos.y + 1] = "pacMan"; 
                        Array[pos.x][pos.y] = "blackSpace";
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
			Array[14][24] = "pacMan"; 
		}
	}
		
	public static void pacmanSounds(String state){
		playSounds.playSound(state);
	}
}
