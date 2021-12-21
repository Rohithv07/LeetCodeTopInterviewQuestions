// ref : https://youtu.be/Y9NFqI6Pzd4


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        // using dfs
        if (adj == null || adj.size() == 0) {
            return false;
        }
        boolean [] visited = new boolean [v];
        for (int i=0; i<v; i++) {
            if (!visited[i]) {
                if (isCycleUsingDFS(i, adj, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isCycleUsingDFS(int node, ArrayList<ArrayList<Integer>> adj, boolean [] visited, int parent) {
        visited[node] = true;
        ArrayList<Integer> children = adj.get(node);
        for (Integer child : children) {
            if (!visited[child]) {
                if (isCycleUsingDFS(child, adj, visited, node)) {
                    return true;
                }
            }
            else if (child != parent) {
                return true;
            }
        }
        return false;
    }
}