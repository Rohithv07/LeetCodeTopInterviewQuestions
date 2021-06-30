/*
Given an array of sorted positive integers, nums, and a value k, return the kth missing number in nums.

Ex: Given the following nums and k…

nums = [1, 9, 13, 22], k = 4, return 5 (5 is the 4th missing number).
Ex: Given the following nums and k…

nums = [3, 4, 5], k = 2, return 2.
*/


class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (arr[middle] - (middle + 1) >= k) {
                right = middle;
            }
            else {
                left = middle + 1;
            }
        }
        return left + k;
    }
}
