package com.rohith.datastructures;
import java.util.*;

public class TwoNodesOnSamePath {
	static int max = Integer.MAX_VALUE;
	static boolean visited[] = new boolean[max];
	static int [] intime = new int[max];
	static int [] outtime = new int[max];
	static int timer = 0;
	static void dfsHelper(LinkedList<Integer> graph[], int node) {
		visited[node] = true;
		timer += 1;
		intime[node] = timer;
		Iterator<Integer> i = graph[node].listIterator();
		while (i.hasNext()) {
			int child = i.next();
			if (!visited[child])
				dfsHelper(graph, child);
		}
		timer += 1;
		outtime[node] = timer;
	}
	static boolean isSamePath(int node1, int node2) {
		if ((intime[node1] < intime[node2] && outtime[node2] > outtime[node1]) ||
				(intime[node2] < intime[node1] && outtime[node1] > outtime[node2]))
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		int n = 9;
		LinkedList<Integer> graph[] = new LinkedList[n+1];
		graph[1].add(2); 
	    graph[1].add(3); 
	    graph[3].add(6); 
	    graph[2].add(4); 
	    graph[2].add(5); 
	    graph[5].add(7); 
	    graph[5].add(8); 
	    graph[5].add(9); 
	    dfsHelper(graph, 1);
	    if (isSamePath(1, 5)) 
	    	System.out.println("Yes");
	    else
	    	System.out.println("No");
	    

	}

}
