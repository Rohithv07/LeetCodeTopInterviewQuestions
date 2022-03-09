import java.util.*;

public class DFS {
	public static void main(String [] args) {
		int n = 8;
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		graph.get(0).add(1);
		graph.get(0).add(3);
		graph.get(1).add(0);
		graph.get(1).add(2);
		graph.get(2).add(1);
		graph.get(2).add(4);
		graph.get(4).add(2);
		graph.get(4).add(3);
		graph.get(3).add(0);
		graph.get(3).add(4);
		graph.get(5).add(6);
		graph.get(5).add(7);
		graph.get(6).add(5);
		graph.get(6).add(7);
		graph.get(7).add(5);
		graph.get(7).add(7);
		System.out.println(dfsTraversal(graph, n));
	}

	public static List<Integer> dfsTraversal(List<List<Integer>> graph, int n) {
		List<Integer> result = new ArrayList<>();
		boolean [] visited = new boolean [n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(graph, visited, i, result);
			}
		}
		return result;
	}

	public static void dfs(List<List<Integer>> graph, boolean [] visited, int node, List<Integer> result) {
		visited[node] = true;
		result.add(node);
		List<Integer> children = graph.get(node);
		for (Integer child : children) {
			if (!visited[child]) {
				dfs(graph, visited, child, result);
			}
		}
	}
}