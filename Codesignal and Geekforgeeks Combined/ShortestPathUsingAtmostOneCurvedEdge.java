// question link : https://practice.geeksforgeeks.org/contest/interview-series-55/problems/#

// https://www.youtube.com/watch?v=XrniqNQe-R0







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