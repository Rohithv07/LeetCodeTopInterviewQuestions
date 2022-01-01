Given a Graph of V vertices and E edges and another edge(c - d), the task is to find if the given edge is a Bridge. i.e., removing the edge disconnects the graph.

 

Example 1:

Input:

c = 1, d = 2
Output:
1
Explanation:
From the graph, we can clearly see that
blocking the edge 1-2 will result in 
disconnection of the graph. So, it is 
a Bridge and thus the Output 1.

Example 2:

Input:

c = 0, d = 2
Output:
0
Explanation:

blocking the edge between nodes 0 and 2
won't affect the connectivity of the graph.
So, it's not a Bridge Edge. All the Bridge
Edges in the graph are marked with a blue
line in the above image.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function isBridge()  which takes number of vertices V, the number of edges E, an adjacency lsit adj and two integers c and d denoting the edge as input parameters and returns 1 if the given edge c-d is a Bridge. Else, it returns 0.

 

Expected Time Complexity: O(V + E).
Expected Auxiliary Space: O(V).

 

Constraints:
1 ≤ V,E ≤ 105
0 ≤ c, d ≤ V-1


// solution by altering the graph
class Solution
{
    //Function to find if the given edge is a bridge in graph.
    static int isBridge(int v, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        // code here
        adj.get(c).remove(new Integer(d));
        adj.get(d).remove(new Integer(c));
        boolean [] visited = new boolean [v];
        dfs(adj, visited, c);
        return visited[d] ?  0 :  1;
    }
    
    static void dfs(ArrayList<ArrayList<Integer>> adj, boolean [] visited, int node) {
        visited[node] = true;
        ArrayList<Integer> children = adj.get(node);
        for (Integer child : children) {
            if (!visited[child]) {
                dfs(adj, visited, child);
            }
        }
    }
}


// our standard answer for the bridge problem : https://youtu.be/2rjZH0-2lhk


class Solution
{
    //Function to find if the given edge is a bridge in graph.
    static int isBridge(int v, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        // code here
        boolean [] visited = new boolean [v];
        int [] timeOfInsertion = new int [v];
        int [] lowestTime = new int [v];
        int timer = 0;
        for (int i=0; i<v; i++) {
            if (!visited[i]) {
                if (isBridgeFoundAtCD(i, -1, visited, timeOfInsertion, lowestTime, adj, timer, c, d)) {
                    return 1;
                }
            }
        }
        return 0;
    }
    
    static boolean isBridgeFoundAtCD(int node, int parent, boolean [] visited, int [] timeOfInsertion, int [] lowestTime, ArrayList<ArrayList<Integer>>adj, int timer, int c, int d) {
        visited[node] = true;
        timeOfInsertion[node] = lowestTime[node] = timer++;
        ArrayList<Integer> children =adj.get(node);
        for (Integer child : children) {
            if (child == parent) {
                continue;
            }
            if (!visited[child]) {
                if (isBridgeFoundAtCD(child, node, visited, timeOfInsertion, lowestTime, adj, timer, c, d)) {
                    return true;
                }
                lowestTime[node] = Math.min(lowestTime[node], lowestTime[child]);
                if (lowestTime[child] > timeOfInsertion[node]) {
                    if ((child == c && node == d) || (child == d && node == c)) {
                        return true;
                    }
                }
            }
            else {
                lowestTime[node] = Math.min(lowestTime[node], timeOfInsertion[child]);
            }
        }
        return false;
    }
}