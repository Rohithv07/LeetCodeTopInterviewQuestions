Given a sorted array Arr of size N and a number X, you need to find the number of occurrences of X in Arr.

Example 1:

Input:
N = 7, X = 2
Arr[] = {1, 1, 2, 2, 2, 2, 3}
Output: 4
Explanation: 2 occurs 4 times in the
given array.
Example 2:

Input:
N = 7, X = 4
Arr[] = {1, 1, 2, 2, 2, 2, 3}
Output: 0
Explanation: 4 is not present in the
given array.
Your Task:
You don't need to read input or print anything. Your task is to complete the function count() which takes the array of integers arr, n and x as parameters and returns an integer denoting the answer.

Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105
1 ≤ Arr[i] ≤ 106
1 ≤ X ≤ 106


class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        if (arr == null || n == 0)
            return 0;
        int starting = -1;
        int ending = -1;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] == x) {
                starting = middle;
                high = middle - 1;
            }
            else if (arr[middle] < x) {
                low = middle + 1;
            }
            else {
                high = middle - 1;
            }
        }
        if (starting == -1) {
            return 0;
        }
        low = 0;
        high = n - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] == x) {
                ending = middle;
                low = middle + 1;
            }
            else if (arr[middle] < x) {
                low = middle + 1;
            }
            else {
                high = middle - 1;
            }
        }
        return ending - starting + 1;
    }
}