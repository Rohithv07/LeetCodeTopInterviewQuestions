

// https://practice.geeksforgeeks.org/contest/interview-series-61/problems/#

// just topological sorting

//User function Template for Java

class Solution
{
    int[] orderProcesses(int n,int dependencies[][])
    {
        ArrayList<ArrayList<Integer>> graph = buildGraph(dependencies, n);
        //System.out.println(graph);
        boolean [] visited = new boolean [n];
        int [] result = new int [n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited, stack);
            }
        }
        int index = 0;
        while (!stack.isEmpty()) {
            result[index++] = stack.pop();
        }
        return result;
    }
    
    void dfs(ArrayList<ArrayList<Integer>> graph, int node, boolean [] visited, Stack<Integer> stack) {
        visited[node] = true;
        ArrayList<Integer> children = graph.get(node);
        for (Integer child : children) {
            if (!visited[child]) {
                dfs(graph, child, visited, stack);
            }
        }
        stack.push(node);
    }
    
    ArrayList<ArrayList<Integer>> buildGraph(int [][] d, int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(new ArrayList<>());
        }
        for (int [] dep : d) {
            result.get(dep[0]).add(dep[1]);
        }
        return result;
    }
}