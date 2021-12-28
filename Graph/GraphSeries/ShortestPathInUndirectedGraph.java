
// https://youtu.be/hwCWi7-bRfI

import java.util.*;

class ShortestPathInUndirectedGraph {
	public static void main(String [] args) {
		int v = 8;
 
        // Adjacency list for storing which vertices are connected
        ArrayList<ArrayList<Integer>> adj =
                            new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }
 
        // Creating graph given in the above diagram.
        // add_edge function takes adjacency list, source
        // and destination vertex as argument and forms
        // an edge between them.
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 2);
        addEdge(adj, 3, 4);
        addEdge(adj, 3, 7);
        addEdge(adj, 4, 5);
        addEdge(adj, 4, 6);
        addEdge(adj, 4, 7);
        addEdge(adj, 5, 6);
        addEdge(adj, 6, 7);
        int source = 0;
        printShortestDistanceFromSource(adj, source, v);
    }
 
    // function to form edge between two vertices
    // source and dest
    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j)
    {
        adj.get(i).add(j);
        adj.get(j).add(i);
    }

    private static void printShortestDistanceFromSource(ArrayList<ArrayList<Integer>> adj, int source, int v) {
    	// create disrance array with maximum value
    	int [] distance = new int [v];
    	Arrays.fill(distance, Integer.MAX_VALUE);
    	Queue<Integer> queue = new LinkedList<>();
    	queue.offer(source);
    	distance[source] = 0;
    	while (!queue.isEmpty()) {
    		int size = queue.size();
    		for (int i=0; i<size; i++) {
    			int currentNode = queue.poll();
    			int currentDistanceFromSource = distance[currentNode];
    			ArrayList<Integer> children = adj.get(currentNode);
    			for (Integer child : children) {
    				if (distance[child] > currentDistanceFromSource + 1) {
    					distance[child] = currentDistanceFromSource + 1;
    					queue.offer(child);
    				}
    				else {
    					continue;
    				}
    			}
    		}
    	}
    	for (int dist : distance) {
    		System.out.print(dist + " ");
    	}
    }
}