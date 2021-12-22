// https://youtu.be/nbgaEu-pvkU

class Solution
{
    public boolean isBipartite(int v, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        // if there is an odd length cycle, then graph is not bipartitie
        
        // using BFS
        if (v == 1) {
            return true;
        }
        int [] color = new int [v];
        // color = 1 - one of the color
        // color = 2 - the other color
        // color = 0 - its yet to be visited and colored with 1 or 2.
        // this will be a disconnected graph
        for (int i=0; i<v; i++) {
            if (color[i] == 0 && !bfs(v, color, adj, i)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean bfs(int v, int [] color, ArrayList<ArrayList<Integer>> adj, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        color[node] = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
                int currentNode = queue.poll();
                ArrayList<Integer> children = adj.get(currentNode);
                for (Integer child : children) {
                    if (color[child] == 0) {
                        if (color[currentNode] == 1) {
                            color[child] = 2;
                        }
                        else {
                            color[child] = 1;
                        }
                        queue.offer(child);
                    }
                    else {
                        if (color[currentNode] == color[child]) {
                            return false;
                        }
                    }
                }
            }
        return true;
    }
}