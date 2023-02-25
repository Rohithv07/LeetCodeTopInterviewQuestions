// https://practice.geeksforgeeks.org/contest/interview-series-60/problems/#

// https://www.youtube.com/watch?v=8VfnEAQfx08

Given an undirected graph with V vertices(numbered from 1 to V) and E edges. Find the number of good components in the graph.
A component of the graph is good if and only if the component is a fully connected component.
Note: A fully connected component is a subgraph of a given graph such that there's an edge between every pair of vertices in a component, the given graph can be a disconnected graph. Consider the adjacency list from index 1.

Example 1:

Input: 

Output: 1
Explanation: We can see that there is only one 
component in the graph and in this component 
there is a edge between any two vertces.
Example 2:

Input:

Output: 2
Explanation: We can see that there are 3 components
in the graph. For 1-2-7 there is no edge between
1 to 7, so it is not a fully connected component.
Rest 2 are individually fully connected component.
Your Task:
You don't need to read input or print anything. Your task is to complete the function
findNumberOfGoodComponent() which takes an integer V and an adjacency list adj as input parameters and returns an integer denoting the number of good components.

Expected Time Complexity: O(V+E)
Expected Auxiliary Space: O(depth of the graph)

Constraints:
1 ≤ V, E ≤ 104





// User function Template for Java

// Main Hint : for a graph to be fully connected, the degree of each node
// must be equal to size of that component - 1


// 1. Store the nodes inside the connected component
// 2. Check whether the degree of all nodes in the current connected component is equal = size - 1, where size = size of current connected component
// 3. Repeat until we do for all the node.
class Solution {
    public int findNumberOfGoodComponent(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        List<Integer> currentConnectNodes;
        boolean [] visited = new boolean [v + 1];
        int count = 0;
        for (int i = 1; i <= v; i++) {
            if (!visited[i]) {
                currentConnectNodes = new ArrayList<>(); // new arraylist for each and every new connected components
                dfs(i, adj, visited, currentConnectNodes);
                boolean isFullyConnected = true;
                for (Integer node : currentConnectNodes) {
                    int degree = adj.get(node).size();
                    if (degree != currentConnectNodes.size() - 1) {
                        isFullyConnected = false;
                        break;
                    }
                }
                if (isFullyConnected) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean [] visited, List<Integer> currentConnectNodes) {
        visited[node] = true;
        currentConnectNodes.add(node);
        ArrayList<Integer> children = adj.get(node);
        for (Integer child : children) {
            if (!visited[child]) {
                dfs(child, adj, visited, currentConnectNodes);
            }
        }
    }


    // more mathematical


    class Solution {
    public int findNumberOfGoodComponent(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int goodComponent = 0;
        boolean [] visited = new boolean [v + 1];
        for (int i = 1; i <= v; i++) {
            if (!visited[i]) {
                int [] count = new int [1];
                int [] edges = new int [1];
                dfs(i, adj, visited, count, edges);
                if (edges[0] / 2 == (count[0] * (count[0] - 1) / 2)) {
                    goodComponent++;
                }
            }
        }
        return goodComponent;
    }
    
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean [] visited, int [] count, int [] edges) {
        visited[node] = true;
        count[0]++;
        ArrayList<Integer> children = adj.get(node);
        for (Integer child : children) {
            edges[0]++;
            if (!visited[child]) {
                dfs(child, adj, visited, count, edges);
            }
        }
    }
}
}