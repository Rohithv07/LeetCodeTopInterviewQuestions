Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109


class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int number : nums) {
        //     if (!map.containsKey(number)) {
        //         int left = map.containsKey(number - 1) ? map.get(number - 1) : 0;
        //         int right = map.containsKey(number + 1) ? map.get(number + 1) : 0;
        //         int lengthSum = left + right + 1;
        //         map.put(number, lengthSum);
        //         result = Math.max(result, lengthSum);
        //         map.put(number - left, lengthSum);
        //         map.put(number + right, lengthSum);
        //     }
        // }
        // return result;
        Set<Integer> set = new HashSet<>();
        for (int number : nums) {
            set.add(number);
        }
        for (int number : nums) {
            int left = number - 1;
            int right = number + 1;
            while (set.remove(left))
                left --;
            while (set.remove(right))
                right++;
            result = Math.max(result, right - left - 1);
            if (set.isEmpty())
                return result;
        }
        return result;
    }
}
