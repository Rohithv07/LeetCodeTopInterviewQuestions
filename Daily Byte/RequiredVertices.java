/*
You are given an integer N, that represents N vertices (labeled zero to N - 1) that exist within an acyclic graph. You are also given a list of edges where edges[i] contains two values: the source node and the node that it connects to (i.e. to and from values). Return the smallest list of required vertices such that you can reach every vertex in the graph.
Note: You may assume only a single solution exists.

Ex: Given the following N and edges…

N = 3, edges = [[0, 1], [1, 2]], return [0] (you only need to be able to access vertex zero to reach every other node in the graph).
Ex: Given the following N and edges…

N = 4, edges = [[3, 1], [1, 2], [0, 2]], return [0, 3].
*/

import java.util.*;

public class RequiredVertices {

	public static List<Integer> findVertices(int n, int [][] edges) {
		if (edges == null || edges.length == 0) {
			return new ArrayList<>();
		}
		List<List<Integer>> graph = buildGraph(edges, n);
		List<Integer> result = new ArrayList<>();
		boolean [] visited = new boolean [n];
		dfs(visited, graph, edges[0][0]);
		visited[edges[0][0]] = false;
		for (int i=0; i<n; i++) {
			if (!visited[i])
				result.add(i);
		}
		return result;
	}

	public static void dfs(boolean [] visited, List<List<Integer>> graph, int currentVertex) {
		if (visited[currentVertex]) {
			return;
		}
		if (graph.get(currentVertex) == null) {
			return;
		}
		visited[currentVertex] = true;
		List<Integer> children = graph.get(currentVertex);
		for (Integer child : children) {
			if (!visited[child])
				dfs(visited, graph, child);
		}
	}

	public static List<List<Integer>> buildGraph(int [][] edges, int n) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i=0; i<n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int [] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
		}
		return graph;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] edges = new int [n - 1][2];
		for (int i=0; i<n-1; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
		}
		System.out.println(findVertices(n, edges));
	}
}