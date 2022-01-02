Given a weighted directed graph with n nodes and m edges. Nodes are labeled from 0 to n-1, the task is to check if it contains a negative weight cycle or not.
Note: edges[i] is defined as u, v and weight.
 

Example 1:

Input: n = 3, edges = {{0,1,-1},{1,2,-2},
{2,0,-3}}
Output: 1
Explanation: The graph contains negative weight
cycle as 0->1->2->0 with weight -1,-2,-3,-1.
Example 2:

Input: n = 3, edges = {{0,1,-1},{1,2,-2},
{2,0,3}}
Output: 0
Explanation: The graph does not contain any
negative weight cycle.
 

Your Task:
You don't need to read or print anyhting. Your task is to complete the function isNegativeWeightCycle() which takes n and edges as input paramater and returns 1 if graph contains negative weight cycle otherwise returns 0.
 

Expected Time Complexity: O(n*m)
Expected Space Compelxity: O(n)
 

Constraints:
1 <= n <= 100
1 <= m <= n*(n-1), where m is the total number of Edges in the directed graph.



class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //code here
        if (edges == null || edges.length == 0 || n <= 0) {
            return 0;
        }
        int [] distance = new int [n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        for (int i=0; i<n-1; i++) {
            for (int [] e : edges) {
                int src = e[0];
                int dest = e[1];
                int weight = e[2];
                if (distance[src] != Integer.MAX_VALUE && distance[src] + weight < distance[dest]) {
                    distance[dest] = distance[src] + weight;
                }
            }
        }
        for (int [] e : edges) {
            int src = e[0];
            int dest = e[1];
            int weight = e[2];
            if (distance[src] != Integer.MAX_VALUE && distance[src] + weight < distance[dest]) {
                return 1;
            }
        }
        return 0;
    }
}