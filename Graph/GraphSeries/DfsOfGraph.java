class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        // since it is connected , there is no need of doing a loop from 0 to v-1
        // if its disconnected, then we need to have a loop and then do the dfs
        if (adj == null || adj.size() == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        boolean [] visited = new boolean [v];
        dfs(adj, 0, visited, result);
        return result;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean [] visited, ArrayList<Integer> result) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        result.add(node);
        ArrayList<Integer> children = adj.get(node);
        for (Integer child : children) {
            if (!visited[child]) {
                dfs(adj, child, visited, result);
            }
        }
    }
}