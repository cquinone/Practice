package interviewprep;

public class CTCI17 {
	public static void main(String args[]) {
		
	}
	
	public static int[][] CTCI17(int[][] matrix) {
		/* 
		 * Write an algorithm that such that if an element in an MxN
		 * matrix is 0, its entire row and column are set to 0.
		 */
		int nrows = matrix.length;
		int ncols = matrix[0].length;
		int[][] result = copy(matrix);
		for (int r=0; r<nrows; r++) {
			for (int c=0; c<ncols; c++) {
				if (matrix[r][c]==0) {
					for (int cs=0; cs<ncols; cs++)
						result[r][cs]=0;
					for (int rs=0; rs<nrows; rs++)
						result[rs][c]=0;
				}
			}
		}	
		return result;
	}
	
	public static int[][] copy(int[][] matrix) {
		int nrows = matrix.length;
		int ncols = matrix[0].length;
		int[][] copy = new int[nrows][ncols];
		for (int r=0; r<nrows; r++) {
			for (int c=0; c<ncols; c++)
				copy[r][c] = matrix[r][c];
		}
		return copy;
	}
}
