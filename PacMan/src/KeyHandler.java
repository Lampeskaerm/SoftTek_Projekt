import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
  
public class KeyHandler implements KeyListener { 
      
    private Screen screen; 
    private Screen.KeyTyped keyTyped; 
    
//    private Screen2 screen2;
//    private Screen2.KeyTyped2 keyTyped2;
      
    public KeyHandler(Screen screen){ 
        this.screen = screen; 
        this.keyTyped = this.screen.new KeyTyped(); 
    } 
  
    public void keyPressed(KeyEvent e) { 
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
          
        if(keyCode == 8){ 
            this.keyTyped.KeySpace(); 
        } 
    } 
  
      
    public void keyReleased(KeyEvent e) {    
    } 
  
  
    public void keyTyped(KeyEvent e) { 
    } 
} 
