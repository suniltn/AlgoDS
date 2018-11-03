package com.chandra.structures.dynamic;

public class SmallSquare_13 {
	
	//http://algorithms.tutorialhorizon.com/dynamic-programming-minimum-numbers-are-required-whose-square-sum-is-equal-to-a-given-number/
	//http://www.geeksforgeeks.org/minimum-number-of-squares-whose-sum-equals-to-given-number-n/
	
	public static int getMinSquaresRec(int n) {
		// base cases
		if (n <= 3)
			return n;
		
		// getMinSquares rest of the table using recursive
        // formula
		int res = n; // Maximum squares required is n (1*1 + 1*1 + ..)
		
		for (int i=1;i<=n;i++) {
			int temp = i*i;
			if (temp > n) break; // since the square number cannot be greater than sum
			else res = Math.min(res, 1 + getMinSquaresRec(n-temp));
		}
		
		return res;
	}
	
	public static int getMinSquaresDP(int sum) {
		// Create a dynamic programming table
	    // to store sq
		int[] dp = new int[sum+1];
		
		// getMinSquares table for base case entries
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		
		// getMinSquares rest of the table using recursive
	    // formula
		for (int i=4;i<=sum;i++) {
			
			// max value is i as i can always be represented
	        // as 1*1 + 1*1 + ...
			dp[i] = i;
			// Go through all smaller numbers to
	        // to recursively find minimum
			for (int j=1;j<=i;j++) {
				if ((j*j) > i) break; // since the square number cannot be greater than sum
				else {
					dp[i] = Math.min(dp[i], 1+dp[i-(j*j)]); 
				}
			}
		}
		return dp[sum];
	}
	
	public static void main(String[] args) {
		System.out.println(getMinSquaresRec(4));
	}
}
