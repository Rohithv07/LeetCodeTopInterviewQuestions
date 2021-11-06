Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

 

Example 1:

Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.
Example 2:

Input: nums = [-1,0]
Output: [-1,0]
Example 3:

Input: nums = [0,1]
Output: [1,0]
 

Constraints:

2 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
Each integer in nums will appear twice, only two integers will appear once.


class Solution {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return new int []{};
        }
        int length = nums.length;
        int [] result = new int [2];
        Map<Integer, Integer> trackCount = new HashMap<>();
        for (int number : nums) {
            trackCount.put(number, trackCount.getOrDefault(number, 0) + 1);
        }
        int index = 0;
        for (int number : trackCount.keySet()) {
            int count = trackCount.get(number);
            if (count == 1) {
                result[index++] = number;
            }
        }
        return result;
    }
}



class Solution {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int []{};
        }
        int [] result = new int [2];
        int xor = 0;
        for (int number : nums) {
            xor ^= number;
        }
        // right most set bit
        xor &= -xor;
        for (int number : nums) {
            if ((number & xor) == 0) {
                // if not set
                result[0] ^= number;
            }
            else {
                result[1] ^= number;
            }
        }
        return result;
    }
}