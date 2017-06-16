package interviewprep;

public class MinCoins {
	
	public static void main(String args[]) { 
		int S = 11;
		int[] coins = {1,3,5};
		System.out.println(minCoins(S,coins));
	}
	
	public static int minCoins(int S, int[] coins) { 
		/* 
		 * TopCoder: Intro to DP 
		 */
		int[] minarr = new int[S+1];
		minarr[0] = 0; 
		for (int i = 1; i <= S; i++) 
			minarr[i] = (int)Integer.MAX_VALUE;
		
		for (int i = 1; i <= S; i++) {
			 for (int j = 0; j < coins.length; j++) { 
				 if (coins[j] <= i && 1+minarr[i-coins[j]] < minarr[i])
					 minarr[i] = 1+minarr[i-coins[j]];
			 }
		}
		return minarr[S];
	}
}
