Geek just learned about Fibonacci numbers.

The Fibonacci Sequence is the series of numbers: 0, 1, 1, 2, 3, 5, 8, 13, ...
where the next number is found by adding up the two numbers before it.

He defines a new series called Geeky numbers. Here the next number is the sum of the K preceding numbers.
You are given an array of size K, GeekNum[ ], where the ith element of the array represents the ith Geeky number. Return its Nth term.

Note: This problem can be solved in O(N2) time complexity but the user has to solve this in O(N). The Constraints are less because there can be integer overflow in the terms.

Example 1:

Input:
N = 6, K = 1
GeekNum[] = {4}
Output: 
4
Explanation: 
Terms are 4, 4, 4, 4, 4, 4
Example 2:

Input:
N = 5, K = 3
GeekNum[] = {0, 1, 2}
Output: 
6
Explanation: 
Terms are 0, 1, 2, 3, 6.
So the 5th term is 6
Your Task:  
You don't need to read input or print anything. Your task is to complete the function solve( ) which takes integer N, K, and an array GeekNum[] as input parameters and returns the Nth term of the Geeky series.

Expected Time Complexity: O(N)
Expected Space Complexity: O(N)

Constraints:
1 ≤ K < 30
1 ≤ N ≤ 70
K ≤ N
0 < GeekNum[ ] < 100


class Solution {
    static long solve(int n, int k, ArrayList<Long> geekNum) {
        //code here
        if (k == 1) {
            return geekNum.get(0);
        }
        if (n <= k) {
            return geekNum.get(k - 1);
        }
        int remaining = n - k;
        long sum = 0;
        for (long num : geekNum) {
            sum += num;
        }
        if (n == k) {
            return sum;
        }
        int index = 0;
        for (int i = 0; i < remaining - 1; i++) {
            geekNum.add(sum);
            sum -= geekNum.get(index++);
            sum += geekNum.get(geekNum.size() - 1);
        }
        return sum;
    }
}