package com.chandra.structures.dynamic;

public class LongstCommonSubsequence {
	
	
	//whenever there's match of character then we increase the value of previous char match by 1
	// where there's no match then we continue to use whatever previous char match value is
	
	public int lcs(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		// similar to wildcard matching, create a 2D with extra row and column for null character
		int[][] L = new int[n+1][m+1];
		for (int i=1;i<=n;i++) {
			for (int j=1;j<=m;j++) {
				if (str1.charAt(i-1)==str2.charAt(j-1))
					L[i][j] = L[i-1][j-1] + 1;
				else
					L[i][j] = Math.max(L[i][j-1], L[i-1][j]);
				
				
			}
		}
		// last value in 2D array will have the longest common subsequence count
		return L[n][m];
	}

	public static void main(String[] args) {
		String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        
       LongstCommonSubsequence lcs = new LongstCommonSubsequence();
       System.out.println(lcs.lcs(str1, str2));
	}

}
