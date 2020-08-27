package com.rohith.datastructures;
import java.util.*;
public class MotherVertexFinder {
	private  int vertices;
	private  List<List<Integer>> adjacent;
	MotherVertexFinder(int v) {
		vertices = v;
		adjacent = new ArrayList<>(v);
		for (int i=0; i<v; i++)
			adjacent.add(new LinkedList<>());
		}
	void dfs(boolean [] visited, int v) {
		visited[v] = true;
		List<Integer> children = adjacent.get(v);
		for (Integer child: children) {
			if (!visited[child])
				dfs(visited, child);
		}
	}
	 void addEdge(int u, int v) {
		adjacent.get(u).add(v);
	}
	int motherVertexFinder() {
		boolean [] visited = new boolean[vertices];
		int v = 0;
		for (int i=0; i<vertices; i++) {
			if (visited[i] == false){
				dfs(visited, i);
				v = i;
			}
		}
		Arrays.fill(visited, false);
		dfs(visited, v);
		for (int i=0; i<vertices; i++) {
			if (visited[i] == false)
				return -1;
		}
		return v;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MotherVertexFinder g = new MotherVertexFinder(7); 
		g.addEdge(0, 1); 
	    g.addEdge(0, 2); 
	    g.addEdge(1, 3); 
	    g.addEdge(4, 1); 
	    g.addEdge(6, 4); 
	    g.addEdge(5, 6); 
	    g.addEdge(5, 2); 
	    g.addEdge(6, 0); 
	    System.out.println("The mother of the above graph is : " + g.motherVertexFinder());

	}

}
