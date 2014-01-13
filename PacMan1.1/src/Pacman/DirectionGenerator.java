package Pacman;

public class DirectionGenerator {
	public String randomMovement = "";
	
	public DirectionGenerator(){
		
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
}
