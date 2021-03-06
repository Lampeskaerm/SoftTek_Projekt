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
        for(int i = 0; i < 13; i++){ 
            for(int j = 0; j < 11; j++){ 
                Array[i + 7][j + 9] = "blackSpace"; 
            } 
        } 
        Array[13][23] = "pacMan"; 
        Array[(int)(Width / 2)][(int)(Height / 2 - 2)] = "redGhostAndBlackSpace"; 
        Array[(int)(Width / 2 - 1)][(int)(Height / 2 - 1)] = "cyanGhostAndBlackSpace"; 
        Array[(int)(Width / 2)][(int)(Height / 2 - 1)] = "pinkGhostAndBlackSpace"; 
        Array[(int)(Width / 2 + 1)][(int)(Height / 2 - 1)] = "orangeGhostAndBlackSpace"; 
        Array[1][3] = "bigPacDot"; 
        Array[1][21] = "bigPacDot"; 
        Array[25][3] = "bigPacDot"; 
        Array[25][21] = "bigPacDot"; 
         
        //blackspace.
        for(int i = 0; i < 4; i++){
        	Array[13][i] = "blackSpace"; 
        }
        for(int i = 0; i < 3; i++){
        	Array[i + 3][3] = "blackSpace"; Array[i + 8][3] = "blackSpace"; Array[i + 17][3] = "blackSpace"; Array[i + 22][3] = "blackSpace";  Array[13][7 + i] = "blackSpace"; Array[13][19 + i] = "blackSpace";
        	Array[13][25 + i] = "blackSpace";
        }
        for(int i = 0; i < 6; i++){
        	for(int j = 0; j < 9; j++){
        		Array[i][j + 10] = "blackSpace";
        		Array[i + 21][j + 10] = "blackSpace";
        	}
        }
        
        //Wall placement. 
        //vertical and horizontal walls.
        Array[2][3] = "verticalWall"; Array[5][3] = "verticalWall"; Array[7][3] = "verticalWall"; Array[10][3] = "verticalWall"; Array[13][4] = "horizontalWall"; Array[16][3] = "verticalWall";
        Array[19][3] = "verticalWall"; Array[21][3] = "verticalWall"; Array[24][3] = "verticalWall"; Array[9][9] = "horizontalWall"; Array[9][10] = "horizontalWall"; Array[17][9] = "horizontalWall"; Array[17][10] = "horizontalWall";
        Array[11][7] = "horizontalWall"; Array[15][7] = "horizontalWall"; Array[13][10] = "horizontalWall"; Array[11][13] = "horizontalWall"; Array[11][12] = "horizontalWall"; Array[11][15] = "horizontalWall"; Array[11][16] = "horizontalWall";
        Array[15][13] = "horizontalWall"; Array[15][12] = "horizontalWall"; Array[15][15] = "horizontalWall"; Array[15][16] = "horizontalWall"; Array[13][22] = "horizontalWall"; Array[15][19] = "horizontalWall"; Array[11][19] = "horizontalWall";
        Array[3][22] = "horizontalWall"; Array[23][22] = "horizontalWall"; Array[1][24] = "horizontalWall";  Array[1][25] = "horizontalWall";  Array[25][24] = "horizontalWall";  Array[25][25] = "horizontalWall";  Array[13][28] = "horizontalWall";
        Array[9][27] = "horizontalWall"; Array[17][27] = "horizontalWall"; Array[15][25] = "horizontalWall"; Array[11][25] = "horizontalWall";
        
        for(int i = 0; i < 25; i++){
        	Array[1 + i][30] = "horizontalWall";
        }
        for(int i = 0; i < 8; i++){
        	Array[0][1 + i] = "verticalWall"; Array[26][1 + i] = "verticalWall";
        }
        for(int i = 0; i < 11; i++){
        	Array[1 + i][0] = "horizontalWall"; Array[15 + i][0] = "horizontalWall"; 
        }
        for(int i = 0; i < 2; i++){
        	Array[3 + i][2] = "horizontalWall"; Array[3 + i][4] = "horizontalWall"; Array[22 + i][4] = "horizontalWall"; Array[22 + i][2] = "horizontalWall"; Array[8 + i][2] = "horizontalWall"; Array[8 + i][4] = "horizontalWall";
        	Array[17 + i][2] = "horizontalWall"; Array[17 + i][4] = "horizontalWall"; Array[3 + i][6] = "horizontalWall"; Array[3 + i][7] = "horizontalWall"; Array[22 + i][6] = "horizontalWall"; Array[22 + i][7] = "horizontalWall";
        	Array[8][7 + i] = "verticalWall"; Array[18][7 + i] = "verticalWall"; Array[12][8 + i] = "verticalWall"; Array[14][8 + i] = "verticalWall"; Array[8][11 + i] = "verticalWall"; Array[18][11 + i] = "verticalWall";
        	Array[3 + i][21] = "horizontalWall"; Array[22 + i][21] = "horizontalWall"; Array[22][23 + i] = "verticalWall"; Array[4][23 + i] = "verticalWall"; Array[8 + i][21] = "horizontalWall"; Array[8 + i][22] = "horizontalWall";
        	Array[17 + i][21] = "horizontalWall"; Array[17 + i][22] = "horizontalWall"; Array[12][20 + i] = "verticalWall";  Array[14][20 + i] = "verticalWall"; Array[7][25 + i] = "verticalWall"; Array[8][25 + i] = "verticalWall";
        	Array[18][25 + i] = "verticalWall"; Array[19][25 + i] = "verticalWall"; Array[14][26 + i] = "verticalWall"; Array[12][26 + i] = "verticalWall";
        }
        for(int i = 0; i < 3; i++){
        	Array[14][1 + i] = "verticalWall"; Array[12][1 + i] = "verticalWall"; Array[5][10 + i] = "verticalWall"; Array[21][10 + i] = "verticalWall"; Array[7][16 + i] = "verticalWall"; Array[8][16 + i] = "verticalWall";
        	Array[21][10 + i] = "verticalWall"; Array[19][16 + i] = "verticalWall"; Array[18][16 + i] = "verticalWall"; Array[5][22 + i] = "verticalWall"; Array[21][22 + i] = "verticalWall";
        	Array[5][16 + i] = "verticalWall"; Array[21][16 + i] = "verticalWall";
        }
        for(int i = 0; i < 4; i++){
        	Array[1 + i][9] = "horizontalWall"; Array[22 + i][9] = "horizontalWall"; Array[1 + i][19] = "horizontalWall"; Array[i + 22][19] = "horizontalWall"; Array[0][i + 20] = "verticalWall";  Array[0][i + 26] = "verticalWall";
        	 Array[26][i + 20] = "verticalWall";  Array[26][i + 26] = "verticalWall";  Array[3 + i][27] = "horizontalWall";   Array[20 + i][27] = "horizontalWall";
        }
        for(int i = 0; i < 5; i++){
        	Array[11 + i][6] = "horizontalWall"; Array[22 + i][9] = "horizontalWall"; Array[i][13] = "horizontalWall"; Array[i + 22][13] = "horizontalWall"; Array[i][15] = "horizontalWall"; Array[i + 22][15] = "horizontalWall";
        	Array[11 + i][18] = "horizontalWall";  Array[11 + i][24] = "horizontalWall"; 
        }
        for(int i = 0; i < 6; i++){
        	Array[7][i + 7] = "verticalWall"; Array[19][i + 7] = "verticalWall";
        }
        for(int i = 0; i < 7; i++){
        	Array[3 + i][28] = "horizontalWall"; Array[17 + i][28] = "horizontalWall";
        }
        
        //upleftwalls.
        Array[0][0] = "upLeftWall"; Array[14][0] = "upLeftWall"; Array[2][2] = "upLeftWall"; Array[7][2] = "upLeftWall"; Array[16][2] = "upLeftWall"; Array[21][2] = "upLeftWall"; Array[21][6] = "upLeftWall"; Array[2][6] = "upLeftWall";
        Array[21][9] = "upLeftWall";  Array[7][6] = "upLeftWall"; Array[10][6] = "upLeftWall"; Array[18][6] = "upLeftWall"; Array[14][7] = "upLeftWall"; Array[16][9] = "upLeftWall"; Array[8][10] = "upLeftWall";
        Array[10][12] = "upLeftWall"; Array[14][12] = "upLeftWall"; Array[10][15] = "upLeftWall"; Array[14][15] = "upLeftWall"; Array[7][15] = "upLeftWall";  Array[10][18] = "upLeftWall"; Array[18][15] = "upLeftWall";
        Array[0][19] = "upLeftWall"; Array[2][21] = "upLeftWall"; Array[7][21] = "upLeftWall"; Array[14][19] = "upLeftWall"; Array[16][21] = "upLeftWall"; Array[21][21] = "upLeftWall"; Array[21][15] = "upLeftWall"; Array[22][22] = "upLeftWall";
        Array[18][24] = "upLeftWall"; Array[16][27] = "upLeftWall"; Array[14][25] = "upLeftWall"; Array[10][24] = "upLeftWall"; Array[7][24] = "upLeftWall"; Array[0][25] = "upLeftWall"; Array[2][27] = "upLeftWall";
        Array[24][24] = "upLeftWall";
        
        //uprightwalls.
        Array[26][0] = "upRightWall"; Array[5][2] = "upRightWall"; Array[10][2] = "upRightWall"; Array[19][2] = "upRightWall"; Array[24][2] = "upRightWall"; Array[24][6] = "upRightWall"; Array[5][6] = "upRightWall"; Array[12][0] = "upRightWall"; 
        Array[5][9] = "upRightWall"; Array[19][6] = "upRightWall"; Array[16][6] = "upRightWall"; Array[8][6] = "upRightWall"; Array[12][7] = "upRightWall"; Array[10][9] = "upRightWall";  Array[18][10] = "upRightWall";
        Array[12][12] = "upRightWall"; Array[16][12] = "upRightWall"; Array[12][15] = "upRightWall"; Array[16][15] = "upRightWall";
        Array[5][15] = "upRightWall"; Array[8][15] = "upRightWall"; Array[19][15] = "upRightWall"; Array[16][18] = "upRightWall"; Array[26][19] = "upRightWall"; Array[4][22] = "upRightWall"; Array[5][21] = "upRightWall"; Array[2][24] = "upRightWall";
        Array[8][24] = "upRightWall"; Array[10][27] = "upRightWall";  Array[12][25] = "upRightWall"; Array[16][24] = "upRightWall"; Array[19][24] = "upRightWall"; Array[19][21] = "upRightWall"; Array[24][21] = "upRightWall"; Array[26][25] = "upRightWall";
        Array[24][27] = "upRightWall"; Array[12][19] = "upRightWall"; Array[10][21] = "upRightWall";
        
        //downleftwalls.
        Array[2][4] = "downLeftWall"; Array[2][7] = "downLeftWall"; Array[12][4] = "downLeftWall"; Array[16][4] = "downLeftWall"; Array[21][4] = "downLeftWall"; Array[21][7] = "downLeftWall"; Array[7][4] = "downLeftWall";
        Array[0][9] = "downLeftWall"; Array[21][13] = "downLeftWall"; Array[10][7] = "downLeftWall"; Array[8][9] = "downLeftWall"; Array[7][13] = "downLeftWall"; Array[18][13] = "downLeftWall";
        Array[16][10] = "downLeftWall"; Array[12][10] = "downLeftWall"; Array[10][13] = "downLeftWall"; Array[14][13] = "downLeftWall"; Array[10][16] = "downLeftWall"; Array[14][16] = "downLeftWall";
        Array[7][19] = "downLeftWall"; Array[10][19] = "downLeftWall"; Array[18][19] = "downLeftWall"; Array[21][19] = "downLeftWall"; Array[2][22] = "downLeftWall"; Array[0][24] = "downLeftWall"; Array[4][25] = "downLeftWall";
        Array[0][30] = "downLeftWall"; Array[2][28] = "downLeftWall"; Array[8][27] = "downLeftWall"; Array[10][25] = "downLeftWall"; Array[12][28] = "downLeftWall"; Array[7][22] = "downLeftWall"; Array[12][22] = "downLeftWall"; Array[16][22] = "downLeftWall";
        Array[16][28] = "downLeftWall"; Array[19][27] = "downLeftWall"; Array[21][25] = "downLeftWall"; Array[24][25] = "downLeftWall";
        
        //downrightwalls.
        Array[5][4] = "downRightWall"; Array[10][4] = "downRightWall"; Array[14][4] = "downRightWall"; Array[19][4] = "downRightWall"; Array[24][4] = "downRightWall"; Array[24][7] = "downRightWall";  Array[5][7] = "downRightWall";
        Array[26][9] = "downRightWall"; Array[5][13] = "downRightWall"; Array[16][7] = "downRightWall"; Array[18][9] = "downRightWall"; Array[10][10] = "downRightWall"; Array[14][10] = "downRightWall";  Array[19][13] = "downRightWall";
        Array[8][13] = "downRightWall"; Array[12][13] = "downRightWall"; Array[16][13] = "downRightWall"; Array[12][16] = "downRightWall"; Array[16][16] = "downRightWall"; Array[5][19] = "downRightWall"; Array[2][25] = "downRightWall";
        Array[26][24] = "downRightWall"; Array[26][30] = "downRightWall"; Array[24][28] = "downRightWall"; Array[22][25] = "downRightWall"; Array[19][22] = "downRightWall"; Array[16][19] = "downRightWall"; Array[19][19] = "downRightWall";
        Array[8][19] = "downRightWall"; Array[10][22] = "downRightWall"; Array[14][22] = "downRightWall"; Array[16][25] = "downRightWall";  Array[18][27] = "downRightWall"; Array[14][28] = "downRightWall"; Array[10][28] = "downRightWall";
        Array[7][27] = "downRightWall"; Array[5][25] = "downRightWall"; Array[24][22] = "downRightWall";
        
        //Portalspaces. 
        Array[0][14] = "portal"; Array[26][14] = "portal";
	}
	
}
