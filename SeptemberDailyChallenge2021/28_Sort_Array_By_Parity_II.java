Given an array of integers nums, half of the integers in nums are odd, and the other half are even.

Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.

Return any answer array that satisfies this condition.

 

Example 1:

Input: nums = [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
Example 2:

Input: nums = [2,3]
Output: [2,3]
 

Constraints:

2 <= nums.length <= 2 * 104
nums.length is even.
Half of the integers in nums are even.
0 <= nums[i] <= 1000
 

Follow Up: Could you solve it in-place?


class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int []{};
        }
        
        // using extra space
        
        int length = nums.length;
        int [] result = new int [length];
        int evenIndex = 0;
        int oddIndex = 1;
        for (int number : nums) {
            if (number % 2 == 0) {
                result[evenIndex] = number;
                evenIndex += 2;
            }
            else {
                result[oddIndex] = number;
                oddIndex += 2;
            }
        }
        return result;
        
        // in-place
        int length = nums.length;
        int evenIndex = 0;
        int oddIndex = 1;
        while (evenIndex < length && oddIndex < length) {
            while (evenIndex < length && nums[evenIndex] % 2 == 0) {
                evenIndex += 2;
            }
            while (oddIndex < length && nums[oddIndex] % 2 == 1) {
                oddIndex += 2;
            }
            if (evenIndex < length && oddIndex < length)
                swap(nums, evenIndex, oddIndex);
        }
        return nums;
    }
    
    private void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


// another way of doing a swap using xor

private void swap(int [] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }