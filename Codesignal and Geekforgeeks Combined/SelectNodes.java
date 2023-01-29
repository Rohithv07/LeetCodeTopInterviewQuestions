Given N nodes of a tree and a list of edges. Find the minimum number of nodes to be selected to light up all the edges of the tree.
An edge lights up when at least one node at the end of the edge is selected.


Example 1:

Input:
N = 6
edges[] = {(1,2), (1,3), (2,4), (3,5), (3,6)}
Output: 2
Explanation: Selecting nodes 2 and 3 lights
up all the edges.
Example 2:

Input:
N = 3
arr[] = {(1,2), (1,3)}
Output: 1
Explanation: Selecting Node 1 
lights up all the edges.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function countVertex() which takes the number of nodes N, and the list of edges as input parameters and returns the minimum number of nodes selected.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 105
1 ≤ edges ≤ N
Given graph is a valid tree.

class Solution{
    public int countVertex(int n, int[][] edges){
        // code here
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int [] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int [][] val = new int [n + 1][2];
        // 0 index - means don't consider the node to light
        // 1 index - means consider the node to light
        for (int i = 1; i <= n; i++) {
            val[i][1] = 1;
        }
        dfs(graph, 1, 1, val);
        return Math.min(val[1][0], val[1][1]);
    }
    
    private void dfs(List<List<Integer>> graph, int source, int parent, int [][] val) {
        List<Integer> children = graph.get(source);
        for (Integer child : children) {
            if (child != parent) {
                continue;
            }
            dfs(graph, child, source, val);
            val[source][0] += val[child][1];
            val[source][1] += Math.min(val[child][1], val[child][0]);
        }
    }
}