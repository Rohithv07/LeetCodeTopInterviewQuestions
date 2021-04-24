There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network where connections[i] = [a, b] represents a connection between servers a and b. Any server can reach any other server directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some server unable to reach some other server.

Return all critical connections in the network in any order.

 

Example 1:



Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.
 

Constraints:

1 <= n <= 10^5
n-1 <= connections.length <= 10^5
connections[i][0] != connections[i][1]
There are no repeated connections.


class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, List<Integer>> graph = buildGraph(connections);
        Set<List<Integer>> possibleConnectionSet = new HashSet<>(connections);
        int [] rank = new int [n];
        Arrays.fill(rank, -2);
        dfsHelper(graph, rank, 0, 0, possibleConnectionSet); // returns the min rank
        return new ArrayList<>(possibleConnectionSet);
    }
    
    public int dfsHelper(Map<Integer, List<Integer>> graph, int [] rank, int node, int depth, Set<List<Integer>> possibleConnectionSet) {
        if (rank[node] >= 0) {
            return rank[node];
        }
        rank[node] = depth;
        int currentMinDepth = depth;
        System.out.println(graph.get(node));
        for (Integer currentNode : graph.get(node)) {
                if (rank[currentNode] >= depth - 1)  // parent
                    continue;
                int minDepth = dfsHelper(graph, rank, currentNode, depth + 1, possibleConnectionSet);
                currentMinDepth = Math.min(currentMinDepth, minDepth);
                if (minDepth <= depth) {
                    possibleConnectionSet.remove(Arrays.asList(node, currentNode));
                    possibleConnectionSet.remove(Arrays.asList(currentNode, node));
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
