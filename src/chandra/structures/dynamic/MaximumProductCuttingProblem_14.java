package com.chandra.structures.dynamic;

//http://algorithms.tutorialhorizon.com/dynamic-programming-maximum-product-cutting-problem/
//http://www.geeksforgeeks.org/dynamic-programming-set-36-cut-a-rope-to-maximize-product/

// This problem has both optimal substructure and overlapping subproblems properties hence we can solve it in both ways of DP
public class MaximumProductCuttingProblem_14 {

	//Time complexity O(2^n) - Top Down approach
	public static int maxProdutRecursion(int n) { 
		if (n == 0 || n == 1)
			return 0;
		
		// here we cut the rope and recurisvely call the cut function on remaining right part of rope
		
		int maxProd = Integer.MIN_VALUE;
		for (int i=1;i<n;i++)
			maxProd = Math.max(maxProd, Math.max(i*(n-i), i*maxProdutRecursion(n-i)));
		
		return maxProd;
	}
	
	//Time Complexity - O(n^2) Bottom Up
	public static int maxProductDP(int n) {
		int[] MPC = new int[n+1];
		
		MPC[0] = 0;
		MPC[1] = 0;
		
		for (int i=2;i<=n;i++) {
			int maxVal = 0;
			
			// here we cut the rope and check if we have product for left part and keep repeating it
			// we consider the rope from length 2 to whatever it was passed in to the function
			for (int j=1;j<i;j++) {
				maxVal = Math.max(maxVal, Math.max(j * (i-j), j*MPC[i-j]));
			}
			MPC[i] = maxVal;
			System.out.println("Length=" + i + ", Product="+MPC[i]);
		}
		
		return MPC[n];
	}
	
	public static void main(String[] args) {
		System.out.println(maxProductDP(10));
	}
}
