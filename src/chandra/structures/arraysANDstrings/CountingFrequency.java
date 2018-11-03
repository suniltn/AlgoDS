package com.chandra.structures.arraysANDstrings;

public class CountingFrequency {
	
	// O(n^2) time and O(1) space
    public static void countFrequenciesNaive(int[] input) {
        int n = input.length;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (input[j] == i) {
                    count++;
                }
            }
            System.out.println(i + " " + count);
        }
    }
    
    
    
    /**
     * 
     * Algorithm 3: O(n) time and O(1) space
1. Reduce all elements by 1 so that the elements are converted in the range 0 to n-1.
2. Traverse the input array and for i = 0 to n-1, add n to element at index (input[i]%n). After all the elements are completed, element at index i will be increment by n*k where k is the number of times i occurs in the array.
3. Finally, print counts of elements. Count of i+1 will be input[i]/n. 
Reason: 
Element at index i will be equal to input[i] + n*k where k is the number of times i occurs in the array.
On dividing by n, we get: (input[i] + n*k)/n = input[i]/n + (n*k)/n = 0 + k = k = the number of times i occurs in the array
As initially, all elements were reduced by 1, so this is count of i+1. 
4. Traverse input array once and set input[i] = input[i]%n+1 to get original array.

     */
	
	// O(n) time and O(1) space
	public static void countEfficient(int[] array) {
		int n = array.length;
		
		//for (int i=0;i<n;i++)
		//	array[i]--;
		
		// logic here is we are using the value stored at index as a index to update the value after
		// adding the (n+1) to it
		//Basically increasing by (maxVal +1) i.e n+1 at corresponding indices and 
		//in the second loop the extra(originally stored)value being lesser than (n+1) doesn't matter after division anyways.
		for (int i=0;i<n;i++)
			array[(array[i]-1)%(n+1)] += (n+1);
		
		for (int i=0;i<n;i++)
			System.out.println((i+1) + "->" + array[i]);
	}
	
	// O(n) time and O(n) space
    public static void countFrequencies(int[] input) {
        int n = input.length;
        int[] count = new int[n];
 
        for (int i = 0; i < n; i++) {
            count[i] = 0;
        }
 
        for (int i = 0; i < n; i++) {
            count[input[i] - 1]++;
        }
 
        for (int i = 0; i < n; i++) {
            System.out.println(i + 1 + " " + count[i]);
        }
    }
    
	public static void main(String[] args) {
		int[] array = {1,2,4,7,7,6,5};
		countEfficient(array);
		int[] array1 = {1,2,4,7,7,6,5};
		countFrequencies(array1);
		
		String str = "bc";
		for (int i=0;i<=str.length();i++)
			System.out.println(str.substring(0,i));
	}
}
