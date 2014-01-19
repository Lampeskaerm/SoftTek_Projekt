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
	private int redNotPresent = 0;
	private int cyanNotPresent = 0;
	private int pinkNotPresent = 0;
	private int orangeNotPresent = 0;
	
	
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
        for(int i = 0; i < 26; i++){ 
            for(int j = 0; j < 31; j++){ 
                if(Array[i][j].equals("redGhostAndPacDot") || Array[i][j].equals("redGhostAndBlackSpace") || Array[i][j].equals("redGhostAndFruit") || Array[i][j].equals("redGhostAndBigPacDot")){ 
                    redPresent = true; 
                } 
                if(Array[i][j].equals("cyanGhostAndPacDot") || Array[i][j].equals("cyanGhostAndBlackSpace") || Array[i][j].equals("cyanGhostAndFruit") || Array[i][j].equals("cyanGhostAndBigPacDot")){ 
                    cyanPresent = true; 
                      
                } 
                if(Array[i][j].equals("pinkGhostAndPacDot") || Array[i][j].equals("pinkGhostAndBlackSpace") || Array[i][j].equals("pinkGhostAndFruit") || Array[i][j].equals("pinkGhostAndBigPacDot") ){ 
                    pinkPresent = true; 
                      
                } 
                if(Array[i][j].equals("orangeGhostAndPacDot") || Array[i][j].equals("orangeGhostAndBlackSpace") || Array[i][j].equals("orangeGhostAndFruit") || Array[i][j].equals("orangeGhostAndBigPacDot") ){ 
                    orangePresent = true; 
                      
                } 
            } 
        } 
        
        if(!redPresent){ 
        	redNotPresent++;
            if(redNotPresent == 100){
            	Array[(int)(Width / 2)][(int)(Height / 2 - 2)] = "redGhostAndBlackSpace";  
            	System.out.println("not here");
            	redNotPresent = 0;
            }
        } 
        redPresent = false; 
        if(!cyanPresent){ 
        	cyanNotPresent++;
        	if(cyanNotPresent == 100){
        		Array[(int)(Width / 2 - 1)][(int)(Height / 2 - 1)] = "cyanGhostAndBlackSpace"; 
        		cyanNotPresent = 0;
        	}
        } 
        cyanPresent = false; 
        if(!pinkPresent){ 
        	pinkNotPresent++;
        	if(pinkNotPresent == 100){
        		Array[(int)(Width / 2)][(int)(Height / 2 - 1)] = "pinkGhostAndBlackSpace"; 
        		pinkNotPresent = 0;
        	}
        } 
        pinkPresent = false; 
        if(!orangePresent){ 
        	orangeNotPresent++;
        	if(orangeNotPresent == 100){
        		Array[(int)(Width / 2 + 1)][(int)(Height / 2 - 1)] = "orangeGhostAndBlackSpace"; 
        		orangeNotPresent = 0;
        	}
        } 
        orangePresent = false;
	}
}
