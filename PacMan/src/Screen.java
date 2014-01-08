import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
  
public class Screen extends JPanel implements Runnable, ActionListener { 
    Thread thread = new Thread(this); 
      
    Frame frame; 
    public boolean running = false; 
    public int gameState = 1; //If game is still running = 1, if gameover = 0. 
    private boolean space = false; 
      
    //Movement variables. 
    public boolean right = false; 
    public boolean left = false; 
    public boolean up = false; 
    public boolean down = false; 
      
    //Location variables. 
    public int locationPacManx = 0; 
    public int locationPacMany = 0; 
    private int locationRedGhostx = 0; 
    private int locationRedGhosty = 0; 
    private int locationCyanGhostx = 0; 
    private int locationCyanGhosty = 0; 
    private int locationPinkGhostx = 0; 
    private int locationPinkGhosty = 0; 
    private int locationOrangeGhostx = 0; 
    private int locationOrangeGhosty = 0; 
      
      
    private int Heigth = 15; 
    private int Width = 15; 
    private int [][] Array = new int[Width][Heigth]; //Maybe change to String array? to easier see what is going on. 
    
    JButton button;
      
    public Screen(Frame frame){ 
        this.frame = frame; 
        frame.setSize(Width * 25 + 24, Heigth * 25 + 48); 
        this.frame.addKeyListener(new KeyHandler(this)); 
        thread.start(); 
        

        
        button = new JButton("Click Me");
        add(button);
        button.addActionListener(this);
        button.setVisible(false);
    } 
      
    //Game area integers. 
    //0 = black space. 
    //1 = pac dots. 
    //2 = pacman. 
    //3 = red ghost. 
    //4 = cyan ghost. 
    //5 = pink ghost. 
    //6 = orange ghost. 
    //7 = big pac dots. 
      
      
    //Greates array with correct starting integers. 
    public void arrayStatus(){ 
        for(int i = 0; i < Width; i++){ 
            for(int j = 0; j < Heigth; j++){ 
                Array[i][j] = 1; 
            } 
        } 
        Array[(int)(Width / 2)][Heigth - 2] = 2; 
        Array[(int)(Width / 2)][(int)(Heigth / 2 - 1)] = 3; 
        Array[(int)(Width / 2 - 1)][(int)(Heigth / 2)] = 4; 
        Array[(int)(Width / 2)][(int)(Heigth / 2)] = 5; 
        Array[(int)(Width / 2 + 1)][(int)(Heigth / 2)] = 6; 
        Array[1][1] = 7; 
        Array[1][Heigth - 2] = 7; 
        Array[Width - 2][1] = 7; 
        Array[Width - 2][Heigth - 2] = 7; 
    } 
      
    public void paintComponent(Graphics g){  
  
        //if game still on. 
        if(gameState == 1){ 
            g.setColor(Color.black); 
            g.fillRect(0, 0, this.frame.getWidth(), this.frame.getHeight()); 
            //Draws the game using the array. 
            for(int i = 0; i < Width; i++){ 
                for(int j = 0; j < Heigth; j++){ 
                    if(Array[i][j] == 1){ 
                        g.setColor(Color.white); 
                        g.fillRect(24 * i + 24, 24 * j + 24, 8, 8); 
                    }else if(Array[i][j] == 2){ 
                        g.setColor(Color.yellow); 
                        g.fillOval(24 * i + 18, 24 * j + 18, 20, 20); 
                    }else if(Array[i][j] == 3){ 
                        g.setColor(Color.red); 
                        g.fillOval(24 * i + 18, 24 * j + 18, 20, 20); 
                    }else if(Array[i][j] == 4){ 
                        g.setColor(Color.cyan); 
                        g.fillOval(24 * i + 18, 24 * j + 18, 20, 20); 
                    }else if(Array[i][j] == 5){ 
                        g.setColor(Color.pink); 
                        g.fillOval(24 * i + 18, 24 * j + 18, 20, 20); 
                    }else if(Array[i][j] == 6){ 
                        g.setColor(Color.orange); 
                        g.fillOval(24 * i + 18, 24 * j + 18, 20, 20); 
                    }else if(Array[i][j] == 7){ 
                        g.setColor(Color.white); 
                        g.fillOval(24 * i + 19, 24 * j + 19, 16, 16); 
                    }else if(Array[i][j] == 0){ 
                        g.setColor(Color.black); 
                        g.fillRect(24 * i + 16, 24 * j + 16, 24, 24); 
                    } 
                } 
            } 
        //if game over, maybe do so that the game just restarts. 
        }else if(gameState == 0){ 
            g.setColor(Color.black); 
            g.fillRect(0, 0, this.frame.getWidth(), this.frame.getHeight()); 
            g.setColor(Color.green); 
            Font font = new Font("Arial", Font.BOLD, 30); 
            g.setFont(font); 
            g.drawString("GAMEOVER!", 100, 50); 
            
            button.setVisible(true);
        } 
    } 
      
