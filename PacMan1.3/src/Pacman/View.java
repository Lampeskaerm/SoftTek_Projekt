package Pacman;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class View extends JPanel{
	String[][] Array;
	String gameState, redDir, cyanDir, pinkDir, orangeDir;
	Frame frame;
	int Width, Height, lives;
	boolean godMode;
	
	
	public View(String[][] Array, String gameState, Frame frame, int Width, int Height, int lives, boolean godMode, String redDir,
				String cyanDir, String pinkDir, String orangeDir){
		this.Array = Array;
		this.gameState = gameState;
		this.frame = frame;
		this.Width = Width;
		this.Height = Height;
		this.lives = lives;
		this.godMode = godMode;
		this.redDir = redDir;
		this.cyanDir = cyanDir;
		this.pinkDir = pinkDir;
		this.orangeDir = orangeDir;
	}
	
	@Override
	public void paintComponent(Graphics g){	
		super.paintComponent(g);
		//if game still on.
		//if game still on. 
        if(gameState.equals("gameOn")){ 
  
            g.setColor(Color.black); 
            g.fillRect(0, 0, this.frame.getWidth(), this.frame.getHeight()); 
            if(godMode){ 
                g.setColor(Color.green); 
                g.drawString("GODMODE, GO! GO!", 330, 50);
            } 
            //Draws how many lives are remaining. 
            for(int i = 0; i < lives; i++){ 
                g.setColor(Color.yellow); 
                g.fillOval(20 + 20 * i, 600, 14, 14); 
            } 
              
              
            //Draws the game using the array. 
            for(int i = 0; i < Width; i++){ 
                for(int j = 0; j < Height; j++){ 
                    if(Array[i][j].equals("pacDot")){ 
                        g.setColor(Color.white); 
                        g.fillRect(18 * i + 25, 18 * j + 75, 2, 2); 
                    }else if(Array[i][j].equals("pacMan")){ 
                        g.drawImage(getImage("pacman_left1.png"), 18 * i + 20, 18 * j + 68, this);
                    }else if(Array[i][j].equals("redGhostAndPacDot") || Array[i][j].equals("redGhostAndBlackSpace")){ 
                    	g.drawImage(getImage("redGhost_"+redDir+"1.png"), 18 * i + 20, 18 * j + 68, this);
                    }else if(Array[i][j].equals("cyanGhostAndPacDot") || Array[i][j].equals("cyanGhostAndBlackSpace")){ 
                    	g.drawImage(getImage("cyanGhost_"+cyanDir+"1.png"), 18 * i + 20, 18 * j + 68, this); 
                    }else if(Array[i][j].equals("pinkGhostAndPacDot") || Array[i][j].equals("pinkGhostAndBlackSpace")){ 
                    	g.drawImage(getImage("pinkGhost_"+pinkDir+"1.png"), 18 * i + 20, 18 * j + 68, this); 
                    }else if(Array[i][j].equals("orangeGhostAndPacDot") || Array[i][j].equals("orangeGhostAndBlackSpace")){ 
                    	g.drawImage(getImage("orangeGhost_" + orangeDir + "1.png"), 18 * i + 20, 18 * j + 68, this); 
                    }else if(Array[i][j].equals("bigPacDot")){ 
                        g.setColor(Color.white); 
                        g.fillRect(18 * i + 23, 18 * j + 73, 6, 6); 
                    }else if(Array[i][j].equals("blackSpace") || Array[i][j].equals("superSecretBlackSpace")){ 
                        g.setColor(Color.black); 
                        g.fillRect(18 * i + 17, 18 * j + 67, 18, 18); 
                    }else if(Array[i][j].equals("Wall")){ 
                        g.setColor(Color.blue); 
                        g.fillRect(18 * i + 17, 18 * j + 67, 18, 18); 
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
	
	public Image getImage(String itemName){
		Image item;
		
		String imgDir = "Sprites/" + itemName;
		
		ImageIcon ii = new ImageIcon(this.getClass().getResource(imgDir));
		item = ii.getImage();
		
		setDoubleBuffered(true);
		
		return item;
	}
	
}
