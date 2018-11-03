package com.chandra.structures.dynamic;

/**
 * http://javabypatel.blogspot.in/2016/09/knapsack-problem-solution-recursive-iterative.html
 */
public class Knapsack {
	
	private static int maximizeProfit(int[] weights, int[] amounts, int knapsackMaxWeight) {
		
		// Rows represent weights and column represent max sack weights
		int[][] K = new int[weights.length+1][knapsackMaxWeight+1];
		
		for (int row=0;row<=weights.length;row++) {
			for (int col=0;col<=knapsackMaxWeight;col++) {
				
				// when max sack wieght is 0, nothing you can be taken since there's no sack to load weights
				// when there's no weight available, nothing can be put into sack to take home
				if (row == 0||col == 0) continue; 
				
				//Since col represent Sack weight, hence if sack is >= item weight,
			    //it means item is eligible to be picked to put into sack.
				if (col >= weights[row-1]) {
					//Checking picking the item will give Max profit or not picking the item will give Max amount/profit.
					//add the current weight amount of sack weight with previous weight's amount for same sack capacity
					int pickingItemAmount = amounts[row-1] + K[row-1][col-weights[row-1]];
					
					//this is nothing but previous weight's amount for same sack capacity
					int notPickingItemAmount = K[row-1][col];
					
					// Now take the max amount 
					K[row][col] = Math.max(pickingItemAmount, notPickingItemAmount);
				} else {
					//Sack weight is less than item weight, So can't pick item and Max profit we 
				     //can get at this point is profit we got in previous step by not picking current item
					K[row][col] = K[row-1][col];
				}
			}
		}
		
		return K[weights.length][knapsackMaxWeight];
		
		
	}
	
	public static void main(String[] args) {
		int knapsackMaxWeight = 5;
		int amounts[] = {200, 240, 140, 150};
		int weights[] = {1, 3, 2, 5};
		
		System.out.println(maximizeProfit(weights, amounts, knapsackMaxWeight));
	}
	
}
