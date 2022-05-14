You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

 

Example 1:


Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2
Example 2:

Input: times = [[1,2,1]], n = 2, k = 1
Output: 1
Example 3:

Input: times = [[1,2,1]], n = 2, k = 2
Output: -1
 

Constraints:

1 <= k <= n <= 100
1 <= times.length <= 6000
times[i].length == 3
1 <= ui, vi <= n
ui != vi
0 <= wi <= 100
All the pairs (ui, vi) are unique. (i.e., no multiple edges.)


class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        List<int []>[] adj = buildGraph(times, N);
        int [] distance = new int [N];
        Arrays.fill(distance, -1);
        int maximumDistance = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int [] {K-1, 0});
        distance[K-1] = 0;
        while (!queue.isEmpty()) {
            int currentSource = queue.remove()[0];
            for (int [] edge : adj[currentSource]) {
                int currentTarget = edge[0];
                int currentWeight = edge[1];
                int dist = distance[currentSource] + currentWeight;
                if (distance[currentTarget] == -1 || distance[currentTarget] > dist) {
                    distance[currentTarget] = dist;
                    queue.add(new int [] {currentTarget, dist});
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (distance[i] == -1)
                return -1;
            maximumDistance = Math.max(maximumDistance, distance[i]);
        }
        return maximumDistance;
    }
    
    public List<int[]>[] buildGraph(int [][] times, int N) {
        List<int[]>[] graph = new ArrayList[N];
        for (int i=0; i<N; i++)
            graph[i] = new ArrayList();
        for (int [] time : times)
            graph[time[0] - 1].add(new int [] {time[1] - 1, time[2]});
        return graph;
    }
}