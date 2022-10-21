Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

 

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105


class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int length = nums.length;
        Map<Integer, Integer> duplicateChecker = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            int index = i;
            if (duplicateChecker.containsKey(num)) {
                int diff = i - duplicateChecker.get(num);
                if (diff <= k) {
                    return true;
                }
            }
            duplicateChecker.put(num, index);
        }
        return false;
    }
}