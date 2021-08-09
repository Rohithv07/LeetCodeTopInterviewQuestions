/*
Case 1:- Undirected Connected Graph : In this case, all the vertices are mother vertices as we can reach to all the other nodes in the graph.
Case 2:- Undirected/Directed Disconnected Graph : In this case, there is no mother vertices as we cannot reach to all the other nodes in the graph.
Case 3:- Directed Connected Graph : In this case, we have to find a vertex -v in the graph such that we can reach to all the other nodes in the graph through a directed path.
*/

// kosaraju
import java.util.*;

public class MotherVertex {

	public static int findMotherVertex(int [][] edges, int e, int n) {
		if (edges == null || edges.length == 0)
			return 0;
		List<List<Integer>> graph = buildGraph(edges, n);
		boolean [] visited = new boolean [n];
		int lastVisitedIndex = -1; // this will hold the mother vertex
		for (int i=0; i<n; i++) {
			if (!visited[i]) {
				dfs(graph, visited, i);
				lastVisitedIndex = i;
			}
		}
		// reset all values in visited to false and again do a dfs search from lastVisitedIndex
		// if there is any false then return -1 as there wont be any mother vertex
		Arrays.fill(visited, false);
		dfs(graph, visited, lastVisitedIndex);
		for (boolean value : visited) {
			if (!value) {
				return -1;
			}
		}
		return lastVisitedIndex;
	}

	public static void dfs(List<List<Integer>> graph, boolean [] visited, int node) {
		if (visited[node])
			return;
		visited[node] = true;
		if (graph.get(node) == null)
			return;
		List<Integer> children = graph.get(node);
		for (int child : children) {
			if (!visited[child]) {
				dfs(graph, visited, child);
			}
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
		int v = sc.nextInt();
		int e = sc.nextInt();
		int [][] edges = new int [e][2];
		for (int i=0; i<e; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
		}
		System.out.println(findMotherVertex(edges, e, v));
	}
}