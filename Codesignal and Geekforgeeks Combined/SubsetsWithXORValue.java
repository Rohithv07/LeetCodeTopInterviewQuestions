Given an array arr of N integers and an integer K, find the number of subsets of arr having XOR of elements as K.
 

Example 1:

Input:
N = 4
k = 6
arr: 6 9 4 2
Output:
2
Explanation:
The subsets are 
{4,2} and {6}
Example 2:

Input:
N = 5
K = 4
arr: 1 2 3 4 5
Output:
4
Explanation:
The subsets are {1, 5},
{4}, {1, 2, 3, 4},
and {2, 3, 5}

Your Task:
You don't need to read input or print anything. Your task is to complete the function subsetXORâ€‹() which takes the array arr[], its size N and an integer K as input parameters and returns the number of subsets having xor as K
 

Expected Time Complexity: O(N*M)
Expected Space Complexity: O(N*M)
Note: M = maximum value any XOR subset will acquire
 

Constraints:
1<=N<=20
1<=K<=100
0<=arr[i]<=100



class Solution{
    static int subsetXOR(int arr[], int n, int k) {
        // code here
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int m = 10 * max;
        int [][] dp = new int [n + 1][m + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] += dp[i - 1][j];
                if ((j ^ arr[i - 1]) <= m) {
                    dp[i][j] += dp[i - 1][j ^ arr[i - 1]];
                }
            }
        }
        return dp[n][k];
    }
}
