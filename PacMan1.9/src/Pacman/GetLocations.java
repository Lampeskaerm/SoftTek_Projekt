package Pacman;
import java.awt.Point;



public class GetLocations {
	int Width, Height;
	String[][] Array;
	Point pacmanPos, redGhostPos, cyanGhostPos, pinkGhostPos, orangeGhostPos;
	
	RedGhostLocation redGhostLoc;
	Pacman pacman;
	CyanGhostLocation cyanGhostLoc;
	PinkGhostLocation pinkGhostLoc;
	Ghost orangeGhost;
	
	public GetLocations(String[][] Array, int Width, int Height, Point pacmanPos, Point redGhostPos, Point cyanGhostPos, Point pinkGhostPos, Point orangeGhostPos){
		this.Array = Array;
		this.Width = Width;
		this.Height = Height;
		this.pacmanPos = pacmanPos;
		this.redGhostPos = redGhostPos;
		this.cyanGhostPos = cyanGhostPos;
		this.pinkGhostPos = pinkGhostPos;
		this.orangeGhostPos = orangeGhostPos;
		
		redGhostLoc = new RedGhostLocation(Array, Width, Height, redGhostPos);
		pacman = new Pacman(pacmanPos, Array, Width, Height);
		cyanGhostLoc = new CyanGhostLocation(Array, Width, Height, cyanGhostPos);
		pinkGhostLoc = new PinkGhostLocation(Array, Width, Height, pinkGhostPos);
		orangeGhost = new Ghost(orangeGhostPos, Array, Width, Height, "orange", pacmanPos);
	}
	
	//Get location functions.
	public void getLocationPacMan(){
		pacman.getLocation();
		pacmanPos = pacman.pos;
	}
	
	public void getLocationRedGhost(){
		redGhostLoc.getLocation();
		redGhostPos = redGhostLoc.redGhostPos;
	}
	
	public void getLocationCyanGhost(){
		cyanGhostLoc.getLocation();
		cyanGhostPos = cyanGhostLoc.cyanGhostPos;
	}
	
	public void getLocationPinkGhost(){
		pinkGhostLoc.getLocation();
		pinkGhostPos = pinkGhostLoc.pinkGhostPos;
	}
	
	public void getLocationOrangeGhost(){
		orangeGhost.getLocation();
		orangeGhostPos = orangeGhost.pos;
	}
}
