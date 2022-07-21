Given a graph with V vertices. We say two vertices u and v belong to a single province if there is a path from u to v or v to u. Your task is to find the number of provinces.
Note: A province is a group of directly or indirectly connected cities and no other cities outside of the group.

 

Example 1:

Input:
[
 [1, 0, 1],
 [0, 1, 0],
 [1, 0, 1]
]

Output:
2
Explanation:
The graph clearly has 2 Provinces [1,3] and [2]. 
As city 1 and city 3 has a path between them they 
belong to a single province. City 2 has no path 
to city 1 or city 3 hence it belongs to another 
province.
Example 2:
Input:
[
 [1, 1],
 [1, 1]
]

Output :
1

Your Task:  
You don't need to read input or print anything. Your task is to complete the function numProvinces() which takes an integer V and an adjacency matrix adj as input and returns the number of provinces. adj[i][j] = 1, if nodes i and j are connected and adj[i][j] = 0, if not connected.


Expected Time Complexity: O(V2)
Expected Auxiliary Space: O(V)


Constraints:
1 ≤ V ≤ 500


//User function Template for Java

// basically finding number of connected components
// can also try using Union-Find

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int v) {
        // code here
        ArrayList<ArrayList<Integer>> graph = buildGraph(adj, v);
        boolean [] visited = new boolean [v];
        int provinceCount = 0;
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                provinceCount++;
                dfs(graph, visited, i);
            }
        }
        return provinceCount;
    }
    
    static void dfs(ArrayList<ArrayList<Integer>> graph, boolean [] visited, int node) {
        visited[node] = true;
        ArrayList<Integer> children = graph.get(node);
        for (Integer child : children) {
            if (!visited[child]) {
                dfs(graph, visited, child);
            }
        }
    }
    
    static ArrayList<ArrayList<Integer>> buildGraph(ArrayList<ArrayList<Integer>> adj, int v) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                int connection = adj.get(i).get(j);
                if (connection == 1) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        return graph;
    }
}