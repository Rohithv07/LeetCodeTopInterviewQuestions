Given an array arr of n elements which is first increasing and then may be decreasing, find the maximum element in the array.
Note: If the array is increasing then just print then last element will be the maximum value.

Example 1:

Input: 
n = 9
arr[] = {1,15,25,45,42,21,17,12,11}
Output: 45
Explanation: Maximum element is 45.
Example 2:

Input: 
n = 5
arr[] = {1, 45, 47, 50, 5}
Output: 50
Explanation: Maximum element is 50.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function findMaximum() which takes the array arr[], and n as parameters and returns an integer denoting the answer.

Expected Time Complexity: O(logn)
Expected Auxiliary Space: O(1)

Constraints:
3 ≤ n ≤ 106
1 ≤ arri ≤ 106

// cpp solution O(logn) binary search method
class Solution{
public:
	
	int findMaximum(int arr[], int n) {
	    // code here
	    int left = 0;
        int right = n-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1])
                return arr[mid];
            else if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1])
                right = mid - 1;
            else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1])
                left = mid + 1;
        }
	}
};



// o(n) complexity
        
        // int max = Integer.MIN_VALUE;
        // for (int number : arr) {
        //     max = Math.max(number, max);
        // }
        // return max;




