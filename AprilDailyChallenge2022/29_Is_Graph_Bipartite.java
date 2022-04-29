There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:

There are no self-edges (graph[u] does not contain u).
There are no parallel edges (graph[u] does not contain duplicate values).
If v is in graph[u], then u is in graph[v] (the graph is undirected).
The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.

Return true if and only if it is bipartite.

 

Example 1:


Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
Output: false
Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.
Example 2:


Input: graph = [[1,3],[0,2],[1,3],[0,2]]
Output: true
Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.
 

Constraints:

graph.length == n
1 <= n <= 100
0 <= graph[u].length < n
0 <= graph[u][i] <= n - 1
graph[u] does not contain u.
All the values of graph[u] are unique.
If graph[u] contains v, then graph[v] contains u.

// dfs
class Solution {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return true;
        }
        int length = graph.length;
        int [] color = new int [length];
        for (int i = 0; i < length; i++) {
            if (color[i] == 0 && !dfs(graph, i, color, 1)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int [][] graph, int node, int [] color, int toColor) {
        if (color[node] != 0) {
            return color[node] == toColor;
        }
        color[node] = toColor;
        int [] vertices = graph[node];
        for (int vertex : vertices) {
            if (!dfs(graph, vertex, color, -toColor)) {
                return false;
            }
        }
        return true;
    }
}

// bfs

class Solution {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return true;
        }
        int length = graph.length;
        int [] color = new int [length];
        for (int i = 0; i < length; i++) {
            if (color[i] == 0 && !bfs(graph, i, color)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean bfs(int [][] graph, int node, int [] color) {
        color[node] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            int [] children = graph[current];
            for (int child :children) {
                if (color[child] == 0) {
                    color[child] = color[current] == 1 ? 2 : 1;
                    queue.offer(child);
                }
                else {
                    if (color[child] == color[current]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}


// union

class Solution {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return true;
        }
        int length = graph.length;
        UnionFind uf = new UnionFind(length);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (uf.isConnected(i, graph[i][j])) {
                    return false;
                }
                uf.union(graph[i][0], graph[i][j]);
            }
        }
        return true;
    }
}

class UnionFind {
    int size;
    int component;
    int [] parent;
    int [] rank;
    public UnionFind(int n) {
        this.size = n;
        this.component = n;
        parent = new int [n];
        rank = new int [n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        if (rank[rootQ] > rank[rootP]) {
            parent[rootP] = rootQ;
        }
        else {
            parent[rootQ] = rootP;
            if (rank[rootP] == rank[rootQ]) {
                rank[rootP] += 1;
            }
        }
        component--;
    }
    
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}