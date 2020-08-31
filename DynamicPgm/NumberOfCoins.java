Given a value V. You have to make change for V cents, given that you have infinite supply of each of C{ C1, C2, .. , Cm} valued coins. Find the minimum number of coins to make the change.

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case is V and N, V is the value of cents and N is the number of coins. The second line of each test case contains N input C[i], value of available coins.

Output:
Print the minimum number of coins to make the change, if not possible print "-1".

Constraints:
1 ≤ T ≤ 100
1 ≤ V ≤ 106
1 ≤ N ≤ 106
1 ≤ C[i] ≤ 106

Example:
Input:
1
7 2
2 1

Output:
4

Explanation :
Testcase 1: We can use coin with value 2 three times, and coin with value 1 one times to change a total of 7.


Solution:

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static int coinChange(int [] coins, int amount) {
        int n = coins.length;
        int [] dp = new int[amount+1];
        dp[0] = 0;
        for (int i=1; i<=amount; i++)
            dp[i] = Integer.MAX_VALUE;
        for (int i=1; i<=amount; i++) {
            for (int j=0; j<n; j++) {
                if (coins[j] <= i) {
                    int subResult = dp[i-coins[j]];
                    if (subResult != Integer.MAX_VALUE && subResult+1 < dp[i]) {
                        dp[i] = subResult + 1;
                    }
                }
            }
        }
        return dp[amount] > amount ? -1: dp[amount];
    }
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
		    int amount = sc.nextInt();
		    int numCoins = sc.nextInt();
		    int [] coins = new int[numCoins];
		    for (int i=0; i<numCoins; i++)
		        coins[i] = sc.nextInt();
		    System.out.println(coinChange(coins, amount));
		}
	}
}
