package com.chandra.structures.leetcode;

/**
Rotate an array of n elements to the right by k steps.
For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
How many different ways do you know to solve this problem?
 */
public class RotateArray {

	/**
	Solution 1 - Intermediate Array
	In a straightforward way, we can create a new array and then copy elements to 
	the new array. Then change the original array by using System.arraycopy().	 
	*/
	
	public void rotateUsingIntermediateArray(int[] nums, int k) {
		  if (k > nums.length) k = k % nums.length;
		  
		  int[] result = new int[nums.length];
		  
		  // copy last k elements to beginning temp array
		  for(int i=0; i < k; i++)
			  result[i] = nums[nums.length-k+i];
		  
		  // copy for n-k elements to temp array starting from k
		  int j=0;
		  for(int i=k; i<nums.length; i++) {
			  result[i] = nums[j];
			  j++;
		  }
		  
		  System.arraycopy(result, 0, nums, 0, nums.length);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
