Given a weighted, undirected and connected graph of V vertices and E edges, Find the shortest distance of all the vertex's from the source vertex S.
Note: The Graph doesn't contain any negative weight cycle.

 

Example 1:

Input:

S = 0
Output:
0 9
Explanation:
The source vertex is 0. Hence, the shortest 
distance of node 0 is 0 and the shortest 
distance from node 9 is 9 - 0 = 9.
 

Example 2:

Input:

S = 2
Output:
4 3 0
Explanation:
For nodes 2 to 0, we can follow the path-
2-1-0. This has a distance of 1+3 = 4,
whereas the path 2-0 has a distance of 6. So,
the Shortest path from 2 to 0 is 4.
The other distances are pretty straight-forward.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function dijkstra()  which takes number of vertices V and an adjacency list adj as input parameters and returns a list of integers, where ith integer denotes the shortest distance of the ith node from Source node. Here adj[i] contains a list of lists containing two integers where the first integer j denotes that there is an edge between i and j and second integer w denotes that the weight between edge i and j is w.

 

Expected Time Complexity: O(V2).
Expected Auxiliary Space: O(V2).

 

Constraints:
1 ≤ V ≤ 1000
0 ≤ adj[i][j] ≤ 1000
1 ≤ adj.size() ≤ [ (V*(V - 1)) / 2 ]
0 ≤ S < V


//User function Template for Java


class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s)
    {
        // Write your code here
        // we will be using a min heap which will be sorted based on the distance
        
        int [] distance = new int [v];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.weight, p2.weight));
        distance[s] = 0;
        minHeap.offer(new Pair(s, 0));
        while (!minHeap.isEmpty()) {
            Pair currentPair = minHeap.poll();
            int currentNode = currentPair.vertex;
            int currentDistance = currentPair.weight;
            ArrayList<ArrayList<Integer>> children = adj.get(currentNode);
            for (ArrayList<Integer> child : children) {
                if (distance[currentNode] + child.get(1) < distance[child.get(0)]) {
                    distance[child.get(0)] = distance[currentNode] + child.get(1);
                    minHeap.offer(new Pair(child.get(0), distance[child.get(0)]));
                }
            }
        }
        return distance;
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

