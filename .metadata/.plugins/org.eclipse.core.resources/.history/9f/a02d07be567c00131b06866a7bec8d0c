import java.awt.*;
import javax.swing.JPanel;

public class Screen extends JPanel implements Runnable {
	Thread thread = new Thread(this);
	
	Frame frame;
	public boolean running = false;
	public String gameState = "gameOn";
	private boolean enter = false;
	public boolean UpperLeftBigPacDot = false;
	public boolean UpperRightBigPacDot = false;
	public boolean lowerLeftBigPacDot = false;
	public boolean lowerRightBigPacDot = false;
	public boolean godMode = false;
	int godModeCounter = 0;
	
	//Movement variables.
	public boolean right = false;
	public boolean left = false;
	public boolean up = false;
	public boolean down = false;
	public int ghostCounter = 0;
	public String randomMovement = "";
	
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
	
	private int Height;
	private int Width;
	private String [][] Array; //Maybe change to String array? to easier see what is going on.
	
	View view;
	
	public Screen(Frame frame, int Width, int Height){
		this.Width = Width;
		this.Height = Height;
		Array = new String[Width][Height];
		this.frame = frame;
		frame.setSize(Width * 25 + 24, Height * 25 + 48);
		this.frame.addKeyListener(new KeyHandler(this));
		thread.start();
	}
	
	//Creates array with correct starting strings.
	public void restartGameArray(){
		for(int i = 0; i < Width; i++){
			for(int j = 0; j < Height; j++){
				Array[i][j] = "pacDot";
			}
		}
		Array[(int)(Width / 2)][Height - 2] = "pacMan";
		Array[(int)(Width / 2)][(int)(Height / 2 - 1)] = "redGhostAndBlackSpace";
		Array[(int)(Width / 2 - 1)][(int)(Height / 2)] = "cyanGhostAndBlackSpace";
		Array[(int)(Width / 2)][(int)(Height / 2)] = "pinkGhostAndBlackSpace";
		Array[(int)(Width / 2 + 1)][(int)(Height / 2)] = "orangeGhostAndBlackSpace";
		Array[1][1] = "bigPacDot";
		Array[1][Height - 2] = "bigPacDot";
		Array[Width - 2][1] = "bigPacDot";
		Array[Width - 2][Height - 2] = "bigPacDot";
	}
	
