// https://www.youtube.com/watch?v=RIn3gOkbhQE&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=11


class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        List<Integer> current = new ArrayList<>();
        backtrack(nums, result, current, 0);
        return result;
    }
    
    private void backtrack(int [] nums, List<List<Integer>> result, List<Integer> current, int index) {
        result.add(new ArrayList<>(current));
        if (index >= nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            current.add(nums[i]);
            backtrack(nums, result, current, i + 1);
            current.remove(current.size() - 1);
        }
    }
}