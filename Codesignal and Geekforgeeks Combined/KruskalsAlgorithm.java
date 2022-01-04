Given a weighted, undirected and connected graph of V vertices and E edges. The task is to find the sum of weights of the edges of the Minimum Spanning Tree.

 

Example 1:

Input:

Output:
4
Explanation:

The Spanning Tree resulting in a weight
of 4 is shown above.
Example 2:

Input:

Output:
5
Explanation:
Only one Spanning Tree is possible
which has a weight of 5.
 

Your task:
Since this is a functional problem you don't have to worry about input, you just have to complete the function  spanningTree() which takes number of vertices V and an adjacency matrix adj as input parameters and returns an integer denoting the sum of weights of the edges of the Minimum Spanning Tree. Here adj[i] contains a list of lists containing two integers where the first integer a[i][0] denotes that there is an edge between i and a[i][0] and second integer a[i][1] denotes that the distance between edge i and a[i][0] is a[i][1].

Expected Time Complexity: O(ElogV).
Expected Auxiliary Space: O(V2).
 

Constraints:
2 ≤ V ≤ 1000
V-1 ≤ E ≤ (V*(V-1))/2
1 ≤ w ≤ 1000
Graph is connected and doesn't contain self loops & multiple edges.





class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Add your code here
        UnionFind uf = new UnionFind(v);
        ArrayList<Node> convert = new ArrayList<>();
        for (int i=0; i<v; i++) {
            ArrayList<ArrayList<Integer>> children = adj.get(i);
            for (ArrayList<Integer> child : children) {
                convert.add(new Node(i, child.get(0), child.get(1)));
            }
        }
        Collections.sort(convert, (c1, c2) -> Integer.compare(c1.weight, c2.weight));
        int total = 0;
        for (Node child : convert) {
            int src = child.src;
            int dest = child.dest;
            int weight = child.weight;
            if (uf.isConnected(src, dest)) {
                continue;
            }
            uf.union(src, dest);
            total += weight;
        }
        return total;
    }
}

class UnionFind {
    int size;
    int component;
    int [] parent;
    int [] rank;
    
    public UnionFind(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n cannot be less than or equal to 0");
        }
        size = n;
        component = n;
        parent = new int [n];
        rank = new int [n];
        for (int i=0; i<n; i++) {
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
        int parentP = find(p);
        int parentQ = find(q);
        if (parentP == parentQ) {
            return;
        }
        if (rank[parentQ] > rank[parentP]) {
            parent[parentP] = parentQ;
        }
        else {
            parent[parentQ] = parentP;
            if (rank[parentQ] == rank[parentP]) {
                rank[parentP] += 1;
            }
        }
        component--;
    }
    
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}

class Node {
    int src;
    int dest;
    int weight;
    public Node(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}