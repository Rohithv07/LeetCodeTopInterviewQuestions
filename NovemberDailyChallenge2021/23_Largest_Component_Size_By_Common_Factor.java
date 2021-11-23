You are given an integer array of unique positive integers nums. Consider the following graph:

There are nums.length nodes, labeled nums[0] to nums[nums.length - 1],
There is an undirected edge between nums[i] and nums[j] if nums[i] and nums[j] share a common factor greater than 1.
Return the size of the largest connected component in the graph.

 

Example 1:


Input: nums = [4,6,15,35]
Output: 4
Example 2:


Input: nums = [20,50,9,63]
Output: 2
Example 3:


Input: nums = [2,3,6,7,4,12,21,39]
Output: 8
 

Constraints:

1 <= nums.length <= 2 * 104
1 <= nums[i] <= 105
All the values of nums are unique.


class Solution {
    public int largestComponentSize(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int maxValue = -1;
        for (int number : nums) {
            maxValue = Math.max(maxValue, number);
        }
        UnionFind uf = new UnionFind(maxValue + 1);
        for (int number : nums) {
            for (int j=2; j*j<=number; j++) {
                if (number % j == 0) {
                    uf.union(number, j);
                    uf.union(number, number / j);
                }
            }
        }
        Map<Integer, Integer> track = new HashMap<>();
        int result = 0;
        for (int number : nums) {
            int value = uf.find(number);
            track.put(value, track.getOrDefault(value, 0) + 1);
            result = Math.max(result, track.get(value));
        }
        return result;
    }
}

class UnionFind {
    int size;
    int component;
    int [] parent;
    int [] rank;
    UnionFind(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("No Applicable");
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
            if (rank[rootQ] == rank[rootP]) {
                rank[rootP]++;
            }
        }
        component--;
    }
    
    public int getComponent() {
        return component;
    }
}