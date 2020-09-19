class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        helper(result, current, nums, 0);
        return result;
    }
    public void helper(List<List<Integer>> result, List<Integer> current, int [] nums, int start) {
        result.add(new ArrayList<>(current));
        for (int i=start; i<nums.length; i++) {
            current.add(nums[i]);
            helper(result, current, nums, i+1);
            current.remove(current.size()-1);
        }
    }
}
