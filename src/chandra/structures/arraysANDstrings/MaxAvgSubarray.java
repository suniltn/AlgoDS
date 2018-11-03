package com.chandra.structures.arraysANDstrings;

/**
Given an integer array and a number k, print the maximum sum subarray of size k.
Maximum average subarray of size k is a subarray (sequence of contiguous elements in the array) for which the average is maximum among all subarrays of size k in the array.
Average of k elements = (sum of k elements)/k
Since k > 0, the maximum sum subarray of size k will also be maximum average subarray of size k. So, the problem reduces to finding maximum sum subarray of size k in the array.
*/

public class MaxAvgSubarray {
	public static int getMaxAvgSubarrayStartIndex(int[] array, int k) {
		int n = array.length;
		
		if (k > n)
            throw new IllegalArgumentException("k should be less than or equal to n");
      
        if(k == n) {
            return 0;   // whole array is the solution
        }
        
        int maxSum = 0;
        int maxSumStartIndex = 0;
        for (int i=0;i<k;i++) {
        	maxSum = maxSum + array[i];
        }
        
        int sum = maxSum;
        for (int i=k;i<n;i++) {
        	sum = sum - array[i-k] + array[i];
        	if (sum > maxSum) {
        		maxSum = sum;
        		maxSumStartIndex = i-k+1;
        	}
        }
        
        return maxSumStartIndex;
	}
	
	public static void main(String[] args) {
		int[] array = {2, 4, 1, 2, 6, 1, 6, 3, 5};
		int k = 4;
		int index = getMaxAvgSubarrayStartIndex(array, k);
		for (int i=0; i<k; i++) {
			System.out.print(array[index++] + ",");
		}
	}
}
