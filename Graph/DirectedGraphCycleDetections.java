package com.rohith.datastructures;
import java.util.*;

public class DirectedGraphCycleDetections {
	private  static int vertices;
	private  static List<List<Integer>> adj;
	DirectedGraphCycleDetections(int v) {
		vertices = v;
		adj = new ArrayList<>(v);
		for (int i=0; i<vertices; i++) {
			adj.add(new LinkedList<>());
		}
	}
	void addEdge(int source, int destination) {
		adj.get(source).add(destination);
	}
	static boolean isCycle() {
		boolean [] visited = new boolean[vertices];
		boolean [] recursionStack = new boolean[vertices];
		for (int i=0; i<vertices; i++) {
			if (isCycleHelper(i, visited, recursionStack))
				return true;
		}
		return false;
	}
	static boolean isCycleHelper(int v, boolean [] visited, boolean [] recursionStack) {
		if (recursionStack[v])
			return true;
		if (visited[v])
			return false;
		visited[v] = true;
		recursionStack[v] = true;
		List<Integer> children = adj.get(v);
		for (Integer child: children) {
			if (isCycleHelper(child, visited, recursionStack))
					return true;
		}
		recursionStack[v] = false;
		return false;
	}
	public static void main(String[] args) {
		DirectedGraphCycleDetections graph = new DirectedGraphCycleDetections(4); 
        graph.addEdge(0, 1); 
        graph.addEdge(0, 2); 
        graph.addEdge(1, 2); 
        graph.addEdge(2, 0); 
        graph.addEdge(2, 3); 
        graph.addEdge(3, 3); 
        if (isCycle())
        	System.out.println("Cycle detected");
        else
        	System.out.println("No Cycle detected");

	}

}
