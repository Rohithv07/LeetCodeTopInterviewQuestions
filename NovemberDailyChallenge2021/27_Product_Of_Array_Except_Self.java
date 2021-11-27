Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)

// O(n) space


class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int []{};
        }
        int length = nums.length;
        int [] prefix = new int [length];
        int [] suffix = new int [length];
        int [] result = new int [length];
        prefix[0] = 1;
        suffix[length - 1] = 1;
        for (int i=1; i<length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        for (int i=length-2; i>=0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        for (int i=0; i<length; i++) {
            result[i] = prefix[i] * suffix[i];
        }
        return result;
    }
}



// O(1) space

class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int []{};
        }
        int length = nums.length;
        int [] result = new int [length];
        result[0] = 1;
        int right = 1;
        for (int i=1; i<length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        for (int i=length-1; i>=0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }
}
