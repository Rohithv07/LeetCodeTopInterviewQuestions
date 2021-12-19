Given a Directed Graph. Count the total number of ways or paths that exist between two vertices in the directed graph. These paths doesn’t contain any cycle.
Note: Graph doesn't contain multiple edges, self loop and cycles and the two vertices( source and destination) are denoted in the example.


Example 1:

Input:

Output: 4
Explanation: 
There are 4 paths from 0 to 4.
0 -> 4
0 -> 1 -> 4
0 -> 2 -> 4
0 -> 1 -> 3 -> 2 -> 4

Example 2:

Input:

Output: 3
Explanation:
There are 3 paths from 0 to 3.
0 -> 3
0 -> 1 -> 3
0 -> 1 -> 2 -> 3

Your task:
You don’t need to read input or print anything. Your task is to complete the function countPaths() which takes the integer V denoting the number of vertices and adjacency list as input parameters and returns  the count of  the number of paths in the graph from the source vertex to the destination vertex.


Expected Time Complexity: O(V!)
Expected Auxiliary Space: O(V)


Constraints:
1 ≤ V, E ≤ 100
1 ≤ source, destination ≤ V



class Solution {
    // Function to count paths between two vertices in a directed graph.
    public int countPaths(int v, ArrayList<ArrayList<Integer>> adj, int source,
                   int destination) {
        // Code here
        if (source == destination) {
            return 1;
        }
        int [] count = new int [1];
        boolean [] visited = new boolean [v];
        dfs(adj, source, destination, count, visited);
        return count[0];
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj, int source, int destination, int [] count, boolean [] visited) {
        if (source == destination) {
            count[0] += 1;
            return;
        }
        if (visited[source]) {
            return;
        }
        visited[source] = true;
        ArrayList<Integer> children = adj.get(source);
        for (Integer child : children) {
            dfs(adj, child, destination, count, visited);
        }
        visited[source] = false;
     }
}