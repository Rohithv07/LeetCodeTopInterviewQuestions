/*
Given an array arr[] of length N and an integer X, the task is to find the number of subsets with a sum equal to X.

Examples: 

Input: arr[] = {1, 2, 3, 3}, X = 6 
Output: 3 
All the possible subsets are {1, 2, 3}, 
{1, 2, 3} and {3, 3}
 

Input: arr[] = {1, 1, 1, 1}, X = 1 
Output: 4 
*/

import java.util.*;

public class CountSubsetsWithGivenSum {

	// when we have leading zeroes.
	public static int countSubset(int [] nums, int n, int x, int count) {
		if (nums == null || n == 0)
			return 0;
		int [][] dp = new int [n + 1][x + 1];
		for (int i=0; i<=x; i++) {
			dp[0][i] = 0;
		}
		for (int i=0; i<=n; i++) {
			dp[i][0] = 1;
		}
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=x; j++) {
				// skip
				if (nums[i - 1] > j || nums[i - 1] == 0) {
					dp[i][j] = dp[i - 1][j];
				}
				else {
					// summation
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
				}
			}
		}
		return dp[n][x] * (int)Math.pow(2, count);
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		int count = 0;
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
			if (nums[i] == 0)
				count++;
		}
		int x = sc.nextInt();
		System.out.println(countSubset(nums, n, x, count));
	}
}


/*
Note : 
For those who has problem with test case  [0,0,0,0,0,0,0,0,1], target = 1.
According to Mazhar Imam Khan, 
The solution doesn't consider presence of "0"s in the array. Why the output is different ?
Because, if we have "0", then, it can have +0 and -0 and still will not effect the sum of a set. For example: Target value is = 2
1) {0,2} = {+0,2}, {-0,2}.  Ans: 2
But if we increase number of 0s,
2) {0,0,2} = {+0,+0,2}, {+0,-0,2}, {-0,+0,2},{-0,-0,2} . Ans: 4

So, if you observe, your answer increase by (2^number of 0s) i.e. pow(2,number of zeros).
So, make a small change as follows:
1) on count of subsetsum function, 
if(nums[i-1] > j )    => change to:  if (nums[i-1] > j || nums[i-1] == 0)
      dp[i][j] = dp[i-1][j];
 //make no change and put the previous value as it is in the next subproblem. (I.e. 2, in example above)
And then at the end, you answer will be
return (int)Math.pow(2, number of 0s) * dp[nums.length][target] ;

Also, other cases we need to handle is:
if (S > sum || (sum + S) % 2 != 0){ //S is target

            return 0;
 }
 */