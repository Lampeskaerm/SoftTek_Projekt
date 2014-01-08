import javax.swing.JFrame;

public class Frame extends JFrame{

	public static void main(String[] args){
		new Frame();
	}
	
	public Frame(){
		new JFrame();

		this.setTitle("PacMan");
		this.setLocation(400,300);
		this.setResizable(false);
		this.setVisible(true);
		
		Screen screen = new Screen(this);
		this.add(screen);
	
	}
	
}
