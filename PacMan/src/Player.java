import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;


public class Player {
	Point pos;
	public String id = "Pacman";
	
	public Player (Point pos){
		this.pos = pos;
	}
	
	public void draw (Graphics2D g2d){
		g2d.setColor(Color.yellow);
		g2d.fillOval(pos.x, pos.y, 20, 20);
	}
}
