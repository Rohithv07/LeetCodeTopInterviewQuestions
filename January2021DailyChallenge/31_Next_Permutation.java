Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
Example 4:

Input: nums = [1]
Output: [1]
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100




class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2)
            return;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i+1])
            i --;
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i])
                j -= 1;
            swap(nums, i, j);
        }
        reverse(nums, i+1, nums.length - 1);
    }
    
    public void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void reverse(int [] nums, int i, int j) {
        while (i < j)
            swap(nums, i++, j--);
    }
}
