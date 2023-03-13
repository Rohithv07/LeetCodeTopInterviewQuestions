We have been given N balloons, each with a number of coins associated with it. On bursting a balloon i, the number of coins gained is equal to A[i-1]*A[i]*A[i+1].
Also, balloons i-1 and i+1 now become adjacent. Find the maximum possible profit earned after bursting all the balloons. Assume an extra 1 at each boundary.

Example 1:

Input: 
N=2
a[]={5, 10}
Output: 
60
Explanation: First Burst 5, Coins = 1*5*10
              Then burst 10, Coins+= 1*10*1
              Total = 60
Example 2:

Input:
N=4
a[] = {3,1,5,8}
Output:
167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function maxCoins() which takes the array arr[], its size N, and returns the maximum number of coins that can be collected.

Expected Time Complexity: O(N^3)
Expected Space Complexity: O(N^2)

Constraints:
1 <= N <= 400
0 <= a[i] <= 100


// https://practice.geeksforgeeks.org/contest/interview-series-44/problems/


class Solution{
    int maxCoins(ArrayList<Integer> arr, int n) {
		//Write your code here
		int [] extraSpaceIncluded = new int [n + 2];
		extraSpaceIncluded[0] = extraSpaceIncluded[n + 1] = 1;
		for (int i = 1; i <= n; i++) {
		    extraSpaceIncluded[i] = arr.get(i - 1);
		}
		int [][] dp = new int [n + 2][n + 2];
		for (int i = 1; i <= n; i++) {
		    for (int left = 1; left < n - i + 2; left++) {
		        int right = left + i - 1;
		        for (int p = left; p < right + 1; p++) {
		            dp[left][right] = Math.max(
		                dp[left][right],
		                dp[left][p - 1] + 
		                extraSpaceIncluded[left - 1] * extraSpaceIncluded[p] * extraSpaceIncluded[right + 1] + dp[p + 1][right]);
		        }
		    }
		}
		return dp[1][n];
	}
}


// matrix chain multiplication variant

// https://youtu.be/AWyGB-P90sg

//User function Template for Java

class Solution{
    int maxCoins(ArrayList<Integer> arr, int n) {
		//Write your code here
		int [] extraSpaceIncluded = new int [n + 2];
		extraSpaceIncluded[0] = extraSpaceIncluded[n + 1] = 1;
		for (int i = 1; i <= n; i++) {
		    extraSpaceIncluded[i] = arr.get(i - 1);
		}
		int [][] dp = new int [n + 2][n + 2];
		for (int i = n; i > 0; i--) {
		    for (int j = i; j <= n; j++) {
		        for (int k = i; k <= j; k++) {
		            dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + dp[k + 1][j] + 
		            extraSpaceIncluded[k] * extraSpaceIncluded[i - 1] * 
		            extraSpaceIncluded[j + 1]);
		        }
		    }
		}
		return dp[1][n];
	}
}