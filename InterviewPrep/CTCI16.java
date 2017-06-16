package interviewprep;

public class CTCI16 {
	public static void main(String args[]) {	
		//Passed some test cases
	}
	
	public static int[][] CTCI16(int[][] matrix) {
		/*
		 * Given an image represented by a NxN matrix, where each 
		 * pixel in the image is 4 bytes, write a method to rotate 
		 * the image by 90 degree.  Can you do this in place?
		 */
		int N = matrix.length;
		int [][]rotated = new int[N][N];
		int counter = 0;
		for (int oldRow=0; oldRow<rotated.length; oldRow++) {
			for (int oldCol=0; oldCol<rotated[0].length; oldCol++) {
				int newRow = (N-1) - oldCol;
				int newCol = oldRow;
				rotated[newRow][newCol] = matrix[oldRow][oldCol];
			}
		}
		return rotated;
	}
}
