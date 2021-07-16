Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 

Constraints:

1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109



class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        Arrays.sort(nums);
        for (int i=0; i+3<length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            for (int k=j; k+2<length; k++) {
                if (k > j && nums[k] == nums[k - 1])
                    continue;
                int left = k + 1;
                int right = length - 1;
                int ourAim = target - (nums[i] + nums[k]);
                while (left < right) {
                    if (nums[left] + nums[right] == ourAim) {
                        result.add(Arrays.asList(nums[i], nums[k], nums[left], nums[right]));
                        left += 1;
                        right -= 1;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                    else if (nums[left] + nums[right] > ourAim) {
                        right --;
                    }
                    else {
                        left ++;
                    }
                }
            }
        }
        return result;
    }
}