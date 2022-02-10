Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107

class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> track = new HashMap<>();
        track.put(0, 1);
        int prefixSum = 0;
        int count = 0;
        for (int number : nums) {
            prefixSum += number;
            if (track.containsKey(prefixSum - k)) {
                count += track.get(prefixSum - k);
            }
            track.put(prefixSum, track.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}