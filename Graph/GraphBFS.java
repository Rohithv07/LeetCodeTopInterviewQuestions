package com.rohith.datastructures;
import java.util.*;
import java.io.*;

public class GraphBFS {
	private int vertices;
	private LinkedList<Integer> adj[];
	GraphBFS(int v) {
		vertices = v;
		adj = new LinkedList[v];
		for (int i=0; i<v; i++) {
			adj[i] = new LinkedList();
		}
	}
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
	void BFS(int v) {
		boolean [] visited = new boolean[vertices];
		Queue<Integer> queue = new LinkedList<>();
		visited[v] = true;
		queue.add(v);
		while (!queue.isEmpty()) {
			v = queue.poll();
			System.out.print(v + " ");
			Iterator<Integer> i = adj[v].listIterator();
			while (i.hasNext()){
				int n = i.next();
				if (!visited[n]){
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
	public static void main(String [] args) {
		GraphBFS g= new GraphBFS(4);
		g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3);
        g.BFS(2);
	}
	
}
