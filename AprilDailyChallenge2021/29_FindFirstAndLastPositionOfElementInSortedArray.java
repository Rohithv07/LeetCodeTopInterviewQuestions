Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

Follow up: Could you write an algorithm with O(log n) runtime complexity?

 

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
        int length = nums.length;
        int low = 0;
        int high = length - 1;
        int startingPosition = 0;
        int endingPosition = length - 1;
        int foundPosition = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                foundPosition = mid;
                break;
            }
            else if (nums[mid] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        if (foundPosition == -1) {
            return new int []{-1, -1};
        }
        for (int i=foundPosition; i>=0; i--) {
            if (nums[i] != target) {
                startingPosition = i + 1;
                break;
            }
        }
        for (int i=foundPosition; i<length; i++) {
            if (nums[i] != target) {
                endingPosition = i - 1;
                break;
            }
        }
        return new int [] {startingPosition, endingPosition};
        
    }
}
