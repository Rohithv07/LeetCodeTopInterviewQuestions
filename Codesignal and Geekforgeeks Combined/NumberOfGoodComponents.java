// https://practice.geeksforgeeks.org/contest/interview-series-60/problems/#

// https://www.youtube.com/watch?v=8VfnEAQfx08







// User function Template for Java

// Main Hint : for a graph to be fully connected, the degree of each node
// must be equal to size of that component - 1


// 1. Store the nodes inside the connected component
// 2. Check whether the degree of all nodes in the current connected component is equal = size - 1, where size = size of current connected component
// 3. Repeat until we do for all the node.
class Solution {
    public int findNumberOfGoodComponent(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        List<Integer> currentConnectNodes;
        boolean [] visited = new boolean [v + 1];
        int count = 0;
        for (int i = 1; i <= v; i++) {
            if (!visited[i]) {
                currentConnectNodes = new ArrayList<>(); // new arraylist for each and every new connected components
                dfs(i, adj, visited, currentConnectNodes);
                boolean isFullyConnected = true;
                for (Integer node : currentConnectNodes) {
                    int degree = adj.get(node).size();
                    if (degree != currentConnectNodes.size() - 1) {
                        isFullyConnected = false;
                        break;
                    }
                }
                if (isFullyConnected) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean [] visited, List<Integer> currentConnectNodes) {
        visited[node] = true;
        currentConnectNodes.add(node);
        ArrayList<Integer> children = adj.get(node);
        for (Integer child : children) {
            if (!visited[child]) {
                dfs(child, adj, visited, currentConnectNodes);
            }
        }
    }
}