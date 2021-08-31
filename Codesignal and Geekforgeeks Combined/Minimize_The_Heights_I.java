Given an array arr[] denoting heights of N towers and a positive integer K, you have to modify the height of each tower either by increasing or decreasing them by K only once.
Find out what could be the possible minimum difference of the height of shortest and longest towers after you have modified each tower.
Note: Assume that height of the tower can be negative.
A slight modification of the problem can be found here. 


Example 1:

Input:
K = 2, N = 4
Arr[] = {1, 5, 8, 10}
Output:
5
Explanation:
The array can be modified as 
{3, 3, 6, 8}. The difference between 
the largest and the smallest is 8-3 = 5.
Example 2:

Input:
K = 3, N = 5
Arr[] = {3, 9, 12, 16, 20}
Output:
11
Explanation:
The array can be modified as
{6, 12, 9, 13, 17}. The difference between 
the largest and the smallest is 17-6 = 11. 

Your Task:
You don't need to read input or print anything. Your task is to complete the function getMinDiff() which takes the arr[], n and k as input parameters and returns an integer denoting the minimum difference.


Expected Time Complexity: O(N*logN)
Expected Auxiliary Space: O(N)

Constraints
1 ≤ K ≤ 104
1 ≤ N ≤ 105
1 ≤ Arr[i] ≤ 105


//User function Template for Java

class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        // code here
        if (arr == null || arr.length == 0)
            return 0;
        Arrays.sort(arr);
        int possibleAnswer = arr[n - 1] - arr[0];
        for (int i=0; i<n - 1; i++) {
            int num1 = arr[i];
            int num2 = arr[i + 1];
            int high = Math.max(arr[n - 1] - k, num1 + k);
            int low = Math.min(arr[0] + k, num2 - k);
            possibleAnswer = Math.min(possibleAnswer, high - low);
        }
        return possibleAnswer;
    }
}
