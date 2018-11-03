package com.chandra.structures.dynamic;

/**
Objec­tive: Given two dimen­sional matrix, write an algo­rithm to find out the snake sequence which has the max­i­mum length. There could be many snake sequence in the matrix, you need to return the one with the max­i­mum length. Travel is allowed only in two direc­tions, either go right OR go down.

What is snake sequence: Snake sequence can be made if num­ber in adja­cent right cell or num­ber in the adja­cent down cell is either +1 or –1 from the num­ber in the cur­rent cell.

E.g: 

*9,  6,  5,  2
*8, *7, *6, *5
 7,  3,  1, *6
 1,  1,  1, *7
 
 
 http://algorithms.tutorialhorizon.com/find-longest-snake-sequence-in-a-given-matrix/
 http://www.geeksforgeeks.org/find-maximum-length-snake-sequence/
*/

public class LongestSnakeSequence {
	public static int maximumSnakeSequence(int[][] matrix) {
		int maxLen = 0;
		int maxRow = 0;
		int maxCol = 0;
		
		int rows = matrix.length;
		int col = matrix[0].length;
		int[][] res = new int[rows][col];
		
		for (int i=0;i<rows;i++) {
			for (int j=0;j<col;j++) {
				//skip matrix[0][0]
				if (i != 0 || j != 0) {
					// look above except first row, hence i>0
					if (i>0 && Math.abs(matrix[i][j] - matrix[i-1][j]) == 1) {
						// update current field in res by taking max of current field value
						// and above field value +1. We add 1 to because there's a sequence to current
						// field in matrix
						res[i][j] = Math.max(res[i][j], res[i-1][j]+1);
						// update maxLen, maxRow and maxCol index
						if (maxLen < res[i][j]) {
							maxLen = res[i][j];
							maxRow = i;
							maxCol = j;
						}
					}
					
					// look left except first column, hence j>0
					if (j>0 && Math.abs(matrix[i][j] - matrix[i][j-1]) == 1) {
						res[i][j] = Math.max(res[i][j], res[i][j-1]+1);
						
						// update maxLen, maxRow and maxCol index
						if (maxLen < res[i][j]) {
							maxLen = res[i][j];
							maxRow = i;
							maxCol = j;
						}
					}
				}
			}
		}
		
		printPath(matrix, res, maxLen, maxRow, maxCol);
		return maxLen;
	}
	
	public static void printPath(int[][] matrix, int[][] result, int maxLen, int maxRow, int maxCol) {
		while(maxLen>0) {
			System.out.println(" - " + matrix[maxRow][maxCol]);
			if (maxRow>0 && Math.abs(result[maxRow][maxCol]-result[maxRow-1][maxCol]) == 1)
				maxRow--;
			if (maxCol>0 && Math.abs(result[maxRow][maxCol]-result[maxRow][maxCol-1]) == 1)
				maxCol--;
			
			maxLen--;
		}
	}
	
	public static void main(String[] args) {
		
		int[][] mat =
		    {
		        {9, 6, 5, 2},
		        {8, 7, 6, 5},
		        {7, 3, 1, 6},
		        {1, 1, 1, 7},
		    };
		
		System.out.println("Maximum Snake Sequence Length : " + maximumSnakeSequence(mat));
	}
}
