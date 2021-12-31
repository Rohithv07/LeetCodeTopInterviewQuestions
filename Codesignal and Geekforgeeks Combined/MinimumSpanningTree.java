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



// User function Template for Java

class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Add your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>(new MyComparator());
        boolean [] visited = new boolean [v];
        pq.offer(new Pair(0, 0));
        int minCost = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int n = pair.n;
            int weight = pair.weight;
            if (!visited[n]) {
                visited[n] = true;
                minCost += weight;
            }
            for (ArrayList<Integer> children : adj.get(n)) {
                if (!visited[children.get(0)]) {
                    pq.offer(new Pair(children.get(1), children.get(0)));
                }
            }
        }
        return minCost;
    }
}

class Pair {
    int weight;
    int n;
    Pair(int weight, int n) {
        this.weight = weight;
        this.n = n;
    }
}

class MyComparator implements Comparator<Pair> {
    public int compare(Pair p1, Pair p2) {
        return Integer.compare(p1.weight, p2.weight);
    }
}





// another way
class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Add your code here
        if (v == 0 || adj == null || adj.size() == 0) {
            return 0;
        }
        int [] key = new int [v];
        boolean [] mst = new boolean [v];
        int [] parent = new int [v];
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        int mstTotalWeight = 0;
        key[0] = 0;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.weight, p2.weight));
        minHeap.offer(new Pair(0, key[0]));
        while (!minHeap.isEmpty()) {
            Pair currentPair = minHeap.poll();
            int currentNode = currentPair.node;
            int currentWeight = currentPair.weight;
            mst[currentNode] = true;
            ArrayList<ArrayList<Integer>> children = adj.get(currentNode);
            for (ArrayList<Integer> child : children) {
                int childNode = child.get(0);
                int childWeight = child.get(1);
                if (!mst[childNode] && key[childNode] > childWeight) {
                    key[childNode] = childWeight;
                    parent[childNode] = currentNode;
                    minHeap.offer(new Pair(childNode, key[childNode]));
                }
            }
        }
        for (int number : key) {
            mstTotalWeight += number;
        }
        return mstTotalWeight;
    }
}

class Pair {
    int node;
    int weight;
    public Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}
