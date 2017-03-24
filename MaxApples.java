package interviewprep;

public class MaxApples {
	
	public static void main(String args[]) {
		 int[][] m0 = {{1,1,1,1,1}, 
				 	   {1,1,1,1,1},
				 	   {1,0,1,1,0}};
		 System.out.println(solve(m0));
	}

	public static int solve(int[][] matrix) {
		int rows = matrix.length; 
		int cols = matrix[0].length;
		int[][] S = new int[rows][cols];
		for (int i = 0; i < rows; i++) { 
			for (int j = 0; j < cols; j++) { 
				if (i == 0 && j == 0) 
					S[i][j] = matrix[i][j];
				else if (i == 0)
					S[i][j] = matrix[i][j] + S[i][j-1]; 
				else if (j == 0) 
					S[i][j] = matrix[i][j] + S[i-1][j];
				else 
					S[i][j] = matrix[i][j] + Math.max(S[i-1][j],S[i][j-1]);
			}
		}
		return S[rows-1][cols-1];
	}
}
