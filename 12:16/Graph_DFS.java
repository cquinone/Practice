import java.util.Iterator; 
import java.util.LinkedList;

public class Graph_DFS {
	private int V; 
	private LinkedList[] adj;
	
	public Graph_DFS(int V) {
		this.V = V; 
		adj = new LinkedList[V];
		for (int i = 0; i < V; i++)  
			adj[i] = new LinkedList(); 
	}
	
	void addEdge(int v, int w) {
		 adj[v].add(w);	
	}
	
	void DFS(int start) { 
		boolean[] visited = new boolean[V]; 
		DFShelper(start, visited);
	}
	
	void DFShelper(int node, boolean[] visited) { 
		System.out.println(node);
		visited[node] = true; 
		
		Iterator i = adj[node].listIterator();
		while (i.hasNext()) {
			 int curr = (int)i.next();
			 if (visited[curr] == false) { 
				 visited[curr] = true; 
				 DFShelper(curr, visited);
			 }
		}
	}

}
