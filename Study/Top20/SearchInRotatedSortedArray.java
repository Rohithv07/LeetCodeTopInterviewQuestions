/*
 * There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k 
(1 <= k < nums.length) such that the resulting array is 
[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). 
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target 
if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104

4 5 6 7 0 1 2
0 1 2 3 4 5 6
l       l
        r
arr[middle] >= arr[l]:

a[l] <= target && target <= a[middle]
h = m - 1

l = m + 1

*/

import java.util.*;

public class SearchInRotatedSortedArray {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int [] nums = new int [length];
        for (int i = 0; i < length; i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(isElementFoundInRotatedArray(nums, length, target));
        sc.close();
    }

    private static int isElementFoundInRotatedArray(int [] nums, int length, int target) {
        if (nums == null || length ==0 ) {
            return -1;
        }
        if (length == 1 && nums[0] != target) {
            return -1;
        }
        if (length == 1 && nums[0] == target) {
            return 0;
        }
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] >= nums[left]) {
                if (nums[left] <= target && target <= nums[middle]) {
                    right = middle - 1;
                }
                else {
                    left = middle + 1;
                }
            }
            else {
                if (nums[middle] <= target && target <= nums[right]) {
                    left = middle + 1;
                }
                else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }
}

// TC : O(logN)
// SC : O(1)





















/*

class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;
        int low = 0;
        int high = length - 1;
        while (low <= high) 
        {
            int middle = low + (high - low) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[low] <= nums[middle]) {
                // left is sorted;
                if (nums[low] <= target && target <= nums[middle]) {
                    high = middle - 1;
                }
                else {
                    low = middle + 1;
                }
            }
            else {
                // right is sorted
                if (nums[middle] <= target && nums[high] >= target) {
                    low = middle + 1;
                }
                else {
                    high = middle - 1;
                }
            }
        }
        return -1;
    }
}
 */



 