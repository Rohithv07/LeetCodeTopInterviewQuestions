Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant extra space.

 

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]
Example 2:

Input: nums = [1,1,2]
Output: [1]
Example 3:

Input: nums = [1]
Output: []
 

Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
Each element in nums appears once or twice.


class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int length = nums.length;
        boolean [] visited = new boolean [length + 1];
        for (int i=0; i<length; i++) {
            int currentNumber = nums[i];
            if (visited[currentNumber]) {
                result.add(currentNumber);
            }
            else {
                visited[currentNumber] = true;
            }
        }
        return result;
    }
}