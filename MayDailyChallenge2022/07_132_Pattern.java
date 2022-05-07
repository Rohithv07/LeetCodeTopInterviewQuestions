Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

Return true if there is a 132 pattern in nums, otherwise, return false.

 

Example 1:

Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.
Example 2:

Input: nums = [3,1,4,2]
Output: true
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
Example 3:

Input: nums = [-1,3,2,0]
Output: true
Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 

Constraints:

n == nums.length
1 <= n <= 2 * 105
-109 <= nums[i] <= 109




class Solution {
    public boolean find132pattern(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int [] minimum = new int [length];
        minimum[0] = nums[0];
        for (int i = 1; i < length; i++) {
            minimum[i] = Math.min(minimum[i - 1], nums[i]);
        }
        for (int i = length - 1; i >= 0; i--) {
            int currentNum = nums[i];
            int currentMin = minimum[i];
            if (currentNum > currentMin) {
                while (!stack.isEmpty() && stack.peek() <= currentMin) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() < currentNum) {
                    return true;
                }
            }
            stack.push(currentNum);
        }
        return false;
    }
}