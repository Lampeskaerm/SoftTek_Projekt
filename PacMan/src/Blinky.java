import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;


public class Blinky extends Ghosts{

	public Blinky(Point pos) {
		super(pos);
	}
	
	public void draw(Graphics2D g2d){
		g2d.setColor(Color.red);
		g2d.fillOval(pos.x, pos.y, 10, 10);
	}
	
}