    public void run() { 
          
        //Goes once: 
        arrayStatus(); 
        getLocationPacMan(); 
        running = true; 
      
          
        //updates: 
        while(running){ 
          
            //movements: 
            //Move right. 
            while(right){ 
                getLocationPacMan(); 
                if(locationPacManx < Width - 1){ 
                Array[locationPacManx + 1][locationPacMany] = 2; 
                Array[locationPacManx][locationPacMany] = 0; 
                right = false; 
                }else{ 
                    right = false; 
                } 
            } 
            right = false; 
              
              
            //Move left. 
            while(left){ 
                getLocationPacMan(); 
                if(locationPacManx > 0){ 
                Array[locationPacManx - 1][locationPacMany] = 2; 
                Array[locationPacManx][locationPacMany] = 0; 
                left = false; 
                }else{ 
                    left = false; 
                } 
            } 
            left = false; 
              
              
            //Move up. 
            while(up){ 
                getLocationPacMan(); 
                if(locationPacMany > 0){ 
                    Array[locationPacManx][locationPacMany - 1] = 2; 
                    Array[locationPacManx][locationPacMany] = 0; 
                    up = false; 
                }else{ 
                    up = false; 
                } 
            } 
            up = false; 
              
              
            //move down. 
            while(down){ 
                getLocationPacMan(); 
                if(locationPacMany < Heigth - 1){ 
                    Array[locationPacManx][locationPacMany + 1] = 2; 
                    Array[locationPacManx][locationPacMany] = 0; 
                    down = false; 
                }else{ 
                    down = false; 
                  
                } 
            } 
            down = false; 
              
            //Checks for collision with ghosts, gameover if this happends. 
            getLocationPacMan(); 
            getLocationRedGhost(); 
            if(locationPacManx == locationRedGhostx && locationPacMany == locationRedGhosty){ 
                gameState = 0; 
            } 
              
            getLocationCyanGhost(); 
            if(locationPacManx == locationCyanGhostx && locationPacMany == locationCyanGhosty){ 
                gameState = 0; 
            } 
              
            getLocationPinkGhost(); 
            if(locationPacManx == locationPinkGhostx && locationPacMany == locationPinkGhosty){ 
                gameState = 0; 
            } 
              
            getLocationOrangeGhost(); 
            if(locationPacManx == locationOrangeGhostx && locationPacMany == locationOrangeGhosty){ 
                gameState = 0; 
            } 
              
            //Make so that when the gameover screen is up you can restart by pressing enter or space. 
            /*if(space == true){ 
                gameState = 1; 
                arrayStatus(); 
                space = false; 
            }*/
  
            //update graphics. 
            frame.getContentPane().repaint(); 
              
            //Limits max fps: 
            try { 
                Thread.sleep(20); //stops the program for 20 milliseconds before going on, therefore the max fps is 50 fps. 
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 
        } 
        System.exit(0); 
    } 
      
      
    //Input 
    public class KeyTyped{ 
        public void keyESC(){ 
            running = false; 
        } 
          
        public void KeyRight(){ 
            right = true; 
        } 
          
        public void KeyLeft(){ 
            left = true; 
        } 
          
        public void KeyUp(){ 
            up = true; 
        } 
          
        public void KeyDown(){ 
            down = true; 
        } 
          
        public void KeySpace(){ 
            space = true; 
        } 
    } 
      
      
      
    //Get location functions. 
    public void getLocationPacMan(){ 
        for(int i = 0; i < Width; i++){ 
            for(int j = 0; j < Heigth; j++){ 
                if(Array[i][j] == 2){ 
                    locationPacManx = i; 
                    locationPacMany = j; 
                } 
            } 
        } 
    } 
      
    public void getLocationRedGhost(){ 
        for(int i = 0; i < Width; i++){ 
            for(int j = 0; j < Heigth; j++){ 
                if(Array[i][j] == 3){ 
                    locationRedGhostx = i; 
                    locationRedGhosty = j; 
                } 
            } 
        } 
    } 
      
    public void getLocationCyanGhost(){ 
        for(int i = 0; i < Width; i++){ 
            for(int j = 0; j < Heigth; j++){ 
                if(Array[i][j] == 4){ 
                    locationCyanGhostx = i; 
                    locationCyanGhosty = j; 
                } 
            } 
        } 
    } 
      
    public void getLocationPinkGhost(){ 
        for(int i = 0; i < Width; i++){ 
            for(int j = 0; j < Heigth; j++){ 
                if(Array[i][j] == 5){ 
                    locationPinkGhostx = i; 
                    locationPinkGhosty = j; 
                } 
            } 
        } 
    } 
      
    public void getLocationOrangeGhost(){ 
        for(int i = 0; i < Width; i++){ 
            for(int j = 0; j < Heigth; j++){ 
                if(Array[i][j] == 6){ 
                    locationOrangeGhostx = i; 
                    locationOrangeGhosty = j; 
                } 
            } 
        } 
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	} 
} 