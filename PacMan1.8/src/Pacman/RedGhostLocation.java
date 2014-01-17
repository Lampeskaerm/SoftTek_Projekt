package Pacman;
import java.awt.Point;


public class RedGhostLocation {
	String[][] Array;
	int Width, Height;
	public Point redGhostPos;
	
	public RedGhostLocation(String[][] Array, int Width, int Height, Point redGhostPos){
		this.Array = Array;
		this.Width = Width;
		this.Height = Height;
		this.redGhostPos = redGhostPos;
	}

	public void getLocation(){
		for(int i = 0; i < Width; i++){
			for(int j = 0; j < Height; j++){
				if(Array[i][j].equals("redGhostAndPacDot") || Array[i][j].equals("redGhostAndBlackSpace")){
					redGhostPos.x = i;
					redGhostPos.y = j;
				}
			}
		}
	}
}
