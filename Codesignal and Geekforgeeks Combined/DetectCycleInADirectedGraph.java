Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.


Example 1:

Input:



Output: 1
Explanation: 3 -> 3 is a cycle

Example 2:

Input:


Output: 0
Explanation: no cycle in the graph

Your task:
You don’t need to read input or print anything. Your task is to complete the function isCyclic() which takes the integer V denoting the number of vertices and adjacency list as input parameters and returns a boolean value denoting if the given directed graph contains a cycle or not.


Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)


Constraints:
1 ≤ V, E ≤ 105



class Solution 
{
    //Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // code here
        if (adj == null || adj.size() == 0)
            return false;
        boolean [] visited = new boolean [V];
        boolean [] recursionStack = new boolean [V];
        for (int i=0; i<V; i++) {
            if (isThereAnyCycle(i, adj, visited, recursionStack))
                return true;
        }
        return false;
    }
    
    public boolean isThereAnyCycle(int node, ArrayList<ArrayList<Integer>> adj, boolean [] visited, boolean [] recursionStack) {
        if (recursionStack[node])
            return true;
        if (visited[node])
            return false;
        visited[node] = true;
        recursionStack[node] = true;
        ArrayList<Integer> children = adj.get(node);
        for (Integer child : children) {
            if (isThereAnyCycle(child, adj, visited, recursionStack))
                return true;
        }
        recursionStack[node] = false;
        return false;
    }
}
