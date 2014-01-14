package Pacman;

import java.util.Scanner;
import javax.swing.JFrame;

public class Frame extends JFrame{
	public static int Width, Height;
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		Width = console.nextInt();
		Height = console.nextInt();
		new Frame();
	}
	
	public Frame(){
		new JFrame();

		this.setTitle("PacMan");
		this.setLocation(400,300);
		this.setResizable(false);
		this.setVisible(true);
		
		Screen screen = new Screen(this, Width, Height);
		this.add(screen);
	
	}
	
}
