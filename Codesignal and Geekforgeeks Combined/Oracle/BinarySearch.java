Given a sorted array of size N and an integer K, find the position at which K is present in the array using binary search.


Example 1:

Input:
N = 5
arr[] = {1 2 3 4 5} 
K = 4
Output: 3
Explanation: 4 appears at index 3.

Example 2:

Input:
N = 5
arr[] = {11 22 33 44 55} 
K = 445
Output: -1
Explanation: 445 is not present.

Your Task:  
You dont need to read input or print anything. Complete the function binarysearch() which takes arr[], N and K as input parameters and returns the index of K in the array. If K is not present in the array, return -1.


Expected Time Complexity: O(LogN)
Expected Auxiliary Space: O(LogN) if solving recursively and O(1) otherwise.


Constraints:
1 <= N <= 104
1 <= arr[i] <= 104

class Solution {
    int binarysearch(int arr[], int n, int x){
        // code here
        if (arr == null || n == 0) {
            return -1;
        }
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] == x) {
                return middle;
            }
            else if (arr[middle] > x) {
                high = middle - 1;
            }
            else {
                low = middle + 1;
            }
        }
        return -1;
        
        // for recursion
        return findPos(arr, 0, n-1, x);
    }
    
    // using recursion
    private int findPos(int [] arr, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int middle = low + (high - low) / 2;
        if (arr[middle] == target) {
            return middle;
        }
        if (arr[middle] > target) {
            return findPos(arr, low, middle - 1, target);
        }
        return findPos(arr, middle + 1, high, target);
    }
}