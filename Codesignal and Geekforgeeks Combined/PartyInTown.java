Geek town has N Houses numbered from 1 to N. They are connected with each other via N-1 bidirectional roads and an adjacency list is used to represent the connections. Find the house from which the distance to the farthest house is the minimum to host the optimal party.


Example 1:

Input: 
N = 4
Roads = {{1,2},{2,3},{2,4}} 
adj = {{2},{1,3,4},{2},{2}} 

Output: 1

Explaination: Maximum distance from house number 2 is 1.

Your Task:
You do not need to read input or print anything. Your task is to complete the function partyHouse() which takes N and adj as input parameters and returns the minimum possible distance to the farthest house from the house where the party is happening.


Expected Time Complexity: O(N*N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 1000


//User function Template for Java

class Solution{
    static int partyHouse(int n, ArrayList<ArrayList<Integer>> adj)
    {
        // code here
        int distance = n;
        int [] depth = new int [1];
        for (int i = 1; i <= n; i++) {
            depth[0] = 0;
            dfs(adj, i, depth, 0, -1);
            distance = Math.min(distance, depth[0]);
        }
        return distance;
    }
    
    static void dfs(ArrayList<ArrayList<Integer>> adj, int node, int [] depth, int currentDepth, int parent) {
        depth[0] = Math.max(depth[0], currentDepth);
        ArrayList<Integer> children = adj.get(node);
        for (Integer child : children) {
            if (child != parent) {
                dfs(adj, child, depth, currentDepth + 1, node);
            }
        }
    }
}