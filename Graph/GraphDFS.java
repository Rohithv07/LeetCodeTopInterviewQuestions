package com.rohith.datastructures;
import java.util.*;
import java.io.*;

public class GraphDFS {
	private int vertices;
	private LinkedList<Integer> adj[];
	GraphDFS(int v) {
		vertices = v;
		adj = new LinkedList[v];
		for (int i=0; i<v; i++)
			adj[i] = new LinkedList<>();
	}
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
	void dfsHelper(int v, boolean [] visited) {
		visited[v] = true;
		System.out.print(v + " ");
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n])
				dfsHelper(n, visited);
		}
	}
	void dfs(int v) {
		boolean [] visited = new boolean[vertices];
		dfsHelper(v, visited);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphDFS g= new GraphDFS(4);
		g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3);
        g.dfs(2);
	}

}
