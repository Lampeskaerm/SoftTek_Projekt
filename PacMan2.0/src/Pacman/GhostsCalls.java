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
	
	
	static Ghost redGhost;
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
                if(Array[i][j].equals("redGhost")){ 
                    redPresent = true; 
                } 
                if(Array[i][j].equals("cyanGhost")){ 
                    cyanPresent = true; 
                      
                } 
                if(Array[i][j].equals("pinkGhost") ){ 
                    pinkPresent = true; 
                      
                } 
                if(Array[i][j].equals("orangeGhost") ){ 
                    orangePresent = true; 
                      
                } 
            } 
        } 
        
        if(!redPresent){ 
        	redNotPresent++;
            if(redNotPresent == 100){
            	redGhost.setAllFalse();
            	Array[(int)(Width / 2)][(int)(Height / 2 - 2)] = "redGhost";  
            	redNotPresent = 0;
            }
        } 
        redPresent = false; 
        if(!cyanPresent){ 
        	cyanNotPresent++;
        	if(cyanNotPresent == 100){
        		cyanGhost.setAllFalse();
        		Array[(int)(Width / 2 - 1)][(int)(Height / 2 - 1)] = "cyanGhost"; 
        		cyanNotPresent = 0;
        	}
        } 
        cyanPresent = false; 
        if(!pinkPresent){ 
        	pinkNotPresent++;
        	if(pinkNotPresent == 100){
        		pinkGhost.setAllFalse();
        		Array[(int)(Width / 2)][(int)(Height / 2 - 1)] = "pinkGhost"; 
        		pinkNotPresent = 0;
        	}
        } 
        pinkPresent = false; 
        if(!orangePresent){ 
        	orangeNotPresent++;
        	if(orangeNotPresent == 100){
        		orangeGhost.setAllFalse();
        		Array[(int)(Width / 2 + 1)][(int)(Height / 2 - 1)] = "orangeGhost"; 
        		orangeNotPresent = 0;
        	}
        } 
        orangePresent = false;
	}
	
	public void setAllFalse(){
		redGhost.setAllFalse();
		cyanGhost.setAllFalse();
		pinkGhost.setAllFalse();
		orangeGhost.setAllFalse();
	}
}
