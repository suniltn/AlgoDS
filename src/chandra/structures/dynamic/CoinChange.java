package com.chandra.structures.dynamic;

public class CoinChange {
	
	public static int dynamic(int[] v, int amount) {
		int[][] solution = new int[v.length + 1][amount + 1];

		// if amount=0 then just return empty set to make the change
		for (int i = 0; i <= v.length; i++) {
			solution[i][0] = 1;
		}

		// if no coins given, 0 ways to change the amount
		for (int i = 1; i <= amount; i++) {
			solution[0][i] = 0;
		}

		// now fill rest of the matrix.

		for (int i = 1; i <= v.length; i++) {
			for (int j = 1; j <= amount; j++) {
				// check if the coin value is less than the amount needed
				if (v[i - 1] <= j) { // Including a coin
					// reduce the amount by coin value and
					// use the subproblem solution (amount-v[i]) and
					// add the solution from the previous coin with amount subproblem
					solution[i][j] = solution[i - 1][j] // previous coin with same amount + same coin with amount-v[i]
							+ solution[i][j - v[i - 1]];
				} else { // Excluding a coin
					// just copy the value from the previous coin subproblem
					solution[i][j] = solution[i - 1][j];
				}
			}
		}
		
		for (int i=0;i<solution.length;i++) {
			for (int j=0;j<solution[0].length;j++) {
				System.out.print(solution[i][j] + "	");
			}
			System.out.println();
		}
		
		return solution[v.length][amount];
	}

	public static void main(String[] args) {
		int amount = 7;
		int[] v = {1,3,4,5};
		System.out.println("By Dynamic Programming " + dynamic(v, amount));
	}

}
