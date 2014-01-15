package Pacman;

public class GameArray {
	int Width, Height;
	String[][] Array;
	
	public GameArray(String[][] Array, int Width, int Height){
		this.Array = Array;
		this.Width = Width;
		this.Height = Height;
	}
	
//	Creates array with correct starting strings.
	public void restartGameArray(){
		for(int i = 0; i < Width; i++){ 
            for(int j = 0; j < Height; j++){ 
                Array[i][j] = "pacDot"; 
            } 
        } 
        for(int i = 0; i < 11; i++){ 
            for(int j = 0; j < 9; j++){ 
                Array[i + 7][j + 9] = "blackSpace"; 
            } 
        } 
        Array[12][21] = "pacMan"; 
        Array[(int)(Width / 2)][(int)(Height / 2 - 2)] = "redGhostAndBlackSpace"; 
        Array[(int)(Width / 2 - 1)][(int)(Height / 2 - 1)] = "cyanGhostAndBlackSpace"; 
        Array[(int)(Width / 2)][(int)(Height / 2 - 1)] = "pinkGhostAndBlackSpace"; 
        Array[(int)(Width / 2 + 1)][(int)(Height / 2 - 1)] = "orangeGhostAndBlackSpace"; 
        Array[1][3] = "bigPacDot"; 
        Array[1][21] = "bigPacDot"; 
        Array[23][3] = "bigPacDot"; 
        Array[23][21] = "bigPacDot"; 
          
        //Wall placement. 
        for(int i = 0; i < 8; i++){ 
            Array[0][i + 1] = "Wall"; Array[24][i + 1] = "Wall";     
        } 
        for(int i = 0; i < 5; i++){ 
            Array[12][i] = "Wall"; Array[i + 10][6] = "Wall"; Array[i + 10][7] = "Wall"; Array[i + 10][22] = "Wall"; Array[i + 10][23] = "Wall"; Array[i][9] = "Wall"; Array[i + 20][9] = "Wall"; Array[i + 10][16] = "Wall"; 
            Array[i + 10][17] = "Wall"; Array[i][12] = "Wall"; Array[i + 20][12] = "Wall"; Array[i][14] = "Wall"; Array[i + 20][14] = "Wall"; Array[i][17] = "Wall"; Array[i + 20][17] = "Wall"; Array[i][10] = "blackSpace"; 
            Array[i][11] = "blackSpace"; Array[i + 20][10] = "blackSpace"; Array[i + 20][11] = "blackSpace"; Array[i][15] = "blackSpace"; Array[i][16] = "blackSpace"; Array[i + 20][15] = "blackSpace"; Array[i + 20][16] = "blackSpace"; 
        } 
        for(int i = 0; i < 7; i++){ 
            Array[7][i + 6] = "Wall"; Array[8][i + 6] = "Wall"; Array[16][i + 6] = "Wall"; Array[17][i + 6] = "Wall"; 
        } 
        for(int i = 0; i < 9; i++){ 
            Array[i + 2][26] = "Wall"; Array[i + 2][25] = "Wall"; Array[i + 14][26] = "Wall"; Array[i + 14][25] = "Wall"; 
        } 
        for(int i = 0; i < 2; i++){ 
            Array[i + 10][12] = "Wall"; Array[i + 13][12] = "Wall"; Array[i + 10][14] = "Wall"; Array[i + 13][14] = "Wall"; Array[i + 1][23] = "Wall"; Array[i + 1][22] = "Wall"; Array[i + 22][23] = "Wall"; Array[i + 22][22] = "Wall"; 
        } 
        for(int i = 0; i < 3; i++){ 
            Array[i + 8][9] = "Wall"; Array[i + 8][10] = "Wall"; Array[i + 14][9] = "Wall"; Array[i + 14][10] = "Wall"; Array[12][i + 8] = "Wall"; Array[12][i + 18] = "Wall"; Array[12][i + 24] = "Wall"; 
            Array[7][i + 22] = "Wall"; Array[8][i + 22] = "Wall"; Array[17][i + 22] = "Wall"; Array[16][i + 22] = "Wall"; Array[5][i + 21] = "Wall"; Array[4][i + 21] = "Wall"; Array[19][i + 21] = "Wall"; Array[20][i + 21] = "Wall"; 
        } 
        for(int i = 0; i < 4; i++){ 
            Array[i + 2][2] = "Wall"; Array[i + 2][3] = "Wall"; Array[i + 2][4] = "Wall"; Array[i + 2][6] = "Wall"; Array[i + 2][7] = "Wall"; Array[i + 14][2] = "Wall"; Array[i + 14][3] = "Wall"; Array[i + 14][4] = "Wall"; 
            Array[i + 19][2] = "Wall"; Array[i + 19][3] = "Wall"; Array[i + 19][4] = "Wall"; Array[i + 19][6] = "Wall"; Array[i + 19][7] = "Wall"; Array[i + 7][2] = "Wall"; Array[i + 7][3] = "Wall"; 
            Array[i + 7][4] = "Wall"; Array[5][i + 9] = "Wall"; Array[19][i + 9] = "Wall"; Array[5][i + 14] = "Wall"; Array[19][i + 14] = "Wall"; Array[7][i + 14] = "Wall"; Array[8][i + 14] = "Wall"; Array[16][i + 14] = "Wall"; 
            Array[17][i + 14] = "Wall"; Array[i + 2][19] = "Wall"; Array[i + 2][20] = "Wall"; Array[i + 19][19] = "Wall"; Array[i + 19][20] = "Wall"; Array[i + 14][19] = "Wall"; Array[i + 14][20] = "Wall"; Array[i + 7][19] = "Wall"; Array[i + 7][20] = "Wall"; 
        }    
        for(int i = 0; i < 25; i++){ 
            Array[i][28] = "Wall"; Array[i][0] = "Wall"; 
        } 
        for(int i = 0; i < 10; i++){ 
            Array[0][i + 18] = "Wall"; Array[24][i + 18] = "Wall"; 
        } 
        for(int i = 0; i < 6; i++){ 
            Array[i][13] = "blackSpace"; Array[i + 19][13] = "blackSpace"; 
        } 
        //Portalspaces. 
        Array[0][13] = "portal"; Array[24][13] = "portal"; 
	}
	
}
