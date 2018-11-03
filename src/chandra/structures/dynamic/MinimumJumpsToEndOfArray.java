package com.chandra.structures.dynamic;

public class MinimumJumpsToEndOfArray {
	public static int minJumps(int[] a) {
		int n = a.length;
		int jumps[] = new int[n];
		
		if (n == 0 || a[0] == 0)
			return Integer.MAX_VALUE;
		
		jumps[0] = 0;
		for (int i=1;i<n;i++) {
			jumps[i] = Integer.MAX_VALUE;
		}
		
		for (int i=1;i<n;i++) {
			for (int j=0;j<i;j++) {
				// this condition check if index of j plus value at index j can be reached to index i or beyond, if yes then there's a possible jump
				// take the minimum of current ith value from jump and 1+jth value of jump
				if (j+a[j] >= i) {
					jumps[i] = Math.min(jumps[i], jumps[j]+1);
				}
			}
		}
		return jumps[n-1];
	}
	
	public static void main(String[] args) {
		int[] arr = {1,3,4,1,2,3};
		System.out.println(minJumps(arr));
	}
}
