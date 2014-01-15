package Pacman;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	
	private Model screen;
	private Model.KeyTyped keyTyped;
	
	public KeyHandler(Model screen){
		this.screen = screen;
		this.keyTyped = this.screen.new KeyTyped();
	}

	public void keyPressed(KeyEvent e) {
		}

	
	public void keyReleased(KeyEvent e) {	
		int keyCode = e.getKeyCode();
		
		if(keyCode == 27){
			this.keyTyped.keyESC();
		}
		
		if(keyCode == 39){
			this.keyTyped.KeyRight();
		}
		
		if(keyCode == 37){
			this.keyTyped.KeyLeft();
		}
		
		if(keyCode == 38){
			this.keyTyped.KeyUp();
		}
		
		if(keyCode == 40){
			this.keyTyped.KeyDown();
		}
		
		if(keyCode == 32){
			this.keyTyped.KeyEnter();
		}
	}



	public void keyTyped(KeyEvent e) {
	}
}
