class Solution
{
    public boolean isBipartite(int v, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        if (v == 1) {
            return true;
        }
        // bipartite using dfs
        // color 0 - the node is yet to be visited and color with 1 or -1
        // color 1 - this node is coloring by 1 and its adjacent must be -1
        // color -1 - this node is coloring by -1 and its adjacent must be 1
        int [] color = new int [v];
        for (int i=0; i<v; i++) {
            if (color[i] == 0 && !dfs(v, adj, i, color, 1)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, int node, int color [], int toColor) {
        if (color[node] != 0) {
            return color[node] == toColor;
        }
        color[node] = toColor;
        ArrayList<Integer> children = adj.get(node);
        for (Integer child : children) {
            if (!dfs(v, adj, child, color, -toColor)) {
                return false;
            }
        }
        return true;
    }
}