package interviewprep;

public class EquillibriumPoint { 
	public static void main(String args[]) { 
		int[] test = {-1,3,-4,5,1,-6,2,1};

		System.out.println(solve(test,test.length));
	}
	
	public static int solve(int[] A, int N) { 
		if (N==2) { 
			if (A[0] == A[1] && A[0] == 0)
				return 0; 
			else
				return -1;
		}
		
		int[] sums = new int[N];
		sums[0] = A[0];
		for (int i = 1; i < N; i++) 
			sums[i] = sums[i-1] + A[i];
		

		//Edge Case
		if (sums[N-1]-sums[0] == 0)
			return 0;
		
		//General Case
		for (int j = 1; j < sums.length-1; j++) { 
			if (sums[N-1]-sums[j] == sums[j-1])
				return j;
		}
		//Edge Case
		if (sums[N-2] == 0) 
			return N-1;
		
		return -1;
		
	}
}


