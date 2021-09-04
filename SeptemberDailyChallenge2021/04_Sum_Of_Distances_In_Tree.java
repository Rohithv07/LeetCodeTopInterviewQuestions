There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.

You are given the integer n and the array edges where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.

Return an array answer of length n where answer[i] is the sum of the distances between the ith node in the tree and all other nodes.

 

Example 1:


Input: n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
Output: [8,12,6,10,10,10]
Explanation: The tree is shown above.
We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
equals 1 + 1 + 2 + 2 + 2 = 8.
Hence, answer[0] = 8, and so on.
Example 2:


Input: n = 1, edges = []
Output: [0]
Example 3:


Input: n = 2, edges = [[1,0]]
Output: [1,1]
 

Constraints:

1 <= n <= 3 * 104
edges.length == n - 1
edges[i].length == 2
0 <= ai, bi < n
ai != bi
The given input represents a valid tree.


// https://leetcode.com/problems/sum-of-distances-in-tree/discuss/885637/Java-solution-code-%2B-photo-explaination

class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        if (n == 0) {
            return new int []{};
        }
        if (n == 1 && edges.length == 0) {
            return new int []{0};
        }
        Map<Integer, List<Integer>> graph = buildGraph(edges);
        int [] count = new int [n];
        int [] result = new int [n];
        Arrays.fill(count, 1);
        // first do postorder so that we get the distance for 0 th node
        // count[parent] += count[child]
        // result[parent] += result[child] + count[child]
        postOrder(0, -1, graph, count, result);
        // to get the rest of the answer, do a post order
        // result[child] = result[parent] + (n - count[child]) - count[child];
        preOrder(0, -1, graph, count, result, n);
        return result;
    }
    
    public void postOrder(int node, int parent, Map<Integer, List<Integer>> graph, int [] count, int [] result) {
        List<Integer> children = graph.get(node);
        for (Integer child : children) {
            if (child != parent) {
                postOrder(child, node, graph, count, result);
                count[node] += count[child];
                result[node] += result[child] + count[child];
            }
        }
    }
    
    public void preOrder(int node, int parent, Map<Integer, List<Integer>> graph, int [] count, int [] result, int n) {
        List<Integer> children = graph.get(node);
        for (Integer child : children) {
            if (child != parent) {
                result[child] = result[node] + (n - count[child]) - count[child];
                preOrder(child, node, graph, count, result, n);
            }
        }
    }
    
    public Map<Integer, List<Integer>> buildGraph(int [][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int [] edge : edges) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
        }
        return graph;
    }
}