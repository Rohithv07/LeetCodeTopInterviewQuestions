/*
You have d dice and each die has f faces numbered 1, 2, ..., f.

Return the number of possible ways (out of fd total ways) modulo 109 + 7 to roll the dice so the sum of the face-up numbers equals target.

 

Example 1:

Input: d = 1, f = 6, target = 3
Output: 1
Explanation: 
You throw one die with 6 faces.  There is only one way to get a sum of 3.
Example 2:

Input: d = 2, f = 6, target = 7
Output: 6
Explanation: 
You throw two dice, each with 6 faces.  There are 6 ways to get a sum of 7:
1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
Example 3:

Input: d = 2, f = 5, target = 10
Output: 1
Explanation: 
You throw two dice, each with 5 faces.  There is only one way to get a sum of 10: 5+5.
Example 4:

Input: d = 1, f = 2, target = 3
Output: 0
Explanation: 
You throw one die with 2 faces.  There is no way to get a sum of 3.
Example 5:

Input: d = 30, f = 30, target = 500
Output: 222616187
Explanation: 
The answer must be returned modulo 10^9 + 7.
 

Constraints:

1 <= d, f <= 30
1 <= target <= 1000

*/



import java.util.*;

public class RollTheDice {

	public static int numberOfDiceWithTarget(int d, int f, int target) {
		int mod = (int) 1e9 + 7;
		int [][] dp = new int [d + 1][target + 1];
		for (int i=0; i<=d; i++) {
			Arrays.fill(dp[i], -1);
		}
		return memoisation(d, f, target, dp, mod);
	}

	public static int memoisation(int d, int f, int target, int [][] dp, int mod) {
		if (d == 0 && target == 0) {
			return 1;
		}
		if (d > target || d * f < target)
			return 0;
		if (dp[d][target] != -1)
			return dp[d][target] % mod;
		int result = 0;
		for (int i=1; i<=f && i<=target; i++) {
			if (target - i >= 0) {
				result = (result + memoisation(d - 1, f, target - i, dp, mod)) % mod;
			}
			else {
				break;
			}
		}
		return dp[d][target] = result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int d = sc.nextInt();
		int f = sc.nextInt();
		int target = sc.nextInt();
		System.out.println(numberOfDiceWithTarget(d, f, target));
	}
}

// tabular code

// dp approach
        int mod = (int)1e9 + 7;
        long [][] dp = new long [d + 1][target + 1];
        dp[0][0] = 1l;
        for (int i=1; i<=d; i++) {
            for (int j=0; j<=target; j++) {
                for (int k=1; k<=f; k++) {
                    if (j >= k) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % mod;
                    }
                    else {
                        break;
                    }
                }
            }
        }
        return (int)(dp[d][target] % mod);