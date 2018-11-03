package com.chandra.structures.recursion;

/**
 *  Count all paths from top left to bottom right of a mXn matrix

Objec­tive: Given two dimen­sional matrix, write an algo­rithm to count all pos­si­ble paths from top left cor­ner to bottom-right cor­ner. You are allowed to move only in two direc­tions, move right OR move down.

http://algorithms.tutorialhorizon.com/dynamic-programming-count-all-paths-from-top-left-to-bottom-right-of-a-mxn-matrix/
 */
public class CountAllPathsIn2DArray {
	public static int count(int [][] arrA, int row, int col){
        //base case
        //check if last row OR column is reached since after that only one path
        //is possible to reach to the bottom right corner.
        if(row==arrA.length-1 || col==arrA.length-1){
            return 1;
        }
        return count(arrA, row+1, col) + count(arrA, row, col+1);
    }
	
	public static void main(String args[]) {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, {7, 8, 9 } };
		System.out.println(count(a, 0, 0));
	}
}
