Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 

Constraints:

1 <= k <= nums.length <= 104
-104 <= nums[i] <= 104



class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int correctPosition = length - k;
        return quickSelect(nums, left, right, correctPosition);
    }
    
    private int quickSelect(int [] nums, int left, int right, int k) {
        int middle = left + (right - left) / 2;
        int pivot = nums[middle];
        swap(nums, middle, right);
        int i = 0;
        int j = 0;
        while (j < right) {
            if (pivot >= nums[j]) {
                swap(nums, i, j);
                i++;
            }
            j++;
        }
        swap(nums, i, right);
        if (i == k) {
            return nums[i];
        }
        if (i < k) {
            return quickSelect(nums, i + 1, right, k);
        }
        return quickSelect(nums, left, i - 1, k);
    }
    
    private void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}