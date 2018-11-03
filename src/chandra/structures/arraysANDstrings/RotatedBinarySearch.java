package com.chandra.structures.arraysANDstrings;

//http://articles.leetcode.com/searching-element-in-rotated-array/
public class RotatedBinarySearch {
	
	public static int binarysearch(int[] array, int key) {
		int left = 0;
		int right = array.length-1;
		
		while (left <= right) {
			// Avoid overflow, same as M=(L+R)/2
			int mid = left + ((right-left)/2);
			
			// the bottom half is sorted
			if (key == array[mid]) return mid;
			
			if (array[left]<=array[mid]) {
				if (array[left]<=key && key < array[mid]) 
					right = mid-1;
				else left = mid+1;
					
			} else { // the upper right is sorted
				 if (array[mid] < key && key <= array[right])
					 left = mid+1;
				 else
					 right = mid-1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] array = {4,5,6,7,0,1,2,3};
		System.out.println(binarysearch(array, 4));
	}

}
