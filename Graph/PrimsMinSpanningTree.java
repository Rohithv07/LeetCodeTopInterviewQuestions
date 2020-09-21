package com.rohith.datastructures;

import java.util.*;
import java.io.*;

public class PrimsMinSpanningTree {
	private static final int vertices = 5;
	public static int minKeyIndex(int [] key, Boolean [] mstSet) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int i=0; i<vertices; i++) {
			if (mstSet[i] == false && key[i] < min) {
				min = key[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	public static void printMst(int [] parent, int [][] graph) {
		for (int i=1; i<vertices; i++) {
			System.out.println(parent[i] + "-" + i + "\t" + graph[i][parent[i]]);
		}
	}
	public void primMst(int [][] graph) {
		int [] key = new int [vertices];
		int [] parent = new int [vertices];
		Boolean [] mstSet = new Boolean [vertices];
		for (int i=0; i<vertices; i++) {
			mstSet[i] = false;
			key[i] = Integer.MAX_VALUE;
		}
		key[0] = 0; // consider the first element;
		parent[0] = -1;// considered as the root;
		for (int i=0; i<vertices-1; i++) {
			int minIndex = minKeyIndex(key, mstSet);
			mstSet[minIndex] = true;
			for (int j=0; j<vertices; j++) {
				if (graph[minIndex][j] != 0 && mstSet[j] == false && graph[minIndex][j] < key[j]) {
					parent[j] = minIndex;
					key[j] = graph[minIndex][j];
				}
			}
		}
		printMst(parent, graph);
	}
	
	public static void main(String[] args) {
		PrimsMinSpanningTree t = new PrimsMinSpanningTree();
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
                                      { 2, 0, 3, 8, 5 },
                                      { 0, 3, 0, 0, 7 },
                                      { 6, 8, 0, 0, 9 },
                                      { 0, 5, 7, 9, 0 } };
 
        // Print the solution
        t.primMst(graph);

	}

}
