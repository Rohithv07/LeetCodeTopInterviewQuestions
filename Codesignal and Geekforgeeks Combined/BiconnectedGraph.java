Given a graph with n vertices, e edges and an array arr[] denoting the edges connected to each other, check whether it is Biconnected or not.
Note: The given graph is Undirected.

 

Example 1:

Input:
n = 2, e = 1
arr = {0, 1}
Output:
1
Explanation:
       0
      /
     1
The above graph is Biconnected.
Example 2:

Input:
n = 3, e = 2
arr = {0, 1, 1, 2}
Output:
0
Explanation:
       0
      /
     1
      \
       2
The above graph is not Biconnected.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function biGraph() which takes 2 Integers n, and e and an array arr of length 2*e as input and returns 1 if the graph is biconnected else returns 0.

 

Expected Time Complexity: O(n+e)
Expected Auxiliary Space: O(n)

 

Constraints:
1 <= e <= 100
2 <= n <= 100





class Solution {
    static int biGraph(int[] arr, int n, int e) {
        // code here
        int length = arr.length;
        List<List<Integer>> graph = buildGraph(arr, n);
        boolean [] visited = new boolean [n];
        int [] timeOfInsertion = new int [n];
        int [] lowestTime = new int [n];
        int [] articulationPoint = new int [n];
        int timer = 0;
        dfs(0, -1, visited, timeOfInsertion, lowestTime, articulationPoint, graph, timer);
        for (boolean val : visited) {
            if (!val) {
                return 0;
            }
        }
        for (int articulation : articulationPoint) {
            if (articulation == 1) {
                return 0;
            }
        }
        return 1;
    }
    
    static boolean dfs(int node, int parent, boolean [] visited, int [] timeOfInsertion, int [] lowestTime, int [] articulationPoint, List<List<Integer>> graph, int timer) {
        visited[node] = true;
        timeOfInsertion[node] = lowestTime[node] = timer++;
        List<Integer> children = graph.get(node);
        int childCount = 0;
        for (Integer child : children) {
            if (child == parent) {
                continue;
            }
            if (!visited[child]) {
                if (dfs(child, node, visited, timeOfInsertion, lowestTime, articulationPoint, graph, timer)) {
                    return true;
                }
                lowestTime[node] = Math.min(lowestTime[node], lowestTime[child]);
                if (lowestTime[child] >= timeOfInsertion[node] && parent != -1) {
                    articulationPoint[node] = 1;
                }
                childCount++;
            }
            else {
                lowestTime[node] = Math.min(lowestTime[node], timeOfInsertion[child]);
            }
        }
        if (parent == -1 && childCount > 1) {
            return true;
        }
        return false;
    }
    
    static List<List<Integer>> buildGraph(int [] arr, int n) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int i = 0;
        int length = arr.length;
        while (i < length) {
            int u = arr[i];
            int v = arr[i + 1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            i += 2;
        }
        return graph;
    }
    
}