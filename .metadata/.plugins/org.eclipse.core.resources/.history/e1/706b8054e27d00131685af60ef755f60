package Pacman.GhostsLocs;

import java.awt.Point;


public class CyanGhostLocation {
	String[][] Array;
	int Width, Height;
	public Point cyanGhostPos;
	
	public CyanGhostLocation(String[][] Array, int Width, int Height, Point cyanGhostPos){
		this.Array = Array;
		this.Width = Width;
		this.Height = Height;
		this.cyanGhostPos = cyanGhostPos;
	}

	public void getLocation(){
		for(int i = 0; i < Width; i++){
			for(int j = 0; j < Height; j++){
				if(Array[i][j].equals("cyanGhostAndPacDot") || Array[i][j].equals("cyanGhostAndBlackSpace")){
					cyanGhostPos.x = i;
					cyanGhostPos.y = j;
				}
			}
		}
	}
}
