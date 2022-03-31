Given a connected acyclic graph with n nodes and n-1 edges, count the pair of nodes that are at even distance(number of edges) from each other.


Example 1:

Input:
n = 3
graph = {{}, {2}, {1, 3}, {2}}
Output: 1
Explaination: Here there are three pairs {1,2},{1,3}
and {2,3} and only {1,3} has even distance between them.
i.e           1
             /
            2
           /
          3

Example 2:

Input:
n = 5
graph = {{}, {2,4}, {1,3}, {2}, {1,5}, {4}}
Output: 4
Explaination: There are four pairs {1,3},{1,5},{2,4}
and {3,5} which has even distance.

Your Task:
You don't need to read input or print anything. Your task is to complete the function countOfNodes() which takes the array graph[] (given as Adjacency list) and its size n as input parameters and returns the count of pair of nodes that are at even distance from each other


Expected Time Complexity: O(V+E)
Expected Auxiliary Space: O(V)


Constraints:
1 ≤ n ≤ 104

class Solution
{
    static int countOfNodes(ArrayList<Integer> graph[], int n) 
    {
        // code here
        boolean [] visited = new boolean [n];
        int [] count = new int [1];
        dfs(graph, visited, count, 1, 0);
        return count[0] * (count[0] - 1) / 2 + (n - count[0]) * (n - count[0] - 1) / 2;
    }
    
    static void dfs(ArrayList<Integer> graph[], boolean [] visited, int [] count, int node, int distance) {
        visited[node] = true;
        if (distance % 2 == 0) {
            count[0]++;
        }
        ArrayList<Integer> children = graph[node];
        for (Integer child : children) {
            if (!visited[child]) {
                dfs(graph, visited, count, child, distance + 1);
            }
        }
    }
}