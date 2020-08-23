package com.rohith.datastructures;
import java.util.*;

public class GraphTopologicalSort {
	private int vertices;
	private LinkedList<Integer> adj[];
	GraphTopologicalSort(int v) {
		vertices = v;
		adj= new LinkedList[v];
		for (int i=0; i<v; i++) {
			adj[i] = new LinkedList();
		}
	}
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
	void topologicalSort() {
		Stack<Integer> stack = new Stack<>();
		boolean [] visited = new boolean[vertices];
		for (int i=0; i<vertices; i++) {
			if (visited[i] == false)
				topologicalSortHelper(i, visited, stack);
		}
		while (stack.empty() == false) {
			System.out.print(stack.pop() + " ");
		}
	}
	void topologicalSortHelper(int v, boolean [] visited, Stack<Integer> stack) {
		visited[v] = true;
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()){
			int n = i.next();
			if (!visited[n]){
				topologicalSortHelper(n, visited, stack);
			}
		}
		stack.push(new Integer(v));
	}
	public static void main(String[] args) {
		GraphTopologicalSort g = new GraphTopologicalSort(6);
		g.addEdge(5, 2);  
        g.addEdge(5, 0);  
        g.addEdge(4, 0);  
        g.addEdge(4, 1);  
        g.addEdge(2, 3);  
        g.addEdge(3, 1);  
        g.topologicalSort();

	}

}
