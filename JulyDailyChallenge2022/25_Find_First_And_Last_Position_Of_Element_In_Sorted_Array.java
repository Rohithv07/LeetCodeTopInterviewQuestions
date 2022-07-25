Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int []{-1, -1};
        }
        int leftMost = findLeftMost(nums, target);
        if (leftMost == -1) {
            return new int []{-1, -1};
        }
        int rightMost = findRightMost(nums, target);
        return new int []{leftMost, rightMost};
    }
    
    private int findLeftMost(int [] nums, int target) {
        int length = nums.length;
        int low = 0;
        int high = length - 1;
        int index = -1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (nums[middle] == target) {
                index = middle;
                high = middle - 1;
            }
            else if (nums[middle] < target){
                low = middle + 1;
            }
            else {
                high = middle - 1;
            }
        }
        return index;
    }
    
    private int findRightMost(int [] nums, int target) {
        int length = nums.length;
        int low = 0;
        int high = length - 1;
        int index = -1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (nums[middle] == target) {
                index = middle;
                low = middle + 1;
            }
            else if (nums[middle] > target){
                high = middle - 1;
            }
            else {
                low = middle + 1;
            }
        }
        return index;
    }
}