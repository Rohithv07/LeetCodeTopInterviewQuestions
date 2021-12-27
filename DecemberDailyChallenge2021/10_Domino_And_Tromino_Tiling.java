You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.


Given an integer n, return the number of ways to tile an 2 x n board. Since the answer may be very large, return it modulo 109 + 7.

In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.

 

Example 1:


Input: n = 3
Output: 5
Explanation: The five different ways are show above.
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 1000


class Solution {
    public int numTilings(int n) {
        if (n <= 2) {
            return n;
        }
        int mod = (int)1e9 + 7;
        long [] f = new long [n + 1];
        long [] p = new long [n + 1];
        f[1] = 1;
        f[2] = 2;
        p[2] = 1;
        for (int i=3; i<=n; i++) {
            f[i] = (f[i - 1] + f[i - 2] + 2 * p[i - 1]) % mod;
            p[i] = (p[i - 1] + f[i - 2]) % mod;
        }
        return (int)(f[n]);
    }
}