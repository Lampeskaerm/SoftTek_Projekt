package Pacman;
import java.awt.Point;



public class GetLocations {
        int Width, Height;
        String[][] Array;
        Point pacmanPos, redGhostPos, cyanGhostPos, pinkGhostPos, orangeGhostPos;
        
        RedGhostLocation redGhostLoc;
        PacmanLocation pacmanLoc;
        CyanGhostLocation cyanGhostLoc;
        PinkGhostLocation pinkGhostLoc;
        OrangeGhostLocation orangeGhostLoc;
        
        public GetLocations(String[][] Array, int Width, int Height, Point pacmanPos, Point redGhostPos, Point cyanGhostPos, Point pinkGhostPos, Point orangeGhostPos){
                this.Array = Array;
                this.Width = Width;
                this.Height = Height;
                this.pacmanPos = pacmanPos;
                this.redGhostPos = redGhostPos;
                this.cyanGhostPos = cyanGhostPos;
                this.pinkGhostPos = pinkGhostPos;
                this.orangeGhostPos = orangeGhostPos;
                
                redGhostLoc = new RedGhostLocation(Array, Width, Height, redGhostPos);
                pacmanLoc = new PacmanLocation(Array, Width, Height, pacmanPos);
                cyanGhostLoc = new CyanGhostLocation(Array, Width, Height, cyanGhostPos);
                pinkGhostLoc = new PinkGhostLocation(Array, Width, Height, pinkGhostPos);
                orangeGhostLoc = new OrangeGhostLocation(Array, Width, Height, orangeGhostPos);
        }
        
        //Get location functions.
        public void getLocationPacMan(){
                pacmanLoc.getLocation();
                pacmanPos = pacmanLoc.pacmanPos;
        }
        
        public void getLocationRedGhost(){
                redGhostLoc.getLocation();
                redGhostPos = redGhostLoc.redGhostPos;
        }
        
        public void getLocationCyanGhost(){
                cyanGhostLoc.getLocation();
                cyanGhostPos = cyanGhostLoc.cyanGhostPos;
        }
        
        public void getLocationPinkGhost(){
                pinkGhostLoc.getLocation();
                pinkGhostPos = pinkGhostLoc.pinkGhostPos;
        }
        
        public void getLocationOrangeGhost(){
                orangeGhostLoc.getLocation();
                orangeGhostPos = orangeGhostLoc.orangeGhostPos;
        }
}