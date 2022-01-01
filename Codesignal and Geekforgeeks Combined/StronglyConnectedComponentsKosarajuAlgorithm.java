Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, Find the number of strongly connected components in the graph.
 

Example 1:

Input:

Output:
3
Explanation:

We can clearly see that there are 3 Strongly
Connected Components in the Graph
Example 2:

Input:

Output:
1
Explanation:
All of the nodes are connected to each other.
So, there's only one SCC.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function kosaraju() which takes the number of vertices V and adjacency list of the graph as inputs and returns an integer denoting the number of strongly connected components in the given graph.
 

Expected Time Complexity: O(V+E).
Expected Auxiliary Space: O(V).
 

Constraints:
1 ≤ V ≤ 5000
0 ≤ E ≤ (V*(V-1))
0 ≤ u, v ≤ N-1
Sum of E over all testcases will not exceed 25*106





class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int v, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        if (adj == null || adj.size() == 0 || v <= 0) {
            return 0;
        }
        // we can apply Kosarajus SCC algorithm here
        // we just need to do 3 steps
        // 1. Find the topological ordering for the given graph
        // 2. Find the transpose of the graph by just changing the direction
        // 3. Now based on the topological ordering, do a dfs on the transpose graph
        // by these steps we can find the strongly connected component, or we can take the count whatever we need
        
        boolean [] visited = new boolean[v];
        Stack<Integer> trackOrder = new Stack<>();
        int stronglyConnectedCount = 0;
        for (int i=0; i<v; i++) {
            if (!visited[i]) {
                normalDfs(i, visited, adj, trackOrder);
            }
        }
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for (int i=0; i<v; i++) {
            transpose.add(new ArrayList<>());
        }
        for (int i=0; i<v; i++) {
            visited[i] = false;
            ArrayList<Integer> children = adj.get(i);
            for (Integer child : children) {
                // change direction
                transpose.get(child).add(i);
            }
        }
        while (!trackOrder.isEmpty()) {
            int node = trackOrder.pop();
            if (!visited[node]) {
                stronglyConnectedCount ++;
                specialDfs(node, visited, transpose);
                // here also we can make use for printing the scc, which can be added inside the dfs
            }
        }
        return stronglyConnectedCount;
    }
    
    // this will help in finding the topo sort
    public void normalDfs(int node, boolean [] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> trackOrder) {
        visited[node] = true;
        ArrayList<Integer> children = adj.get(node);
        for (Integer child : children) {
            if (!visited[child]) {
                normalDfs(child, visited, adj, trackOrder);
            }
        }
        trackOrder.push(node);
    }
    
    // this will track the scc
    public void specialDfs(int node, boolean [] visited, ArrayList<ArrayList<Integer>> transpose) {
        visited[node] = true;
        // we can just print the node which will give our scc nodes
        ArrayList<Integer> children = transpose.get(node);
        for (Integer child : children) {
            if (!visited[child]) {
                specialDfs(child, visited, transpose);
            }
        }
    }
}
