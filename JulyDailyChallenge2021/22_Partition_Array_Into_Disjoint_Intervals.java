Given an array nums, partition it into two (contiguous) subarrays left and right so that:

Every element in left is less than or equal to every element in right.
left and right are non-empty.
left has the smallest possible size.
Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.

 

Example 1:

Input: nums = [5,0,3,8,6]
Output: 3
Explanation: left = [5,0,3], right = [8,6]
Example 2:

Input: nums = [1,1,1,0,6,12]
Output: 4
Explanation: left = [1,1,1,0], right = [6,12]
 

Note:

2 <= nums.length <= 30000
0 <= nums[i] <= 106
It is guaranteed there is at least one way to partition nums as described.


class Solution {
    public int partitionDisjoint(int[] nums) {
       //  Using extra space
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 2)
            return 1;
        int count = 0;
        int length = nums.length;
        int [] leftArray = new int [length]; // stores max from left to right
        int [] rightArray = new int [length]; // stores min from right to left
        int value = nums[0];
        for (int i=0; i<length; i++) {
            value = Math.max(value, nums[i]);
            leftArray[i] = value;
        }
        value = nums[length - 1];
        for (int i=length - 1 ; i >= 0; i--) {
            value = Math.min(value, nums[i]);
            rightArray[i] = value;
        }
        for (int i=1; i<length; i++) {
            int left = leftArray[i - 1];
            int right = rightArray[i];
            if (left <= right)
                return i;
        }
        return -1;
        
        // constant space
        if (nums == null || nums.length == 0)
            return 0;
        int currentMax = nums[0];
        int allTimeMax = nums[0];
        int count = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] < currentMax) {
                currentMax = allTimeMax;
                count = i + 1;
            }
            else {
                allTimeMax = Math.max(allTimeMax, nums[i]);
            }
        }
        return count;
    }
}