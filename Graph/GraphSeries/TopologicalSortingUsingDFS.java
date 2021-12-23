class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        // for topological sorting, the graph must be directed acyclic graph
        // if its not mentioned, we need to make sure the graph is not having any cycke
        // if it have any cycle, then there is no topological sort ordering
        if (adj == null || adj.size() == 0) {
            return new int []{};
        }
        boolean [] visited = new boolean [v];
        Stack<Integer> trackOrder = new Stack<>();
        int [] result = new int [v];
        for (int i=0; i<v; i++) {
            if (!visited[i]) {
                dfs(adj, i, visited, trackOrder);
            }
        }
        int index = 0;
        while (!trackOrder.isEmpty()) {
            result[index++] = trackOrder.pop();
        }
        return result;
    }
    
    static void dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean [] visited, Stack<Integer> trackOrder) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        ArrayList<Integer> children = adj.get(node);
        for (Integer child : children) {
            if (!visited[child]) {
                dfs(adj, child, visited, trackOrder);
            }
        }
        trackOrder.push(node);
    }
}
