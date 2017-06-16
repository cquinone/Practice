package interviewprep;

public class LongestNonDecSequence {
	
	public static void main(String args[]) {
		 
	}
	
	public static int longestNonDecSequence(int[] arr) {
		int[] S = new int[arr.length];
		int max = 0; 
		for (int i = 0; i < arr.length; i++) 
			S[i] = 1;
		
		for (int i = 0; i < arr.length; i++) { 
			for (int j = 0; j < i; j++) { 
				if (arr[j] <= arr[i] && S[i] < S[j]+1)
					S[i] = S[j]+1; 
			}
		}
		
		for (int i = 0; i < S.length; i++) 
			 if (max < arr[i]) max = arr[i];
	
		return max;
	}	
}
