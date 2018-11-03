package com.chandra.structures.dynamic;


/**
 *Dynamic Programming — Count all paths in 2D Matrix with Obstructions in it
BY SJ · JUNE 20, 2016

Objec­tive: Given two dimen­sional matrix, write an algo­rithm to count all pos­si­ble paths from top left cor­ner to bottom-right cor­ner. You are allowed to move only in two direc­tions, move right OR move down. There are few obstruc­tions as well, means few cells are blocked and you can­not travel that cell.

Many times this prob­lem is being referred as “Robot Travel Prob­lem”. Given a 2d matrix, how many ways a robot can travel from top left cor­ner to bot­tom right cor­ner and there are few cells in which robot can­not travel.

http://algorithms.tutorialhorizon.com/dynamic-programming-count-all-paths-in-2d-matrix-with-obstructions-in-it/
 */
public class NoOfPathObstruction {
	public static int countDP(int[][] arr) {
		int[][] result = arr;
		
		for (int i=1;i<result.length;i++) {
			for (int j=1;j<result.length;j++) {
				if (result[i][j] != -1) {
					result[i][j]=0;
					if (result[i-1][j]>0) {
						result[i][j] += result[i-1][j];
					}
					if (result[i][j-1]>0) {
						result[i][j] += result[i][j-1];
					}
				}
			}
		}
		
		return result[arr.length-1][arr.length-1];
	}
	
	public static void main(String[] args) {
		int arrA [][] = {{1,1,1},{1,-1,1},{1,-1,1}};
		System.out.println(countDP(arrA));
	}
}
