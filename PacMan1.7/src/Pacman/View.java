package Pacman;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class View extends JPanel{
	String[][] Array;
	String redDir, cyanDir, pinkDir, orangeDir, pacmanDir;
	Frame frame;
	int Width, Height, lives;
	SpriteLoad spriteload;
	
	
	
	public View(String[][] Array, Frame frame, int Width, int Height, String redDir,
				String cyanDir, String pinkDir, String orangeDir, String pacmanDir){
		this.Array = Array;
		this.frame = frame;
		this.Width = Width;
		this.Height = Height;
		this.redDir = redDir;
		this.cyanDir = cyanDir;
		this.pinkDir = pinkDir;
		this.orangeDir = orangeDir;
		this.pacmanDir = pacmanDir;
	}
	
	public void initiateSpriteLoad(){
		SpriteLoad spriteload = new SpriteLoad();
	}
	
	
	@Override
	public void paintComponent(Graphics g){	
		super.paintComponent(g);
		//if game still on. 
        if(Model.gameState.equals("gameOn")){ 
  
            g.setColor(Color.black); 
            g.fillRect(0, 0, this.frame.getWidth(), this.frame.getHeight()); 
            if(Model.godMode){ 
            	g.setColor(Color.white);
                Font font = new Font("Arial", Font.BOLD, 20); 
                g.setFont(font); 
                g.drawString("GODMODE, GO! GO!", 260, 50);
            } 
            //Draws how many lives are remaining. 
            for(int i = 0; i < Pacman.lives; i++){ 
            	g.drawImage(SpriteLoad.sprites[2], 20 + 20 * i, 650, this);  
            } 
            //Draws how many fruits are collected.
            for(int i = 0; i < Pacman.fruits; i++){ 
            	g.drawImage(SpriteLoad.sprites[27], 300 + 20 * i, 650, this);
            }
            
            //Shows the current score.
            g.setColor(Color.white);
            Font font = new Font("Arial", Font.BOLD, 20); 
            g.setFont(font); 
            g.drawString(Pacman.score + "", 50, 50);
            
            //Shows current level.
            g.setColor(Color.white);
            g.setFont(font); 
            g.drawString("Level " + Model.level + "", 150, 50);
                      
            //Draws the game using the array. 
            for(int i = 0; i < Width; i++){ 
                for(int j = 0; j < Height; j++){ 
                    if(Array[i][j].equals("pacDot")){ 
                        g.setColor(Color.white); 
                        g.fillRect(18 * i + 25, 18 * j + 75, 2, 2); 
                    }else if(Array[i][j].equals("pacMan")){ 
                    	if(pacmanDir.equals("up")){
                    		g.drawImage(SpriteLoad.sprites[4], 18 * i + 18, 18 * j + 67, this);
                    	}else if(pacmanDir.equals("down")){
                    		g.drawImage(SpriteLoad.sprites[6], 18 * i + 18, 18 * j + 67, this);
                    	}else if(pacmanDir.equals("right")){
                    		g.drawImage(SpriteLoad.sprites[2], 18 * i + 18, 18 * j + 67, this);
                    	}else if(pacmanDir.equals("left")){
                    		g.drawImage(SpriteLoad.sprites[0], 18 * i + 18, 18 * j + 67, this);
                    	}
                    }else if(Array[i][j].equals("redGhostAndPacDot") || Array[i][j].equals("redGhostAndBlackSpace") || Array[i][j].equals("redGhostAndFruit")){ 
                    	if(redDir.equals("up")){
                    		g.drawImage(SpriteLoad.sprites[9], 18 * i + 18, 18 * j + 67, this);
                    	}else if(redDir.equals("down")){
                    		g.drawImage(SpriteLoad.sprites[10], 18 * i + 18, 18 * j + 67, this);
                    	}else if(redDir.equals("left")){
                    		g.drawImage(SpriteLoad.sprites[11], 18 * i + 18, 18 * j + 67, this);
                    	}else if(redDir.equals("right")){
                    		g.drawImage(SpriteLoad.sprites[12], 18 * i + 18, 18 * j + 67, this);
                    	}
                    }else if(Array[i][j].equals("pinkGhostAndPacDot") || Array[i][j].equals("pinkGhostAndBlackSpace") || Array[i][j].equals("pinkGhostAndFruit")){ 
                    	if(pinkDir.equals("up")){
                    		g.drawImage(SpriteLoad.sprites[13], 18 * i + 18, 18 * j + 67, this);
                    	}else if(pinkDir.equals("down")){
                    		g.drawImage(SpriteLoad.sprites[14], 18 * i + 18, 18 * j + 67, this);
                    	}else if(pinkDir.equals("left")){
                    		g.drawImage(SpriteLoad.sprites[15], 18 * i + 18, 18 * j + 67, this);
                    	}else if(pinkDir.equals("right")){
                    		g.drawImage(SpriteLoad.sprites[16], 18 * i + 18, 18 * j + 67, this);
                    	}
                    }else if(Array[i][j].equals("cyanGhostAndPacDot") || Array[i][j].equals("cyanGhostAndBlackSpace") || Array[i][j].equals("cyanGhostAndFruit")){ 
                    	if(cyanDir.equals("up")){
                    		g.drawImage(SpriteLoad.sprites[17], 18 * i + 18, 18 * j + 67, this);
                    	}else if(cyanDir.equals("down")){
                    		g.drawImage(SpriteLoad.sprites[18], 18 * i + 18, 18 * j + 67, this);
                    	}else if(cyanDir.equals("left")){
                    		g.drawImage(SpriteLoad.sprites[19], 18 * i + 18, 18 * j + 67, this);
                    	}else if(cyanDir.equals("right")){
                    		g.drawImage(SpriteLoad.sprites[20], 18 * i + 18, 18 * j + 67, this);
                    	}
                    }else if(Array[i][j].equals("orangeGhostAndPacDot") || Array[i][j].equals("orangeGhostAndBlackSpace") || Array[i][j].equals("orangeGhostAndFruit")){ 
                    	if(orangeDir.equals("up")){
                    		g.drawImage(SpriteLoad.sprites[21], 18 * i + 18, 18 * j + 67, this);
                    	}else if(orangeDir.equals("down")){
                    		g.drawImage(SpriteLoad.sprites[22], 18 * i + 18, 18 * j + 67, this);
                    	}else if(orangeDir.equals("left")){
                    		g.drawImage(SpriteLoad.sprites[23], 18 * i + 18, 18 * j + 67, this);
                    	}else if(orangeDir.equals("right")){
                    		g.drawImage(SpriteLoad.sprites[24], 18 * i + 18, 18 * j + 67, this);
                    	}
                    }else if(Array[i][j].equals("bigPacDot")){ 
                        g.setColor(Color.white); 
                        g.fillRect(18 * i + 23, 18 * j + 73, 6, 6); 
                    }else if(Array[i][j].equals("blackSpace") || Array[i][j].equals("superSecretBlackSpace")){ 
                        g.setColor(Color.black); 
                        g.fillRect(18 * i + 17, 18 * j + 67, 18, 18); 
                    }else if(Array[i][j].equals("horizontalWall")){ 
                    	g.drawImage(SpriteLoad.sprites[37], 18 * i + 18, 18 * j + 67, this); 
                    }else if(Array[i][j].equals("verticalWall")){
                    	g.drawImage(SpriteLoad.sprites[36], 18 * i + 18, 18 * j + 67, this);
                    }else if(Array[i][j].equals("downLeftWall")){
                    	g.drawImage(SpriteLoad.sprites[41], 18 * i + 18, 18 * j + 67, this);
                    }else if(Array[i][j].equals("upLeftWall")){
                    	g.drawImage(SpriteLoad.sprites[38], 18 * i + 18, 18 * j + 67, this);
                    }else if(Array[i][j].equals("downRightWall")){
                    	g.drawImage(SpriteLoad.sprites[40], 18 * i + 18, 18 * j + 67, this);
                    }else if(Array[i][j].equals("upRightWall")){
                    	g.drawImage(SpriteLoad.sprites[39], 18 * i + 18, 18 * j + 67, this);
                    }else if(Array[i][j].equals("fruitAndBlackSpace") || Array[i][j].equals("fruitAndPacDot")){
                    	if(Model.level == 1){
                    		g.drawImage(SpriteLoad.sprites[27], 18 * i + 18, 18 * j + 67, this);
                    	}else if(Model.level == 2){
                    		g.drawImage(SpriteLoad.sprites[28], 18 * i + 18, 18 * j + 67, this);
                    	}else if(Model.level == 3){
                    		g.drawImage(SpriteLoad.sprites[29], 18 * i + 18, 18 * j + 67, this);
                    	}else if(Model.level > 3){
                    		g.drawImage(SpriteLoad.sprites[30], 18 * i + 18, 18 * j + 67, this);
                    	}
                    }
                } 
            } 
              
        //if game over. 
        }else if(Model.gameState.equals("gameOver")){ 
            g.setColor(Color.black); 
            g.fillRect(0, 0, this.frame.getWidth(), this.frame.getHeight()); 
            g.setColor(Color.green); 
            Font font = new Font("Arial", Font.BOLD, 30); 
            g.setFont(font); 
            g.drawString("GAMEOVER!", 100, 50); 
            g.drawString("PRESS SPACE", 90, 150); 
            g.drawString("TO RESTART!", 95, 200); 
            g.drawString("ESC TO EXIT", 100, 300); 
        }
	}

}
