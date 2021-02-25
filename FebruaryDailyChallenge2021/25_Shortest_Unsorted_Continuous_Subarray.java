Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.

 

Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Example 2:

Input: nums = [1,2,3,4]
Output: 0
Example 3:

Input: nums = [1]
Output: 0
 

Constraints:

1 <= nums.length <= 104
-105 <= nums[i] <= 105
 

Follow up: Can you solve it in O(n) time complexity?






class Solution {
    public int findUnsortedSubarray(int[] nums) {
       
        int length = nums.length;
        int begSort = -1;
        int endSort = -1;
        int min = nums[length - 1];
        int max = nums[0];
        for (int i=1; i<length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[length - 1 - i]);
            if (nums[i] < max)
                endSort = i;
            if (nums[length - i - 1] > min)
                begSort = length - i - 1;
        } 
        return endSort - begSort + 1 == 1 ? 0 : endSort - begSort + 1;
         
    /* 
       Wrong solution
       
       // base checks
        if (nums.length == 1)
            return 0;
        boolean getPassed = true;
        int length = nums.length;
        int leftIrregular = 0;
        int rightIrregular = 0;
        // left to right 
        for (int i=1; i<length; i++) {
            if (nums[i - 1] > nums[i]) {
                getPassed = false;
                leftIrregular = i - 1;
                break;
            }
        }
        // already sorted
        if (getPassed)
            return 0;
        
        int correctlyPassed = 0;
        for (int i=length - 1; i>0; i--) {
            if (nums[i] < nums[i - 1]) {
                rightIrregular = i;
                break;
            }
        }
        return rightIrregular - leftIrregular <= 1 ? length - 1 : rightIrregular - leftIrregular + 1;
        */
    }
}
/*
If the array nums is already sorted, then we dont want to consider any subarray, return 0
if the array length = 1, then return 0

nums = [2,6,4,8,10,9,15]
          1

so from left to right, ith number must be less than i + 1th number.
if irregularity occurs, mark the index of irregularity
same way right ot left and ith nuber > i - 1th number
if irregularity mark the index number


result = []
left to right -> 2 < 6 - true  -> [2, 0, 0, 0, 0, 0, 0]
                6 < 4 - false -> mark index of 6 say leftIrregular = 1 and break
right to left -> 15 > 9 - true  -> [2, 0, 0, 0, 0, 0, 15]
                9 > 10 - false -> mark index of 9 as rightIrregular = 5

answer =  5 - 1 + 1 = 5
so we have the subarray to be sorred and return rightIrregular - leftIrregular + 1



Another example 
[10, 1, 2, 3, 15]
from i = 1 to length:
    left to right -> 10 < 1 -> false leftIrregular = i - 1 = 0
from i = length - 1 to 0:
    right to left -> 15 > 3 -> true
                    3 > 2 -> true
                    2 > 1 -> true
                    1 > 10 -> false right irregular = 1

*/
