Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10


class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();
        Arrays.sort(nums); // so that we can get rid of duplicates easily
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        helper(result, current, nums, 0);
        return result;
    }
    
    public void helper(List<List<Integer>> result, List<Integer> current, int [] nums, int pos) {
        result.add(new ArrayList<>(current));
        for (int i=pos; i<nums.length; i++) {
            if (i > pos && nums[i] == nums[i - 1]) {
                continue;
            }
            current.add(nums[i]);
            System.out.println(current);
            helper(result, current, nums, i+1);
            current.remove(current.size() - 1);
        }
    }
}