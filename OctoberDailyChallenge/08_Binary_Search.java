class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1 && target == nums[0])
            return 0;
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target)
                return middle;
            else if (nums[middle] > target)
                right = middle - 1;
            else 
                left = middle + 1;
        }
        return -1;
    }
}
