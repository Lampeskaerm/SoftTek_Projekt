package Pacman;
import javax.swing.JFrame;

public class PacmanDriver extends JFrame{
	public static int Width, Height;
	public static void main(String[] args){
		new PacmanDriver();
	}
	
	public PacmanDriver(){
		new JFrame();

		this.setTitle("PacMan");
		this.setLocation(50,50);
		this.setResizable(false);
		this.setVisible(true);
		
		Model screen = new Model(this);
		this.add(screen);
	}
	
}
