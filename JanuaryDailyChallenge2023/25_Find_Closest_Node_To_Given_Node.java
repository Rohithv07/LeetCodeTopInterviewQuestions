You are given a directed graph of n nodes numbered from 0 to n - 1, where each node has at most one outgoing edge.

The graph is represented with a given 0-indexed array edges of size n, indicating that there is a directed edge from node i to node edges[i]. If there is no outgoing edge from i, then edges[i] == -1.

You are also given two integers node1 and node2.

Return the index of the node that can be reached from both node1 and node2, such that the maximum between the distance from node1 to that node, and from node2 to that node is minimized. If there are multiple answers, return the node with the smallest index, and if no possible answer exists, return -1.

Note that edges may contain cycles.

 

Example 1:


Input: edges = [2,2,3,-1], node1 = 0, node2 = 1
Output: 2
Explanation: The distance from node 0 to node 2 is 1, and the distance from node 1 to node 2 is 1.
The maximum of those two distances is 1. It can be proven that we cannot get a node with a smaller maximum distance than 1, so we return node 2.
Example 2:


Input: edges = [1,2,-1], node1 = 0, node2 = 2
Output: 2
Explanation: The distance from node 0 to node 2 is 2, and the distance from node 2 to itself is 0.
The maximum of those two distances is 2. It can be proven that we cannot get a node with a smaller maximum distance than 2, so we return node 2.
 

Constraints:

n == edges.length
2 <= n <= 105
-1 <= edges[i] < n
edges[i] != i
0 <= node1, node2 < n


class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int length = edges.length;
        if (edges == null || length == 0) {
            return 0;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < length; i++) {
            int source = i;
            int destination = edges[i];
            graph.get(source).add(destination);
        }
        System.out.println(graph);
        int [] distance1 = new int [length];
        int [] distance2 = new int [length];
        Arrays.fill(distance1, -1);
        Arrays.fill(distance2, -1);
        distance1[node1] = 0;
        distance2[node2] = 0;
        boolean [] visited1 = new boolean [length];
        boolean [] visited2 = new boolean [length];
        dfs(graph, distance1, node1, visited1);
        dfs(graph, distance2, node2, visited2);
        int min = Integer.MAX_VALUE;
        int resultNode = -1;
        for (int i = 0; i < length; i++) {
            if (distance1[i] != -1 && distance2[i] != -1) {
                int max = Math.max(distance1[i], distance2[i]);
                if (min > max) {
                    min = max;
                    resultNode = i;
                }
            }
        }
        return resultNode;
    }

    private void dfs(List<List<Integer>> graph, int [] distance, int node, boolean [] visited) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        List<Integer> children = graph.get(node);
        for (Integer child : children) {
            if (child != -1 && !visited[child]) {
                distance[child] = distance[node] + 1;
                dfs(graph, distance, child, visited);
            }
        }
    }
}