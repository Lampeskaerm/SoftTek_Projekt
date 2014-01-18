package Pacman;
import java.awt.Point;


public class PinkGhostLocation {
	String[][] Array;
	int Width, Height;
	public Point pinkGhostPos;
	
	public PinkGhostLocation(String[][] Array, int Width, int Height, Point pinkGhostPos){
		this.Array = Array;
		this.Width = Width;
		this.Height = Height;
		this.pinkGhostPos = pinkGhostPos;
	}

	public void getLocation(){
		for(int i = 0; i < Width; i++){
			for(int j = 0; j < Height; j++){
				if(Array[i][j].equals("pinkGhostAndPacDot") || Array[i][j].equals("pinkGhostAndBlackSpace")){
					pinkGhostPos.x = i;
					pinkGhostPos.y = j;
				}
			}
		}
	}
}
