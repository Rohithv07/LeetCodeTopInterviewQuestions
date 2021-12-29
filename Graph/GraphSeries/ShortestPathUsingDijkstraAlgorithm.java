import java.util.*;


// https://youtu.be/jbhuqIASjoM

public class ShortestPathUsingDijkstraAlgorithm {
	public static void main(String [] args) {
		int n = 5;
		ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
		for (int i=0; i<n; i++) {
			graph.add(new ArrayList<>());
		}
		graph.get(0).add(new Pair(1, 2));
		graph.get(0).add(new Pair(3, 1));
		graph.get(1).add(new Pair(0, 2));
		graph.get(1).add(new Pair(2, 4));
		graph.get(1).add(new Pair(4, 5));
		graph.get(2).add(new Pair(1, 4));
		graph.get(2).add(new Pair(4, 1));
		graph.get(2).add(new Pair(3, 3));
		graph.get(3).add(new Pair(0, 1));
		graph.get(3).add(new Pair(2, 3));
		graph.get(4).add(new Pair(1, 5));
		graph.get(4).add(new Pair(2, 1));
		// so here same way we will be maintaining a distance array to track
		// down the shortest distance from the source
		// but instead of using a queue, we will go forward with priorityqueue,(minHeap)
		// which will be sorted based on distance
		// we start by adding the source with a distance of 0 as a pair inside the minHeap
		// then until the heap becomes empty, we take out every top element
		// then just checks whether we can reach a particular node which are adjacent
		// with a better distance path
		// if yes we update our distance array and add those nodes along with the distance as pair into the minHeap
		// we continue this until the heap becomes empty and we will be left out with our answer
		// in distance array .
		// here we consider the source as the very first node 0
		findTheShortestPathFromSource(graph, n, 0);
	}

	public static void findTheShortestPathFromSource(ArrayList<ArrayList<Pair>> graph, int n, int source) {
		int [] distance = new int [n];
		Arrays.fill(distance, Integer.MAX_VALUE);
		PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.weight, p2.weight));
		distance[source] = 0;
		minHeap.offer(new Pair(source, 0));
		while (!minHeap.isEmpty()) {
			Pair currentPair = minHeap.poll();
			int currentNode = currentPair.node;
			int currentWeight = currentPair.weight;
			ArrayList<Pair> children = graph.get(currentNode);
			for (Pair child : children) {
				if (distance[currentNode] + child.weight < distance[child.node]) {
					distance[child.node] = distance[currentNode] + child.weight;
					minHeap.offer(new Pair(child.node, distance[child.node]));
				}
			}
		}
		for (int dist : distance) {
			System.out.print(dist + " ");
		}
	}
}

class Pair {
	int node;
	int weight;
	public Pair(int node, int weight) {
		this.node = node;
		this.weight = weight;
	}
}