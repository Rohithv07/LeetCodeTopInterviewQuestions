Given an array arr[] of N elements. Find the number of non-empty subsets whose product of elements is less than or equal to a given integer K.

 

Example 1:

Input:
N = 4
arr[] = {2, 4, 5, 3}
K = 12
Output:
8
Explanation:
All possible subsets whose 
products are less than 12 are:
(2), (4), (5), (3), (2, 4), (2, 5), (2, 3), (4, 3)
Example 2:
Input:
N = 3
arr[] = {9, 8, 3}
K = 2 
Output:
0
Explanation:
There is no subsets with product less
than or equal to 2.


Your Task:  
You don't need to read input or print anything. Your task is to complete the function numOfSubsets() which takes 2 integers N, and K, and an array arr of size N as input and returns the number of subsets with product less equal to K.


Expected Time Complexity: O(N*2N/2)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 30
1 ≤ arr[i] ≤ 10
1 ≤ K ≤ 106

class Solution {
    static int numOfSubsets(int[] arr, int N, int K) {
        // code here
        int [][] dp = new int [N + 1][K + 1];
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=K; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = 1 + dp[i - 1][j] + dp[i - 1][j / arr[i - 1]];
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][K];
    }
}