Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

 

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:

Input: nums = [1,1]
Output: [2]
 

Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
 

Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        // O(n) time and space
        
        int length = nums.length;
        List<Integer> result = new ArrayList<>();
        boolean [] visited = new boolean [length + 1];
        for (int number : nums) {
            visited[number] = true;
        }
        for (int i=1; i<=length; i++) {
            if (!visited[i]) {
                result.add(i);
            }
        }
        return result;
        
        int length = nums.length;
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<length; i++) {
            int sortedIndex = Math.abs(nums[i]) - 1;
            nums[sortedIndex] = -1 * Math.abs(nums[sortedIndex]);
        }
        for (int i=0; i<length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}