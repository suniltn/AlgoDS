package com.chandra.structures.recursion;

/**
Print All Paths from Top left to bottom right in Two Dimensional Array

Objec­tive: Print all the paths from left top cor­ner to right bot­tom cor­ner in two dimen­sional array.

Input: Two Dimen­sional array

Out­put: Print all the paths.

Note: At the End of the arti­cle you will know what needs to be included if you want to print the diag­o­nal paths as well.

http://algorithms.tutorialhorizon.com/print-all-paths-from-top-left-to-bottom-right-in-two-dimensional-array/
*/
public class PrintAllPathsIn2DArray {
	int rowCount;
	int colCount;
	int[][] arrA;

	public PrintAllPathsIn2DArray(int arrA[][]) {
		this.arrA = arrA;
		rowCount = arrA.length;
		colCount = arrA[0].length;
	}
	
	public void printAll(int currentRow, int currentColumn, String path) {
		// If we reached last row
		if (currentRow == rowCount - 1) {
			for (int i = currentColumn; i < colCount; i++) {
				path += "-" + arrA[currentRow][i];
			}
			System.out.println(path);
			return;
		}
		
		// If we reached last column
		if (currentColumn == colCount - 1) {
			for (int i = currentRow; i <= rowCount - 1; i++) {
				path += "-" + arrA[i][currentColumn];
			}
			System.out.println(path);
			return;
		}
		path = path + "-" + arrA[currentRow][currentColumn];
		printAll(currentRow + 1, currentColumn, path);
		printAll(currentRow, currentColumn + 1, path);
		// below commented line needs to be uncommented if we need to print diagonal paths
		//printAll(currentRow + 1, currentColumn + 1, path);
	}
	
	public static void main(String args[]) {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, {7, 8, 9 } };
		PrintAllPathsIn2DArray p = new PrintAllPathsIn2DArray(a);
		p.printAll(0, 0, "");
	}
	
}
