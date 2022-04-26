You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.

Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.

 

Example 1:


Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
Output: 20
Explanation: 

We can connect the points as shown above to get the minimum cost of 20.
Notice that there is a unique path between every pair of points.
Example 2:

Input: points = [[3,12],[-2,5],[-4,1]]
Output: 18
 

Constraints:

1 <= points.length <= 1000
-106 <= xi, yi <= 106
All pairs (xi, yi) are distinct.



// Kruskals algorithm
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<Node> graph = buildGraph(points);
        UnionFind uf = new UnionFind(n);
        Collections.sort(graph, (g1, g2) -> Integer.compare(g1.weight, g2.weight));
        int cost = 0;
        int edgesUsed = 0; // we only need to look for n - 1 edges.
        for (Node node : graph) {
            int source = node.source;
            int destination = node.destination;
            int weight = node.weight;
            if (uf.isConnected(source, destination)) {
                continue;
            }
            uf.union(source, destination);
            cost += weight;
            edgesUsed++;
            if (edgesUsed >= n - 1) {
                break;
            } // this is an optimization step
        }
        return cost;
    }
    
    public List<Node> buildGraph(int [][] points) {
        List<Node> graph = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int source = i;
                int destination = j;
                int weight = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                graph.add(new Node(source, destination, weight));
            }
        }
        return graph;
    }
}

class UnionFind {
    int size;
    int component;
    int [] parent;
    int [] rank;
    public UnionFind(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Cannot be zero or negative");
        }
        size = n;
        component = n;
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

class Node {
    int weight;
    int source;
    int destination;
    public Node(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}