package interviewprep;

public class WordSearch {
	public static void main(String args[]) {
		String [][] t0 =  { {"ABCE"},
						    {"SFCS"},
						    {"ADEE"}};
		System.out.println();
		//indexing error 
		         
		              
	}
	
	public static boolean wordSearch(String[][] matrix, String word){
		/*
		 * http://www.programcreek.com/2014/06/leetcode-word-search-java/
		 */
		boolean wordFound = false;
		int length = word.length();
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[][] visited = new boolean[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				wordFound = dfs(matrix,visited,word,i,j,length,1);
				if (wordFound)
					return true;
			}
		}
		return false;
	}
	
	public static boolean dfs(String[][] matrix,boolean[][] visited,
			String word, int row, int col, int length, int level) {
		if (level == length){
			if (word.charAt(level-1) == matrix[row][0].charAt(col))
				return true;
			else
				return false;
			
		} else { 
			if ((row < 0 || row > matrix.length -1) ||
					(col < 0 || col > matrix[0].length))
				return false;
			if (visited[row][col]) return false;
			
			visited[row][col] = true;
			if (word.charAt(level-1) != matrix[row][0].charAt(col)) return false;
			
			if (dfs(matrix,visited,word,row+1,col,length,level+1)) return true;
			if (dfs(matrix,visited,word,row-1,col,length,level+1)) return true;
			if (dfs(matrix,visited,word,row,col+1,length,level+1)) return true;
			if (dfs(matrix,visited,word,row,col-1,length,level+1)) return true;
		
			return false;
		}
		
	}

}
