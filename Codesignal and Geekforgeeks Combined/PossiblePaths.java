Given a directed graph and two vertices ‘u’ and ‘v’ in it. Find the number of possible walks from ‘u’ to ‘v’ with exactly k edges on the walk modulo 109+7.
 

Example 1:

Input 1: graph = {{0,1,1,1},{0,0,0,1}, 
{0,0,0,1}, {0,0,0,0}}, u = 0, v = 3, k = 2
Output: 2
Explanation: Let source ‘u’ be vertex 0, 
destination ‘v’ be 3 and k be 2. The output 
should be 2 as there are two walk from 0 to 
3 with exactly 2 edges. The walks are {0, 2, 3}
and {0, 1, 3}.

Your Task:
You don't need to read or print anything. Your task is to complete the function MinimumWalk() which takes graph, u, v and k as input parameter and returns total possible paths from u to v using exactly k edges modulo 109+7.
Note: In graph, if graph[i][j] = 1, it means there is an directed edge from vertex i to j.
 

Expected Time Complexity: O(n3)
Expected Space Complexity: O(n3)
 

Constraints:
1 ≤ n ≤ 50
1 ≤ k ≤ n
0 ≤ u, v ≤ n-1

class Solution
{
    private int mod = (int)1e9 + 7;
    
    public int MinimumWalk(int[][] graph, int u, int v, int k)
    {
        // Code here
        if (graph == null || graph.length == 0) {
            return 0;
        }
        int [][] dp = new int [graph.length][k + 1];
        for (int [] d : dp) {
            Arrays.fill(d, -1);
        }
        return dfsHelper(graph, dp, u, v, k);
    }
    
    private int dfsHelper(int [][] graph, int [][] dp, int src, int dest, int k) {
        if (src == dest && k == 0) {
            return 1;
        }
        if (k == 0) {
            return 0;
        }
        if (dp[src][k] != -1) {
            return dp[src][k] % mod;
        }
        int countPath = 0;
        for (int i=0; i<graph[src].length; i++) {
            if (graph[src][i] == 1) {
                countPath = (countPath + dfsHelper(graph, dp, i, dest, k-1)) % mod;
            }
        }
        return dp[src][k] = countPath % mod;
    }
}