package Pacman;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;


public class View extends JPanel{
	String[][] Array;
	String gameState;
	Frame frame;
	int Width;
	int Height;
	
	public View(String[][] Array, String gameState, Frame frame, int Width, int Height){
		this.Array = Array;
		this.gameState = gameState;
		this.frame = frame;
		this.Width = Width;
		this.Height = Height;
	}
	
	@Override
	public void paintComponent(Graphics g){	
		super.paintComponent(g);
		//if game still on.
		if(gameState.equals("gameOn")){
			g.setColor(Color.black);
			g.fillRect(0, 0, this.frame.getWidth(), this.frame.getHeight());
			//Draws the game using the array.
			for(int i = 0; i < Width; i++){
				for(int j = 0; j < Height; j++){
					if(Array[i][j].equals("pacDot")){
						g.setColor(Color.white);
						g.fillRect(24 * i + 24, 24 * j + 24, 8, 8);
					}else if(Array[i][j].equals("pacMan")){
						g.setColor(Color.yellow);
						g.fillOval(24 * i + 18, 24 * j + 18, 20, 20);
					}else if(Array[i][j].equals("redGhostAndPacDot")){
						g.setColor(Color.red);
						g.fillOval(24 * i + 18, 24 * j + 18, 20, 20);
					}else if(Array[i][j].equals("redGhostAndBlackSpace")){
						g.setColor(Color.red);
						g.fillOval(24 * i + 18, 24 * j + 18, 20, 20);
					}else if(Array[i][j].equals("cyanGhostAndPacDot")){
						g.setColor(Color.cyan);
						g.fillOval(24 * i + 18, 24 * j + 18, 20, 20);
					}else if(Array[i][j].equals("cyanGhostAndBlackSpace")){
						g.setColor(Color.cyan);
						g.fillOval(24 * i + 18, 24 * j + 18, 20, 20);
					}else if(Array[i][j].equals("pinkGhostAndPacDot")){
						g.setColor(Color.pink);
						g.fillOval(24 * i + 18, 24 * j + 18, 20, 20);
					}else if(Array[i][j].equals("pinkGhostAndBlackSpace")){
						g.setColor(Color.pink);
						g.fillOval(24 * i + 18, 24 * j + 18, 20, 20);
					}else if(Array[i][j].equals("orangeGhostAndPacDot")){
						g.setColor(Color.orange);
						g.fillOval(24 * i + 18, 24 * j + 18, 20, 20);
					}else if(Array[i][j].equals("orangeGhostAndBlackSpace")){
						g.setColor(Color.orange);
						g.fillOval(24 * i + 18, 24 * j + 18, 20, 20);
					}else if(Array[i][j].equals("bigPacDot")){
						g.setColor(Color.white);
						g.fillOval(24 * i + 19, 24 * j + 19, 16, 16);
					}else if(Array[i][j].equals("blackSpace")){
						g.setColor(Color.black);
						g.fillRect(24 * i + 16, 24 * j + 16, 24, 24);
					}
				}
			}
			
		//if game over.
		}else if(gameState.equals("gameOver")){
			g.setColor(Color.black);
			g.fillRect(0, 0, this.frame.getWidth(), this.frame.getHeight());
			g.setColor(Color.green);
			Font font = new Font("Arial", Font.BOLD, 30);
			g.setFont(font);
			g.drawString("GAMEOVER!", 100, 50);
			g.drawString("PRESS SPACE", 90, 150);
			g.drawString("TO RESTART!", 95, 200);
			g.drawString("ESC TO EXIT", 100, 300);
		
		//If game is won.
		}else if (gameState.equals("gameWon")){
			g.setColor(Color.black);
			g.fillRect(0, 0, this.frame.getWidth(), this.frame.getHeight());
			g.setColor(Color.green);
			Font font = new Font("Arial", Font.BOLD, 30);
			g.setFont(font);
			g.drawString("GAME WON!", 100, 50);
			g.drawString("PRESS SPACE", 90, 150);
			g.drawString("TO RESTART!", 95, 200);
			g.drawString("ESC TO EXIT", 100, 300);
		}
	}
	
}
