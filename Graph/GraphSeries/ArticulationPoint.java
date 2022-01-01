import java.util.*;


/**
 * Articulation point means if we remove a vertex and removal of that vertez
 * results in making the graph disconnected to 2 or more components, then this 
 * is an articulation point
 */
public class ArticulationPoint {

	public static void findArticulationPoint(int n, ArrayList<ArrayList<Integer>> adj) {
		boolean [] visited = new boolean[n];
		int [] timeOfInsertion = new int [n];
		int [] lowestTime = new int [n];
		int [] articulationPoint = new int [n];
		int timer = 0;
		for (int i=0; i<n; i++) {
			if (!visited[i]) {
				dfs(i, -1, visited, timeOfInsertion, lowestTime, articulationPoint, adj, timer);
			}
		}
		int node = 0;
		for (int articulation : articulationPoint) {
			if (articulation == 1) {
				System.out.println("Articualtion Point :" + node);
			}
			node++;
			// we can also just do a for loop from i = 0 to n and check the above condition and print i
		}
	}

	public static void dfs(int node, int parent, boolean [] visited, int [] timeOfInsertion, int [] lowestTime, int [] articulationPoint, ArrayList<ArrayList<Integer>> adj, int timer) {
		visited[node] = true;
		timeOfInsertion[node] = lowestTime[node] = timer++;
		ArrayList<Integer> children = adj.get(node);
		int childCount = 0;
		for (Integer child : children) {
			if (child == parent) {
				continue;
			}
			if (!visited[child]) {
				dfs(child, node, visited, timeOfInsertion, lowestTime, articulationPoint, adj, timer);
				lowestTime[node] = Math.min(lowestTime[node], lowestTime[child]);
				if (lowestTime[child] >= timeOfInsertion[node] && parent != -1) {
					articulationPoint[node] = 1;
				}
				childCount++;
			}
			else {
				lowestTime[node] = Math.min(lowestTime[node], timeOfInsertion[child]);
			}
		}

		// this is the edge case for the very first node becoming articulation point whose parent = -1;
		if (parent == -1 && childCount > 1) {
			articulationPoint[node] = 1;
		}
	}

	public static void main(String args[])
    {
        int n = 5;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<Integer>());
			
		adj.get(0).add(1);
		adj.get(1).add(0);

		adj.get(0).add(2);
		adj.get(2).add(0);

		adj.get(1).add(2);
		adj.get(2).add(1);

		adj.get(1).add(3);
		adj.get(3).add(1);

		adj.get(3).add(4);
		adj.get(4).add(3);

		findArticulationPoint(n, adj);
	}
}