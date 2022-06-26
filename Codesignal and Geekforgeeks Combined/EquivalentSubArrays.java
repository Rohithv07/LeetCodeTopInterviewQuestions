Given an array arr[] of n integers. Count the total number of sub-array having total distinct elements same as that of total distinct elements of the original array.

 

Example 1:

Input:
N=5
arr[] = {2, 1, 3, 2, 3} 
Output: 5
Explanation:
Total distinct elements in array is 3
Total sub-arrays that satisfy the condition
are:
Subarray from index 0 to 2
Subarray from index 0 to 3
Subarray from index 0 to 4
Subarray from index 1 to 3
Subarray from index 1 to 4

Example 2:

Input:
N=5
arr[] = {2, 4, 4, 2, 4} 
Output: 9

Your Task:
Since, this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function countDistinctSubarray() that takes array arr and integer n  as parameters and returns the desired result.

 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

 

Constraints:
1 ≤ N ≤ 104


class Solution
{ 
    // Method to calculate distinct sub-array 
    static int countDistinctSubarray(int arr[], int n) 
    { 
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : arr) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
        }
        int size = map.size();
        int left = 0;
        int right = 0;
        int sizeTracker = 0;
        while (right < n) {
            int num = arr[right];
            map.put(num, map.get(num) + 1);
            if (map.get(num) == 1) {
                sizeTracker++;
            }
            while (sizeTracker ==size && left <= right) {
                count += (n - right);
                int leftNum = arr[left];
                map.put(leftNum, map.get(leftNum) - 1);
                if (map.get(leftNum) == 0) {
                    sizeTracker--;
                }
                left++;
            }
            right++;
        }
        return count;
    }
}