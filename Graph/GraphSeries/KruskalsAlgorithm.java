import java.util.*;

// https://youtu.be/1KRmCzBl_mQ


/**
 * Here we will be storing the source, the destination and the weight in a data structure.
 * Then we will just sort the data structure based on the weight
 * After sorting, we pick each item from the data structure 
 * And we check whether the source and destination are in same component with the help of Union Find concept
 * If in same component, we just skip it, else we consider them in our MST and make them in same component using union operation
 * Continue the process until the end of the elements inside the data structure
 */

public class KruskalsAlgorithm {
	public static void main(String [] args) {
		int n = 5;
		ArrayList<Node> adj = new ArrayList<>();
		adj.add(new Node(0, 1, 2));
		adj.add(new Node(0, 3, 6));
		adj.add(new Node(1, 3, 8));
		adj.add(new Node(1, 2, 3));
		adj.add(new Node(1, 4, 5));
		adj.add(new Node(2, 4, 7));
		printKruskalsAlgorithm(n, adj);
	}

	public static void printKruskalsAlgorithm(int n, ArrayList<Node> adj) {
		UnionFind unionFind = new UnionFind(n);
		Collections.sort(adj, (node1, node2) -> Integer.compare(node1.weight, node2.weight));
		int totalWeightOfMST = 0;
		for (Node node : adj) {
			int currentSource = node.source;
			int currentDestination = node.destination;
			int currentWeight = node.weight;
			if (unionFind.isConnected(currentSource, currentDestination)) {
				continue;
			}
			unionFind.union(currentSource, currentDestination);
			System.out.println("Node :" + currentDestination + " from parent :" + currentSource);
			totalWeightOfMST += currentWeight;
		}
		System.out.println(totalWeightOfMST);
	}
}

class Node {
	int weight;
	int source;
	int destination;
	public Node(int source, int destination, int weight) {
		this.weight = weight;
		this.source = source;
		this.destination = destination;
	}
}

class UnionFind {
	int size;
	int component;
	int [] parent;
	int [] rank;
	public UnionFind(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("n cannot be zero or negative");
		}
		size = n;
		component = n;
		parent = new int [n];
		rank = new int [n];
		for (int i=0; i<n; i++) {
			parent[i] = i;
		}
	}

	public int findParent(int p) {
		while (p != parent[p]) {
			parent[p] = parent[parent[p]];
			p = parent[p];
		}
		return p;
	}

	public void union(int p, int q) {
		int parentP = findParent(p);
		int parentQ = findParent(q);
		if (parentP == parentQ) {
			return;
		}
		if (rank[parentQ] > rank[parentP]) {
			parent[parentP] = parentQ;
		}
		else {
			parent[parentQ] = parentP;
			if (rank[parentP] == rank[parentQ]) {
				rank[parentP] += 1;
			}
		}
		component--;
	}

	public boolean isConnected(int p, int q) {
		return findParent(p) == findParent(q);
	}
}