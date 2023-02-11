You are given an integer n, the number of nodes in a directed graph where the nodes are labeled from 0 to n - 1. Each edge is red or blue in this graph, and there could be self-edges and parallel edges.

You are given two arrays redEdges and blueEdges where:

redEdges[i] = [ai, bi] indicates that there is a directed red edge from node ai to node bi in the graph, and
blueEdges[j] = [uj, vj] indicates that there is a directed blue edge from node uj to node vj in the graph.
Return an array answer of length n, where each answer[x] is the length of the shortest path from node 0 to node x such that the edge colors alternate along the path, or -1 if such a path does not exist.

 

Example 1:

Input: n = 3, redEdges = [[0,1],[1,2]], blueEdges = []
Output: [0,1,-1]
Example 2:

Input: n = 3, redEdges = [[0,1]], blueEdges = [[2,1]]
Output: [0,1,-1]
 

Constraints:

1 <= n <= 100
0 <= redEdges.length, blueEdges.length <= 400
redEdges[i].length == blueEdges[j].length == 2
0 <= ai, bi, uj, vj < n



class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int[][] g = new int[n][n];
        buildGraph(g, n, red_edges, blue_edges);
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 1});
        q.offer(new int[]{0, -1});
        int len = 0;
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        
        Set<String> visited = new HashSet<>();
        while (!q.isEmpty()) {
            int size = q.size();
            len++;
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int node = cur[0];
                int color = cur[1];
                int oppoColor = -color;
                
                for (int j = 1; j < n; j++) {
                    if (g[node][j] == oppoColor ||
                       g[node][j] == 0) {
                        if (!visited.add(j + "" + oppoColor)) continue;
                        q.offer(new int[]{j, oppoColor});
                        res[j] = Math.min(res[j], len);
                    }
                }
            }
        }
        
        for (int i = 1; i < n; i++) {
            if (res[i] == Integer.MAX_VALUE) {
                res[i] = -1;
            }
        }
        
        return res;
    }
    
    private void buildGraph(int[][] g, int n, int[][] red_edges, int[][] blue_edges) {
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i], -n);
        }
        
        for (int[] e : red_edges) {
            int from = e[0];
            int to = e[1];
            g[from][to] = 1;
        }
        
        for (int[] e : blue_edges) {
            int from = e[0];
            int to = e[1];
            if (g[from][to] == 1) {
                g[from][to] = 0;
            } else {
                g[from][to] = -1;
            }
        }
    }
}