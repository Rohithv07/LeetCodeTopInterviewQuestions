// refernce : https://youtu.be/A8ko93TyOns


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        // using BFS
        if (adj == null || adj.size() == 0) {
            return false;
        }
        boolean [] visited = new boolean [v];
        for (int i=0; i<v; i++) {
            if (!visited[i]) {
                if (checkCycleUsingBFS(i, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean checkCycleUsingBFS(int node, ArrayList<ArrayList<Integer>> adj, boolean [] visited) {
        // we will be storing the currentNode + the parent of currentNode inside the queue
        Queue<int[]> queue = new LinkedList<>();
        visited[node] = true;
        queue.offer(new int[]{node, -1}); // this is the very first node for a particualr component
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int [] currentItems = queue.poll();
                int currentNode = currentItems[0];
                int parent = currentItems[1];
                ArrayList<Integer> children = adj.get(currentNode);
                for (Integer child : children) {
                    if (visited[child] && child != parent) {
                        // this means somehow we have reached the child node through some other path
                        // so this will lead toa cycle
                        return true;
                    }
                    if (visited[child] && child == parent) {
                        continue;
                    }
                    if (!visited[child]) {
                        visited[child] = true;
                        queue.offer(new int []{child, currentNode});
                    }
                }
            }
        }
        return false;
    }
}