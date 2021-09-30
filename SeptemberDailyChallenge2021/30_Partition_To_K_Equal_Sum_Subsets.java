Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.

 

Example 1:

Input: nums = [4,3,2,3,5,2,1], k = 4
Output: true
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
Example 2:

Input: nums = [1,2,3,4], k = 3
Output: false
 

Constraints:

1 <= k <= nums.length <= 16
1 <= nums[i] <= 104
The frequency of each element is in the range [1, 4].


// handles both negative and positive numbers
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int totalSum = 0;
        for (int number : nums) {
            totalSum += number;
        }
        if (k <= 0 || totalSum % k != 0) {
            return false;
        }
        int length = nums.length;
        int [] visited = new int [length];
        return partition(nums, visited, k, 0, 0, 0, totalSum / k);
    }
    
    public boolean partition(int [] nums, int [] visited, int k, int startingIndex, int currentNumber, int currentSum, int target) {
        if (k == 1) {
            return true;
        }
        if (currentSum == target && currentNumber > 0) {
            return partition(nums, visited, k-1, 0, 0, 0, target);
        }
        for (int i=startingIndex; i<nums.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                if (partition(nums, visited, k, i+1, currentNumber++, currentSum + nums[i], target)) {
                    return true;
                }
                visited[i] = 0;   
            }
        }
        return false;
    }
}