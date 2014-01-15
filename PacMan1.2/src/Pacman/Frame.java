package Pacman;
import java.util.Scanner;
import javax.swing.JFrame;

public class Frame extends JFrame{
	public static int Width, Height;
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		new Frame();
	}
	
	public Frame(){
		new JFrame();

		this.setTitle("PacMan");
		this.setLocation(400,300);
		this.setResizable(false);
		this.setVisible(true);
		
		Model screen = new Model(this);
		this.add(screen);
	}
	
}
