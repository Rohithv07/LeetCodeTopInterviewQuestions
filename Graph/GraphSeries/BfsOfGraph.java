class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        if (adj == null || adj.size() == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        boolean [] visited = new boolean [v];
        bfs(adj, 0, visited, result);
        return result;
    }
    
    public void bfs(ArrayList<ArrayList<Integer>>adj, int node, boolean [] visited, 
    ArrayList<Integer> result) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int currentNode = queue.poll();
                result.add(currentNode);
                ArrayList<Integer> children = adj.get(currentNode);
                for (Integer child : children) {
                    if (!visited[child]) {
                        visited[child] = true;
                        queue.offer(child);
                    }
                }
            }
        }
    }
}