	public void run() {
		
		//Goes once:
		restartGameArray();
		view = new View(Array, gameState, frame, Width, Height);
		frame.getContentPane().add(view);
		getLocationPacMan();
		running = true;
	
		
		//updates:
		while(running){
			
			//movements:
			//Move right.
			while(right){
				getLocationPacMan();
				if(locationPacManx < Width - 1){
					if(Array[locationPacManx + 1][locationPacMany].equals("bigPacDot")){
						godMode = true;
					}
				Array[locationPacManx + 1][locationPacMany] = "pacMan";
				Array[locationPacManx][locationPacMany] = "blackSpace";
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
					if(Array[locationPacManx - 1][locationPacMany].equals("bigPacDot")){
						godMode = true;
					}
				Array[locationPacManx - 1][locationPacMany] = "pacMan";
				Array[locationPacManx][locationPacMany] = "blackSpace";
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
					if(Array[locationPacManx][locationPacMany - 1].equals("bigPacDot")){
						godMode = true;
					}
					Array[locationPacManx][locationPacMany - 1] = "pacMan";
					Array[locationPacManx][locationPacMany] = "blackSpace";
					up = false;
				}else{
					up = false;
				}
			}
			up = false;
			
			
			//move down.
			while(down){
				getLocationPacMan();
				if(locationPacMany < Height - 1){
					if(Array[locationPacManx][locationPacMany + 1].equals("bigPacDot")){
						godMode = true;
					}
					Array[locationPacManx][locationPacMany + 1] = "pacMan";
					Array[locationPacManx][locationPacMany] = "blackSpace";
					down = false;
				}else{
					down = false;
				}
			}
			down = false;
			
			//Check if the game is won.
			int numberOfBlackSpaces = 0;
			for(int i = 0; i < Width; i++){
				for(int j = 0; j < Height; j++){
					if(Array[i][j].equals("blackSpace")){
						numberOfBlackSpaces++;
					}
				}
			}
			if(numberOfBlackSpaces == Width * Height - 5){
				gameState = "gameWon";
			}	
			
			//Increment ghostCounter.
			ghostCounter++;
			if(ghostCounter == 50){
				movementGhosts();
				ghostCounter = 0;
			}
			
			//Checks for collision with ghosts, gameover if this happends.
			if(!godMode){
				getLocationPacMan();
				getLocationRedGhost();
				if(locationPacManx == locationRedGhostx && locationPacMany == locationRedGhosty){
					gameState = "gameOver";
				}
			
				getLocationCyanGhost();
				if(locationPacManx == locationCyanGhostx && locationPacMany == locationCyanGhosty){
					gameState =  "gameOver";
				}
			
				getLocationPinkGhost();
				if(locationPacManx == locationPinkGhostx && locationPacMany == locationPinkGhosty){
					gameState =  "gameOver";
				}
			
				getLocationOrangeGhost();
				if(locationPacManx == locationOrangeGhostx && locationPacMany == locationOrangeGhosty){
					gameState =  "gameOver";
				}
			}
			if(godMode == true){
				getLocationPacMan();
				getLocationRedGhost();
				if(locationPacManx == locationRedGhostx && locationPacMany == locationRedGhosty){
					Array[(int)(Width / 2)][(int)(Height / 2 - 1)] = "redGhostAndBlackSpace";
					getLocationRedGhost();
				}
				
				getLocationCyanGhost();
				if(locationPacManx == locationCyanGhostx && locationPacMany == locationCyanGhosty){
					Array[(int)(Width / 2 - 1)][(int)(Height / 2)] = "cyanGhostAndBlackSpace";
					getLocationCyanGhost();
				}
				
				getLocationPinkGhost();
				if(locationPacManx == locationPinkGhostx && locationPacMany == locationPinkGhosty){
					Array[(int)(Width / 2)][(int)(Height / 2)] = "pinkGhostAndBlackSpace";
					getLocationPinkGhost();
				}
				
				getLocationOrangeGhost();
				if(locationPacManx == locationOrangeGhostx && locationPacMany == locationOrangeGhosty){
					Array[(int)(Width / 2 + 1)][(int)(Height / 2)] = "orangeGhostAndBlackSpace";
					getLocationOrangeGhost();
				}
				
			}
			 
			
			//Make so that when the gameover or game won screen is up you can restart by pressing space
			if(enter){
				gameState = "gameOn";
				restartGameArray();
				enter = false;
			}

			
			//Check god mode and increment god mode counter.
			if(godMode){
				godModeCounter++;
				if(godModeCounter == 500){
					godMode = false;
					godModeCounter = 0;
				}
			}
						
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
		
		public void KeyEnter(){
			enter = true;
		}
	}
	
	//Get location functions.
	public void getLocationPacMan(){
		for(int i = 0; i < Width; i++){
			for(int j = 0; j < Height; j++){
				if(Array[i][j].equals("pacMan")){
					locationPacManx = i;
					locationPacMany = j;
				}
			}
		}
	}
	
	public void getLocationRedGhost(){
		for(int i = 0; i < Width; i++){
			for(int j = 0; j < Height; j++){
				if(Array[i][j].equals("redGhostAndPacDot") || Array[i][j].equals("redGhostAndBlackSpace")){
					locationRedGhostx = i;
					locationRedGhosty = j;
				}
			}
		}
	}
	
	public void getLocationCyanGhost(){
		for(int i = 0; i < Width; i++){
			for(int j = 0; j < Height; j++){
				if(Array[i][j].equals("cyanGhostAndPacDot") || Array[i][j].equals("cyanGhostAndBlackSpace")){
					locationCyanGhostx = i;
					locationCyanGhosty = j;
				}
			}
		}
	}
	
	public void getLocationPinkGhost(){
		for(int i = 0; i < Width; i++){
			for(int j = 0; j < Height; j++){
				if(Array[i][j].equals("pinkGhostAndPacDot") || Array[i][j].equals("pinkGhostAndBlackSpace")){
					locationPinkGhostx = i;
					locationPinkGhosty = j;
				}
			}
		}
	}
	
	public void getLocationOrangeGhost(){
		for(int i = 0; i < Width; i++){
			for(int j = 0; j < Height; j++){
				if(Array[i][j].equals("orangeGhostAndPacDot") || Array[i][j].equals("orangeGhostAndBlackSpace")){
					locationOrangeGhostx = i;
					locationOrangeGhosty = j;
				}
			}
		}
	}
	
	public void randomDirection(){
		 int random = (int)(Math.random() * 4 + 1);
		 if(random == 1){
			 randomMovement = "moveRight";
		 }else if(random == 2){
			 randomMovement = "moveLeft";
		 }else if(random == 3){
			 randomMovement = "moveDown";
		 }else if(random == 4){
			 randomMovement = "moveUp";
		 }
	}
	
	public void movementGhosts(){
		String redGhost = "";
		String cyanGhost = "";
		String pinkGhost = "";
		String orangeGhost = "";
		
		
		//Red ghost controls:
		randomDirection();
		redGhost = randomMovement;
		getLocationRedGhost();
		
		//move right.
		if(redGhost.equals("moveRight")){
			if(locationRedGhostx < Width - 1){
				getLocationRedGhost();
				getLocationPacMan();
				if(Array[locationRedGhostx][locationRedGhosty].equals("redGhostAndPacDot") && Array[locationRedGhostx + 1][locationRedGhosty].equals("pacDot")){
					Array[locationRedGhostx + 1][locationRedGhosty] = "redGhostAndPacDot";
					Array[locationRedGhostx][locationRedGhosty] = "pacDot";
					
				}else if(Array[locationRedGhostx][locationRedGhosty].equals("redGhostAndPacDot") && Array[locationRedGhostx + 1][locationRedGhosty].equals("blackSpace")){
					Array[locationRedGhostx + 1][locationRedGhosty] = "redGhostAndBlackSpace";
					Array[locationRedGhostx][locationRedGhosty] = "pacDot";
											
				}else if(Array[locationRedGhostx][locationRedGhosty].equals("redGhostAndBlackSpace") && Array[locationRedGhostx + 1][locationRedGhosty].equals("blackSpace")){
					Array[locationRedGhostx + 1][locationRedGhosty] = "redGhostAndBlackSpace";
					Array[locationRedGhostx][locationRedGhosty] = "blackSpace";
											
				}else if(Array[locationRedGhostx][locationRedGhosty].equals("redGhostAndBlackSpace") && Array[locationRedGhostx + 1][locationRedGhosty].equals("pacDot")){
					Array[locationRedGhostx + 1][locationRedGhosty] = "redGhostAndPacDot";
					Array[locationRedGhostx][locationRedGhosty] = "blackSpace";
					
				}else if(!godMode){
					if(Array[locationRedGhostx + 1][locationRedGhosty].equals("pacMan")){
					gameState = "gameOver";
					}
				}
			}
		}
		
		
		//move left.
		if(redGhost.equals("moveLeft")){
			if(locationRedGhostx > 0){
				getLocationRedGhost();
				getLocationPacMan();
				if(Array[locationRedGhostx][locationRedGhosty].equals("redGhostAndPacDot") && Array[locationRedGhostx - 1][locationRedGhosty].equals("pacDot")){
					Array[locationRedGhostx - 1][locationRedGhosty] = "redGhostAndPacDot";
					Array[locationRedGhostx][locationRedGhosty] = "pacDot";
					
				}else if(Array[locationRedGhostx][locationRedGhosty].equals("redGhostAndPacDot") && Array[locationRedGhostx - 1][locationRedGhosty].equals("blackSpace")){
					Array[locationRedGhostx - 1][locationRedGhosty] = "redGhostAndBlackSpace";
					Array[locationRedGhostx][locationRedGhosty] = "pacDot";
										
				}else if(Array[locationRedGhostx][locationRedGhosty].equals("redGhostAndBlackSpace") && Array[locationRedGhostx - 1][locationRedGhosty].equals("blackSpace")){
					Array[locationRedGhostx - 1][locationRedGhosty] = "redGhostAndBlackSpace";
					Array[locationRedGhostx][locationRedGhosty] = "blackSpace";
									
				}else if(Array[locationRedGhostx][locationRedGhosty].equals("redGhostAndBlackSpace") && Array[locationRedGhostx - 1][locationRedGhosty].equals("pacDot")){
					Array[locationRedGhostx - 1][locationRedGhosty] = "redGhostAndPacDot";
					Array[locationRedGhostx][locationRedGhosty] = "blackSpace";
					
				}else if(!godMode){
					if(Array[locationRedGhostx - 1][locationRedGhosty].equals("pacMan")){
					gameState = "gameOver";
					}
				}
			}
		}
			
		
		//move up.
		if(redGhost.equals("moveUp")){
			if(locationRedGhosty > 0){
				getLocationRedGhost();
				getLocationPacMan();
				if(Array[locationRedGhostx][locationRedGhosty].equals("redGhostAndPacDot") && Array[locationRedGhostx][locationRedGhosty - 1].equals("pacDot")){
					Array[locationRedGhostx][locationRedGhosty - 1] = "redGhostAndPacDot";
					Array[locationRedGhostx][locationRedGhosty] = "pacDot";
					
				}else if(Array[locationRedGhostx][locationRedGhosty].equals("redGhostAndPacDot") && Array[locationRedGhostx][locationRedGhosty - 1].equals("blackSpace")){
					Array[locationRedGhostx][locationRedGhosty - 1] = "redGhostAndBlackSpace";
					Array[locationRedGhostx][locationRedGhosty] = "pacDot";
											
				}else if(Array[locationRedGhostx][locationRedGhosty].equals("redGhostAndBlackSpace") && Array[locationRedGhostx][locationRedGhosty - 1].equals("blackSpace")){
					Array[locationRedGhostx][locationRedGhosty - 1] = "redGhostAndBlackSpace";
					Array[locationRedGhostx][locationRedGhosty] = "blackSpace";
											
				}else if(Array[locationRedGhostx][locationRedGhosty].equals("redGhostAndBlackSpace") && Array[locationRedGhostx][locationRedGhosty - 1].equals("pacDot")){
					Array[locationRedGhostx][locationRedGhosty - 1] = "redGhostAndPacDot";
					Array[locationRedGhostx][locationRedGhosty] = "blackSpace";
					
				}else if(!godMode){
					if(Array[locationRedGhostx][locationRedGhosty - 1].equals("pacMan")){
						gameState = "gameOver";
					}
				}
			}
		}
		
		
		//move down.
		if(redGhost.equals("moveDown")){
			if(locationRedGhosty < Height - 1){
				getLocationRedGhost();
				getLocationPacMan();
				if(Array[locationRedGhostx][locationRedGhosty].equals("redGhostAndPacDot") && Array[locationRedGhostx][locationRedGhosty + 1].equals("pacDot")){
					Array[locationRedGhostx][locationRedGhosty + 1] = "redGhostAndPacDot";
					Array[locationRedGhostx][locationRedGhosty] = "pacDot";
							
				}else if(Array[locationRedGhostx][locationRedGhosty].equals("redGhostAndPacDot") && Array[locationRedGhostx][locationRedGhosty + 1].equals("blackSpace")){
					Array[locationRedGhostx][locationRedGhosty + 1] = "redGhostAndBlackSpace";
					Array[locationRedGhostx][locationRedGhosty] = "pacDot";
											
				}else if(Array[locationRedGhostx][locationRedGhosty].equals("redGhostAndBlackSpace") && Array[locationRedGhostx][locationRedGhosty + 1].equals("blackSpace")){
					Array[locationRedGhostx][locationRedGhosty + 1] = "redGhostAndBlackSpace";
					Array[locationRedGhostx][locationRedGhosty] = "blackSpace";
									
				}else if(Array[locationRedGhostx][locationRedGhosty].equals("redGhostAndBlackSpace") && Array[locationRedGhostx][locationRedGhosty + 1].equals("pacDot")){
					Array[locationRedGhostx][locationRedGhosty + 1] = "redGhostAndPacDot";
					Array[locationRedGhostx][locationRedGhosty] = "blackSpace";
					
				}else if(!godMode){
					if(Array[locationRedGhostx][locationRedGhosty + 1].equals("pacMan")){
						gameState = "gameOver";
					}
				}
			}
		}
				
				
		//Cyan ghost controls:
		randomDirection();
		cyanGhost = randomMovement;
		getLocationCyanGhost();
				
		//move right.
		if(cyanGhost.equals("moveRight")){
			if(locationCyanGhostx < Width - 1){
				getLocationCyanGhost();
				getLocationPacMan();
				if(Array[locationCyanGhostx][locationCyanGhosty].equals("cyanGhostAndPacDot") && Array[locationCyanGhostx + 1][locationCyanGhosty].equals("pacDot")){
					Array[locationCyanGhostx + 1][locationCyanGhosty] = "cyanGhostAndPacDot";
					Array[locationCyanGhostx][locationCyanGhosty] = "pacDot";
							
				}else if(Array[locationCyanGhostx][locationCyanGhosty].equals("cyanGhostAndPacDot") && Array[locationCyanGhostx + 1][locationCyanGhosty].equals("blackSpace")){
					Array[locationCyanGhostx + 1][locationCyanGhosty] = "cyanGhostAndBlackSpace";
					Array[locationCyanGhostx][locationCyanGhosty] = "pacDot";
									
				}else if(Array[locationCyanGhostx][locationCyanGhosty].equals("cyanGhostAndBlackSpace") && Array[locationCyanGhostx + 1][locationCyanGhosty].equals("blackSpace")){
					Array[locationCyanGhostx + 1][locationCyanGhosty] = "cyanGhostAndBlackSpace";
					Array[locationCyanGhostx][locationCyanGhosty] = "blackSpace";
											
				}else if(Array[locationCyanGhostx][locationCyanGhosty].equals("cyanGhostAndBlackSpace") && Array[locationCyanGhostx + 1][locationCyanGhosty].equals("pacDot")){
					Array[locationCyanGhostx + 1][locationCyanGhosty] = "cyanGhostAndPacDot";
					Array[locationCyanGhostx][locationCyanGhosty] = "blackSpace";
					
				}else if(!godMode){
					if(Array[locationCyanGhostx + 1][locationCyanGhosty].equals("pacMan")){
						gameState = "gameOver";
					}
				}
			}
		}
				
				
		//move left.
		if(cyanGhost.equals("moveLeft")){
			if(locationCyanGhostx > 0){
				getLocationCyanGhost();
				getLocationPacMan();
				if(Array[locationCyanGhostx][locationCyanGhosty].equals("cyanGhostAndPacDot") && Array[locationCyanGhostx - 1][locationCyanGhosty].equals("pacDot")){
					Array[locationCyanGhostx - 1][locationCyanGhosty] = "cyanGhostAndPacDot";
					Array[locationCyanGhostx][locationCyanGhosty] = "pacDot";
							
				}else if(Array[locationCyanGhostx][locationCyanGhosty].equals("cyanGhostAndPacDot") && Array[locationCyanGhostx - 1][locationCyanGhosty].equals("blackSpace")){
					Array[locationCyanGhostx - 1][locationCyanGhosty] = "cyanGhostAndBlackSpace";
					Array[locationCyanGhostx][locationCyanGhosty] = "pacDot";
										
				}else if(Array[locationCyanGhostx][locationCyanGhosty].equals("cyanGhostAndBlackSpace") && Array[locationCyanGhostx - 1][locationCyanGhosty].equals("blackSpace")){
					Array[locationCyanGhostx - 1][locationCyanGhosty] = "cyanGhostAndBlackSpace";
					Array[locationCyanGhostx][locationCyanGhosty] = "blackSpace";
									
				}else if(Array[locationCyanGhostx][locationCyanGhosty].equals("cyanGhostAndBlackSpace") && Array[locationCyanGhostx - 1][locationCyanGhosty].equals("pacDot")){
					Array[locationCyanGhostx - 1][locationCyanGhosty] = "cyanGhostAndPacDot";
					Array[locationCyanGhostx][locationCyanGhosty] = "blackSpace";
					
				}else if(!godMode){
					if(Array[locationCyanGhostx - 1][locationCyanGhosty].equals("pacMan")){
						gameState = "gameOver";
					}
				}
			}
		}
					
				
		//move up.
		if(cyanGhost.equals("moveUp")){
			if(locationCyanGhosty > 0){
				getLocationCyanGhost();
				getLocationPacMan();
				if(Array[locationCyanGhostx][locationCyanGhosty].equals("cyanGhostAndPacDot") && Array[locationCyanGhostx][locationCyanGhosty - 1].equals("pacDot")){
					Array[locationCyanGhostx][locationCyanGhosty - 1] = "cyanGhostAndPacDot";
					Array[locationCyanGhostx][locationCyanGhosty] = "pacDot";
							
				}else if(Array[locationCyanGhostx][locationCyanGhosty].equals("cyanGhostAndPacDot") && Array[locationCyanGhostx][locationCyanGhosty - 1].equals("blackSpace")){
					Array[locationCyanGhostx][locationCyanGhosty - 1] = "cyanGhostAndBlackSpace";
					Array[locationCyanGhostx][locationCyanGhosty] = "pacDot";
																
				}else if(Array[locationCyanGhostx][locationCyanGhosty].equals("cyanGhostAndBlackSpace") && Array[locationCyanGhostx][locationCyanGhosty - 1].equals("blackSpace")){
					Array[locationCyanGhostx][locationCyanGhosty - 1] = "cyanGhostAndBlackSpace";
					Array[locationCyanGhostx][locationCyanGhosty] = "blackSpace";
										
				}else if(Array[locationCyanGhostx][locationCyanGhosty].equals("cyanGhostAndBlackSpace") && Array[locationCyanGhostx][locationCyanGhosty - 1].equals("pacDot")){
					Array[locationCyanGhostx][locationCyanGhosty - 1] = "cyanGhostAndPacDot";
					Array[locationCyanGhostx][locationCyanGhosty] = "blackSpace";
					
				}else if(!godMode){
					if(Array[locationCyanGhostx][locationCyanGhosty - 1].equals("pacMan")){
						gameState = "gameOver";
					}
				}
			}
		}
				
				
		//move down.
		if(cyanGhost.equals("moveDown")){
			if(locationCyanGhosty < Height - 1){
				getLocationCyanGhost();
				getLocationPacMan();
				if(Array[locationCyanGhostx][locationCyanGhosty].equals("cyanGhostAndPacDot") && Array[locationCyanGhostx][locationCyanGhosty + 1].equals("pacDot")){
					Array[locationCyanGhostx][locationCyanGhosty + 1] = "cyanGhostAndPacDot";
					Array[locationCyanGhostx][locationCyanGhosty] = "pacDot";
									
				}else if(Array[locationCyanGhostx][locationCyanGhosty].equals("cyanGhostAndPacDot") && Array[locationCyanGhostx][locationCyanGhosty + 1].equals("blackSpace")){
					Array[locationCyanGhostx][locationCyanGhosty + 1] = "cyanGhostAndBlackSpace";
					Array[locationCyanGhostx][locationCyanGhosty] = "pacDot";
												
				}else if(Array[locationCyanGhostx][locationCyanGhosty].equals("cyanGhostAndBlackSpace") && Array[locationCyanGhostx][locationCyanGhosty + 1].equals("blackSpace")){
					Array[locationCyanGhostx][locationCyanGhosty + 1] = "cyanGhostAndBlackSpace";
					Array[locationCyanGhostx][locationCyanGhosty] = "blackSpace";
											
				}else if(Array[locationCyanGhostx][locationCyanGhosty].equals("cyanGhostAndBlackSpace") && Array[locationCyanGhostx][locationCyanGhosty + 1].equals("pacDot")){
					Array[locationCyanGhostx][locationCyanGhosty + 1] = "cyanGhostAndPacDot";
					Array[locationCyanGhostx][locationCyanGhosty] = "blackSpace";
						
				}else if(!godMode){
					if(Array[locationCyanGhostx][locationCyanGhosty + 1].equals("pacMan")){
						gameState = "gameOver";
					}
				}
			}
		}
						
		//Pink ghost controls:
		randomDirection();
		pinkGhost = randomMovement;
		getLocationPinkGhost();
						
		//move right.
		if(pinkGhost.equals("moveRight")){
			if(locationPinkGhostx < Width - 1){
				getLocationPinkGhost();
				getLocationPacMan();
				if(Array[locationPinkGhostx][locationPinkGhosty].equals("pinkGhostAndPacDot") && Array[locationPinkGhostx + 1][locationPinkGhosty].equals("pacDot")){
					Array[locationPinkGhostx + 1][locationPinkGhosty] = "pinkGhostAndPacDot";
					Array[locationPinkGhostx][locationPinkGhosty] = "pacDot";
									
				}else if(Array[locationPinkGhostx][locationPinkGhosty].equals("pinkGhostAndPacDot") && Array[locationPinkGhostx + 1][locationPinkGhosty].equals("blackSpace")){
					Array[locationPinkGhostx + 1][locationPinkGhosty] = "pinkGhostAndBlackSpace";
					Array[locationPinkGhostx][locationPinkGhosty] = "pacDot";
														
				}else if(Array[locationPinkGhostx][locationPinkGhosty].equals("pinkGhostAndBlackSpace") && Array[locationPinkGhostx + 1][locationPinkGhosty].equals("blackSpace")){
					Array[locationPinkGhostx + 1][locationPinkGhosty] = "pinkGhostAndBlackSpace";
					Array[locationPinkGhostx][locationPinkGhosty] = "blackSpace";
																	
				}else if(Array[locationPinkGhostx][locationPinkGhosty].equals("pinkGhostAndBlackSpace") && Array[locationPinkGhostx + 1][locationPinkGhosty].equals("pacDot")){
					Array[locationPinkGhostx + 1][locationPinkGhosty] = "pinkGhostAndPacDot";
					Array[locationPinkGhostx][locationPinkGhosty] = "blackSpace";
					
				}else if(!godMode){
					if(Array[locationPinkGhostx + 1][locationPinkGhosty].equals("pacMan")){
						gameState = "gameOver";
					}
				}
			}
		}
						
						
		//move left.
		if(pinkGhost.equals("moveLeft")){
			if(locationPinkGhostx > 0){
				getLocationPinkGhost();
				getLocationPacMan();
				if(Array[locationPinkGhostx][locationPinkGhosty].equals("pinkGhostAndPacDot") && Array[locationPinkGhostx - 1][locationPinkGhosty].equals("pacDot")){
					Array[locationPinkGhostx - 1][locationPinkGhosty] = "pinkGhostAndPacDot";
					Array[locationPinkGhostx][locationPinkGhosty] = "pacDot";
									
				}else if(Array[locationPinkGhostx][locationPinkGhosty].equals("pinkGhostAndPacDot") && Array[locationPinkGhostx - 1][locationPinkGhosty].equals("blackSpace")){
					Array[locationPinkGhostx - 1][locationPinkGhosty] = "pinkGhostAndBlackSpace";
					Array[locationPinkGhostx][locationPinkGhosty] = "pacDot";
												
				}else if(Array[locationPinkGhostx][locationPinkGhosty].equals("pinkGhostAndBlackSpace") && Array[locationPinkGhostx - 1][locationPinkGhosty].equals("blackSpace")){
					Array[locationPinkGhostx - 1][locationPinkGhosty] = "pinkGhostAndBlackSpace";
					Array[locationPinkGhostx][locationPinkGhosty] = "blackSpace";
											
				}else if(Array[locationPinkGhostx][locationPinkGhosty].equals("pinkGhostAndBlackSpace") && Array[locationPinkGhostx - 1][locationPinkGhosty].equals("pacDot")){
					Array[locationPinkGhostx - 1][locationPinkGhosty] = "pinkGhostAndPacDot";
					Array[locationPinkGhostx][locationPinkGhosty] = "blackSpace";
					
				}else if(!godMode){
					if(Array[locationPinkGhostx - 1][locationPinkGhosty].equals("pacMan")){
						gameState = "gameOver";
					}
				}
			}
		}
							
						
		//move up.
		if(pinkGhost.equals("moveUp")){
			if(locationPinkGhosty > 0){
				getLocationPinkGhost();
				getLocationPacMan();
				if(Array[locationPinkGhostx][locationPinkGhosty].equals("pinkGhostAndPacDot") && Array[locationPinkGhostx][locationPinkGhosty - 1].equals("pacDot")){
					Array[locationPinkGhostx][locationPinkGhosty - 1] = "pinkGhostAndPacDot";
					Array[locationPinkGhostx][locationPinkGhosty] = "pacDot";
									
				}else if(Array[locationPinkGhostx][locationPinkGhosty].equals("pinkGhostAndPacDot") && Array[locationPinkGhostx][locationPinkGhosty - 1].equals("blackSpace")){
					Array[locationPinkGhostx][locationPinkGhosty - 1] = "pinkGhostAndBlackSpace";
					Array[locationPinkGhostx][locationPinkGhosty] = "pacDot";
											
				}else if(Array[locationPinkGhostx][locationPinkGhosty].equals("pinkGhostAndBlackSpace") && Array[locationPinkGhostx][locationPinkGhosty - 1].equals("blackSpace")){
					Array[locationPinkGhostx][locationPinkGhosty - 1] = "pinkGhostAndBlackSpace";
					Array[locationPinkGhostx][locationPinkGhosty] = "blackSpace";
											
				}else if(Array[locationPinkGhostx][locationPinkGhosty].equals("pinkGhostAndBlackSpace") && Array[locationPinkGhostx][locationPinkGhosty - 1].equals("pacDot")){
					Array[locationPinkGhostx][locationPinkGhosty - 1] = "pinkGhostAndPacDot";
					Array[locationPinkGhostx][locationPinkGhosty] = "blackSpace";
					
				}else if(godMode){
					if(Array[locationPinkGhostx][locationPinkGhosty - 1].equals("pacMan")){
						gameState = "gameOver";
					}
				}
			}
		}
						
						
		//move down.
		if(pinkGhost.equals("moveDown")){
			if(locationPinkGhosty < Height - 1){
				getLocationPinkGhost();
				getLocationPacMan();
				if(Array[locationPinkGhostx][locationPinkGhosty].equals("pinkGhostAndPacDot") && Array[locationPinkGhostx][locationPinkGhosty + 1].equals("pacDot")){
					Array[locationPinkGhostx][locationPinkGhosty + 1] = "pinkGhostAndPacDot";
					Array[locationPinkGhostx][locationPinkGhosty] = "pacDot";
											
				}else if(Array[locationPinkGhostx][locationPinkGhosty].equals("pinkGhostAndPacDot") && Array[locationPinkGhostx][locationPinkGhosty + 1].equals("blackSpace")){
					Array[locationPinkGhostx][locationPinkGhosty + 1] = "pinkGhostAndBlackSpace";
					Array[locationPinkGhostx][locationPinkGhosty] = "pacDot";
																								
				}else if(Array[locationPinkGhostx][locationPinkGhosty].equals("pinkGhostAndBlackSpace") && Array[locationPinkGhostx][locationPinkGhosty + 1].equals("blackSpace")){
					Array[locationPinkGhostx][locationPinkGhosty + 1] = "pinkGhostAndBlackSpace";
					Array[locationPinkGhostx][locationPinkGhosty] = "blackSpace";
																							
				}else if(Array[locationPinkGhostx][locationPinkGhosty].equals("pinkGhostAndBlackSpace") && Array[locationPinkGhostx][locationPinkGhosty + 1].equals("pacDot")){
					Array[locationPinkGhostx][locationPinkGhosty + 1] = "pinkGhostAndPacDot";
					Array[locationPinkGhostx][locationPinkGhosty] = "blackSpace";
					
				}else if(!godMode){
					if(Array[locationPinkGhostx][locationPinkGhosty + 1].equals("pacMan")){
						gameState = "gameOver";
					}
				}
			}
		}
								
		//Orange ghost controls:
		randomDirection();
		orangeGhost = randomMovement;
		getLocationOrangeGhost();
								
		//move right.
		if(orangeGhost.equals("moveRight")){
			if(locationOrangeGhostx < Width - 1){
				getLocationOrangeGhost();
				getLocationPacMan();
				if(Array[locationOrangeGhostx][locationOrangeGhosty].equals("orangeGhostAndPacDot") && Array[locationOrangeGhostx + 1][locationOrangeGhosty].equals("pacDot")){
					Array[locationOrangeGhostx + 1][locationOrangeGhosty] = "orangeGhostAndPacDot";
					Array[locationOrangeGhostx][locationOrangeGhosty] = "pacDot";
											
				}else if(Array[locationOrangeGhostx][locationOrangeGhosty].equals("orangeGhostAndPacDot") && Array[locationOrangeGhostx + 1][locationOrangeGhosty].equals("blackSpace")){
					Array[locationOrangeGhostx + 1][locationOrangeGhosty] = "orangeGhostAndBlackSpace";
					Array[locationOrangeGhostx][locationOrangeGhosty] = "pacDot";
																								
				}else if(Array[locationOrangeGhostx][locationOrangeGhosty].equals("orangeGhostAndBlackSpace") && Array[locationOrangeGhostx + 1][locationOrangeGhosty].equals("blackSpace")){
					Array[locationOrangeGhostx + 1][locationOrangeGhosty] = "orangeGhostAndBlackSpace";
					Array[locationOrangeGhostx][locationOrangeGhosty] = "blackSpace";
																							
				}else if(Array[locationOrangeGhostx][locationOrangeGhosty].equals("orangeGhostAndBlackSpace") && Array[locationOrangeGhostx + 1][locationOrangeGhosty].equals("pacDot")){
					Array[locationOrangeGhostx + 1][locationOrangeGhosty] = "orangeGhostAndPacDot";
					Array[locationOrangeGhostx][locationOrangeGhosty] = "blackSpace";
					
				}else if(!godMode){
					if(Array[locationOrangeGhostx + 1][locationOrangeGhosty].equals("pacMan")){
						gameState = "gameOver";
					}
				}
			}
		}
								
								
		//move left.
		if(orangeGhost.equals("moveLeft")){
			if(locationOrangeGhostx > 0){
				getLocationOrangeGhost();
				getLocationPacMan();
				if(Array[locationOrangeGhostx][locationOrangeGhosty].equals("orangeGhostAndPacDot") && Array[locationOrangeGhostx - 1][locationOrangeGhosty].equals("pacDot")){
					Array[locationOrangeGhostx - 1][locationOrangeGhosty] = "orangeGhostAndPacDot";
					Array[locationOrangeGhostx][locationOrangeGhosty] = "pacDot";
											
				}else if(Array[locationOrangeGhostx][locationOrangeGhosty].equals("orangeGhostAndPacDot") && Array[locationOrangeGhostx - 1][locationOrangeGhosty].equals("blackSpace")){
					Array[locationOrangeGhostx - 1][locationOrangeGhosty] = "orangeGhostAndBlackSpace";
					Array[locationOrangeGhostx][locationOrangeGhosty] = "pacDot";
																							
				}else if(Array[locationOrangeGhostx][locationOrangeGhosty].equals("orangeGhostAndBlackSpace") && Array[locationOrangeGhostx - 1][locationOrangeGhosty].equals("blackSpace")){
					Array[locationOrangeGhostx - 1][locationOrangeGhosty] = "orangeGhostAndBlackSpace";
					Array[locationOrangeGhostx][locationOrangeGhosty] = "blackSpace";
																						
				}else if(Array[locationOrangeGhostx][locationOrangeGhosty].equals("orangeGhostAndBlackSpace") && Array[locationOrangeGhostx - 1][locationOrangeGhosty].equals("pacDot")){
					Array[locationOrangeGhostx - 1][locationOrangeGhosty] = "orangeGhostAndPacDot";
					Array[locationOrangeGhostx][locationOrangeGhosty] = "blackSpace";
						
				}else if(!godMode){
					if(Array[locationOrangeGhostx - 1][locationOrangeGhosty].equals("pacMan")){
						gameState = "gameOver";
					}
				}
			}
		}		
									
								
		//move up.
		if(orangeGhost.equals("moveUp")){
			if(locationOrangeGhosty > 0){
				getLocationOrangeGhost();
				getLocationPacMan();
				if(Array[locationOrangeGhostx][locationOrangeGhosty].equals("orangeGhostAndPacDot") && Array[locationOrangeGhostx][locationOrangeGhosty - 1].equals("pacDot")){
					Array[locationOrangeGhostx][locationOrangeGhosty - 1] = "orangeGhostAndPacDot";
					Array[locationOrangeGhostx][locationOrangeGhosty] = "pacDot";
											
				}else if(Array[locationOrangeGhostx][locationOrangeGhosty].equals("orangeGhostAndPacDot") && Array[locationOrangeGhostx][locationOrangeGhosty - 1].equals("blackSpace")){
					Array[locationOrangeGhostx][locationOrangeGhosty - 1] = "orangeGhostAndBlackSpace";
					Array[locationOrangeGhostx][locationOrangeGhosty] = "pacDot";
																								
				}else if(Array[locationOrangeGhostx][locationOrangeGhosty].equals("orangeGhostAndBlackSpace") && Array[locationOrangeGhostx][locationOrangeGhosty - 1].equals("blackSpace")){
					Array[locationOrangeGhostx][locationOrangeGhosty - 1] = "orangeGhostAndBlackSpace";
					Array[locationOrangeGhostx][locationOrangeGhosty] = "blackSpace";
																							
				}else if(Array[locationOrangeGhostx][locationOrangeGhosty].equals("orangeGhostAndBlackSpace") && Array[locationOrangeGhostx][locationOrangeGhosty - 1].equals("pacDot")){
					Array[locationOrangeGhostx][locationOrangeGhosty - 1] = "orangeGhostAndPacDot";
					Array[locationOrangeGhostx][locationOrangeGhosty] = "blackSpace";
					
				}else if(!godMode){
					if(Array[locationOrangeGhostx][locationOrangeGhosty - 1].equals("pacMan")){
						gameState = "gameOver";
					}
				}
			}
		}
								
								
		//move down.
		if(orangeGhost.equals("moveDown")){
			if(locationOrangeGhosty < Height - 1){
				getLocationOrangeGhost();
				getLocationPacMan();
				if(Array[locationOrangeGhostx][locationOrangeGhosty].equals("orangeGhostAndPacDot") && Array[locationOrangeGhostx][locationOrangeGhosty + 1].equals("pacDot")){
					Array[locationOrangeGhostx][locationOrangeGhosty + 1] = "orangeGhostAndPacDot";
					Array[locationOrangeGhostx][locationOrangeGhosty] = "pacDot";
													
				}else if(Array[locationOrangeGhostx][locationOrangeGhosty].equals("orangeGhostAndPacDot") && Array[locationOrangeGhostx][locationOrangeGhosty + 1].equals("blackSpace")){
					Array[locationOrangeGhostx][locationOrangeGhosty + 1] = "orangeGhostAndBlackSpace";
					Array[locationOrangeGhostx][locationOrangeGhosty] = "pacDot";
																												
				}else if(Array[locationOrangeGhostx][locationOrangeGhosty].equals("orangeGhostAndBlackSpace") && Array[locationOrangeGhostx][locationOrangeGhosty + 1].equals("blackSpace")){
					Array[locationOrangeGhostx][locationOrangeGhosty + 1] = "orangeGhostAndBlackSpace";
					Array[locationOrangeGhostx][locationOrangeGhosty] = "blackSpace";
																											
				}else if(Array[locationOrangeGhostx][locationOrangeGhosty].equals("orangeGhostAndBlackSpace") && Array[locationOrangeGhostx][locationOrangeGhosty + 1].equals("pacDot")){
					Array[locationOrangeGhostx][locationOrangeGhosty + 1] = "orangeGhostAndPacDot";
					Array[locationOrangeGhostx][locationOrangeGhosty] = "blackSpace";
					
				}else if(!godMode){
					if(Array[locationOrangeGhostx][locationOrangeGhosty + 1].equals("pacMan")){
						gameState = "gameOver";
					}
				}
			}
		}
	}
}