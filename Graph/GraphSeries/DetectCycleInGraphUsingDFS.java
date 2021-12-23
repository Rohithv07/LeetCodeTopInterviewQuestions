class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean [] visited = new boolean [v];
        boolean [] recursionStack = new boolean [v];
        for (int i=0; i<v; i++) {
            if (!visited[i]) {
                if (cycleCheckUsingDFS(i, adj, visited, recursionStack)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean cycleCheckUsingDFS(int node, ArrayList<ArrayList<Integer>> adj, boolean [] visited, boolean [] recursionStack) {
        if (recursionStack[node]) {
            return true;
        }
        if (visited[node]) {
            return false;
        }
        visited[node] = true;
        recursionStack[node] = true;
        ArrayList<Integer> children = adj.get(node);
        for (Integer child : children) {
            if (cycleCheckUsingDFS(child, adj, visited, recursionStack)) {
                return true;
            }
        }
        recursionStack[node] = false;
        return false;
    }
}