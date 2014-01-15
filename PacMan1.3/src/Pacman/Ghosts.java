package Pacman;
import java.awt.Point;


public class Ghosts {
	String randomMovement = "";
	int Width, Height;
	String[][] Array;
	Point pacmanPos, redGhostPos, cyanGhostPos, pinkGhostPos, orangeGhostPos;
	boolean godMode;
	String gameState;
	
	GetLocations getLocations;
	RedGhost redGhost;
	CyanGhost cyanGhost;
	PinkGhost pinkGhost;
	OrangeGhost orangeGhost;
	
	public Ghosts(String[][] Array, int Width, int Height, Point pacmanPos, Point redGhostPos, Point cyanGhostPos, Point pinkGhostPos, Point orangeGhostPos, boolean godMode, String gameState){
		this.Array = Array;
		this.Width = Width;
		this.Height = Height;
		this.pacmanPos = pacmanPos;
		this.redGhostPos = redGhostPos;
		this.cyanGhostPos = cyanGhostPos;
		this.pinkGhostPos = pinkGhostPos;
		this.orangeGhostPos = orangeGhostPos;
		this.godMode = godMode;
		this.gameState = gameState;
		
		getLocations = new GetLocations(Array, Width, Height, pacmanPos, redGhostPos, cyanGhostPos, pinkGhostPos, orangeGhostPos);
		redGhost = new RedGhost(Array, Width, Height, pacmanPos, redGhostPos, godMode, gameState);
		cyanGhost = new CyanGhost(Array, Width, Height, pacmanPos, cyanGhostPos, godMode, gameState);
		pinkGhost = new PinkGhost(Array, Width, Height, pacmanPos, pinkGhostPos, godMode, gameState);
		orangeGhost = new OrangeGhost(Array, Width, Height, pacmanPos, orangeGhostPos, godMode, gameState);
	}
	
	public void Movements(){
		
		redGhost.Movements();
		if(redGhost.gameState == "GameOver"){
			this.gameState = redGhost.gameState;
		}				
				
		cyanGhost.Movements();
		if(cyanGhost.gameState == "GameOver"){
			this.gameState = cyanGhost.gameState;
		}
						
		pinkGhost.Movements();
		if(pinkGhost.gameState == "GameOver"){
			this.gameState = pinkGhost.gameState;
		}
		
		orangeGhost.Movements();
		if(orangeGhost.gameState == "GameOver"){
			this.gameState = orangeGhost.gameState;
		}
	}
	
	public void checkIfPresent(boolean redPresent, boolean cyanPresent, boolean pinkPresent, boolean orangePresent){
		//check if all ghosts are present, if not they respawn. 
        for(int i = 0; i < 24; i++){ 
            for(int j = 0; j < 29; j++){ 
                if(Array[i][j].equals("redGhostAndPacDot") || Array[i][j].equals("redGhostAndBlackSpace")){ 
                    redPresent = true; 
                } 
                if(Array[i][j].equals("cyanGhostAndPacDot") || Array[i][j].equals("cyanGhostAndBlackSpace")){ 
                    cyanPresent = true; 
                      
                } 
                if(Array[i][j].equals("pinkGhostAndPacDot") || Array[i][j].equals("pinkGhostAndBlackSpace")){ 
                    pinkPresent = true; 
                      
                } 
                if(Array[i][j].equals("orangeGhostAndPacDot") || Array[i][j].equals("orangeGhostAndBlackSpace")){ 
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
