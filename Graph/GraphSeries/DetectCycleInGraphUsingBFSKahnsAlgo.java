/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        // this can also be done using BFS Kahn's algorithm
        // its basically used for finding the topological ordering
        // but the condition for the topological sorting is the graph must be DAG
        // so we can try to create the topological ordering using BFS Kahns algorithm
        // if we fails, then there is a cycle, else we are good
        
        if (adj == null || adj.size() == 0) {
            return false;
        }
        int [] indegree = new int [v];
        // here we will maintain a count variable instead creating an array for storing the order
        // if the count after the bfs process == v, then we have the topological order for the given graph
        // which means, there is no cycle and the graph is DAG
        // other wise, there is a cycle.
        int countOrder = 0;
        for (int i=0; i<v; i++) {
            ArrayList<Integer> children = adj.get(i);
            for (Integer child : children) {
                indegree[child] += 1;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<v; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int currentNode = queue.poll();
                countOrder ++;
                ArrayList<Integer> children = adj.get(currentNode);
                for (Integer child : children) {
                    indegree[child] -= 1;
                    if (indegree[child] == 0) {
                        queue.offer(child);
                    }
                }
            }
        }
        return countOrder == v ? false : true;
    }
}