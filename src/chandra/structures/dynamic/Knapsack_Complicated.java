package com.chandra.structures.dynamic;

//http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/

public class Knapsack_Complicated {
	// A utility function that returns maximum of two integers
    static int max(int a, int b) { return (a > b)? a : b; }
      
   // Returns the maximum value that can be put in a knapsack of capacity W
    static int knapSack(int W, int wt[], int val[], int n)
    {
     int K[][] = new int[n+1][W+1];
      
     // Build table K[][] in bottom up manner
     for (int i = 0; i <= n; i++)
     {
         for (int w = 0; w <= W; w++)
         {
             if (i==0 || w==0)
                  K[i][w] = 0;
             else if (wt[i-1] <= w)
            	 // taking max of current wt's value + previous weight's (totalweight - current weight) vs previous wt's current value
            	 
            	 /*
            	  	index	value	weight (wt)
            	  	0		1		1
            	  	1		4		3
            	  	2		5		4
            	  	3		7		5
            	  	
            	   
            	 		<------ weights ---> (total weight split into individual)
            	 i/w|	0	1	2	3	4	5	6	7					
            	 ---|--------------------------------
            	 0	|	0	0	0	0	0	0	0	0
            	 1	|	0	1	1	1	1	1	1	1	
            	 2	|	0	1	1	4	5	5	5	5
            	 3	|	0	1	1	4	5	6	7	9
            	 4	|	0	1	1	4	5	7	8	[9] - ans
            	 
            	 */
                   K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
             else
                   K[i][w] = K[i-1][w];
         }
      }
      
     for (int i=0;i<K.length;i++) {
			for (int j=0;j<K[0].length;j++) {
				System.out.print(K[i][j] + "	");
			}
			System.out.println();
		}
      return K[n][W];
    }
    
    public static void main(String[] args) {
		int val[] = {1,4,5,7};
		int wt[] = {1,3,4,5};
		int W = 7;
		int n = val.length;
		System.out.println(knapSack(W, wt, val, n));
	}
}
