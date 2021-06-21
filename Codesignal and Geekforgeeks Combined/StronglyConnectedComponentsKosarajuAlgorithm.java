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





// dfs and fill the stack
// reverse
// dfs and pop the stack and count the scc
class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        boolean [] visited = new boolean [V];
        for (int i=0; i<V; i++) {
            if (!visited[i]) {
                dfsFillStack(adj, i, visited, stack);
            }
        }
        ArrayList<ArrayList<Integer>> reversed = new ArrayList<>();
        Arrays.fill(visited, false);
        for (int i=0; i<V; i++) {
            reversed.add(i, new ArrayList<>());
        }
        reverse(adj, V, reversed);
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited[current]) {
                dfsCountSCC(reversed, current, visited);
                count++;
            }
        }
        return count;
    }
    
    public void reverse(ArrayList<ArrayList<Integer>> adj, int V, ArrayList<ArrayList<Integer>> reversed) {
        for (int i=0; i<V; i++) {
            ArrayList<Integer> children = adj.get(i);
            for (Integer child : children) {
                reversed.get(child).add(i);
            }
        }
    }
    
    public void dfsFillStack(ArrayList<ArrayList<Integer>> adj, int i, boolean [] visited, Stack<Integer> stack) {
        visited[i] = true;
        ArrayList<Integer> children = adj.get(i);
        for (Integer child : children) {
            if (!visited[child]) {
                dfsFillStack(adj, child, visited, stack);
            }
        }
        stack.push(i);
    }
    
    public void dfsCountSCC(ArrayList<ArrayList<Integer>> reversed, int i, boolean [] visited) {
        visited[i] = true;
        ArrayList<Integer> children = reversed.get(i);
        for (Integer child : children) {
            if (!visited[child]) {
                dfsCountSCC(reversed, child, visited);
            }
        }
    }

    
    
    
    
}

