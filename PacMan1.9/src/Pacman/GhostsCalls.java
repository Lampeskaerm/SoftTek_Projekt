package Pacman;
import java.awt.Point;
import java.util.Arrays;
import java.util.List;


public class GhostsCalls {
	String randomMovement = "";
	int Width, Height;
	String[][] Array;
	Point pacmanPos, redGhostPos, cyanGhostPos, pinkGhostPos, orangeGhostPos;
	String redDir = "up", pinkDir = "up", cyanDir = "up", orangeDir = "up";
	
	Ghost redGhost;
	Ghost cyanGhost;
	Ghost pinkGhost;
	Ghost orangeGhost;
	
	public GhostsCalls(String[][] Array, int Width, int Height, Point pacmanPos, Point redGhostPos, Point cyanGhostPos, Point pinkGhostPos, Point orangeGhostPos){
		this.Array = Array;
		this.Width = Width;
		this.Height = Height;
		this.pacmanPos = pacmanPos;
		this.redGhostPos = redGhostPos;
		this.cyanGhostPos = cyanGhostPos;
		this.pinkGhostPos = pinkGhostPos;
		this.orangeGhostPos = orangeGhostPos;
		
		redGhost = new Ghost(orangeGhostPos, Array, Width, Height, "red", pacmanPos);
		cyanGhost = new Ghost(orangeGhostPos, Array, Width, Height, "cyan", pacmanPos);
		pinkGhost = new Ghost(orangeGhostPos, Array, Width, Height, "pink", pacmanPos);
		orangeGhost = new Ghost(orangeGhostPos, Array, Width, Height, "orange", pacmanPos);

	}
	
	public void Movements(){
		
		redGhost.Movements();
		redDir = redGhost.ghost;
							
		cyanGhost.Movements();
		cyanDir = cyanGhost.ghost;
						
		pinkGhost.Movements();
		pinkDir = pinkGhost.ghost;
		
		orangeGhost.Movements();
		orangeDir = orangeGhost.ghost;
	}
	
	public void checkIfPresent(boolean redPresent, boolean cyanPresent, boolean pinkPresent, boolean orangePresent){
		//check if all ghosts are present, if not they respawn. 
        for(int i = 0; i < 24; i++){ 
            for(int j = 0; j < 29; j++){ 
                if(Array[i][j].equals("redGhostAndPacDot") || Array[i][j].equals("redGhostAndBlackSpace") || Array[i][j].equals("redGhostAndFruit")){ 
                    redPresent = true; 
                } 
                if(Array[i][j].equals("cyanGhostAndPacDot") || Array[i][j].equals("cyanGhostAndBlackSpace") || Array[i][j].equals("cyanGhostAndFruit")){ 
                    cyanPresent = true; 
                      
                } 
                if(Array[i][j].equals("pinkGhostAndPacDot") || Array[i][j].equals("pinkGhostAndBlackSpace") || Array[i][j].equals("pinkGhostAndFruit")){ 
                    pinkPresent = true; 
                      
                } 
                if(Array[i][j].equals("orangeGhostAndPacDot") || Array[i][j].equals("orangeGhostAndBlackSpace") || Array[i][j].equals("orangeGhostAndFruit")){ 
                    orangePresent = true; 
                      
                } 
            } 
        } 
        if(!redPresent){ 
            Array[(int)(Width / 2)][(int)(Height / 2 - 2)] = "redGhostAndBlackSpace"; 
        } 
        redPresent = false; 
        if(!cyanPresent){ 
            Array[(int)(Width / 2 - 1)][(int)(Height / 2 - 1)] = "cyanGhostAndBlackSpace"; 
        } 
        cyanPresent = false; 
        if(!pinkPresent){ 
            Array[(int)(Width / 2)][(int)(Height / 2 - 1)] = "pinkGhostAndBlackSpace"; 
        } 
        pinkPresent = false; 
        if(!orangePresent){ 
            Array[(int)(Width / 2 + 1)][(int)(Height / 2 - 1)] = "orangeGhostAndBlackSpace"; 
        } 
        orangePresent = false;
	}
}
