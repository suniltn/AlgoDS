package com.chandra.structures.sorts;

import java.util.Arrays;

/** IN PLACE Algo **/

public class BubbleSort {
	public static void sort(int[] array) {
		if (array == null || array.length < 2)
			return;
		
		int size = array.length;
		// the reason for the variable swapped is, suppose if there were zero swappings in an iteration,
		// which means the array is already sorted and we do not need to continue just break out of the loop
		boolean swapped = true;
		while (swapped) {
			swapped = false;
			for (int i=1;i<size;i++) {
				if (array[i-1] > array[i]) {
					//swap
					int temp = array[i-1];
					array[i-1] = array[i];
					array[i] = temp;
					swapped = true;
				}
			}
			size--;
		}
	}
	
	public static void main(String[] args) {
		int[] array = {12, 35, 87, 26, 9, 28, 7};
		System.out.println("Before : " + Arrays.toString(array));
		sort(array);
		System.out.println("After : " + Arrays.toString(array));
	}
}
