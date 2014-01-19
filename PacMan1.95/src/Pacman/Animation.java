package Pacman;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Animation extends JPanel implements ActionListener {
	Timer timer;
	int i, j, k = 2;
	SpriteLoad spriteload;
	
	public Animation(Point pos){
		this.i = pos.x;
		this.j = pos.y;
	}
	
	public void runAnimation(){
		timer = new Timer(125, this);
        timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(SpriteLoad.sprites[k], 18 * i + 18, 18 * j + 67, this);
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		
		if(k == 2){
			k = 3; 
		} else {
			k = 2;
		}
		
		repaint();
	}
}
