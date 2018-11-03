package com.chandra.structures.dynamic;


/*
Cre­ate an aux­il­iary array of the same size as given input array. We will fill the aux­il­iary array with Max­i­mum size square sub-matrix with all 1’s pos­si­ble with respect to the par­tic­u­lar cell.
Once the aux­il­iary is fill, scan it and find out the max­i­mum entry in it, this will the size of Max­i­mum size square sub-matrix with all 1’s in the given matrix.
How to fill the aux­il­iary matrix??

Copy the first row and first col­umn from the given array to aux­il­iary array. (Read the base cases described earlier).
For fill­ing rest of cells, check if par­tic­u­lar cell’s value is 0 in given array, if yes then put 0 against to that cell in aux­il­iary array.
check if par­tic­u­lar cell’s value is 1 in given array, if yes then put Min­i­mum (value in the left cell, top cell and left-top diag­o­nal cell) + 1 in aux­il­iary cell.
Base Cases:
sub[i][0] = arrA[i][0] i = 0 to row Count // copy the first col­umn
sub[0][i] = arrA[0][i] i = 0 to col­umn Count // copy the first row

for rest of the cells
sub[i][j] = 0 if arrA[i][j]=0               = Min(arrA[i-1][j], arrA[i][j-1], arrA[i-1][j-1] )
At the End, scan the sub[][] and find out the max­i­mum entry in it.


http://algorithms.tutorialhorizon.com/dynamic-programming-maximum-size-square-sub-matrix-with-all-1s/
 */
public class MaximumSizeSquareSubMatrixWith1s {

	public static int subMatrix(int[][] arr) {
		int rows = arr.length;
		int cols = arr[0].length;
		
		int[][] sub = new int[rows][cols];
		
		int maxSize = 0;
		
		// copy first row to sub
		for (int i=0;i<cols;i++) 
			sub[0][i] = arr[0][i];
		
		// copy first column to sub
		for (int i=0;i<rows;i++)
			sub[i][0] = arr[i][0];
		
		for (int i=1;i<rows;i++)
			for (int j=1;j<cols;j++) {
				if (arr[i][j] == 1) {
					                     //left                  top           topleft or diagonal
					sub[i][j] = Math.min(sub[i][j-1], Math.min(sub[i-1][j], sub[i-1][j-1])) + 1;
					maxSize = Math.max(maxSize, sub[i][j]);
				} else {
					sub[i][j] = 0;
				}
			}
		return maxSize;
	}
	
	public static void main(String[] args) {
		int[][] arrA = { { 0, 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1, 0 },
				{ 0, 1, 1, 1, 1, 0 }, { 0, 0, 1, 1, 1, 0 },
				{ 1, 1, 1, 1, 1, 1 } };
		System.out.println(subMatrix(arrA));
	}
}
