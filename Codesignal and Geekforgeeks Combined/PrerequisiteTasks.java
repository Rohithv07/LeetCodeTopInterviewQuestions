There are a total of N tasks, labeled from 0 to N-1. Some tasks may have prerequisites, for example to do task 0 you have to first complete task 1, which is expressed as a pair: [0, 1]
Given the total number of tasks N and a list of prerequisite pairs P, find if it is possible to finish all tasks.


Example 1:

Input: 
N = 4, P = 3
prerequisites = {{1,0},{2,1},{3,2}}
Output:
Yes
Explanation:
To do task 1 you should have completed
task 0, and to do task 2 you should 
have finished task 1, and to do task 3 you 
should have finished task 2. So it is possible.
Example 2:

Input:
N = 2, P = 2
prerequisites = {{1,0},{0,1}}
Output:
No
Explanation:
To do task 1 you should have completed
task 0, and to do task 0 you should
have finished task 1. So it is impossible.

Your task:
You don’t need to read input or print anything. Your task is to complete the function isPossible() which takes the integer N denoting the number of tasks, P denoting the number of prerequisite pairs and prerequisite as input parameters and returns true if it is possible to finish all tasks otherwise returns false. 


Expected Time Complexity: O(N + P)
Expected Auxiliary Space: O(N + P)


Constraints:
1 ≤ N ≤ 104
1 ≤ P ≤ 105





class Solution {
    public boolean isPossible(int n, int[][] prerequisites)
    {
        // Your Code goes here
        if (prerequisites == null || n == 0) {
            return true;
        }
        if (n == 1) {
            return true;
        }
        List<List<Integer>> graph = buildGraph(prerequisites, n);
        return !isThereCycle(graph, n);
    }
    
    private boolean isThereCycle(List<List<Integer>> graph, int n) {
        boolean [] visited = new boolean [n];
        boolean [] recursionStack = new boolean [n];
        for (int i=0; i<n; i++) {
            if (dfs(graph, i, visited, recursionStack))
                return true;
        }
        return false;
    }
    
    private boolean dfs(List<List<Integer>> graph, int node, boolean [] visited, boolean [] recursionStack) {
        if (recursionStack[node]) 
            return true;
        if (visited[node])
            return false;
        visited[node] = true;
        recursionStack[node] = true;
        List<Integer> children = graph.get(node);
        for (Integer child : children) {
            if (dfs(graph, child, visited, recursionStack)) {
                return true;
            }
        }
        return recursionStack[node] = false;
    }
    
    private List<List<Integer>> buildGraph(int [][] prerequisites, int n) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int [] course : prerequisites) {
            graph.get(course[0]).add(course[1]);
        }
        return graph;
    }
    
}