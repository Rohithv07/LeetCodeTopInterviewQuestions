import java.util.*;


// https://youtu.be/HnD676J56ak

/**
 * this algorithm is used to find the minimum spanning tree
 * spanning tree means if we have a graph and if we are able to convert the graph
 * to a tree with n number of nodes and n - 1 number of edges
 * We add minimum, if such spanning tree is a having the total weight minimum
 * 
 * To achieve this MST using prims, we typically have 3 arrays
 * Key array 
 * MST array boolean
 * parent array
 * 
 * So here we start with the very first index as 0 in the key and the rest as infinity in the key array
 * In the MST array, we just mark the 0th index as true telling we have included it in our MST
 * and the third array, which tracks the parent of each node will be initially 0 and will be 0 even for the very first index
 * 
 * Now we continue by traversing through all the adjacent element of node 0. We compare it with key array and mark the minimum distance/weight in it.
 * Since we are traversing through the adjacent nodes of node 0, in the parent array, mark the respective indexes as 0, indicating 0 is the parent node for the particular node. We do this only for the nodes that are not part of MST otherwise cycles will arise.
 * 
 * Now we look inside the key array and pick the index with the minimum value we provided and then mark it as true in MST array
 * Now we repeat the steps like traversing through all the adjacent nodes for the minimum value we spotted inside the key array and mark them inside the key array and mark the parent
 * 
 * Once we are all done, we can get the MST and also the total weight etc from the respective arrays
 * 
 */




public class PrimsAlgorithmMST {
	public static void main(String [] args) {
		int n = 5;
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for (int i=0; i<n; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(0).add(new Pair(1, 2));
		adj.get(0).add(new Pair(3, 6));
		adj.get(1).add(new Pair(0, 2));
		adj.get(1).add(new Pair(2, 3));
		adj.get(1).add(new Pair(3, 8));
		adj.get(1).add(new Pair(4, 5));
		adj.get(2).add(new Pair(1, 3));
		adj.get(2).add(new Pair(4, 7));
		adj.get(3).add(new Pair(0, 6));
		adj.get(3).add(new Pair(1, 8));
		adj.get(4).add(new Pair(1, 5));
		adj.get(4).add(new Pair(2, 7));

		printPrimsAlgoMST(n, adj);
	}

	public static void printPrimsAlgoMST(int n, ArrayList<ArrayList<Pair>> adj) {
		int [] key = new int [n];
		int [] parent = new int [n];
		boolean [] mst = new boolean [n];
		Arrays.fill(key, Integer.MAX_VALUE);
		Arrays.fill(parent, -1);
		key[0] = 0;
		PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.weight, p2.weight));
		minHeap.offer(new Pair(0, key[0]));

		// since in MST we have n nodes and n - 1 edes, we will be doing a loop from 0 to n - 1
		// for (int i=0; i<n-1; i++) {
		// 	Pair currentPair = minHeap.poll();
		// 	int currentNode = currentPair.node;
		// 	int currentWeight = currentPair.weight;
		// 	mst[currentNode] = true;

		// 	ArrayList<Pair> children = adj.get(currentNode);
		// 	for (Pair child : children) {
		// 		int childNode = child.node;
		// 		int childWeight = child.weight;
		// 		if (!mst[childNode] && key[childNode] > childWeight) {
		// 			key[childNode] = childWeight;
		// 			parent[childNode] = currentNode;
		// 			minHeap.offer(new Pair(childNode, key[childNode]));
		// 		}
		// 	}
		// }
		// the above code is also correct but we can remove the for loop and do a while loop until pq is empty


		while (!minHeap.isEmpty()) {
			Pair currentPair = minHeap.poll();
			int currentNode = currentPair.node;
			int currentWeight = currentPair.weight;
			mst[currentNode] = true;
			ArrayList<Pair> children = adj.get(currentNode);
			for (Pair child : children) {
				int childNode = child.node;
				int childWeight = child.weight;
				if (!mst[childNode] && key[childNode] > childWeight) {
					key[childNode] = childWeight;
					parent[childNode] = currentNode;
					minHeap.offer(new Pair(childNode, key[childNode]));
				}
			}
		}



		// parent of the very first index will be -1.
		for (int i=1; i<n; i++) {
			System.out.println("Parent : " + parent[i] + " of node : " + i);
		}
		int totalWeight = 0;
		for (int number : key) {
			totalWeight += number;
		}
		System.out.println("The total weight for MST : " + totalWeight);
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