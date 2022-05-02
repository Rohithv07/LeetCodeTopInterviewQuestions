Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.

 

Example 1:

Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 5000
0 <= nums[i] <= 5000


// approach 1
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums;
        }
        int evenCount = 0;
        for (int num : nums) {
            if (num % 2 == 0)
                evenCount++;
        }
        int evenStarting = 0;
        int oddStarting = evenCount;
        int [] result = new int [length];
        for (int num : nums) {
            if (num % 2 == 0) {
                result[evenStarting++] = num;
            }
            else {
                result[oddStarting++] = num;
            }
        }
        return result;
    }
}


// approach 2

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums;
        }
        int evenIndex = 0;
        int i = 0;
        while (i < length) {
            if (nums[i] % 2 == 0) {
                swap(nums, i, evenIndex);
                evenIndex++;
            }
            i++;
        }
        return nums;
    }
    
    private void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}