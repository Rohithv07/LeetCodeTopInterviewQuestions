Given an integer array arr of size N, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum and find the minimum difference


Example 1:

Input: N = 4, arr[] = {1, 6, 11, 5} 
Output: 1
Explanation: 
Subset1 = {1, 5, 6}, sum of Subset1 = 12 
Subset2 = {11}, sum of Subset2 = 11   
Example 2:
Input: N = 2, arr[] = {1, 4}
Output: 3
Explanation: 
Subset1 = {1}, sum of Subset1 = 1
Subset2 = {4}, sum of Subset2 = 4

Your Task:  
You don't need to read input or print anything. Complete the function minDifference() which takes N and array arr as input parameters and returns the integer value


Expected Time Complexity: O(N*|sum of array elements|)
Expected Auxiliary Space: O(N*|sum of array elements|)


Constraints:
1 ≤ N*|sum of array elements| ≤ 106



class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    if (arr == null || n == 0)
	        return 0;
	    int sum = getSum(arr);
	    int minimumDiff = Integer.MAX_VALUE;
	    boolean [][] dp = new boolean [n + 1][sum + 1];
	    for (int i=0; i<=n; i++) {
	        dp[i][0] = true;
	    }
	    for (int j=1; j<=sum; j++) {
	        dp[0][j] = false;
	    }
	    for (int i=1; i<=n; i++) {
	        for (int j=1; j<=sum; j++) {
	            // total ignore
	            if (arr[i - 1] > j) {
	                dp[i][j] = dp[i - 1][j];
	            }
	            // else 2 option, ignore or include
	            else {
	                dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
	            }
	        }
	    }
	    // now we need that j from sum / 2 to 0 such that dp[n][j] = true
	    // then sum - 2 * j is the answer
	    for (int j=sum/2; j>=0; j--) {
	        if (dp[n][j] == true) {
	            minimumDiff = sum - 2 * j;
	            break;
	        }
	    }
	    return minimumDiff;
	} 
	
	public int getSum(int [] arr) {
	    int sum = 0;
	    for (int number : arr) {
	        sum += number;
	    }
	    return sum;
	}
}
