package Pacman;

import java.awt.Point;

public class GetLocations {
	int Width, Height;
	String[][] Array;
	Point pacmanPos, redGhostPos, cyanGhostPos, pinkGhostPos, orangeGhostPos;
	
	public GetLocations(String[][] Array, int Width, int Height, Point pacmanPos, Point redGhostPos, Point cyanGhostPos, Point pinkGhostPos, Point orangeGhostPos){
		this.Array = Array;
		this.Width = Width;
		this.Height = Height;
		this.pacmanPos = pacmanPos;
		this.redGhostPos = redGhostPos;
		this.cyanGhostPos = cyanGhostPos;
		this.pinkGhostPos = pinkGhostPos;
		this.orangeGhostPos = orangeGhostPos;
		
	}
	
	//Get location functions.
		public void getLocationPacMan(){
			for(int i = 0; i < Width; i++){
				for(int j = 0; j < Height; j++){
					if(Array[i][j].equals("pacMan")){
						pacmanPos.x = i;
						pacmanPos.y = j;
					}
				}
			}
		}
		
		public void getLocationRedGhost(){
			for(int i = 0; i < Width; i++){
				for(int j = 0; j < Height; j++){
					if(Array[i][j].equals("redGhostAndPacDot") || Array[i][j].equals("redGhostAndBlackSpace")){
						redGhostPos.x = i;
						redGhostPos.y = j;
					}
				}
			}
		}
		
		public void getLocationCyanGhost(){
			for(int i = 0; i < Width; i++){
				for(int j = 0; j < Height; j++){
					if(Array[i][j].equals("cyanGhostAndPacDot") || Array[i][j].equals("cyanGhostAndBlackSpace")){
						cyanGhostPos.x = i;
						cyanGhostPos.y = j;
					}
				}
			}
		}
		
		public void getLocationPinkGhost(){
			for(int i = 0; i < Width; i++){
				for(int j = 0; j < Height; j++){
					if(Array[i][j].equals("pinkGhostAndPacDot") || Array[i][j].equals("pinkGhostAndBlackSpace")){
						pinkGhostPos.x = i;
						pinkGhostPos.y = j;
					}
				}
			}
		}
		
		public void getLocationOrangeGhost(){
			for(int i = 0; i < Width; i++){
				for(int j = 0; j < Height; j++){
					if(Array[i][j].equals("orangeGhostAndPacDot") || Array[i][j].equals("orangeGhostAndBlackSpace")){
						orangeGhostPos.x = i;
						orangeGhostPos.y = j;
					}
				}
			}
		}
}
