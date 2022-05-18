There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some servers unable to reach some other server.

Return all critical connections in the network in any order.

 

Example 1:


Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.
Example 2:

Input: n = 2, connections = [[0,1]]
Output: [[0,1]]
 

Constraints:

2 <= n <= 105
n - 1 <= connections.length <= 105
0 <= ai, bi <= n - 1
ai != bi
There are no repeated connections.






class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, List<Integer>> graph = buildGraph(connections);
        int [] rank = new int [n];
        Arrays.fill(rank, -2);
        Set<List<Integer>> possibleConnectionSet = new HashSet<>(connections);
        dfsHelper(graph, rank, 0, 0, possibleConnectionSet);
        return new ArrayList<>(possibleConnectionSet);
    }
    
    public int dfsHelper(Map<Integer, List<Integer>> graph, int [] rank, int node, int depth, Set<List<Integer>> possibleConnectionSet) {
        if (rank[node] >= 0)
            return rank[node];
        rank[node] = depth;
        int currentMinDepth = depth;
        List<Integer> children = graph.get(node);
        for (Integer child : children) {
            if (rank[child] == depth - 1)
                continue;
            int minDepth = dfsHelper(graph, rank, child, depth + 1, possibleConnectionSet);
            currentMinDepth = Math.min(currentMinDepth, minDepth);
            if (minDepth <= depth) {
                possibleConnectionSet.remove(Arrays.asList(node, child));
                possibleConnectionSet.remove(Arrays.asList(child, node));
            }
        }
        return currentMinDepth;
    }
    
    public Map<Integer, List<Integer>> buildGraph(List<List<Integer>> connections) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (List<Integer> conn : connections) {
            graph.computeIfAbsent(conn.get(0), x -> new ArrayList<>()).add(conn.get(1));
            graph.computeIfAbsent(conn.get(1), x -> new ArrayList<>()).add(conn.get(0));
        }
        return graph;
    }
}