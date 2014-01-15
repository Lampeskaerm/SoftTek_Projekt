package Pacman;
import java.awt.Point;


public class OrangeGhostLocation {
	String[][] Array;
	int Width, Height;
	public Point orangeGhostPos;
	
	public OrangeGhostLocation(String[][] Array, int Width, int Height, Point orangeGhostPos){
		this.Array = Array;
		this.Width = Width;
		this.Height = Height;
		this.orangeGhostPos = orangeGhostPos;
		
		System.out.println("orangeLoc");
	}

	public void getLocation(){
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
