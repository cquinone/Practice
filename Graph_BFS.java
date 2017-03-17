import java.util.LinkedList;

import java.util.Iterator; 

public class Graph_BFS {
	private int V; 
	private LinkedList[] adj;
	
	public Graph_BFS(int V) { 
		this.V = V; 
		adj = new LinkedList[V]; 
		for (int i = 0; i < V; i++) { 
			adj[i] = new LinkedList(); 
		}
	}
	
	void addEdge(int v, int w) {
		adj[v].add(w);		
	}

	void BFS(int s) { 
		boolean[] visited = new boolean[V];
		LinkedList Q = new LinkedList();
		Q.add(s);
		visited[s] = true;
		
		while (Q.size() != 0) { 
			int top = (int)Q.remove(0);
			System.out.println(top);
			Iterator i = adj[top].listIterator();
			while (i.hasNext()) {
				 int curr = (int)i.next();
				 if (visited[curr] == false) {
					  visited[curr] = true; 
					  Q.add(curr);
				 }
			}
		}
	}
 }
