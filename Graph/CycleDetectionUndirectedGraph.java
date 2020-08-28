package com.rohith.datastructures;
import java.util.*;
public class CycleDetectionUndirectedGraph {
	private int vertices;
	private List<List<Integer>> adjacent;
	CycleDetectionUndirectedGraph(int v) {
		vertices = v;
		adjacent = new ArrayList<>(vertices);
		for (int i=0; i<vertices; i++)
			adjacent.add(new LinkedList<>());
	}
	void addEdge(int u, int v) {
		adjacent.get(u).add(v);
	}
	Boolean isCycle(int v, Boolean visited[], int parent) {
		visited[v] = true;
		List<Integer> children = adjacent.get(v);
		for (Integer child: children) {
			if (!visited[child]) {
				if (isCycle(child, visited, v))
					return true;
			}
			else if (child != parent)
				return true;
		}
		return false;
	}
	Boolean cycleDetector() {
		Boolean [] visited = new Boolean[vertices];
		for (int i=0; i<vertices; i++)
			visited[i] = false;
		for (int i=0; i<vertices; i++) {
			if (!visited[i]) 
				if (isCycle(i, visited, -1))
					return true;
		}
		return false;
	}
	public static void main(String[] args) {
		CycleDetectionUndirectedGraph g1 = new CycleDetectionUndirectedGraph(5);
		g1.addEdge(1, 0); 
        g1.addEdge(0, 2); 
        g1.addEdge(2, 1); 
        g1.addEdge(0, 3); 
        g1.addEdge(3, 4); 
        if (g1.cycleDetector())
        	System.out.println("Yes there is a cycle");
        else
        	System.out.println("No there is no cylce");
	}

}
