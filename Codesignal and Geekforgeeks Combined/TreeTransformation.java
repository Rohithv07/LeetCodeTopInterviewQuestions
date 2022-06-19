
// question link : https://practice.geeksforgeeks.org/contest/interview-series-55/problems/#

// https://www.youtube.com/watch?v=XrniqNQe-R0


class Solution {
    public static int solve(int n, int[] p) {
        // code here
        // answer will be totalNode - leafNodes - 1
        
        // hash the number of edges from each node.
        // leaf node will be those with only 1 edge as its undirected
        int [] count = new int [n + 1];
        int leafNode = 0;
        for (int i = 1; i < n; i++) {
            count[i] += 1;
            count[p[i]] += 1;
        }
        for (int i = 0; i < n; i++) {
            if (count[i] == 1) {
                leafNode++;
            }
        }
        int result = n - leafNode - 1;
        return Math.max(result, 0);
        
    }
}
        
