package com.chandra.structures.dynamic;

import java.util.Arrays;


//http://algorithms.tutorialhorizon.com/dynamic-programming-maximum-subarray-problem/
public class LargestSumOfSubArray {
	
	//bottom up approach
	/**
	To cal­cu­late the solu­tion for any ele­ment at index “i” has two options
	EITHER added to the solu­tion found till “i-1“th index
	OR start a new sum from the index “i”.
	*/
    public static int solveDP(int [] a){
    	int[] solution = new int[a.length];
    	solution[0] = a[0];
    	int maxSoFar = a[0];
    	for (int i=1;i<a.length;i++) {
    		solution[i] = Math.max(solution[i-1]+a[i], a[i]);
    		maxSoFar = Math.max(maxSoFar, solution[i]);
    	}
    	
    	System.out.println("My DP : " + Arrays.toString(solution));
    	return maxSoFar;
    }
    
    //kadane's algorithm
    public static int kadane(int[] a) {
    	int curMax = a[0];
    	int maxSoFar = a[0];
    	for (int i=1;i<a.length;i++) {
    		curMax = Math.max(curMax+a[i], a[i]);
    		maxSoFar = Math.max(curMax, maxSoFar);
    	}
    	return maxSoFar;
    }
    
    public static int solve(int [] a){
        int [] solution = new int[a.length+1];
        solution[0] = 0;

        for (int j = 1; j <solution.length ; j++) {
            solution[j] = Math.max(solution[j-1]+a[j-1],a[j-1]);
        }
        //this will print the solution matrix
        System.out.println(Arrays.toString(solution));
        //now return the maximum in the solution array
        int result = solution[0];
        for (int j = 1; j <solution.length ; j++) {
            if(result<solution[j])
                result = solution[j];
        }

        return result;
    }

	
	public static void main(String[] args) {
        int arrA[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println(solve(arrA));
        System.out.println(solveDP(arrA));
        System.out.println(kadane(arrA));
	}

}
