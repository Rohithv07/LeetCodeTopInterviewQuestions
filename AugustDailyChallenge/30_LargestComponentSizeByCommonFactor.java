Given a non-empty array of unique positive integers A, consider the following graph:

There are A.length nodes, labelled A[0] to A[A.length - 1];
There is an edge between A[i] and A[j] if and only if A[i] and A[j] share a common factor greater than 1.
Return the size of the largest connected component in the graph.

 

Example 1:

Input: [4,6,15,35]
Output: 4

Example 2:

Input: [20,50,9,63]
Output: 2

Example 3:

Input: [2,3,6,7,4,12,21,39]
Output: 8

Note:

1 <= A.length <= 20000
1 <= A[i] <= 100000




class Solution {
    int max = 0;
    public int largestComponentSize(int[] A) {
        boolean[] isPrime = new boolean[100001];
        Arrays.fill(isPrime, true);
        Set<Integer> primes = new HashSet<>();
        // all primes less than 100000
        for (int i = 2; i <= 100000; i++) {
            if (isPrime[i]) {
                primes.add(i);
                for (int j = 2; j * i <= 100000; j++) {
                    isPrime[j * i] = false;
                }
            }
        }
        int n = A.length;
        int[] counts = new int[n];
        int[] parents = new int[n];
        int[] primeToIndex = new int[100001];
        Arrays.fill(primeToIndex, -1);
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            counts[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            int a = A[i];
            for (int p : primes) {
                if (primes.contains(a)) { // Optimization
                    p = a;
                }
                if (a % p == 0) {
                    if (primeToIndex[p] > -1) {
                        union(parents, counts, primeToIndex[p], i);
                    }
                    primeToIndex[p] = i;
                    while (a % p == 0) {
                        a /= p;
                    }
                }
                if (a == 1) {
                    break;
                }
            }
        }
        return max;
    }
    private int find(int[] parents, int a) {
        if (parents[a] != a) {
            parents[a] = find(parents, parents[a]);
        }
        return parents[a];
    }
    private void union(int[] parents, int[] counts, int a, int b) {
        int root1 = find(parents, a), root2 = find(parents, b);
        if (root1 == root2) {
            return;
        }
        int count = counts[root2] + counts[root1];
        max = Math.max(count, max);
        parents[root1] = root2;
        counts[root2] = count;
    }
}
