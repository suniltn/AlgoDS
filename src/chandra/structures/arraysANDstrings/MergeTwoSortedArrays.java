package com.chandra.structures.arraysANDstrings;

public class MergeTwoSortedArrays {
	public static int[] merge(int[] a, int[] b) {
	    int[] answer = new int[a.length + b.length];
	    int i = a.length - 1, j = b.length - 1, k = answer.length;

	    while (k > 0) {
	    	//  in case j < 0, b is already exhausted, so we keep adding the remaining a elements to the answer array 
	        answer[--k] = (j < 0 || (i >= 0 && a[i] >= b[j])) ? a[i--] : b[j--];
	    }
	    return answer;
	}
	
	public static int[] merge1(int[] a, int[] b) {
	    int[] mergedArray = new int[(a.length + b.length)];
	    int i = 0, j = 0;
	    int mergedArrayIndex = 0;
	    for (; i < a.length || j < b.length;) {
	        if (i < a.length && j < b.length) {
	            if (a[i] < b[j]) {
	                mergedArray[mergedArrayIndex] = a[i];
	                i++;
	            } else {
	                mergedArray[mergedArrayIndex] = b[j];
	                j++;
	            }
	        } else if (i < a.length) {
	            mergedArray[mergedArrayIndex] = a[i];
	            i++;
	        } else if (j < b.length) {
	            mergedArray[mergedArrayIndex] = b[j];
	            j++;
	        }
	        mergedArrayIndex++;
	    }
	    return mergedArray;
	}
}
