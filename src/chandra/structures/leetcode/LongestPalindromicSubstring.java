package com.chandra.structures.leetcode;

public class LongestPalindromicSubstring {
	
	// Reference : http://articles.leetcode.com/longest-palindromic-substring-part-i/
	/**
	 Stated more formally below:

Define P[ i, j ] ← true iff the substring Si … Sj is a palindrome, otherwise false.
Therefore,

P[ i, j ] ← ( P[ i+1, j-1 ] and Si = Sj )
The base cases are:

P[ i, i ] ← true
P[ i, i+1 ] ← ( Si = Si+1 )

	 */
//run time complexity of O(N2) and uses O(N2) space to store the table.	
	public String longestPalindrome0(String s) {
    int n = s.length();
    
    //2D array for Dynamic Programming
    boolean[][] LPS = new boolean[n][n];
    
    // start with comparing one element - always one character is a palindrome to itself
    int lpsIndex = 0;
    int lpsLen = 1;
    for (int i=0;i<n;i++) {
    	LPS[i][i] = true;
    }

    // Proceed to compare 2 elements and only if both characters are same
    // then they are palindrome 
    for (int i=0;i<n-1;i++) {
    	if (s.charAt(i) == s.charAt(i+1)) {
    		LPS[i][i+1] = true;
    		lpsIndex = i;
    		lpsLen = 2;
    	}
    }
    
    // proceed with take 3 elements into considering and move on to next set
    // hence we start with len 3 and move forward till the end of the string which is equals to length of the string
    // keep two pointers starting and ending. If start and end characters are same then check string of characters
    // between them if they are already palindrome then these characters also count towards a palindrome
    // increasing length of palin string by 2
    
    // this looks like expanding the comparison window and moving till the end of the string 
    
    for (int len=3;len<=n;len++) {
    	for (int i=0;i<n-len+1;i++) {
    		int j = i+len-1;
    		if (s.charAt(i) == s.charAt(j) && LPS[i+1][j-1]) {
    			LPS[i][j] = true;
    			lpsIndex = i;
    			lpsLen = len;
    		}
    	}
    }
    
    return s.substring(lpsIndex, lpsLen);
    
    }
	
	
	// this function starts building the table from length 0 comparisons
	public String longestPalindrome(String s) {
		if (s == null || s.length() <= 1) return s;
		int n = s.length();
		int maxLen = 1;
		boolean[][] lps = new boolean[n][n];
		String longest = null;
		for (int len=0;len<=n;len++) {
			for (int i=0;i<n-len;i++) {
				int j = i + len;
				// lps[i+1][j-1] means characters between i and j (excl)'s palindrome match
				if (s.charAt(i) == s.charAt(j) && (j-i<=2 || lps[i+1][j-1])) {
					lps[i][j] = true;
					
					if (j-i+1 > maxLen) {
						maxLen = j-i+1;
						longest = s.substring(i, j+1);
					}
				}
			}
		}
		return longest;
	}
	
	public static void main(String[] args) {
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		System.out.println(lps.longestPalindrome("Fourscoreandsevenyearsagoourfaathersbroughtforthonthisconta"
				+ "inentanewnationconceivedinzLibertyanddedicatedtotheproposit"
				+ "ionthatallmenarecreatedequalNowweareengagedinagreahtcivilwa"
				+ "rtestingwhetherthatnaptionoranynartionsoconceivedandsodedic"
				+ "atedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWeh"
				+ "avecometodedicpateaportionofthatfieldasafinalrestingplacefo"
				+ "rthosewhoheregavetheirlivesthatthatnationmightliveItisaltog"
				+ "etherfangandproperthatweshoulddothisButinalargersensewecann"
				+ "otdedicatewecannotconsecratewecannothallowthisgroundThebrav"
				+ "elmenlivinganddeadwhostruggledherehaveconsecrateditfarabove"
				+ "ourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorl"
				+ "ongrememberwhatwesayherebutitcanneverforgetwhattheydidhereI"
				+ "tisforusthelivingrathertobededicatedheretotheulnfinishedwor"
				+ "kwhichtheywhofoughtherehavethusfarsonoblyadvancedItisrather"
				+ "forustobeherededicatedtothegreattdafskremainingbeforeusthat"
				+ "fromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwh"
				+ "ichtheygavethelastpfullmeasureofdevotionthatweherehighlyres"
				+ "olvethatthesedeadshallnothavediedinvainthatthisnationunsder"
				+ "Godshallhaveanewbirthoffreedomandthatgovernmentofthepeopleb"
				+ "ythepeopleforthepeopleshallnotperishfromtheearth"));
	}

}
