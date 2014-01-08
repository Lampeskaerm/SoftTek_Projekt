import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;


public class Clyde extends Ghosts{

	public Clyde(Point pos) {
		super(pos);
	}
	
	public void draw(Graphics2D g2d){
		g2d.setColor(Color.orange);
		g2d.fillOval(pos.x, pos.y, 10, 10);
	}
	
}
