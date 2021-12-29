import java.util.*;

public class ShortestPathInDAG {
	public static void main(String [] args) {
		int n = 6;
		ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
		for (int i=0; i<n; i++) {
			graph.add(new ArrayList<>());
		}
		graph.get(0).add(new Pair(1, 2));
		graph.get(0).add(new Pair(4, 1));
		graph.get(1).add(new Pair(2, 3));
		graph.get(2).add(new Pair(3, 6));
		graph.get(4).add(new Pair(2, 2));
		graph.get(4).add(new Pair(5, 4));
		graph.get(5).add(new Pair(3, 1));
		findTheShortestPathInDAG(n, graph);
	}

	private static void findTheShortestPathInDAG(int n, ArrayList<ArrayList<Pair>> graph) {
		// so here the idea is the first step is we will find the topological ordering
		// store all the ordering inside the stack
		// after that just take out each element from the stack, make sure the distance is not infinity
		// if we are good, just consider all the adjacent node and consider the minimum distance
		// store these distances inside the distance array.

		// find the topological ordering
		Stack<Integer> topologicalOrder = new Stack<>();
		findTheTopologicalOrder(n, graph, topologicalOrder);

		// after getting the order, take out each element
		int [] distance = new int [n];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[0] = 0; // considering the source as 0
		while (!topologicalOrder.isEmpty()) {
			int currentNode = topologicalOrder.pop();
			//System.out.println(currentNode);
			if (distance[currentNode] != Integer.MAX_VALUE) {
				ArrayList<Pair> children = graph.get(currentNode);
				for (Pair child : children) {
					int node = child.vertex;
					int weight = child.weight;
					if (distance[currentNode] + weight < distance[node]) {
						distance[node] = distance[currentNode] + weight;
					}
				}
			}
		}
		for (int dist : distance) {
			System.out.print(dist + " ");
		}
	}

	private static void findTheTopologicalOrder(int n, ArrayList<ArrayList<Pair>> graph, Stack<Integer> order) {
		boolean [] visited = new boolean [n];
		for (int i=0; i<n; i++) {
			if (!visited[i]) {
				dfs(order, visited, graph, i);
			}
		}
	}

	private static void dfs(Stack<Integer> stack, boolean [] visited, ArrayList<ArrayList<Pair>> graph, int node) {
		visited[node] = true;
		ArrayList<Pair> children = graph.get(node);
		for (Pair child : children) {
			if (!visited[child.vertex]) {
				dfs(stack, visited, graph, child.vertex);
			}
		}
		stack.push(node);
	}
}

class Pair {
	int vertex;
	int weight;
	public Pair(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
}