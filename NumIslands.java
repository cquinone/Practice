package interviewprep;

public class NumIslands {

	public static void main(String[] args) {
		int[][] matrix = {{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
		System.out.println(numIslands(matrix));

	}
	
	public static int numIslands(int[][] matrix){
		int islands = 0;
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		
		for (int r=0; r<matrix.length; r++) {
			for (int c=0; c<matrix[0].length; c++) {
				if (matrix[r][c] == 1 && visited[r][c] == false) {
					islands++;
					visited = dfs(matrix,visited,r,c);
				}
			}
			return islands;
		}
		return 0;
	}
	
	public static boolean[][] dfs(int[][] matrix, boolean[][] visited,int r,int c){
		visited[r][c] = true;
		int rp = r+1;
		int rm = r-1;
		int cp = c+1;
		int cm = c-1;
		
		if (0<=rp && rp<=matrix.length-1) {
			if (matrix[rp][c]==1 && visited[rp][c]==false)
				dfs(matrix,visited,rp,c);
		}
		
		if (0 <= cp && cp <= matrix[0].length-1) {
			if (matrix[r][cp]==1 && visited[r][cp]==false)
				dfs(matrix,visited,r,cp);
		}
		
		if (0<=rm && rm<=matrix.length-1) {
			if (matrix[rm][c]==1 && visited[rm][c]==false)
				dfs(matrix,visited,rm,c);
		}
		
		if (0<=cm && cm<=matrix[0].length-1) {
			if (matrix[r][cm]==1 && visited[r][cm]==false)
				dfs(matrix,visited,r,cm);
		}
		return visited;
	}

}
