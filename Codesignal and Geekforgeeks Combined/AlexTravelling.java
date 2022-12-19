Alex is very fond of traveling. There are n cities, labeled from 1 to n.  You are also given flights, a list of travel flights as directed weighted edges flights[i] = (ui,vi,wi) where ui is the source node, vi is the target node, and wi is the price it takes for a person to travel from source to target.
Currently, Alex is in k'th city and wants to visit one city of his choice. Return the minimum money Alex should have so that he can visit any city of his choice from k'th city. If there is a city that has no path from k'th city, which means Alex can't visit that city, return -1. 
Alex always takes the optimal path. He can any city via another city by taking multiple flights.
 

Example 1:

Input:
n: 4
k: 2
flights size: 3
flights: [[2,1,1],[2,3,1],[3,4,1]]
Output:
2
Explanation:
to visit 1 from 2 takes cost 1
to visit 2 from 2 takes cost 0
to visit 3 from 2 takes cost 1
to visit 4 from 2 takes cost 2,
2->3->4
So if Alex wants to visit city 4
from 2, he needs 2 units of money


Example 2:

Input:
n: 4 
k: 3 
flights size: 3 
flights: [[2,1,1],[2,3,1],[3,4,1]] 
Output: -1
Explanation:
There is no direct or indirect path 
to visit city 2 and 1 from city 3


Your Task:

You don't need to print or input anything. Complete the function minimumCost() which takes a  flights array, an integer n and an integer k as the input parameters and returns an integer, denoting the minimum money Alex should have so that he can visit any city of his choice from k'th city.

Expected Time Complexity: O((V+E) log V), here V is number of cities and E is number of flights. 
Expected Auxiliary Space: O(V+E), here V is number of cities and E is number of flights. 

Constraints:

2 <= n <= 500
1 <= flights.length <= 100000
flights[i].length == 3
1 <= ui, vi, k<= n
ui != vi
1 <= wi <= 100
All the pairs (ui, vi) are unique. (i.e., no multiple edges)


class Solution {

    int minimumCost(int[][] flights, int n, int k) {
        // Your code here
        List<List<Pair>> graph = buildGraph(flights, n);
        int [] distance = new int [n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.weight, p2.weight));
        minHeap.offer(new Pair(k, 0));
        while (!minHeap.isEmpty()) {
            Pair currentPair = minHeap.poll();
            int currentNode = currentPair.node;
            int currentMoney = currentPair.weight;
            List<Pair> children = graph.get(currentNode);
            for (Pair child : children) {
                int childNode = child.node;
                int childMoney = child.weight;
                if (distance[currentNode] + childMoney < distance[childNode]) {
                    distance[childNode] = distance[currentNode] + childMoney;
                    minHeap.offer(new Pair(childNode, distance[childNode]));
                }
            }
        }
        int maxSpend = -1;
        for (int i = 1; i <= n; i++) {
            //System.out.print(distance[i] + " ");
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxSpend = Math.max(distance[i], maxSpend);
        }
        return maxSpend;
    }
    
    List<List<Pair>> buildGraph(int [][] flights, int n) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int [] flight : flights) {
            graph.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
        return graph;
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
