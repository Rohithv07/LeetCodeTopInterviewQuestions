You are given a directed graph of n nodes numbered from 0 to n - 1, where each node has at most one outgoing edge.

The graph is represented with a given 0-indexed array edges of size n, indicating that there is a directed edge from node i to node edges[i]. If there is no outgoing edge from node i, then edges[i] == -1.

Return the length of the longest cycle in the graph. If no cycle exists, return -1.

A cycle is a path that starts and ends at the same node.

 

Example 1:


Input: edges = [3,3,4,2,3]
Output: 3
Explanation: The longest cycle in the graph is the cycle: 2 -> 4 -> 3 -> 2.
The length of this cycle is 3, so 3 is returned.
Example 2:


Input: edges = [2,-1,3,1]
Output: -1
Explanation: There are no cycles in this graph.
 

Constraints:

n == edges.length
2 <= n <= 105
-1 <= edges[i] < n
edges[i] != i


class Solution {
    
    private int logestCycleLength = -1;
    private List<Integer>[] graph;
    private int[] visited;
    
    private void dfs(int vertex, int cycleLength) {
        visited[vertex] = 1; //add current node under processing mode. [1 : under processing node]
        for(int adj : graph[vertex]) {
            if(visited[adj] == 0) { //If unprocessed yet, [0 : unprocessed node]
                dfs(adj, cycleLength + 1);
                //if current vertex[adj] which is adjacent of current node [vertex] is already in under processing mode,
                //It means we found a cycle.
            } else if(visited[adj] == 1) {
                //1 is added to include the edge length [vertex ----> adj] : I'm NOT making the call for this edge.
                logestCycleLength = Math.max(logestCycleLength, cycleLength + 1); 
            }
        }
        visited[vertex] = 2; //mark current node as processed node
    }
    
    public int longestCycle(int[] edges) {
        
        int n = edges.length;
        graph = new ArrayList[n];
        for(int i = 0; i < n; i += 1) graph[i] = new ArrayList<>();
        for(int i = 0; i < n; i += 1) if(edges[i] != -1) graph[edges[i]].add(i);
        
        visited = new int[n];
        
        for(int i = 0; i < n; i += 1) {
            if(visited[i] == 0) {
                dfs(i, 0);
            }
        }
        
        return logestCycleLength;
    }
}