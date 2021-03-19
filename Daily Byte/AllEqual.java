/*
Given a non-empty integer array, nums, return the minimum number of moves to make all values in nums equal. A move consists of incrementing all but one element in the array by one.

Ex: Given the following nums...

nums = [1, 2, 3], return 3. [1, 2, 3] -> [2, 3, 3] -> [3, 4, 3] -> [4, 4, 4].

*/


// Adding 1 to n - 1 elements is the same as subtracting 1 from one element, w.r.t goal of making the elements in the array equal.
class Solution {
    public int minMoves(int[] nums) {
        int length = nums.length;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int number : nums) {
            sum += number;
            min = Math.min(min, number);
        }
        return sum - length * min;
    }
}