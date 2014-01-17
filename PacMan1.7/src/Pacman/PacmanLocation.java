package Pacman;
import java.awt.Point;


public class PacmanLocation {
	String[][] Array;
	int Width, Height;
	Point pacmanPos;
	
	public PacmanLocation(String[][] Array, int Width, int Height, Point pacmanPos){
		this.Array = Array;
		this.Width = Width;
		this.Height = Height;
		this.pacmanPos = pacmanPos;
		
	}
	//Get location functions.
	public void getLocation(){
		for(int i = 0; i < Width; i++){
			for(int j = 0; j < Height; j++){
				if(Array[i][j].equals("pacMan")){
					pacmanPos.x = i;
					pacmanPos.y = j;
				}
			}
		}
	}
}
