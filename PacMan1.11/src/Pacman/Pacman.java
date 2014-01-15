package Pacman;

import java.awt.Point;

public class Pacman {
	PacmanLocation pacmanLoc;
	
	Point pacmanPos;
	String[][] Array;
	boolean godMode, right, left, up, down;
	int Width, Height;
	
	public Pacman (String[][] Array, int Width, int Height, boolean godMode, Point pacmanPos, boolean right, boolean left, boolean up, boolean down){
		this.pacmanPos = pacmanPos;
		this.Array = Array;
		this.godMode = godMode;
		this.Width = Width;
		this.Height = Height;
		this.right = right;
		this.left = left;
		this.up = up;
		this.down = down;
		
		pacmanLoc = new PacmanLocation(Array, Width, Height, pacmanPos);
	}
	
	public void movePacman(){
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
                        Array[pacmanPos.x + 1][pacmanPos.y] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        right = false; 
                    }else if(Array[pacmanPos.x + 1][pacmanPos.y].equals("pacDot") || Array[pacmanPos.x + 1][pacmanPos.y].equals("blackSpace")){ 
                        Array[pacmanPos.x + 1][pacmanPos.y] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        right = false; 
                    }else if(Array[pacmanPos.x + 1][pacmanPos.y].equals("Wall")){ 
                        right = false; 
                    }else if(Array[pacmanPos.x + 1][pacmanPos.y].equals("redGhostAndPacDot") || Array[pacmanPos.x + 1][pacmanPos.y].equals("cyanGhostAndPacDot") || Array[pacmanPos.x + 1][pacmanPos.y].equals("pinkGhostAndPacDot") || Array[pacmanPos.x + 1][pacmanPos.y].equals("orangeGhostAndPacDot")){ 
                        if(godMode){ 
                            Array[pacmanPos.x + 1][pacmanPos.y] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "pacDot"; 
                        } 
                        if(!godMode){ 
                            Array[pacmanPos.x][pacmanPos.y] = "pacDot"; 
                            ResetPacManAndLoseLife(); 
                        } 
                        right = false; 
                    }else if(Array[pacmanPos.x + 1][pacmanPos.y].equals("redGhostAndBlackSpace") || Array[pacmanPos.x + 1][pacmanPos.y].equals("cyanGhostAndBlackSpace") || Array[pacmanPos.x + 1][pacmanPos.y].equals("pinkGhostAndBlackSpace") || Array[pacmanPos.x + 1][pacmanPos.y].equals("orangeGhostAndBlackSpace")){ 
                        if(godMode){ 
                            Array[pacmanPos.x + 1][pacmanPos.y] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        } 
                        if(!godMode){ 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
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
                        Array[pacmanPos.x - 1][pacmanPos.y] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        left = false; 
                    }else if(Array[pacmanPos.x - 1][pacmanPos.y].equals("pacDot") || Array[pacmanPos.x - 1][pacmanPos.y].equals("blackSpace") || Array[pacmanPos.x - 1][pacmanPos.y].equals("bigPacDot")){ 
                        Array[pacmanPos.x - 1][pacmanPos.y] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        left = false; 
                    }else if(Array[pacmanPos.x - 1][pacmanPos.y].equals("Wall")){ 
                        left = false; 
                    }else if(Array[pacmanPos.x - 1][pacmanPos.y].equals("redGhostAndPacDot") || Array[pacmanPos.x - 1][pacmanPos.y].equals("cyanGhostAndPacDot") || Array[pacmanPos.x - 1][pacmanPos.y].equals("pinkGhostAndPacDot") || Array[pacmanPos.x - 1][pacmanPos.y].equals("orangeGhostAndPacDot")){ 
                        if(godMode){ 
                            Array[pacmanPos.x - 1][pacmanPos.y] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "pacDot"; 
                        } 
                        if(!godMode){ 
                            Array[pacmanPos.x][pacmanPos.y] = "pacDot"; 
                            ResetPacManAndLoseLife(); 
                        } 
                        left = false; 
                    }else if(Array[pacmanPos.x - 1][pacmanPos.y].equals("redGhostAndBlackSpace") || Array[pacmanPos.x - 1][pacmanPos.y].equals("cyanGhostAndBlackSpace") || Array[pacmanPos.x - 1][pacmanPos.y].equals("pinkGhostAndBlackSpace") || Array[pacmanPos.x - 1][pacmanPos.y].equals("orangeGhostAndBlackSpace")){ 
                        if(godMode){ 
                            Array[pacmanPos.x - 1][pacmanPos.y] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        } 
                        if(!godMode){ 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
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
                        Array[pacmanPos.x][pacmanPos.y - 1] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        up = false; 
                    }else if(Array[pacmanPos.x][pacmanPos.y - 1].equals("pacDot") || Array[pacmanPos.x][pacmanPos.y - 1].equals("blackSpace") || Array[pacmanPos.x][pacmanPos.y - 1].equals("bigPacDot")){ 
                        Array[pacmanPos.x][pacmanPos.y - 1] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        up = false; 
                    }else if(Array[pacmanPos.x][pacmanPos.y - 1].equals("Wall")){ 
                        up = false; 
                    }else if(Array[pacmanPos.x][pacmanPos.y - 1].equals("redGhostAndPacDot") || Array[pacmanPos.x][pacmanPos.y - 1].equals("cyanGhostAndPacDot") || Array[pacmanPos.x][pacmanPos.y - 1].equals("pinkGhostAndPacDot") || Array[pacmanPos.x][pacmanPos.y - 1].equals("orangeGhostAndPacDot")){ 
                        if(godMode){ 
                            Array[pacmanPos.x][pacmanPos.y - 1] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "pacDot"; 
                        } 
                        if(!godMode){ 
                            Array[pacmanPos.x][pacmanPos.y] = "pacDot"; 
                            ResetPacManAndLoseLife(); 
                        } 
                        up = false; 
                    }else if(Array[pacmanPos.x][pacmanPos.y - 1].equals("redGhostAndBlackSpace") || Array[pacmanPos.x][pacmanPos.y - 1].equals("cyanGhostAndBlackSpace") || Array[pacmanPos.x][pacmanPos.y - 1].equals("pinkGhostAndBlackSpace") || Array[pacmanPos.x][pacmanPos.y - 1].equals("orangeGhostAndBlackSpace")){ 
                        if(godMode){ 
                            Array[pacmanPos.x][pacmanPos.y - 1] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        } 
                        if(!godMode){ 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
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
                        Array[pacmanPos.x][pacmanPos.y + 1] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        down = false; 
                    }else if(Array[pacmanPos.x][pacmanPos.y + 1].equals("pacDot") || Array[pacmanPos.x][pacmanPos.y + 1].equals("blackSpace") || Array[pacmanPos.x][pacmanPos.y + 1].equals("bigPacDot")){ 
                        Array[pacmanPos.x][pacmanPos.y + 1] = "pacMan"; 
                        Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        down = false; 
                    }else if(Array[pacmanPos.x][pacmanPos.y + 1].equals("Wall")){ 
                        down = false; 
                    }else if(Array[pacmanPos.x][pacmanPos.y + 1].equals("redGhostAndPacDot") || Array[pacmanPos.x][pacmanPos.y + 1].equals("cyanGhostAndPacDot") || Array[pacmanPos.x][pacmanPos.y + 1].equals("pinkGhostAndPacDot") || Array[pacmanPos.x][pacmanPos.y + 1].equals("orangeGhostAndPacDot")){ 
                        if(godMode){ 
                            Array[pacmanPos.x][pacmanPos.y + 1] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "pacDot"; 
                        } 
                        if(!godMode){ 
                            Array[pacmanPos.x][pacmanPos.y] = "pacDot"; 
                            ResetPacManAndLoseLife(); 
                        } 
                        down = false; 
                    }else if(Array[pacmanPos.x][pacmanPos.y + 1].equals("redGhostAndBlackSpace") || Array[pacmanPos.x][pacmanPos.y + 1].equals("cyanGhostAndBlackSpace") || Array[pacmanPos.x][pacmanPos.y + 1].equals("pinkGhostAndBlackSpace") || Array[pacmanPos.x][pacmanPos.y + 1].equals("orangeGhostAndBlackSpace")){ 
                        if(godMode){ 
                            Array[pacmanPos.x][pacmanPos.y + 1] = "pacMan"; 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                        } 
                        if(!godMode){ 
                            Array[pacmanPos.x][pacmanPos.y] = "blackSpace"; 
                            ResetPacManAndLoseLife(); 
                        } 
                        down = false; 
                    }else{ 
                    down = false; 
                    } 
                } 
            } 
        }
	}
	
	public void ResetPacManAndLoseLife(){
		
	}
}
