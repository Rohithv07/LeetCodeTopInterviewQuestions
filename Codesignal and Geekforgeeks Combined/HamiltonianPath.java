A Hamiltonian path, is a path in an undirected graph that visits each vertex exactly once. Given an undirected graph, the task is to check if a Hamiltonian path is present in it or not.

Example 1:

Input:
N = 4, M = 4
Edges[][]= { {1,2}, {2,3}, {3,4}, {2,4} }
Output:
1 
Explanation: 
There is a hamiltonian path: 
1 -> 2 -> 3 -> 4 
Example 2:

Input:
N = 4, M = 3 
Edges[][] = { {1,2}, {2,3}, {2,4} } 
Output: 
0 
Explanation: 
It can be proved that there is no 
hamiltonian path in the given graph
Your task:
You don't need to read input or print anything. Your task is to complete the function check() which takes the N (the number of vertices), M (Number of edges) and the list of Edges[][] (where Edges[i] denotes the undirected Edge between vertices Edge[i][0] and Edges[i][1] ) as input parameter and returns true (boolean value) if the graph contains Hamiltonian path,otherwise returns false. 


Expected Time Complexity: O(N!).
Expected Auxiliary Space: O(N+M).


Constraints:
1 ≤ N ≤ 10
1 ≤ M ≤ 15
Size of Edges[i] is 2
1 ≤ Edges[i][0],Edges[i][1] ≤ N


//User function Template for Java
class Solution 
{ 
    boolean check(int n, int m, ArrayList<ArrayList<Integer>> edges) 
    { 
        // code here
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (ArrayList<Integer> edge : edges) {
            int node1 = edge.get(0);
            int node2 = edge.get(1);
            graph[node1].add(node2);
            graph[node2].add(node1);
        }
        for (int i = 1; i <= n; i++) {
            if (isHamiltonianCheck(graph, i, set)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isHamiltonianCheck(ArrayList<Integer> [] graph, int node, Set<Integer> set) {
        set.add(node);
        if (set.size() == graph.length - 1) {
            return true;
        }
        ArrayList<Integer> children = graph[node];
        for (Integer child : children) {
            if (!set.contains(child)) {
                if (isHamiltonianCheck(graph, child, set)) {
                    return true;
                }
            }
        }
        set.remove(node);
        return false;
    }
} 