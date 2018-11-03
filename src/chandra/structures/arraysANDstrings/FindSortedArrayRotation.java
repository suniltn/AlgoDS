package com.chandra.structures.arraysANDstrings;

public class FindSortedArrayRotation {
	public static int findRotation(int[] array) {
		int left = 0;
		int right = array.length-1;
		while (array[left] > array[right]) {
			int mid = left + (right - left)/2;
			if(array[mid] > array[right]) 
				left = mid + 1;
			else
				right = mid;
		}
		return left;
	}
	
	public static void main(String[] args) {
		int[] array = { 6, 1, 2, 3, 4, 5 };
		System.out.println(findRotation(array));
	}
}
