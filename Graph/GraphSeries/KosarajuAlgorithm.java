import java.util.*;

// https://youtu.be/V8qIqJxCioo

/**
 * The steps for this algorithm is :
 * 1. Sort all nodes based on the finishing time, this is just topological sorting
 * 2. Transpose the graph, which means just change the direction of the given graph
 * 3. Do the dfs based on the finishing time ie topo ordering on the transposed graph
 */
public class KosarajuAlgorithm {

	public static void printStronglyConnectedComponent(int n, ArrayList<ArrayList<Integer>> adj) {
		boolean [] visited = new boolean[n];
		Stack<Integer> trackOrder = new Stack<>();
		// find topo sort
		for (int i=0; i<n; i++) {
			if (!visited[i]) {
				dfs(i, adj, visited, trackOrder);
			}
		}
		// find transpose
		ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
		for (int i=0; i<n; i++) {
			transpose.add(new ArrayList<>());
		}
		visited = new boolean[n];
		for (int i=0; i<n; i++) {
			ArrayList<Integer> children = adj.get(i);
			for (Integer child : children) {
				transpose.get(child).add(i);
			}
		}
		// do the dfs on the basis of topo sort on tranpose graph
		while (!trackOrder.isEmpty()) {
			int node = trackOrder.pop();
			if (!visited[node]) {
				System.out.print("Strongly Connected components are : ");
				reverseDfs(node, transpose, visited);
				System.out.println();
			}
		}
	}

	public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean [] visited, Stack<Integer> trackOrder) {
		visited[node] = true;
		ArrayList<Integer> children = adj.get(node);
		for (Integer child : children) {
			if (!visited[child]) {
				dfs(child, adj, visited, trackOrder);
			}
		}
		trackOrder.push(node);
	}

	public static void reverseDfs(int node, ArrayList<ArrayList<Integer>> transpose, boolean [] visited) {
		visited[node] = true;
		System.out.print(node + " ");
		ArrayList<Integer> children = transpose.get(node);
		for (Integer child : children) {
			if (!visited[child]) {
				reverseDfs(child, transpose, visited);
			}
		}
	}


	public static void main(String [] args) {
		int n = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<Integer>());
		adj.get(0).add(1);
		adj.get(1).add(2);
		adj.get(2).add(0);
		adj.get(1).add(3);
		adj.get(3).add(4);
		printStronglyConnectedComponent(n, adj);

	}
}