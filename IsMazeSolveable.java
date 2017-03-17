package interviewprep;

public class IsMazeSolveable {
	
	public static void main(String args[]) { 
		String[][] eg = {{"S","*","*"}, 
						 {" ","*","*"},
						 {" ", " ", "E"}};
		
		String[][] eg1 = {{"S","*","*"}, 
				 		  {"*","*","*"},
				 	      {" ", " ", "E"}};
		
		System.out.println(isMazeSolveable(eg)); //true 
		System.out.println(isMazeSolveable(eg1)); // false
		
	}

	public static boolean isMazeSolveable(String[][] maze) {
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		int sRow = -1; 
		int sCol = -1;
		
		outerloop: 
		for (int row = 0; row < maze.length; row++) {
			 for (int col = 0; col < maze[0].length; col++) { 
				 if (maze[row][col] == "S"){ 
					 sRow = row; 
					 sCol = col;
					 break outerloop;
				 }		 
			 }
		}
		
		if (sRow == -1) return false; 
		return solveMaze(maze,visited,sRow,sCol);
	}
	
	public static boolean solveMaze(String[][] maze, boolean[][] visited, int row, int col) { 
		if ((row < 0 || row > maze.length-1) || (col < 0 || col > maze[0].length -1))
			return false;
		if (visited[row][col] == true)
			return false;
	
		visited[row][col] = true;
		if (maze[row][col] == "*") 
			return false;
		if (maze[row][col] == "E")
			return true; 
		
		if (solveMaze(maze,visited,row+1,col)) return true; 
		if (solveMaze(maze,visited,row-1,col)) return true; 
		if (solveMaze(maze,visited,row,col-1)) return true; 
		if (solveMaze(maze,visited,row,col+1)) return true; 
		
		return false; 
	}
}
