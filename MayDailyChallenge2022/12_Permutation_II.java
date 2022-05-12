Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10



class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean [] used = new boolean [nums.length];
        backtrack(result, current, nums, 0, used);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> current, int [] nums, int pos, boolean [] used) {
        if (current.size() >= nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            if (used[i] || i > pos && nums[i] ==nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            current.add(nums[i]);
            backtrack(result, current, nums, 0, used);
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}