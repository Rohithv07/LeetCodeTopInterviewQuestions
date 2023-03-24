There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.

This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.

It's guaranteed that each city can reach city 0 after reorder.

 

Example 1:


Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
Output: 3
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
Example 2:


Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
Output: 2
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
Example 3:

Input: n = 3, connections = [[1,0],[2,0]]
Output: 0
 

Constraints:

2 <= n <= 5 * 104
connections.length == n - 1
connections[i].length == 2
0 <= ai, bi <= n - 1
ai != bi


// 1. Convert the given into graph
// 2. Do the dfs and look for the forward direction.
// 3. Count of forward direction will give our answer.

class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<n; i++) {
            adj.add(new LinkedList<>());
        }
        for (int [] c:connections) {
            adj.get(c[0]).add(c[1]);
            adj.get(c[1]).add(-c[0]);
        }
        boolean [] visited = new boolean[n];
        return dfs(adj, visited, 0);
    }
    public int dfs(List<List<Integer>>adj, boolean [] visited, int v) {
        int reOrderCount = 0;
        visited[v] = true;
        List<Integer> children = adj.get(v);
        for (Integer child: children) {
            if (!visited[Math.abs(child)])
                reOrderCount += dfs(adj, visited, Math.abs(child)) + (child > 0 ? 1:0);
        }
        return reOrderCount;
    }
}