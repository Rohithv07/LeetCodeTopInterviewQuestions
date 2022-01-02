import java.util.*;

// https://youtu.be/75yC1vbS8S8


/**
 * So bellman ford algorithm can be used to find the shortest path in a graph
 * that involves negative weight. It is also useful in finding negative cycles in graph
 * SO the first step in Bellman Form algorithm is to do relaxation n - 1 number of times
 * by updating the distance array which is initialised as infinity except the very first node as 0.
 * Then we will be doing the relaxation step n - 1 number of times.
 * In relaxation step, we will be checking dist[u] + wt < dist[v] and if it satisfies, then dist[v] is updated with
 * dist[u] + wt.
 * This is continued n - 1 number of times and at last whatever values inside the distance array will be the shortest path.
 * The time complexity is O(n * e) and space is O(n) where n = number of nodes
 * Now inorder to detect negative cycles, we will once again try to do relaxation step after n - 1 times and if the values inside the
 * distance array changes further, it means there is a negative cycle in the graph and becuase of that the distance array gets updated again.
 * 
 * Now why we need to do n - 1 number of times.
 * This is because, if we have a graph a->b->c, here the longest distance is n - 1 = 3 -1 = 2
 * So when we do the reflectionstep, at first b->c, but they are infinity and we will not update distance array
 * nexr is a->b, this time we update distance array as we are initializing dist[a] = 0 at first
 * Now for the next relaxation we will again check for b -> c, this time we will be able to update as we got a value other
 * than infiinity in the distance array dist[b]
 * 
 * So this is why we need n - 1 number of relaxation steps
 * if dist[u] + wt < dist[v]:
 * 			dist[v] = dist[u] + wt
 */ 

public class BellmanFordAlgorithm {

	// shortest distance to allother nodes from 0
	public static void printBellmanFordDistanceArray(int n, ArrayList<Node> adj) {
		int [] distance = new int [n];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[0] = 0;
		for (int i=1; i<=n-1; i++) {
			// n - 1 number of relaxation steps
			for (Node node : adj) {
				int src = node.source;
				int dest = node.destination;
				int weight = node.weight;
				if (distance[src] != Integer.MAX_VALUE && distance[src] + weight < distance[dest]) {
					distance[dest] = distance[src] + weight;
				}
			}
		}
		// to detect the negative, we can do once more the relaxation step and see whether the distance array gets updated
		System.out.println("Is there cycle :" + isThereNegativeCycle(distance, n, adj));
		if (!isThereNegativeCycle(distance, n, adj))
			for (int dist : distance) {
				System.out.print(dist + " ");
			}
	}

	public static boolean isThereNegativeCycle(int [] distance, int n, ArrayList<Node> adj) {
		for (Node node : adj) {
			int src = node.source;
			int dest = node.destination;
			int weight = node.weight;
			if (distance[src] != Integer.MAX_VALUE && distance[src] + weight < distance[dest]) {
				return true;
			}
		}
		return false;
	}


	public static void main(String [] args) {
		int n = 6;
        ArrayList<Node> adj = new ArrayList<>();
		
			
		adj.add(new Node(3, 2, 6));
		adj.add(new Node(5, 3, 1));
		adj.add(new Node(0, 1, 5));
		adj.add(new Node(1, 5, -3));
		adj.add(new Node(1, 2, -2));
		adj.add(new Node(3, 4, -2));
		adj.add(new Node(2, 4, 3));

		printBellmanFordDistanceArray(n, adj);
	}
}

class Node {
	int source;
	int destination;
	int weight;
	public Node(int source, int destination, int weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}
}
