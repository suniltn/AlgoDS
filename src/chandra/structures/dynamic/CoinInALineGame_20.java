package com.chandra.structures.dynamic;


/*
 *  N pots, each with some number of gold coins, are arranged   in a line. 
 *  You are playing a game against another player. You take turns picking a pot of gold. 
 *  You may pick a pot from either end of the line, remove the pot, and keep the gold pieces. 
 *  The player with the most gold at the end wins. Develop a strategy for playing this game.
 *  
 *   
 *   Good Explaination : http://algorithms.tutorialhorizon.com/dynamic-programming-coin-in-a-line-game-problem/
 */

/**
if Alice picks the ith coin, Ci then Bob will be left with 2 choices Ci+1 and Cj, since Bob is equally clever than Bob will pick the coin which will leave the Alice with min­i­mum value coins.
So if Bob picks i+1th coin then it will again Alice turn and prob­lem will be reduced to Alice has to pick a coin from i+2th to jth coin and sim­i­larly if   if Bob picks jth coin then it will again Alice turn and prob­lem will be reduced to Alice has to pick a coin from i+1th to j-1th coin.
So Alice col­lec­tion will be = Vi + Min{MV(i+2,j), MV(i+1, j-1)}

if Alice picks the jth coin, Cj then Bob will be left with 2 choices Ci and Cj-1, since Bob is equally clever than Bob will pick the coin which will leave the Alice with min­i­mum value coins.
So if Bob picks ith coin then it will again Alice turn and prob­lem will be reduced to Alice has to pick a coin from i+1th to j-1th coin and sim­i­larly if Bob picks j-1th coin then it will again Alice turn and prob­lem will be reduced to Alice has to pick a coin from ith to j-2th coin.
So Alice col­lec­tion will be = Vi + Min{MV(i+1,j-1), MV(i, j-2)}

So now we need to decide whether Alice should pick ith coin or jth coin. Alice will pick the coin which ever gives the more value con­sid­er­ing 2 moves ahead
so MV(i, j) = Max { Vi + Min{MV(i+2,j), MV(i+1, j-1)} , Vi + Min{MV(i+1,j-1), MV(i, j-2)}}


http://algorithms.tutorialhorizon.com/dynamic-programming-coin-in-a-line-game-problem/

http://articles.leetcode.com/coins-in-line/
*/

public class CoinInALineGame_20 {
	public static int solve(int[] A) {
		int[][] MV = new int[A.length][A.length];
		
		for (int interval=0;interval<A.length;interval++) {
			for (int i=0,j=interval;j<A.length;++i,++j) {
				int a, b, c;
				// Matrix is filled diagonally and last cell in the first row is our targeted cell
				
				// the reason why we check i+1 <= j to make we have at the very least 3 elements in an array
				// checking for 3 elements can be done in 3 ways with index i=0 and index j=2
				// i+2 <= j -> 0+2<=2
				// i+1 <= j-1 -> 0+1 <= 2-1
				// i <= j-2 -> 0 <= 2-2
				
				// a = MV(i+2,j) - Alice chooses i Bob chooses i+1
				// b = MV(i+1,j-1)- Alice chooses i , Bob chooses j OR
				// Alice chooses j , Bob chooses i
				// c = MV(i,j-2)- Alice chooses j , Bob chooses j-1
				a = ((i+2 <= j) ? MV[i+2][j] : 0);
				b = ((i+1 <= j-1 && j-1 >= 0) ? MV[i+1][j-1] : 0);
				c = ((i <= j-2) ? MV[i][j-2] : 0); // or  c = ((j-2 >= 0) ? MV[i][j-2] : 0);
				
				MV[i][j] = Math.max(A[i] + Math.min(a, b), A[j]+Math.min(b, c));
			}
		}
		
		return MV[0][A.length-1];
	}

	public static void main(String[] args) {
		int[] B = { 6, 9,1,2,16,8};
		System.out.println("Max value pick up by player1(Alice) " + solve(B));
	}
}
