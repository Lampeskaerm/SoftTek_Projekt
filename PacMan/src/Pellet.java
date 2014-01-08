import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;



public class Pellet extends JPanel{
	Point pos;
	public String id = "Pellet";
	
	public Pellet (Point pos){
		this.pos = pos;
	}
	
	public void draw(Graphics2D g2d) {
		
		g2d.setColor(Color.white);
		g2d.fillRect(pos.x, pos.y, 8, 8);
	}
	
}
