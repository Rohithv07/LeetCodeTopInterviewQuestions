class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        helper(result, current, nums, 0);
        return result;
    }
    public void helper(List<List<Integer>> result, List<Integer> current, int [] nums, int start) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i=start; i<nums.length; i++) {
            if (!current.contains(nums[i])) {
                current.add(nums[i]);
                helper(result, current, nums, 0);
                current.remove(current.size()-1);
            }
        }
    }
}
