package com.chandra.structures.dynamic;

public class Fibonacci {
	static int fibRec(int n) {
	    if (n <= 1)
	       return n;
	    return fibRec(n-1) + fibRec(n-2);
    }
	
	//O(n) space
	static int fibDP(int n) {
        /* Declare an array to store Fibonacci numbers. */
	    int f[] = new int[n+1];
	    int i;
	      
	    /* 0th and 1st number of the series are 0 and 1*/
	    f[0] = 0;
	    f[1] = 1;
	     
	    for (i = 2; i <= n; i++) {
	       /* Add the previous 2 numbers in the series
	         and store it */
	        f[i] = f[i-1] + f[i-2];
	    }
	      
	    return f[n];
    }
	
	
}
