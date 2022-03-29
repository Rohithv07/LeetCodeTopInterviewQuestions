class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        while (nums[0] != nums[nums[0]]) {
            /*
            int temp = nums[0];
            nums[0] = nums[nums[0]];
            nums[0] = temp;
            */
            swap(nums, 0, nums[0]);
        }
        return nums[0];
    }
    
    public void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}