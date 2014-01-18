package Pacman;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteLoad {
	private BufferedImage spriteSheet;
	public static BufferedImage[] sprites;
	public SpriteLoad(){
		
		try{
			spriteSheet =  ImageIO.read(new File("src/Pacman/Sprites/pacmanSpriteSheet.png"));
		}catch(IOException e){
			e.printStackTrace();
		}

		createSprites();
	}
	
	public void createSprites(){
		final int width = 18;
		final int height = 18;
		final int rows = 5;
		final int cols = 9;
		sprites = new BufferedImage[rows * cols];
		
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				sprites[(i * cols) + j] = spriteSheet.getSubimage(j * width, i * height, width, height);			
			}
		}
	}
}
