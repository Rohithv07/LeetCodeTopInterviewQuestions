import java.util.*;

public class BridgesInGraph {


	// low[adjacent] > timeOfInsertion[node], then that is a bridge

	private static void printBridges(int n, ArrayList<ArrayList<Integer>> graph) {
		boolean [] visited = new boolean [n];
		int [] timeOfInsertion = new int [n];
		int [] lowestTime = new int [n];
		int timer = 0;
		for (int i=0; i<n; i++) {
			if (!visited[i]) {
				dfs(i, -1, visited, timeOfInsertion, lowestTime, graph, timer);
			}
		}
	}

	private static void dfs(int node, int parent, boolean [] visited, int [] timeOfInsertion, int [] lowestTime, ArrayList<ArrayList<Integer>> graph, int timer) {
		visited[node] = true;
		timeOfInsertion[node] = lowestTime[node] = timer++;
		ArrayList<Integer> children = graph.get(node);
		for (Integer child : children) {
			if (child == parent) {
				continue;
			}
			if (!visited[child]) {
				dfs(child, node, visited, timeOfInsertion, lowestTime, graph, timer);
				lowestTime[node] = Math.min(lowestTime[node], lowestTime[child]);
				if (lowestTime[child] > timeOfInsertion[node]) {
					// this a bridge
					System.out.println("Bridge found in : " + node + "->" + child);
				}
			}
			else {
				lowestTime[node] = Math.min(lowestTime[node], timeOfInsertion[child]);
			}
		}
	}

	public static void main(String [] args) {
		int n = 5;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i=0; i<n; i++) {
			graph.add(new ArrayList<>());
		}
		graph.get(0).add(1);
		graph.get(1).add(0);
		graph.get(0).add(2);
		graph.get(2).add(0);
		graph.get(1).add(2);
		graph.get(2).add(1);
		graph.get(1).add(3);
		graph.get(3).add(1);
		graph.get(3).add(4);
		graph.get(4).add(3);
		printBridges(n, graph);
	}
}