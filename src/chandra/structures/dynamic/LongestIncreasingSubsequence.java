package com.chandra.structures.dynamic;

public class LongestIncreasingSubsequence {

	public static int subSequence(int[] A) {
		int[] LIS = new int[A.length];
		
		for (int i=0;i<A.length;i++) {
			int max = -1; // Every new element that's being processed has max subsequence as -1
			for (int j=0;j<i;j++) { // this loop goes from 0th index to i-1th index
				if (A[j] < A[i]) {
					if (max == -1 || LIS[j]+1 > max) { 
						// if current processing element's LIS value + 1 is greater than previous computed max subsequence value then update max to include current value to subsequence
						// or if the max subsequence hasn't been calculated yet for current element
						max = LIS[j]+1;
					}
				}
			}
			if (max == -1) max = 1; // if there was no max subsequence found for current value then max subsequence is 1 which just for current element
			LIS[i] = max;
		}
		
		// Now loop through the LIS to pick the maximum subsequence among all the elements
		int result = -1;
		int resultIndex = -1;
		for (int i=0;i<A.length;i++) {
			if (result < LIS[i]) {
				result = LIS[i];
				resultIndex = i;
			}
		}
		
		// Printing the longest increasing subsequence elements
		// Step 1: Start processing LIS from right side to print the elements for LIS
		String path = A[resultIndex] + " "; // last element
		int res = result - 1;
		for (int i=resultIndex-1;i>=0;i--) { // we start from resultIndex-1 because we already know resultIndex has the LIS value
			if (LIS[i] == res) { // this condition is to check if LIS Index -1 value is equal to previous resultant LIS
				// the main idea here to find the index of LIS starting from right and pick that element from original array elements
				path = A[i] + " " + path;
				res--;
			}
		}
		System.out.println("Actual Elements: " + path);	
		
		return result;
		
	}
	
	/* lis() returns the length of the longest increasing
    subsequence in arr[] of size n */
	public static int lis(int[] A) {
		int lis[] = new int[A.length];
		int max = 0;
		
		/* Initialize LIS values for all indexes */
		for (int i=0;i<A.length;i++) {
			lis[i] = 1;
		}
		
		/* Compute optimized LIS values in bottom up manner */
		for (int i=1;i<A.length;i++) {
			for (int j=0;j<i;j++) {
				if (A[j]<A[i] && lis[j]+1>lis[i]) 
					lis[i] = lis[j]+1;
			}
		}
		
		/* Pick maximum of all LIS values */
        for (int i = 0; i < A.length; i++ )
           if ( max < lis[i] )
              max = lis[i];
        
        return max;
	}
	
	public static void main(String[] args) {
		int[] A = { 1, 12, 7, 0, 23, 11, 52, 31, 61, 69, 70, 2 };
		System.out.println(lis(A));
	}
}
