package Pacman;

import java.awt.Point;

public class Objects {
	Point pos;
	int Width, Height;
	String[][] Array;
	
	public Objects(Point pos, String[][] Array, int Width, int Height){
		this.pos = pos;
		this.Width = Width;
		this.Height = Height;
		this.Array = Array;
	}
}
