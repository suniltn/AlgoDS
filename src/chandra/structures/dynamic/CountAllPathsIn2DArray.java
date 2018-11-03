package com.chandra.structures.dynamic;

/**
 * Dynamic Programming — Count all paths from top left to bottom right of a mXn matrix

Objec­tive: Given two dimen­sional matrix, write an algo­rithm to count all pos­si­ble paths from top left cor­ner to bottom-right cor­ner. You are allowed to move only in two direc­tions, move right OR move down.

http://algorithms.tutorialhorizon.com/dynamic-programming-count-all-paths-from-top-left-to-bottom-right-of-a-mxn-matrix/
 */
public class CountAllPathsIn2DArray {

	public static int countDP(int [][] arrA){
		int[][] result = new int[arrA.length][arrA.length];
		
		result[0][0] = 1;
		
		for (int i=1;i<result.length;i++) {
			// all elements in first row will constitute to path
			result[0][i] = 1;
			
			// all elements in first column will constitute to path
			result[i][0] = 1;
		}
		
		for (int i=1;i<result.length;i++) {
			for(int j=1;j<result.length;j++) {
				result[i][j] = result[i-1][j] + result[i][j-1];
			}
		}

		/**
		 The result matrix would look lik
		 1	1	1
		 1	2	3
		 1	3	6
		 */
		
		
		return result[result.length-1][result.length-1];
	}

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, {7, 8, 9 } };
		System.out.println(countDP(a));
	}
}
