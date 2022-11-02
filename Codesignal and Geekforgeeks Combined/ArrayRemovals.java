Given an array arr[] of size N and an integer K. The task is to find the minimum number of elements that should be removed, such that Amax-Amin<=K. After the removal of elements, Amax and Amin is considered among the remaining elements. 

Note: Can you solve the probelm without using any extra space and O(N*log(N)) time complexity?

Example 1:

Input: N = 9, K = 4  
arr[] = {1,3,4,9,10,11,12,17,20}
Output: 5
Explanation: Remove 1, 3, 4 from beginning
and 17, 20 from the end.
Example 2:

Input: N = 5, K = 2 
arr[] = {1, 5, 6, 2, 8} 
Output: 3
Explanation: There are multiple ways to
remove elements in this case.
One among them is to remove 5, 6, 8.
The other is to remove 1, 2, 5
Your Task:
You don't need to read input or print anything. Your task is to complete the function removals() which takes the array of integers arr, n and k as parameters and returns an integer, denotes minimum number of elements should be remove to satisfy the condition.

Expected Time Complexity: O(N^2)
Expected Auxiliary Space: O(N^2)

Constraints:
1 ≤ N ≤ 100
1 ≤ Arr[i], K ≤ 106


//User function Template for Java

class Solution {
    int removals(int[] arr, int n, int k) {
        // code here
        Arrays.sort(arr);
        int left = 0;
        int right = 0;
        int remove = 0;
        while (left <= right && right < n) {
            if (arr[right] - arr[left] > k) {
                left++;
            }
            else {
                remove = Math.max(remove, right - left + 1);
                right++;
            }
        }
        return n - remove;
    }
}