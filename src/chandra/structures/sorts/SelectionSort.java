package com.chandra.structures.sorts;

import java.util.Arrays;

/** IN PLACE Algo **/

public class SelectionSort {

	public static void sort(int[] array) {
		if (array == null || array.length < 2) return;
		
		int minIndex;
		int size = array.length;
		for (int i=0;i<size-1;i++) { // the reason we go till size-1 is because by the time we reach end the
			// last element will be in correct sorted position hence we can reduce one iteration
			minIndex = i;
			for (int j=i;j<size;j++) {
				if (array[j] < array[minIndex])
					minIndex = j;
			}
			if (i != minIndex && array[i] != array[minIndex]) {
				int temp = array[minIndex];
				array[minIndex] = array[i];
				array[i] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = {12, 35, 87, 26, 9, 28, 7};
		System.out.println("Before : " + Arrays.toString(array));
		sort(array);
		System.out.println("After : " + Arrays.toString(array));
	}
}
