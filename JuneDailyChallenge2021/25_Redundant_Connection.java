In this problem, a tree is an undirected graph that is connected and has no cycles.

You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.

 

Example 1:


Input: edges = [[1,2],[1,3],[2,3]]
Output: [2,3]
Example 2:


Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
Output: [1,4]
 

Constraints:

n == edges.length
3 <= n <= 1000
edges[i].length == 2
1 <= ai < bi <= edges.length
ai != bi
There are no repeated edges.
The given graph is connected.

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int length = edges.length;
        UnionFind uf = new UnionFind(length);
        int component = uf.getComponent();
        for (int [] edge: edges) {
            int p1 = uf.find(edge[0] - 1);
            int p2 = uf.find(edge[1] - 1);
            if (p1 == p2) {
                return new int [] {edge[0], edge[1]};
            }
            else {
                uf.union(edge[0] - 1, edge[1] - 1);
            }
        }
        return new int [] {};
    }
}

class UnionFind {
    int component;
    int size;
    int [] parent;
    int [] rank;
    UnionFind(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("n can't be negative");
        size = n;
        component = n;
        parent = new int [n];
        rank = new int [n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
    }
    
    int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    
    void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ)
            return;
        if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        }
        else {
            parent[rootQ] = rootP;
            if (rank[rootP] == rank[rootQ]) {
                rank[rootP] += 1;
            }
        }
        component -= 1;
    }
    
    int getComponent() {
        return component;
    }
}

// same method but by using the change in component becuase after union, the component changes, so we can make use of this propety to find redundant

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        for (int [] edge : edges) {
            int component = uf.getComponent();
            uf.union(edge[0] - 1, edge[1] - 1);
            if (component == uf.getComponent())
                return new int [] {edge[0], edge[1]};
        }
        return new int [] {};
    }
    
}

class UnionFind {
    int size;
    int component;
    int [] parent;
    int [] rank;
    UnionFind(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("n cant be zero or negative");
        size = n;
        component = n;
        parent = new int [n];
        rank = new int [n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
    }
    
    int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    
    void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        }
        else {
            parent[rootQ] = rootP;
            if (rank[rootP] == rank[rootQ]) {
                rank[rootP] += 1;
            }
        }
        component -= 1;
    }
    
    int getComponent() {
        return component;
    }
}



class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        if (edges.length == 0)
            return null;
        int [] parent = new int[edges.length+1];
        for (int i=0; i<edges.length+1; i++)
            parent[i] = -1;
        for (int []edge:edges) {
            int x = find(parent, edge[0]);
            int y = find(parent, edge[1]);
            if (x == y)
                return new int[]{edge[0], edge[1]};
            else
                union(parent, x, y);
        }
        return null;
    }
    public int find(int [] parent, int v) {
        if (parent[v] == -1)
            return v;
        return find(parent, parent[v]);
    }
    public void union(int [] parent, int x, int y) {
        int xSet = find(parent, x);
        int ySet = find(parent, y);
        parent[xSet] = ySet;
    }   
}



