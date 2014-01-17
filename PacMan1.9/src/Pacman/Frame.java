package Pacman;
import java.util.Scanner;
import javax.swing.JFrame;

public class Frame extends JFrame{
	public static int Width, Height;
	public static void main(String[] args){
		new Frame();
	}
	
	public Frame(){
		new JFrame();

		this.setTitle("PacMan");
		this.setLocation(50,50);
		this.setResizable(false);
		this.setVisible(true);
		
		Model screen = new Model(this);
		this.add(screen);
	}
	
}
