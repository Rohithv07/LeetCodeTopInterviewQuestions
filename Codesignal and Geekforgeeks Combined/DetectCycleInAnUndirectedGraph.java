Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not. 

Example 1:

Input:   

Output: 1
Explanation: 1->2->3->4->1 is a cycle.
Example 2:

Input: 

Output: 0
Explanation: No cycle in the graph.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function isCycle() which takes V denoting the number of vertices and adjacency list as input parameters and returns a boolean value denoting if the undirected graph contains any cycle or not, return 1 if a cycle is present else return 0.

NOTE: The adjacency list denotes the edges of the graph where edges[i][0] and edges[i][1] represent an edge.

 

Expected Time Complexity: O(V + E)
Expected Space Complexity: O(V)


 

Constraints:
1 ≤ V, E ≤ 105


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean [] visited = new boolean [v];
        for (int node = 0; node < v; node++) {
            if (!visited[node]) {
                if (isThereCycle(adj, node, -1, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isThereCycle(ArrayList<ArrayList<Integer>> adj, int node, int parent, boolean [] visited) {
        visited[node] = true;
        ArrayList<Integer> children = adj.get(node);
        for (Integer child : children) {
            if (!visited[child]) {
                if (isThereCycle(adj, child, node, visited)) {
                    return true;
                }
            }
            else if (child != parent) {
                return true;
            }
        }
        return false;
    }
}