// question link : https://practice.geeksforgeeks.org/contest/interview-series-55/problems/#

// https://www.youtube.com/watch?v=XrniqNQe-R0

Given an undirected connected graph of n vertices and list of m edges in a graph and for each pair of vertices that are connected by an edge. 

There are two edges between them, one curved edge and one straight edge i.e. the tuple (x, y, w1, w2) means that between vertices x and y, there is a straight edge with weight w1 and a curved edge with weight w2.

You are given two vertices a and b and you have to go from a to b through a series of edges such that in the entire path you can use at most 1 curved edge. Your task is to find the shortest path from a to b satisfying the above condition. If there is no path from a to b, return -1.

 

Example 1:

Input:
n = 4, m = 4
a = 2, b = 4
edges = {{1, 2, 1, 4}, {1, 3, 2, 4},
         {1, 4, 3, 1}, {2, 4, 6, 5}}
Output:
2

Explanation:
We can follow the path 2 -> 1 -> 4.
This gives a distance of 1+3 = 4 if we follow
all straight paths. But we can take the curved
path  from 1 -> 4, which costs 1. This
will result in a cost of 1+1 = 2
Example 2:
Input:
n = 2, m = 1
a = 1, b = 2
edges = {{1, 2, 4, 1}}
Output :
1

Explanation:
Take the curved path from 1 to 2 which costs 1. 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function shortestPath() which takes 4 integers n, m, a, and b, and a list of lists named edges of size m as input and returns the cost of shortest path from a to b.


Expected Time Complexity: O((m+n)log(n))
Expected Auxiliary Space: O(n+m)


Constraints:
1 ≤ n,m ≤ 105
1 ≤ a,b ≤ n
weight of edges ≤ 104





//User function Template for Java



// we do dijskra from source to the node which have shortes curve weight
// then from there we again do the djikstra from that curved node to destination
class Solution {
    static int shortestPath(int n, int m, int a, int b, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        ArrayList<ArrayList<Integer>> curved = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
            //curved.add(new ArrayList<>());
        }
        for (ArrayList<Integer> edge : edges) {
            int x = edge.get(0);
            int y = edge.get(1);
            int straight = edge.get(2);
            int curve = edge.get(3);
            adj.get(x).add(new Pair(y, straight));
            adj.get(y).add(new Pair(x, straight));
            curved.add(new ArrayList<>(Arrays.asList(x, y, curve)));
        }
        //System.out.println(curved);
        int [] dist1 = djikstraHelper(n, a, b, adj);
        int [] dist2 = djikstraHelper(n, b, a, adj);
        int result = dist1[b];
        for (int i = 0; i < m; i++) {
            int x = curved.get(i).get(0);
            int y = curved.get(i).get(1);
            int curve = curved.get(i).get(2);
            result = Math.min(result, dist1[x] + curve + dist2[y]);
            result = Math.min(result, dist1[y] + curve + dist2[x]);
        }
        return result;
    }
    
    static int [] djikstraHelper(int n, int src, int dest, ArrayList<ArrayList<Pair>> edges) {
        int [] distance = new int [n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.weight, p2.weight));
        minHeap.offer(new Pair(src, 0));
        distance[src] = 0;
        while (!minHeap.isEmpty()) {
            Pair current = minHeap.poll();
            int node = current.node;
            // if (node == dest) {
            //     break;
            // }
            int weight = current.weight;
            ArrayList<Pair> children = edges.get(node);
            for (Pair child : children) {
                if (distance[node] + child.weight < distance[child.node]) {
                    distance[child.node] = distance[node] + child.weight;
                    minHeap.offer(new Pair(child.node, distance[child.node]));
                }
            }
        }
        return distance;
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