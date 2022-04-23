Given a sorted array Arr[](0-index based) consisting of N distinct integers and an integer k, the task is to find the index of k, if it’s present in the array Arr[]. Otherwise, find the index where k must be inserted to keep the array sorted.


Example 1:

Input:
N = 4
Arr = {1 , 3, 5, 6}
k = 5
Output: 2
Explaination: Since 5 is found at index 2 
as arr[2] = 5, the output is 2.

Example 2:

Input:
N = 4
Arr = {1, 3, 5, 6}
k = 2
Output: 1
Explaination: Since 2 is not present in 
the array but can be inserted at index 1 
to make the array sorted.

Your Task:
You don't need to read input or print anything. Your task is to complete the function searchInsertK() which takes the array Arr[] and its size N and k as input parameters and returns the index.


Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 104
-103 ≤ Arr[i] ≤ 103
-103 ≤ k ≤ 103




//User function Template for Java

class Solution
{
    static int searchInsertK(int arr[], int n, int k)
    {
        // code here
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] == k) {
                return middle;
            }
            if (arr[middle] > k) {
                high = middle - 1;
            }
            else {
                low = middle + 1;
            }
        }
        return low;
    }
}