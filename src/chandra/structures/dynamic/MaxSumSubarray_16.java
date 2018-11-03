package com.chandra.structures.dynamic;

/** Kadane's Algorithm - https://en.wikipedia.org/wiki/Maximum_subarray_problem
*/

public class MaxSumSubarray_16 {


	// Here we are using dynamic programming
	public static void findMaxSum(int[] array) {
		// initially we start with first value in array as max and current sum
		int curSum = array[0];
		int maxSum = array[0];
		
		int n = array.length;
		
		// starting from second element in array
		for (int i=1;i<n;i++) {
			//compute current sum by adding next value to previous computed sum and compare the sum and
			// next value, pick which ever max
			curSum = Math.max(curSum + array[i], array[i]);
			
			// now with current sum compare the previously stored max sum, pick which ever is max as max
			// sum
			maxSum = Math.max(maxSum, curSum);
		}
		
		System.out.println("Max Sum : " + maxSum);
	}
	
	// the above function can be extended to print the elements contributing to max sum
	// Here we are using dynamic programming
		public static void findMaxSumWithElements(int[] array) {
			// initially we start with first value in array as max and current sum
			int curSum = array[0];
			int maxSum = array[0];
			
			int n = array.length;
			int startIndex = 0;
			int endIndex = 0;
			// starting from second element in array
			for (int i=1;i<n;i++) {
				//compute current sum by adding next value to previous computed sum and compare the sum and
				// next value, pick which ever max
				curSum = Math.max(curSum + array[i], array[i]);
				if (curSum == array[i]) startIndex = i;
				
				// now with current sum compare the previously stored max sum, pick which ever is max as max
				// sum
				maxSum = Math.max(maxSum, curSum);
				if (maxSum == curSum) endIndex = i;
			}
			
			System.out.println("Max Sum : " + maxSum);
			System.out.print("Elements for Max Sum : ");
			for (int i=startIndex;i<=endIndex;i++)
				System.out.print(array[i] + " ");
			
		}
	
	public static void main(String[] args) {
		int[] input = {2, -9, 5, 1, -4, 6, 0, -7, 8};
		findMaxSumWithElements(input);
	}

}
