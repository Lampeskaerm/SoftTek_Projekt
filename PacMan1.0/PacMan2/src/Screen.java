import java.awt.*;
import javax.swing.JPanel;

public class Screen extends JPanel implements Runnable {
	Thread thread = new Thread(this);

	Frame frame;
	public boolean running = false;
	public int gameState = 1; // If game is still running = 1, if gameover = 0.
	private boolean space = false;

	// Movement variables.
	public boolean right = false;
	public boolean left = false;
	public boolean up = false;
	public boolean down = false;

	// Location variables.
	public Point locationPacMan = new Point();
	private Point locationRedGhost = new Point();
	private Point locationCyanGhost = new Point();
	private Point locationPinkGhost = new Point();
	private Point locationOrangeGhost = new Point();

	private int height = 15;
	private int width = 15;

	// private int [][] Array = new int[width][height]; //Maybe change to String
	// array? to easier see what is going on.

	public Screen(Frame frame) {
		this.frame = frame;
		frame.setSize(width * 25 + 24, height * 25 + 48);
		this.frame.addKeyListener(new KeyHandler(this));
		thread.start();

	}

	// Game area integers.
	// 0 = black space.
	// 1 = pac dots.
	// 2 = pacman.
	// 3 = red ghost.
	// 4 = cyan ghost.
	// 5 = pink ghost.
	// 6 = orange ghost.
	// 7 = big pac dots.

	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, this.frame.getWidth(), this.frame.getHeight());

		for (int i = 1; i <= height; i++) {
			for (int j = 1; j <= width; j++) {
				g.setColor(Color.white);
				g.fillRect(24*j + 24, 24*i + 24, 8, 8);
			}
		}
	}

	public void run() {

		// Goes once:
		running = true;

		// updates:
		while (running) {

			// movements:
			// Move right.
			while (right) {
				if (locationPacMan.x < width - 1) {
					System.out.println("RIGHT!");
					right = false;
				} else {
					right = false;
				}
			}
			right = false;

			// Move left.
			while (left) {
				if (locationPacMan.x > 0) {
					System.out.println("LEFT!");
					left = false;
				} else {
					left = false;
				}
			}
			left = false;

			// Move up.
			while (up) {
				if (locationPacMan.y > 0) {
					System.out.println("UP!");
					up = false;
				} else {
					up = false;
				}
			}
			up = false;

			// move down.
			while (down) {
				if (locationPacMan.y < height - 1) {
					System.out.println("DOWN!");
					down = false;
				} else {
					down = false;

				}
			}
			down = false;

			// Checks for collision with ghosts, gameover if this happends.
			if (locationPacMan.x == locationRedGhost.x
					&& locationPacMan.y == locationRedGhost.y) {
				gameState = 0;
			}


			if (locationPacMan.x == locationCyanGhost.x
					&& locationPacMan.y == locationCyanGhost.y) {
				gameState = 0;
			}

			if (locationPacMan.x == locationPinkGhost.x
					&& locationPacMan.y == locationPinkGhost.y) {
				gameState = 0;
			}

			if (locationPacMan.x == locationOrangeGhost.x
					&& locationPacMan.y == locationOrangeGhost.y) {
				gameState = 0;
			}

			// Make so that when the gameover screen is up you can restart by
			// pressing enter or space.
			/*
			 * if(space == true){ gameState = 1; arrayStatus(); space = false; }
			 */

			// update graphics.
			frame.getContentPane().repaint();

			// Limits max fps:
			try {
				Thread.sleep(20); // stops the program for 20 milliseconds
									// before going on, therefore the max fps is
									// 50 fps.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.exit(0);
	}

	// Input
	public class KeyTyped {
		public void keyESC() {
			running = false;
		}

		public void KeyRight() {
			right = true;
		}

		public void KeyLeft() {
			left = true;
		}

		public void KeyUp() {
			up = true;
		}

		public void KeyDown() {
			down = true;
		}

		public void KeySpace() {
			space = true;
		}
	}

//	// Get location functions.
//	public void getLocationPacMan() {
//		for (int i = 0; i < width; i++) {
//			for (int j = 0; j < height; j++) {
//				if (Array[i][j] == 2) {
//					locationPacMan.x = i;
//					locationPacMan.y = j;
//				}
//			}
//		}
//	}
//
//	public void getLocationRedGhost() {
//		for (int i = 0; i < width; i++) {
//			for (int j = 0; j < height; j++) {
//				if (Array[i][j] == 3) {
//					locationRedGhost.x = i;
//					locationRedGhost.y = j;
//				}
//			}
//		}
//	}
//
//	public void getLocationCyanGhost() {
//		for (int i = 0; i < width; i++) {
//			for (int j = 0; j < height; j++) {
//				if (Array[i][j] == 4) {
//					locationCyanGhost.x = i;
//					locationCyanGhost.y = j;
//				}
//			}
//		}
//	}
//
//	public void getLocationPinkGhost() {
//		for (int i = 0; i < width; i++) {
//			for (int j = 0; j < height; j++) {
//				if (Array[i][j] == 5) {
//					locationPinkGhost.x = i;
//					locationPinkGhost.y = j;
//				}
//			}
//		}
//	}
//
//	public void getLocationOrangeGhost() {
//		for (int i = 0; i < width; i++) {
//			for (int j = 0; j < height; j++) {
//				if (Array[i][j] == 6) {
//					locationOrangeGhost.x = i;
//					locationOrangeGhost.y = j;
//				}
//			}
//		}
//	}
}
