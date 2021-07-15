We define f (X, Y) as number of different corresponding bits in binary representation of X and Y. For example, f (2, 7) = 2, since binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit differ, so f (2, 7) = 2.

You are given an array A of N integers, A1, A2 ,…, AN. Find sum of f(Ai, Aj) for all ordered pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.

Example 1:

Input: N = 2
A = {2, 4}
Output: 4
Explaintion: We return 
f(2, 2) + f(2, 4) + 
f(4, 2) + f(4, 4) = 
0 + 2 + 
2 + 0 = 4.
Example 2:

Input: N = 3
A = {1, 3, 5}
Output: 8
Explaination: We return 
f(1, 1) + f(1, 3) + f(1, 5) + 
f(3, 1) + f(3, 3) + f(3, 5) + 
f(5, 1) + f(5, 3) + f(5, 5) = 
0 + 1 + 1 + 
1 + 0 + 2 + 
1 + 2 + 0 = 8.
Your Task:
You do not need to read input or print anything. Your task is to complete the function countBits() which takes the value N and the array A as input parameters and returns the desired count modulo 109+7.

Expected Time Complexity: O(N * log2(Max(Ai)))
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105
20 ≤ A[i] < 231

class Solution{
    static int countBits(int n, long a[])
    {
        // code here
        if (a == null || n == 0)
            return 0;
        int mod = (int) 1e9 + 7;
        long result = 0l;
        for (int i=0; i<32; i++) {
            long count = 0l;
            for (int j=0; j<n; j++) {
                if ((a[j] & (1 << i)) == 0)
                    count += 1;
            }
            result = (result + (count * (n - count) * 2)) % mod;
        }
        return (int)(result % mod);
    }
}