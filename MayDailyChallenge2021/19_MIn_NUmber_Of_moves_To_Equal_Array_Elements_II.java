Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.

In one move, you can increment or decrement an element of the array by 1.

 

Example 1:

Input: nums = [1,2,3]
Output: 2
Explanation:
Only two moves are needed (remember each move increments or decrements one element):
[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
Example 2:

Input: nums = [1,10,2,9]
Output: 16
 

Constraints:

n == nums.length
1 <= nums.length <= 105
-109 <= nums[i] <= 109



/*
If we assume the number will be modified to some value say C and this C is the value the array have at middle, then from last element of array,  the array element > C, then we have to subtract C it and after middle element, array element < C, then we have to subtract from C
ie
nums[last] - C + nums[last - 1] - C + ….. + C - nums[mid- 1] + C - nums[mid - 2]+ …. + C - nums[0]
where C gets cancelled and we get 
nums[last] - nums[0] + nums[last - 1] - nums[1].....
this some gives the min number of moves to make array equal

*/


class Solution {
    public int minMoves2(int[] nums) {
        	int length = nums.length;
		Arrays.sort(nums);
		int low = 0;
		int high = length - 1;
		int count = 0;
		while (low < high) {
			count += nums[high] - nums[low];
			high -= 1;
			low += 1;
		}
		return count;
    }
}

