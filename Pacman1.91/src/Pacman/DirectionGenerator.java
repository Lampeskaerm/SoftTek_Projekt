package Pacman;

import java.awt.List;
import java.util.ArrayList;

public class DirectionGenerator {
	public String randomMovement = "";
	public ArrayList<String> directions = new ArrayList<String>();
	public ArrayList<String> copy; 
	
	public DirectionGenerator(){
		directions.add("up");
		directions.add("down");
		directions.add("left");
		directions.add("right");
	}
	
	public void randomDirection(ArrayList<String> illegalPos){
		copy = new ArrayList<String>(directions);
		for(String str : illegalPos){
			if(directions.contains(str)){
				directions.remove(directions.indexOf(str));
			}
		}
		if(directions.size() < 4){
			int random = (int)(Math.random() * directions.size() + 1);
			randomMovement = directions.get(random - 1);
		} else {
			int random = (int)(Math.random() * 4 + 1);
			randomMovement = directions.get(random - 1);
		}
		directions = new ArrayList<String>(copy);
	}
}
